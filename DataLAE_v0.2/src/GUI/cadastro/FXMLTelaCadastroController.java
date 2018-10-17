package GUI.cadastro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação solicitada", 
						"Erro Inesperado", JOptionPane.ERROR_MESSAGE);
			}
		}
			
		else if(value == "Local") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("model/FXMLCadLocal.fxml")));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação solicitada", 
						"Erro Inesperado", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(value == "Viagem") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("model/FXMLCadViagem.fxml")));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação solicitada", 
						"Erro Inesperado", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(value == "Arquivo") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("model/FXMLCadArquivo.fxml")));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação solicitada", 
						"Erro Inesperado", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(value == "Diretor") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("model/FXMLCadDiretor.fxml")));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação solicitada", 
						"Erro Inesperado", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(value == "Financiador") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("model/FXMLCadFinanciador.fxml")));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação solicitada", 
						"Erro Inesperado", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(value == "Pesquisador") {
			try {
				main.setCenter(FXMLLoader.load(this.getClass().getResource("model/FXMLCadPesq.fxml")));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Não foi possível realizar a operação solicitada", 
						"Erro Inesperado", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.getItems().addAll("Arquivo", "Diretor", "Financiador", "Local", "Pesquisador", "Projeto", "Viagem");
	}

}
