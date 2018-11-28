package com.lab.estatistica.service;

import com.lab.estatistica.model.ParticipanteEstatistica;

import framework.dao.interfaces.IDAOParticipante;
import framework.service.ServiceParticipante;

public class ParticipanteEstatisticaService extends ServiceParticipante<ParticipanteEstatistica> {

	public ParticipanteEstatisticaService(IDAOParticipante<ParticipanteEstatistica> dao) {
		super(dao);
	}

	@Override
	protected void validarInserir(ParticipanteEstatistica p) {
		if(p.getCpf() == null || p.getCpf().length() == 0)
			throw new IllegalArgumentException("Cpf nulo!");
	}

	@Override
	protected void validarAtualizar(ParticipanteEstatistica p) {
		if(p.getCpf() == null || p.getCpf().length() == 0)
			throw new IllegalArgumentException("Cpf nulo!");
	}

	@Override
	protected void validarConsultar(ParticipanteEstatistica p) {
		/* nothing */
	}

}
