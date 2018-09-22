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
import gui.screens.LoggedIn;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.CampoService;
import service.ICampoService;

/**
 *
 * @author gabriel
 */
public class Main extends Application {
	
	IPesquisaService pesquisaService;
	ICampoService campoService;
	
	public Main() {
		this.pesquisaService = null;
		this.campoService = null;
	}
	
	public Main(IPesquisaService pesquisaService, ICampoService campoService) {
		/*this.pesquisaService = pesquisaService;
		this.campoService = campoService;*/
	}
	
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new LoggedIn());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	IDAO dao = new DAOMemoria();
    	IPesquisaService pesquisaService = new PesquisaService(dao);
        ICampoService campoService = new CampoService(dao);
        Main myApp = new Main(pesquisaService,campoService);
        launch(args);
        //TelaPrincipal principal = new TelaPrincipal(pesquisaService, campoService);
        //principal.setVisible(true);
    }
    
}
