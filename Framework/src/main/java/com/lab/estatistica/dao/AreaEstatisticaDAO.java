package com.lab.estatistica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lab.estatistica.model.AreaEstatistica;

import framework.dao.DAOArea;
import framework.model.MarcadoresDAO.CompAtualizar;
import framework.model.MarcadoresDAO.CompConsultar;
import framework.model.MarcadoresDAO.CompInserir;
import framework.model.MarcadoresDAO.RecuperaResultado;

public class AreaEstatisticaDAO extends DAOArea<AreaEstatistica> {

	public AreaEstatisticaDAO(Class<AreaEstatistica> classe) {
		super(classe);
	}
	
	@CompInserir
	@CompAtualizar
	public ArrayList<String> inserir (ArrayList<String> campos, AreaEstatistica a) {
		if(a.getCidade() != null)
			campos.add("cidade = '" + a.getCidade() + "'");
		if(a.getEstado() != null)
			campos.add("estado = '" + a.getEstado() + "'");
		return campos;
	}
	
	@CompConsultar
	public ArrayList<String> consulta (ArrayList<String> campos, AreaEstatistica a) {
		if(a.getCidade() != null)
			campos.add("cidade like '%" + a.getCidade() + "%'");
		if(a.getEstado() != null)
			campos.add("estado like '%" + a.getEstado() + "%'");
		return campos;
	}
	
	@RecuperaResultado
	public void recuperaCidade(ResultSet resultSet, AreaEstatistica a) throws SQLException {
		String cidade = resultSet.getString("cidade");
		String estado = resultSet.getString("estado");
		a.setCidade(cidade);
		a.setEstado(estado);
	}
}
