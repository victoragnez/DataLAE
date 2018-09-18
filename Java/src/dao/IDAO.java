/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.CampoNaoExistenteException;
import dao.exceptions.CodigoCampoEmUsoException;
import dao.exceptions.CodigoInvalidoException;
import service.Pesquisa;

import java.util.ArrayList;
import dao.exceptions.CodigoPesquisaEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;
import service.Campo;

public interface IDAO {

    public void inserirPesquisa(Pesquisa pesquisa) throws CodigoPesquisaEmUsoException;
    public void alterarPesquisa(Pesquisa pesquisa) throws PesquisaNaoExistenteException;
    public void removerPesquisa(String codigo) throws PesquisaNaoExistenteException;
    public Pesquisa consultarPesquisa(String codigo) throws PesquisaNaoExistenteException;
    public ArrayList<Pesquisa> consultarPesquisa(Pesquisa pesquisa);

    public void inserirCampo(Campo campo, Pesquisa pesquisa) throws 
            CodigoInvalidoException, PesquisaNaoExistenteException;
    public void alterarCampo(Campo campo, Pesquisa pesquisa) throws
            CampoNaoExistenteException, PesquisaNaoExistenteException;
    public void removerPesquisa(String codigoCampo, Pesquisa pesquisa) throws
            CampoNaoExistenteException, PesquisaNaoExistenteException;
    public Campo consultarCampo(String codigoCampo, Pesquisa pesquisa) throws
            CampoNaoExistenteException, PesquisaNaoExistenteException;           

}
