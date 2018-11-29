package framework.service;

import java.util.ArrayList;
import java.util.List;

import framework.dao.interfaces.IDAOParticipante;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.BadAttributeException;
import framework.model.DatabaseException;
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
	public void inserir(P p) throws DatabaseException, BadAttributeException {
		if(p == null)
			throw new BadAttributeException("Parâmetro fornecido nulo");
		if(p.getDataInicio() == null)
			throw new BadAttributeException("Data de início nula");
		if(p.getNome() == null || p.getNome().length() == 0)
			throw new BadAttributeException("Nome nulo");
		if(p.getDataFim() != null && p.getDataFim().before(p.getDataInicio()))
				throw new BadAttributeException("A data de témino deve ser maior ou igual a data de início");
		
		
		validarInserir(p);
		dao.inserir(p);
	}
	
	@Override
	public void remover(P p) throws DatabaseException, BadAttributeException {

		if (p == null) 
			throw new BadAttributeException("Parâmetro fornecido nulo");
		if (p.getCodigo() == null )
			throw new BadAttributeException("Identificador de projeto nulo!");
		
		dao.remover(p);
	}
	
	@Override
	public void atualizar(P p) throws DatabaseException, BadAttributeException {
		if (p == null)
			throw new BadAttributeException("Parâmetro fornecido nulo");
		if (p.getCodigo() == null) 
			throw new BadAttributeException("Identificador de projeto nulo!");
		if(p.getDataInicio() == null)
			throw new BadAttributeException("Data inicio nula!");
		if(p.getNome() == null)
			throw new BadAttributeException("Nome nulo!");
		if(p.getDataFim() != null && p.getDataFim().before(p.getDataInicio()))
				throw new BadAttributeException("A data de témino deve ser maior ou igual a data de início");
		
		validarAtulizar(p);
		dao.atualizar(p);
	}
	
	@Override
	public List<P> consultar(P p) throws DatabaseException, BadAttributeException{
		if(p == null)
			throw new BadAttributeException("Parâmetro fornecido nulo");
		
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
	protected abstract void validarInserir(P p) throws BadAttributeException;
	protected abstract void validarAtulizar(P p) throws BadAttributeException;
	protected abstract void validarConsultar(P p) throws BadAttributeException;

}	
