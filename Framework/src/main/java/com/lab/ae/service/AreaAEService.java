package com.lab.ae.service;

import com.lab.ae.model.AreaAE;

import framework.dao.interfaces.IDAOArea;
import framework.model.BadAttributeException;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.service.ServiceArea;

public class AreaAEService extends ServiceArea<AreaAE> {

	public AreaAEService(IDAOArea<AreaAE> dao) {
		super(dao);
	}
	
	@ValidarInserir
	@ValidarAtualizar
	public void validaIP (AreaAE a) throws BadAttributeException{
		if (a.getIp() == null || a.getIp().length() == 0)
			throw new BadAttributeException("Campo IP nulo!");
	}
	
	@ValidarInserir
	@ValidarAtualizar
	public void validaModelo (AreaAE a) throws BadAttributeException {
		if (a.getModelo() == null || a.getModelo().length() == 0)
			throw new BadAttributeException("Campo Modelo nulo!");
	}
	
	@ValidarInserir
	@ValidarAtualizar
	public void validaEstaMontada (AreaAE a) throws BadAttributeException {
		if (a.getEstaMontada() == null)
			throw new BadAttributeException("É necessário informa se a máquina está montada ou não");
	}
	
}
