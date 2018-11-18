package com.lab.data.dao;

import java.util.List;

import com.lab.data.dao.interfaces.DatabaseException;
import com.lab.data.dao.interfaces.IDAOUsuario;
import com.lab.data.model.Usuario;

@Deprecated
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
