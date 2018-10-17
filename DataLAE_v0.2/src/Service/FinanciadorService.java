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
		if (f == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (f.getNome() == null || f.getCnpj() == null)
			throw new IllegalArgumentException("Campo obrigatório nulo!");
		
		dao.inserir(f);
	}

	@Override
	public void remover(Financiador f) throws SQLException {
		if (f == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (f.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar o Financiador informado"); 
		
		dao.remover(f);
	}

	@Override
	public ArrayList<Financiador> listarFinanciadores() throws SQLException {
		return dao.listarFinanciadores();
	}

	@Override
	public ArrayList<Financiador> buscar(Financiador f, Projeto p) throws SQLException {	
		return dao.buscar(f, p);
	}

	@Override
	public void alterar(Financiador f) {
		if (f == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (f.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar o Financiador informado"); 
		
		dao.alterar(f);
	}
	


}
