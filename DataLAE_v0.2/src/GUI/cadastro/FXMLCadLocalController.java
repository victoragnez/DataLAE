package GUI.cadastro;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLCadLocalController implements Initializable{

    @FXML
    private TextField txNomeLocal;

    @FXML
    private TextField txPaisLocal;

    @FXML
    private TextField txEstadoLocal;

    @FXML
    private TextField txCidadeLocal;

    @FXML
    private TextField txLatitude;

    @FXML
    private TextField txLongitude;
    
    @FXML
    private Button btCadastrar;
    

    @FXML
    void acaoCadastrarLocal(ActionEvent event) {
    	String nome = txNomeLocal.getText().trim();
    	if (nome.equals("")) nome = null;
    	
    	String pais = txPaisLocal.getText().trim();
    	if (pais.equals("")) pais = null;
    	
    	String estado = txEstadoLocal.getText().trim();
    	if (estado.equals("")) estado = null;
    	
    	String cidade = txCidadeLocal.getText().trim();
    	if (cidade.equals("")) cidade = null;
    	
//    	Local l = new Local()
    	
    }
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
