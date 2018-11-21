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
		if(p == null)
			throw new IllegalArgumentException("Parâmetro fornecido nulo");
		if(p.getDataInicio() == null)
			throw new IllegalArgumentException("Data inicio nula!");
		if(p.getNome() == null)
			throw new IllegalArgumentException("Nome nulo!");
		
		validarInserir(p);
		dao.inserir(p);
	}
	
	@Override
	public void remover(P p) throws DatabaseException {
		dao.remover(p);
	}
	
	@Override
	public void atualizar(P p) throws DatabaseException {
		dao.atualizar(p);
	}
	
	@Override
	public List<P> consultar(P p) throws DatabaseException{
		return dao.consultar(p);
	}
	
	@Override
	public List<P> listar() throws DatabaseException {
		return dao.listar();
	}

	/** Metodos que precisam ser implementados */
	protected abstract void validarInserir(P p);
	protected abstract void validarRemover(P p);
	protected abstract void validarAtulizar(P p);
	protected abstract void validarConsultar(P p);

}
