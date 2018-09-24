package dao;

import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public class CreateDAO implements ICreateDAO {

	// Implementações quebra-galho aqui:
	@Override
	public void criaProjeto(Projeto p) {
		System.out.println("A pesquisa foi criada!");
	}

	@Override
	public void criaArea(Projeto p, Area a) {
		System.out.println("A área foi criada!");
	}

	@Override
	public void criaViagem(Projeto p, Area a, Viagem v) {
		System.out.println("A viagem foi criada!");
	}
}