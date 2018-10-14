package Service.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Local;
import Model.Pesquisador;
import Model.Projeto;

public interface ILocalService {

	public void inserir(Local l) throws SQLException;
	public void remover(Local l) throws SQLException;
	public ArrayList<Local> listarLocais() throws SQLException;
	public ArrayList<Local> buscar(Local l, Pesquisador p, Projeto proj) throws SQLException;
	public void alterar (Local l);
}
