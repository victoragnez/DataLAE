package com.lab.ae.service;

import com.lab.ae.model.AreaAE;

import framework.dao.interfaces.IDAOArea;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.service.ServiceArea;

public class AreaAEService extends ServiceArea<AreaAE> {

	public AreaAEService(IDAOArea<AreaAE> dao) {
		super(dao);
	}
	
	@ValidarInserir
	@ValidarAtualizar
	public void validaIP (AreaAE a){
		if (a.getIp() == null)
			throw new IllegalArgumentException("Campo IP nulo!");
	}
	
	@ValidarInserir
	@ValidarAtualizar
	public void validaModelo (AreaAE a) {
		if (a.getModelo() == null)
			throw new IllegalArgumentException("Campo Modelo nulo!");
	}
	
	@ValidarInserir
	@ValidarAtualizar
	public void validaEstaMontada (AreaAE a) {
		if (a.getEstaMontada() == null)
			throw new IllegalArgumentException("É necessário informa se a máquina está montada ou não");
	}
	
}
