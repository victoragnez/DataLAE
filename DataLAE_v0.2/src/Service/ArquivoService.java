package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ArquivoDAO;
import DAO.Interfaces.IArquivoDAO;
import Model.Arquivo;
import Service.Interfaces.IArquivoService;

public final class ArquivoService implements IArquivoService {

	private final IArquivoDAO dao = new ArquivoDAO();
	
	private ArquivoService(){}
	
	private static Wrapper<ArquivoService> wrapper;
	
	public static ArquivoService getInstance () {
		Wrapper<ArquivoService> w = wrapper;
        if (w == null) { // check 1
        	synchronized (ArquivoService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper<ArquivoService>(new ArquivoService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}

	@Override
	public void inserir(Arquivo user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Arquivo user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Arquivo> listarArquivos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arquivo> buscar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Arquivo user) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
