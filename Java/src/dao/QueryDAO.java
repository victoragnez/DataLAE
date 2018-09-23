package dao;

import java.util.ArrayList;
import java.util.Calendar;

import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public class QueryDAO implements IQueryDAO {

	// Implementações quebra-galho abaixo:
	@Override
	public ArrayList<Pesquisa> queryPesquisas() {
		ArrayList<Pesquisa> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Pesquisa pesq = new Pesquisa();
			pesq.setDenomicacao("Pesquisa "+i);
			pesq.setCoordenador("Coordenador " + i);
			pesq.setFinanciador("Financiador " + i);
			list.add(pesq);
		}
		return list;
	}

	@Override
	public ArrayList<Area> queryArea(Pesquisa p) {
		ArrayList<Area> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			list.add(new Area(Integer.toString(i), "Área" + i + " da " + p.getDenomicacao()));
		}
		return list;
	}

	@Override
	public ArrayList<Viagem> queryViagem(Area a) {
		ArrayList<Viagem> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DAY_OF_MONTH, 1+i);
			c.set(Calendar.MONTH, 9);
			c.set(Calendar.YEAR, 2018);
			
			list.add(new Viagem(
					Integer.toString(i),
					c, 
					"Pesquisador da " + a.getLocal(), 
					(double)i));
		}
		return list;
	}
}
