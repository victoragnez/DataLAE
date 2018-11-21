/**
 * 
 */
package com.lab.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lab.data.model.ProjetoGeologia;

import framework.dao.DAOProjeto;

/**
 * @author victoragnez
 *
 */
public class ProjetoGeologiaDAO extends DAOProjeto<ProjetoGeologia> {

	public ProjetoGeologiaDAO() { super(ProjetoGeologia.class); }
	
	@Override
	protected String compInserir(String sql, ProjetoGeologia p) {
		if(p.getContatoFinanciador() != null)
			sql += ", contato='" + p.getContatoFinanciador() + "'";
		
		if(p.getFinanciador() != null)
			sql += ", financiador='" + p.getFinanciador() + "'";
		
		return sql;
	}

	@Override
	protected String compRemover(String sql, ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected String compAtualizar(String sql, ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected String compConsultar(String sql, ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected void getProjectWithFlexibleAttributes(ResultSet resultSet, ProjetoGeologia p) throws SQLException {
		String financiador = resultSet.getString("financiador");
		String contato = resultSet.getString("contato");
		p.setContatoFinanciador(contato);
		p.setFinanciador(financiador);
	}

}
