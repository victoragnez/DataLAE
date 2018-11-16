package Model;

public abstract class Participante {

	/** Atributos */
	
	private String nome;
	private String instituicao;
	private String email;
	private Integer codigo;
	
	public Participante (String nome, String instituicao, String email)
	{
		this.nome = nome;
		this.instituicao = instituicao;
		this.email = email;
	}
	
	public Participante(String nome, String instituicao, String email, 
			Integer codigo) {
		this.nome = nome;
		this.instituicao = instituicao;
		this.email = email;
		this.codigo = codigo;
	}

	/** Getters and Setters*/
	
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

	
	public Integer getCodigo() {
		return codigo;
	}
	

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
}
