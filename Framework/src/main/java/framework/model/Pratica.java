package framework.model;

import java.sql.Date;
import java.util.List;

public abstract class Pratica<
		A extends Area, 
		Part extends Participante,
		Proj extends Projeto<Part>> 
{
	
	/* Atributos */
	private Integer codigo;
	private Date dataInicio;
	private Date dataTermino;
	private A area;
	private Proj projeto;
	private List<Part> participantes;
	
	/* Construtores */
	public Pratica() {
		/* Nothing */
	}

	public Pratica(
			Integer codigo, 
			Date dataInicio, 
			Date dataTermino, 
			A area, 
			Proj projeto, 
			List<Part> participantes) 
	{
		this.codigo = codigo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.area = area;
		this.projeto = projeto;
		this.participantes = participantes;
	}

	/* Getters e setters */
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public A getArea() {
		return area;
	}

	public void setArea(A area) {
		this.area = area;
	}

	public Proj getProjeto() {
		return projeto;
	}

	public void setProjeto(Proj projeto) {
		this.projeto = projeto;
	}

	public List<Part> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Part> participantes) {
		this.participantes = participantes;
	}
}
