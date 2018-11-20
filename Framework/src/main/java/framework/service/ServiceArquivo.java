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
	
	/** Classes que precisam ser implementadas */
	protected abstract boolean validarInserir(String command);
	protected abstract boolean validarRemover(String command);
	protected abstract boolean validarAtulizar(String command);
	protected abstract boolean validarConsultar(String command);

}
