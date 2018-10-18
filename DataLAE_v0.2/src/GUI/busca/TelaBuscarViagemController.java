package GUI.busca;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import GUI.listagem.BlocoViagem;
import Model.Local;
import Model.Pesquisador;
import Model.Projeto;
import Model.Viagem;
import Service.LocalService;
import Service.PesquisadorService;
import Service.ProjetoService;
import Service.ViagemService;
import Service.Interfaces.ILocalService;
import Service.Interfaces.IPesquisadorService;
import Service.Interfaces.IProjetoService;
import Service.Interfaces.IViagemService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;

public class TelaBuscarViagemController implements Initializable {
	private IViagemService viagemService;
	private IPesquisadorService pesquisadorService;
	private IProjetoService projetoService;
	private ILocalService localService;
	
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
	private ComboBox<Pesquisador> cmbPesquisador;
	
	@FXML
	private ComboBox<Projeto> cmbProjeto;
	
	@FXML
	private ComboBox<Local> cmbLocal;
	
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
		list.setVisible(false);
		list.getChildren().clear();
		
		Viagem v = new Viagem(
				chbData.isSelected() ? (dpData.getValue() == null ? null : Date.valueOf(dpData.getValue())) : null,
				null,
				null,
				null);
		
		Projeto proj = chbProjeto.isSelected() ? cmbProjeto.getValue() : null;
		Pesquisador p = chbPesquisador.isSelected() ? cmbPesquisador.getValue() : null;
		Local l = chbLocal.isSelected() ? cmbLocal.getValue() : null;
		
		try {
			for(Viagem viagem : viagemService.buscar(v, p, proj, l))
				list.getChildren().add(new BlocoViagem(viagem));
			System.out.println("deu certo o try");
		} catch (Exception e) {	
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		list.setVisible(true);
	}
	
	public TelaBuscarViagemController() {
		viagemService = ViagemService.getInstance();
		pesquisadorService = PesquisadorService.getInstance();
		projetoService = ProjetoService.getInstance();
		localService = LocalService.getInstance();
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
		
		try {
			cmbLocal.getItems().addAll(localService.listarLocais());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
