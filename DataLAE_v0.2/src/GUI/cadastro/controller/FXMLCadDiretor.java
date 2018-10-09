package GUI.cadastro.controller;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.Interfaces.IDiretorDAO;
import Model.Diretor;
import Service.DiretorService;
import Service.Interfaces.IDiretorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLCadDiretor implements Initializable{


    @FXML
    private TextField txNome;

    @FXML
    private TextField txEmail;

    @FXML
    private TextField txTelefone;

    @FXML
    private TextField txCargo;

    @FXML
    private Button btCadastrar;

    @FXML
    void acaoCadastrarDiretor(ActionEvent event) {
    	String nome = txNome.getText().trim();
    	if (nome.equals("")) nome = null;
    	
    	String email = txEmail.getText().trim();
    	if (email.equals("")) email = null;
    	
    	String telefone = txTelefone.getText().trim();
    	if (telefone.equals("")) telefone = null;
    	
    	String cargo = txCargo.getText().trim();
    	if (cargo.equals("")) cargo = null;
    	
    	Diretor d = new Diretor(nome, email, telefone, cargo);
    	
    	try {
			IDiretorService service = DiretorService.getInstance();
			service.inserir(d);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}