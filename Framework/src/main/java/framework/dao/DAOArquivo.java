package framework.dao;

import java.util.List;

import framework.dao.interfaces.DatabaseException;
import framework.dao.interfaces.IDAOArquivo;
import framework.model.Arquivo;

public class DAOArquivo<A extends Arquivo<?, ?> > implements IDAOArquivo<A> {
	
	private EstrategiaArquivo<A> estrategia;
	
	public DAOArquivo(){
		this(true);
	}
	
	public DAOArquivo(boolean salvarEmBanco) {
		if(salvarEmBanco) {
			estrategia = new ArquivoEmBanco<A>();
		}
		else
			estrategia = new ArquivoNoSistema<A>();
	}
	
	@Override
	public void inserir(A a) throws DatabaseException {
		estrategia.inserir(a);
	}

	@Override
	public void remover(A a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(A a) throws DatabaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<A> consultar(A a) throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<A> listar() throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public A ler(A a) throws DatabaseException {
		a.setDados(estrategia.ler(a));
		return a;
	}

}
