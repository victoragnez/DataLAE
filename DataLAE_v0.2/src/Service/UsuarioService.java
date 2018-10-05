package Service;

import Model.Usuario;
import Service.Interfaces.IUsuarioService;

public final class UsuarioService implements IUsuarioService {

	private UsuarioService(){}
	
	public UsuarioService getInstance() {
		Wrapper w = wrapper;
        if (w == null) { // check 1
        	synchronized (UsuarioService.class)
        	{
        		w = wrapper;
        		if (w == null) 
        		{ // check2
        			w = new Wrapper(new UsuarioService());
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
	
	private static Wrapper wrapper;
	   
    private static class Wrapper{
        public final UsuarioService instancia;
        public Wrapper(UsuarioService service) {
            this.instancia = service;
        }
        public UsuarioService getInstancia() {
            return instancia;
        }
    }

}
