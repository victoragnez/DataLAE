package framework.service.interfaces;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.model.Arquivo;
import framework.model.Pratica;
import framework.model.Projeto;

public interface IServiceArquivo<Proj extends Projeto<?>, Prat extends Pratica<?, ?, Proj>, 
A extends Arquivo<Proj, Prat> > {

	public void inserir(A a) throws DatabaseException;
	public void remover(A a) throws DatabaseException;
	public void atualizar(A a) throws DatabaseException;
	public List<A> consultar(A a) throws DatabaseException;
	public List<A> listar() throws DatabaseException;
	
}
