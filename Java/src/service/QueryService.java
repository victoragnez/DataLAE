package service;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
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
	public ArrayList<Projeto> queryProjetos() throws MalformedURLException, RemoteException, ClassNotFoundException, NotBoundException, SQLException {
		return queryDAO.queryProjetos();
	}

	@Override
	public ArrayList<Area> queryArea(Projeto p) throws MalformedURLException, RemoteException, ClassNotFoundException, NotBoundException, SQLException {
		return queryDAO.queryAreas(p);
	}

	@Override
	public ArrayList<Viagem> queryViagem(Area a) throws MalformedURLException, RemoteException, ClassNotFoundException, NotBoundException, SQLException {
		return queryDAO.queryViagens(a);
	}

	@Override
	public ArrayList<Diretorio> pastasProjetos(Projeto p) {
		return queryDAO.pastasProjeto(p);
	}
	
	@Override
	public ArrayList<Diretorio> pastasViagem(Viagem v) {
		return queryDAO.pastasViagem(v);
	}
}
