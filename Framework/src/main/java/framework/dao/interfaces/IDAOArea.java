package framework.dao.interfaces;

import java.util.List;

import framework.model.Area;

public interface IDAOArea<A extends Area> {

	public void inserir(A a) throws DatabaseException;
	public void remover(A a) throws DatabaseException;
	public void atualizar(A a) throws DatabaseException;
	public List<A> consultar(A a) throws DatabaseException;
	public List<A> listar() throws DatabaseException;
	
}
