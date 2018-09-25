package service;

import service.exceptions.AtributoInvalidoException;
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

public interface ICreateService {
    
    public void criaProjeto(Projeto p) throws AtributoInvalidoException;
    public void criaArea(Projeto p, Area a) throws AtributoInvalidoException;
    public void criaViagem(Projeto p, Area a, Viagem v) 
            throws AtributoInvalidoException;
    public void criaPublicacao(Projeto p, Publicacao pb) 
            throws AtributoInvalidoException;
    public void criaRelatorio(Projeto p, Boolean Final, Relatorio r)
            throws AtributoInvalidoException;
    
    public void criaArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq)
            throws AtributoInvalidoException;
    public void criaArquivosFotos(Viagem v, Arquivo arq)
            throws AtributoInvalidoException;
    public void criaArquivosGeofisica(Viagem v, Geofisica.Metodo m, 
            Geofisica.Tipo t, Arquivo arq) throws AtributoInvalidoException;
    public void criaArquivosGPS(Viagem v, Arquivo arq)
            throws AtributoInvalidoException;
    public void criaArquivosLaserScanner(Viagem v, LaserScannerTipo t, 
            Arquivo arq) throws AtributoInvalidoException;
    public void criaArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t,
            Arquivo arq) throws AtributoInvalidoException;
    public void criaArquivosModeloIntegrado(Projeto p,
            ModelagemOuModeloIntegrado t, Arquivo arq)
            throws AtributoInvalidoException;
    public void criaArquivosSIGArea(Area a, Arquivo arq)
            throws AtributoInvalidoException;
    public void criaArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq)
            throws AtributoInvalidoException;
}
