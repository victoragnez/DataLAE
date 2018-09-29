package Service.Interfaces;

import Model.Local;
import Model.Projeto;

public interface ILocalService {

	public void inserir(Local l, Projeto p);
	public void remover(Local l, Projeto p);
	public Local consultar(String codigoLocal, Projeto p);
	public void alterar (Local l);
	
}
