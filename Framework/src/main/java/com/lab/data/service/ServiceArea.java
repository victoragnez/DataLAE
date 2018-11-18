package com.lab.data.service;

import java.util.List;

import com.lab.data.dao.interfaces.DatabaseException;
import com.lab.data.dao.interfaces.IDAOArea;
import com.lab.data.model.Area;
import com.lab.data.service.interfaces.IServiceArea;

public abstract class ServiceArea implements IServiceArea {

	private final IDAOArea dao;
	
	public ServiceArea (IDAOArea dao)	{
		this.dao = dao;
	}
	
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

	/** Classes que precisam ser implementadas */
	public abstract boolean validarInserir(String command);
	public abstract boolean validarRemover(String command);
	public abstract boolean validarAtulizar(String command);
	public abstract boolean validarConsultar(String command);

	public IDAOArea getDao() {
		return dao;
	}
	
}
