package com.lab.ae.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.ae.model.ParticipanteAE;
import com.lab.ae.model.ProjetoAE;

import framework.dao.DAOProjeto;

public class ProjetoAEDAO extends DAOProjeto<ProjetoAE, ParticipanteAE> {

	public ProjetoAEDAO(Class<ProjetoAE> classe, Class<ParticipanteAE> partClass) {
		super(classe, partClass);
	}

	@Override
	protected ArrayList<String> compInserir(ArrayList<String> campos, ProjetoAE p) {
		if(p.getFinanciador() != null && p.getFinanciador().length() != 0) {
			campos.add("financiador = '" + p.getFinanciador() + "'");
		}
		return campos;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> campos, ProjetoAE p) {
		if(p.getFinanciador() != null && p.getFinanciador().length() != 0) {
			campos.add("financiador = '" + p.getFinanciador() + "'");
		}
		return campos;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> campos, ProjetoAE p) {
		if(p.getFinanciador() != null && p.getFinanciador().length() != 0) {
			campos.add("financiador like '%" + p.getFinanciador() + "%'");
		}
		return campos;
	}

	@Override
	protected void getProjectWithFlexibleAttributes(ResultSet resultSet, ProjetoAE p) throws SQLException {
		String financiador = resultSet.getString("financiador");
		p.setFinanciador(financiador);
	}
	
}
