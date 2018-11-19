package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOAtividade;
import framework.model.Atividade;

public abstract class DAOAtividade<A extends Atividade> implements IDAOAtividade<A> {

	@Override
	public void inserir(A a) throws DatabaseException {
		// TODO Auto-generated method stub

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
	
	/** Metodos que devem ser implementados*/
	
	protected abstract String compInserir(String comando);
	protected abstract String compRemover(String comando);
	protected abstract String compAtualizar(String comando);
	protected abstract String compConsultar(String comando);
}
