package framework.service.interfaces;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.model.Participante;
import framework.model.Projeto;


public interface IServiceProjeto {

	public void inserir(Projeto p) throws DatabaseException;
	public void remover(Projeto p) throws DatabaseException;
	public void atualizar(Projeto p) throws DatabaseException;
	public List<Projeto> consultar(Projeto pj, Participante p) throws DatabaseException;
	public List<Projeto> listar() throws DatabaseException;
	
}
