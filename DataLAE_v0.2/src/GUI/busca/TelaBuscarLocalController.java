package GUI.busca;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import GUI.listagem.BlocoViagem;
import Model.Local;
import Model.Projeto;
import Model.Viagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class TelaBuscarLocalController implements Initializable {
	@FXML
	private VBox list;

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
	private ComboBox<String> cmbPesquisador;
	
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
	private void pesquisadorComboBox(ActionEvent event) {
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
		// Mudar depois
		this.list.getChildren().add(
				new BlocoViagem(new Viagem(
						new Date(),
						new Date(),
						new Local("IMD/UFRN", "", "", "", 0.0, 0.0),
						new Projeto("Projeto1", "", "", "", null, null)
						
				))	
			);
		System.out.println("Buscar Local");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
