package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IProjetoDAO;
import Model.Projeto;

public class ProjetoDAO  implements IProjetoDAO{

	@Override
	public void inserir(Projeto p) throws SQLException {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(p.getCodigo() != null)
				campos.add("codigoProjeto=" + p.getCodigo());
		
		if(p.getNome() != null && p.getNome().length() != 0)
			campos.add("nome='" + p.getNome()+"'");
		
		if(p.getSigla() != null && p.getSigla().length() != 0)
			campos.add("sigla='" + p.getSigla()+"'");
		
		if(p.getCoordenador() != null && p.getCoordenador().length() != 0)
			campos.add("nomeCoordenador='" + p.getCoordenador() + "'");
		
		if(p.getDataInicio() != null)
			campos.add("dataInicio='" + p.getDataInicio().toString() + "'");
		
		if(p.getDataTermino() != null)
			campos.add("dataTermino='" + p.getDataTermino().toString() + "'");
		
		if(campos.isEmpty()) /* nada para adicionar */
			return;
		
		String sql = "insert into Projeto set ";
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
	public void remover(Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Projeto consultar(String codigoProjeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Projeto p) {
		// TODO Auto-generated method stub
		
	}

}
