package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOParticipante;
import framework.model.Participante;
import framework.service.interfaces.IServiceParticipante;

public abstract class ServiceParticipante<P extends Participante> implements IServiceParticipante<P> {

	private final IDAOParticipante<P> dao;
	
	public ServiceParticipante (IDAOParticipante<P> dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(P p) throws DatabaseException
	{
		dao.inserir(p);
	}
	
	@Override
	public void remover(P p) throws DatabaseException
	{}
	
	@Override
	public void atualizar(P p) throws DatabaseException
	{}
	
	@Override
	public List<P> consultar(P p) throws DatabaseException
	{return null;}
	
	@Override
	public List<P> listar() throws DatabaseException
	{return null;}

	/** Metodos que precisam ser implementados */
	protected abstract boolean validarInserir(P p);
	protected abstract boolean validarRemover(P p);
	protected abstract boolean validarAtulizar(P p);
	protected abstract boolean validarConsultar(P p);
}
