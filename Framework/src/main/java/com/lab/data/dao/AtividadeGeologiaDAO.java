package com.lab.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.data.model.AreaGeologia;
import com.lab.data.model.ParticipanteGeologia;
import com.lab.data.model.PraticaGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.dao.DAOAtividade;

public class AtividadeGeologiaDAO extends DAOAtividade<AreaGeologia, ProjetoGeologia, PraticaGeologia, ParticipanteGeologia> {

	public AtividadeGeologiaDAO(Class<AreaGeologia> areaClass, Class<ProjetoGeologia> projClass,
			Class<PraticaGeologia> pratClass, Class<ParticipanteGeologia> partClass) {
		super(areaClass, projClass, pratClass, partClass);
	}

	@Override
	protected ArrayList<String> compInserir(ArrayList<String> sql, PraticaGeologia a) {
		return sql;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> sql, PraticaGeologia a) {
		return sql;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> sql, PraticaGeologia a) {
		return sql;
	}

	@Override
	protected void getProjectWithFlexibleAttributes(ResultSet resultSet, PraticaGeologia p) throws SQLException {
		/* Nothing */
	}
}
