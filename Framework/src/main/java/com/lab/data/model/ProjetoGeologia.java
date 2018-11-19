/**
 * 
 */
package com.lab.data.model;

import java.sql.Date;
import java.util.ArrayList;

import framework.model.Participante;
import framework.model.Projeto;

/**
 * @author victoragnez
 *
 */
public class ProjetoGeologia extends Projeto {

	private String financiador;
	private String contatoFinanciador;
	
	public ProjetoGeologia() {
		
	}
	
	public ProjetoGeologia(String nome, ArrayList<Participante> participantes, 
			Date dataInicio, Date dataFim, String financiador, String contatoFinanciador) {
		super(nome, participantes, dataInicio);
		this.setFinanciador(financiador);
		this.setContatoFinanciador(contatoFinanciador);
	}

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

	/**
	 * @return the contatoFinanciador
	 */
	public String getContatoFinanciador() {
		return contatoFinanciador;
	}

	/**
	 * @param contatoFinanciador the contatoFinanciador to set
	 */
	public void setContatoFinanciador(String contatoFinanciador) {
		this.contatoFinanciador = contatoFinanciador;
	}

}
