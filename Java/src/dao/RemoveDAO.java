package dao;

import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public class RemoveDAO implements IRemoveDAO {

	// Implementações quebra-galho aqui:
	@Override
	public void removeProjeto(Projeto p) {
		System.out.println(p.getDenomicacao() + " foi removida com sucesso!");
	}

	@Override
	public void removeArea(Projeto p, Area a) {
		System.out.println(a.getLocal() + " foi removida com sucesso!");
	}

	@Override
	public void removeViagem(Projeto p, Area a, Viagem v) {
		System.out.println(v.getData().getTime() + " foi removida com sucesso!");
	}
}
