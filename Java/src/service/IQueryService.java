package service;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import service.exceptions.AtributoInvalidoException;
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

public interface IQueryService {
	
    public ArrayList<Projeto> queryProjetos() throws MalformedURLException, 
            RemoteException, ClassNotFoundException, NotBoundException, 
            SQLException;
	
    public ArrayList<Area> queryAreas(Projeto p) throws MalformedURLException, 
            RemoteException, ClassNotFoundException, NotBoundException, 
            SQLException, AtributoInvalidoException;
    
    public ArrayList<Area> pastasSIGAreaEstudo(Projeto p) throws 
            MalformedURLException, RemoteException, ClassNotFoundException, 
            NotBoundException, SQLException, AtributoInvalidoException;
	
    public ArrayList<Viagem> queryViagens(Area a) throws MalformedURLException, 
            RemoteException, ClassNotFoundException, NotBoundException, 
            SQLException, AtributoInvalidoException;
	
    public ArrayList<Publicacao> queryPublicacoes(Projeto p, PublicacaoTipo t)
           throws AtributoInvalidoException;
           
    public ArrayList<Relatorio> queryRelatorios(Projeto p, Boolean Final)
           throws AtributoInvalidoException;
	
    
    
    public ArrayList<Diretorio> pastasProjeto(Projeto p)
           throws AtributoInvalidoException;
    
    public ArrayList<Diretorio> pastasModelagem(Projeto p)
           throws AtributoInvalidoException;
     
    public ArrayList<Diretorio> pastasModeloIntegrado(Projeto p)
           throws AtributoInvalidoException;
    
    public ArrayList<Diretorio> pastasPublicacoes(Projeto p)
           throws AtributoInvalidoException;
    
    public ArrayList<Diretorio> pastasRelatorios(Projeto p)
           throws AtributoInvalidoException;
            
    public ArrayList<Diretorio> pastasSIG(Projeto p)
           throws AtributoInvalidoException;
    
    public ArrayList<Diretorio> pastasSIGDados(Projeto p)
           throws AtributoInvalidoException;
    
    public ArrayList<Diretorio> pastasViagem(Viagem v)
           throws AtributoInvalidoException;
    
    public ArrayList<Diretorio> pastasAmbiental(Viagem v)
           throws AtributoInvalidoException;
    
    public ArrayList<Diretorio> pastasGeofisica(Viagem v)
           throws AtributoInvalidoException;
    
    public ArrayList<Diretorio> pastasGeofisica(Viagem v, Geofisica.Metodo m)
           throws AtributoInvalidoException;
    
    public ArrayList<Diretorio> pastasLaserScanner(Viagem v)
           throws AtributoInvalidoException;
    
    
                 
    public ArrayList<Arquivo> arquivosAmbiental(Viagem v, AmbientalTipo t)
           throws AtributoInvalidoException;
    
    public ArrayList<Arquivo> arquivosFotos(Viagem v)
           throws AtributoInvalidoException;
    
    public ArrayList<Arquivo> arquivosGeofisica(Viagem v, Geofisica.Metodo m, 
           Geofisica.Tipo t) throws AtributoInvalidoException;
    
    public ArrayList<Arquivo> arquivosGPS(Viagem v)
           throws AtributoInvalidoException;
    
    public ArrayList<Arquivo> arquivosLaserScanner(Viagem v, 
           LaserScannerTipo t) throws AtributoInvalidoException;
    
    public ArrayList<Arquivo> arquivosModelagem(Projeto p, 
           ModelagemOuModeloIntegrado t) throws AtributoInvalidoException;
    
    public ArrayList<Arquivo> arquivosModeloIntegrado(Projeto p, 
            ModelagemOuModeloIntegrado t) throws AtributoInvalidoException;
    
    public ArrayList<Arquivo> arquivosSIGArea(Area a)
           throws AtributoInvalidoException;
    
    public ArrayList<Arquivo> arquivosSIGDados(Projeto p, SIGDadoTipo t)
           throws AtributoInvalidoException;
}