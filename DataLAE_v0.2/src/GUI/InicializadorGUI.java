package GUI;

import DAO.ProjetoDAO;
import GUI.cadastro.CadastroProjeto;
import Service.ProjetoService;
import Service.Interfaces.IProjetoService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InicializadorGUI extends Application {
	private IProjetoService projService;
	
	private GridPane telaCadastroProjeto;
	private BorderPane telaPrincipal;
	
	public InicializadorGUI() {
		projService = new ProjetoService(new ProjetoDAO());
		
		// Inicializa tela
		telaCadastroProjeto = new CadastroProjeto(projService);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(telaCadastroProjeto);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
