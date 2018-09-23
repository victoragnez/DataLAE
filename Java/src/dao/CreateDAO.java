package dao;

import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public class CreateDAO implements ICreateDAO {

	// Implementações quebra-galho aqui:
	@Override
	public void criaPesquisa(Pesquisa p) {
		System.out.println("A pesquisa foi criada!");
	}

	@Override
	public void criaArea(Pesquisa p, Area a) {
		System.out.println("A área foi criada!");
	}

	@Override
	public void criaViagem(Pesquisa p, Area a, Viagem v) {
		System.out.println("A viagem foi criada!");
	}
}