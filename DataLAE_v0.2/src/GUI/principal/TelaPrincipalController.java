package GUI.principal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TelaPrincipalController implements Initializable {
	@FXML
	private BorderPane main;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Pane telaSecundaria = FXMLLoader.load(TelaPrincipalController.class.getResource("TelaSecundaria.fxml"));
			main.setCenter(telaSecundaria);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
