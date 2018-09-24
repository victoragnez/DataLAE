package gui.screens;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import service.IQueryService;

/**
 * Tela após logar.
 * @author Gilney Junior
 */
public class LoggedIn extends BorderPane {
	private PesquisaScreen pesqScreen;
	
	public LoggedIn(IQueryService queryService) {
		
		// Cria duas labels
		Label dataLAE = new Label("DataLAE");
		Label sair = new Label("Sair");
		
		
		// Define os estilos CSS das labels
		dataLAE.setStyle("-fx-text-fill: chocolate;"
        		+ "-fx-font-weight: bold;"
            	+ "-fx-font-size: 24;");
		
		sair.setStyle("-fx-text-fill: chocolate;"
        		+ "-fx-font-weight: bold;"
            	+ "-fx-font-size: 18;");
		sair.setUnderline(true);
		
		// Cria os paineis
		BorderPane top = new BorderPane();
		HBox top_center = new HBox();
		HBox top_right = new HBox();
		top_center.setPadding(new Insets(10,10,10,20));
		top_right.setPadding(new Insets(10,20,10,10));
		
		// Organiza os componentes da parte superior da tela
		top_center.getChildren().add(dataLAE);
		top_right.getChildren().add(sair);
		top.setRight(top_right);
		top.setCenter(top_center);
		
		Separator sep = new Separator(Orientation.HORIZONTAL);
		sep.setPadding(new Insets(20));
		top.setBottom(sep);
		
		// Organiza os componentes da parte do centro da tela
		pesqScreen = new PesquisaScreen(queryService);
		
		this.setTop(top);
		this.setCenter(pesqScreen);
		this.setPrefSize(800, 600);
	}
}
