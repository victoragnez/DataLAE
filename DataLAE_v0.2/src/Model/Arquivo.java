package Model;

import java.io.InputStream;

public class Arquivo {
	private String nome;
	private TipoArquivo tipo;
	private Metodo metodo;
	private Integer tamanho;
	private InputStream dados;
	private Integer codigo;
	
	public Arquivo() {
		codigo = null;
		nome = null;
		tipo = null;
		metodo = null;
	}
	
	public Arquivo(String nome, TipoArquivo tipo, 
			Metodo metodo, Integer tamanho, InputStream dados, Integer codigo) {
		this.nome = nome;
		this.tipo = tipo;
		this.metodo = metodo;
		this.tamanho = tamanho;
		this.dados = dados;
		this.codigo = codigo;
	}
	
	public Arquivo(String nome, TipoArquivo tipo, 
			Metodo metodo, Integer tamanho, InputStream dados) {
		this(nome, tipo, metodo, tamanho, dados, null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoArquivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArquivo tipo) {
		this.tipo = tipo;
	}

	public Metodo getMetodo() {
		return metodo;
	}

	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}

	public Integer getCodigo() {
		return codigo;
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
	public Integer getTamanho() {
		return tamanho;
	}

	/**
	 * @param tamanho the tamanho to set
	 */
	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}
}
