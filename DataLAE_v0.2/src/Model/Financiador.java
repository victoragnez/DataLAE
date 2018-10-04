package Model;

public class Financiador {

	private String nome;
	private Diretor diretor;
	private String cnpj;
	private Integer codigo;
	
	public Financiador (String nome, Diretor diretor, 
			String cnpj, Integer codigo)
	{
		this.nome = nome;
		this.diretor = diretor;
		this.cnpj = cnpj;
		this.codigo = codigo;
	}
	
	public Financiador (String nome, Diretor diretor, 
			String cnpj)
	{
		this(nome, diretor, cnpj, (Integer)null); 
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

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	
	
}
