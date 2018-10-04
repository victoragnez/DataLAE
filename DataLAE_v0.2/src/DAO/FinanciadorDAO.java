package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IFinanciadorDAO;
import Model.Financiador;

public class FinanciadorDAO implements IFinanciadorDAO{

	@Override
	public void inserir(Financiador f) throws SQLException {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(f.getCodigo() != null)
				campos.add("codigoFinanciador=" + f.getCodigo());
		
		if(f.getNome() != null && f.getNome().length() != 0)
			campos.add("nome='" + f.getNome() + "'");
		
		if(f.getCnpj() != null && f.getCnpj().length() != 0)
			campos.add("cnpj='" + f.getCnpj() + "'");
		
		String sql = "insert into Financiador set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		JDBC.runInsert(sql);
		
	}

	@Override
	public void remover(Financiador f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Financiador consultar(String codigoFinanciador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Financiador f) {
		// TODO Auto-generated method stub
		
	}

}
