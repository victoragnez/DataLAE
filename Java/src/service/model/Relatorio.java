package service.model;

public class Relatorio {
	private final String codigo;
	private String nome;
	private String arquivo;
	
	public Relatorio(String nome, String arquivo) {
		this.codigo = null;
		this.nome = nome;
		this.arquivo = arquivo;
	}
	
	public Relatorio(String codigo, String nome, String arquivo) {
		this.codigo = codigo;
		this.nome = nome;
		this.arquivo = arquivo;
	}
	
	public void setNome(String s) {
		nome = s;
	}
	
	public void setArquivo(String s) {
		arquivo = s;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getArquivo() {
		return arquivo;
	}
	
	public String getCodigo() {
		return codigo;
	}
}
