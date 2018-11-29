package framework.service;

import java.util.List;

import framework.dao.interfaces.IDAOParticipante;
import framework.model.BadAttributeException;
import framework.model.DatabaseException;
import framework.model.Participante;
import framework.service.interfaces.IServiceParticipante;

public abstract class ServiceParticipante<P extends Participante> implements IServiceParticipante<P> {

	private final IDAOParticipante<P> dao;
	
	public ServiceParticipante (IDAOParticipante<P> dao) {
		this.dao = dao;
	}
	
	@Override
	public void inserir(P p) throws DatabaseException, BadAttributeException {
		if (p == null)
			throw new BadAttributeException("Falha ao tentar inserir participante! O particiante fornecido possui um valor nulo.");
		if (p.getNome() == null) 
			throw new BadAttributeException("Nome do particiante é nulo! Por favor, forneça um nome válido.");
		if (p.getEmail() == null)
			throw new BadAttributeException("E-mail do particiante é nulo! Por favor, forneça um e-mail válido.");
		if (p.getInstituicao() == null)
			throw new BadAttributeException("Instituição do particiante é nula! Por favor, forneça uma instituição válida.");
		
		validarInserir(p);
		dao.inserir(p);
	}
	
	@Override
	public void remover(P p) throws DatabaseException, BadAttributeException {
		if (p == null)
			throw new BadAttributeException("Falha ao tentar remover particiante! O particiante fornecido possui um valor nulo.");
		if (p.getCodigo() == null)
			throw new BadAttributeException("Identificação de participante nula!");

		dao.remover(p);
	}
	
	@Override
	public void atualizar(P p) throws DatabaseException, BadAttributeException {
		if (p == null)
			throw new BadAttributeException("Parâmetro fornecido nulo");
		if (p.getCodigo() == null)
			throw new BadAttributeException("Identificação de participante nula!");
		if (p.getNome() == null) 
			throw new BadAttributeException("Nome nulo!");
		if (p.getEmail() == null)
			throw new BadAttributeException("Email nulo");
		if (p.getInstituicao() == null)
			throw new BadAttributeException("Instituição nula");
		
		validarAtualizar(p);
		dao.atualizar(p);
	}
	
	@Override
	public List<P> consultar(P p) throws DatabaseException, BadAttributeException {
		if (p == null)
			throw new BadAttributeException("Parâmetro fornecido nulo");
				
		validarConsultar(p);
		return dao.consultar(p);
	}
	
	@Override
	public List<P> listar() throws DatabaseException {
		return dao.listar();
	}

	/** Metodos que precisam ser implementados */
	protected abstract void validarInserir(P p) throws BadAttributeException;
	protected abstract void validarAtualizar(P p) throws BadAttributeException;
	protected abstract void validarConsultar(P p) throws BadAttributeException;
}
