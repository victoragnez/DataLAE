package framework.service.interfaces;

import java.util.List;

import framework.model.Area;
import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.model.Pratica;
import framework.model.Projeto;
import framework.model.Participante;

public interface IServiceAtividade<
		A extends Area,
		Proj extends Projeto<?>,
		Prat extends Pratica<A, ?, Proj>,
		Part extends Participante> 
{

	public void inserir(Prat a) throws DatabaseException, BadAttributeException;
	public void remover(Prat a) throws DatabaseException, BadAttributeException;
	public void atualizar(Prat a) throws DatabaseException, BadAttributeException;
	public List<Prat> consultar(Prat a) throws DatabaseException, BadAttributeException;
	public List<Prat> listar() throws DatabaseException;
	
}
