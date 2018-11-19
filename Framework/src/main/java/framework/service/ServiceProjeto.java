package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Participante;
import framework.model.Projeto;
import framework.service.interfaces.IServiceProjeto;

public abstract class ServiceProjeto<P extends Projeto> implements IServiceProjeto<P> {

	private final IDAOProjeto dao;
	
	public ServiceProjeto (IDAOProjeto dao)	{
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
	public List<Projeto> consultar(P p) throws DatabaseException
	{return null;}
	
	@Override
	public List<Projeto> listar() throws DatabaseException
	{return null;}

	/** Classes que precisam ser implementadas */
	protected abstract boolean validarInserir(String command);
	protected abstract boolean validarRemover(String command);
	protected abstract boolean validarAtulizar(String command);
	protected abstract boolean validarConsultar(String command);

}
