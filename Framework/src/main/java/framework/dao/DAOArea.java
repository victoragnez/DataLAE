package framework.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArea;
import framework.model.Area;
import framework.model.MarcadoresDAO.CompInserir;
import framework.model.MarcadoresDAO.RecuperaResultado;

public abstract class DAOArea<A extends Area> implements IDAOArea<A> {
	private final Class<A> classe;
	
	public DAOArea(Class<A> classe) {
		this.classe = classe;
	}
	
	public void inserir(A a) throws DatabaseException {
		ArrayList<String> campos = new ArrayList<String>();
		
		if(a.getCodigo() != null)
				campos.add("codigoArea=" + a.getCodigo());
		
		if(a.getNome() != null && a.getNome().length() != 0)
			campos.add("nome='" + a.getNome()+"'");
		
		String sql = "insert into Area set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		
		sql = complemento(CompInserir.class, sql, a);
		
		sql += ";";
		
		int id;
		try {
			id = JDBC.runInsert(sql);
		}catch(SQLException e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
		
		if(id == -1) {
			id = a.getCodigo();
		} else {
			a.setCodigo(id);
		}
	}
	
	@Override
	public void remover(A a) throws DatabaseException
	{}
	
	@Override
	public void atualizar(A a) throws DatabaseException
	{}
	
	@Override
	public List<A> consultar(A a) throws DatabaseException
	{return null;}
	
	@Override
	public List<A> listar() throws DatabaseException {
		String sql = "select *, st_x(coordenadas) as latitude, st_y(coordenadas) as longitude from Area;";
		
		try {
			return getFromResult(JDBC.runQuery(sql));
		}catch (Exception e) {
			throw new DatabaseException("Não foi possível realizar a operação solicitada");
		}
	}
	
	private ArrayList<A> getFromResult(ResultSet resultSet) throws DatabaseException {
		ArrayList<A> retorno = new ArrayList<A>();

		try {
			while(resultSet.next()) {
				
				Integer codigo;
				String nome;
				
				codigo = (Integer)resultSet.getObject("codigoArea");
				nome = resultSet.getString("nome");
				
				A a = recuperaResultado(resultSet);
				
				a.setCodigo(codigo);
				a.setNome(nome);
				
				retorno.add(a);
				
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		return retorno;
	}
	
	private String complemento(Class<? extends Annotation> annotation, String sql, A a) 	{
		Class<?> curClass = this.getClass();
		
		while (curClass != DAOArea.class) {
			List<Method> allMethods = new ArrayList<Method>(Arrays.asList(curClass.getDeclaredMethods()));       
			for (Method method : allMethods) {
				if (method.isAnnotationPresent(annotation)) {
					try {
						sql = (String) method.invoke(this, sql, a);
					} catch (IllegalAccessException | IllegalArgumentException e) {
						e.printStackTrace();
					}
					catch (InvocationTargetException e) {
						throw new IllegalArgumentException(e.getMessage());
					}
				}
			}
			curClass = curClass.getSuperclass();
		}
		return sql;
	}
	
	private A recuperaResultado(ResultSet resultSet) throws DatabaseException {
		Class<?> curClass = this.getClass();
		
		A a;
		
		try {
			a = classe.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException 
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new DatabaseException(e);
		}
		
		while (curClass != DAOArea.class) {
			List<Method> allMethods = new ArrayList<Method>(Arrays.asList(curClass.getDeclaredMethods()));       
			for (Method method : allMethods) {
				if (method.isAnnotationPresent(RecuperaResultado.class)) {
					try {
						classe.cast(method.invoke(this, resultSet, a));
					}
					catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
						throw new DatabaseException(e);
					}
				}
			}
			curClass = curClass.getSuperclass();
		}
		return a;
	}
	
}
