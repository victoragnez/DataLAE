package framework.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Participante;
import framework.model.Projeto;

public abstract class DAOProjeto<P extends Projeto<Part>, Part extends Participante> 
	implements IDAOProjeto<P,Part> 
{
	
	private final Class<P> classe;
	private final Class<Part> partClass;
	
	public DAOProjeto(Class<P> classe, Class<Part> partClass) {
		this.classe = classe;
		this.partClass = partClass;
	}
	
	@Override
	public void inserir(P p) throws DatabaseException
	{

		ArrayList<String> campos = new ArrayList<String>();
		
		if(p.getCodigo() != null)
			campos.add("codigoProjeto=" + p.getCodigo());
		
		if(p.getNome() != null && p.getNome().length() != 0)
			campos.add("nome='" + p.getNome()+"'");
		
		if(p.getDataInicio() != null)
			campos.add("dataInicio='" + p.getDataInicio().toString() + "'");
		
		if(p.getDataFim() != null)
			campos.add("dataTermino='" + p.getDataFim().toString() + "'");
		
		//Flexible part
		campos = compInserir(campos, p);
				
		String sql = "insert into Projeto set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
	
		
		sql += ";";
		System.out.println(sql);
		int id;
		try {
			id = JDBC.runInsert(sql);
		}catch (SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
		
		if(id == -1) {
			id = p.getCodigo();
		} else {
			p.setCodigo(id);
		}
		
		try {
			ArrayList<String> commands = new ArrayList<String>();
			
			p.setCodigo(id);
			if(p.getParticipantes() != null) {
				for(Participante pesq : p.getParticipantes()) {
					campos = new ArrayList<String>();
					campos.add("codigoProjeto=" + p.getCodigo());
					campos.add("codigoParticipante=" + pesq.getCodigo());
					
					sql = "insert into ParticipanteProjeto set ";
					for(int i = 0; i < campos.size(); i++) {
						sql += campos.get(i);
						if(i+1 < campos.size())
							sql += ", ";
					}
					sql += ";";
					commands.add(sql);
				}
			}
			
			if(commands.size() > 0) {
				JDBC.runMultipleInserts(commands);
			}
		}
		catch(SQLException e) {
			try {
				JDBC.runRemove("delete from Projeto where codigoProjeto=" + p.getCodigo() + ";");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DatabaseException(e);
		}
		
	}
	
	@Override
	public void remover(P p) throws DatabaseException
	{
		
		String sql = "delete from Projeto where codigoProjeto= " + p.getCodigo() + ";";
		try {
			JDBC.runRemove(sql);
		}catch(Exception e)
		{
			throw new DatabaseException("Impossível remover o projeto informado");
		}
	}
	
	@Override
	public void atualizar(P p) throws DatabaseException
	{
		String sql = "update Projeto set ";
		ArrayList<String> campos = new ArrayList<String>();
		
		if(p.getNome() != null && p.getNome().length() != 0)
			campos.add("nome='" + p.getNome()+"'");
		
		if(p.getDataInicio() != null)
			campos.add("dataInicio='" + p.getDataInicio().toString() + "'");
		
		if(p.getDataFim() != null)
			campos.add("dataTermino='" + p.getDataFim().toString() + "'");
			 
		//chamar parte flexível
		campos = compAtualizar(campos, p);
		
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		
		sql += " where codigoProjeto=" + p.getCodigo() + ";";
		System.out.println("Atualizar: " + sql);
		try {
			JDBC.runUpdate(sql);
		}catch(Exception e) {
			throw new DatabaseException("Não foi possível atualizar o projeto");
		}
		
		/**
		 * Verificar se foram passados participantes.
		 * A metodologia aqui é apagar todos os participantes do projeto
		 * e inserir os novos passados. Cabe a GUI mandar de voltar os 
		 * participantes que foram passados pelo DAO no momento da 
		 * listangem.
		 */
		String sqlDelete = "delete from ParticipanteProjeto where codigoProjeto="+p.getCodigo()+";";
		System.out.println(sqlDelete);
		try {
			JDBC.runRemove(sqlDelete);
		}catch(Exception e) {
			throw new DatabaseException("Não foi atualizar participantes do projeto");
		}
		
		if (p.getParticipantes() != null) {
			
			// Agora inserimos a nova lista de participantes
			try {
				ArrayList<String> commands = new ArrayList<String>();
				
				if(p.getParticipantes() != null) {
					for(Participante pesq : p.getParticipantes()) {
						campos = new ArrayList<String>();
						campos.add("codigoProjeto=" + p.getCodigo());
						campos.add("codigoParticipante=" + pesq.getCodigo());
						
						sql = "insert into ParticipanteProjeto set ";
						for(int i = 0; i < campos.size(); i++) {
							sql += campos.get(i);
							if(i+1 < campos.size())
								sql += ", ";
						}
						sql += ";";
						commands.add(sql);
					}
				}
				
				if(commands.size() > 0) {
					System.out.println("inserção multipla");
					JDBC.runMultipleInserts(commands);
				}
			}
			catch(SQLException e) {
				try {
					JDBC.runRemove("delete from Projeto where codigoProjeto=" + p.getCodigo() + ";");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				throw new DatabaseException(e);
			}
		}else System.out.println("lista de partticipantes vazia");
		
	}
	
	@Override
	public List<P> consultar(P pj) throws DatabaseException
	{
		String sql = "select * from Projeto ";
		
		ArrayList<String> cond = new ArrayList<String>();
		
		if(pj.getCodigo() != null) {
			cond.add("codigoProjeto = " + pj.getCodigo());
		}
		
		if(pj.getDataInicio() != null) {
			cond.add("dataInicio <= '" + pj.getDataInicio().toString() + "'");
			cond.add("(dataTermino is null or dataTermino >= '" + 
					pj.getDataInicio().toString() + "')");
		}
		
		if (pj.getNome() != null) {
			cond.add("nome like '%" + pj.getNome() + "%'");
		}
		
		cond = compConsultar(cond, pj);
		
		if (!cond.isEmpty())
		{
			sql += "where ";
			for(int i = 0; i < cond.size(); i++) {
				sql += " " + cond.get(i);
				if(i + 1 < cond.size())
					sql += " and";
			}
			
		}
	
		sql += ";";
		System.out.println("Consultar: " + sql);
		try {
			return getFromResult(JDBC.runQuery(sql));
		} catch (Exception e) {
			throw new DatabaseException("Erro durante a consulta");
		}
		
	}
	
	@Override
	public P consultar(Integer codigo) throws DatabaseException {
		P p;
		try {
			p = classe.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new DatabaseException(e);
		}
		
		p.setCodigo(codigo);
		
		List<P> ps = this.consultar(p);
		
		if(ps == null || ps.size() != 1)
			throw new DatabaseException("Objeto não existe");
		else
			return ps.get(0); 
	}
	
	@Override
	public List<P> listar() throws DatabaseException
	{
		String sql = "select * from Projeto;";
		
		try {
			return getFromResult(JDBC.runQuery(sql));
		}catch (SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
		
	}

	private ArrayList<P> getFromResult(ResultSet resultSet) throws DatabaseException {
		ArrayList<P> retorno = new ArrayList<P>();

		try {
			while(resultSet.next()) {
				
				Integer codigo = (Integer)resultSet.getObject("codigoProjeto");
				String nome = resultSet.getString("nome");
				Date inicio = resultSet.getDate("dataInicio");
				Date termino = resultSet.getDate("dataTermino");
				
				P p;
				
				try {
					p = classe.getDeclaredConstructor().newInstance();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					throw new DatabaseException(e);
				}
				
				getProjectWithFlexibleAttributes(resultSet, p);
				
				p.setCodigo(codigo);
				p.setNome(nome);
				p.setDataInicio(inicio);
				p.setDataFim(termino);
				
				/**
				 * Resgatar todos os participantes de um projeto.
				 * Aqui é necessário verificar a tabela ParticipanteProjeto
				 * do banco.
				 */
				String sqlPart = "select * from ParticipanteProjeto where codigoProjeto=" + codigo + ";";
				ArrayList<Integer> codParticipantes = new ArrayList<Integer>();
				try {
					ResultSet partProj = JDBC.runQuery(sqlPart);
					
					/**
					 * Nesse passo resgatamos todos os códigos de Participantes
					 * que fazem parte do projeto em questão.
					 */
					while(partProj.next())
						codParticipantes.add((Integer)partProj.getObject("codigoParticipante"));
				
				} catch (Exception e) {
					throw new DatabaseException("Erro durante a consulta - "
							+ "Tentativa falha de resgatar Participantes do Projeto "+ codigo); 
				}
				
				/**
				 * Agora criamos os objetos participantes e inserimos no 
				 * projeto que está sendo construído
				 */
				ArrayList<Part> participantes = new ArrayList<Part>();
				for (Integer cod : codParticipantes)
				{
					if(cod != null) {
						try {
							Part newPart = partClass.getDeclaredConstructor().newInstance();
							newPart.setCodigo(cod);
							participantes.add(newPart);
						} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
								| InvocationTargetException | NoSuchMethodException | SecurityException e) {
							throw new DatabaseException(e);
						}
					}
				}
				
				p.setParticipantes(participantes);
				retorno.add(p);
				
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		return retorno;
	}
	
	/** Metodos que devem ser implementados*/
	
	protected abstract ArrayList<String> compInserir(ArrayList<String> campos, P p);
	protected abstract ArrayList<String> compRemover(ArrayList<String> campos, P p);
	protected abstract ArrayList<String> compAtualizar(ArrayList<String> campos, P p);
	protected abstract ArrayList<String> compConsultar(ArrayList<String> campos, P p);

	protected abstract void getProjectWithFlexibleAttributes(ResultSet resultSet, P p) throws SQLException;

}
