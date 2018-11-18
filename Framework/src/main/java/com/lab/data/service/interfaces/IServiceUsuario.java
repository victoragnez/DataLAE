package com.lab.data.service.interfaces;

import java.util.List;

import com.lab.data.dao.interfaces.DatabaseException;
import com.lab.data.model.Usuario;

@Deprecated
public interface IServiceUsuario {

	public void inserir(Usuario user) throws DatabaseException;
	public void remover(Usuario user) throws DatabaseException;
	public void atualizar(Usuario user) throws DatabaseException;
	public List<Usuario> consultar(Usuario user) throws DatabaseException;
	public List<Usuario> listar() throws DatabaseException;

}
