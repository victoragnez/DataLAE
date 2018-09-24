package service;

import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public interface IUpdateService {
	public void updatePesquisa(Pesquisa p);
    public void updateArea(Pesquisa p, Area a);
    public void updateViagem(Pesquisa p, Area a, Viagem v);
}
