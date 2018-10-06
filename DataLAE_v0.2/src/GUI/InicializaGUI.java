package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InicializaGUI extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = (BorderPane) FXMLLoader.load(this.getClass().getResource("principal/TelaPrincipal.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}