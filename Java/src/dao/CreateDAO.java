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

/**
 *
 * @author gabriel
 */
public class CreateDAO implements ICreateDAO {

    @Override
    public void criaProjeto(Projeto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArea(Projeto p, Area a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaViagem(Projeto p, Area a, Viagem v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaPublicacao(Projeto p, Publicacao pb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaRelatorio(Projeto p, Boolean Final, Relatorio r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArquivosFotos(Viagem v, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArquivosGeofisica(Viagem v, Geofisica.Metodo m, Geofisica.Tipo t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArquivosGPS(Viagem v, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArquivosLaserScanner(Viagem v, LaserScannerTipo t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArquivosSIGArea(Area a, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void criaArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
