package framework.model;

public abstract class Area {
	
	/* Atributos */
	private Integer codigo;
	private String nome;
	
	/* Contrutores */
	public Area() {
		/* Nothing */
	}
	
	public Area(Integer codigo, String nome) {
		this.nome = nome;
		this.codigo = codigo;
	}

	/** Getters and Setters */
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
