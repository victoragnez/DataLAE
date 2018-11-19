package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOAtividade;
import framework.model.Atividade;
import framework.service.interfaces.IServiceAtividade;

public abstract class ServiceAtividade<A extends Atividade> implements IServiceAtividade<A> {

	private final IDAOAtividade<A> dao;
	
	public ServiceAtividade (IDAOAtividade<A> dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(A a) throws DatabaseException {
		// TODO Auto-generated method stub
		dao.atualizar(a);
	}

	@Override
	public void remover(A a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(A a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<A> consultar(A a) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<A> listar() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/** Metodos que precisam ser implementados */
	protected abstract boolean validarInserir(A a);
	protected abstract boolean validarRemover(A a);
	protected abstract boolean validarAtulizar(A a);
	protected abstract boolean validarConsultar(A a);

}
