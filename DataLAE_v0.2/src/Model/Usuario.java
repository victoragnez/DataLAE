package Model;

public class Usuario {

	// Atributes
	
	private String nome;
	private String email;
	private String username;
	private String password;
	
	
	/**
	 * 
	 * @param nome      nome do usuário
	 * @param email	    email do usuário
	 * @param username  username do usuário
	 * @param password  senha do usuário
	 */
	public Usuario (String nome, String email, String username, 
			String password) 
	{
		this.nome = nome;
		this.email = email;
		this.username = username;
		this.password = password;		
	}
	
	
	// Getters and Setters
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
