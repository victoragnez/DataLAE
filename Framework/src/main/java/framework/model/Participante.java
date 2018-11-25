package framework.model;

public abstract class Participante {
	
	/* Atributos */
	private Integer codigo;
	private String nome;
	private String instituicao;
	private String email;
	
	/* Contrutores */
	public Participante() {
		/* Nothing */
	}
	
	public Participante(Integer codigo, String nome, String instituicao, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.instituicao = instituicao;
		this.email = email;
	}

	/* Getters e Setters*/
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

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
