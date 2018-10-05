package Service.Interfaces;


import java.sql.SQLException;

import Model.Pesquisador;

public interface IPesquisadorService {

	public void inserir(Pesquisador p) throws SQLException;
	public void remover(Pesquisador p);
	public Pesquisador consultar(String codigoPesquisador);
	public void alterar (Pesquisador p);
	
}
