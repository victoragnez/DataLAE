package com.lab.data.dao;

import com.lab.data.model.AtividadeGeologia;

import framework.dao.DAOAtividade;

public class AtividadeGeologiaDAO extends DAOAtividade<AtividadeGeologia> {

	@Override
	protected String compInserir(String sql, AtividadeGeologia a) {
		if (a.getDataTermino() == null)
			sql += ", dataTermino='" + a.getDataTermino() + "'";
		return sql;
	}

	@Override
	protected String compRemover(String sql, AtividadeGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected String compAtualizar(String sql, AtividadeGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected String compConsultar(String sql, AtividadeGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

}
