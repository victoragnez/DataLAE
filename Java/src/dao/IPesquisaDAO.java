/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.Pesquisa;
import dao.exceptions.PesquisaNaoExistenteException;

public interface IPesquisaDAO {
    public void inserirPesquisa(Pesquisa pesquisa);
    public void alterarPesquisa(Pesquisa pesquisa);
    public void removerPesquisa(String codigo);
    public Pesquisa consultarPesquisa(String codigo) throws PesquisaNaoExistenteException;
}
