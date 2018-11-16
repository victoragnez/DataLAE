package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ViagemDAO;
import DAO.Interfaces.IViagemDAO;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;
import Model.Viagem;
import Service.Interfaces.IViagemService;

public final class ViagemService implements IViagemService {

	private final IViagemDAO dao = new ViagemDAO();
	
	private ViagemService() {}
	
	private static Wrapper<ViagemService> wrapper;
	
	public static ViagemService getInstance () {
		Wrapper<ViagemService> w = wrapper;
        if (w == null) { // check 1
        	synchronized (ViagemService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper<ViagemService>(new ViagemService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}

	@Override
	public void inserir(Viagem v) throws SQLException {
		if (v == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (v.getDataInicio() == null || v.getDataTermino() == null)
			throw new IllegalArgumentException("Campo obrigatório nulo"); 
		
		dao.inserir(v);
	}

	@Override
	public void remover(Viagem v) throws SQLException {
		if (v == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (v.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar a viagem informada"); 
				
		dao.remover(v);
	}

	@Override
	public ArrayList<Viagem> listarViagens() throws SQLException {
		return dao.listarViagens();
	}

	@Override
	public ArrayList<Viagem> buscar(Viagem v, Pesquisador p, Projeto proj, Local l) throws SQLException {
		if (v == null && p == null && proj == null && l == null)
			return listarViagens();
		
		return dao.buscar(v, p, proj, l);
	}

	@Override
	public void alterar(Viagem v) {
		if (v == null)
			throw new IllegalArgumentException("Argumento nulo!"); 
		
		if (v.getCodigo() == null)
			throw new IllegalArgumentException("Impossível encontrar a viagem informada"); 
		
		dao.alterar(v);
	}

}
