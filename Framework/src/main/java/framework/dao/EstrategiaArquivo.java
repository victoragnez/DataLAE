package framework.dao;

import framework.dao.interfaces.DatabaseException;
import framework.model.Arquivo;

interface EstrategiaArquivo<A extends Arquivo<?, ?> > {
	public int inserir(A a) throws DatabaseException;
	
	public byte[] ler(A a) throws DatabaseException;
}
