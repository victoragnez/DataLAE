package GUI.cadastro;

import Service.Interfaces.IProjetoService;
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

public class CadastroProjeto extends GridPane {
	private TextField tfNome;
	private TextField tfSigla;
	private TextField tfCoordenador;
	private TextField tfFinanciador;
	private TextField tfInicio;
	private TextField tfFim;
	
	private void addToGrid(Node node, int rowIndex, int columnIndex, Insets margin) {
		GridPane.setConstraints (
				node,
				columnIndex, rowIndex,
				1, 1,
				HPos.LEFT, VPos.BOTTOM, 
				Priority.NEVER, Priority.NEVER,
				margin);
	}
	
	public CadastroProjeto(IProjetoService projService) {
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
		tfSigla = new TextField();
		tfCoordenador = new TextField();
		tfFinanciador = new TextField();
		tfInicio = new TextField();
		tfFim = new TextField();
		
		// Instanciando Labels
		Label lNome = new Label("Nome:");
		Label lSigla = new Label("Sigla:");
		Label lCoordenador = new Label("Coordenador:");
		Label lFinanciador = new Label("Financiador:");
		Label lInicio = new Label("Data de início:");
		Label lFim = new Label("Data de término:");
		
		// Configurando Labels no grid
		Insets lMargin = new Insets(8);
		Insets tfMargin = new Insets(5);
		addToGrid(lNome, 1, 1, lMargin);
		addToGrid(lSigla, 2, 1, lMargin);
		addToGrid(lCoordenador, 3, 1, lMargin);
		addToGrid(lFinanciador, 4, 1, lMargin);
		addToGrid(lInicio, 5, 1, lMargin);
		addToGrid(lFim, 6, 1, lMargin);

		// Configurando TextFields no grid		
		addToGrid(tfNome, 1, 2, tfMargin);
		addToGrid(tfSigla, 2, 2, tfMargin);
		addToGrid(tfCoordenador, 3, 2, tfMargin);
		addToGrid(tfFinanciador, 4, 2, tfMargin);
		addToGrid(tfInicio, 5, 2, tfMargin);
		addToGrid(tfFim, 6, 2, tfMargin);
		
		Button bCadastrar = new Button("Cadastrar");
		bCadastrar.setOnAction(evt -> acaoBotaoCadastrar(projService));
		GridPane.setConstraints (
				bCadastrar,
				2, 7,
				1, 1,
				HPos.RIGHT, VPos.BOTTOM, 
				Priority.NEVER, Priority.NEVER,
				tfMargin);
		
		// adicionando todos os Nodes no painel
		this.getChildren().addAll (
				lNome,
				lSigla,
				lCoordenador,
				lFinanciador,
				lInicio,
				lFim,
				tfNome,
				tfSigla,
				tfCoordenador,
				tfFinanciador,
				tfInicio,
				tfFim,
				bCadastrar
		);
	}
	
	private void acaoBotaoCadastrar(IProjetoService projService) {
		System.out.println("Projeto Cadastrado!");
	}
}
