/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.DAOMemoria;
import service.IPesquisaService;
import service.PesquisaService;
import dao.IDAO;
import gui.App;
import service.CampoService;
import service.ICampoService;

/**
 *
 * @author gabriel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	IDAO dao = new DAOMemoria();
    	IPesquisaService pesquisaService = new PesquisaService(dao);
        ICampoService campoService = new CampoService(dao);
        App.launch(args);
        //TelaPrincipal principal = new TelaPrincipal(pesquisaService, campoService);
        //principal.setVisible(true);
    }
    
}
