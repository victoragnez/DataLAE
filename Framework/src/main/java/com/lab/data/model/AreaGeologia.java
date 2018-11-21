package com.lab.data.model;

import framework.model.Area;

public class AreaGeologia extends Area{

	private Integer latitude;
	private Integer longitude;
	private String cidade;
    private String estado;
    private String pais;
	
	public AreaGeologia(String nome, Integer latitude, Integer longitude, String pais) {
		super(nome);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setPais(pais);
	}
	
	public AreaGeologia(String nome, String pais) {
		super(nome);
		this.setPais(pais);
	}
	
	public AreaGeologia(String nome, int latitude, int longitude, 
			String cidade, String estado, String pais)
	{
		super(nome);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setPais(pais);
		
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
