package Service;

import DAO.FinanciadorDAO;
import DAO.Interfaces.IFinanciadorDAO;
import Model.Financiador;
import Model.Projeto;
import Service.Interfaces.IFinanciadorService;

public final class FinanciadorService implements IFinanciadorService{

	private final IFinanciadorDAO dao = new FinanciadorDAO();

	private FinanciadorService () {};
	
	public static FinanciadorService getInstance () {
		Wrapper w = wrapper;
        if (w == null) { // check 1
        	synchronized (FinanciadorService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper(new FinanciadorService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}
	
	@Override
	public void inserir(Financiador f, Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Financiador f, Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Financiador consultar(String codigoFinanciador, Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Financiador f) {
		// TODO Auto-generated method stub
		
	}
	
	private static Wrapper wrapper;
	   
    private static class Wrapper{
        public final FinanciadorService instancia;
        public Wrapper(FinanciadorService service) {
            this.instancia = service;
        }
        public FinanciadorService getInstancia() {
            return instancia;
        }
    }

}
