package DAO.Interfaces;

import Model.Financiador;
import Model.Projeto;

public interface IFinanciadorDAO {

	public void inserir(Financiador f, Projeto p);
	public void remover(Financiador f, Projeto p);
	public Financiador consultar(String codigoFinanciador, Projeto p);
	public void alterar (Financiador f);
	
}
