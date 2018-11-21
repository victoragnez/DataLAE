/**
 * 
 */
package com.lab.data.service;

import com.lab.data.model.ProjetoGeologia;

import framework.dao.interfaces.IDAOProjeto;
import framework.service.ServiceProjeto;

/**
 * @author victoragnez
 *
 */
public class ProjetoGeologiaService extends ServiceProjeto<ProjetoGeologia> {

	public ProjetoGeologiaService(IDAOProjeto<ProjetoGeologia> dao) {
		super(dao);
	}

	@Override
	protected void validarInserir(ProjetoGeologia p) {
		if(p.getContatoFinanciador() == null)
			throw new IllegalArgumentException("Contato nulo");
		if(p.getFinanciador() == null)
			throw new IllegalArgumentException("Financiador nulo");
	}

	protected void validarRemover(ProjetoGeologia p) {
		/* Nothing */
	}

	@Override
	protected void validarAtulizar(ProjetoGeologia p) {
		if (p.getContatoFinanciador() == null)
			throw new IllegalArgumentException("Contato de Financiador nulo!");
		if (p.getFinanciador() == null)
			throw new IllegalArgumentException("Financiador nulo!");
	}

	@Override
	protected void validarConsultar(ProjetoGeologia p) {
		/* Nothing */
	}
}	
