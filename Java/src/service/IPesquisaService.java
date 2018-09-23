/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author gabriel
 */
public interface IPesquisaService {
    
    public void inserirPesquisa (Pesquisa pesquisa);
    public void alterarPesquisa (Pesquisa pesquisa);
    public void removerPesquisa (String codigo);

    /**
     * Busca uma pesquisa 
     * @param codigo o codigo da pesquisa
     * @return A pesquisa que corresponde ao código
     */
    public Pesquisa consultarPesquisa (String codigo);
}
