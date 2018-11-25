package framework.dao.interfaces;

import java.util.List;

import framework.model.Projeto;

public interface IDAOProjeto <P extends Projeto<?>> {
	
	public void inserir(P p) throws DatabaseException;
	public void remover(P p) throws DatabaseException;
	public void atualizar(P p) throws DatabaseException;
	public List<P> consultar(P p) throws DatabaseException;
	public P consultar(Integer codigo) throws DatabaseException;
	public List<P> listar() throws DatabaseException;
}
