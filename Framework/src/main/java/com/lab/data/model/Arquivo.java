package com.lab.data.model;

import java.io.InputStream;

public class Arquivo {
	
	/** Atributos */
	
	private String nome;
//	private TipoArquivo tipo;
	private Long tamanho;
	private InputStream dados;
	private Projeto projeto;
	private Integer codigo;

	public Arquivo(String nome, /*TipoArquivo tipo, */ 
			Long tamanho, InputStream dados, 
			Projeto projeto, Integer codigo) {
		
		this.nome = nome;
//		this.tipo = tipo;
		this.tamanho = tamanho;
		this.dados = dados;
		this.setCodigo(codigo);
		this.projeto = projeto;
	}
	
	public Arquivo(String nome, /*TipoArquivo tipo,*/ 
			Long tamanho, InputStream dados, 
			Projeto projeto) {
		
		this(nome, /*tipo,*/ tamanho, dados, projeto, null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*public TipoArquivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArquivo tipo) {
		this.tipo = tipo;
	}*/

	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the dados
	 */
	public InputStream getDados() {
		return dados;
	}

	/**
	 * @param dados the dados to set
	 */
	public void setDados(InputStream dados) {
		this.dados = dados;
	}

	/**
	 * @return the tamanho
	 */
	public Long getTamanho() {
		return tamanho;
	}

	/**
	 * @param tamanho the tamanho to set
	 */
	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
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

}