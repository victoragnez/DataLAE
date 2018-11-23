package com.lab.data.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.data.model.AtividadeGeologia;

import framework.dao.DAOAtividade;

public class AtividadeGeologiaDAO extends DAOAtividade<AtividadeGeologia> {

	public AtividadeGeologiaDAO() { super(AtividadeGeologia.class); }
	
	@Override
	protected ArrayList<String> compInserir(ArrayList<String> sql, AtividadeGeologia a) {
		if (a.getDataTermino() == null)
			sql.add("dataTermino='" + a.getDataTermino() + "'");
		return sql;
	}

	@Override
	protected ArrayList<String> compRemover(ArrayList<String> sql, AtividadeGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> sql, AtividadeGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> sql, AtividadeGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected void getProjectWithFlexibleAttributes(ResultSet resultSet, AtividadeGeologia p) throws SQLException {
		Date dataTermino = resultSet.getDate("dataTermino");
		p.setDataTermino(dataTermino);
	}

}
