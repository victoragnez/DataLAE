package com.lab.data.service;

import com.lab.data.model.AtividadeGeologia;

import framework.dao.interfaces.IDAOAtividade;
import framework.service.ServiceAtividade;

public class AtividadeGeologiaService extends ServiceAtividade<AtividadeGeologia>{

	public AtividadeGeologiaService(IDAOAtividade<AtividadeGeologia> dao) {
		super(dao);
	}

}
