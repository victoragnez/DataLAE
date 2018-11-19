package framework.model;

@Deprecated
public abstract class Usuario {

	private String username;
	private String email;
	private String password;
	private Integer codigo;
	
	public Usuario(String username, String email, String password, 
				   Integer codigo) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.codigo = codigo;
	}
	
	public Usuario(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	/** Getters and Setters */
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
}
