/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.exceptions.CodigoPesquisaEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;

/**
 *
 * @author gabriel
 */
public interface IPesquisaService {
    
    public void inserirPesquisa (Pesquisa pesquisa) throws CodigoPesquisaEmUsoException;
    public void alterarPesquisa (Pesquisa pesquisa) throws PesquisaNaoExistenteException;
    public void removerPesquisa (String codigo) throws PesquisaNaoExistenteException;

    /**
     * Busca uma pesquisa 
     * @param codigo o codigo da pesquisa
     * @return A pesquisa que corresponde ao código
     */
    public Pesquisa consultarPesquisa (String codigo);
}
