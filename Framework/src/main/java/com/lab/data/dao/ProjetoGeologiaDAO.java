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

	@Override
	protected String compInserir(String sql, ProjetoGeologia p) {
		if(p.getContatoFinanciador() != null)
			sql += ", diretor='" + p.getContatoFinanciador() + "'";
		
		if(p.getFinanciador() != null)
			sql += ", financiador='" + p.getFinanciador() + "'";
		
		return sql;
	}

	@Override
	protected String compRemover(String sql, ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String compAtualizar(String sql, ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String compConsultar(String sql, ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ProjetoGeologia getProjectWithFlexibleAttributes(ResultSet resultSet) throws SQLException {
		ProjetoGeologia p = new ProjetoGeologia();
		String financiador = resultSet.getString("financiador");
		String contato = resultSet.getString("diretor");
		p.setContatoFinanciador(contato);
		p.setFinanciador(financiador);
		return p;
	}

}
