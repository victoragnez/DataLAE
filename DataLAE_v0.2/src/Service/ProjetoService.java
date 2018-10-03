package Service;

import DAO.ProjetoDAO;
import DAO.Interfaces.IProjetoDAO;
import Model.Projeto;
import Service.Interfaces.IProjetoService;

public class ProjetoService implements IProjetoService{
	
	private IProjetoDAO dao = new ProjetoDAO();
	
	public ProjetoService() {}

	@Override
	public void inserir(Projeto p) {
		dao.inserir(p);
		
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
