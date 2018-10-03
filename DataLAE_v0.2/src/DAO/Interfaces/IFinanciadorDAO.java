package DAO.Interfaces;

import Model.Financiador;

public interface IFinanciadorDAO {

	public void inserir(Financiador f);
	public void remover(Financiador f);
	public Financiador consultar(String codigoFinanciador);
	public void alterar (Financiador f);
	
}
