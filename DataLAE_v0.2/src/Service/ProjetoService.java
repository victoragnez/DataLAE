package Service;

import java.sql.SQLException;

import DAO.ProjetoDAO;
import DAO.Interfaces.IProjetoDAO;
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
	public void remover(Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Projeto consultar(String codigoProjeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Projeto p) {
		// TODO Auto-generated method stub
		
	}

}
