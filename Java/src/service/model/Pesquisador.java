package service.model;

public class Pesquisador {
	private final String codigo;
	private String nome;
	private PesquisadorTipo tipo;
	
	public Pesquisador(String codigo, String nome, PesquisadorTipo tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Pesquisador(String nome, PesquisadorTipo tipo) {
		this.codigo = null;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTipo(PesquisadorTipo tipo) {
		this.tipo = tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public PesquisadorTipo getTipo() {
		return tipo;
	}
}
