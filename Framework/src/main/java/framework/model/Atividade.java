package framework.model;

import java.sql.Date;
import java.util.List;

public abstract class Atividade {
	private Projeto projeto;
	private Area area;
	private Date data;
	private List<Participante> participantes;
	private Integer codigo;
	
	public Atividade(){}
	
	public Atividade(Projeto projeto, Area area, Date data, List<Participante> participantes) {
		this.setProjeto(projeto);
		this.setArea(area);
		this.setData(data);
		this.setParticipantes(participantes);
	}
	
	public Atividade(Projeto projeto, Area area, Date data, List<Participante> participantes, Integer codigo) {
		this.setProjeto(projeto);
		this.setArea(area);
		this.setData(data);
		this.setParticipantes(participantes);
		this.setCodigo(codigo);
	}

	/**
	 * @return the projeto
	 */
	public Projeto getProjeto() {
		return projeto;
	}

	/**
	 * @param projeto the projeto to set
	 */
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	/**
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
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
	
}
