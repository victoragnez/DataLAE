package gui.model;

import service.model.Viagem;

public class ViagemBlock extends Block {
	private Viagem viagem;
	
	public ViagemBlock(Viagem viagem) {
		super(viagem.getData().toString(), "");
		this.viagem = viagem;
	}
	
	public Viagem getViagem() {
		return viagem;
	}
}
