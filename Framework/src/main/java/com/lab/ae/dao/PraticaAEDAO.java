package com.lab.ae.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.ae.model.AreaAE;
import com.lab.ae.model.PraticaAE;
import com.lab.ae.model.ProjetoAE;

import framework.dao.DAOAtividade;

public class PraticaAEDAO extends DAOAtividade<AreaAE, ProjetoAE, PraticaAE> {

	public PraticaAEDAO(Class<AreaAE> areaClass, Class<ProjetoAE> projClass, Class<PraticaAE> pratClass) {
		super(areaClass, projClass, pratClass);
	}

	@Override
	protected ArrayList<String> compInserir(ArrayList<String> campos, PraticaAE a) {
		if(a.getStatus() != null && a.getStatus().length() != 0) {
			campos.add("status = '" + a.getStatus() + "'");
		}
		return campos;
	}

	@Override
	protected ArrayList<String> compRemover(ArrayList<String> campos, PraticaAE a) {
		return campos;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> campos, PraticaAE a) {
		if(a.getStatus() != null && a.getStatus().length() != 0) {
			campos.add("status = '" + a.getStatus() + "'");
		}
		return campos;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> campos, PraticaAE a) {
		if(a.getStatus() != null && a.getStatus().length() != 0) {
			campos.add("status = '" + a.getStatus() + "'");
		}
		return campos;
	}

	@Override
	protected void getProjectWithFlexibleAttributes(ResultSet resultSet, PraticaAE p) throws SQLException {
		String status = resultSet.getString("status");
		p.setStatus(status);
	}

}
