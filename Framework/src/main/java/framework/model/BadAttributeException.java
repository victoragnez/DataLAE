package framework.model;

public class BadAttributeException extends Exception {

	private static final long serialVersionUID = -471035963148401170L;

	public BadAttributeException() {}
	public BadAttributeException(String message) { super(message); }
	public BadAttributeException(Throwable cause) { super(cause); }
	public BadAttributeException(String message, Throwable cause) {super(message, cause);}
	public BadAttributeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) { super(message, cause, enableSuppression, writableStackTrace);}

}
