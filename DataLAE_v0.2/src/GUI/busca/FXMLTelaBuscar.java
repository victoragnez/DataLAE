package GUI.busca;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FXMLTelaBuscar implements Initializable {
	
	private Pane buscarProjeto;
	private Pane buscarLocal;
	private Pane buscarViagem;
	private Pane buscarArquivo;
	
	@FXML
	private ComboBox<String> comboBox;
	
	@FXML
	private BorderPane main;
	
	@FXML
	private void mudarTela(ActionEvent event) {
		String value = comboBox.getValue();
		
		if(value == "Projeto") {
			main.setCenter(buscarProjeto);
		}
		else if(value == "Local") {
			main.setCenter(buscarLocal);
		}
		else if(value == "Viagem") {
			main.setCenter(buscarViagem);
		}
		else if(value == "Arquivo")
			main.setCenter(buscarArquivo);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.getItems().addAll("Projeto", "Local","Viagem", "Arquivo");
		
		try {
			buscarProjeto = FXMLLoader.load(FXMLTelaBuscar.class.getResource("./quebragalho/FXMLBuscaProjeto.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
