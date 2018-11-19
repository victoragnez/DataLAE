package framework.service.interfaces;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.model.Atividade;

public interface IServiceAtividade<A extends Atividade> {

	public void inserir(A a) throws DatabaseException;
	public void remover(A a) throws DatabaseException;
	public void atualizar(A a) throws DatabaseException;
	public List<A> consultar(A a) throws DatabaseException;
	public List<A> listar() throws DatabaseException;
	
}
