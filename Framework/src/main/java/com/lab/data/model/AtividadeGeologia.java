package com.lab.data.model;

import java.sql.Date;

import framework.model.Atividade;

public class AtividadeGeologia extends Atividade{

	private Date dataTermino;
	
	public AtividadeGeologia(Date dataIncio, Date dataTermino)
	{
		this.setData(dataIncio);
		this.setDataTermino(dataTermino);
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	
}
