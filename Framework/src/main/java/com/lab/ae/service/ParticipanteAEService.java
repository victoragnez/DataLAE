package com.lab.ae.service;

import com.lab.ae.model.ParticipanteAE;

import framework.dao.interfaces.IDAOParticipante;
import framework.service.ServiceParticipante;

public class ParticipanteAEService extends ServiceParticipante<ParticipanteAE>{

	public ParticipanteAEService(IDAOParticipante<ParticipanteAE> dao) {
		super(dao);
	}

	@Override
	protected void validarInserir(ParticipanteAE p) {	
	}

	@Override
	protected void validarAtualizar(ParticipanteAE p) {
	}

	@Override
	protected void validarConsultar(ParticipanteAE p) {	
	}

}
