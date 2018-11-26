package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArquivo;
import framework.model.Arquivo;
import framework.service.interfaces.IServiceArquivo;

public class ServiceArquivo<Arq extends Arquivo<?,?>> implements IServiceArquivo<Arq> {
	
	private final IDAOArquivo<Arq> dao;
	
	public ServiceArquivo (IDAOArquivo<Arq> dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(Arq a) throws DatabaseException {
		if (a.getNome() == null)
			throw new IllegalArgumentException("Nome de arquivo não fornecido");
		if (a.getProjeto() == null)
			throw new IllegalArgumentException("Projeto de arquivo nulo!");
		if (a.getDados() == null)
			throw new IllegalArgumentException("Arquivo inválido");
				
		dao.inserir(a);
	}

	@Override
	public void remover(Arq a) throws DatabaseException {
		if (a.getCodigo() == null)
			throw new IllegalArgumentException("Impossível deletar arquivo informado");
		
		dao.remover(a);
	}

	@Override
	public void atualizar(Arq a) throws DatabaseException {
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
	public List<Arq> consultar(Arq a) throws DatabaseException {
		if (a == null) return listar();
		
		return dao.consultar(a);
	}

	@Override
	public List<Arq> listar() throws DatabaseException {
		return dao.listar();
	}
}
