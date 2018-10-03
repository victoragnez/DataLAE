package Model;

public class Titulacao {
	
	private Integer id;
	private String nome;
	
	public Titulacao (Integer id, String nome)  {
		this.id = id;
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
	
}
