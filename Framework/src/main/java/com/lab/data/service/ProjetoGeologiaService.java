/**
 * 
 */
package com.lab.data.service;

import com.lab.data.model.ParticipanteGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.dao.interfaces.IDAOParticipante;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.BadAttributeException;
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
	protected void validarInserir(ProjetoGeologia p) throws BadAttributeException {
		if(p.getContatoFinanciador() == null || p.getFinanciador().length() == 0)
			throw new BadAttributeException("Contato nulo");
		if(p.getFinanciador() == null)
			throw new BadAttributeException("Financiador nulo");
	}

	@Override
	protected void validarAtulizar(ProjetoGeologia p) throws BadAttributeException {
		if (p.getContatoFinanciador() == null || p.getContatoFinanciador().length() == 0)
			throw new BadAttributeException("Contato de Financiador nulo!");
		if (p.getFinanciador() == null)
			throw new BadAttributeException("Financiador nulo!");
	}

	@Override
	protected void validarConsultar(ProjetoGeologia p) {
		/* Nothing */
	}
}	
