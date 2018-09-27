package DAO.Interfaces;

import Model.Pesquisador;

public interface IPesquisadorDAO {

	public void inserir(Pesquisador p);
	public void remover(Pesquisador p);
	public Pesquisador consultar(String codigoPesquisador);
	public void alterar (Pesquisador p);
	
}
