package DAO;

import java.util.List;

import DAO.Interfaces.DatabaseException;
import Model.Area;

public abstract class DAOArea {

	public DAOArea() {}
	
	public void inserir(Area a) throws DatabaseException
	{}
	
	public void remover(Area a) throws DatabaseException
	{}
	
	public void atualizar(Area a) throws DatabaseException
	{}
	
	public List<Area> consultar(Area a) throws DatabaseException
	{return null;}
	
	public List<Area> listar() throws DatabaseException
	{return null;}
	
	/** classes que devem ser implementadas*/
	
	public abstract String compInserir(String comando);
	public abstract String compRemover(String comando);
	public abstract String compAtualizar(String comando);
	public abstract String compConsultar(String comando);
}
