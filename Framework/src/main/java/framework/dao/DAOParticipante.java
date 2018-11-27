package framework.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOParticipante;
import framework.model.Participante;

public abstract class DAOParticipante<P extends Participante> implements IDAOParticipante<P> {

	private final Class<P> classe;
	
	public DAOParticipante(Class<P> classe) {
		this.classe = classe;
	}

	@Override
	public void inserir(P p) throws DatabaseException {
		ArrayList<String> campos = new ArrayList<>();
		
		if(p.getCodigo() != null)
			campos.add("codigoParticipante='" + p.getCodigo() + "'");
		if(p.getNome() != null && !p.getNome().isEmpty())
			campos.add("nome='" + p.getNome() + "'");
		if(p.getEmail() != null && !p.getEmail().isEmpty())
			campos.add("email='" + p.getEmail() + "'");
		if(p.getInstituicao() != null && !p.getInstituicao().isEmpty())
			campos.add("instituicao='" + p.getInstituicao() + "'");
		
		//Flexible part
		campos = compInserir(campos, p);
		
		String sql = "insert into Participante set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		
		sql += ";";
		
		try {
			JDBC.runInsert(sql);
		} catch (SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}
	
	@Override
	public void remover(P p) throws DatabaseException {
		String sql = "delete from Participante where codigoParticipante="+ p.getCodigo() + ";";
		try {
			JDBC.runRemove(sql);
		} catch(Exception e)	{
			throw new DatabaseException("Impossível remover o participante informado!");
		}
	}
	
	@Override
	public void atualizar(P p) throws DatabaseException {
		String sql = "update Participante set ";
		ArrayList<String> campos = new ArrayList<String>();
			
		if(p.getNome() != null && !p.getNome().isEmpty())
			campos.add("nome='" + p.getNome() +"'");
		if(p.getEmail() != null && !p.getEmail().isEmpty())
			campos.add("email='" + p.getEmail() + "'");
		if(p.getInstituicao() != null && !p.getInstituicao().isEmpty())
			campos.add("instituicao='" + p.getInstituicao() + "'");
		
		campos = compAtualizar(campos, p);
		
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		
		sql += " where codigoParticipante=" + p.getCodigo() + ";";
		try {
			JDBC.runUpdate(sql);
		} catch(Exception e) {
			throw new DatabaseException("Não foi possível atualizar o participante");
		}
	}
	
	@Override
	public List<P> consultar(P p) throws DatabaseException
	{
		String sql = "select * from Participante ";
		
		ArrayList<String> campos = new ArrayList<String>();
		if(p.getCodigo() != null)
			campos.add("codigoParticipante=" + p.getCodigo());
		
		if(p.getNome() != null)
			campos.add("nome like '%" + p.getNome() + "%'");
		
		if(p.getEmail() != null)
			campos.add("email like '%" + p.getEmail() + "%'");
		
		if(p.getInstituicao() != null)
			campos.add("instituicao like '%" + p.getInstituicao() + "%'");
		
		campos = compConsultar(campos, p);
		
		if (!campos.isEmpty())
		{
			sql += "where";
			for(int i = 0; i < campos.size(); i++) {
				sql += " " + campos.get(i);
				if(i + 1 < campos.size())
					sql += " and";
			}	
		}
		sql += ";";
		
		try {
			return getFromResult(JDBC.runQuery(sql));
		} catch (SQLException | DatabaseException e) {
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
		String sql = "select * from Participante;";
		
		try {
			return getFromResult(JDBC.runQuery(sql));
		}
		catch (SQLException | DatabaseException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}
	
	private List<P> getFromResult(ResultSet resultSet) throws DatabaseException {
		ArrayList<P> retorno = new ArrayList<P>();
		
		try {
			while(resultSet.next()) {
				Integer codigo = (Integer)resultSet.getObject("codigoParticipante");
				String nome = resultSet.getString("nome");
				String email = resultSet.getString("email");
				String instituicao = resultSet.getString("instituicao");
				
				P p;
				
				try {
					p = classe.getDeclaredConstructor().newInstance();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					throw new DatabaseException(e);
				}
				
				getParticipanteWithFlexibleAttributes(resultSet, p);
				
				p.setCodigo(codigo);
				p.setNome(nome);
				p.setEmail(email);
				p.setInstituicao(instituicao);
				
				retorno.add(p);
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		return retorno;
	}

	/** Metodos que devem ser implementados*/
	
	protected abstract ArrayList<String> compInserir(ArrayList<String> campos, P p);
	protected abstract String compRemover(String sql, P p);
	protected abstract ArrayList<String> compAtualizar(ArrayList<String> campos, P p);
	protected abstract ArrayList<String> compConsultar(ArrayList<String> campos, P p);
	protected abstract void getParticipanteWithFlexibleAttributes(ResultSet resultSet, P p) throws SQLException;
	
}
