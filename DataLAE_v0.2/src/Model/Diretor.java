package Model;

public class Diretor {

	private String nome;
	private String email;
	private String telefone;
	private String cargo;
	private String codigo;
	
	/**
	 * 
	 * @param nome
	 * @param email
	 * @param telefone
	 * @param cargo
	 */
	public Diretor (String nome, String email, String telefone,
			String cargo, String codigo) 
	{
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cargo = cargo;
		this.codigo = codigo;
	}

	//Getters and Setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCodigo() {
		return codigo;
	}	
	
}