package com.lab.data.service;

import java.util.List;

import com.lab.data.dao.interfaces.DatabaseException;
import com.lab.data.dao.interfaces.IDAOParticipante;
import com.lab.data.model.Participante;
import com.lab.data.service.interfaces.IServiceParticipante;

public abstract class ServiceParticipante implements IServiceParticipante {

	private final IDAOParticipante dao;
	
	public ServiceParticipante (IDAOParticipante dao)	{
		this.dao = dao;
	}
	
	public void inserir(Participante p) throws DatabaseException
	{}
	
	public void remover(Participante p) throws DatabaseException
	{}
	
	public void atualizar(Participante p) throws DatabaseException
	{}
	
	public List<Participante> consultar(Participante p) throws DatabaseException
	{return null;}
	
	public List<Participante> listar() throws DatabaseException
	{return null;}

	/** Classes que precisam ser implementadas */
	public abstract boolean validarInserir(String command);
	public abstract boolean validarRemover(String command);
	public abstract boolean validarAtulizar(String command);
	public abstract boolean validarConsultar(String command);

	public IDAOParticipante getDao() {
		return dao;
	}
}
