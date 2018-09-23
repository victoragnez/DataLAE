/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dao.ICreateDAO;
import dao.IQueryDAO;
import dao.IRemoveDAO;
import dao.IUpdateDAO;
import dao.QueryDAO;
import dao.RemoveDAO;
import dao.UpdateDAO;
import dao.CreateDAO;
import gui.screens.LoggedIn;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.CreateService;
import service.ICreateService;
import service.IQueryService;
import service.IRemoveService;
import service.IUpdateService;
import service.QueryService;
import service.RemoveService;
import service.UpdateService;
import service.antigos.ICampoService;
import service.antigos.IPesquisaService;
import service.antigos.PesquisaService;

/**
 *
 * @author gabriel
 */
public class Main extends Application {
	ICreateService createService;
	IQueryService queryService;
	IRemoveService removeService;
	IUpdateService updateService;
	
	public Main() {
		super();
		
		// Inicializa DAO
    	ICreateDAO createDAO = new CreateDAO();
    	IQueryDAO queryDAO = new QueryDAO();
    	IRemoveDAO removeDAO = new RemoveDAO();
    	IUpdateDAO updateDAO = new UpdateDAO();
    	
    	// Inicializa service
    	createService = new CreateService(createDAO);
    	queryService = new QueryService(queryDAO);
    	removeService = new RemoveService(removeDAO);
    	updateService = new UpdateService(updateDAO);
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
    	Main main = new Main();
    	launch(args);		// Executa a interface gráfica
    }
    
}
