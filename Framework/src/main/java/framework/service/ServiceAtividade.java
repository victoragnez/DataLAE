package framework.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOAtividade;
import framework.model.Pratica;
import framework.model.MarcadoresService.ValidarAtualizar;
import framework.model.MarcadoresService.ValidarConsultar;
import framework.model.MarcadoresService.ValidarInserir;
import framework.model.MarcadoresService.ValidarRemover;
import framework.service.interfaces.IServiceAtividade;

public abstract class ServiceAtividade<A extends Pratica> implements IServiceAtividade<A> {

	private final IDAOAtividade<A> dao;
	
	public ServiceAtividade (IDAOAtividade<A> dao)	{
		this.dao = dao;
	}
	
	@Override
	public void inserir(A a) throws DatabaseException {
		if (a == null)
			throw new IllegalArgumentException("Parâmetro nulo");
		if (a.getDataInicio() == null)
			throw new IllegalArgumentException("Data de início da atividade nulo!");
		
		validate(ValidarInserir.class, a);
		dao.inserir(a);
	}
	
	@Override
	public void remover(A a) throws DatabaseException {
		if (a.getCodigo() == null)
			throw new IllegalArgumentException("Identificador de projeto nulo!");
		
		validate(ValidarRemover.class, a);
		dao.remover(a);
	}
	
	@Override
	public void atualizar(A a) throws DatabaseException {
		if (a == null)
			throw new IllegalArgumentException("Parâmetro nulo");
		if (a.getDataInicio() == null)
			throw new IllegalArgumentException("Data da atividade nulo!");
		
		validate(ValidarAtualizar.class, a);
		dao.atualizar(a);
	}
	
	@Override
	public List<A> consultar(A a) throws DatabaseException {
		if (a == null) return listar();
		
		validate(ValidarConsultar.class, a);
		return dao.consultar(a);
	}
	
	@Override
	public List<A> listar() throws DatabaseException{
		return dao.listar();
	}
	
	private void validate(Class<? extends Annotation> annotation, A a) {
		Class<?> curClass = this.getClass();
	    
		while (curClass != ServiceAtividade.class) {
	        List<Method> allMethods = new ArrayList<Method>(Arrays.asList(curClass.getDeclaredMethods()));       
	        for (Method method : allMethods) {
	            if (method.isAnnotationPresent(annotation)) {
	            	try {
						method.invoke(this, a);
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
