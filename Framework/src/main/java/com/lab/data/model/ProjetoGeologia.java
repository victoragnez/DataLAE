/**
 * 
 */
package com.lab.data.model;

import java.sql.Date;
import java.util.ArrayList;

import framework.model.Projeto;

/**
 * @author victoragnez
 *
 */
public class ProjetoGeologia extends Projeto<ParticipanteGeologia> {

	/* Atributos */
	private String financiador;
	private String contatoFinanciador;
	
	public ProjetoGeologia() {
		/* Nothing */
	}
	
	public ProjetoGeologia(Integer codigo, String nome, Date dataInicio,
			Date dataTermino, ArrayList<ParticipanteGeologia> participantes, 
			String financiador, String contatoFinanciador)
	{
		super(codigo, nome, dataInicio, dataTermino, participantes);
		this.financiador = financiador;
		this.contatoFinanciador = contatoFinanciador;
	}

	/* Getters e setters */
	public String getFinanciador() {
		return financiador;
	}

	public void setFinanciador(String financiador) {
		this.financiador = financiador;
	}
	
	public String getContatoFinanciador() {
		return contatoFinanciador;
	}

	public void setContatoFinanciador(String contatoFinanciador) {
		this.contatoFinanciador = contatoFinanciador;
	}
}
