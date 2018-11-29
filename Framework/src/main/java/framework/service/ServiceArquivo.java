package framework.service;

import java.util.List;

import framework.dao.interfaces.IDAOArquivo;
import framework.dao.interfaces.IDAOAtividade;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Arquivo;
import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.model.Pratica;
import framework.model.Projeto;
import framework.service.interfaces.IServiceArquivo;

public class ServiceArquivo<Proj extends Projeto<?>, Prat extends Pratica<?, ?, Proj>> implements IServiceArquivo<Proj, Prat> {
	
	private final IDAOArquivo<Proj, Prat> dao;
	private final IDAOProjeto<Proj,?> daoProj;
	private final IDAOAtividade<?, Proj,Prat> daoPrat;
	
	public ServiceArquivo (IDAOArquivo<Proj, Prat> dao, 
			IDAOProjeto<Proj,?> daoProj, IDAOAtividade<?, Proj, Prat> daoPrat) {
		this.dao = dao;
		this.daoProj = daoProj;
		this.daoPrat = daoPrat;
	}
	
	@Override
	public void inserir(Arquivo<Proj, Prat> a) throws DatabaseException, BadAttributeException {

		if (a.getNome() == null || a.getNome().length() == 0)
			throw new BadAttributeException("Nome de arquivo não fornecido");
		if (a.getProjeto() == null)
			throw new BadAttributeException("Projeto de arquivo nulo!");
		if (a.getDados() == null)
			throw new BadAttributeException("Arquivo inválido");
				
		dao.inserir(a);
	}

	@Override
	public void remover(Arquivo<Proj,Prat> a) throws DatabaseException, BadAttributeException {

		if (a.getCodigo() == null)
			throw new BadAttributeException("Impossível deletar arquivo informado");
		
		dao.remover(a);
	}

	@Override
	public void atualizar(Arquivo<Proj,Prat> a) throws DatabaseException, BadAttributeException {
		if (a.getTamanho() == null)
			throw new BadAttributeException("Tamanho de arquivo desconhecido");
		if (a.getNome() == null || a.getNome().length() == 0)
			throw new BadAttributeException("Nome de arquivo não fornecido");
		if (a.getProjeto() == null)
			throw new BadAttributeException("Projeto de arquivo nulo!");
		
		dao.atualizar(a);
	}

	@Override

	public List<Arquivo<Proj,Prat>> consultar(Arquivo<Proj,Prat> a) throws DatabaseException, BadAttributeException {
		if(a == null)
			throw new BadAttributeException("Arquivo nulo!");
		return dao.consultar(a);
	}

	@Override
	public List<Arquivo<Proj,Prat>> listar() throws DatabaseException {
		List<Arquivo<Proj,Prat>> results = dao.listar();
		
		for ( Arquivo<Proj,Prat> arq : results) {
			if (arq.getProjeto() != null && arq.getCodigo() != null)
				arq.setProjeto(daoProj.consultar(arq.getProjeto().getCodigo()));
					
			if(arq.getPratica() != null && arq.getPratica().getCodigo() != null)
				arq.setPratica(daoPrat.consultar(arq.getPratica().getCodigo()));
		}
		
		return results;
	}

	@Override
	public Arquivo<Proj, Prat> ler(Arquivo<Proj, Prat> a) throws DatabaseException, BadAttributeException {
		if(a == null)
			throw new BadAttributeException("Arquivo nulo!");
		if(a.getCodigo() == null)
			throw new BadAttributeException("Arquivo com codigo nulo!");
		return dao.ler(a);
	}
}
