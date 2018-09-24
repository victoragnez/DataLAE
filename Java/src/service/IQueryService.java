package service;

import java.util.ArrayList;

import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public interface IQueryService {
	public ArrayList<Pesquisa> queryPesquisas();
	public ArrayList<Area> queryArea(Pesquisa p);
	public ArrayList<Viagem> queryViagem(Area a);
}
