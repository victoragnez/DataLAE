package gui.model;

import service.model.Pesquisa;

public class PesquisaBlock extends Block {
	private Pesquisa pesq;
	
	public PesquisaBlock(Pesquisa pesq) {
		super(pesq.getDenomicacao(),
				"Coordenador: " + pesq.getCoordenador() +
				"\nFinanciador: " + pesq.getFinanciador());
		this.pesq = pesq;
	}
	
	public Pesquisa getPesquisa() {
		return pesq;
	}
}
