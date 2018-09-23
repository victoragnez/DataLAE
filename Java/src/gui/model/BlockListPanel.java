package gui.model;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class BlockListPanel extends BorderPane {
	VBox vbox;
	
	public BlockListPanel() {
		super();
		vbox = new VBox(5);

		// Cria nova barra de rolagem vertical
		ScrollPane scroller = new ScrollPane(vbox);
		scroller.setFitToWidth(true);
		
		this.setPrefSize(400, 400);
		this.setCenter(scroller);
	}
	
	public void removeBlock(Block block) {
		vbox.getChildren().remove(block);
	}
	
	public void addBlock(Block block) {
		vbox.getChildren().add(block);
	}
}
