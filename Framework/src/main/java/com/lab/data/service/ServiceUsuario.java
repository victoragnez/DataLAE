package com.lab.data.service;

import java.util.List;

import com.lab.data.dao.interfaces.DatabaseException;
import com.lab.data.dao.interfaces.IDAOUsuario;
import com.lab.data.model.Usuario;
import com.lab.data.service.interfaces.IServiceUsuario;

@Deprecated
public abstract class ServiceUsuario implements IServiceUsuario {

	private final IDAOUsuario dao;
	
	public ServiceUsuario (IDAOUsuario dao)	{
		this.dao = dao;
	}
	
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

	/** Classes que precisam ser implementadas */
	public abstract boolean validarInserir(String command);
	public abstract boolean validarRemover(String command);
	public abstract boolean validarAtulizar(String command);
	public abstract boolean validarConsultar(String command);

	public IDAOUsuario getDao() {
		return dao;
	}
	
}
