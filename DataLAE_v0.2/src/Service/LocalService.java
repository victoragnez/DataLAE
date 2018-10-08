package Service;

import java.sql.SQLException;

import DAO.LocalDAO;
import DAO.Interfaces.ILocalDAO;
import Model.Local;
import Model.Projeto;
import Service.Interfaces.ILocalService;

public final class LocalService implements ILocalService {

	private final ILocalDAO dao = new LocalDAO();
	
	private LocalService () {}
	
	private static Wrapper<LocalService> wrapper;
	
	public static LocalService getInstance () {
		Wrapper<LocalService> w = wrapper;
        if (w == null) { // check 1
        	synchronized (LocalService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper<LocalService>(new LocalService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}
	
	@Override
	public void inserir(Local l, Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Local l, Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Local consultar(String codigoLocal, Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Local l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(Local l) throws SQLException {
		dao.inserir(l);
	}
	
}
