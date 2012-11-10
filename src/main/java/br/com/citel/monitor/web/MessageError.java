package br.com.citel.monitor.web;

/**
 * Interface padrão para tratamento de erro
 * 
 * @author marcelofelix
 * 
 */
public interface MessageError {

	/**
	 * @return the message
	 */
	String getMessage();

	/**
	 * @return Codigo do erro
	 */
	String getCode();

	/**
	 * @param messageSource
	 */
	void setMessageSource(MessageSourceLocaleResolver messageSource);

	/**
	 * @param exception
	 */
	void setException(Exception exception);

}