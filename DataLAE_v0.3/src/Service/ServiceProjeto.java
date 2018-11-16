package Service;

import java.util.List;

import DAO.Interfaces.DatabaseException;
import DAO.Interfaces.IDAOProjeto;
import Model.Participante;
import Model.Projeto;
import Service.Interfaces.IServiceProjeto;

public abstract class ServiceProjeto implements IServiceProjeto{

	private final IDAOProjeto dao;
	
	public ServiceProjeto (IDAOProjeto dao)	{
		this.dao = dao;
	}
	
	public void inserir(Projeto p) throws DatabaseException
	{}
	
	public void remover(Projeto p) throws DatabaseException
	{}
	
	public void atualizar(Projeto p) throws DatabaseException
	{}
	
	public List<Projeto> consultar(Projeto pj, Participante p) throws DatabaseException
	{return null;}
	
	public List<Projeto> listar() throws DatabaseException
	{return null;}

	/** Classes que precisam ser implementadas */
	public abstract boolean validarInserir(String command);
	public abstract boolean validarRemover(String command);
	public abstract boolean validarAtulizar(String command);
	public abstract boolean validarConsultar(String command);

	public IDAOProjeto getDao() {
		return dao;
	}
	
}
