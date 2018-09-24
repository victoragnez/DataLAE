package gui.screens;

import gui.model.AreaBlock;
import gui.model.Block;
import gui.model.BlockListPanel;
import gui.model.DefaultBlock;
import gui.model.ProjetoBlock;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import service.IQueryService;
import service.model.Area;
import service.model.Diretorio;
import service.model.Projeto;

public class ProjetoScreen extends BorderPane {
	Label title;
	BlockListPanel list;
	
	public ProjetoScreen(IQueryService queryService) {
		super();
		
		// Instancia atributos
		title = new Label("Projetos");
		list = new BlockListPanel();
		
		title.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: chocolate;"); 
		
		HBox top = new HBox();
		top.getChildren().add(title);

		//addButton.setOnAction(evt -> addButtonAction(queryService));
		
		top.setPadding(new Insets(5,10,5,0));
		
		this.setTop(top);
		this.setCenter(list);
		this.setPadding(new Insets(0,20,20,20));
		initProjetos(queryService);
	}
	
	private void initProjetos(IQueryService queryService) {
		list.clear();
		for(Projeto proj : queryService.queryProjetos()) {
			Block b = new ProjetoBlock(proj);
			b.setOnMouseClicked(e -> pastasProjetos(queryService, proj));
			list.addBlock(b);
		}
	}
	
	private void pastasProjetos(IQueryService queryService, Projeto proj) {
		list.clear();
		this.title.setText("Projetos");
		for(Diretorio dir : queryService.pastasProjetos(proj)) {
			Block b = new DefaultBlock(dir.getNome(), "");
			if(dir.getNome().equals("Área de Pesquisa"))
				b.setOnMouseClicked(e -> pastasAreas(queryService, proj));
			list.addBlock(b);
		}
	}
	
	private void pastasAreas(IQueryService queryService, Projeto proj) {
		list.clear();
		this.title.setText("Areas");
		for(Area area : queryService.queryArea(proj)) {
			Block b = new AreaBlock(area);
			list.addBlock(b);
		}
	}
}