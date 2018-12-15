package com.lab.data.model;

import java.sql.Date;
import java.util.List;

import framework.model.Pratica;

public class PraticaGeologia extends Pratica<AreaGeologia, ParticipanteGeologia, ProjetoGeologia>{
	
	public PraticaGeologia() {
		/* Nothing */
	}

	public PraticaGeologia(
			Integer codigo,
			Date dataInicio,
			Date dataTermino, 
			AreaGeologia area,
			ProjetoGeologia projeto, 
			List<ParticipanteGeologia> participantes)
	{
		super(codigo, dataInicio, dataTermino, area, projeto, participantes);
	}
}
