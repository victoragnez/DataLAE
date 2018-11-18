package com.lab.data.service;

import java.util.List;

import com.lab.data.dao.interfaces.DatabaseException;
import com.lab.data.dao.interfaces.IDAOProjeto;
import com.lab.data.model.Participante;
import com.lab.data.model.Projeto;
import com.lab.data.service.interfaces.IServiceProjeto;

public abstract class ServiceProjeto implements IServiceProjeto {

	private final IDAOProjeto dao;
	
	public ServiceProjeto (IDAOProjeto dao)	{
		this.dao = dao;
	}
	
	public void inserir(Projeto p) throws DatabaseException
	{}
	
	public void remover(Projeto p) throws DatabaseException
	{}
	
	public void atualizar(Projeto p) throws DatabaseException
	{}
	
	public List<Projeto> consultar(Projeto pj, Participante p) throws DatabaseException
	{return null;}
	
	public List<Projeto> listar() throws DatabaseException
	{return null;}

	/** Classes que precisam ser implementadas */
	public abstract boolean validarInserir(String command);
	public abstract boolean validarRemover(String command);
	public abstract boolean validarAtulizar(String command);
	public abstract boolean validarConsultar(String command);

	public IDAOProjeto getDao() {
		return dao;
	}
	
}
