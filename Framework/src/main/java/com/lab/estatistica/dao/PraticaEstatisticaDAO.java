package com.lab.estatistica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.estatistica.model.AreaEstatistica;
import com.lab.estatistica.model.PraticaEstatistica;
import com.lab.estatistica.model.ProjetoEstatistica;

import framework.dao.DAOAtividade;

public class PraticaEstatisticaDAO extends DAOAtividade<AreaEstatistica, ProjetoEstatistica, PraticaEstatistica> {

	public PraticaEstatisticaDAO(Class<AreaEstatistica> areaClass, Class<ProjetoEstatistica> projClass,
			Class<PraticaEstatistica> pratClass) {
		super(areaClass, projClass, pratClass);
	}

	@Override
	protected ArrayList<String> compInserir(ArrayList<String> sql, PraticaEstatistica a) {
		return sql;
	}

	@Override
	protected ArrayList<String> compRemover(ArrayList<String> sql, PraticaEstatistica a) {
		return sql;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> sql, PraticaEstatistica a) {
		return sql;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> sql, PraticaEstatistica a) {
		return sql;
	}

	@Override
	protected void getProjectWithFlexibleAttributes(ResultSet resultSet, PraticaEstatistica p) throws SQLException {
		/* nothing */
	}

}
