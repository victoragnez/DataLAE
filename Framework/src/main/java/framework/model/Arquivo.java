package framework.model;

public class Arquivo<P extends Projeto<?>, A extends Pratica<?, ?, ?> > {
	
	/** Atributos */
	private String nome;
	private Long tamanho;
	private byte[] dados;
	private P projeto;
	private A atividade;
	private Integer codigo;

	public Arquivo() {}
	
	public Arquivo(String nome, Long tamanho, byte[] dados, P projeto, A atividade, Integer codigo) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.dados = dados;
		this.projeto = projeto;
		this.atividade = atividade;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	public byte[] getDados() {
		return dados;
	}

	/**
	 * @param dados the dados to set
	 */
	public void setDados(byte[] dados) {
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
	public P getProjeto() {
		return projeto;
	}

	/**
	 * @param projeto the projeto to set
	 */
	public void setProjeto(P projeto) {
		this.projeto = projeto;
	}
	
	/**
	 * @return the projeto
	 */
	public A getAtividade() {
		return atividade;
	}

	/**
	 * @param projeto the projeto to set
	 */
	public void setAtividade(A atividade) {
		this.atividade = atividade;
	}

}