/**
 * 
 */
package com.lab.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.data.model.ParticipanteGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.dao.DAOProjeto;

/**
 * @author victoragnez
 *
 */
public class ProjetoGeologiaDAO extends DAOProjeto<ProjetoGeologia, ParticipanteGeologia> {

	public ProjetoGeologiaDAO() { super(ProjetoGeologia.class, ParticipanteGeologia.class); }
	
	@Override
	protected ArrayList<String> compInserir(ArrayList<String> campos, ProjetoGeologia p) {
		if(p.getContatoFinanciador() != null)
			campos.add("contato='" + p.getContatoFinanciador() + "'");
		
		if(p.getFinanciador() != null)
			campos.add("financiador='" + p.getFinanciador() + "'");
		
		return campos;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> campos, ProjetoGeologia p) {
		if (p.getFinanciador() != null)
			campos.add("financiador='" + p.getFinanciador() + "'");
		if (p.getContatoFinanciador() != null)
			 campos.add("contato='" + p.getContatoFinanciador() + "'");
			
		return campos;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> campos, ProjetoGeologia p) {
		if (p.getFinanciador() != null)
			campos.add("financiador like '%" + p.getFinanciador() + "%'"); 
		if (p.getContatoFinanciador() != null)
			campos.add("contato='" + p.getContatoFinanciador() + "'");
			
		return campos;
	}

	@Override
	protected void getProjectWithFlexibleAttributes(ResultSet resultSet, ProjetoGeologia p) throws SQLException {
		String financiador = resultSet.getString("financiador");
		String contato = resultSet.getString("contato");
		p.setContatoFinanciador(contato);
		p.setFinanciador(financiador);
	}

}
