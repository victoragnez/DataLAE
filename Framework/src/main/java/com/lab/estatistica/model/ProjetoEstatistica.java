package com.lab.estatistica.model;

import framework.model.Projeto;

public class ProjetoEstatistica extends Projeto<ParticipanteEstatistica> {
	private String professor;
	private String orgao;
	/**
	 * @return the professor
	 */
	public String getProfessor() {
		return professor;
	}
	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	/**
	 * @return the orgao
	 */
	public String getOrgao() {
		return orgao;
	}
	/**
	 * @param orgao the orgao to set
	 */
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
}
