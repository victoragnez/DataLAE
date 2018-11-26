package framework.service.interfaces;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.model.Arquivo;

public interface IServiceArquivo<Arq extends Arquivo<?, ?>> {

	public void inserir(Arq a) throws DatabaseException;
	public void remover(Arq a) throws DatabaseException;
	public void atualizar(Arq a) throws DatabaseException;
	public List<Arq> consultar(Arq a) throws DatabaseException;
	public List<Arq> listar() throws DatabaseException;
}
