package GUI;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Model.Projeto;
import Service.ProjetoService;
import Service.Interfaces.IProjetoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class FXMLCadProjController implements Initializable{

	IProjetoService service = new ProjetoService();

    @FXML
    private TextField txNomeProj;

    @FXML
    private TextField txSiglaProj;

    @FXML
    private TextField txCoordenadoProj;

    @FXML
    private DatePicker dateInicio;

    @FXML
    private DatePicker dateTermino;

    @FXML
    private Button btCadastrar;

    @FXML
    void acaoCadastrarProj(ActionEvent event) {
    	
    	 String nome = txNomeProj.getText().trim();
    	 if (nome.equals("")) nome = null;
    	 
    	 String sigla = txSiglaProj.getText().trim();
    	 if (sigla.equals("")) sigla = null;
    	 
    	 String coordenador = txCoordenadoProj.getText().trim();
    	 if (coordenador.equals("")) coordenador = null;
    	 
    	 LocalDate dataI = dateInicio.getValue();
    	 Date dInicio;
    	 if (dataI == null ) dInicio = null;
    	 else dInicio = Date.valueOf(dataI);
    	 
    	 LocalDate dataT = dateTermino.getValue();
    	 Date dTermino;
    	 if (dataT == null ) dTermino = null;
    	 else dTermino = Date.valueOf(dataT);
    
    	 Projeto p = new Projeto(nome, sigla, coordenador, dInicio, dTermino);
    	 
    	 try {
    		 service.inserir(p);
		 } catch (Exception e) {	
			// TODO: handle exception
		 }
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
