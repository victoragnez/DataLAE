package Service.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Financiador;
import Model.Projeto;

public interface IFinanciadorService {

	public void inserir(Financiador f) throws SQLException;
	public void remover(Financiador f) throws SQLException;
	public ArrayList<Financiador> listarFinanciadores() throws SQLException;
	public ArrayList<Financiador> buscar(Financiador f, Projeto p) throws SQLException;
	public void alterar (Financiador f);
}
