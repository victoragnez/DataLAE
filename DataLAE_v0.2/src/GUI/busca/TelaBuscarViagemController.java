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

public class TelaBuscarViagemController implements Initializable {
	
	@FXML
	private CheckBox chbPesquisador;
	
	@FXML
	private CheckBox chbProjeto;
	
	@FXML
	private CheckBox chbLocal;
	
	@FXML
	private CheckBox chbData;
	
	@FXML
	private TextField tfPesquisador;
	
	@FXML
	private ComboBox<String> cmbProjeto;
	
	@FXML
	private ComboBox<String> cmbLocal;
	
	@FXML
	private DatePicker dpData;
	
	@FXML
	private void pesquisadorTextField(KeyEvent event) {
		chbPesquisador.setSelected(true);
	}
	
	@FXML
	private void projetoComboBox(ActionEvent event) {
		chbProjeto.setSelected(true);
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
	private void buscarViagem(ActionEvent event) {
		System.out.println("Buscar Viagem!");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
