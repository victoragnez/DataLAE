package Service.Interfaces;

import Model.Projeto;

public interface IProjetoService {

	public void inserir(Projeto p);
	public void remover(Projeto p);
	public Projeto consultar(String codigoProjeto);
	public void alterar(Projeto p);
	
}
