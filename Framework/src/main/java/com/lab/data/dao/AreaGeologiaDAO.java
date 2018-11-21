package com.lab.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import com.lab.data.model.AreaGeologia;

import framework.dao.DAOArea;
import framework.model.MarcadoresDAO.CompInserir;
import framework.model.MarcadoresDAO.RecuperaResultado;

public class AreaGeologiaDAO extends DAOArea<AreaGeologia>{

	public AreaGeologiaDAO() { super(AreaGeologia.class); }
	
	@CompInserir
	public String inserir (String sql, AreaGeologia a)
	{
		if(a.getCidade() != null)
			sql += ", cidade='" + a.getCidade() + "'";
		if (a.getEstado() != null)
			sql += ", estado='" + a.getEstado() + "'";
		if (a.getPais() != null)
			sql += ", pais='" + a.getPais() + "'";
		if(a.getLatitude() != null && a.getLongitude() != null && 
				Double.isFinite(a.getLatitude()) && Double.isFinite(a.getLongitude()))
			sql += ", coordenadas=point(" + 
				String.format(Locale.US, "%.8f", a.getLatitude()) + ", " + 
				String.format(Locale.US, "%.8f", a.getLongitude()) + ")";
		
		return sql;
	}
	
	
	
	@RecuperaResultado
	public void recuperaCidade(ResultSet resultSet, AreaGeologia a) throws SQLException {
		String cidade = resultSet.getString("cidade");
		a.setCidade(cidade);
	}
	
	@RecuperaResultado
	public void recuperaEstado(ResultSet resultSet, AreaGeologia a) throws SQLException {
		String estado = resultSet.getString("estado");
		a.setEstado(estado);
	}
	
	@RecuperaResultado
	public void recuperaPais(ResultSet resultSet, AreaGeologia a) throws SQLException {
		String pais = resultSet.getString("pais");
		a.setPais(pais);
	}
	
	@RecuperaResultado
	public void recuperaCoordenadas(ResultSet resultSet, AreaGeologia a) throws SQLException {
		Double latitude, longitude;
		
		latitude = resultSet.getDouble("latitude");
		longitude = resultSet.getDouble("longitude");
		
		a.setLatitude(latitude);
		a.setLongitude(longitude);
	}
}
