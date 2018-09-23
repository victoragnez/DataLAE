package gui.screens;

import gui.model.BlockListPanel;
import gui.model.PesquisaBlock;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import service.Pesquisa;

public class PesquisaScreen extends BorderPane {
	Label title;
	BlockListPanel list;
	
	public PesquisaScreen() {
		super();
		
		title = new Label("Projetos");
		list = new BlockListPanel();
		
		title.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: chocolate;"); 
		
		HBox top = new HBox();
		top.getChildren().add(title);
		
		
		HBox bottom = new HBox();
		Button addButton = new Button("Novo Projeto...");
		addButton.setOnAction(evt -> addButtonAction());
		bottom.getChildren().add(addButton);
		
		bottom.setPadding(new Insets(10,10,10,0));
		top.setPadding(new Insets(5,10,5,0));
		
		this.setTop(top);
		this.setCenter(list);
		this.setBottom(bottom);
		this.setPadding(new Insets(0,20,0,20));
	}
	
	private void addButtonAction() {
		// Ação do botão adicionar
		PesquisaBlock block = new PesquisaBlock(new Pesquisa(
				"1",
				"Denominação",
				"Sigla",
				"Financador",
				"Coordenador",
				"Pesquisador"
		));
		
		Button rem = new Button("Remover");
		rem.setOnAction(evt -> removeButtonAction(block));
		
		block.addButton(rem);
		
		list.addBlock(block);
	}
	
	private void removeButtonAction(PesquisaBlock block) {
		// Ação de remover pesquisa aqui!
		list.removeBlock(block);
	}
}