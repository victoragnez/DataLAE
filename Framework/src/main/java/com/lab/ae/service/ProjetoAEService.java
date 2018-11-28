package com.lab.ae.service;

import com.lab.ae.model.ParticipanteAE;
import com.lab.ae.model.ProjetoAE;

import framework.dao.interfaces.IDAOParticipante;
import framework.dao.interfaces.IDAOProjeto;
import framework.service.ServiceProjeto;

public class ProjetoAEService extends 
	ServiceProjeto<ProjetoAE, ParticipanteAE> {

	public ProjetoAEService(IDAOProjeto<ProjetoAE, ParticipanteAE> dao, 
			IDAOParticipante<ParticipanteAE> daoPart) {
		super(dao, daoPart);
	}

	@Override
	protected void validarInserir(ProjetoAE p) {
		if (p.getFinanciador() != null)
			throw new IllegalArgumentException("Campo Financiador nulo!");
		
	}

	@Override
	protected void validarRemover(ProjetoAE p) {	
	}

	@Override
	protected void validarAtulizar(ProjetoAE p) {
		if (p.getFinanciador() == null)
			throw new IllegalArgumentException("Campo Financiador nulo!");
	
	}

	@Override
	protected void validarConsultar(ProjetoAE p) {
		
	}

}
