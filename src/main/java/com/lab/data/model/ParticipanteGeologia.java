package com.lab.data.model;

import framework.model.Participante;

public class ParticipanteGeologia extends Participante {
	
	/* Atributos */
	private String cpf;
	private Categoria categoria;
	
	/* Contrutores */
	public ParticipanteGeologia() {
		/* Nothing */
	}
	
	public ParticipanteGeologia(Integer codigo, String nome,
			String instituicao, String email,
			String cpf, Categoria categoria)
	{
		super(codigo, nome, instituicao, email);
		this.cpf = cpf;
		this.categoria = categoria;
	}
	
	/* Getters e setters */
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
