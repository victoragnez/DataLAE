package Service.Interfaces;

import java.sql.SQLException;

import Model.Projeto;

public interface IProjetoService {

	public void inserir(Projeto p) throws SQLException;
	public void remover(Projeto p);
	public Projeto consultar(String codigoProjeto);
	public void alterar(Projeto p);
	
}
