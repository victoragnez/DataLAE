package framework.service.interfaces;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.model.Participante;
import framework.model.Projeto;


public interface IServiceProjeto<P extends Projeto> {

	public void inserir(P p) throws DatabaseException;
	public void remover(P p) throws DatabaseException;
	public void atualizar(P p) throws DatabaseException;
	public List<P> consultar(P p) throws DatabaseException;
	public List<P> listar() throws DatabaseException;
	
}
