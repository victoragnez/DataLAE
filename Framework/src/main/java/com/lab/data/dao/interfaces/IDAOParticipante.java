package com.lab.data.dao.interfaces;

import java.util.List;

import com.lab.data.model.Participante;

public interface IDAOParticipante {

	public void inserir(Participante p) throws DatabaseException;
	public void remover(Participante p) throws DatabaseException;
	public void atualizar(Participante p) throws DatabaseException;
	public List<Participante> consultar(Participante p) throws DatabaseException;
	public List<Participante> listar() throws DatabaseException;
	
}
