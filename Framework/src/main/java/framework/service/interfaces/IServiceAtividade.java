package framework.service.interfaces;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.model.Atividade;

public interface IServiceAtividade {

	public void inserir(Atividade a) throws DatabaseException;
	public void remover(Atividade a) throws DatabaseException;
	public void atualizar(Atividade a) throws DatabaseException;
	public List<Atividade> consultar(Atividade a) throws DatabaseException;
	public List<Atividade> listar() throws DatabaseException;
	
}
