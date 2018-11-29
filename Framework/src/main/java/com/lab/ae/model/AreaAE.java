package com.lab.ae.model;

import framework.model.Area;

public class AreaAE extends Area {
	private String ip;
	private String modelo;
	private Boolean estaMontada;
	private String observacao;
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}
	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	/**
	 * @return the estaMontada
	 */
	public Boolean getEstaMontada() {
		return estaMontada;
	}
	/**
	 * @param estaMontada the estaMontada to set
	 */
	public void setEstaMontada(Boolean estaMontada) {
		this.estaMontada = estaMontada;
	}
	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}
	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
