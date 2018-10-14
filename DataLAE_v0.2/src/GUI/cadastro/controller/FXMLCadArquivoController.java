package GUI.cadastro.controller;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Arquivo;
import Model.Metodo;
import Model.Projeto;
import Model.TipoArquivo;
import Model.Viagem;
import Service.ArquivoService;
import Service.Interfaces.IArquivoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class FXMLCadArquivoController implements Initializable {
	private IArquivoService service;
	private FileChooser chooser;
	
	@FXML
	private GridPane main;
	
	@FXML
	private TextField tfCaminho;
	
	@FXML
	private TextField tfNome;
	
	@FXML
	private ComboBox<Projeto> cmbProjeto;
	
	@FXML
	private ComboBox<Viagem> cmbViagem;
	
	@FXML
	private ComboBox<Metodo> cmbCategoria;
	
	@FXML
	private ComboBox<TipoArquivo> cmbTipo;
	
	
	@FXML
	private void botaoProcurar(ActionEvent event) {
		File f = chooser.showOpenDialog(main.getScene().getWindow());
		tfCaminho.setText(f.getAbsolutePath());
		tfNome.setText(f.getName());
	}
	
	@FXML
	private void botaoCadastrar(ActionEvent event) {
		try {
			service.inserir(new Arquivo(
					null,
					tfNome.getText().trim(),
					cmbTipo.getValue(),
					cmbCategoria.getValue()
			));
		} catch (SQLException e) {
			System.out.println("Tratar exceção no cadastro de um novo arquivo");
		}
		
		
		System.out.println("Arquivo cadastrado");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(Metodo m : Metodo.values())
			cmbCategoria.getItems().add(m);
		
		for(TipoArquivo t : TipoArquivo.values())
			cmbTipo.getItems().add(t);
		
		// Carregar Viagens e Projetos
	}
	
	public FXMLCadArquivoController() {
		service = ArquivoService.getInstance();
		
		chooser = new FileChooser();
		chooser.setTitle("Abrir arquivo");
		
		// Carregar ComboBoxes aqui
	}

}
