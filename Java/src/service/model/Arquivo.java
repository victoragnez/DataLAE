package service.model;

public class Arquivo {
	private final String codigo;
	private String nome;
	
	public Arquivo(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public void setNome(String s) {
		nome = s;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}

}