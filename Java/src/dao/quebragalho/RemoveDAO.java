package dao.quebragalho;

import dao.IRemoveDAO;
import service.model.AmbientalTipo;
import service.model.Area;
import service.model.Arquivo;
import service.model.Geofisica.Metodo;
import service.model.Geofisica.Tipo;
import service.model.LaserScannerTipo;
import service.model.ModelagemOuModeloIntegrado;
import service.model.Projeto;
import service.model.Publicacao;
import service.model.Relatorio;
import service.model.SIGDadoTipo;
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

	@Override
	public void removePublicacao(Projeto p, Publicacao pb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRelatorio(Projeto p, Boolean Final, Relatorio r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArquivosFotos(Viagem v, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArquivosGeofisica(Viagem v, Metodo m, Tipo t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArquivosGPS(Viagem v, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArquivosLaserScanner(Viagem v, LaserScannerTipo t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArquivosSIGArea(Area a, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}
}
