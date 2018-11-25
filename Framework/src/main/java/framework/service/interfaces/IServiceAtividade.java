package framework.service.interfaces;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.model.Area;
import framework.model.Pratica;
import framework.model.Projeto;

public interface IServiceAtividade<
		A extends Area,
		Proj extends Projeto<?>,
		Prat extends Pratica<A, ?, Proj>> 
{

	public void inserir(Prat a) throws DatabaseException;
	public void remover(Prat a) throws DatabaseException;
	public void atualizar(Prat a) throws DatabaseException;
	public List<Prat> consultar(Prat a) throws DatabaseException;
	public List<Prat> listar() throws DatabaseException;
	
}
