package framework.service.interfaces;

import java.util.List;

import framework.model.Area;
import framework.model.BadAttributeException;
import framework.model.DatabaseException;

public interface IServiceArea <A extends Area>{

	public void inserir(A a) throws DatabaseException, BadAttributeException;
	public void remover(A a) throws DatabaseException, BadAttributeException;
	public void atualizar(A a) throws DatabaseException, BadAttributeException;
	public List<A> consultar(A a) throws DatabaseException, BadAttributeException;
	public List<A> listar() throws DatabaseException, BadAttributeException;
	
}
