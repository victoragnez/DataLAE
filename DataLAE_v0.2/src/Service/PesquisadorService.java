package Service;

import java.sql.SQLException;

import DAO.PesquisadorDAO;
import DAO.Interfaces.IPesquisadorDAO;
import Model.Pesquisador;
import Service.Interfaces.IPesquisadorService;

public final class PesquisadorService implements IPesquisadorService {

	private IPesquisadorDAO dao = new PesquisadorDAO();
	
	private PesquisadorService() {}

	public static PesquisadorService getInstance()
	{
		Wrapper w = wrapper;
        if (w == null) { // check 1
        	synchronized (PesquisadorService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper(new PesquisadorService());
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
	
	private static Wrapper wrapper;
	   
    private static class Wrapper{
        public final PesquisadorService instancia;
        public Wrapper(PesquisadorService service) {
            this.instancia = service;
        }
        public PesquisadorService getInstancia() {
            return instancia;
        }
    }

}
