package Service.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Arquivo;
import Model.Projeto;
import Model.Viagem;

public interface IArquivoService {
	public void inserir(Arquivo arquivo) throws SQLException;
	public void remover(Arquivo arquivo) throws SQLException;
	public ArrayList<Arquivo> listarArquivos() throws SQLException;
	public ArrayList<Arquivo> buscar(Arquivo a, Projeto proj, Viagem v) throws SQLException;
	public void alterar(Arquivo arquivo) throws SQLException;
	
}
