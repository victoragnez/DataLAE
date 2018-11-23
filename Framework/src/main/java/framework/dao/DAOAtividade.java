package framework.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOAtividade;
import framework.model.Atividade;

public abstract class DAOAtividade<A extends Atividade> implements IDAOAtividade<A> {

	private final Class<A> classe;
	
	public DAOAtividade(Class<A> classe) {
		this.classe = classe;
	}
	
	@Override
	public void inserir(A a) throws DatabaseException {
		String sql = "insert into Pratica set ";
		ArrayList<String> campos = new ArrayList<String>();
		
		if(a.getDataInicio() != null)
			campos.add("dataInicio='" + a.getDataInicio().toString() + "'");
		
		if(a.getDataTermino() != null)
			campos.add("dataTermino='" + a.getDataTermino().toString() + "'");
		
		if(a.getProjeto() != null )
		{
			if (a.getProjeto().getCodigo() != null)
				campos.add("codigoProjeto=" + a.getProjeto().getCodigo());
		}
		
		if(a.getArea() != null)
		{
			if (a.getProjeto().getCodigo() != null)
				campos.add("codigoArea=" + a.getArea().getCodigo());
		}
		
		//chamar parte flexível
		campos = compInserir(campos, a);
		
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
				
	}

	@Override
	public void remover(A a) throws DatabaseException {
		String sql = "delete from Pratica where codigoPratica=" + a.getCodigo() + ";";
		System.out.println(sql);
		try {
			JDBC.runRemove(sql);
		}catch(Exception e)
		{
			throw new DatabaseException("Impossível remover o projeto informado");
		}
	}

	@Override
	public void atualizar(A a) throws DatabaseException {
		String sql = "update Pratica set ";
		ArrayList<String> campos = new ArrayList<String>();
		
		if(a.getDataInicio() != null)
			campos.add("dataInicio='" + a.getDataInicio().toString() + "'");
		
		if(a.getDataTermino() != null)
			campos.add("dataTermino='" + a.getDataTermino().toString() + "'");
		
		if(a.getProjeto() != null )
		{
			if (a.getProjeto().getCodigo() != null)
				campos.add("codigoProjeto=" + a.getProjeto().getCodigo());
		}
		
		if(a.getArea() != null)
		{
			if (a.getProjeto().getCodigo() != null)
				campos.add("codigoArea=" + a.getArea().getCodigo());
		}
			
		//chamar parte flexível
		campos = compAtualizar(campos, a);
		
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		
		sql += " where codigoProjeto=" + a.getCodigo() + ";";
		System.out.println(sql);
		try {
			JDBC.runUpdate(sql);
		}catch(Exception e) {
			throw new DatabaseException("Não foi possível atualizar o projeto");
		}

	}

	@Override
	public List<A> consultar(A a) throws DatabaseException {
		String sql = "select * from Pratica ";
		
		ArrayList<String> cond = new ArrayList<String>();
		
		if(a.getCodigo() != null) {
			cond.add("codigoPratica = " + a.getCodigo());
		}
		
		if(a.getDataInicio() != null && a.getDataTermino() != null) {
			cond.add("dataInicio >= '" + a.getDataInicio().toString() + "'");
			cond.add("(dataTermino is null or (dataTermino >= '" + 
					a.getDataInicio().toString() + "' and dataTermino <='" 
					+ a.getDataTermino().toString() + "'))");
		}
		else if (a.getDataInicio() != null) {
			cond.add("dataInicio >= '" + a.getDataInicio().toString() + "'");
		}
		
		if(a.getProjeto() != null )
		{
			if (a.getProjeto().getCodigo() != null)
				cond.add("codigoProjeto=" + a.getProjeto().getCodigo());
		}
		
		if(a.getArea() != null)
		{
			if (a.getProjeto().getCodigo() != null)
				cond.add("codigoArea=" + a.getArea().getCodigo());
		}
			
		cond = compConsultar(cond, a);
		
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
		System.out.println(sql);
		try {
			return getFromResult(JDBC.runQuery(sql));
		}catch (Exception e) {
			throw new DatabaseException("Erro durante a consulta");
		}
	}

	@Override
	public List<A> listar() throws DatabaseException {
		String sql = "select * from Pratica;";
		System.out.println(sql);
		try {
			return getFromResult(JDBC.runQuery(sql));
		}catch (SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}
	
	private ArrayList<A> getFromResult(ResultSet resultSet) throws DatabaseException {
		ArrayList<A> retorno = new ArrayList<A>();

		try {
			while(resultSet.next()) {
				
				Integer codigo = (Integer)resultSet.getObject("codigoPratica");
				Date inicio = resultSet.getDate("dataInicio");
				Date termino = resultSet.getDate("dataTermino");
				A a;
				
				try {
					a = classe.getDeclaredConstructor().newInstance();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					throw new DatabaseException(e);
				}
				
				getProjectWithFlexibleAttributes(resultSet, a);
				
				a.setCodigo(codigo);
				a.setDataInicio(inicio);
				a.setDataTermino(termino);
				
				retorno.add(a);
				
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		return retorno;
	}
	
	/** Metodos que devem ser implementados*/
	
	protected abstract ArrayList<String> compInserir(ArrayList<String> sql, A a);
	protected abstract ArrayList<String> compRemover(ArrayList<String> sql, A a);
	protected abstract ArrayList<String> compAtualizar(ArrayList<String> sql, A a);
	protected abstract ArrayList<String> compConsultar(ArrayList<String> sql, A a);
	
	protected abstract void getProjectWithFlexibleAttributes(ResultSet resultSet, A p) throws SQLException;
}
