package com.lab.estatistica.service;

import com.lab.estatistica.model.AreaEstatistica;

import framework.dao.interfaces.IDAOArea;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.service.ServiceArea;

public class AreaEstatisticaService extends ServiceArea<AreaEstatistica> {

	public AreaEstatisticaService(IDAOArea<AreaEstatistica> dao) {
		super(dao);
	}
	
	@ValidarInserir
	@ValidarAtualizar
	public void verificaEstado(AreaEstatistica a) {
		if (a.getEstado() == null)
			throw new IllegalArgumentException("Estado nulo");
	}
	
}
