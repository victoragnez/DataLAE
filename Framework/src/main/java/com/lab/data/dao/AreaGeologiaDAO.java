package com.lab.data.dao;

import java.util.Locale;

import com.lab.data.model.AreaGeologia;

import framework.dao.DAOArea;
import framework.model.MarcadoresDAO.CompInserir;

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
	
}
