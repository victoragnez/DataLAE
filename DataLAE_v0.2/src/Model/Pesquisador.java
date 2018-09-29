package Model;

public class Pesquisador {

	private String titulacao;
	private String universidade;
	private String nome;
	private String cpf;
	
	public Pesquisador(String titulacao, String universidade, String nome, 
			String cpf) 
	{
		this.titulacao = titulacao;
		this.universidade = universidade;
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
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
	
		
	
}
