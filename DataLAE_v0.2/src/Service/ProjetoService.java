package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ProjetoDAO;
import DAO.Interfaces.IProjetoDAO;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;
import Service.Interfaces.IProjetoService;

public final class ProjetoService implements IProjetoService{
	
	private final IProjetoDAO dao = new ProjetoDAO();
	
	private ProjetoService() {}
	
	private static Wrapper<ProjetoService> wrapper;
	
	public static ProjetoService getInstance () {
		Wrapper<ProjetoService> w = wrapper;
        if (w == null) { // check 1
        	synchronized (ProjetoService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper<ProjetoService>(new ProjetoService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}

	@Override
	public void inserir(Projeto p) throws SQLException{
		
		if ( p == null ) 
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (p.getNome() == null || p.getCoordenador() == null || p.getDataInicio() == null)
			throw new IllegalArgumentException("Campo obrigatório nulo!");
		
		dao.inserir(p);
	}

	@Override
	public void remover(Projeto p) throws SQLException {
		dao.remover(p);
	}

	@Override
	public ArrayList<Projeto> listarProjetos() throws SQLException {
		return dao.listarProjetos();
	}

	@Override
	public ArrayList<Projeto> buscar(Projeto proj, Pesquisador p, Local l) throws SQLException {
		return dao.buscar(proj, p, l);
	}

	@Override
	public void alterar(Projeto p) {
		dao.alterar(p);
	}

}
