package Service.Interfaces;


import DAO.Exceptions.CampoInvalidoException;
import Model.Pesquisador;
import Service.Exceptions.AtributoInvalidoException;

public interface IPesquisadorService {

	public void inserir(Pesquisador p) throws AtributoInvalidoException, CampoInvalidoException;
	public void remover(Pesquisador p);
	public Pesquisador consultar(String codigoPesquisador);
	public void alterar (Pesquisador p);
	
}
