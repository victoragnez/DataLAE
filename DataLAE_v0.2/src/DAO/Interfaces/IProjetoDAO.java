package DAO.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Financiador;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;

public interface IProjetoDAO {

	public void inserir(Projeto p) throws SQLException;
	public void remover(Projeto p) throws SQLException;
	public ArrayList<Projeto> listarProjetos() throws SQLException;
	public ArrayList<Projeto> buscar(Projeto proj, Financiador f, Pesquisador p, Local l) 
			throws SQLException;
	public void alterar(Projeto p);
	
}
