package Service.Interfaces;


import Model.Pesquisador;

public interface IPesquisadorService {

	public void inserir(Pesquisador p);
	public void remover(Pesquisador p);
	public Pesquisador consultar(String codigoPesquisador);
	public void alterar (Pesquisador p);
	
}
