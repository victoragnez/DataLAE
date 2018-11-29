package com.lab.ae.dao;

import java.util.ArrayList;

import com.lab.ae.model.AreaAE;

import framework.dao.DAOArea;
import framework.model.MarcadoresDAO.CompAtualizar;
import framework.model.MarcadoresDAO.CompConsultar;
import framework.model.MarcadoresDAO.CompInserir;

public class AreaAEDAO extends DAOArea<AreaAE> {

	public AreaAEDAO(Class<AreaAE> classe) {
		super(classe);
	}
	
	@CompInserir
	@CompAtualizar
	@CompConsultar
	public ArrayList<String> camposComuns (ArrayList<String> campos, AreaAE a) {
		if(a.getIp() != null && a.getIp().length() != 0)
			campos.add("ip = '" + a.getIp() + "'");
		if(a.getEstaMontada() != null)
			campos.add("estaMontada = " + a.getEstaMontada());
		if(a.getObservacao() != null && a.getObservacao().length() != 0)
			campos.add("observacao = '" + a.getObservacao() + "'");
		return campos;
	}
	
	@CompInserir
	@CompAtualizar
	public ArrayList<String> inserirModelo (ArrayList<String> campos, AreaAE a) {
		if(a.getModelo() != null && a.getModelo().length() != 0)
			campos.add("modelo = '" + a.getModelo() + "'");
		return campos;
	}
	
	@CompConsultar
	public ArrayList<String> buscarModelo (ArrayList<String> campos, AreaAE a) {
		if(a.getModelo() != null && a.getModelo().length() != 0)
			campos.add("modelo like '%" + a.getModelo() + "%'");
		return campos;
	}
	
}
