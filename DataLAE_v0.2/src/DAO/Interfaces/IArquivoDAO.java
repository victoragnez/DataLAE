package DAO.Interfaces;

import Model.Arquivo;

public interface IArquivoDAO {

	public void inserir(Arquivo user);
	public void remover(Arquivo user);
	public Arquivo consultar(String codigoUser);
	public void alterar(Arquivo user);
	
}
