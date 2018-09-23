package service;

import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public interface IRemoveService {
	public void removePesquisa(Pesquisa p);
    public void removeArea(Pesquisa p, Area a);
    public void removeViagem(Pesquisa p, Area a, Viagem v);
}
