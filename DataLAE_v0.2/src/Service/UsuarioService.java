package Service;

import DAO.UsuarioDAO;
import DAO.Interfaces.IUsuarioDAO;
import Model.Usuario;
import Service.Interfaces.IUsuarioService;

public final class UsuarioService implements IUsuarioService {

	private final IUsuarioDAO dao = new UsuarioDAO();
	
	private UsuarioService(){}
	
	private static Wrapper<UsuarioService> wrapper;
	
	public static UsuarioService getInstance () {
		Wrapper<UsuarioService> w = wrapper;
        if (w == null) { // check 1
        	synchronized (UsuarioService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper<UsuarioService>(new UsuarioService());
        			wrapper = w;
        		}
        	}
        }
        
        return w.getInstancia();
	}
	
	@Override
	public void inserir(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario consultar(String codigoUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Usuario user) {
		// TODO Auto-generated method stub
		
	}
	
}
