package GUI.principal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TelaSecundariaController implements Initializable {
	@FXML
	private HBox tabs;
	
	@FXML
	private BorderPane main;
	
	private Label current;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		current = null;
		
		try {
			Pane busca = (Pane) FXMLLoader.load(this.getClass().getResource("../busca/TelaBuscar.fxml"));
			addTab("Buscar", busca);
		} catch (IOException e) {
			System.out.println("Cheguei");
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			Pane cadastro = (Pane) FXMLLoader.load(this.getClass().getResource("../cadastro/FXMLTelaCadastro.fxml"));
			addTab("Cadastrar", cadastro);
		} catch (IOException e) {
			System.out.println("Cheguei");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public void addTab(String title, Pane pane) {
		Label l = new Label(title);
		
		l.setStyle(
				"-fx-text-fill: chocolate;"
				+ "-fx-text-weight: bold;"
				+ "-fx-font-size: 15;"
				+ "-fx-background-radius: 4 4 4 4;"
				+ "-fx-background-color: rgb(245,245,245)"
		);
		
		l.setMinSize(100, 30);
		l.setPrefSize(100, 30);
		
		l.setOnMouseReleased(e -> setCurrent(l, pane));
		l.setOnMouseEntered(e -> enteredEffect(l));
		l.setOnMouseExited(e -> exitedEffect(l));
		l.setCursor(Cursor.HAND);
		
		l.setAlignment(Pos.CENTER);
		
		tabs.getChildren().add(l);
		
		pane.setStyle("-fx-border-color: lightgray");
		if(current == null)
			setCurrent(l, pane);
	}
	
	private void setCurrent(Label l, Pane pane) {
		if(current != l && current != null) {
			this.current.setStyle(
					"-fx-text-fill: chocolate;"
					+ "-fx-text-weight: bold;"
					+ "-fx-font-size: 15;"
					+ "-fx-background-radius: 4 4 4 4;"
					+ "-fx-background-color: rgb(245,245,245)"
			);
		}
		this.current = l;
		
		this.current.setStyle(
				"-fx-text-fill: chocolate;"
				+ "-fx-text-weight: bold;"
				+ "-fx-font-size: 15;"
				+ "-fx-background-radius: 4 4 4 4;"
				+ "-fx-background-color: rgb(220,220,220)"
		);
		
		main.setCenter(pane);
	}
	
	private void enteredEffect(Label l) {
		if(l != null && l != current) {
			l.setStyle(
					"-fx-text-fill: chocolate;"
					+ "-fx-text-weight: bold;"
					+ "-fx-font-size: 15;"
					+ "-fx-background-radius: 4 4 4 4;"
					+ "-fx-background-color: rgb(235,235,235)"
			);
		}
	}
	
	private void exitedEffect(Label l) {
		if(l != null && l != current) {
			l.setStyle(
					"-fx-text-fill: chocolate;"
					+ "-fx-text-weight: bold;"
					+ "-fx-font-size: 15;"
					+ "-fx-background-radius: 4 4 4 4;"
					+ "-fx-background-color: rgb(245,245,245)"
			);
		}
	}
}
