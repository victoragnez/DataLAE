package DAO.Interfaces;

import java.sql.SQLException;

import DAO.Exceptions.CampoInvalidoException;
import Model.Pesquisador;

public interface IPesquisadorDAO {

	public void inserir(Pesquisador p) throws CampoInvalidoException, SQLException;
	public void remover(Pesquisador p);
	public Pesquisador consultar(String codigoPesquisador);
	public void alterar (Pesquisador p);
	
}
