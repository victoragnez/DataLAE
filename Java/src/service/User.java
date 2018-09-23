package service;

public abstract class User {
	static private String username, password;
	
	static public String getUsername() {
		return username;
	}
	
	static public String getPassword() {
		return password;
	}
	
	static public void setUsername(String s) {
		username = s;
	}
	
	static public void setPassword(String s) {
		password = s;
	}
	
}
