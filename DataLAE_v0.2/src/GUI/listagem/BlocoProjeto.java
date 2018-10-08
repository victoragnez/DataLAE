package GUI.listagem;

import java.sql.SQLException;
import java.text.DateFormat;

import Model.Projeto;
import Service.ProjetoService;
import Service.Interfaces.IProjetoService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BlocoProjeto extends Bloco {
	private IProjetoService service;
	private Projeto projeto;
	
	public BlocoProjeto(Projeto projeto) {
		super();
		this.service = ProjetoService.getInstance();
		this.projeto = projeto;
		
		Label nome = new Label(
				projeto.getNome() +
				projeto.getSigla() != null || projeto.getSigla().length() > 0 ? 
						"(" + projeto.getSigla() + ")" : "");
		nome.setStyle("-fx-text-fill: chocolate; -fx-font-size: 20; -fx-font-weight: bold");
		
		String styleTitulo = "-fx-text-fill: chocolate; -fx-font-size: 14; -fx-font-weight: bold";
		String styleValue = "-fx-font-size: 14";
		
		
		Label lCoord = new Label("Coordenador:");
		Label coord = new Label(projeto.getCoordenador());
		
		Label lIni = new Label("Data de início:");
		Label lFim = new Label("Data de término:");
		
		DateFormat d = DateFormat.getInstance();
		
		Label ini = new Label(d.format(projeto.getDataInicio()));
		Label fim = new Label(projeto.getDataTermino() == null ? "" : d.format(projeto.getDataTermino()));
		
		
		lCoord.setStyle(styleTitulo);
		lIni.setStyle(styleTitulo);
		lFim.setStyle(styleTitulo);
		
		coord.setStyle(styleValue);
		ini.setStyle(styleValue);
		fim.setStyle(styleValue);
		
		VBox vbox = new VBox(5);
		vbox.setAlignment(Pos.TOP_LEFT);
		vbox.setPadding(new Insets(10));
		this.addLabelsToVBox(vbox, nome, null);
		this.addLabelsToVBox(vbox, lCoord, coord);
		this.addLabelsToVBox(vbox, lIni, ini);
		this.addLabelsToVBox(vbox, lFim, fim);
		
		this.setCenter(vbox);
		
		Button remove = new Button("Remover");
		remove.setOnAction(evt -> removerProjeto());
		remove.setMinHeight(25);
		remove.setPrefHeight(25);
		remove.setMaxHeight(25);
		this.setRight(remove);
	}
	
	private void removerProjeto() {
		try {
			service.remover(projeto);
		} catch (SQLException e) {
			System.out.println("Tratar exceção na remoção de projeto");
		}
	}
}
