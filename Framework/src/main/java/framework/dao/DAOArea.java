package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArea;
import framework.model.Area;

public abstract class DAOArea<A extends Area> implements IDAOArea<A> {

	public DAOArea() {}
	
	public void inserir(A a) throws DatabaseException
	{}
	
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
	public List<A> listar() throws DatabaseException
	{return null;}
	
	/** Metodos que devem ser implementados*/
	
	protected abstract String compInserir(String comando);
	protected abstract String compRemover(String comando);
	protected abstract String compAtualizar(String comando);
	protected abstract String compConsultar(String comando);
}
