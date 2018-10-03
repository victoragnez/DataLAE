package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IPesquisadorDAO;
import Model.Pesquisador;

public class PesquisadorDAO implements IPesquisadorDAO{

	public PesquisadorDAO() {}
	
	@Override
	public void inserir(Pesquisador p) throws SQLException {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(p.getCodigo() != null)
				campos.add("codigoPesquisador=" + p.getCodigo());
		
		if(p.getCpf() != null && p.getCpf().length() != 0)
			campos.add("cpfPesquisador='" + p.getCpf() + "'");
		
		if(p.getUniversidade() != null && p.getUniversidade().length() != 0)
			campos.add("universidade='" + p.getUniversidade() + "'");
		
		if(p.getNome() != null && p.getNome().length() != 0)
			campos.add("nome='" + p.getNome()+"'");
		
		if(campos.isEmpty()) /* nada para adicionar */
			return;
		
		String sql = "insert into Pesquisador set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
			else
				sql += ";";
		}
		
		JDBC.runInsert(sql);
		
	}

	@Override
	public void remover(Pesquisador p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pesquisador consultar(String codigoPesquisador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Pesquisador p) {
		// TODO Auto-generated method stub
		
	}

}
