package com.lab.data.model;

public abstract class Area {

	private String nome;
	private Integer codigo;
	
	public Area(String nome, Integer codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public Area(String nome) {
		super();
		this.nome = nome;
	}

	/** Getters and Setters */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
