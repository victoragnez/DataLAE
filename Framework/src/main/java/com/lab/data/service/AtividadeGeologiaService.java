package com.lab.data.service;

import com.lab.data.model.AreaGeologia;
import com.lab.data.model.PraticaGeologia;
import com.lab.data.model.ProjetoGeologia;

import framework.dao.interfaces.IDAOArea;
import framework.dao.interfaces.IDAOAtividade;
import framework.dao.interfaces.IDAOProjeto;
import framework.service.ServiceAtividade;

public class AtividadeGeologiaService extends 
		ServiceAtividade<AreaGeologia, ProjetoGeologia, PraticaGeologia>
{
	public AtividadeGeologiaService(IDAOArea<AreaGeologia> daoArea, IDAOProjeto<ProjetoGeologia, ?> daoProjeto,
			IDAOAtividade<AreaGeologia, ProjetoGeologia, PraticaGeologia> dao) {
		super(daoArea, daoProjeto, dao);
	}
}
