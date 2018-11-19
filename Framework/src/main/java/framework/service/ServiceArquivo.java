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
		// TODO Auto-generated method stub
		dao.inserir(a);
	}

	@Override
	public void remover(Arquivo a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Arquivo a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Arquivo> consultar(Arquivo a) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Arquivo> listar() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/** Metodos que precisam ser implementados */
	protected abstract boolean validarInserir(Arquivo a);
	protected abstract boolean validarRemover(Arquivo a);
	protected abstract boolean validarAtulizar(Arquivo a);
	protected abstract boolean validarConsultar(Arquivo a);

}
