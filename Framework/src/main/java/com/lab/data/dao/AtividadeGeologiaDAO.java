package com.lab.data.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.data.model.PraticaGeologia;

import framework.dao.DAOAtividade;

public class AtividadeGeologiaDAO extends DAOAtividade<PraticaGeologia> {

	public AtividadeGeologiaDAO() { super(PraticaGeologia.class); }

	@Override
	protected ArrayList<String> compInserir(ArrayList<String> sql, PraticaGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected ArrayList<String> compRemover(ArrayList<String> sql, PraticaGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> sql, PraticaGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> sql, PraticaGeologia a) {
		// TODO Auto-generated method stub
		return sql;
	}

	@Override
	protected void getProjectWithFlexibleAttributes(ResultSet resultSet, PraticaGeologia p) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
