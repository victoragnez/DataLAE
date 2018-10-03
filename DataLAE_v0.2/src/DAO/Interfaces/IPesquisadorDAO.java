package DAO.Interfaces;

import DAO.Exceptions.CampoInvalidoException;
import Model.Pesquisador;

public interface IPesquisadorDAO {

	public void inserir(Pesquisador p) throws CampoInvalidoException;
	public void remover(Pesquisador p);
	public Pesquisador consultar(String codigoPesquisador);
	public void alterar (Pesquisador p);
	
}
