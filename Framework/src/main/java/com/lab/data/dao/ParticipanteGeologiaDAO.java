package com.lab.data.dao;

import com.lab.data.model.ParticipanteGeologia;

import framework.dao.DAOParticipante;

public class ParticipanteGeologiaDAO extends DAOParticipante<ParticipanteGeologia>{

	public ParticipanteGeologiaDAO() { super(ParticipanteGeologia.class); }
	
	@Override
	protected String compInserir(String sql, ParticipanteGeologia p) {
		if (p.getCategoria() != null)
			sql += ", categoria='" + p.getCategoria() + "'";
		if (p.getCpf() != null)
			sql += ", cpf='" + p.getCpf() + "'";
					
		return sql;
	}

	@Override
	protected String compRemover(String sql, ParticipanteGeologia p) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected String compAtualizar(String sql, ParticipanteGeologia p) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected String compConsultar(String sql, ParticipanteGeologia p) {
		// TODO Auto-generated method stub
		return sql;
	}

}
