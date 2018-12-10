package framework.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.IDAOAtividade;
import framework.model.Area;
import framework.model.DatabaseException;
import framework.model.Participante;
import framework.model.Pratica;
import framework.model.Projeto;

public abstract class DAOAtividade<
		A extends Area, 
		Proj extends Projeto<Part>,
		Prat extends Pratica<A,Part,Proj>,
		Part extends Participante> 
			implements IDAOAtividade<A, Proj, Prat, Part>
	{

	private final Class<Prat> pratClass;
	private final Class<Proj> projClass;
	private final Class<A> areaClass;
	private final Class<Part> partClass;
	
	
	public DAOAtividade(Class<A> areaClass, Class<Proj> projClass, Class<Prat> pratClass, Class<Part> partClass) {
		this.areaClass = areaClass;
		this.projClass = projClass;
		this.pratClass = pratClass;
		this.partClass = partClass;
	}
	
	@Override
	public void inserir(Prat prat) throws DatabaseException {
		String sql = "insert into Pratica set ";
		ArrayList<String> campos = new ArrayList<String>();
		
		if(prat.getDataInicio() != null)
			campos.add("dataInicio='" + prat.getDataInicio().toString() + "'");
		
		if(prat.getDataTermino() != null)
			campos.add("dataTermino='" + prat.getDataTermino().toString() + "'");
		
		if(prat.getProjeto() != null && prat.getProjeto().getCodigo() != null)
				campos.add("codigoProjeto=" + prat.getProjeto().getCodigo());
				
		if(prat.getArea() != null && prat.getArea().getCodigo() != null)
			campos.add("codigoArea=" + prat.getArea().getCodigo());

		//chamar parte flexível
		campos = compInserir(campos, prat);
		
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		
		sql += ";";
		int id;
		
		try {
			id = JDBC.runInsert(sql);
		} catch (SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
		
		if(prat.getCodigo() == null) {
			prat.setCodigo(id);
		}
		
		if(prat.getParticipantes() != null) {
			try {
				ArrayList<String> commands = new ArrayList<String>();
				
				for(Participante pesq : prat.getParticipantes()) {
					campos = new ArrayList<String>();
					campos.add("codigoPratica=" + prat.getCodigo());
					campos.add("codigoParticipante=" + pesq.getCodigo());
					
					sql = "insert into ParticipantePratica set ";
					for(int i = 0; i < campos.size(); i++) {
						sql += campos.get(i);
						if(i+1 < campos.size())
							sql += ", ";
					}
					sql += ";";
					commands.add(sql);
				}
				
				if(commands.size() > 0) {
					JDBC.runMultipleInserts(commands);
				}
			} catch(SQLException e) {
				try {
					JDBC.runRemove("delete from Pratica where codigoPratica=" + prat.getCodigo() + ";");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				throw new DatabaseException(e);
			}
		}
		
	}

	@Override
	public void remover(Prat prat) throws DatabaseException {
		String sql = "delete from Pratica where codigoPratica=" + prat.getCodigo() + ";";
		System.out.println(sql);
		try {
			JDBC.runRemove(sql);
		} catch(Exception e) {
			throw new DatabaseException("Impossível remover o projeto informado");
		}
	}

	@Override
	public void atualizar(Prat prat) throws DatabaseException {
		String sql = "update Pratica set ";
		ArrayList<String> campos = new ArrayList<String>();
		
		if(prat.getDataInicio() != null)
			campos.add("dataInicio='" + prat.getDataInicio().toString() + "'");
		
		if(prat.getDataTermino() != null)
			campos.add("dataTermino='" + prat.getDataTermino().toString() + "'");
		
		if(prat.getProjeto() != null && prat.getProjeto().getCodigo() != null)
			campos.add("codigoProjeto=" + prat.getProjeto().getCodigo());
			
		if(prat.getArea() != null && prat.getArea().getCodigo() != null)
			campos.add("codigoArea=" + prat.getArea().getCodigo());
			
		campos = compAtualizar(campos, prat);
		
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		
		sql += " where codigoPratica=" + prat.getCodigo() + ";";

		try {
			JDBC.runUpdate(sql);
		} catch(Exception e) {
			throw new DatabaseException("Não foi possível atualizar o projeto");
		}
		
		try {
			JDBC.runRemove("delete from ParticipantePratica where codigoPratica=" +
					prat.getCodigo() + ";");
			
			if(prat.getParticipantes() != null) {
					
					ArrayList<String> commands = new ArrayList<String>();
					
					for(Participante pesq : prat.getParticipantes()) {
						campos = new ArrayList<String>();
						campos.add("codigoPratica=" + prat.getCodigo());
						campos.add("codigoParticipante=" + pesq.getCodigo());
						
						sql = "insert into ParticipantePratica set ";
						for(int i = 0; i < campos.size(); i++) {
							sql += campos.get(i);
							if(i+1 < campos.size())
								sql += ", ";
						}
						sql += ";";
						System.out.println(sql);
						commands.add(sql);
					}
					
					if(commands.size() > 0) {
						JDBC.runMultipleInserts(commands);
					}
				}else System.out.println("A lista de participante veio vazia");
			} 
		catch(SQLException e) {
			try {
				JDBC.runRemove("delete from ParticipantePratica where codigoPratica=" +
						prat.getCodigo() + ";");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DatabaseException(e);
		}
	}

	@Override
	public List<Prat> consultar(Prat prat) throws DatabaseException {
		String sql = "select * from Pratica ";
		
		ArrayList<String> cond = new ArrayList<String>();
		
		if(prat.getCodigo() != null) {
			cond.add("codigoPratica = " + prat.getCodigo());
		}
		
		if(prat.getDataInicio() != null) {
			cond.add("dataInicio <= '" + prat.getDataInicio().toString() + "'");
			cond.add("(dataTermino is null or dataTermino >= '" + 
					prat.getDataInicio().toString() + "')");
		}
		
		else if (prat.getDataInicio() != null) {
			cond.add("dataInicio >= '" + prat.getDataInicio().toString() + "'");
		}

		if(prat.getProjeto() != null && prat.getProjeto().getCodigo() != null)
			cond.add("codigoProjeto=" + prat.getProjeto().getCodigo());

		if(prat.getArea() != null && prat.getArea().getCodigo() != null)
			cond.add("codigoArea=" + prat.getArea().getCodigo());
					
		
		cond = compConsultar(cond, prat);
		if (!cond.isEmpty()) {
			sql += "where ";
			for(int i = 0; i < cond.size(); i++) {
				sql += " " + cond.get(i);
				if(i + 1 < cond.size())
					sql += " and";
			}
		}
	
		sql += ";";
		try {
			return getFromResult(JDBC.runQuery(sql));
		} catch (Exception e) {
			throw new DatabaseException("Erro durante a consulta");
		}
	}
	
	@Override
	public Prat consultar(Integer codigoPratica) throws DatabaseException {
		String sql = "select * from Pratica where codigoPratica=";
		
		if (codigoPratica == null)
			throw new IllegalArgumentException("Código de prática precisa ser fornecido");
		
		sql += codigoPratica + ";";
		try {
			return getFromResult(JDBC.runQuery(sql)).get(0);
		} catch (SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}

	@Override
	public List<Prat> listar() throws DatabaseException {
		String sql = "select * from Pratica;";
		System.out.println(sql);
		try {
			return getFromResult(JDBC.runQuery(sql));
		} catch (SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}
	
	private ArrayList<Prat> getFromResult(ResultSet resultSet) throws DatabaseException {
		ArrayList<Prat> retorno = new ArrayList<>();

		try {
			while(resultSet.next()) {
				
				Integer codigo = (Integer)resultSet.getObject("codigoPratica");
				Date inicio = resultSet.getDate("dataInicio");
				Date termino = resultSet.getDate("dataTermino");
				Integer codigoProjeto = (Integer)resultSet.getObject("codigoProjeto");
				Integer codigoArea = (Integer)resultSet.getObject("codigoArea");
				
				Prat prat;
				
				try {
					prat = pratClass.getDeclaredConstructor().newInstance();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					throw new DatabaseException(e);
				}
				
				
			
				getProjectWithFlexibleAttributes(resultSet, prat);
				
				prat.setCodigo(codigo);
				prat.setDataInicio(inicio);
				prat.setDataTermino(termino);
				
				if(codigoProjeto != null) {
					try {
						prat.setProjeto(projClass.getDeclaredConstructor().newInstance());
						prat.getProjeto().setCodigo(codigoProjeto);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException e) {
						throw new DatabaseException(e);
					}
				}
				
				if(codigoArea != null) {
					try {
						prat.setArea(areaClass.getDeclaredConstructor().newInstance());
						prat.getArea().setCodigo(codigoArea);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException e) {
						throw new DatabaseException(e);
					}
				}
				/**
				 * Resgatar todos os participantes de um projeto.
				 * Aqui é necessário verificar a tabela ParticipanteProjeto
				 * do banco.
				 */
				String sqlPart = "select * from ParticipantePratica where codigoPratica=" + codigo + ";";
				System.out.println(sqlPart);
				ArrayList<Integer> codParticipantes = new ArrayList<Integer>();
				try {
					ResultSet partProj = JDBC.runQuery(sqlPart);
					
					/**
					 * Nesse passo resgatamos todos os códigos de Participantes
					 * que fazem parte da Pratica em questão.
					 */
					while(partProj.next())
						codParticipantes.add((Integer)partProj.getObject("codigoParticipante"));
				
				} catch (Exception e) {
					throw new DatabaseException("Erro durante a consulta - "
							+ "Tentativa falha de resgatar Participantes da Prática "+ codigo); 
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
				
				prat.setParticipantes(participantes);		
				retorno.add(prat);
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		return retorno;
	}
	
	/** Metodos que devem ser implementados*/
	protected abstract ArrayList<String> compInserir(ArrayList<String> sql, Prat a);
	protected abstract ArrayList<String> compAtualizar(ArrayList<String> sql, Prat a);
	protected abstract ArrayList<String> compConsultar(ArrayList<String> sql, Prat a);
	protected abstract void getProjectWithFlexibleAttributes(ResultSet resultSet, Prat p) throws SQLException;
}
	