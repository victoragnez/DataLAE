package dao;

public class RepeatedKeyException extends Exception {

	public RepeatedKeyException(){
		super();
	}

	public RepeatedKeyException(String mensagem){
		super(mensagem);
	}

	public RepeatedKeyException(String mensagem, Throwable causa){
		super(mensagem, causa);
	}
}
