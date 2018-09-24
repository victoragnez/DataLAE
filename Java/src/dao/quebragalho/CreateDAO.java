package dao.quebragalho;

import java.util.ArrayList;

import dao.ICreateDAO;
import service.model.AmbientalTipo;
import service.model.Area;
import service.model.Arquivo;
import service.model.Geofisica.Metodo;
import service.model.Geofisica.Tipo;
import service.model.LaserScannerTipo;
import service.model.ModelagemOuModeloIntegrado;
import service.model.Projeto;
import service.model.PublicacaoTipo;
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
	public void criaArquivosAmbiental(Viagem v, AmbientalTipo t, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosFotos(Viagem v, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosGeofisica(Viagem v, Metodo m, Tipo t, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosGPS(Viagem v, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosLaserScanner(Viagem v, LaserScannerTipo t, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosPublicacoes(Projeto p, PublicacaoTipo t, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosRelatorios(Projeto p, Boolean Final, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosSIGArea(Area a, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criaArquivosSIGDados(Projeto p, SIGDadoTipo t, ArrayList<Arquivo> vet) {
		// TODO Auto-generated method stub
		
	}
}