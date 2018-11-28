package com.lab.estatistica.service;

import com.lab.estatistica.model.AreaEstatistica;

import framework.dao.interfaces.IDAOArea;
import framework.service.ServiceArea;

public class AreaEstatisticaService extends ServiceArea<AreaEstatistica> {

	public AreaEstatisticaService(IDAOArea<AreaEstatistica> dao) {
		super(dao);
	}
	
}
