package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Participante;
import framework.model.Projeto;

public abstract class DAOProjeto implements IDAOProjeto {
	
	public void inserir(Projeto p) throws DatabaseException
	{
		
	}
	
	public void remover(Projeto p) throws DatabaseException
	{
		
	}
	
	public void atualizar(Projeto p) throws DatabaseException
	{
		
	}
	
	public List<Projeto> consultar(Projeto pj, Participante p) throws DatabaseException
	{
		return null;
		
	}
	
	public List<Projeto> listar() throws DatabaseException
	{
		return null;
		
	}

	/** classes que devem ser implementadas*/
	
	public abstract String compInserir(String comando);
	public abstract String compRemover(String comando);
	public abstract String compAtualizar(String comando);
	public abstract String compConsultar(String comando);

}
