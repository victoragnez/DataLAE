package framework.dao.interfaces;

import java.util.List;

import framework.model.DatabaseException;
import framework.model.Participante;

public interface IDAOParticipante <P extends Participante> {

	public void inserir(P p) throws DatabaseException;
	public void remover(P p) throws DatabaseException;
	public void atualizar(P p) throws DatabaseException;
	public List<P> consultar(P p) throws DatabaseException;
	public List<P> listar() throws DatabaseException;
	P consultar(Integer codigo) throws DatabaseException;
	
}
