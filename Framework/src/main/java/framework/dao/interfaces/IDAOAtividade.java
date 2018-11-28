package framework.dao.interfaces;

import java.util.List;

import framework.model.Area;
import framework.model.DatabaseException;
import framework.model.Pratica;
import framework.model.Projeto;

public interface IDAOAtividade<
		A extends Area,
		Proj extends Projeto<?>, 
		Prat extends Pratica<?, ?, Proj> > 
{
	public void inserir(Prat a) throws DatabaseException;
	public void remover(Prat a) throws DatabaseException;
	public void atualizar(Prat a) throws DatabaseException;
	public List<Prat> consultar(Prat a) throws DatabaseException;
	public Prat consultar(Integer codigo) throws DatabaseException;
	public List<Prat> listar() throws DatabaseException;
}
