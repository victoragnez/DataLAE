package com.lab.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.data.model.Categoria;
import com.lab.data.model.ParticipanteGeologia;

import framework.dao.DAOParticipante;

public class ParticipanteGeologiaDAO extends DAOParticipante<ParticipanteGeologia>{

	public ParticipanteGeologiaDAO() { super(ParticipanteGeologia.class); }
	
	@Override
	protected ArrayList<String> compInserir(ArrayList<String> campos, ParticipanteGeologia p) {
		if (p.getCategoria() != null)
			campos.add("categoria='" + p.getCategoria() + "'");
		if (p.getCpf() != null)
			campos.add("cpfParticipante='" + p.getCpf() + "'");
		return campos;
	}

	@Override
	protected ArrayList<String> compAtualizar(ArrayList<String> campos, ParticipanteGeologia p) {
		if(p.getCpf() != null)
			campos.add("cpfParticipante='" + p.getCpf() + "'");
		if(p.getCategoria() != null)
			campos.add("categoria='" + p.getCategoria() + "'");	
		return campos;
	}

	@Override
	protected ArrayList<String> compConsultar(ArrayList<String> campos, ParticipanteGeologia p) {
		if(p.getCpf() != null)
			campos.add("cpfParticipante='" + p.getCpf() + "'");
		if(p.getCategoria() != null)
			campos.add("categoria='" + p.getCategoria() + "'");	
		return campos;
	}

	@Override
	protected void getParticipanteWithFlexibleAttributes(ResultSet resultSet, ParticipanteGeologia p) throws SQLException {
		try {
			p.setCategoria(Categoria.valueOf(resultSet.getString("categoria")));
		} catch (IllegalArgumentException | NullPointerException e) {
			p.setCategoria(null);
		}
		
		p.setCpf(resultSet.getString("cpfParticipante"));
	}	
}
