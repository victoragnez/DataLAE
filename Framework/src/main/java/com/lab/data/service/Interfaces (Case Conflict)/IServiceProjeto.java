package com.lab.data.service.interfaces;

import java.util.List;

import com.lab.data.dao.interfaces.DatabaseException;
import com.lab.data.model.Participante;
import com.lab.data.model.Projeto;


public interface IServiceProjeto {

	public void inserir(Projeto p) throws DatabaseException;
	public void remover(Projeto p) throws DatabaseException;
	public void atualizar(Projeto p) throws DatabaseException;
	public List<Projeto> consultar(Projeto pj, Participante p) throws DatabaseException;
	public List<Projeto> listar() throws DatabaseException;
	
}
