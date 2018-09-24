package gui.model;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public abstract class Block extends BorderPane {
	private Label title;
	private Label subtitle;
	
	public Block(String title, String subtitle) {
		super();
		
		VBox center = new VBox();
		
		// Cria título e subtítulo
		this.title = new Label(title);
		this.title.setStyle(
				"-fx-text-fill: chocolate;"
        		+ "-fx-font-weight: bold;"
            	+ "-fx-font-size: 24;"
        );
		this.subtitle = new Label(subtitle);
		this.subtitle.setStyle("-fx-font-size: 15;");
		
		center.getChildren().add(this.title);
		center.getChildren().add(this.subtitle);
		
		this.setStyle("-fx-background-color: rgb(235,235,235);");
		this.setPrefHeight(100);
		this.setCenter(center);
		this.setPadding(new Insets(10.0));
		
		this.setOnMouseEntered(e -> this.setStyle(
			"-fx-background-color: rgb(220,220,220);"
			+ "-fx-cursor: hand"
		));
		this.setOnMouseExited(e -> this.setStyle(
			"-fx-background-color: rgb(235,235,235);"
		));
		this.setOnMouseClicked(e-> clickedAction());
	}
	
	public void setTitle(String title) {
		this.title.setText(title);
	}
	
	public void setSubtitle(String subtitle) {
		this.subtitle.setText(subtitle);
	}
	
	public String getTitle() {
		return this.title.getText();
	}
	
	public String getSubtitle() {
		return this.subtitle.getText();
	}
	
	private void clickedAction() {
		System.out.println("Clicou!");
	}
}
