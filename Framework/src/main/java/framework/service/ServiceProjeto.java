package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Projeto;
import framework.service.interfaces.IServiceProjeto;

public abstract class ServiceProjeto<P extends Projeto> implements IServiceProjeto<P> {

	private final IDAOProjeto<P> dao;
	
	public ServiceProjeto (IDAOProjeto<P> dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(P p) throws DatabaseException {
		if(p.getDataInicio() != null || p.getNome() != null)
			throw new IllegalArgumentException("Parametro fornecido contem campos obrigatórios nulos");
		if(!validarInserir(p))
			throw new IllegalArgumentException("Parametro fornecido não esta de acordo com as restrições da classe concreta");
		dao.inserir(p);
	}
	
	@Override
	public void remover(P p) throws DatabaseException
	{}
	
	@Override
	public void atualizar(P p) throws DatabaseException
	{}
	
	@Override
	public List<P> consultar(P p) throws DatabaseException{
		return dao.consultar(p);
	}
	
	@Override
	public List<P> listar() throws DatabaseException
	{return null;}

	/** Metodos que precisam ser implementados */
	protected abstract boolean validarInserir(P p);
	protected abstract boolean validarRemover(P p);
	protected abstract boolean validarAtulizar(P p);
	protected abstract boolean validarConsultar(P p);

}
