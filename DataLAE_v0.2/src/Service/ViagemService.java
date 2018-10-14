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
		dao.inserir(v);
	}

	@Override
	public void remover(Viagem v) throws SQLException {
		dao.remover(v);
	}

	@Override
	public ArrayList<Viagem> listarViagens() throws SQLException {
		return dao.listarViagens();
	}

	@Override
	public ArrayList<Viagem> buscar(Viagem v, Pesquisador p, Projeto proj, Local l) throws SQLException {
		return dao.buscar(v, p, proj, l);
	}

	@Override
	public void alterar(Viagem v) {
		dao.alterar(v);
	}

}
