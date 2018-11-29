package framework.dao.interfaces;

import java.util.List;

import framework.model.Arquivo;
import framework.model.DatabaseException;
import framework.model.Pratica;
import framework.model.Projeto;

public interface IDAOArquivo<Proj extends Projeto<?>, Prat extends Pratica<?, ?, Proj>> {
	public void inserir(Arquivo<Proj,Prat> a) throws DatabaseException;
	public void remover(Arquivo<Proj,Prat> a) throws DatabaseException;
	public void atualizar(Arquivo<Proj,Prat> a) throws DatabaseException;
	public List<Arquivo<Proj,Prat>> consultar(Arquivo<Proj,Prat> a) throws DatabaseException;
	public List<Arquivo<Proj,Prat>> listar() throws DatabaseException;
	public Arquivo<Proj,Prat> ler(Arquivo<Proj,Prat> a) throws DatabaseException;
}
