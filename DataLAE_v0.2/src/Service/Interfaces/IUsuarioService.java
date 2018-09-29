package Service.Interfaces;

import Model.Usuario;

public interface IUsuarioService {

	public void inserir(Usuario user);
	public void remover(Usuario user);
	public Usuario consultar(String codigoUser);
	public void alterar(Usuario user);
	
}
