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
	public ArrayList<Area> pastasSIGAreaEstudo(Projeto p);
	
	public ArrayList<Viagem> queryViagens(Area a);
	
	public ArrayList<Publicacao> queryPublicacoes(Projeto p, PublicacaoTipo t);
	
	public ArrayList<Relatorio> queryRelatorios(Projeto p, Boolean Final);
	
	public ArrayList<Diretorio> pastasProjeto(Projeto p);
	public ArrayList<Diretorio> pastasModelagem(Projeto p);
	public ArrayList<Diretorio> pastasModeloIntegrado(Projeto p);
	public ArrayList<Diretorio> pastasPublicacoes(Projeto p);
	public ArrayList<Diretorio> pastasRelatorios(Projeto p);
	public ArrayList<Diretorio> pastasSIG(Projeto p);
	public ArrayList<Diretorio> pastasSIGDados(Projeto p);
	public ArrayList<Diretorio> pastasViagem(Viagem v);
	public ArrayList<Diretorio> pastasAmbiental(Viagem v);
	public ArrayList<Diretorio> pastasGeofisica(Viagem v);
	public ArrayList<Diretorio> pastasGeofisica(Viagem v, Geofisica.Metodo m);
	public ArrayList<Diretorio> pastasLaserScanner(Viagem v);
	
	public ArrayList<Arquivo> arquivosAmbiental(Viagem v, AmbientalTipo t);
	public ArrayList<Arquivo> arquivosFotos(Viagem v);
	public ArrayList<Arquivo> arquivosGeofisica(Viagem v, Geofisica.Metodo m, Geofisica.Tipo t);
	public ArrayList<Arquivo> arquivosGPS(Viagem v);
	public ArrayList<Arquivo> arquivosLaserScanner(Viagem v, LaserScannerTipo t);
	public ArrayList<Arquivo> arquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t);
	public ArrayList<Arquivo> arquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t);
	public ArrayList<Arquivo> arquivosSIGArea(Area a);
	public ArrayList<Arquivo> arquivosSIGDados(Projeto p, SIGDadoTipo t);
	
}
