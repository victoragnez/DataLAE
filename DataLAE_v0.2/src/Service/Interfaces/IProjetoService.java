package Service.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Local;
import Model.Pesquisador;
import Model.Projeto;

public interface IProjetoService {

	public void inserir(Projeto p) throws SQLException;
	public void remover(Projeto p) throws SQLException;
	public ArrayList<Projeto> listarProjetos() throws SQLException;
	public ArrayList<Projeto> buscar(Projeto proj, Pesquisador p, Local l) 
			throws SQLException;
	public void alterar(Projeto p);
	
}
