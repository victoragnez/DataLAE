package Model;

public class Financiador {

	private String nome;
	private Diretor diretor;
	private Integer codigo;
	private String cnpj;
	
	public Financiador (String nome, Diretor diretor, Integer codigo, 
			String cnpj)
	{
		this.nome = nome;
		this.diretor = diretor;
		this.codigo = codigo;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	
	
	
}
