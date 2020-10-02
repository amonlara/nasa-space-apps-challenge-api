package br.com.nasaspaceappschallenge.domain.model.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errorMessage;

	public EntityNotFoundException(String message) {
		super(message);
		errorMessage = message;
	}

}
