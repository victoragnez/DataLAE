package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOAtividade;
import framework.model.Atividade;
import framework.service.interfaces.IServiceAtividade;

public abstract class ServiceAtividade implements IServiceAtividade {

	private final IDAOAtividade dao;
	
	public ServiceAtividade (IDAOAtividade dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(Atividade a) throws DatabaseException {
		// TODO Auto-generated method stub
		dao.atualizar(a);
	}

	@Override
	public void remover(Atividade a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Atividade a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Atividade> consultar(Atividade a) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atividade> listar() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/** Classes que precisam ser implementadas */
	protected abstract boolean validarInserir(String command);
	protected abstract boolean validarRemover(String command);
	protected abstract boolean validarAtulizar(String command);
	protected abstract boolean validarConsultar(String command);

}
