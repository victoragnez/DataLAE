package Service;

import DAO.PesquisadorDAO;
import DAO.Exceptions.CampoInvalidoException;
import DAO.Interfaces.IPesquisadorDAO;
import Model.Pesquisador;
import Service.Exceptions.AtributoInvalidoException;
import Service.Interfaces.IPesquisadorService;

public class PesquisadorService implements IPesquisadorService {

	IPesquisadorDAO dao = new PesquisadorDAO();
	
	@Override
	public void inserir(Pesquisador p) throws AtributoInvalidoException, CampoInvalidoException {
		if ( p == null ) 
			throw new AtributoInvalidoException("Os campos obrigatórios devem ser preenchidos!"); 
		
		dao.inserir(p);		
	}

	@Override
	public void remover(Pesquisador p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pesquisador consultar(String codigoPesquisador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Pesquisador p) {
		// TODO Auto-generated method stub
		
	}

}
