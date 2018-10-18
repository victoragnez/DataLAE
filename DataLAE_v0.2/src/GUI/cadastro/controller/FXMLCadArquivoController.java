package GUI.cadastro.controller;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Model.Metodo;
import Model.Projeto;
import Model.TipoArquivo;
import Model.Viagem;
import Service.ArquivoService;
import Service.ProjetoService;
import Service.ViagemService;
import Service.Interfaces.IArquivoService;
import Service.Interfaces.IProjetoService;
import Service.Interfaces.IViagemService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class FXMLCadArquivoController implements Initializable {
	private IArquivoService arquivoService;
	private IProjetoService projetoService;
	private IViagemService viagemService;
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
			arquivoService.inserir(null);
			
			JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!",
					null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(Metodo m : Metodo.values())
			cmbCategoria.getItems().add(m);
		
		for(TipoArquivo t : TipoArquivo.values())
			cmbTipo.getItems().add(t);
		
		try {
			cmbProjeto.getItems().addAll(projetoService.listarProjetos());
		} catch (SQLException e) {
			System.out.println("Erro na listagem de projetos no combobox do cadastro de Arquivo");
		}
		
		try {
			cmbViagem.getItems().addAll(viagemService.listarViagens());
		} catch (SQLException e) {
			System.out.println("Erro na listagem de viagens no combobox do cadastro de Arquivo");
		}
		
	}
	
	public FXMLCadArquivoController() {
		arquivoService = ArquivoService.getInstance();
		viagemService =  ViagemService.getInstance();
		projetoService = ProjetoService.getInstance();
		
		chooser = new FileChooser();
		chooser.setTitle("Abrir arquivo");
	}

}
