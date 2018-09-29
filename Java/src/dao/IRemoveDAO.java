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

public interface IRemoveDAO {
    
    public void removeProjeto(Projeto p);
    public void removeArea(Projeto p, Area a);
    public void removeViagem(Projeto p, Area a, Viagem v);
    public void removePublicacao(Projeto p, Publicacao pb);
    public void removeRelatorio(Projeto p, Boolean Final, Relatorio r);
    
    public void removeArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq);
    public void removeArquivosFotos(Viagem v, Arquivo arq);
    public void removeArquivosGeofisica(Viagem v, Geofisica.Metodo m, Geofisica.Tipo t, Arquivo arq);
    public void removeArquivosGPS(Viagem v, Arquivo arq);
    public void removeArquivosLaserScanner(Viagem v, LaserScannerTipo t, Arquivo arq);
    public void removeArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq);
    public void removeArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq);
    public void removeArquivosSIGArea(Area a, Arquivo arq);
    public void removeArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq);
    
    /*
    public void removeArquivosAmbiental(Viagem v, AmbientalTipo t, ArrayList<Arquivo> vet);
	public void removeArquivosFotos(Viagem v, ArrayList<Arquivo> vet);
	public void removeArquivosGeofisica(Viagem v, Geofisica.Metodo m, Geofisica.Tipo t, ArrayList<Arquivo> vet);
	public void removeArquivosGPS(Viagem v, ArrayList<Arquivo> vet);
	public void removeArquivosLaserScanner(Viagem v, LaserScannerTipo t, ArrayList<Arquivo> vet);
	public void removeArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, ArrayList<Arquivo> vet);
	public void removeArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t, ArrayList<Arquivo> vet);
	public void removeArquivosSIGArea(Area a, ArrayList<Arquivo> vet);
	public void removeArquivosSIGDados(Projeto p, SIGDadoTipo t, ArrayList<Arquivo> vet);
	*/
}
