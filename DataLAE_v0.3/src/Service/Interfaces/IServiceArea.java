package Service.Interfaces;

import java.util.List;

import DAO.Interfaces.DatabaseException;
import Model.Area;

public interface IServiceArea {

	public void inserir(Area a) throws DatabaseException;
	public void remover(Area a) throws DatabaseException;
	public void atualizar(Area a) throws DatabaseException;
	public List<Area> consultar(Area a) throws DatabaseException;
	public List<Area> listar() throws DatabaseException;
	
}
