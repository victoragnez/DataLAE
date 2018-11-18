package com.lab.data.service.interfaces;

import java.util.List;

import com.lab.data.dao.interfaces.DatabaseException;
import com.lab.data.model.Area;

public interface IServiceArea {

	public void inserir(Area a) throws DatabaseException;
	public void remover(Area a) throws DatabaseException;
	public void atualizar(Area a) throws DatabaseException;
	public List<Area> consultar(Area a) throws DatabaseException;
	public List<Area> listar() throws DatabaseException;
	
}
