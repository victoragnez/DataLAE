package GUI.cadastro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class FXMLTelaCadastroController implements Initializable {
	@FXML
	private ComboBox<String> comboBox;
	
	@FXML
	private BorderPane main;
	
	@FXML
	private void mudarTela(ActionEvent event) {
		String value = comboBox.getValue();
		if(value == "Projeto") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("model/FXMLCadProj.fxml")));
			} catch (IOException e) {
				System.out.println("Preciso avisar ao cliente que o arquivo não foi encontrado");
				System.exit(-1);
			}
		}
			
		else if(value == "Local") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("model/FXMLCadLocal.fxml")));
			} catch (IOException e) {
				System.out.println("Preciso avisar ao cliente que o arquivo não foi encontrado");
				System.exit(-1);
			}
		}
		else if(value == "Viagem") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("model/FXMLCadViagem.fxml")));
			} catch (IOException e) {
				System.out.println("Preciso avisar ao cliente que o arquivo não foi encontrado");
				System.exit(-1);
			}
		}
		else if(value == "Arquivo")
			main.setCenter(null);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.getItems().addAll("Projeto","Local","Viagem","Arquivo");
	}

}
