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
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;

public class TelaBuscarViagemController implements Initializable {
	
	@FXML
	private VBox list;
	
	@FXML
	private CheckBox chbPesquisador;
	
	@FXML
	private CheckBox chbProjeto;
	
	@FXML
	private CheckBox chbLocal;
	
	@FXML
	private CheckBox chbData;
	
	@FXML
	private ComboBox<String> cmbPesquisador;
	
	@FXML
	private ComboBox<String> cmbProjeto;
	
	@FXML
	private ComboBox<String> cmbLocal;
	
	@FXML
	private DatePicker dpData;
	
	@FXML
	private void pesquisadorComboBox(ActionEvent event) {
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
		// Montar Viagem
		
		// Buscar no banco (retorna ArrayList<Viagem>)
		
		// Limpa a lista
		
		// Exibe a nova lista
		
		this.list.getChildren().add(
			new BlocoViagem(new Viagem(
					new Date(),
					new Date(),
					new Local("IMD/UFRN", "", "", "", 0.0, 0.0),
					new Projeto("Projeto1", "", "", "", null, null)
					
			))	
		);
		
		//this.list.getChildren().add(new Button("Teste"));
		System.out.println("Buscar Viagem!");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
