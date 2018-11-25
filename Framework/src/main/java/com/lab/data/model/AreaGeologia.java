package com.lab.data.model;

import framework.model.Area;

public class AreaGeologia extends Area {

	/* Atributos */
	private Double latitude;
	private Double longitude;
	private String cidade;
    private String estado;
    private String pais;
	
    /* Contrutores */
    public AreaGeologia() {
		/* Nothing */
	}
    
	public AreaGeologia(
			Integer codigo, 
			String nome, 
			Double latitude, 
			Double longitude,
			String cidade,
			String estado,
			String pais)
	{
		super(codigo, nome);
		this.latitude = latitude;
		this.longitude = longitude;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	
	/* Getters e setters */
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
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
