/**
 * 
 */
package com.lab.data.service;

import framework.dao.interfaces.IDAOProjeto;
import framework.service.ServiceProjeto;

/**
 * @author victoragnez
 *
 */
public class ProjetoGeologiaService extends ServiceProjeto {

	public ProjetoGeologiaService(IDAOProjeto dao) {
		super(dao);
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarInserir(java.lang.String)
	 */
	@Override
	protected boolean validarInserir(String command) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarRemover(java.lang.String)
	 */
	@Override
	protected boolean validarRemover(String command) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarAtulizar(java.lang.String)
	 */
	@Override
	protected boolean validarAtulizar(String command) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see framework.service.ServiceProjeto#validarConsultar(java.lang.String)
	 */
	@Override
	protected boolean validarConsultar(String command) {
		// TODO Auto-generated method stub
		return false;
	}

}
