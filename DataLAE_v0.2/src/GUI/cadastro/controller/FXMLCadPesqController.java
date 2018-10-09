package GUI.cadastro.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import Model.Categoria;
import Model.Pesquisador;
import Service.PesquisadorService;
import Service.Interfaces.IPesquisadorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLCadPesqController implements Initializable {
	private IPesquisadorService pesquisadorService;
	
	@FXML
	private Label label;
	
	@FXML
    private TextField txtNomePesquisador;

    @FXML
    private TextField txtUniversidadePesquisador;

    @FXML
    private ComboBox<Categoria> comboTipoPesquisador;

    @FXML
    private TextField txtCPFPesquisador;
    
    @FXML
    private Button btCadastrarPesquisador;
	
    private List<Categoria> categorias = new ArrayList<>();
    private ObservableList<Categoria> obsCategorias;
    
    @FXML
    void acaoCadastrarPesquisador(ActionEvent event) {
 
    	String nomePesquisador = txtNomePesquisador.getText().trim();
    	if (nomePesquisador.equals("")) nomePesquisador = null;
    	
    	String cpfPesquisador = txtCPFPesquisador.getText().trim();
    	if (cpfPesquisador.equals("")) cpfPesquisador = null;
    	
    	String universidadePesquisador = txtUniversidadePesquisador.getText().trim();
    	if (universidadePesquisador.equals("")) universidadePesquisador = null;
    	
    	Categoria categoriaPesquisador = comboTipoPesquisador.getSelectionModel().getSelectedItem();
    	Pesquisador p = new Pesquisador(universidadePesquisador, 
    			nomePesquisador, cpfPesquisador, categoriaPesquisador);
    
    	try {
    		pesquisadorService.inserir(p);
		} catch (SQLException e) {
			System.out.println("Tratar exceção no cadastro de pesquisador");
		}
    }
    
    public FXMLCadPesqController() {
		pesquisadorService = PesquisadorService.getInstance();
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarCategorias();
	}
	
	public void carregarCategorias () {
		
		for ( Categoria c : Categoria.values() )
			categorias.add(c);
		
		obsCategorias = FXCollections.observableArrayList(categorias);
		comboTipoPesquisador.setItems(obsCategorias);
	}

}
