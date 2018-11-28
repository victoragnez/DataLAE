/**
 * 
 */
package com.lab.data.service;

import com.lab.data.model.ParticipanteGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.dao.interfaces.IDAOParticipante;
import framework.dao.interfaces.IDAOProjeto;
import framework.service.ServiceProjeto;

/**
 * @author victoragnez
 *
 */
public class ProjetoGeologiaService extends 
	ServiceProjeto<ProjetoGeologia, ParticipanteGeologia> {

	public ProjetoGeologiaService(IDAOProjeto<ProjetoGeologia, ParticipanteGeologia> dao,
			IDAOParticipante<ParticipanteGeologia> daoPart) {
		super(dao, daoPart);
	}

	@Override
	protected void validarInserir(ProjetoGeologia p) {
		if(p.getContatoFinanciador() == null || p.getFinanciador().length() == 0)
			throw new IllegalArgumentException("Contato nulo");
		if(p.getFinanciador() == null)
			throw new IllegalArgumentException("Financiador nulo");
	}

	@Override
	protected void validarAtulizar(ProjetoGeologia p) {
		if (p.getContatoFinanciador() == null || p.getContatoFinanciador().length() == 0)
			throw new IllegalArgumentException("Contato de Financiador nulo!");
		if (p.getFinanciador() == null)
			throw new IllegalArgumentException("Financiador nulo!");
	}

	@Override
	protected void validarConsultar(ProjetoGeologia p) {
		/* Nothing */
	}
}	
