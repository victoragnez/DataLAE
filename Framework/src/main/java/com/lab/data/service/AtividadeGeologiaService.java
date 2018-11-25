package com.lab.data.service;

import com.lab.data.model.PraticaGeologia;

import framework.dao.interfaces.IDAOAtividade;
import framework.service.ServiceAtividade;

public class AtividadeGeologiaService extends ServiceAtividade<PraticaGeologia>{

	public AtividadeGeologiaService(IDAOAtividade<PraticaGeologia> dao) {
		super(dao);
	}

}
