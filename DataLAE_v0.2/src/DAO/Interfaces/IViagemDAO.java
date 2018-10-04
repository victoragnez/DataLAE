package DAO.Interfaces;

import java.sql.SQLException;

import Model.Viagem;

public interface IViagemDAO {

	public void inserir(Viagem v) throws SQLException;
	public void remover(Viagem v);
	public Viagem consultar(String codigoViagem);
	public void alterar(Viagem v);
	
}
