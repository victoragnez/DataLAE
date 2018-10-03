package GUI;

import java.io.IOException;

import GUI.cadastro.CadastroProjeto;
import GUI.model.MyTabPane;
import Service.Interfaces.IProjetoService;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TelaPrincipal extends BorderPane {
	private IProjetoService projService;
	
	public TelaPrincipal() {
		this.setMinSize(800, 600);
		this.setTop(constroiPaneSuperior());
		this.setCenter(constroiPaneCentral());
	}
	
	/**
	 * Constrói a parte superior da tela.
	 * @return Um Pane contendo a parte superior da tela construída.
	 */
	private Pane constroiPaneSuperior() {
		// Cria um painel para o topo
		VBox top = new VBox();
		
		Label dataLAE = new Label("DataLAE");
		dataLAE.setStyle(
				"-fx-text-fill: chocolate;"
				+ "-fx-font-weight: bold;"
				+ "-fx-font-size: 30"
		);
		
		Separator sep = new Separator(Orientation.HORIZONTAL);
		
		dataLAE.setPadding(new Insets(20,10,5,20));
		sep.setPadding(new Insets(0,20,0,20));
		top.getChildren().addAll(dataLAE, sep);
		
		return top;
	}
	
	private Pane constroiPaneCentral() {
		MyTabPane tabs = new MyTabPane();
		try {
			tabs.addTab("Buscar", FXMLLoader.load(getClass().getResource("FXMLCadPesq.fxml")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabs.addTab("Cadastrar", new CadastroProjeto(projService));
		
		tabs.setPadding(new Insets(0,20,20,20));
		
		return tabs;
	}
}
