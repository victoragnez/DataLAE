package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Interfaces.IDiretorDAO;
import Model.Diretor;

public class DiretorDAO implements IDiretorDAO {

	public void inserir(Diretor d) throws SQLException {
		
		ArrayList<String> campos = new ArrayList<String>();
		
		if(d.getCodigo() != null)
				campos.add("codigoDiretor=" + d.getCodigo());
		
		if(d.getNome() != null && d.getNome().length() != 0)
			campos.add("nome='" + d.getNome() + "'");
		
		if(d.getEmail() != null && d.getEmail().length() != 0)
			campos.add("email='" + d.getEmail() + "'");
		
		if(d.getTelefone() != null && d.getTelefone().length() != 0)
			campos.add("telefone='" + d.getTelefone()+"'");
		
		if(d.getCargo() != null && d.getCargo().length() != 0)
			campos.add("cargo='" + d.getCargo()+"'");
		
		String sql = "insert into Diretor set ";
		for(int i = 0; i < campos.size(); i++) {
			sql += campos.get(i);
			if(i+1 < campos.size())
				sql += ", ";
		}
		sql += ";";
		
		int id = JDBC.runInsert(sql);
		
		if(id == -1) {
			id = d.getCodigo();
		} else {
			d.setCodigo(id);
		}
		
	}

	public void remover(Diretor d) {
		// TODO Auto-generated method stub
		
	}
	
	public Diretor consultar(String codigoFinanciador) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void alterar(Diretor d) {
		// TODO Auto-generated method stub
		
	}

}
