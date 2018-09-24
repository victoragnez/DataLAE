package service;

import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public interface IRemoveService {
	public void removeProjeto(Projeto p);
    public void removeArea(Projeto p, Area a);
    public void removeViagem(Projeto p, Area a, Viagem v);
}
