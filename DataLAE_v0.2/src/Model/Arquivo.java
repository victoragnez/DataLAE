package Model;

public class Arquivo {
	private Integer codigo;
	private String nome;
	private TipoArquivo tipo;
	private Metodo metodo;
	
	public Arquivo() {
		codigo = null;
		nome = null;
		tipo = null;
		metodo = null;
	}
	
	public Arquivo(Integer codigo, String nome, TipoArquivo tipo, Metodo metodo) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.metodo = metodo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoArquivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArquivo tipo) {
		this.tipo = tipo;
	}

	public Metodo getMetodo() {
		return metodo;
	}

	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}

	public Integer getCodigo() {
		return codigo;
	}
}
