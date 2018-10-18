package GUI.busca;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import GUI.listagem.BlocoLocal;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;
import Service.LocalService;
import Service.PesquisadorService;
import Service.ProjetoService;
import Service.Interfaces.ILocalService;
import Service.Interfaces.IPesquisadorService;
import Service.Interfaces.IProjetoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class TelaBuscarLocalController implements Initializable {
	private ILocalService localService;
	private IPesquisadorService pesquisadorService;
	private IProjetoService projetoService;
	
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
	private ComboBox<Pesquisador> cmbPesquisador;
	
	@FXML
	private TextField tfLatitude;
	
	@FXML
	private TextField tfLongitude;
	
	@FXML
	private ComboBox<Projeto> cmbProjeto;
	
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
		list.setVisible(false);
		list.getChildren().clear();
		
		Local l = new Local(
				chbNome.isSelected() ? (tfNome.getText().trim().length() == 0 ? null : tfNome.getText().trim()) : null,
				chbPais.isSelected() ? (tfPais.getText().trim().length() == 0 ? null : tfPais.getText().trim()) : null,
				chbEstado.isSelected() ? (tfEstado.getText().trim().length() == 0 ? null : tfEstado.getText().trim()) : null,
				chbCidade.isSelected() ? (tfCidade.getText().trim().length() == 0 ? null : tfCidade.getText().trim()) : null,		
				null, 
				null
		);
		
		Pesquisador p = chbPesquisador.isSelected() ? cmbPesquisador.getValue() : null;
		Projeto proj = chbProjeto.isSelected() ? cmbProjeto.getValue() : null;
		
		try {
			for(Local local : localService.buscar(l, p, proj))
				list.getChildren().add(new BlocoLocal(local));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		list.setVisible(true);
	}
	
	public TelaBuscarLocalController() {
		localService = LocalService.getInstance();
		pesquisadorService = PesquisadorService.getInstance();
		projetoService = ProjetoService.getInstance();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			cmbPesquisador.getItems().addAll(pesquisadorService.listarPesquisadores());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			cmbProjeto.getItems().addAll(projetoService.listarProjetos());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

}
