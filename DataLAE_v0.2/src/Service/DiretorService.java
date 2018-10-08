package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.DiretorDAO;
import DAO.Interfaces.IDiretorDAO;
import Model.Diretor;
import Service.Interfaces.IDiretorService;

public class DiretorService implements IDiretorService {
	
	private final IDiretorDAO dao = new DiretorDAO();
	
	private DiretorService() {}
	
	private static Wrapper<DiretorService> wrapper;
	
	public static DiretorService getInstance () {
		Wrapper<DiretorService> w = wrapper;
        if (w == null) { // check 1
        	synchronized (DiretorService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper<DiretorService>(new DiretorService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}
	
	@Override
	public void inserir(Diretor f) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Diretor f) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Diretor> listarDiretores() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Diretor f) {
		// TODO Auto-generated method stub

	}

}
