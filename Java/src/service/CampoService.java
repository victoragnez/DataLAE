/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDAO;

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
    public void inserirCampo(Campo campo, Pesquisa pesquisa) {
        
    }

    @Override
    public void alterarCampo(Campo campo, Pesquisa pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerCampo(String codigo, Pesquisa pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Campo consultarCampo(String codigo, Pesquisa pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
