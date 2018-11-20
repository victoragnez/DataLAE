package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOAtividade;
import framework.model.Atividade;

public abstract class DAOAtividade implements IDAOAtividade {

	@Override
	public void inserir(Atividade a) throws DatabaseException {
		// TODO Auto-generated method stub

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
	
	/** classes que devem ser implementadas*/
	
	protected abstract String compInserir(String comando);
	protected abstract String compRemover(String comando);
	protected abstract String compAtualizar(String comando);
	protected abstract String compConsultar(String comando);
}
