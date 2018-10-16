package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IArquivoDAO;
import Model.Arquivo;
import Model.Projeto;
import Model.Viagem;

public class ArquivoDAO implements IArquivoDAO {

	@Override
	public void inserir(Arquivo a) {
		System.out.println("Arquivo inserido!");
	}

	@Override
	public void remover(Arquivo a) {
		System.out.println("Arquivo removido!");		
	}

	@Override
	public void alterar(Arquivo a) {
		System.out.println("Arquivo editado!");
	}

	@Override
	public ArrayList<Arquivo> listarArquivos() throws SQLException {
		return new ArrayList<Arquivo>();
	}

	@Override
	public ArrayList<Arquivo> buscar(Arquivo a, Projeto proj, Viagem v) throws SQLException {
		return new ArrayList<Arquivo>();
	}

}
