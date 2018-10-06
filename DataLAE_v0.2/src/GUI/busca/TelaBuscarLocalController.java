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

public class TelaBuscarLocalController implements Initializable {

	@FXML
	private CheckBox chbNome;
	
	@FXML
	private CheckBox chbPais;
	
	@FXML
	private CheckBox chbCidade;
	
	@FXML
	private CheckBox chbEstado;
	
	@FXML
	private CheckBox chbPesquisador;
	
	@FXML
	private CheckBox chbProjeto;
	
	@FXML
	private CheckBox chbLatitude;
	
	@FXML
	private CheckBox chbLongitude;
	
	@FXML
	private TextField tfNome;
	
	@FXML
	private TextField tfPais;
	
	@FXML
	private TextField tfEstado;
	
	@FXML
	private TextField tfCidade;
	
	@FXML
	private TextField tfPesquisador;
	
	@FXML
	private TextField tfLatitude;
	
	@FXML
	private TextField tfLongitude;
	
	@FXML
	private ComboBox<String> cmbProjeto;
	
	@FXML
	private void nomeTextField(KeyEvent event) {
		chbNome.setSelected(true);
	}
	
	@FXML
	private void paisTextField(KeyEvent event) {
		chbPais.setSelected(true);
	}
	
	@FXML
	private void estadoTextField(KeyEvent event) {
		chbEstado.setSelected(true);
	}
	
	@FXML
	private void cidadeTextField(KeyEvent event) {
		chbCidade.setSelected(true);
	}
	
	@FXML
	private void pesquisadorTextField(KeyEvent event) {
		chbPesquisador.setSelected(true);
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
	private void projetoComboBox(ActionEvent event) {
		chbProjeto.setSelected(true);
	}
	
	@FXML
	private void buscarLocal(ActionEvent event) {
		System.out.println("Buscar Local");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
