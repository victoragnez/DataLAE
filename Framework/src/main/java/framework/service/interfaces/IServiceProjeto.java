package framework.service.interfaces;

import java.util.List;

import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.model.Projeto;

public interface IServiceProjeto<P extends Projeto<?>> {

	public void inserir(P p) throws DatabaseException, BadAttributeException;
	public void remover(P p) throws DatabaseException, BadAttributeException;
	public void atualizar(P p) throws DatabaseException, BadAttributeException;
	public List<P> consultar(P p) throws DatabaseException, BadAttributeException;
	public List<P> listar() throws DatabaseException;
	
}
