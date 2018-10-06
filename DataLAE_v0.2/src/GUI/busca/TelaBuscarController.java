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

public class TelaBuscarController implements Initializable {
	
	private Pane buscarArquivo;
	private Pane buscarFinanciador;
	private Pane buscarLocal;
	private Pane buscarProjeto;
	private Pane buscarViagem;
	
	
	@FXML
	private ComboBox<String> comboBox;
	
	@FXML
	private BorderPane main;
	
	@FXML
	private void mudarTela(ActionEvent event) {
		String value = comboBox.getValue();
		
		if(value == "Arquivo")
			main.setCenter(buscarArquivo);
		else if(value == "Financiador")
			main.setCenter(buscarFinanciador);
		else if(value == "Local")
			main.setCenter(buscarLocal);
		else if(value == "Projeto")
			main.setCenter(buscarProjeto);
		else if(value == "Viagem")
			main.setCenter(buscarViagem);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.getItems().addAll("Arquivo","Financiador","Local","Projeto","Viagem");
		
		try {
			buscarArquivo = FXMLLoader.load(TelaBuscarController.class.getResource("./TelaBuscarArquivo.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			buscarFinanciador = FXMLLoader.load(TelaBuscarController.class.getResource("./TelaBuscarFinanciador.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			buscarLocal = FXMLLoader.load(TelaBuscarController.class.getResource("./TelaBuscarLocal.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			buscarProjeto = FXMLLoader.load(TelaBuscarController.class.getResource("./TelaBuscarProjeto.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			buscarViagem = FXMLLoader.load(TelaBuscarController.class.getResource("./TelaBuscarViagem.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
