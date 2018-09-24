package dao.quebragalho;

import dao.IUpdateDAO;
import service.model.Area;
import service.model.Projeto;
import service.model.Publicacao;
import service.model.Relatorio;
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

	@Override
	public void updatePublicacao(Projeto p, Publicacao pb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRelatorio(Projeto p, Boolean Final, Relatorio r) {
		// TODO Auto-generated method stub
		
	}
	
}
