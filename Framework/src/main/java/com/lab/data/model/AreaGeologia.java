package com.lab.data.model;

import framework.model.Area;

public class AreaGeologia extends Area{

	private int latitude;
	private int longitude;
	
	public AreaGeologia(String nome, int latitude, int longitude) {
		super(nome);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
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

}
