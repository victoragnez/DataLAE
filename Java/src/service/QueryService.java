package service;

import java.util.ArrayList;

import dao.IQueryDAO;
import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public class QueryService implements IQueryService {
	private IQueryDAO queryDAO;
	
	public QueryService(IQueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	
	// ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois:
	
	@Override
	public ArrayList<Pesquisa> queryPesquisas() {
		return queryDAO.queryPesquisas();
	}

	@Override
	public ArrayList<Area> queryArea(Pesquisa p) {
		return queryDAO.queryArea(p);
	}

	@Override
	public ArrayList<Viagem> queryViagem(Area a) {
		return queryDAO.queryViagem(a);
	}
}
