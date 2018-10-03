package DAO.Interfaces;

import Model.Local;

public interface ILocalDAO {

	public void inserir(Local l);
	public void remover(Local l);
	public Local consultar(String codigoLocal);
	public void alterar (Local l);
	
}
