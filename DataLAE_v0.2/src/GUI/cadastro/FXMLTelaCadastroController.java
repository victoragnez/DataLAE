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
import javafx.scene.layout.Pane;

public class FXMLTelaCadastroController implements Initializable {
	
	private Pane cadastrarProjeto;
	private Pane cadastrarLocal;
	private Pane cadastrarViagem;
	private Pane cadastrarArquivo;
	
	@FXML
	private ComboBox<String> comboBox;
	
	@FXML
	private BorderPane main;
	
	@FXML
	private void mudarTela(ActionEvent event) {
		String value = comboBox.getValue();
		if(value == "Projeto")
			main.setCenter(cadastrarProjeto);
		else if(value == "Local")
			main.setCenter(cadastrarLocal);
		else if(value == "Viagem")
			main.setCenter(cadastrarViagem);
		else if(value == "Arquivo")
			main.setCenter(cadastrarArquivo);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.getItems().addAll("Projeto","Local","Viagem","Arquivo");
		
		// Iniciar telas de cadastro
		try {
			cadastrarProjeto = FXMLLoader.load(this.getClass().getResource("FXMLCadProj.fxml"));
		} catch (IOException e) {
			System.out.println("Preciso avisar ao cliente que o arquivo não foi encontrado");
			System.exit(-1);
		}
		/*
		try {
			cadastrarLocal = FXMLLoader.load(this.getClass().getResource("FXMLCadLocal.fxml"));
		} catch (IOException e) {
			System.out.println("Preciso avisar ao cliente que o arquivo não foi encontrado");
			System.exit(-1);
		}
		
		try {
			cadastrarViagem = FXMLLoader.load(this.getClass().getResource("FXMLCadViagem.fxml"));
		} catch (IOException e) {
			System.out.println("Preciso avisar ao cliente que o arquivo não foi encontrado");
			System.exit(-1);
		}
		*/
	}

}
