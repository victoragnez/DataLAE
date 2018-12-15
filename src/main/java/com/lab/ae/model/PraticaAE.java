package com.lab.ae.model;

import framework.model.Pratica;

public class PraticaAE extends Pratica<AreaAE, ParticipanteAE, ProjetoAE> {
	private String status;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
