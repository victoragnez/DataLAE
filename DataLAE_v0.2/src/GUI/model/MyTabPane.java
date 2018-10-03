package GUI.model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MyTabPane extends BorderPane {
	private HBox tabs;
	private Label current;
	
	public MyTabPane() {
		VBox vbox = new VBox();
		tabs = new HBox(10);
		tabs.setPadding(new Insets(5));
		
		vbox.getChildren().addAll(tabs);
		this.setTop(vbox);
		current = null;
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
		
		pane.setStyle("-fx-border-color: lightgray");
		this.setCenter(pane);
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
