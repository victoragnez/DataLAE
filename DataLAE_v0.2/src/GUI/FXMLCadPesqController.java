package GUI;

import java.net.URL;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ResourceBundle;

import DAO.Exceptions.CampoInvalidoException;
import Model.Pesquisador;
import Service.PesquisadorService;
import Service.Exceptions.AtributoInvalidoException;
//import Model.Titulacao;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLCadPesqController implements Initializable {

	@FXML
	private Label label;
	
	@FXML
    private TextField txtNomePesquisador;

    @FXML
    private TextField txtUniversidadePesquisador;

    //@FXML
    //private ComboBox<Titulacao> comboTipoPesquisador;

    @FXML
    private TextField txtCPFPesquisador;
    
    @FXML
    private Button btCadastrarPesquisador;
	
    //private List<Titulacao> titulacoes = new ArrayList<>();
    //private ObservableList<Titulacao> obsTitulacoes;
    
    @FXML
    void acaoCadastrarPesquisador(ActionEvent event) {
 
    	String nomePesquisador = txtNomePesquisador.getText();
    	String cpfPesquisador = txtCPFPesquisador.getText();
    	String universidadePesquisador = txtUniversidadePesquisador.getText();
    	//Titulacao titulacaoPesquisador = comboTipoPesquisador.getSelectionModel().getSelectedItem();
    	
    	Pesquisador p = new Pesquisador(universidadePesquisador, 
    			nomePesquisador, cpfPesquisador);
    
    	PesquisadorService service = new PesquisadorService();
    	try {
			service.inserir(p);
		} catch (AtributoInvalidoException | CampoInvalidoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//carregarTitulacao();
	}
	
	/*
	public void carregarTitulacao () {
		
		Titulacao t1 = new Titulacao(1, "Graduação");
		Titulacao t2 = new Titulacao(2, "Iniciação Científica");
		Titulacao t3 = new Titulacao(3, "Mestrado");
		Titulacao t4 = new Titulacao(4, "Doutorado");
		Titulacao t5 = new Titulacao(5, "Pós-Doutorado");
	
		titulacoes.add(t1);
		titulacoes.add(t2);
		titulacoes.add(t3);
		titulacoes.add(t4);
		titulacoes.add(t5);
		
		obsTitulacoes = FXCollections.observableArrayList(titulacoes);
		
		comboTipoPesquisador.setItems(obsTitulacoes);
	} */

}
