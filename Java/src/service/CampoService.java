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
    public void inserirCampo(Campo campo, Pesquisa pesquisa) throws CodigoCampoEmUsoException, PesquisaNaoExistenteException {
        dao.inserirCampo(campo, pesquisa);
    }

    @Override
    public void alterarCampo(Campo campo, Pesquisa pesquisa) throws CampoNaoExistenteException, PesquisaNaoExistenteException {
        dao.alterarCampo(campo, pesquisa);
    }

    @Override
    public void removerCampo(String codigo, Pesquisa pesquisa) throws CampoNaoExistenteException, PesquisaNaoExistenteException {
        dao.removerCampo(codigo, pesquisa);
    }

    @Override
    public Campo consultarCampo(String codigo, Pesquisa pesquisa) throws CampoNaoExistenteException, PesquisaNaoExistenteException {
        return dao.consultarCampo(codigo, pesquisa);
    }  
}
