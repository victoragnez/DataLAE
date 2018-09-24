package dao;

import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public class RemoveDAO implements IRemoveDAO {

	// Implementações quebra-galho aqui:
	@Override
	public void removePesquisa(Pesquisa p) {
		System.out.println(p.getDenomicacao() + " foi removida com sucesso!");
	}

	@Override
	public void removeArea(Pesquisa p, Area a) {
		System.out.println(a.getLocal() + " foi removida com sucesso!");
	}

	@Override
	public void removeViagem(Pesquisa p, Area a, Viagem v) {
		System.out.println(v.getData().getTime() + " foi removida com sucesso!");
	}
}
