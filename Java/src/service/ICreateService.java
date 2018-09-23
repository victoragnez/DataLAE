package service;

import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public interface ICreateService {
	public void criaPesquisa(Pesquisa p);
    public void criaArea(Pesquisa p, Area a);
    public void criaViagem(Pesquisa p, Area a, Viagem v);
}
