package com.lab.ae.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.ae.model.ParticipanteAE;

import framework.dao.DAOParticipante;

public class ParticipanteAEDAO extends DAOParticipante<ParticipanteAE> {

	public ParticipanteAEDAO(Class<ParticipanteAE> classe) {
		super(classe);
	}

	@Override
	protected ArrayList<String> compInserir(ArrayList<String> campos, ParticipanteAE p) {
		if(p.getLattes() != null && p.getLattes().length() != 0) {
			campos.add("lattes = '" + p.getLattes() + "'");
		}
		return campos;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> campos, ParticipanteAE p) {
		if(p.getLattes() != null && p.getLattes().length() != 0) {
			campos.add("lattes = '" + p.getLattes() + "'");
		}
		return campos;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> campos, ParticipanteAE p) {
		if(p.getLattes() != null && p.getLattes().length() != 0) {
			campos.add("lattes = '" + p.getLattes() + "'");
		}
		return campos;
	}

	@Override
	protected void getParticipanteWithFlexibleAttributes(ResultSet resultSet, ParticipanteAE p) throws SQLException {
		String lattes = resultSet.getString("lattes");
		p.setLattes(lattes);
	}

}
