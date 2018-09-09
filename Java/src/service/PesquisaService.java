/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IPesquisaDAO;
import dao.exceptions.PesquisaNaoExistenteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class PesquisaService implements IPesquisaService {

    private IPesquisaDAO pesquisaDAO;
    
    public PesquisaService (IPesquisaDAO pesquisaDAO){
        this.pesquisaDAO = pesquisaDAO;
    }
    
    @Override
    public void inserirPesquisa(Pesquisa pesquisa) {
        pesquisaDAO.inserirPesquisa(pesquisa);
    }

    @Override
    public void alterarPesquisa(Pesquisa pesquisa) {
        pesquisaDAO.alterarPesquisa(pesquisa);
    }

    @Override
    public void removerPesquisa(String codigo) {
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
