package GUI.busca;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class TelaBuscarFinanciadorController implements Initializable {
	
	@FXML
	private CheckBox chbNome;
	
	@FXML
	private CheckBox chbCNPJ;
	
	@FXML
	private CheckBox chbProjeto;
	
	@FXML
	private TextField tfNome;
	
	@FXML
	private TextField tfCNPJ;
	
	@FXML
	private ComboBox<String> cmbProjeto;
	
	@FXML
	private void nomeTextField(KeyEvent event) {
		chbNome.setSelected(true);
	}
	
	@FXML
	private void cnpjTextField(KeyEvent event) {
		chbCNPJ.setSelected(true);
	}
	
	@FXML
	private void projetoComboBox(ActionEvent event) {
		chbProjeto.setSelected(true);
	}
	
	@FXML
	private void buscarFinanciador(ActionEvent event) {
		System.out.println("Buscar Financiador");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
}
