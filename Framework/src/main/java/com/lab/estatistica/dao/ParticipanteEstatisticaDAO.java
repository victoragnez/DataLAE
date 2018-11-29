package com.lab.estatistica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.estatistica.model.ParticipanteEstatistica;

import framework.dao.DAOParticipante;

public class ParticipanteEstatisticaDAO extends DAOParticipante<ParticipanteEstatistica> {

	public ParticipanteEstatisticaDAO(Class<ParticipanteEstatistica> classe) {
		super(classe);
	}

	@Override
	protected ArrayList<String> compInserir(ArrayList<String> campos, ParticipanteEstatistica p) {
		if(p.getCpf() != null)
			campos.add("cpf = '" + p.getCpf() + "'");
		return campos;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> campos, ParticipanteEstatistica p) {
		if(p.getCpf() != null)
			campos.add("cpf = '" + p.getCpf() + "'");
		return campos;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> campos, ParticipanteEstatistica p) {
		if(p.getCpf() != null)
			campos.add("cpf = '" + p.getCpf() + "'");
		return campos;
	}

	@Override
	protected void getParticipanteWithFlexibleAttributes(ResultSet resultSet, ParticipanteEstatistica p)
			throws SQLException {
		p.setCpf(resultSet.getString("cpf"));
	}
	
}
