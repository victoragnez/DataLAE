package gui.model;

import service.model.Projeto;

public class PesquisaBlock extends Block {
	private Projeto pesq;
	
	public PesquisaBlock(Projeto pesq) {
		super(pesq.getDenomicacao(),
				"Coordenador: " + pesq.getCoordenador() +
				"\nFinanciador: " + pesq.getFinanciador());
		this.pesq = pesq;
	}
	
	public Projeto getPesquisa() {
		return pesq;
	}
}
