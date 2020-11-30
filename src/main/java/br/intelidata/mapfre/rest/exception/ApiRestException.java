package br.intelidata.mapfre.rest.exception;

public class ApiRestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiRestException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiRestException(String message) {
		super(message);
	}

	public ApiRestException(Throwable cause) {
		super(cause);
	}
}
