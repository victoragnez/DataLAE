package framework.service.interfaces;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.model.Arquivo;

public interface IServiceArquivo {

	public void inserir(Arquivo a) throws DatabaseException;
	public void remover(Arquivo a) throws DatabaseException;
	public void atualizar(Arquivo a) throws DatabaseException;
	public List<Arquivo> consultar(Arquivo a) throws DatabaseException;
	public List<Arquivo> listar() throws DatabaseException;
	
}
