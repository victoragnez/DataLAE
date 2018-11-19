package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOParticipante;
import framework.model.Participante;

public abstract class DAOParticipante<P extends Participante> implements IDAOParticipante<P> {

	public DAOParticipante() {} 

	@Override
	public void inserir(P p) throws DatabaseException
	{}
	
	@Override
	public void remover(P p) throws DatabaseException
	{}
	
	@Override
	public void atualizar(P p) throws DatabaseException
	{}
	
	@Override
	public List<P> consultar(P p) throws DatabaseException
	{
		return null;
	}
	
	@Override
	public List<P> listar() throws DatabaseException
	{
		return null;
	}
	
	/** Metodos que devem ser implementados*/
	
	protected abstract String compInserir(String sql, P p);
	protected abstract String compRemover(String sql, P p);
	protected abstract String compAtualizar(String sql, P p);
	protected abstract String compConsultar(String sql, P p);
	
}
