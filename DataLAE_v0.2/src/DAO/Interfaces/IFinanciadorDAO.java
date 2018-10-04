package DAO.Interfaces;

import java.sql.SQLException;

import Model.Financiador;

public interface IFinanciadorDAO {

	public void inserir(Financiador f) throws SQLException;
	public void remover(Financiador f);
	public Financiador consultar(String codigoFinanciador);
	public void alterar (Financiador f);
	
}
