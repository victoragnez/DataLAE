package GUI.busca;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class TelaBuscarArquivoController implements Initializable {
	@FXML
	private VBox list;
	
	@FXML
	private CheckBox chbProjeto;
	
	@FXML
	private CheckBox chbViagem;
	
	@FXML
	private CheckBox chbTipo;
	
	@FXML
	private CheckBox chbCategoria;
	
	@FXML
	private ComboBox<String> cmbProjeto;
	
	@FXML
	private ComboBox<String> cmbViagem;
	
	@FXML
	private ComboBox<String> cmbTipo;
	
	@FXML
	private ComboBox<String> cmbCategoria;
	
	@FXML
	private void projetoComboBox(ActionEvent event) {
		chbProjeto.setSelected(true);
	}
	
	@FXML
	private void viagemComboBox(ActionEvent event) {
		chbViagem.setSelected(true);
	}
	
	@FXML
	private void tipoComboBox(ActionEvent event) {
		chbTipo.setSelected(true);
	}
	
	@FXML
	private void categoriaCheckBox(ActionEvent event) {
		chbCategoria.setSelected(true);
	}
	
	@FXML
	private void buscarArquivo(ActionEvent event) {
		// TODO
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
}
