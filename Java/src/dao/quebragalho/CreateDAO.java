package dao.quebragalho;

import dao.ICreateDAO;
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

	@Override
	public void criaPublicacao(Projeto p, Publicacao pb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaRelatorio(Projeto p, Boolean Final, Relatorio r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosFotos(Viagem v, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosGeofisica(Viagem v, Metodo m, Tipo t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosGPS(Viagem v, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosLaserScanner(Viagem v, LaserScannerTipo t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosSIGArea(Area a, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq) {
		// TODO Auto-generated method stub
		
	}
}