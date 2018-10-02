package Model;

public class Pesquisador {

	private Titulacao titulacao;
	private String universidade;
	private String nome;
	private String cpf;
	private String codigo;
	
	public Pesquisador(Titulacao titulacao, String universidade, String nome, 
			String cpf) 
	{
		this.titulacao = titulacao;
		this.universidade = universidade;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Titulacao getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(Titulacao titulacao) {
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Pesquisador [titulacao=" + titulacao + ", universidade=" + universidade + ", nome=" + nome + ", cpf="
				+ cpf + ", codigo=" + codigo + "]";
	}
	
		
	
}
