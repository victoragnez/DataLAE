package GUI.cadastro.controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Financiador;
import Service.FinanciadorService;
import Service.Interfaces.IFinanciadorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLCadFinanciadorController implements Initializable{
	private IFinanciadorService financiadorService;
	
    @FXML
    private TextField txNome;

    @FXML
    private TextField txCnpj;

    @FXML
    private Button btCadastrar;

    @FXML
    void acaoCadastrarFinanciador(ActionEvent event) {
    	String nome = txNome.getText().trim();
    	if (nome.equals("")) nome = null;
    	
    	String cnpj = txCnpj.getText().trim();
    	if (cnpj.equals("")) cnpj = null;
    	
    	Financiador f = new Financiador (nome, cnpj);
    	try {
			financiadorService.inserir(f);
		} catch (Exception e) {
			System.out.println("Tratar exceção no cadastro de financiador");
		}
    }
    
    public FXMLCadFinanciadorController() {
		financiadorService = FinanciadorService.getInstance();
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {}

}
