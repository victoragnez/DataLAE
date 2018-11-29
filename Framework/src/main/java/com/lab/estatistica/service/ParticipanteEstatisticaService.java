package com.lab.estatistica.service;

import com.lab.estatistica.model.ParticipanteEstatistica;

import framework.dao.interfaces.IDAOParticipante;
import framework.model.BadAttributeException;
import framework.service.ServiceParticipante;

public class ParticipanteEstatisticaService extends ServiceParticipante<ParticipanteEstatistica> {

	public ParticipanteEstatisticaService(IDAOParticipante<ParticipanteEstatistica> dao) {
		super(dao);
	}

	@Override
	protected void validarInserir(ParticipanteEstatistica p) throws BadAttributeException {
		if(p.getCpf() == null || p.getCpf().length() == 0)
			throw new BadAttributeException("Cpf nulo!");
	}

	@Override
	protected void validarAtualizar(ParticipanteEstatistica p) throws BadAttributeException {
		if(p.getCpf() == null || p.getCpf().length() == 0)
			throw new BadAttributeException("Cpf nulo!");
	}

	@Override
	protected void validarConsultar(ParticipanteEstatistica p) {
		/* nothing */
	}

}
