/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.model.AmbientalTipo;
import service.model.Area;
import service.model.Arquivo;
import service.model.Diretorio;
import service.model.Geofisica;
import service.model.LaserScannerTipo;
import service.model.ModelagemOuModeloIntegrado;
import service.model.Projeto;
import service.model.Publicacao;
import service.model.PublicacaoTipo;
import service.model.Relatorio;
import service.model.SIGDadoTipo;
import service.model.Viagem;

import java.util.ArrayList;

public interface IQueryDAO {
	
	public ArrayList<Projeto> queryProjetos();
	
	public ArrayList<Area> queryAreas(Projeto p);
	
	public ArrayList<Viagem> queryViagens(Area a);
	
	public ArrayList<Publicacao> queryPublicacoes(Projeto p, PublicacaoTipo t);
	
	public ArrayList<Relatorio> queryRelatorios(Projeto p, Boolean Final);
	
	public ArrayList<Diretorio> PastasProjeto(Projeto p);
	public ArrayList<Diretorio> PastasModelagem(Projeto p);
	public ArrayList<Diretorio> PastasModeloIntegrado(Projeto p);
	public ArrayList<Diretorio> PastasPublicacoes(Projeto p);
	public ArrayList<Diretorio> PastasRelatorios(Projeto p);
	public ArrayList<Diretorio> PastasSIG(Projeto p);
	public ArrayList<Diretorio> PastasSIGAreaEstudo(Projeto p);
	public ArrayList<Diretorio> PastasSIGDados(Projeto p);
	public ArrayList<Diretorio> PastasViagem(Viagem v);
	public ArrayList<Diretorio> PastasAmbiental(Viagem v);
	public ArrayList<Diretorio> PastasGeofisica(Viagem v);
	public ArrayList<Diretorio> PastasGeofisica(Viagem v, Geofisica.Metodo m);
	public ArrayList<Diretorio> PastasLaserScanner(Viagem v);
	
	public ArrayList<Arquivo> ArquivosAmbiental(Viagem v, AmbientalTipo t);
	public ArrayList<Arquivo> ArquivosFotos(Viagem v);
	public ArrayList<Arquivo> ArquivosGeofisica(Viagem v, Geofisica.Metodo m, Geofisica.Tipo t);
	public ArrayList<Arquivo> ArquivosGPS(Viagem v);
	public ArrayList<Arquivo> ArquivosLaserScanner(Viagem v, LaserScannerTipo t);
	public ArrayList<Arquivo> ArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t);
	public ArrayList<Arquivo> ArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t);
	public ArrayList<Arquivo> ArquivosSIGArea(Area a);
	public ArrayList<Arquivo> ArquivosSIGDados(Projeto p, SIGDadoTipo t);
	
}
