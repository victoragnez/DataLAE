package Service.Interfaces;

import java.util.List;

import DAO.Interfaces.DatabaseException;
import Model.Usuario;

public interface IServiceUsuario {

	public void inserir(Usuario user) throws DatabaseException;
	public void remover(Usuario user) throws DatabaseException;
	public void atualizar(Usuario user) throws DatabaseException;
	public List<Usuario> consultar(Usuario user) throws DatabaseException;
	public List<Usuario> listar() throws DatabaseException;

}
