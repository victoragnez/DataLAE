package GUI.cadastro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXCadProj extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("model/FXMLCadProj.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
