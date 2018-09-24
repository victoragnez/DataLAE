package dao;

import java.util.ArrayList;
import java.util.Arrays;

import service.model.AmbientalTipo;
import service.model.Area;
import service.model.Arquivo;
import service.model.Diretorio;
import service.model.Geofisica.Metodo;
import service.model.Geofisica.Tipo;
import service.model.LaserScannerTipo;
import service.model.ModelagemOuModeloIntegrado;
import service.model.Projeto;
import service.model.Publicacao;
import service.model.PublicacaoTipo;
import service.model.Relatorio;
import service.model.SIGDadoTipo;
import service.model.Viagem;

class QueryDAO implements IQueryDAO {

	@Override
	public ArrayList<Projeto> queryProjetos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Area> queryAreas(Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Area> pastasSIGAreaEstudo(Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Viagem> queryViagens(Area a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Publicacao> queryPublicacoes(Projeto p, PublicacaoTipo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Relatorio> queryRelatorios(Projeto p, Boolean Final) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasProjeto(Projeto p) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Área de Pesquisa"), 
				new Diretorio("Modelagem"), 
				new Diretorio("Modelo Integrado"), 
				new Diretorio("Publicações"), 
				new Diretorio("Relatórios"), 
				new Diretorio("SIG")));
	}

	@Override
	public ArrayList<Diretorio> pastasModelagem(Projeto p) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Imagens"), 
				new Diretorio("Report"), 
				new Diretorio("Superfícies 2D"), 
				new Diretorio("Visualização 3D")));
	}

	@Override
	public ArrayList<Diretorio> pastasModeloIntegrado(Projeto p) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Imagens"), 
				new Diretorio("Report"), 
				new Diretorio("Superfícies 2D"), 
				new Diretorio("Visualização 3D")));
	}

	@Override
	public ArrayList<Diretorio> pastasPublicacoes(Projeto p) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Artigos"), 
				new Diretorio("Congresso"), 
				new Diretorio("Dissertações"), 
				new Diretorio("TCC"), 
				new Diretorio("Teses")));
	}

	@Override
	public ArrayList<Diretorio> pastasRelatorios(Projeto p) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Final"), 
				new Diretorio("Parcial")));
	}

	@Override
	public ArrayList<Diretorio> pastasSIG(Projeto p) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Área de Estudo"), 
				new Diretorio("Dados")));
	}

	@Override
	public ArrayList<Diretorio> pastasSIGDados(Projeto p) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("CAD"), 
				new Diretorio("Imagens Aéreas"), 
				new Diretorio("Modelo Digital de Elevação"), 
				new Diretorio("Planilhas"), 
				new Diretorio("Shapes")));
	}

	@Override
	public ArrayList<Diretorio> pastasViagem(Viagem v) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Ambiental"), 
				new Diretorio("Fotos"), 
				new Diretorio("Geofísica"), 
				new Diretorio("GPS"), 
				new Diretorio("Laser Scanner")));
	}

	@Override
	public ArrayList<Diretorio> pastasAmbiental(Viagem v) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Documentação de Campo"), 
				new Diretorio("Imagens"), 
				new Diretorio("Report")));
	}

	@Override
	public ArrayList<Diretorio> pastasGeofisica(Viagem v) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("ERT"), 
				new Diretorio("GPR"), 
				new Diretorio("Sísmica de Reflexão"), 
				new Diretorio("Sísmica de Refração")));
	}

	@Override
	public ArrayList<Diretorio> pastasGeofisica(Viagem v, Metodo m) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Dados Brutos"), 
				new Diretorio("Documentação de Campo"), 
				new Diretorio("Imagens"), 
				new Diretorio("Processamento"),
				new Diretorio("Report")));
	}

	@Override
	public ArrayList<Diretorio> pastasLaserScanner(Viagem v) {
		return new ArrayList<Diretorio>(Arrays.asList(
				new Diretorio("Dados Brutos"), 
				new Diretorio("Documentação de Campo"), 
				new Diretorio("Imagens"), 
				new Diretorio("Processamento"), 
				new Diretorio("Report"), 
				new Diretorio("Visualização 3D")));
	}

	@Override
	public ArrayList<Arquivo> arquivosAmbiental(Viagem v, AmbientalTipo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arquivo> arquivosFotos(Viagem v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arquivo> arquivosGeofisica(Viagem v, Metodo m, Tipo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arquivo> arquivosGPS(Viagem v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arquivo> arquivosLaserScanner(Viagem v, LaserScannerTipo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arquivo> arquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arquivo> arquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arquivo> arquivosSIGArea(Area a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Arquivo> arquivosSIGDados(Projeto p, SIGDadoTipo t) {
		// TODO Auto-generated method stub
		return null;
	}

}
