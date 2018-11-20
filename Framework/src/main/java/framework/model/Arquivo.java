package framework.model;

public class Arquivo {
	
	/** Atributos */
	
	private String nome;
	private Long tamanho;
	private byte[] dados;
	private Projeto projeto;
	private Integer codigo;

	public Arquivo(String nome, 
			Long tamanho, byte[] dados, 
			Projeto projeto, Integer codigo) {
		
		this.nome = nome;
		this.tamanho = tamanho;
		this.dados = dados;
		this.setCodigo(codigo);
		this.projeto = projeto;
	}
	
	public Arquivo(String nome,
			Long tamanho, byte[] dados, 
			Projeto projeto) {
		
		this(nome, tamanho, dados, projeto, null);
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