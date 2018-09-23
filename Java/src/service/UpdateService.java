package service;

import dao.IUpdateDAO;
import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public class UpdateService implements IUpdateService {
	private IUpdateDAO updateDAO;
	
	public UpdateService(IUpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
	
	// ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois:
	
	@Override
	public void updatePesquisa(Pesquisa p) {
		updateDAO.updatePesquisa(p);
	}

	@Override
	public void updateArea(Pesquisa p, Area a) {
		updateDAO.updateArea(p, a);
	}

	@Override
	public void updateViagem(Pesquisa p, Area a, Viagem v) {
		updateDAO.updateViagem(p, a, v);
	}
}
