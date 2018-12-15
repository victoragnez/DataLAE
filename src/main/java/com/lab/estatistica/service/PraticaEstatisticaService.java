package com.lab.estatistica.service;

import com.lab.estatistica.model.AreaEstatistica;
import com.lab.estatistica.model.PraticaEstatistica;
import com.lab.estatistica.model.ProjetoEstatistica;

import framework.dao.interfaces.IDAOArea;
import framework.dao.interfaces.IDAOAtividade;
import framework.dao.interfaces.IDAOProjeto;
import framework.service.ServiceAtividade;

public class PraticaEstatisticaService extends ServiceAtividade<AreaEstatistica, ProjetoEstatistica , PraticaEstatistica> {

	public PraticaEstatisticaService(IDAOArea<AreaEstatistica> daoArea, IDAOProjeto<ProjetoEstatistica, ?> daoProjeto,
			IDAOAtividade<AreaEstatistica, ProjetoEstatistica, PraticaEstatistica> dao) {
		super(daoArea, daoProjeto, dao);
	}

}
