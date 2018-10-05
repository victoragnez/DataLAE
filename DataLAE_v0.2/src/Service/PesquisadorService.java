package Service;

import java.sql.SQLException;

import DAO.PesquisadorDAO;
import DAO.Interfaces.IPesquisadorDAO;
import Model.Pesquisador;
import Service.Interfaces.IPesquisadorService;

public class PesquisadorService implements IPesquisadorService {

	IPesquisadorDAO dao = new PesquisadorDAO();
	
	@Override
	public void inserir(Pesquisador p) throws SQLException {
		if ( p == null ) 
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (p.getNome() == null ||  p.getUniversidade() == null)
			throw new IllegalArgumentException("Campo obrigatório nulo!");
		
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
