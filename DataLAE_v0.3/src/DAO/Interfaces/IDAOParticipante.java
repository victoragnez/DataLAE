package DAO.Interfaces;

import java.util.List;

import Model.Participante;

public interface IDAOParticipante {

	public void inserir(Participante p) throws DatabaseException;
	public void remover(Participante p) throws DatabaseException;
	public void atualizar(Participante p) throws DatabaseException;
	public List<Participante> consultar(Participante p) throws DatabaseException;
	public List<Participante> listar() throws DatabaseException;
	
}
