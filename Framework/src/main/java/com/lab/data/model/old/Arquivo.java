package com.lab.data.model.old;

@Deprecated
public class Arquivo {
	private Integer id;
	private String nome;
	private byte[] dados;
	private String tipo;
	
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
	public Arquivo(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public byte[] getDados() {
		return dados;
	}
	public void setDados(byte[] dados) {
		this.dados = dados;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
