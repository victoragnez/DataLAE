package com.lab.data.model.old;

@Deprecated
public class Viagem {
	private Integer id;
	private Projeto projeto;
	private Local local;
	private String inicio;
	private String fim;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
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
	public Viagem(Integer id, Projeto projeto, Local local, String inicio, String fim) {
		this.id = id;
		this.projeto = projeto;
		this.local = local;
		this.inicio = inicio;
		this.fim = fim;
	}
}
