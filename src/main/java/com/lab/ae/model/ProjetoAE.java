package com.lab.ae.model;

import framework.model.Projeto;

public class ProjetoAE extends Projeto<ParticipanteAE> {
	private String financiador;	

	/**
	 * @return the financiador
	 */
	public String getFinanciador() {
		return financiador;
	}

	/**
	 * @param financiador the financiador to set
	 */
	public void setFinanciador(String financiador) {
		this.financiador = financiador;
	}
}
