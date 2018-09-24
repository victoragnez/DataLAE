package service;

import dao.IRemoveDAO;
import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public class RemoveService implements IRemoveService {
	private IRemoveDAO removeDAO;
	
	public RemoveService(IRemoveDAO removeDAO) {
		this.removeDAO = removeDAO;
	}
	
	// ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois:

	@Override
	public void removeProjeto(Projeto p) {
		removeDAO.removeProjeto(p);
	}

	@Override
	public void removeArea(Projeto p, Area a) {
		removeDAO.removeArea(p, a);
	}

	@Override
	public void removeViagem(Projeto p, Area a, Viagem v) {
		removeDAO.removeViagem(p, a, v);
	}
}
