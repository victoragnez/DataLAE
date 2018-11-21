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

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarInserir(java.lang.String)
	 */
	@Override
	protected void validarInserir(ProjetoGeologia p) {
		if(p.getContatoFinanciador() == null)
			throw new IllegalArgumentException("Contato nulo");
		if(p.getFinanciador() == null)
			throw new IllegalArgumentException("Financiador nulo");
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarRemover(java.lang.String)
	 */
	@Override
	protected void validarRemover(ProjetoGeologia p) {
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarAtulizar(java.lang.String)
	 */
	@Override
	protected void validarAtulizar(ProjetoGeologia p) {
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarConsultar(java.lang.String)
	 */
	@Override
	protected void validarConsultar(ProjetoGeologia p) {
	}
}
