package DAO.Interfaces;

import java.sql.SQLException;

import Model.Local;

public interface ILocalDAO {

	public void inserir(Local l) throws SQLException;
	public void remover(Local l);
	public Local consultar(String codigoLocal);
	public void alterar (Local l);
	
}
