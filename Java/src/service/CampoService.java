/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDAO;
import dao.exceptions.CampoNaoExistenteException;
import dao.exceptions.CodigoCampoEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;
import service.model.Pesquisa;
import service.model.Viagem;


/**
 *
 * @author gabriel
 */
public class CampoService implements ICampoService {
    
    private IDAO dao;
    
    public CampoService (IDAO dao){
        this.dao = dao;
    }

    @Override
    public void inserirCampo(Viagem campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarCampo(Viagem campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerCampo(String codigo, Pesquisa pesquisa) throws CampoNaoExistenteException, PesquisaNaoExistenteException {
        dao.removerCampo(codigo, pesquisa);
    }

    @Override
    public Viagem consultarCampo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
