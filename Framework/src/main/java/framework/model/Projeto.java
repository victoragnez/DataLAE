package framework.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class Projeto<Part extends Participante> {
	
	/* Atributos */
	
	private Integer codigo;
	private String nome;
	private Date dataInicio;
	private Date dataFim;
	private List<Part> participantes;
	
	/* Contrutores */
	public Projeto() {
		/* Nothing */
	}
	
	/**
	 * Construtor para Projeto
	 * @param codigo			O código que identifica o projeto  
	 * @param nome              O nome do projeto
	 * @param dataInicio        A data de Início do projeto
	 * @param dataFim           A data de Termino do projeto
	 * @param participantes     Uma lista de participantes que trabalham no projeto
	 */
	public Projeto(Integer codigo, String nome, Date dataInicio,
			Date dataFim, ArrayList<Part> participantes) 
	{
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.participantes = participantes;
	}
	
	/* Getters and Setters */
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<Part> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Part> participantes) {
		this.participantes = participantes;
	}
}
