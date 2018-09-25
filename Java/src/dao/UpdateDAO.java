/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.model.Area;
import service.model.Projeto;
import service.model.Publicacao;
import service.model.Relatorio;
import service.model.Viagem;

/**
 *
 * @author gabriel
 */
public class UpdateDAO implements IUpdateDAO{

    @Override
    public void updateProjeto(Projeto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateArea(Projeto p, Area a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateViagem(Projeto p, Area a, Viagem v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePublicacao(Projeto p, Publicacao pb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRelatorio(Projeto p, Boolean Final, Relatorio r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
