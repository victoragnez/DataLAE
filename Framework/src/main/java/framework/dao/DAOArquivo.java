package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArquivo;
import framework.model.Arquivo;

public abstract class DAOArquivo implements IDAOArquivo {

	@Override
	public void inserir(Arquivo a) throws DatabaseException {
		// TODO Auto-generated method stub

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

}
