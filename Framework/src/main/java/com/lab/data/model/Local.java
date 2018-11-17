package com.lab.data.model;

public class Local {
	private Integer id;
	private String nome;
	private Integer latitude;
	private Integer longitude;
	
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
	public Integer getLatitude() {
		return latitude;
	}
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
	public Integer getLongitude() {
		return longitude;
	}
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	public Local(Integer id, String nome, Integer latitude, Integer longitude) {
		this.id = id;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
