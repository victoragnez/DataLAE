package framework.model;

import java.sql.Date;
import java.util.List;

public abstract class Atividade {
	
	private Integer referenciaProjeto;
	private Integer referenciaArea;
	private Date dataInicio;
	private Date dataTermino;
	private List<Participante> participantes;
	private Integer codigo;
	
	public Atividade(){}
	
	public Atividade(Integer projeto, Integer area, Date dataInicio, 
			Date dataTermino, List<Participante> participantes) {
		this.setReferenciaProjeto(projeto);
		this.setReferenciaArea(area);
		this.setDataInicio(dataInicio);
		this.setDataTermino(dataTermino);
		this.setParticipantes(participantes);
	}
	
	public Atividade(Integer projeto, Integer area, Date dataInicio, 
			List<Participante> participantes, Integer codigo) {
		this.setReferenciaProjeto(projeto);
		this.setReferenciaArea(area);
		this.setDataInicio(dataInicio);
		this.setParticipantes(participantes);
		this.setCodigo(codigo);
	}



	/**
	 * @return the participantes
	 */
	public List<Participante> getParticipantes() {
		return participantes;
	}

	/**
	 * @param participantes the participantes to set
	 */
	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
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

	public Integer getReferenciaProjeto() {
		return referenciaProjeto;
	}

	public void setReferenciaProjeto(Integer referenciaProjeto) {
		this.referenciaProjeto = referenciaProjeto;
	}

	public Integer getReferenciaArea() {
		return referenciaArea;
	}

	public void setReferenciaArea(Integer referenciaArea) {
		this.referenciaArea = referenciaArea;
	}
	
}
