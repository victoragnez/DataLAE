package Model;

public class Local {

	private String nome;
	private String pais;
	private String estado;
	private String cidade;
	private Integer codigo;
	
	
	public Local(String nome, String pais, String estado, String cidade, 
			Integer codigo) 
	{
		this.nome = nome;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public Integer getCodigo() {
		return codigo;
	}
}
