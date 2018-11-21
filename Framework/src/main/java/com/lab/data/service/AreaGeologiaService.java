package com.lab.data.service;

import com.lab.data.model.AreaGeologia;

import framework.dao.interfaces.IDAOArea;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.service.ServiceArea;

public class AreaGeologiaService extends ServiceArea<AreaGeologia>{

	public AreaGeologiaService(IDAOArea<AreaGeologia> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@ValidarInserir
	@ValidarAtualizar
	public void validarPais(AreaGeologia a)
	{
		if (a.getPais() == null)
			throw new IllegalArgumentException("País nulo");
	}
	
	@ValidarInserir
	public void validarCoordenadas (AreaGeologia a)
	{
		if ( (a.getLatitude() == null) || (a.getLongitude() == null))
			throw new IllegalArgumentException("Coordenadas Inválidas");;
	}
}
