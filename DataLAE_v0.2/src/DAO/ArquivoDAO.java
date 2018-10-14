package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IArquivoDAO;
import Model.Arquivo;

public class ArquivoDAO implements IArquivoDAO {

	@Override
	public void inserir(Arquivo user) {
		System.out.println("Arquivo inserido!");
	}

	@Override
	public void remover(Arquivo user) {
		System.out.println("Arquivo removido!");		
	}

	@Override
	public void alterar(Arquivo user) {
		System.out.println("Arquivo editado!");
	}

	@Override
	public ArrayList<Arquivo> listarArquivos() throws SQLException {
		return new ArrayList<Arquivo>();
	}

	@Override
	public ArrayList<Arquivo> buscar() throws SQLException {
		return new ArrayList<Arquivo>();
	}

}
