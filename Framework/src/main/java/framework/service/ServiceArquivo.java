package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArquivo;
import framework.model.Arquivo;
import framework.service.interfaces.IServiceArquivo;

public abstract class ServiceArquivo implements IServiceArquivo {
	
	private final IDAOArquivo<Arquivo<?, ?>> dao;
	
	public ServiceArquivo (IDAOArquivo<Arquivo<?,?>> dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(Arquivo<?,?> a) throws DatabaseException {
		if (a.getNome() == null)
			throw new IllegalArgumentException("Nome de arquivo não fornecido");
		if (a.getProjeto() == null)
			throw new IllegalArgumentException("Projeto de arquivo nulo!");
		if (a.getDados() == null)
			throw new IllegalArgumentException("Arquivo inválido");
				
		dao.inserir(a);
	}

	@Override
	public void remover(Arquivo<?,?> a) throws DatabaseException {
		if (a.getCodigo() == null)
			throw new IllegalArgumentException("Impossível deletar arquivo informado");
		
		dao.remover(a);
	}

	@Override
	public void atualizar(Arquivo<?,?> a) throws DatabaseException {
		if (a.getTamanho() == null)
			throw new IllegalArgumentException("Tamanho de arquivo desconhecido");
		if (a.getNome() == null)
			throw new IllegalArgumentException("Nome de arquivo não fornecido");
		if (a.getProjeto() == null)
			throw new IllegalArgumentException("Projeto de arquivo nulo!");
		if (a.getDados() == null)
			throw new IllegalArgumentException("Arquivo inválido");
		
		dao.atualizar(a);
	}

	@Override
	public List<Arquivo<?,?>> consultar(Arquivo<?,?> a) throws DatabaseException {
		if (a == null) return listar();
		
		return dao.consultar(a);
	}

	@Override
	public List<Arquivo<?,?>> listar() throws DatabaseException {
		return dao.listar();
	}
}
