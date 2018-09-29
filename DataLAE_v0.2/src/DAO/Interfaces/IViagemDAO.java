package DAO.Interfaces;

import Model.Local;
import Model.Projeto;
import Model.Viagem;

public interface IViagemDAO {

	public void inserir(Viagem v, Local l, Projeto p);
	public void remover(Viagem v, Local l, Projeto p);
	public Viagem consultar(String codigoViagem, Local l, Projeto p);
	public void alterar(Viagem v, Local l, Projeto p);
	
}
