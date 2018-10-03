package DAO;

import DAO.Exceptions.CampoInvalidoException;
import DAO.Interfaces.IPesquisadorDAO;
import Model.Pesquisador;

public class PesquisadorDAO implements IPesquisadorDAO{

	public PesquisadorDAO() {}
	
	@Override
	public void inserir(Pesquisador p) throws CampoInvalidoException{
		
		if (p.getCpf() == null || p.getNome() == null || 
			p.getUniversidade() == null || p.getTitulacao() == null)
			throw new CampoInvalidoException("Campo inválido!");
		
		
	}

	@Override
	public void remover(Pesquisador p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pesquisador consultar(String codigoPesquisador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Pesquisador p) {
		// TODO Auto-generated method stub
		
	}

}
