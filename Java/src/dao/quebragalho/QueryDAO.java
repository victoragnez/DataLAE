package dao.quebragalho;

import java.util.ArrayList;
import java.util.Calendar;

import dao.IQueryDAO;
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

public class QueryDAO implements IQueryDAO {

	// Implementações quebra-galho abaixo:
	public ArrayList<Projeto> queryProjetos() {
		ArrayList<Projeto> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Projeto pesq = new Projeto();
			pesq.setDenomicacao("Pesquisa "+i);
			pesq.setCoordenador("Coordenador " + i);
			pesq.setFinanciador("Financiador " + i);
			list.add(pesq);
		}
		return list;
	}

	
	public ArrayList<Area> queryAreas(Projeto p) {
		ArrayList<Area> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			list.add(new Area(Integer.toString(i), "Área" + i + " da " + p.getDenomicacao()));
		}
		return list;
	}

	
	public ArrayList<Viagem> queryViagens(Area a) {
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

	
	public ArrayList<Diretorio> PastasProjeto(Projeto p) {
		ArrayList<Diretorio> list = new ArrayList<>();
		list.add(new Diretorio("Área de Pesquisa"));
		list.add(new Diretorio("Modelagem"));
		list.add(new Diretorio("Publicações"));
		list.add(new Diretorio("Relatórios"));
		list.add(new Diretorio("SIG"));
		
		return list;
	}

	
	public ArrayList<Diretorio> PastasModelagem(Projeto p) {
		ArrayList<Diretorio> list = new ArrayList<>();
		list.add(new Diretorio("Imagens"));
		list.add(new Diretorio("Report"));
		list.add(new Diretorio("Superfícies 2D"));
		list.add(new Diretorio("Vizualizção 3D"));
		
		return list;
	}

	
	public ArrayList<Diretorio> PastasModeloIntegrado(Projeto p) {
		ArrayList<Diretorio> list = new ArrayList<>();
		list.add(new Diretorio("Imagens"));
		list.add(new Diretorio("Report"));
		list.add(new Diretorio("Superfícies 2D"));
		list.add(new Diretorio("Vizualizção 3D"));
		
		return list;
	}

	
	public ArrayList<Diretorio> PastasPublicacoes(Projeto p) {
		ArrayList<Diretorio> list = new ArrayList<>();
		list.add(new Diretorio("Artigos"));
		list.add(new Diretorio("Congresso"));
		list.add(new Diretorio("Dissertações"));
		list.add(new Diretorio("TCC"));
		list.add(new Diretorio("Teses"));
		
		return list;
	}

	
	public ArrayList<Diretorio> PastasRelatorios(Projeto p) {
		ArrayList<Diretorio> list = new ArrayList<>();
		list.add(new Diretorio("Final"));
		list.add(new Diretorio("Parcial"));
		
		return list;
	}

	
	public ArrayList<Diretorio> PastasSIG(Projeto p) {
		ArrayList<Diretorio> list = new ArrayList<>();
		list.add(new Diretorio("Áreas de Estudo"));
		list.add(new Diretorio("Dados"));
		
		return list;
	}

	
	public ArrayList<Diretorio> PastasSIGAreaEstudo(Projeto p) {
		ArrayList<Diretorio> list = new ArrayList<>();
		list.add(new Diretorio("Arapuá"));
		list.add(new Diretorio("Furma Feia"));
		list.add(new Diretorio("Toca da Barriguda"));
		list.add(new Diretorio("Toca da Boa Vista"));
		
		return list;
	}

	
	public ArrayList<Diretorio> PastasSIGDados(Projeto p) {
		ArrayList<Diretorio> list = new ArrayList<>();
		list.add(new Diretorio("Dados"));
		list.add(new Diretorio("Imagens Aéreas"));
		list.add(new Diretorio("Modelo Digital de Elevação"));
		list.add(new Diretorio("Planilhas"));
		list.add(new Diretorio("Shapes"));
		
		return list;
	}

	@Override
	public ArrayList<Diretorio> pastasViagem(Viagem v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasAmbiental(Viagem v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasGeofisica(Viagem v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasGeofisica(Viagem v, Metodo m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasLaserScanner(Viagem v) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public ArrayList<Area> pastasSIGAreaEstudo(Projeto p) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasModelagem(Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasModeloIntegrado(Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasPublicacoes(Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasRelatorios(Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasSIG(Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diretorio> pastasSIGDados(Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

}
