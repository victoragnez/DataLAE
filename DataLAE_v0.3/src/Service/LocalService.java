package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LocalDAO;
import DAO.Interfaces.ILocalDAO;
import Model.Local;
import Model.Pesquisador;
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
	public void inserir(Local l) throws SQLException {
		if (l == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (l.getNome() == null)
			throw new IllegalArgumentException("Campo obrigatório nulo!"); 
		
		dao.inserir(l);
	}

	@Override
	public void remover(Local l) throws SQLException {
		if (l == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (l.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar o local informado"); 
		
		
		dao.remover(l);
	}

	@Override
	public ArrayList<Local> listarLocais() throws SQLException {
		return dao.listarLocais();
	}

	@Override
	public ArrayList<Local> buscar(Local l, Pesquisador p, Projeto proj) throws SQLException {
		return dao.buscar(l, p, proj);
	}

	@Override
	public void alterar(Local l) {
		if (l == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (l.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar o local informado"); 
		
		
		dao.alterar(l);
	}

}
