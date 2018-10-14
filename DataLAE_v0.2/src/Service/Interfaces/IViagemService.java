package Service.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Local;
import Model.Pesquisador;
import Model.Projeto;
import Model.Viagem;

public interface IViagemService {

	public void inserir(Viagem v) throws SQLException;
	public void remover(Viagem v) throws SQLException;
	public ArrayList<Viagem> listarViagens() throws SQLException;
	public ArrayList<Viagem> buscar(Viagem v, Pesquisador p, Projeto proj, Local l) throws SQLException;
	public void alterar(Viagem v);
	
}
