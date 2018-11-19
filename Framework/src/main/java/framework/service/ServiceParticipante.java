package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOParticipante;
import framework.model.Participante;
import framework.service.interfaces.IServiceParticipante;

public abstract class ServiceParticipante implements IServiceParticipante {

	private final IDAOParticipante dao;
	
	public ServiceParticipante (IDAOParticipante dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(Participante p) throws DatabaseException
	{
		dao.inserir(p);
	}
	
	@Override
	public void remover(Participante p) throws DatabaseException
	{}
	
	@Override
	public void atualizar(Participante p) throws DatabaseException
	{}
	
	@Override
	public List<Participante> consultar(Participante p) throws DatabaseException
	{return null;}
	
	@Override
	public List<Participante> listar() throws DatabaseException
	{return null;}

	/** Classes que precisam ser implementadas */
	protected abstract boolean validarInserir(String command);
	protected abstract boolean validarRemover(String command);
	protected abstract boolean validarAtulizar(String command);
	protected abstract boolean validarConsultar(String command);
}
