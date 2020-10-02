package br.com.nasaspaceappschallenge.domain.model.exception;
import lombok.Getter;

@Getter
public class EntityValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3990230734685978718L;
	private final String errorMessage;

	public EntityValidationException(String message) {
		super(message);
		errorMessage = message;
	}
	
	public EntityValidationException(String message, Exception e) {
		super(message,e);
		errorMessage = message;
	}

}
