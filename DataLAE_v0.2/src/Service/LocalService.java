package Service;

import java.sql.SQLException;

import DAO.LocalDAO;
import DAO.Interfaces.ILocalDAO;
import Model.Local;
import Model.Projeto;
import Service.Interfaces.ILocalService;

public class LocalService implements ILocalService {

	ILocalDAO dao = new LocalDAO();
	
	@Override
	public void inserir(Local l, Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Local l, Projeto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Local consultar(String codigoLocal, Projeto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Local l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(Local l) throws SQLException {
		dao.inserir(l);
	}

	
}
