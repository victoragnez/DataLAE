package com.lab.estatistica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.estatistica.model.ParticipanteEstatistica;
import com.lab.estatistica.model.ProjetoEstatistica;

import framework.dao.DAOProjeto;

public class ProjetoEstatisticaDAO extends DAOProjeto<ProjetoEstatistica, ParticipanteEstatistica> {

	public ProjetoEstatisticaDAO(Class<ProjetoEstatistica> classe, Class<ParticipanteEstatistica> partClass) {
		super(classe, partClass);
	}

	@Override
	protected ArrayList<String> compInserir(ArrayList<String> campos, ProjetoEstatistica p) {
		if (p.getProfessor() != null)
			campos.add("professor='" + p.getProfessor() + "'");
		if (p.getOrgao() != null)
			campos.add("orgao='" + p.getOrgao() + "'");
		return campos;
	}

	@Override
	protected ArrayList<String> compRemover(ArrayList<String> campos, ProjetoEstatistica p) {
		return campos;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> campos, ProjetoEstatistica p) {
		if (p.getProfessor() != null)
			campos.add("professor='" + p.getProfessor() + "'");
		if (p.getOrgao() != null)
			campos.add("orgao='" + p.getOrgao() + "'");
		return campos;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> campos, ProjetoEstatistica p) {
		if (p.getProfessor() != null)
			campos.add("professor like '%" + p.getProfessor() + "%'");
		if (p.getOrgao() != null)
			campos.add("orgao like '%" + p.getOrgao() + "%'");
		return campos;
	}

	@Override
	protected void getProjectWithFlexibleAttributes(ResultSet resultSet, ProjetoEstatistica p) throws SQLException {
		p.setProfessor(resultSet.getString("professor"));
		p.setOrgao(resultSet.getString("orgao"));
	}

}
