package framework.dao;

import framework.model.Arquivo;
import framework.model.DatabaseException;

interface EstrategiaArquivo<A extends Arquivo<?, ?> > {
	public int inserir(A a) throws DatabaseException;
	
	public byte[] ler(A a) throws DatabaseException;
}
