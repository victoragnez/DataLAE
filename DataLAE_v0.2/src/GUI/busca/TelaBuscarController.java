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

public class TelaBuscarController implements Initializable {
	@FXML
	private ComboBox<String> comboBox;
	
	@FXML
	private BorderPane main;
	
	@FXML
	private void mudarTela(ActionEvent event) {
		String value = comboBox.getValue();
		
		if(value == "Arquivo") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("./TelaBuscarArquivo.fxml")));
			} catch (IOException e) {
				System.out.println("Falha ao carregar tela de busca por Arquivo!");
				e.printStackTrace();
			}
		}
		else if(value == "Financiador") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("./TelaBuscarFinanciador.fxml")));
			} catch (IOException e) {
				System.out.println("Falha ao carregar tela de busca por Financiador!");
				e.printStackTrace();
			}
		}
		else if(value == "Local") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("./TelaBuscarLocal.fxml")));
			} catch (IOException e) {
				System.out.println("Falha ao carregar tela de busca por Local!");
				e.printStackTrace();
			}
		}
		else if(value == "Projeto") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("./TelaBuscarProjeto.fxml")));
			} catch (IOException e) {
				System.out.println("Falha ao carregar tela de busca por Projeto!");
				e.printStackTrace();
			}
		}
		else if(value == "Viagem") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("./TelaBuscarViagem.fxml")));
			} catch (IOException e) {
				System.out.println("Falha ao carregar tela de busca por Viagem!");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.getItems().addAll("Arquivo","Financiador","Local","Projeto","Viagem");
	}
}
