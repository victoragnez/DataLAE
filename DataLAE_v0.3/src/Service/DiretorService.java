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
	public void inserir(Diretor d) throws SQLException {
		if (d == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (d.getNome() == null)
			throw new IllegalArgumentException("Campo obrigatório nulo!"); 
		
		dao.inserir(d);
	}

	@Override
	public void remover(Diretor d) throws SQLException {
		if (d == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (d.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar o Diretor informado"); 
	
		dao.remover(d);
	}

	@Override
	public ArrayList<Diretor> listarDiretores() throws SQLException {
		return dao.listarDiretores();
	}

	@Override
	public void alterar(Diretor d) {
		if (d == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (d.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar o Diretor informado"); 
		
		dao.alterar(d);
	}

}
