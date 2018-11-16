package DAO.Interfaces;

import java.util.List;

import Model.Participante;
import Model.Projeto;

public interface IDAOProjeto {
	
	public void inserir(Projeto p) throws DatabaseException;
	public void remover(Projeto p) throws DatabaseException;
	public void atualizar(Projeto p) throws DatabaseException;
	public List<Projeto> consultar(Projeto pj, Participante p) throws DatabaseException;
	public List<Projeto> listar() throws DatabaseException;
}
