package framework.dao.interfaces;

import java.util.List;

import framework.model.Arquivo;

public interface IDAOArquivo {

	public void inserir(Arquivo a) throws DatabaseException;
	public void remover(Arquivo a) throws DatabaseException;
	public void atualizar(Arquivo a) throws DatabaseException;
	public List<Arquivo> consultar(Arquivo a) throws DatabaseException;
	public List<Arquivo> listar() throws DatabaseException;
	
}
