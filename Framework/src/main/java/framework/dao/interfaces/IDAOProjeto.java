package framework.dao.interfaces;

import java.util.List;

import framework.model.Participante;
import framework.model.Projeto;

public interface IDAOProjeto {
	
	public void inserir(Projeto p) throws DatabaseException;
	public void remover(Projeto p) throws DatabaseException;
	public void atualizar(Projeto p) throws DatabaseException;
	public List<Projeto> consultar(Projeto pj, Participante p) throws DatabaseException;
	public List<Projeto> listar() throws DatabaseException;
}
