package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Projeto;

public abstract class DAOProjeto implements IDAOProjeto {
	
	@Override
	public void inserir(Projeto p) throws DatabaseException
	{
		
	}
	
	@Override
	public void remover(Projeto p) throws DatabaseException
	{
		
	}
	
	@Override
	public void atualizar(Projeto p) throws DatabaseException
	{
		
	}
	
	@Override
	public List<Projeto> consultar(Projeto pj) throws DatabaseException
	{
		return null;
		
	}
	
	@Override
	public List<Projeto> listar() throws DatabaseException
	{
		return null;
		
	}

	/** classes que devem ser implementadas*/
	
	protected abstract String compInserir(String comando);
	protected abstract String compRemover(String comando);
	protected abstract String compAtualizar(String comando);
	protected abstract String compConsultar(String comando);

}
