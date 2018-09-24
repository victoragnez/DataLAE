package service;

import dao.ICreateDAO;
import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public class CreateService implements ICreateService {
	private ICreateDAO createDAO;
	
	public CreateService(ICreateDAO createDAO) {
		 this.createDAO = createDAO;
	}

	// ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois: 
	
	@Override
	public void criaPesquisa(Pesquisa p) {
		createDAO.criaPesquisa(p);
	}

	@Override
	public void criaArea(Pesquisa p, Area a) {
		createDAO.criaArea(p, a);
	}

	@Override
	public void criaViagem(Pesquisa p, Area a, Viagem v) {
		createDAO.criaViagem(p, a, v);
	}
}
