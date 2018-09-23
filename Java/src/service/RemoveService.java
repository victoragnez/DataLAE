package service;

import dao.IRemoveDAO;
import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public class RemoveService implements IRemoveService {
	private IRemoveDAO removeDAO;
	
	public RemoveService(IRemoveDAO removeDAO) {
		this.removeDAO = removeDAO;
	}
	
	// ATENÇÃO: Ajeitar regras de negócio para os métodos abaixo depois:

	@Override
	public void removePesquisa(Pesquisa p) {
		removeDAO.removePesquisa(p);
	}

	@Override
	public void removeArea(Pesquisa p, Area a) {
		removeDAO.removeArea(p, a);
	}

	@Override
	public void removeViagem(Pesquisa p, Area a, Viagem v) {
		removeDAO.removeViagem(p, a, v);
	}
}
