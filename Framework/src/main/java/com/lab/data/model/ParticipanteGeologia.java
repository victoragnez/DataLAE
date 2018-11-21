package com.lab.data.model;

import framework.model.Participante;

public class ParticipanteGeologia extends Participante{
	
	private String cpf;
	private Categoria categoria;
	
	public ParticipanteGeologia(String nome, String instituicao, String email,
			Categoria categoria) {
		super(nome, instituicao, email);
		this.categoria = categoria;
	}
	
	public ParticipanteGeologia(String nome, String instituicao, String email,
			Categoria categoria, String cpf) {
		super(nome, instituicao, email);
		this.categoria = categoria;
		this.cpf = cpf;
	}
	
	public ParticipanteGeologia(String nome, String instituicao, String email,
			String cpf, Categoria categoria, Integer codigo) {
		super(nome, instituicao, email, codigo);
		this.cpf = cpf;
		this.categoria = categoria;
	}
	
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
