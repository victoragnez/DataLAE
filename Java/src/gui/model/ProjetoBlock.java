package gui.model;

import service.model.Projeto;

public class ProjetoBlock extends Block {
	private Projeto proj;
	
	public ProjetoBlock(Projeto proj) {
		super(proj.getDenomicacao(),
				"Coordenador: " + proj.getCoordenador() +
				"\nFinanciador: " + proj.getFinanciador());
		this.proj = proj;
	}
	
	public Projeto getPesquisa() {
		return proj;
	}
}
