package framework.model;

import java.sql.Date;
import java.util.ArrayList;

public abstract class Projeto {
	
	/** Atributos */
	
	private String nome;
	private ArrayList<Participante> participantes;
	private Date dataInicio;
	private Date dataFim;
	private Integer codigo;
	
	public Projeto() {}
	
	/**
	 * Construtor para Projeto
	 * @param nome              O nome do projeto
	 * @param participantes     Uma lista de participantes que trabalham no projeto
	 * @param dataInicio        A data de Início do projeto
	 * @param dataFim           A data de Termino do projeto
	 */
	public Projeto(String nome, ArrayList<Participante> participantes, 
				   Date dataInicio, Date dataFim) 
	{
		this.nome = nome;
		this.participantes = participantes;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	
	/**
	 * Construtor para projeto sem data de término definida
	 * @param nome              O nome do projeto
	 * @param participantes     Uma lista de participantes que trabalham no projeto
	 * @param dataInicio        A data de Início do projeto
	 */
	public Projeto(String nome, ArrayList<Participante> participantes, 
			   Date dataInicio) 
	{
		this.nome = nome;
		this.participantes = participantes;
		this.dataInicio = dataInicio;
	}
	
	public Projeto(String nome, Integer codigo)
	{
		this.nome = nome;
		this.codigo = codigo;
	}
	
	/** Getters and Setters */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
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

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
