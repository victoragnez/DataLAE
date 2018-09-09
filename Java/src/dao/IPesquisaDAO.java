/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.Pesquisa;

import java.util.ArrayList;
import dao.exceptions.CodigoPesquisaEmUsoException;
import dao.exceptions.PesquisaNaoExistenteException;

public interface IPesquisaDAO {
    public void inserirPesquisa(Pesquisa pesquisa) throws CodigoPesquisaEmUsoException;
    public void alterarPesquisa(Pesquisa pesquisa) throws PesquisaNaoExistenteException;
    public void removerPesquisa(String codigo) throws PesquisaNaoExistenteException;
    public Pesquisa consultarPesquisa(String codigo) throws PesquisaNaoExistenteException;
    public ArrayList<Pesquisa> consultarPesquisa(Pesquisa pesquisa);
}
