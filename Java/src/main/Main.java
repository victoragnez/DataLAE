/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.IPesquisaDAO;
import dao.PesquisaDAOMemoria;
import gui.TelaPrincipal;
import service.IPesquisaService;
import service.PesquisaService;

/**
 *
 * @author gabriel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	IPesquisaDAO dao = new PesquisaDAOMemoria();
    	IPesquisaService service = new PesquisaService(dao);
        TelaPrincipal principal = new TelaPrincipal(service);
        principal.setVisible(true);
    }
    
}
