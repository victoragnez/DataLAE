package DAO.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Local;

public interface ILocalDAO {

	public void inserir(Local l) throws SQLException;
	public void remover(Local l);
	public ArrayList<Local> listarLocais() throws SQLException;
	public void alterar (Local l);
	
}
