package Service.Interfaces;


import java.sql.SQLException;
import java.util.ArrayList;

import Model.Pesquisador;

public interface IPesquisadorService {

	public void inserir(Pesquisador p) throws SQLException;
	public void remover(Pesquisador p) throws SQLException;
	public ArrayList<Pesquisador> listarPesquisadores() throws SQLException;
	public ArrayList<Pesquisador> buscar() throws SQLException;
	public void alterar (Pesquisador p);
	
}
