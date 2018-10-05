package Service;

import java.sql.SQLException;

import DAO.LocalDAO;
import DAO.Interfaces.ILocalDAO;
import Model.Local;
import Model.Projeto;
import Service.Interfaces.ILocalService;

public final class LocalService implements ILocalService {

	ILocalDAO dao = new LocalDAO();
	
	private LocalService () {}
	
	
	public LocalService getInstance ()
	{
		Wrapper w = wrapper;
        if (w == null) { // check 1
        	synchronized (LocalService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper(new LocalService());
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

	private static Wrapper wrapper;
	   
    private static class Wrapper{
        public final LocalService instancia;
        public Wrapper(LocalService service) {
            this.instancia = service;
        }
        public LocalService getInstancia() {
            return instancia;
        }
    }
	
}
