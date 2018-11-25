package framework.dao;

import framework.dao.interfaces.DatabaseException;
import framework.model.Arquivo;

class ArquivoNoSistema<A extends Arquivo<?, ?> > implements EstrategiaArquivo<A> {

	@Override
	public int inserir(A a) throws DatabaseException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] ler(A a) {
		// TODO Auto-generated method stub
		return null;
	}

}
