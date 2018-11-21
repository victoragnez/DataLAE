package com.lab.data.service;

import com.lab.data.model.ParticipanteGeologia;

import framework.dao.interfaces.IDAOParticipante;
import framework.service.ServiceParticipante;

public class ParticipanteGeologiaService extends ServiceParticipante<ParticipanteGeologia>{

	public ParticipanteGeologiaService(IDAOParticipante<ParticipanteGeologia> dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void validarInserir(ParticipanteGeologia p) {
		if (p.getCategoria() == null)
			throw new IllegalArgumentException("Categoria nulo!");

	}

	@Override
	protected void validarRemover(ParticipanteGeologia p) {
		// TODO Auto-generated method stub			
	}

	@Override
	protected void validarAtualizar(ParticipanteGeologia p) {
		if (p.getCategoria() == null)
			throw new IllegalArgumentException("Categoria nulo!");
		
	}

	@Override
	protected void validarConsultar(ParticipanteGeologia p) {
		// TODO Auto-generated method stub
	}

}
