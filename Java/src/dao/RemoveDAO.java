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
public class RemoveDAO implements IRemoveDAO {

    @Override
    public void removeProjeto(Projeto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArea(Projeto p, Area a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeViagem(Projeto p, Area a, Viagem v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePublicacao(Projeto p, Publicacao pb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeRelatorio(Projeto p, Boolean Final, Relatorio r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArquivosFotos(Viagem v, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArquivosGeofisica(Viagem v, Geofisica.Metodo m, Geofisica.Tipo t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArquivosGPS(Viagem v, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArquivosLaserScanner(Viagem v, LaserScannerTipo t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArquivosSIGArea(Area a, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
