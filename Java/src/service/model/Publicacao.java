package service.model;

import java.util.ArrayList;

public class Publicacao {
	private final String codigo;
	private String nome;
	private String arquivo;
	private PublicacaoTipo tipo;
	private ArrayList<AutorPublicacao> autores;
	
	public Publicacao(String codigo, String nome, String arquivo, PublicacaoTipo tipo, ArrayList<AutorPublicacao> autores) {
		this.codigo = codigo;
		this.nome = nome;
		this.arquivo = arquivo;
		this.tipo = tipo;
		this.autores = autores;
	}
	
	public Publicacao(String nome, String arquivo, PublicacaoTipo tipo, ArrayList<AutorPublicacao> autores) {
		this.codigo = null;
		this.nome = nome;
		this.arquivo = arquivo;
		this.tipo = tipo;
		this.autores = autores;
	}
	
	public void addAutor(AutorPublicacao autor) {
		autores.add(autor);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public void setTipo(PublicacaoTipo tipo) {
		this.tipo = tipo;
	}
	
	public void setAutores(ArrayList<AutorPublicacao> autores) {
		this.autores = autores;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getArquivo() {
		return arquivo;
	}
	
	public PublicacaoTipo getTipo() {
		return tipo;
	}
	
	public ArrayList<AutorPublicacao> getAutores() {
		return autores;
	}
}
