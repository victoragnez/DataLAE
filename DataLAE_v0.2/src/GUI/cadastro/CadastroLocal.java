package GUI.cadastro;

import Service.Interfaces.ILocalService;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class CadastroLocal extends GridPane {
	private TextField tfNome;
	private TextField tfPais;
	private TextField tfEstado;
	private TextField tfCidade;
	
	private void addToGrid(Node node, int rowIndex, int columnIndex, Insets margin) {
		GridPane.setConstraints (
				node,
				columnIndex, rowIndex,
				1, 1,
				HPos.LEFT, VPos.BOTTOM, 
				Priority.NEVER, Priority.NEVER,
				margin);
	}
	
	public CadastroLocal(ILocalService localService) {
		this.setAlignment(Pos.TOP_CENTER);
		
		//this.setGridLinesVisible(true); // DEBUG
		
		// Configurando tamanho das linhas
		RowConstraints rowBorder = new RowConstraints(20,20,20);
		RowConstraints rowBody = new RowConstraints(40,40,40);
		this.getRowConstraints().add(rowBorder);
		this.getRowConstraints().add(rowBody);
		this.getRowConstraints().add(rowBody);
		this.getRowConstraints().add(rowBody);
		this.getRowConstraints().add(rowBody);
		this.getRowConstraints().add(rowBody);
		this.getRowConstraints().add(rowBorder);
		
		// Configurando tamanho das colunas
		ColumnConstraints colBorder = new ColumnConstraints(40,40,40); 
		this.getColumnConstraints().add(colBorder);
		this.getColumnConstraints().add(new ColumnConstraints(120,120,120));
		this.getColumnConstraints().add(new ColumnConstraints(200,200,200));
		this.getColumnConstraints().add(colBorder);
		
		// Instanciando TextFields
		tfNome = new TextField();
		tfPais = new TextField();
		tfEstado = new TextField();
		tfCidade = new TextField();
		
		// Instanciando Labels
		Label lNome = new Label("Nome:");
		Label lPais = new Label("País:");
		Label lEstado = new Label("Estado:");
		Label lCidade = new Label("Cidade:");
		
		// Configurando Labels no grid
		Insets lMargin = new Insets(8);
		Insets tfMargin = new Insets(5);
		addToGrid(lNome, 1, 1, lMargin);
		addToGrid(lPais, 2, 1, lMargin);
		addToGrid(lEstado, 3, 1, lMargin);
		addToGrid(lCidade, 4, 1, lMargin);

		// Configurando TextFields no grid		
		addToGrid(tfNome, 1, 2, tfMargin);
		addToGrid(tfPais, 2, 2, tfMargin);
		addToGrid(tfEstado, 3, 2, tfMargin);
		addToGrid(tfCidade, 4, 2, tfMargin);
		
		Button bCadastrar = new Button("Cadastrar");
		bCadastrar.setOnAction(evt -> acaoBotaoCadastrarProjeto(localService));
		GridPane.setConstraints (
				bCadastrar,
				2, 5,
				1, 1,
				HPos.RIGHT, VPos.BOTTOM, 
				Priority.NEVER, Priority.NEVER,
				tfMargin);
		
		// adicionando todos os Nodes no painel
		this.getChildren().addAll (
				lNome,
				lPais,
				lEstado,
				lCidade,
				tfNome,
				tfPais,
				tfEstado,
				tfCidade,
				bCadastrar
		);
	}
	
	private void acaoBotaoCadastrarProjeto(ILocalService localService) {
		System.out.println("Local Cadastrado!");
	}
}
