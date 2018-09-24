package service.model;

public class AutorPublicacao {
	private final String codigo;
	private String nome;
	
	public AutorPublicacao(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public AutorPublicacao(String nome) {
		this.codigo = null;
		this.nome = nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
}
