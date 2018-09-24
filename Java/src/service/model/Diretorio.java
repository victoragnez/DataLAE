package service.model;

public class Diretorio {
	private String nome;
	
	public Diretorio(){
		nome = null;
	}
	
	public Diretorio(String s){
		nome = s;
	}
	
	public String getNome() {
		return nome;
	}
}
