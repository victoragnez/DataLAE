package com.lab.ae.service;

import com.lab.ae.model.AreaAE;
import com.lab.ae.model.PraticaAE;
import com.lab.ae.model.ProjetoAE;

import framework.dao.interfaces.IDAOArea;
import framework.dao.interfaces.IDAOAtividade;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.service.ServiceAtividade;

public class PraticaAEService extends 
	ServiceAtividade<AreaAE, ProjetoAE, PraticaAE> {

	public PraticaAEService(IDAOArea<AreaAE> daoArea, IDAOProjeto<ProjetoAE, ?> daoProjeto,
			IDAOAtividade<AreaAE, ProjetoAE, PraticaAE> dao) {
		super(daoArea, daoProjeto, dao);
	}
	
	@ValidarInserir
	@ValidarAtualizar
	public void validaFinanciador (PraticaAE a)	{
		if (a.getStatus() == null || a.getStatus().length() == 0)
			throw new IllegalArgumentException("É necessário definir o status dos Experimento");
	}

}
