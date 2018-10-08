package GUI.listagem;

import java.sql.SQLException;

import Model.Local;
import Service.LocalService;
import Service.Interfaces.ILocalService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BlocoLocal extends Bloco {
	private ILocalService service;
	private Local local;
	
	public BlocoLocal(Local local) {
		super();
		this.service = LocalService.getInstance();
		this.local = local;
		
		Label nome = new Label(local.getNome());
		
		Label lPais = new Label("País:");
		Label lEstado = new Label("Estado:");
		Label lCidade = new Label("Cidade:");
		
		Label pais = new Label(local.getPais());
		Label estado = new Label(local.getEstado());
		Label cidade = new Label(local.getCidade());
		
		VBox vbox = new VBox(5);
		vbox.setAlignment(Pos.TOP_LEFT);
		vbox.setPadding(new Insets(10));
		addLabelsToVBox(vbox, nome, null);
		addLabelsToVBox(vbox, lPais, pais);
		addLabelsToVBox(vbox, lEstado, estado);
		addLabelsToVBox(vbox, lCidade, cidade);
		this.setCenter(vbox);
		
		Button remove = new Button("Remover");
		remove.setOnAction(evt -> removerLocal());
		remove.setMinHeight(25);
		remove.setPrefHeight(25);
		remove.setMaxHeight(25);
		this.setRight(remove);
	}
	
	private void removerLocal() {
		try {
			service.remover(local);
		} catch (SQLException e) {
			System.out.println("Tratar exceção na remoção de Local");
		}
	}
}
