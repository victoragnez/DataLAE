package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOParticipante;
import framework.model.Participante;

public abstract class DAOParticipante implements IDAOParticipante {

	public DAOParticipante() {} 

	@Override
	public void inserir(Participante p) throws DatabaseException
	{}
	
	@Override
	public void remover(Participante p) throws DatabaseException
	{}
	
	@Override
	public void atualizar(Participante p) throws DatabaseException
	{}
	
	@Override
	public List<Participante> consultar(Participante p) throws DatabaseException
	{
		return null;
	}
	
	@Override
	public List<Participante> listar() throws DatabaseException
	{
		return null;
	}
	
	/** classes que devem ser implementadas*/
	
	protected abstract String compInserir(String comando);
	protected abstract String compRemover(String comando);
	protected abstract String compAtualizar(String comando);
	protected abstract String compConsultar(String comando);
	
}
