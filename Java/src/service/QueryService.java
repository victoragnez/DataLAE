package service;

import java.util.ArrayList;

import dao.IQueryDAO;
import service.model.Area;
import service.model.Diretorio;
import service.model.Projeto;
import service.model.Viagem;

public class QueryService implements IQueryService {
	private IQueryDAO queryDAO;
	
	public QueryService(IQueryDAO queryDAO) {
		this.queryDAO = queryDAO;
	}
	
	// ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois:
	
	@Override
	public ArrayList<Projeto> queryProjetos() {
		return queryDAO.queryProjetos();
	}

	@Override
	public ArrayList<Area> queryArea(Projeto p) {
		return queryDAO.queryAreas(p);
	}

	@Override
	public ArrayList<Viagem> queryViagem(Area a) {
		return queryDAO.queryViagens(a);
	}

	@Override
	public ArrayList<Diretorio> pastasProjetos(Projeto p) {
		return queryDAO.pastasProjeto(p);
	}
}
