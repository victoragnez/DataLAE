package gui.model;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public abstract class Block extends BorderPane {
	private Label title;
	private Label subtitle;
	private VBox right;
	
	public Block(String title, String subtitle) {
		super();
		
		VBox left = new VBox();
		right = new VBox();
		
		// Cria título e subtítulo
		this.title = new Label(title);
		this.title.setStyle(
				"-fx-text-fill: chocolate;"
        		+ "-fx-font-weight: bold;"
            	+ "-fx-font-size: 24;"
        );
		this.subtitle = new Label(subtitle);
		this.subtitle.setStyle("-fx-font-size: 15;"
        );
		left.getChildren().add(this.title);
		left.getChildren().add(this.subtitle);
		
		this.setStyle("-fx-background-color: rgb(235,235,235);");
		this.setPrefHeight(100);
		this.setLeft(left);
		this.setRight(right);
		this.setPadding(new Insets(10.0));
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
	
	public void addButton(Button button) {
		button.setPrefSize(90, 15);
		button.setStyle("-fx-cursor: hand;");
		right.getChildren().addAll(button);
	}
}
