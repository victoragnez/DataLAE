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
	public void inserir(A a) throws DatabaseException{
		dao.inserir(a);
	}
	
	@Override
	public void remover(A a) throws DatabaseException{
		dao.remover(a);
	}
	
	@Override
	public void atualizar(A a) throws DatabaseException{
		dao.atualizar(a);
	}
	
	@Override
	public List<A> consultar(A a) throws DatabaseException{
		return dao.consultar(a);
	}
	
	@Override
	public List<A> listar() throws DatabaseException{
		return dao.listar();
	}

	/** Metodos que precisam ser implementados */
	protected abstract void validarInserir(A a);
	protected abstract void validarRemover(A a);
	protected abstract void validarAtulizar(A a);
	protected abstract void validarConsultar(A a);
	
}
