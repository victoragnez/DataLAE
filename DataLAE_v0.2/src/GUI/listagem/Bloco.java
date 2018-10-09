package GUI.listagem;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class Bloco extends BorderPane {
	public Bloco() {
		super();
		this.setPadding(new Insets(10));
		this.setOnMouseEntered(e -> this.setStyle(
			"-fx-background-color: rgb(220,220,220);"
			+ "-fx-cursor: hand"
		));
		this.setOnMouseExited(e -> this.setStyle(""));
	}
	
	protected void addLabelsToVBox(VBox vbox, Label l1, Label l2) {
		HBox hbox = new HBox(5);
		
		if(l1 != null)
			hbox.getChildren().add(l1);
		if(l2 != null)
			hbox.getChildren().add(l2);
		if(l1 != null || l2 != null)
			vbox.getChildren().add(hbox);
	}
}
