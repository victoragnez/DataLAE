package Model;

public class Pesquisador {

	private String universidade;
	private String nome;
	private String cpf;
	private Integer codigo;
	
	public Pesquisador(String universidade, String nome, 
			String cpf) 
	{
		this.universidade = universidade;
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getUniversidade() {
		return universidade;
	}

	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Pesquisador [universidade=" + universidade + ", nome=" + nome + ", cpf="
				+ cpf + ", codigo=" + codigo + "]";
	}
	
		
	
}
