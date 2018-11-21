package com.lab.data.model;

import framework.model.Participante;

public class ParticipanteGeologia extends Participante{

	private String formacao;
	
	public ParticipanteGeologia(String nome, String instituicao, String email, String formacao) {
		super(nome, instituicao, email);
		this.setFormacao(formacao);
	}
	
	public ParticipanteGeologia(String nome, String instituicao, String email, String formacao, Integer codigo) {
		super(nome, instituicao, email, codigo);
		this.setFormacao(formacao);
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

}
