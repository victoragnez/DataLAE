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

public class TelaBuscarFinanciadorController implements Initializable {
	@FXML
	private VBox list;
	
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
		// Mudar depois
		this.list.getChildren().add(
			new BlocoViagem(new Viagem(
					new Date(),
					new Date(),
					new Local("IMD/UFRN", "", "", "", 0.0, 0.0),
					new Projeto("Projeto1", "", "", "", null, null)
					
			))	
		);
		
		System.out.println("Buscar Financiador");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
}
