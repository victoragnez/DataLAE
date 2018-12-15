package com.lab.data.service;

import com.lab.data.model.AreaGeologia;
import com.lab.data.model.ParticipanteGeologia;
import com.lab.data.model.PraticaGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.dao.interfaces.IDAOArea;
import framework.dao.interfaces.IDAOAtividade;
import framework.dao.interfaces.IDAOParticipante;
import framework.dao.interfaces.IDAOProjeto;
import framework.service.ServiceAtividade;

public class AtividadeGeologiaService extends 
		ServiceAtividade<AreaGeologia, ProjetoGeologia, PraticaGeologia, ParticipanteGeologia>
{
	public AtividadeGeologiaService(IDAOArea<AreaGeologia> daoArea, IDAOProjeto<ProjetoGeologia, ?> daoProjeto,
			IDAOAtividade<AreaGeologia, ProjetoGeologia, PraticaGeologia, ParticipanteGeologia> dao, 
			IDAOParticipante<ParticipanteGeologia> daoPart) {
		super(daoArea, daoProjeto, dao, daoPart);
	}
}
