package GUI.listagem;

import Model.Viagem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BlocoViagem extends BorderPane {
	
	private Viagem viagem;
	
	public BlocoViagem(Viagem viagem) {
		super();
		this.viagem = viagem;
		
		VBox vbox = new VBox(5);
		
		Label local = new Label(this.viagem.getLocal().getNome());
		local.setStyle(
				"-fx-text-fill: chocolate;"
        		+ "-fx-font-weight: bold;"
            	+ "-fx-font-size: 24;"
        );
		String style = "-fx-text-fill: chocolate; -fx-font-weight: bold;";
		
		
		Label lIni = new Label("Início:");
		Label lDataIni = new Label(this.viagem.getDataInicio().toString());
		lIni.setStyle(style);
		
		Label lFim = new Label("Término:");
		Label lDataFim = new Label(this.viagem.getDataTermino().toString());
		lFim.setStyle(style);
		
		Label lProj = new Label("Projeto:");
		Label lProjNome = new Label(this.viagem.getProjeto().getNome());
		
		this.addLabelsToVBox(vbox, local, null);
		this.addLabelsToVBox(vbox, lIni, lDataIni);
		this.addLabelsToVBox(vbox, lFim, lDataFim);
		this.addLabelsToVBox(vbox, lProj, lProjNome);
		
		
		vbox.setAlignment(Pos.TOP_LEFT);
		vbox.setPadding(new Insets(10));
		
		this.setCenter(vbox);
		this.setPrefHeight(100);
		this.setPadding(new Insets(10));
		this.setOnMouseEntered(e -> this.setStyle(
			"-fx-background-color: rgb(220,220,220);"
			+ "-fx-cursor: hand"
		));
		this.setOnMouseExited(e -> this.setStyle(""));
	}
	
	private void addLabelsToVBox(VBox vbox, Label l1, Label l2) {
		HBox hbox = new HBox(5);
		
		if(l1 != null)
			hbox.getChildren().add(l1);
		if(l2 != null)
			hbox.getChildren().add(l2);
		if(l1 != null || l2 != null)
			vbox.getChildren().add(hbox);
	}
}
