package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArea;
import framework.model.Area;

public abstract class DAOArea implements IDAOArea {

	public DAOArea() {}
	
	public void inserir(Area a) throws DatabaseException
	{}
	
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
	
	/** classes que devem ser implementadas*/
	
	protected abstract String compInserir(String comando);
	protected abstract String compRemover(String comando);
	protected abstract String compAtualizar(String comando);
	protected abstract String compConsultar(String comando);
}
