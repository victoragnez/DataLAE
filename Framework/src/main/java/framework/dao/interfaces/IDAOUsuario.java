package framework.dao.interfaces;

import java.util.List;

import framework.model.Usuario;

@Deprecated
public interface IDAOUsuario {

	public void inserir(Usuario user) throws DatabaseException;
	public void remover(Usuario user) throws DatabaseException;
	public void atualizar(Usuario user) throws DatabaseException;
	public List<Usuario> consultar(Usuario user) throws DatabaseException;
	public List<Usuario> listar() throws DatabaseException;
	
}
