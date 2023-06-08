package br.com.curso.bibliotecaref.exception;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

}
