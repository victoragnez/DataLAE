package framework.service;

import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOParticipante;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Participante;
import framework.model.Projeto;
import framework.service.interfaces.IServiceProjeto;

public abstract class ServiceProjeto<P extends Projeto<Part>, Part extends Participante > implements IServiceProjeto<P> {

	private final IDAOProjeto<P, Part> dao;
	private final IDAOParticipante<Part> daoPart;
	
	public ServiceProjeto (IDAOProjeto<P, Part> dao, IDAOParticipante<Part> daoPart)	{
		this.dao = dao;
		this.daoPart = daoPart;
	}
	
	@Override
	public void inserir(P p) throws DatabaseException {
		if(p == null)
			throw new IllegalArgumentException("Parâmetro fornecido nulo");
		if(p.getDataInicio() == null)
			throw new IllegalArgumentException("Data de início nula");
		if(p.getNome() == null)
			throw new IllegalArgumentException("Nome nulo");
		
		validarInserir(p);
		dao.inserir(p);
	}
	
	@Override
	public void remover(P p) throws DatabaseException {

		if (p == null) 
			throw new IllegalArgumentException("Parâmetro fornecido nulo");
		if (p.getCodigo() == null )
			throw new IllegalArgumentException("Identificador de projeto nulo!");
		
		validarRemover(p);
		dao.remover(p);
	}
	
	@Override
	public void atualizar(P p) throws DatabaseException {
		if (p == null)
			throw new IllegalArgumentException("Parâmetro fornecido nulo");
		if (p.getCodigo() == null) 
			throw new IllegalArgumentException("Identificador de projeto nulo!");
		if(p.getDataInicio() == null)
			throw new IllegalArgumentException("Data inicio nula!");
		if(p.getNome() == null)
			throw new IllegalArgumentException("Nome nulo!");
		
		validarAtulizar(p);
		dao.atualizar(p);
	}
	
	@Override
	public List<P> consultar(P p) throws DatabaseException{
		if(p == null)
			throw new IllegalArgumentException("Parâmetro fornecido nulo");
		
		validarConsultar(p);
		List<P> projetos = dao.consultar(p);
		for (P cur : projetos)
		{
			if (cur.getParticipantes() != null) {
				ArrayList<Part> nv = new ArrayList<Part>();
				for (Part part : cur.getParticipantes())
					nv.add(daoPart.consultar(part.getCodigo()));
				cur.setParticipantes(nv);
			}
		}
		return projetos;
	}
	
	@Override
	public List<P> listar() throws DatabaseException {
		List<P> projetos = dao.listar();
		
		for (P p : projetos)
		{
			if (p.getParticipantes() != null) {
				ArrayList<Part> nv = new ArrayList<Part>();
				for (Part part : p.getParticipantes())
					nv.add(daoPart.consultar(part.getCodigo()));
				p.setParticipantes(nv);
			}
		}
		
		return projetos;
	}

	/** Metodos que precisam ser implementados */
	protected abstract void validarInserir(P p);
	protected abstract void validarRemover(P p);
	protected abstract void validarAtulizar(P p);
	protected abstract void validarConsultar(P p);

}	
