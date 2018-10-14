package DAO.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Arquivo;

public interface IArquivoDAO {

	public void inserir(Arquivo user) throws SQLException;
	public void remover(Arquivo user) throws SQLException;
	public ArrayList<Arquivo> listarArquivos() throws SQLException;
	public ArrayList<Arquivo> buscar() throws SQLException;
	public void alterar(Arquivo user) throws SQLException;
	
}
