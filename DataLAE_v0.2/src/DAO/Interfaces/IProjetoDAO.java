package DAO.Interfaces;

import Model.Projeto;

public interface IProjetoDAO {

	public void inserir(Projeto p);
	public void remover(Projeto p);
	public Projeto consultar(String codigoProjeto);
	public void alterar(Projeto p);
	
}
