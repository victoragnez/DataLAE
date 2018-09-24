package service;

import java.util.ArrayList;

import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public interface IQueryService {
	public ArrayList<Projeto> queryProjetos();
	public ArrayList<Area> queryArea(Projeto p);
	public ArrayList<Viagem> queryViagem(Area a);
}
