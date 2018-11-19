package framework.service.interfaces;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.model.Participante;

public interface IServiceParticipante {

	public void inserir(Participante a) throws DatabaseException;
	public void remover(Participante a) throws DatabaseException;
	public void atualizar(Participante a) throws DatabaseException;
	public List<Participante> consultar(Participante a) throws DatabaseException;
	public List<Participante> listar() throws DatabaseException;
	
}
