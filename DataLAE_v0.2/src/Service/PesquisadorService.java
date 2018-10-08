package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.PesquisadorDAO;
import DAO.Interfaces.IPesquisadorDAO;
import Model.Pesquisador;
import Service.Interfaces.IPesquisadorService;

public final class PesquisadorService implements IPesquisadorService {

	private final IPesquisadorDAO dao = new PesquisadorDAO();
	
	private PesquisadorService() {}

	private static Wrapper<PesquisadorService> wrapper;
	
	public static PesquisadorService getInstance () {
		Wrapper<PesquisadorService> w = wrapper;
        if (w == null) { // check 1
        	synchronized (PesquisadorService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper<PesquisadorService>(new PesquisadorService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}
	
	@Override
	public void inserir(Pesquisador p) throws SQLException {
		if ( p == null ) 
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (p.getNome() == null ||  p.getUniversidade() == null)
			throw new IllegalArgumentException("Campo obrigatório nulo!");
		
		dao.inserir(p);
	}

	@Override
	public void remover(Pesquisador p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Pesquisador> listarPesquisadores() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pesquisador> buscar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Pesquisador p) {
		// TODO Auto-generated method stub
		
	}

}
