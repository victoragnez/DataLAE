package dao;

import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public class UpdateDAO implements IUpdateDAO {

	// Implementações quebra-galho aqui:
	@Override
	public void updateProjeto(Projeto p) {
		System.out.println(p.getDenomicacao() + " foi atualizada com sucesso!");
	}

	@Override
	public void updateArea(Projeto p, Area a) {
		System.out.println(a.getLocal() + " foi atualizada com sucesso!");
	}

	@Override
	public void updateViagem(Projeto p, Area a, Viagem v) {
		System.out.println(v.getData().getTime() + " foi atulizada com sucesso!");
	}
	
}
