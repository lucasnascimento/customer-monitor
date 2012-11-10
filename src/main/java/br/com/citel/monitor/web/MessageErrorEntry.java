package br.com.citel.monitor.web;

import org.springframework.http.HttpStatus;

/**
 * Clase utilizada para configurar a conversão de exception para mensagens de
 * erro e status.
 * 
 * @author marcelofelix
 * 
 */
public class MessageErrorEntry {

	private Class<? extends Exception> exception;
	private Class<? extends MessageError> messageError;
	private int httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();

	/**
	 * @return the exception
	 */
	public Class<? extends Exception> getException() {
		return exception;
	}

	/**
	 * @param exception
	 *            the exception to set
	 */
	public void setException(final Class<? extends Exception> exception) {
		this.exception = exception;
	}

	/**
	 * @return the messageError
	 */
	public Class<? extends MessageError> getMessageError() {
		return messageError;
	}

	/**
	 * @param messageError
	 *            the messageError to set
	 */
	public void setMessageError(final Class<? extends MessageError> messageError) {
		this.messageError = messageError;
	}

	/**
	 * @return the httpStatus
	 */
	public int getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus
	 *            the httpStatus to set
	 */
	public void setHttpStatus(final int httpStatus) {
		this.httpStatus = httpStatus;
	}

}