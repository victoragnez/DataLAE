package DAO.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Pesquisador;

public interface IPesquisadorDAO {

	public void inserir(Pesquisador p) throws SQLException;
	public void remover(Pesquisador p);
	public ArrayList<Pesquisador> listarPesquisadores() throws SQLException;
	public void alterar (Pesquisador p);
	
}
