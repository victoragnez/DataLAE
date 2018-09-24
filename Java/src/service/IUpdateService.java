package service;

import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public interface IUpdateService {
	public void updateProjeto(Projeto p);
    public void updateArea(Projeto p, Area a);
    public void updateViagem(Projeto p, Area a, Viagem v);
}
