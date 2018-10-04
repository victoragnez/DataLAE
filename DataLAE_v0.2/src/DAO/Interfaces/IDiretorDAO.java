package DAO.Interfaces;

import java.sql.SQLException;

import Model.Diretor;

public interface IDiretorDAO {

	public void inserir(Diretor f) throws SQLException;
	public void remover(Diretor f);
	public Diretor consultar(String codigoFinanciador);
	public void alterar (Diretor f);
	
}
