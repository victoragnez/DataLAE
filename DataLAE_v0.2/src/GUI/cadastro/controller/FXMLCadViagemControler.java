package GUI.cadastro.controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.Local;
import Model.Projeto;
import Model.Viagem;
import Service.LocalService;
import Service.ProjetoService;
import Service.ViagemService;
import Service.Interfaces.ILocalService;
import Service.Interfaces.IProjetoService;
import Service.Interfaces.IViagemService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class FXMLCadViagemControler implements Initializable {
	private IViagemService viagemService;
	private ILocalService localService;
	private IProjetoService projetoService;
	
	@FXML
	private ComboBox<Local> local;
	
	@FXML
	private ComboBox<Projeto> projeto;
	
	@FXML
	private DatePicker dataInicio;
	
	@FXML
	private DatePicker dataFim;
	
	@FXML
	private Button cadastrar;
	
	@FXML
	private void acaoCadsatrar(ActionEvent event) {
		Local local = this.local.getValue();
		
		Projeto projeto = this.projeto.getValue();
		
		LocalDate inicio = dataInicio.getValue();
		
		LocalDate fim = dataFim.getValue();
		
		Date dataInicio = null;
		Date dataFim = null;
		
		if(inicio != null)
			dataInicio = Date.valueOf(inicio);
		if(fim != null)
			dataFim = Date.valueOf(fim);
		
		Viagem v = new Viagem(dataInicio, dataFim, local, projeto);
		try {
			viagemService.inserir(v);
			JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!",
					null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
    	
	}
	
	public FXMLCadViagemControler() {
		viagemService = ViagemService.getInstance();
		localService = LocalService.getInstance();
		projetoService = ProjetoService.getInstance();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			local.getItems().addAll(localService.listarLocais());
		} catch (SQLException e) {
			System.out.println("Erro em listar locais no cadastro de Viagem!");
		}
		
		try {
			projeto.getItems().addAll(projetoService.listarProjetos());
		} catch (SQLException e) {
			System.out.println("Erro em listar projetos no cadastro de Viagem!");
		}
	}
}