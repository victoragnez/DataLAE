/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.model.AmbientalTipo;
import service.model.Area;
import service.model.Arquivo;
import service.model.Geofisica;
import service.model.LaserScannerTipo;
import service.model.ModelagemOuModeloIntegrado;
import service.model.Projeto;
import service.model.Publicacao;
import service.model.Relatorio;
import service.model.SIGDadoTipo;
import service.model.Viagem;

public interface ICreateDAO {
    public void criaProjeto(Projeto p);
    public void criaArea(Projeto p, Area a);
    public void criaViagem(Projeto p, Area a, Viagem v);
    public void criaPublicacao(Projeto p, Publicacao pb);
    public void criaRelatorio(Projeto p, Boolean Final, Relatorio r);
    
    public void criaArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq);
	public void criaArquivosFotos(Viagem v, Arquivo arq);
	public void criaArquivosGeofisica(Viagem v, Geofisica.Metodo m, Geofisica.Tipo t, Arquivo arq);
	public void criaArquivosGPS(Viagem v, Arquivo arq);
	public void criaArquivosLaserScanner(Viagem v, LaserScannerTipo t, Arquivo arq);
	public void criaArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq);
	public void criaArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq);
	public void criaArquivosSIGArea(Area a, Arquivo arq);
	public void criaArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq);
    
    /*
    public void criaArquivosAmbiental(Viagem v, AmbientalTipo t, ArrayList<Arquivo> vet);
	public void criaArquivosFotos(Viagem v, ArrayList<Arquivo> vet);
	public void criaArquivosGeofisica(Viagem v, Geofisica.Metodo m, Geofisica.Tipo t, ArrayList<Arquivo> vet);
	public void criaArquivosGPS(Viagem v, ArrayList<Arquivo> vet);
	public void criaArquivosLaserScanner(Viagem v, LaserScannerTipo t, ArrayList<Arquivo> vet);
	public void criaArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, ArrayList<Arquivo> vet);
	public void criaArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t, ArrayList<Arquivo> vet);
	public void criaArquivosSIGArea(Area a, ArrayList<Arquivo> vet);
	public void criaArquivosSIGDados(Projeto p, SIGDadoTipo t, ArrayList<Arquivo> vet);
	*/
}