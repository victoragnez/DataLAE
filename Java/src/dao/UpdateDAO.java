package dao;

import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public class UpdateDAO implements IUpdateDAO {

	// Implementações quebra-galho aqui:
	@Override
	public void updatePesquisa(Pesquisa p) {
		System.out.println(p.getDenomicacao() + " foi atualizada com sucesso!");
	}

	@Override
	public void updateArea(Pesquisa p, Area a) {
		System.out.println(a.getLocal() + " foi atualizada com sucesso!");
	}

	@Override
	public void updateViagem(Pesquisa p, Area a, Viagem v) {
		System.out.println(v.getData().getTime() + " foi atulizada com sucesso!");
	}
	
}
