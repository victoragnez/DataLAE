package com.lab.data.model;

public class Projeto {
	private Integer id;
	private String nome;
	private String descricao;
	private String inicio;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public Projeto(Integer id, String nome, String descricao, String inicio) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.inicio = inicio;
	}
}