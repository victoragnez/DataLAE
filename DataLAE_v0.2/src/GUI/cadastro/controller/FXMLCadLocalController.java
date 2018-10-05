package GUI.cadastro.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Local;
import Service.LocalService;
import Service.Interfaces.ILocalService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLCadLocalController implements Initializable{

	ILocalService service = new LocalService();
	
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
    	
    	Double latitude;
    	String lat = txLatitude.getText().trim();
    	if (lat.equals("")) latitude = null;
    	else latitude = Double.valueOf(lat);
    	
    	Double longitude;
    	String lon = txLongitude.getText().trim();
    	if (lon.equals("")) longitude = null;
    	else longitude = Double.valueOf(lon);
    	
    	Local l = new Local(nome, pais, estado, cidade, latitude, longitude);
    	try {
			service.inserir(l);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
