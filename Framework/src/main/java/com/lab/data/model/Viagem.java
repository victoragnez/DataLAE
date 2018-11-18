package com.lab.data.model;

public class Viagem {
	private Integer id;
	private Integer projetoId;
	private Local local;
	private String inicio;
	private String fim;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProjetoId() {
		return projetoId;
	}
	public void setProjetoId(Integer projetoId) {
		this.projetoId = projetoId;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public Viagem(Integer id, Integer projetoId, Local local, String inicio, String fim) {
		this.id = id;
		this.projetoId = projetoId;
		this.local = local;
		this.inicio = inicio;
		this.fim = fim;
	}
}
