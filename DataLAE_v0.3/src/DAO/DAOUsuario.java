package DAO;

import java.util.List;

import DAO.Interfaces.DatabaseException;
import DAO.Interfaces.IDAOUsuario;
import Model.Usuario;

public abstract class DAOUsuario implements IDAOUsuario{

	public void inserir(Usuario user) throws DatabaseException
	{}
	
	public void remover(Usuario user) throws DatabaseException
	{}
	
	public void atualizar(Usuario user) throws DatabaseException
	{}
	
	public List<Usuario> consultar(Usuario user) throws DatabaseException
	{return null;}	
	
	public List<Usuario> listar() throws DatabaseException
	{return null;}
	
	/** classes que devem ser implementadas*/
	
	public abstract String compInserir(String comando);
	public abstract String compRemover(String comando);
	public abstract String compAtualizar(String comando);
	public abstract String compConsultar(String comando);
}
