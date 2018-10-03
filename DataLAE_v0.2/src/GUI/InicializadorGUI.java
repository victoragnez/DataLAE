package GUI;

import DAO.ProjetoDAO;
import Service.LocalService;
import Service.ProjetoService;
import Service.ViagemService;
import Service.Interfaces.ILocalService;
import Service.Interfaces.IProjetoService;
import Service.Interfaces.IViagemService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InicializadorGUI extends Application {
	private IProjetoService projService;
	private ILocalService localService;
	private IViagemService viagemService;
	private BorderPane telaPrincipal;
	
	public InicializadorGUI() {
		projService = new ProjetoService(new ProjetoDAO());
		localService = new LocalService();
		viagemService = new ViagemService();
		
		// Inicializa tela
		telaPrincipal = new TelaPrincipal(projService, localService,viagemService);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(telaPrincipal);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
