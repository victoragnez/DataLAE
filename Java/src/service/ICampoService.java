/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.exceptions.CampoNaoExistenteException;
import dao.exceptions.CodigoCampoEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;
import service.exceptions.CampoInvalidoException;
import service.exceptions.PesquisaInvalidaException;

/**
 * Interface para serviço de acesso ao Campo
 * @author gabriel
 */
public interface ICampoService {
    
    public void inserirCampo (Campo campo, Pesquisa pesquisa) throws 
            CodigoCampoEmUsoException, PesquisaNaoExistenteException ;
    public void alterarCampo (Campo campo, Pesquisa pesquisa) throws 
            CampoNaoExistenteException, PesquisaNaoExistenteException ;
    public void removerCampo (String codigo, Pesquisa pesquisa) throws
            CampoNaoExistenteException, PesquisaNaoExistenteException ;
    public Campo consultarCampo (String codigo, Pesquisa pesquisa) throws
            CampoNaoExistenteException, PesquisaNaoExistenteException;

}
