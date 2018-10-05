package DAO;

import java.sql.ResultSet;
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
		
		int id = JDBC.runInsert(sql);
		
		if(id == -1) {
			id = f.getCodigo();
		} else {
			f.setCodigo(id);
		}
		
	}

	@Override
	public void remover(Financiador f) throws SQLException {
		JDBC.runRemove("delete from Financiador where codigoFinanciador=" + f.getCodigo() + ";");		
	}

	@Override
	public ArrayList<Financiador> listarFinanciadores() throws SQLException {

		ArrayList<Financiador> retorno = new ArrayList<Financiador>();
		String sql = "select * from Financiador;";
		ResultSet resultSet = JDBC.runQuery(sql);

		while(resultSet.next()) {

			Integer codigo = (Integer)resultSet.getObject("codigoFinanciador");
			String nome = resultSet.getString("nome");
			String cnpj = resultSet.getString("cnpj");
			
			retorno.add(new Financiador(nome, cnpj, codigo));
			
		}
		return retorno;
	}

	@Override
	public void alterar(Financiador f) {
		// TODO Auto-generated method stub
		
	}

}
