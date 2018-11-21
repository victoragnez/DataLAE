package com.lab.data.model;

import framework.model.Area;

public class AreaGeologia extends Area{

	private int latitude;
	private int longitude;
	private String cidade;
    private String estado;
    private String pais;
	
	public AreaGeologia(String nome, int latitude, int longitude) {
		super(nome);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
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
	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
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
