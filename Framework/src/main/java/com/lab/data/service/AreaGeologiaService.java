package com.lab.data.service;

import com.lab.data.model.AreaGeologia;

import framework.dao.interfaces.IDAOArea;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.service.ServiceArea;

public class AreaGeologiaService extends ServiceArea<AreaGeologia>{

	public AreaGeologiaService(IDAOArea<AreaGeologia> dao) {
		super(dao);
	}

	@ValidarInserir
	@ValidarAtualizar
	public void validarPais(AreaGeologia a) {
		if (a.getPais() == null || a.getPais().length() == 0)
			throw new IllegalArgumentException("País nulo");
	}
	
	@ValidarInserir
	@ValidarAtualizar
	public void validarCoordenadas (AreaGeologia a) {
		if ( a.getLatitude() == null || a.getLongitude() == null ||
				a.getLatitude() < -90.000001 || a.getLongitude() < -180.000001 ||
				a.getLatitude() > 90.000001 || a.getLongitude() > 180.000001
				)
			throw new IllegalArgumentException("Coordenadas Inválidas");;
	}
	
}
