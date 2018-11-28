package com.lab.estatistica.service;

import com.lab.estatistica.model.ParticipanteEstatistica;
import com.lab.estatistica.model.ProjetoEstatistica;

import framework.dao.interfaces.IDAOParticipante;
import framework.dao.interfaces.IDAOProjeto;
import framework.service.ServiceProjeto;

public class ProjetoEstatisticaService extends ServiceProjeto<ProjetoEstatistica, ParticipanteEstatistica> {

	public ProjetoEstatisticaService(IDAOProjeto<ProjetoEstatistica, ParticipanteEstatistica> dao,
			IDAOParticipante<ParticipanteEstatistica> daoPart) {
		super(dao, daoPart);
	}

	@Override
	protected void validarInserir(ProjetoEstatistica p) {
		if(p.getProfessor() == null || p.getProfessor().length() == 0)
			throw new IllegalArgumentException("Professor do projeto nulo!");
	}

	@Override
	protected void validarAtulizar(ProjetoEstatistica p) {
		if(p.getProfessor() == null || p.getProfessor().length() == 0)
			throw new IllegalArgumentException("Professor do projeto nulo!");
	}

	@Override
	protected void validarConsultar(ProjetoEstatistica p) {
		/* nothing */
	}

}
