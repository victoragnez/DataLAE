package framework.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArea;
import framework.dao.interfaces.IDAOAtividade;
import framework.dao.interfaces.IDAOProjeto;
import framework.model.Pratica;
import framework.model.Projeto;
import framework.model.Area;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarConsultar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.model.MarcadoresService.ValidarRemover;
import framework.service.interfaces.IServiceAtividade;

public abstract class ServiceAtividade<
		A extends Area,
		Proj extends Projeto<?>,
		Prat extends Pratica<A, ?, Proj>> 
			implements IServiceAtividade<A, Proj, Prat> 
{
	private final IDAOAtividade<A, Proj, Prat> dao;
	private final IDAOProjeto<Proj, ?> daoProjeto;
	private final IDAOArea<A> daoArea;
	
	public ServiceAtividade(
			IDAOArea<A> daoArea,
			IDAOProjeto<Proj, ?> daoProjeto,
			IDAOAtividade<A, Proj, Prat> dao)
	{
		this.dao = dao;
		this.daoProjeto = daoProjeto;
		this.daoArea = daoArea;
	}
	
	@Override
	public void inserir(Prat prat) throws DatabaseException {
		if (prat == null)
			throw new IllegalArgumentException("Parâmetro nulo");
		if (prat.getDataInicio() == null)
			throw new IllegalArgumentException("Data de início da atividade nulo!");
		
		validate(ValidarInserir.class, prat);
		dao.inserir(prat);
	}
	
	@Override
	public void remover(Prat prat) throws DatabaseException {
		if (prat.getCodigo() == null)
			throw new IllegalArgumentException("Identificador de projeto nulo!");
		
		validate(ValidarRemover.class, prat);
		dao.remover(prat);
	}
	
	@Override
	public void atualizar(Prat prat) throws DatabaseException {
		if (prat == null)
			throw new IllegalArgumentException("Parâmetro nulo");
		if (prat.getDataInicio() == null)
			throw new IllegalArgumentException("Data da atividade nulo!");
		
		validate(ValidarAtualizar.class, prat);
		dao.atualizar(prat);
	}
	
	@Override
	public List<Prat> consultar(Prat prat) throws DatabaseException {
		if (prat == null) return listar();
		
		validate(ValidarConsultar.class, prat);
		return dao.consultar(prat);
	}
	
	@Override
	public List<Prat> listar() throws DatabaseException{
		List<Prat> praticas = dao.listar();
		
		for(Prat pratica : praticas) {
			if(pratica.getProjeto() != null)
				pratica.setProjeto(daoProjeto.consultar(pratica.getProjeto().getCodigo()));
				
			if(pratica.getArea() != null)
				pratica.setArea(daoArea.consultar(pratica.getArea().getCodigo()));
		}
		
		return praticas;
	}
	
	private void validate(Class<? extends Annotation> annotation, Prat prat) {
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
						throw new IllegalArgumentException(e.getMessage());
					}
	            }
	        }
	        curClass = curClass.getSuperclass();
	    }
	}

}
