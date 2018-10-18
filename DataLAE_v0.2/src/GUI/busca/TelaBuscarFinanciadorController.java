package GUI.busca;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import GUI.listagem.BlocoFinanciador;
import Model.Financiador;
import Model.Projeto;
import Service.FinanciadorService;
import Service.ProjetoService;
import Service.Interfaces.IFinanciadorService;
import Service.Interfaces.IProjetoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class TelaBuscarFinanciadorController implements Initializable {
	private IFinanciadorService financiadorService;
	private IProjetoService projetoService;
	
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
	private ComboBox<Projeto> cmbProjeto;
	
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
		list.setVisible(false);
		list.getChildren().clear();
		
		Financiador f = new Financiador(
				chbNome.isSelected() ? (tfNome.getText().trim().length() == 0 ? null : tfNome.getText().trim()) : null,
				chbCNPJ.isSelected() ? (tfCNPJ.getText().trim().length() == 0 ? null : tfCNPJ.getText().trim()) : null
		);
		
		Projeto p = chbProjeto.isSelected() ? cmbProjeto.getValue() : null; 
		
		try {
			for(Financiador financiador : financiadorService.buscar(f, p))
				list.getChildren().add(new BlocoFinanciador(financiador));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);		
		}
		list.setVisible(true);
	}
	
	public TelaBuscarFinanciadorController() {
		this.financiadorService = FinanciadorService.getInstance();
		this.projetoService = ProjetoService.getInstance();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			cmbProjeto.getItems().addAll(projetoService.listarProjetos());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
