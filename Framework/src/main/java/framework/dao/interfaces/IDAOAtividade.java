package framework.dao.interfaces;

import java.util.List;

import framework.model.Atividade;

public interface IDAOAtividade {
	
	public void inserir(Atividade a) throws DatabaseException;
	public void remover(Atividade a) throws DatabaseException;
	public void atualizar(Atividade a) throws DatabaseException;
	public List<Atividade> consultar(Atividade a) throws DatabaseException;
	public List<Atividade> listar() throws DatabaseException;
}
