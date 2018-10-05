package DAO.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Financiador;

public interface IFinanciadorDAO {

	public void inserir(Financiador f) throws SQLException;
	public void remover(Financiador f) throws SQLException;
	public ArrayList<Financiador> listarFinanciadores() throws SQLException;
	public void alterar (Financiador f);
	
}
