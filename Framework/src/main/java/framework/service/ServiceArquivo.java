package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArquivo;
import framework.model.Arquivo;
import framework.service.interfaces.IServiceArquivo;

public abstract class ServiceArquivo implements IServiceArquivo {
	
	private final IDAOArquivo dao;
	
	public ServiceArquivo (IDAOArquivo dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(Arquivo a) throws DatabaseException {
		dao.inserir(a);
	}

	@Override
	public void remover(Arquivo a) throws DatabaseException {
		dao.remover(a);
	}

	@Override
	public void atualizar(Arquivo a) throws DatabaseException {
		dao.atualizar(a);
	}

	@Override
	public List<Arquivo> consultar(Arquivo a) throws DatabaseException {
		return dao.consultar(a);
	}

	@Override
	public List<Arquivo> listar() throws DatabaseException {
		return dao.listar();
	}
	
	/** Metodos que precisam ser implementados */
	protected abstract void validarInserir(Arquivo a);
	protected abstract void validarRemover(Arquivo a);
	protected abstract void validarAtulizar(Arquivo a);
	protected abstract void validarConsultar(Arquivo a);

}
