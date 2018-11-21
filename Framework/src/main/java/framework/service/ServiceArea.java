package framework.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArea;
import framework.model.Area;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarConsultar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.model.MarcadoresService.ValidarRemover;
import framework.service.interfaces.IServiceArea;

public abstract class ServiceArea<A extends Area> implements IServiceArea <A>{

	private final IDAOArea<A> dao;
	
	public ServiceArea (IDAOArea<A> dao) {
		this.dao = dao;
	}
	
	@Override
	public void inserir(A a) throws DatabaseException {
		validate(ValidarInserir.class, a);
		dao.inserir(a);
	}
	
	@Override
	public void remover(A a) throws DatabaseException {
		validate(ValidarRemover.class, a);
		dao.remover(a);
	}
	
	@Override
	public void atualizar(A a) throws DatabaseException {
		validate(ValidarAtualizar.class, a);
		dao.atualizar(a);
	}
	
	@Override
	public List<A> consultar(A a) throws DatabaseException {
		validate(ValidarConsultar.class, a);
		return dao.consultar(a);
	}
	
	@Override
	public List<A> listar() throws DatabaseException{
		return dao.listar();
	}
	
	private void validate(Class<? extends Annotation> annotation, A a) {
		Class<?> curClass = this.getClass();
	    
		while (curClass != ServiceArea.class) {
	        List<Method> allMethods = new ArrayList<Method>(Arrays.asList(curClass.getDeclaredMethods()));       
	        for (Method method : allMethods) {
	            if (method.isAnnotationPresent(annotation)) {
	            	try {
						method.invoke(this, a);
					} catch (IllegalAccessException | IllegalArgumentException | 
							InvocationTargetException e) {
					}
	            }
	        }
	        curClass = curClass.getSuperclass();
	    }
	}
}
