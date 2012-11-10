package br.com.citel.monitor.web;

import java.io.Serializable;

/**
 * Classe base para a interface MessageError
 * 
 * @author marcelofelix
 * 
 * @param <T>
 */
public abstract class AbstractMessageError<T extends Exception> implements MessageError, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3506120656397733320L;
	private MessageSourceLocaleResolver messageSource;
	private T exception;
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void setException(final Exception exception) {
		this.exception = (T) exception;
		convert(this.exception);
	}

	/**
	 * @param exception
	 */
	public abstract void convert(T exception);

	@Override
	public void setMessageSource(final MessageSourceLocaleResolver messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * @return Exception
	 */
	protected T getException() {
		return exception;
	}

	/**
	 * @return the messageSource
	 */
	protected MessageSourceLocaleResolver getMessageSource() {
		return messageSource;
	}

}