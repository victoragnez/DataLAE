package GUI.listagem;

import java.sql.SQLException;

import Model.Viagem;
import Service.ViagemService;
import Service.Interfaces.IViagemService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BlocoViagem extends Bloco {
	private IViagemService service;
	private Viagem viagem;
	
	public BlocoViagem(Viagem viagem) {
		super();
		this.viagem = viagem;
		this.service = ViagemService.getInstance();
		
		Label data = new Label(this.viagem.getDataInicio() + " - " + this.viagem.getDataTermino());
		data.setStyle(
				"-fx-text-fill: chocolate;"
        		+ "-fx-font-weight: bold;"
            	+ "-fx-font-size: 20;"
        );
		String style = "-fx-text-fill: chocolate; -fx-font-weight: bold; -fx-font-size: 14";
		
		
//		Label lLocal = new Label("Local:");
//		Label local = new Label(
//			this.viagem.getLocal().getNome() + 
//			(this.viagem.getLocal().getCidade().length() > 0 ? ", " + this.viagem.getLocal().getCidade() : "") + 
//			(this.viagem.getLocal().getEstado().length() > 0 ? ", " + this.viagem.getLocal().getEstado() : "") + 
//			(this.viagem.getLocal().getPais().length() > 0 ? ", " + this.viagem.getLocal().getPais() : ""));
//		local.setStyle("-fx-font-size: 14");
//		lLocal.setStyle(style);
//		
//		Label lProj = new Label("Projeto:");
//		Label lProjNome = new Label(this.viagem.getProjeto().getNome());
//		lProjNome.setStyle("-fx-font-size: 14");
//		lProj.setStyle(style);
		
		VBox vbox = new VBox(5);
		vbox.setAlignment(Pos.TOP_LEFT);
		vbox.setPadding(new Insets(10));
		this.addLabelsToVBox(vbox, data, null);
//		this.addLabelsToVBox(vbox, lLocal, local);
//		this.addLabelsToVBox(vbox, lProj, lProjNome);
		this.setCenter(vbox);
		
		Button remove = new Button("Remover");
		remove.setOnAction(evt -> removerViagem());
		remove.setMinHeight(25);
		remove.setPrefHeight(25);
		remove.setMaxHeight(25);
		this.setRight(remove);
	}
	
	private void removerViagem() {
		try {
			service.remover(viagem);
		} catch (SQLException e) {
			System.out.println("Tratar exceção na remoção de Viagem");
		}
	}
}
