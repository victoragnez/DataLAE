package DAO.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Projeto;

public interface IProjetoDAO {

	public void inserir(Projeto p) throws SQLException;
	public void remover(Projeto p);
	public ArrayList<Projeto> listarProjetos() throws SQLException;
	public void alterar(Projeto p);
	
}
