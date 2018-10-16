package Model;

import java.io.InputStream;

public class Arquivo {
	private String nome;
	private TipoArquivo tipo;
	private Metodo metodo;
	private Long tamanho;
	private InputStream dados;
	private Projeto projeto;
	private Viagem viagem;
	private Integer codigo;

	public Arquivo(String nome, TipoArquivo tipo, 
			Metodo metodo, Long tamanho, InputStream dados, 
			Projeto projeto, Viagem viagem, Integer codigo) {
		this.nome = nome;
		this.tipo = tipo;
		this.metodo = metodo;
		this.tamanho = tamanho;
		this.dados = dados;
		this.setCodigo(codigo);
		this.projeto = projeto;
		this.viagem = viagem;
	}
	
	public Arquivo(String nome, TipoArquivo tipo, 
			Metodo metodo, Long tamanho, InputStream dados, 
			Projeto projeto, Viagem viagem) {
		
		this(nome, tipo, metodo, tamanho, dados, projeto, viagem, null);
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

	/**
	 * @return the viagem
	 */
	public Viagem getViagem() {
		return viagem;
	}

	/**
	 * @param viagem the viagem to set
	 */
	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}
}
