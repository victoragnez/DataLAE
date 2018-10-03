package GUI.model;

import GUI.cadastro.CadastroLocal;
import GUI.cadastro.CadastroProjeto;
import GUI.cadastro.CadastroViagem;
import Service.Interfaces.ILocalService;
import Service.Interfaces.IProjetoService;
import Service.Interfaces.IViagemService;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class SearchTypePane extends BorderPane {
	private CadastroProjeto cadastroProjeto;
	private CadastroLocal cadastroLocal;
	private CadastroViagem cadastroViagem;
	
	public SearchTypePane(IProjetoService projService, ILocalService localService, IViagemService viagemService) {
		this.cadastroProjeto = new CadastroProjeto(projService);
		this.cadastroLocal = new CadastroLocal(localService);
		this.cadastroViagem = new CadastroViagem(viagemService);
		this.setTop(constroiPaneSuperior());
	}
	
	private Pane constroiPaneSuperior() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		
		// Configurando tamanho das linhas
		RowConstraints rowBody = new RowConstraints(40,40,40);
		grid.getRowConstraints().add(rowBody);
		
		// Configurando tamanho das colunas
		ColumnConstraints colBorder = new ColumnConstraints(40,40,40); 
		grid.getColumnConstraints().add(colBorder);
		grid.getColumnConstraints().add(new ColumnConstraints(120,120,120));
		grid.getColumnConstraints().add(new ColumnConstraints(200,200,200));
		grid.getColumnConstraints().add(colBorder);
		
		// Cria os Nodes
		Label tipo = new Label("Tipo:");
		tipo.setStyle(
				"-fx-text-fill: gray;"
				+ "-fx-font-size: 14"
		);
		ComboBox<String> options = new ComboBox<>();
		options.getItems().addAll("Projeto", "Local","Viagem", "Arquivo");
		options.setOnAction(e -> mudarTela(options.getValue()));
		
		// Configura as posições dos Nodes no grid
		GridPane.setConstraints (
				tipo,
				1, 0,
				1, 1,
				HPos.LEFT, VPos.CENTER, 
				Priority.NEVER, Priority.NEVER,
				new Insets(8));
		GridPane.setConstraints (
				options,
				2, 0,
				1, 1,
				HPos.LEFT, VPos.CENTER, 
				Priority.NEVER, Priority.NEVER,
				new Insets(5));
		
		// Adiciona Nodes no grid
		grid.getChildren().addAll(tipo, options);
		
		return grid;
	}
	
	/**
	 * Implementa a ação do ComboBox, trocando de tela de acordo com o item selecionado.
	 * @param Item selecionado.
	 */
	private void mudarTela(String value) {
		if(value == "Projeto") {
			this.setCenter(cadastroProjeto);
		}
		else if(value == "Local") {
			this.setCenter(cadastroLocal);
		}
		else if(value == "Viagem") {
			this.setCenter(cadastroViagem);
		}
	}
}
