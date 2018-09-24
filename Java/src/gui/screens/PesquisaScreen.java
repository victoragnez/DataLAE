package gui.screens;

import gui.model.BlockListPanel;
import gui.model.PesquisaBlock;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import service.IQueryService;
import service.model.Pesquisa;

public class PesquisaScreen extends BorderPane {
	Label title;
	BlockListPanel list;
	
	public PesquisaScreen(IQueryService queryService) {
		super();
		
		title = new Label("Projetos");
		list = new BlockListPanel();
		
		title.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: chocolate;"); 
		
		HBox top = new HBox();
		top.getChildren().add(title);
		
		
		HBox bottom = new HBox();
		Button addButton = new Button("Novo Projeto...");
		addButton.setOnAction(evt -> addButtonAction(queryService));
		bottom.getChildren().add(addButton);
		
		bottom.setPadding(new Insets(10,10,10,0));
		top.setPadding(new Insets(5,10,5,0));
		
		this.setTop(top);
		this.setCenter(list);
		this.setBottom(bottom);
		this.setPadding(new Insets(0,20,0,20));
	}
	
	private void addButtonAction(IQueryService queryService) {
		list.clear();
		// Ação do botão adicionar
		for (Pesquisa pesq : queryService.queryPesquisas()) {
			list.addBlock(new PesquisaBlock(pesq));
		}
	}
}