package service;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.IQueryDAO;
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

public class QueryService implements IQueryService {
    private IQueryDAO queryDAO;
    
    public QueryService(IQueryDAO queryDAO) {
	this.queryDAO = queryDAO;
    }
	
    // ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois:

    @Override
    public ArrayList<Projeto> queryProjetos() throws MalformedURLException, 
            RemoteException, ClassNotFoundException, NotBoundException, 
            SQLException 
    {
        return queryDAO.queryProjetos();
    }

    @Override
    public ArrayList<Area> queryAreas(Projeto p) throws MalformedURLException, 
            RemoteException, ClassNotFoundException, NotBoundException, 
            SQLException, AtributoInvalidoException 
    {
        if (p == null) 
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.queryAreas(p);
    }

    @Override
    public ArrayList<Area> pastasSIGAreaEstudo(Projeto p) throws 
            MalformedURLException, RemoteException, ClassNotFoundException, 
            NotBoundException, SQLException, AtributoInvalidoException 
    {
        if (p == null )
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.pastasSIGAreaEstudo(p);
    }

    @Override
    public ArrayList<Viagem> queryViagens(Area a) throws MalformedURLException,
            RemoteException, ClassNotFoundException, NotBoundException, 
            SQLException, AtributoInvalidoException 
    {
        if (a == null)
            throw new AtributoInvalidoException("Área inválida");
        return queryDAO.queryViagens(a);
    }

    @Override
    public ArrayList<Publicacao> queryPublicacoes(Projeto p, PublicacaoTipo t) 
            throws AtributoInvalidoException 
    {
        if (p == null || t == null)
            throw new AtributoInvalidoException("Projeto ou tipo de publicação "
                    + "inválidos");
        return queryDAO.queryPublicacoes(p, t);
    }

    @Override
    public ArrayList<Relatorio> queryRelatorios(Projeto p, Boolean Final) 
            throws AtributoInvalidoException 
    {
        if (p == null)
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.queryRelatorios(p, Final);
    }

    @Override
    public ArrayList<Diretorio> pastasProjeto(Projeto p) throws 
            AtributoInvalidoException 
    {
        if (p == null)
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.pastasProjeto(p);
    }

    @Override
    public ArrayList<Diretorio> pastasModelagem(Projeto p) throws 
            AtributoInvalidoException 
    {
        if (p == null)
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.pastasModelagem(p);
    }

    @Override
    public ArrayList<Diretorio> pastasModeloIntegrado(Projeto p) throws 
            AtributoInvalidoException 
    {
        if (p == null)
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.pastasModeloIntegrado(p);
    }   

    @Override
    public ArrayList<Diretorio> pastasPublicacoes(Projeto p) throws 
            AtributoInvalidoException 
    {
        if (p == null)
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.pastasPublicacoes(p);
    }

    @Override
    public ArrayList<Diretorio> pastasRelatorios(Projeto p) throws 
            AtributoInvalidoException 
    {
        if (p == null)
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.pastasRelatorios(p);
    }

    @Override
    public ArrayList<Diretorio> pastasSIG(Projeto p) throws 
            AtributoInvalidoException 
    {
        if (p == null)
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.pastasSIG(p);
    }

    @Override
    public ArrayList<Diretorio> pastasSIGDados(Projeto p) throws 
            AtributoInvalidoException
    {
        if (p == null)
            throw new AtributoInvalidoException("Projeto inválido");
        return queryDAO.pastasSIGDados(p);
    }

    @Override
    public ArrayList<Diretorio> pastasViagem(Viagem v) throws 
            AtributoInvalidoException 
    {
        if (v == null)
            throw new AtributoInvalidoException("Viagem inválida");
        return queryDAO.pastasViagem(v);
    }

    @Override
    public ArrayList<Diretorio> pastasAmbiental(Viagem v) throws
            AtributoInvalidoException 
    {
        if (v == null)
            throw new AtributoInvalidoException("Viagem inválida");
        return queryDAO.pastasAmbiental(v);
    }

    @Override
    public ArrayList<Diretorio> pastasGeofisica(Viagem v) throws 
            AtributoInvalidoException 
    {
        if (v == null)
            throw new AtributoInvalidoException("Viagem inválida");
        return queryDAO.pastasGeofisica(v);
    }

    @Override
    public ArrayList<Diretorio> pastasGeofisica(Viagem v, Geofisica.Metodo m) 
            throws AtributoInvalidoException 
    {
        if (v == null || m == null)
            throw new AtributoInvalidoException("Viagem ou método inválidos");
        return queryDAO.pastasGeofisica(v, m);
    }

    @Override
    public ArrayList<Diretorio> pastasLaserScanner(Viagem v) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Arquivo> arquivosAmbiental(Viagem v, AmbientalTipo t) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Arquivo> arquivosFotos(Viagem v) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Arquivo> arquivosGeofisica(Viagem v, Geofisica.Metodo m, Geofisica.Tipo t) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Arquivo> arquivosGPS(Viagem v) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Arquivo> arquivosLaserScanner(Viagem v, LaserScannerTipo t) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Arquivo> arquivosModelagem(Projeto p, ModelagemOuModeloIntegrado t) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Arquivo> arquivosModeloIntegrado(Projeto p, ModelagemOuModeloIntegrado t) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Arquivo> arquivosSIGArea(Area a) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Arquivo> arquivosSIGDados(Projeto p, SIGDadoTipo t) throws AtributoInvalidoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
}
