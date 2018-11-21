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
	public void inserir(P p) throws DatabaseException {
		//TODO add verification
		dao.inserir(p);
	}
	
	@Override
	public void remover(P p) throws DatabaseException {
		if(p == null)
			throw new IllegalArgumentException("Parâmetro fornecido nulo");
		if(p.getCodigo() == null)
			throw new IllegalArgumentException("Codigo nulo");
		
		validarRemover(p);
		dao.remover(p);
	}
	
	@Override
	public void atualizar(P p) throws DatabaseException {
		if(p == null)
			throw new IllegalArgumentException("Parâmetro fornecido nulo");
		if(p.getCodigo() == null)
			throw new IllegalArgumentException("Codigo nulo");
		
		validarAtulizar(p);
		dao.atualizar(p);
	}
	
	@Override
	public List<P> consultar(P p) throws DatabaseException{
		if(p == null)
			throw new IllegalArgumentException("Parâmetro fornecido nulo");
		validarConsultar(p);
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
