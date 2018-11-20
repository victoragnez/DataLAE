package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArea;
import framework.model.Area;
import framework.service.interfaces.IServiceArea;

public abstract class ServiceArea implements IServiceArea {

	private final IDAOArea dao;
	
	public ServiceArea (IDAOArea dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(Area a) throws DatabaseException
	{
		dao.inserir(a);
	}
	
	@Override
	public void remover(Area a) throws DatabaseException
	{}
	
	@Override
	public void atualizar(Area a) throws DatabaseException
	{}
	
	@Override
	public List<Area> consultar(Area a) throws DatabaseException
	{return null;}
	
	@Override
	public List<Area> listar() throws DatabaseException
	{return null;}

	/** Classes que precisam ser implementadas */
	protected abstract boolean validarInserir(String command);
	protected abstract boolean validarRemover(String command);
	protected abstract boolean validarAtulizar(String command);
	protected abstract boolean validarConsultar(String command);
	
}
