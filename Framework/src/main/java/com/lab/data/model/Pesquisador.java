package com.lab.data.model;

@Deprecated
public class Pesquisador {
	private Integer id;
	private String nome;
	private String universidade;
	private String formacao;
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
	public String getUniversidade() {
		return universidade;
	}
	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public Pesquisador(Integer id, String nome, String universidade, String formacao) {
		this.id = id;
		this.nome = nome;
		this.universidade = universidade;
		this.formacao = formacao;
	}
}
