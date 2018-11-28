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
		if(a.getLocal() != null)
			campos.add("local = '" + a.getLocal() + "'");
		return campos;
	}
	
	@CompConsultar
	public ArrayList<String> consulta (ArrayList<String> campos, AreaEstatistica a) {
		if(a.getLocal() != null)
			campos.add("local like '%" + a.getLocal() + "%'");
		return campos;
	}
	
	@RecuperaResultado
	public void recuperaCidade(ResultSet resultSet, AreaEstatistica a) throws SQLException {
		String local = resultSet.getString("local");
		a.setLocal(local);
	}
}
