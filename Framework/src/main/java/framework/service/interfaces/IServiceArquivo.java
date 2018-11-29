package framework.service.interfaces;

import java.util.List;

import framework.model.Arquivo;
import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.model.Pratica;
import framework.model.Projeto;

public interface IServiceArquivo<Proj extends Projeto<?>, Prat extends Pratica<?, ?, Proj>> {

	public void inserir(Arquivo<Proj, Prat> a) throws DatabaseException, BadAttributeException;
	public void remover(Arquivo<Proj, Prat> a) throws DatabaseException, BadAttributeException;
	public void atualizar(Arquivo<Proj, Prat> a) throws DatabaseException, BadAttributeException;
	public List<Arquivo<Proj, Prat>> consultar(Arquivo<Proj, Prat> a) throws DatabaseException, BadAttributeException;
	public List<Arquivo<Proj, Prat> > listar() throws DatabaseException;
	Arquivo<Proj, Prat> ler(Arquivo<Proj, Prat> a) throws DatabaseException, BadAttributeException;
}
