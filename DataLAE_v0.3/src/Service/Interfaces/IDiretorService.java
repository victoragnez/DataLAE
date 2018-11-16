package Service.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Diretor;

public interface IDiretorService {

	public void inserir(Diretor f) throws SQLException;
	public void remover(Diretor f) throws SQLException;
	public ArrayList<Diretor> listarDiretores() throws SQLException;
	public void alterar (Diretor f);
}
