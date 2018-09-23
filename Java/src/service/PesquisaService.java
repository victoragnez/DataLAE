/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ICreateDAO;
import dao.exceptions.CodigoPesquisaEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;
import service.model.Pesquisa;

import java.util.ArrayList;
import dao.IDAO;

/**
 *
 * @author gabriel
 */
public class PesquisaService implements IPesquisaService {

    private ICreateDAO pesquisaDAO;
    
    public PesquisaService (ICreateDAO pesquisaDAO){
        this.pesquisaDAO = pesquisaDAO;
    }
    
    @Override
    public void inserirPesquisa(Pesquisa pesquisa) throws CodigoPesquisaEmUsoException {
        dao.inserirPesquisa(pesquisa);
    }

    @Override
    public void alterarPesquisa(Pesquisa pesquisa) throws PesquisaNaoExistenteException {
        dao.alterarPesquisa(pesquisa);
    }

    @Override
    public void removerPesquisa(String codigo) throws PesquisaNaoExistenteException {
        dao.removerPesquisa(codigo);
    }

    @Override
    public Pesquisa consultarPesquisa(String codigo) {
        Pesquisa pesquisa = null;
        
        try {
            pesquisa = dao.consultarPesquisa(codigo);
        } catch (PesquisaNaoExistenteException ex) {
            System.out.println(ex);
        }
        return pesquisa;
    }
    
    public ArrayList<Pesquisa> consultarPesquisa(Pesquisa pesquisa) {
        return dao.consultarPesquisa(pesquisa);
    }
    
}   
