package service;

import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public interface ICreateService {
	public void criaProjeto(Projeto p);
    public void criaArea(Projeto p, Area a);
    public void criaViagem(Projeto p, Area a, Viagem v);
}
