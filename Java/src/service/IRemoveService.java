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

public interface IRemoveService {
    
    public void removeProjeto(Projeto p) throws AtributoInvalidoException;
    public void removeArea(Projeto p, Area a) throws AtributoInvalidoException;
    public void removeViagem(Projeto p, Area a, Viagem v) 
            throws AtributoInvalidoException ;
    public void removePublicacao(Projeto p, Publicacao pb)
            throws AtributoInvalidoException;
    public void removeRelatorio(Projeto p, Boolean Final, Relatorio r)
            throws AtributoInvalidoException;
    
    public void removeArquivosAmbiental(Viagem v, AmbientalTipo t, Arquivo arq)
            throws AtributoInvalidoException;
    public void removeArquivosFotos(Viagem v, Arquivo arq)
            throws AtributoInvalidoException;
    public void removeArquivosGeofisica(Viagem v, Geofisica.Metodo m, 
            Geofisica.Tipo t, Arquivo arq) throws AtributoInvalidoException;
    public void removeArquivosGPS(Viagem v, Arquivo arq) 
            throws AtributoInvalidoException;
    public void removeArquivosLaserScanner(Viagem v, LaserScannerTipo t, 
            Arquivo arq) throws AtributoInvalidoException;
    public void removeArquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t,
            Arquivo arq) throws AtributoInvalidoException;
    public void removeArquivosModeloIntegrado(Projeto p,
            ModelagemOuModeloIntegrado t, Arquivo arq) 
            throws AtributoInvalidoException;
    public void removeArquivosSIGArea(Area a, Arquivo arq) 
            throws AtributoInvalidoException;
    public void removeArquivosSIGDados(Projeto p, SIGDadoTipo t, Arquivo arq)
            throws AtributoInvalidoException;
}
