package GUI.listagem;

import java.sql.SQLException;

import Model.Financiador;
import Service.FinanciadorService;
import Service.Interfaces.IFinanciadorService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BlocoFinanciador extends Bloco {
	private IFinanciadorService service;
	private Financiador financiador;
	
	public BlocoFinanciador(Financiador financiador) {
		super();
		this.financiador = financiador;
		this.service = FinanciadorService.getInstance();
		
		Label nome = new Label(financiador.getNome());
		Label cnpj = new Label(financiador.getCnpj());
		Label lCNPJ = new Label("CNPJ:");
		
		nome.setStyle(
				"-fx-text-fill: chocolate;"
				+ "-fx-font-size: 20;"
				+ "-fx-font-weight: bold"
		);
		
		cnpj.setStyle("-fx-font-size: 14");
		
		lCNPJ.setStyle(
				"-fx-text-fill: chocolate;"
				+ "-fx-font-size: 14;"
				+ "-fx-font-weight: bold"
		);
		
		VBox vbox = new VBox(5);
		vbox.setAlignment(Pos.TOP_LEFT);
		vbox.setPadding(new Insets(10));
		this.addLabelsToVBox(vbox, nome, null);
		this.addLabelsToVBox(vbox, lCNPJ, cnpj);
		this.setCenter(vbox);
		
		Button remove = new Button("Remover");
		remove.setOnAction(evt -> removerFinanciador());
		remove.setMinHeight(25);
		remove.setPrefHeight(25);
		remove.setMaxHeight(25);
		this.setRight(remove);
	}
	
	private void removerFinanciador() {
		try {
			service.remover(financiador);
		} catch (SQLException e) {
			System.out.println("Tratar exceção de remoção de Financiador");
		}
	}
}
