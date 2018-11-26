package framework.service;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArquivo;
import framework.dao.interfaces.IDAOAtividade;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Arquivo;
import framework.model.Pratica;
import framework.model.Projeto;
import framework.service.interfaces.IServiceArquivo;

public abstract class ServiceArquivo<Proj extends Projeto<?>, Prat extends Pratica<?, ?, Proj>, 
A extends Arquivo<Proj, Prat> > implements IServiceArquivo<Proj, Prat, A> {
	
	private final IDAOArquivo<Proj, Prat, A> dao;
	private final IDAOProjeto<Proj> daoProj;
	private final IDAOAtividade<?, Proj,Prat> daoPrat;
	
	public ServiceArquivo (IDAOArquivo<Proj, Prat, A> dao, 
			IDAOProjeto<Proj> daoProj, IDAOAtividade<?, Proj,Prat> daoPrat)	{
		this.dao = dao;
		this.daoProj = daoProj;
		this.daoPrat = daoPrat;
	}
	
	@Override
	public void inserir(A a) throws DatabaseException {
		if (a.getNome() == null)
			throw new IllegalArgumentException("Nome de arquivo não fornecido");
		if (a.getProjeto() == null)
			throw new IllegalArgumentException("Projeto de arquivo nulo!");
		if (a.getDados() == null)
			throw new IllegalArgumentException("Arquivo inválido");
				
		dao.inserir(a);
	}

	@Override
	public void remover(A a) throws DatabaseException {
		if (a.getCodigo() == null)
			throw new IllegalArgumentException("Impossível deletar arquivo informado");
		
		dao.remover(a);
	}

	@Override
	public void atualizar(A a) throws DatabaseException {
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
	public List<A> consultar(A a) throws DatabaseException {
		if (a == null) return listar();
		
		return dao.consultar(a);
	}

	@Override
	public List<A> listar() throws DatabaseException {
		List<A> results = dao.listar();
		
		for ( A arq : results) {
			if (arq.getProjeto() != null && arq.getCodigo() != null)
				arq.setProjeto(daoProj.consultar(arq.getProjeto().getCodigo()));
					
			if(arq.getAtividade() != null && arq.getAtividade().getCodigo() != null)
				arq.setAtividade(daoPrat.consultar(arq.getAtividade().getCodigo()));
		}
		
		return results;
	}
}
