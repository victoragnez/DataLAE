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
import dao.quebragalho.CreateDAO;
import dao.quebragalho.QueryDAO;
import dao.quebragalho.RemoveDAO;
import dao.quebragalho.UpdateDAO;
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

/**
 *
 * @author gabriel
 */
public class Main extends Application {
	private ICreateService createService;
	private IQueryService queryService;
	private IRemoveService removeService;
	private IUpdateService updateService;
	
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
        Scene scene = new Scene(new LoggedIn(this.queryService));
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
