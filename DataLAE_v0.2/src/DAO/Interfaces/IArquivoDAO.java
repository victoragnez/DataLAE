package DAO.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Arquivo;
import Model.Projeto;
import Model.Viagem;

public interface IArquivoDAO {

	public void inserir(Arquivo a) throws SQLException;
	public void remover(Arquivo a) throws SQLException;
	public ArrayList<Arquivo> listarArquivos() throws SQLException;
	public ArrayList<Arquivo> buscar(Arquivo a, Projeto proj, Viagem v) throws SQLException;
	public void alterar(Arquivo a) throws SQLException;
	
}
