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
	protected boolean validarInserir(ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarRemover(java.lang.String)
	 */
	@Override
	protected boolean validarRemover(ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarAtulizar(java.lang.String)
	 */
	@Override
	protected boolean validarAtulizar(ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarConsultar(java.lang.String)
	 */
	@Override
	protected boolean validarConsultar(ProjetoGeologia p) {
		// TODO Auto-generated method stub
		return false;
	}

}
