package GUI.cadastro;

import Service.Interfaces.IViagemService;
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

public class CadastroViagem extends GridPane {
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
	
	public CadastroViagem(IViagemService viagemService) {
		this.setAlignment(Pos.TOP_CENTER);
		
		//this.setGridLinesVisible(true); // DEBUG
		
		// Configurando tamanho das linhas
		RowConstraints rowBorder = new RowConstraints(20,20,20);
		RowConstraints rowBody = new RowConstraints(40,40,40);
		this.getRowConstraints().add(rowBorder);
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
		tfInicio = new TextField();
		tfFim = new TextField();
		
		// Instanciando Labels
		Label lInicio = new Label("Data de início:");
		Label lFim = new Label("Data de término:");
		
		// Configurando Labels no grid
		Insets lMargin = new Insets(8);
		Insets tfMargin = new Insets(5);
		addToGrid(lInicio, 1, 1, lMargin);
		addToGrid(lFim, 2, 1, lMargin);

		// Configurando TextFields no grid
		addToGrid(tfInicio, 1, 2, tfMargin);
		addToGrid(tfFim, 2, 2, tfMargin);
		
		Button bCadastrar = new Button("Cadastrar");
		bCadastrar.setOnAction(evt -> acaoBotaoCadastrarProjeto(viagemService));
		GridPane.setConstraints (
				bCadastrar,
				2, 3,
				1, 1,
				HPos.RIGHT, VPos.BOTTOM, 
				Priority.NEVER, Priority.NEVER,
				tfMargin);
		
		// adicionando todos os Nodes no painel
		this.getChildren().addAll (
				lInicio,
				lFim,
				tfInicio,
				tfFim,
				bCadastrar
		);
	}
	
	private void acaoBotaoCadastrarProjeto(IViagemService viagemService) {
		System.out.println("Projeto Cadastrado!");
	}
}
