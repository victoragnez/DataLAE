/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ICreateDAO;
import dao.exceptions.CodigoPesquisaEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;

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
        pesquisaDAO.inserirPesquisa(pesquisa);
    }

    @Override
    public void alterarPesquisa(Pesquisa pesquisa) throws PesquisaNaoExistenteException {
        pesquisaDAO.alterarPesquisa(pesquisa);
    }

    @Override
    public void removerPesquisa(String codigo) throws PesquisaNaoExistenteException {
        pesquisaDAO.removerPesquisa(codigo);
    }

    @Override
    public Pesquisa consultarPesquisa(String codigo) {
        Pesquisa pesquisa = null;
        
        try {
            pesquisa = pesquisaDAO.consultarPesquisa(codigo);
        } catch (PesquisaNaoExistenteException ex) {
            System.out.println(ex);
        }
        return pesquisa;
    }
    
}   
