package GUI.busca;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class TelaBuscarProjetoController implements Initializable {
	@FXML
	private CheckBox chbNomeProjeto;
	
	@FXML
	private CheckBox chbSiglaProjeto;
	
	@FXML
	private CheckBox chbNomeFinanciador;
	
	@FXML
	private CheckBox chbCNPJFinanciador;
	
	@FXML
	private CheckBox chbPesquisador;
	
	@FXML
	private CheckBox chbLocal;
	
	@FXML
	private CheckBox chbData;
	
	@FXML
	private CheckBox chbLatitude;
	
	@FXML
	private CheckBox chbLongitude;
	
	@FXML
	private TextField tfNomeProjeto;
	
	@FXML
	private TextField tfSiglaProjeto;
	
	@FXML
	private TextField tfNomeFinanciador;
	
	@FXML
	private TextField tfCNPJFinanciador;
	
	@FXML
	private TextField tfPesquisador;
	
	@FXML
	private ComboBox<String> cmbLocal;
	
	@FXML
	private DatePicker dpData;
	
	@FXML
	private TextField tfLatitude;
	
	@FXML
	private TextField tfLongitude;
	
	@FXML
	private void nomeProjetoTextField(KeyEvent event) {
		chbNomeProjeto.setSelected(true);
	}
	
	@FXML
	private void siglaProjetoTextField(KeyEvent event) {
		chbSiglaProjeto.setSelected(true);
	}
	
	@FXML
	private void nomeFinanciadorTextField(KeyEvent event) {
		chbNomeFinanciador.setSelected(true);
	}
	
	@FXML
	private void cnpjFinanciadorTextField(KeyEvent event) {
		chbCNPJFinanciador.setSelected(true);
	}
	
	@FXML
	private void pesquisadorTextField(KeyEvent event) {
		chbPesquisador.setSelected(true);
	}
	
	@FXML
	private void localComboBox(ActionEvent event) {
		chbLocal.setSelected(true);
	}
	
	@FXML
	private void dataDatePicker(ActionEvent event) {
		chbData.setSelected(true);
	}
	
	@FXML
	private void latitudeTextField(KeyEvent event) {
		chbLatitude.setSelected(true);
	}
	
	@FXML
	private void longitudeTextField(KeyEvent event) {
		chbLongitude.setSelected(true);
	}
	@FXML
	private void buscarProjeto(ActionEvent event) {
		System.out.println("Buscar Projeto!");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
