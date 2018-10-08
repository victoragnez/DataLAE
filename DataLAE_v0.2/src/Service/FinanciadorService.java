package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.FinanciadorDAO;
import DAO.Interfaces.IFinanciadorDAO;
import Model.Financiador;
import Model.Projeto;
import Service.Interfaces.IFinanciadorService;

public final class FinanciadorService implements IFinanciadorService{

	private final IFinanciadorDAO dao = new FinanciadorDAO();
	
	private FinanciadorService () {};
	
	private static Wrapper<FinanciadorService> wrapper;
	
	public static FinanciadorService getInstance () {
		Wrapper<FinanciadorService> w = wrapper;
        if (w == null) { // check 1
        	synchronized (FinanciadorService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper<FinanciadorService>(new FinanciadorService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}

	@Override
	public void inserir(Financiador f) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Financiador f) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Financiador> listarFinanciadores() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Financiador> buscar(Financiador f, Projeto p) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Financiador f) {
		// TODO Auto-generated method stub
		
	}
	


}
