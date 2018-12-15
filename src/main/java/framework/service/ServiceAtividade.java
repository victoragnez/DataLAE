package framework.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import framework.dao.interfaces.IDAOArea;
import framework.dao.interfaces.IDAOAtividade;
import framework.dao.interfaces.IDAOParticipante;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Pratica;
import framework.model.Projeto;
import framework.model.Area;
import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarConsultar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.model.Participante;
import framework.service.interfaces.IServiceAtividade;

public abstract class ServiceAtividade<
		A extends Area,
		Proj extends Projeto<Part>,
		Prat extends Pratica<A, Part, Proj>,
		Part extends Participante> 
			implements IServiceAtividade<A, Proj, Prat, Part> 
{
	private final IDAOAtividade<A, Proj, Prat, Part> dao;
	private final IDAOProjeto<Proj, ?> daoProjeto;
	private final IDAOArea<A> daoArea;
	private final IDAOParticipante<Part> daoPart;
	
	public ServiceAtividade(
			IDAOArea<A> daoArea,
			IDAOProjeto<Proj, ?> daoProjeto,
			IDAOAtividade<A, Proj, Prat, Part> dao,
			IDAOParticipante<Part> daoPart)
	{
		this.dao = dao;
		this.daoProjeto = daoProjeto;
		this.daoArea = daoArea;
		this.daoPart = daoPart;
	}
	
	@Override
	public void inserir(Prat prat) throws DatabaseException, BadAttributeException {
		if (prat == null)
			throw new BadAttributeException("Parâmetro nulo");
		if (prat.getDataInicio() == null)
			throw new BadAttributeException("Data de início da atividade nulo!");
		if(prat.getDataTermino() != null && prat.getDataTermino().before(prat.getDataInicio()))
			throw new BadAttributeException("A data de témino deve ser maior ou igual a data de início");
		
		validate(ValidarInserir.class, prat);
		dao.inserir(prat);
	}
	
	@Override
	public void remover(Prat prat) throws DatabaseException, BadAttributeException {
		if (prat.getCodigo() == null)
			throw new BadAttributeException("Identificador de projeto nulo!");
		
		dao.remover(prat);
	}
	
	@Override
	public void atualizar(Prat prat) throws DatabaseException, BadAttributeException {
		if (prat == null)
			throw new BadAttributeException("Parâmetro nulo");
		if (prat.getDataInicio() == null)
			throw new BadAttributeException("Data da atividade nulo!");
		if(prat.getDataTermino() != null && prat.getDataTermino().before(prat.getDataInicio()))
				throw new BadAttributeException("A data de témino deve ser maior ou igual a data de início");
		
		validate(ValidarAtualizar.class, prat);
		dao.atualizar(prat);
	}
	
	@Override
	public List<Prat> consultar(Prat prat) throws DatabaseException, BadAttributeException {
		if (prat == null) return listar();
		
		validate(ValidarConsultar.class, prat);
		List<Prat> praticas = dao.consultar(prat);
		for(Prat pratica : praticas) {
			if(pratica.getProjeto() != null)
				pratica.setProjeto(daoProjeto.consultar(pratica.getProjeto().getCodigo()));
				
			if(pratica.getArea() != null)
				pratica.setArea(daoArea.consultar(pratica.getArea().getCodigo()));
		
			if (pratica.getParticipantes() != null) {
				ArrayList<Part> nv = new ArrayList<Part>();
				for (Part part : pratica.getParticipantes())
					nv.add(daoPart.consultar(part.getCodigo()));
				pratica.setParticipantes(nv);
			}
		}
		return praticas;
	}
	
	@Override
	public List<Prat> listar() throws DatabaseException{
		List<Prat> praticas = dao.listar();
		
		for(Prat pratica : praticas) {
			if(pratica.getProjeto() != null)
				pratica.setProjeto(daoProjeto.consultar(pratica.getProjeto().getCodigo()));
				
			if(pratica.getArea() != null)
				pratica.setArea(daoArea.consultar(pratica.getArea().getCodigo()));
			
			if (pratica.getParticipantes() != null) {
				ArrayList<Part> nv = new ArrayList<Part>();
				for (Part part : pratica.getParticipantes())
					nv.add(daoPart.consultar(part.getCodigo()));
				pratica.setParticipantes(nv);
			}
		}
		
		return praticas;
	}
	
	private void validate(Class<? extends Annotation> annotation, Prat prat) throws BadAttributeException {
		Class<?> curClass = this.getClass();
	    
		while (curClass != ServiceAtividade.class) {
	        List<Method> allMethods = new ArrayList<Method>(Arrays.asList(curClass.getDeclaredMethods()));       
	        for (Method method : allMethods) {
	            if (method.isAnnotationPresent(annotation)) {
	            	try {
						method.invoke(this, prat);
					} catch (IllegalAccessException | IllegalArgumentException e) {
						e.printStackTrace();
					}
	            	catch (InvocationTargetException e) {
						throw new BadAttributeException(e.getMessage());
					}
	            }
	        }
	        curClass = curClass.getSuperclass();
	    }
	}

}
