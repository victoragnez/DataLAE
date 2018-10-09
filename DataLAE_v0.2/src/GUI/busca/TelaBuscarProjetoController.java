package GUI.busca;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

import GUI.listagem.BlocoProjeto;
import Model.Financiador;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;
import Service.FinanciadorService;
import Service.LocalService;
import Service.PesquisadorService;
import Service.ProjetoService;
import Service.Interfaces.IFinanciadorService;
import Service.Interfaces.ILocalService;
import Service.Interfaces.IPesquisadorService;
import Service.Interfaces.IProjetoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class TelaBuscarProjetoController implements Initializable {
	private IProjetoService projetoService;
	private IFinanciadorService financiadorService;
	private IPesquisadorService pesquisadorService;
	private ILocalService localService;
	
	@FXML
	private VBox list;
	
	@FXML
	private CheckBox chbNomeProjeto;
	
	@FXML
	private CheckBox chbSiglaProjeto;
	
	@FXML
	private CheckBox chbFinanciador;
	
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
	private ComboBox<Financiador> cmbFinanciador;
	
	@FXML
	private ComboBox<Pesquisador> cmbPesquisador;
	
	@FXML
	private ComboBox<Local> cmbLocal;
	
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
	private void financiadorComboBox(ActionEvent event) {
		chbFinanciador.setSelected(true);
	}
	
	@FXML
	private void pesquisadorComboBox(ActionEvent event) {
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
		list.setVisible(false);
		list.getChildren().clear();
		
		Projeto proj = new Projeto(
				chbNomeProjeto.isSelected() ? (tfNomeProjeto.getText().trim().equals("") ? null : tfNomeProjeto.getText().trim()) : null,
				null,
				chbSiglaProjeto.isSelected() ? (tfSiglaProjeto.getText().trim().equals("") ? null : tfSiglaProjeto.getText().trim()): null,
				null,
				chbData.isSelected() ? ( dpData.getValue() != null ? Date.valueOf(dpData.getValue()) : null ) : null,
				null
		);
		
		Financiador f = chbFinanciador.isSelected() ? cmbFinanciador.getValue() : null;
		Pesquisador p = chbPesquisador.isSelected() ? cmbPesquisador.getValue() : null;
		Local l = chbLocal.isSelected() ? cmbLocal.getValue() : null;
		
		try {
			for(Projeto projeto : projetoService.buscar(proj, f, p, l))
				list.getChildren().add(new BlocoProjeto(projeto));
		} catch (SQLException e) {
			System.out.println("Tratar exceção na busca de Projeto");
		}
		list.setVisible(true);
	}
	
	public TelaBuscarProjetoController() {
		this.projetoService = ProjetoService.getInstance();
		this.financiadorService = FinanciadorService.getInstance();
		this.pesquisadorService = PesquisadorService.getInstance();
		this.localService = LocalService.getInstance();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			cmbFinanciador.getItems().addAll(financiadorService.listarFinanciadores());
		} catch (SQLException e) {
			System.out.println("Tratar exceção de listar financiadores na tela de busca de Projeto");
		}
		
		try {
			cmbPesquisador.getItems().addAll(pesquisadorService.listarPesquisadores());
		} catch (SQLException e) {
			System.out.println("Tratar exceção de listar pesquisadores na tela de busca de Projeto");
		}
		
		try {
			cmbLocal.getItems().addAll(localService.listarLocais());
		} catch (SQLException e) {
			System.out.println("Tratar exceção de listar locais na tela de busca de Projeto");
		}
	}
}
