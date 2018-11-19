package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArea;
import framework.model.Area;
import framework.service.interfaces.IServiceArea;

public abstract class ServiceArea<A extends Area> implements IServiceArea <A>{

	private final IDAOArea<A> dao;
	
	public ServiceArea (IDAOArea<A> dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(A a) throws DatabaseException
	{
		dao.inserir(a);
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
	public List<A> listar() throws DatabaseException
	{return null;}

	/** Metodos que precisam ser implementados */
	protected abstract boolean validarInserir(A a);
	protected abstract boolean validarRemover(A a);
	protected abstract boolean validarAtulizar(A a);
	protected abstract boolean validarConsultar(A a);
	
}
