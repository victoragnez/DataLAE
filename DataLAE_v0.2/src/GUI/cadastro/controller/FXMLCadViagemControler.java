package GUI.cadastro.controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Local;
import Model.Projeto;
import Model.Viagem;
import Service.ViagemService;
import Service.Interfaces.IViagemService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class FXMLCadViagemControler implements Initializable {
	private IViagemService viagemService;
	
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
		} catch (SQLException e) {
			System.out.println("Tratar exceção no cadastro de Viagem");
		}
	}
	
	public FXMLCadViagemControler() {
		viagemService = ViagemService.getInstance();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}
}