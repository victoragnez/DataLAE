package com.lab.data.dao;

import java.util.List;

import com.lab.data.dao.interfaces.DatabaseException;
import com.lab.data.dao.interfaces.IDAOParticipante;
import com.lab.data.model.Participante;

public abstract class DAOParticipante implements IDAOParticipante {

	public DAOParticipante() {} 

	public void inserir(Participante p) throws DatabaseException
	{}
	
	public void remover(Participante p) throws DatabaseException
	{}
	
	public void atualizar(Participante p) throws DatabaseException
	{}
	
	public List<Participante> consultar(Participante p) throws DatabaseException
	{
		return null;
	}
	
	public List<Participante> listar() throws DatabaseException
	{
		return null;
	}
	
	/** classes que devem ser implementadas*/
	
	public abstract String compInserir(String comando);
	public abstract String compRemover(String comando);
	public abstract String compAtualizar(String comando);
	public abstract String compConsultar(String comando);
	
}
