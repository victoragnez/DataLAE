package service;

import dao.IUpdateDAO;
import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public class UpdateService implements IUpdateService {
	private IUpdateDAO updateDAO;
	
	public UpdateService(IUpdateDAO updateDAO) {
		this.updateDAO = updateDAO;
	}
	
	// ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois:
	
	@Override
	public void updateProjeto(Projeto p) {
		updateDAO.updateProjeto(p);
	}

	@Override
	public void updateArea(Projeto p, Area a) {
		updateDAO.updateArea(p, a);
	}

	@Override
	public void updateViagem(Projeto p, Area a, Viagem v) {
		updateDAO.updateViagem(p, a, v);
	}
}
