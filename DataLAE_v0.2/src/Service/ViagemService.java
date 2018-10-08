package Service;

import DAO.ViagemDAO;
import DAO.Interfaces.IViagemDAO;
import Model.Local;
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
	public void inserir(Viagem v, Local l, Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Viagem v, Local l, Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Viagem consultar(String codigoViagem, Local l, Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Viagem v, Local l, Projeto p) {
		// TODO Auto-generated method stub
		
	}
	
}
