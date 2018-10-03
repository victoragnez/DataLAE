package Service;

import DAO.Interfaces.IProjetoDAO;
import Model.Projeto;
import Service.Interfaces.IProjetoService;

public class ProjetoService implements IProjetoService{
	private IProjetoDAO projDAO;
	
	public ProjetoService(IProjetoDAO projDAO) {
		this.projDAO = projDAO;
	}

	@Override
	public void inserir(Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Projeto consultar(String codigoProjeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Projeto p) {
		// TODO Auto-generated method stub
		
	}

}
