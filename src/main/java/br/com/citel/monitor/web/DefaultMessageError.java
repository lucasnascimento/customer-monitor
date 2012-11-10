package br.com.citel.monitor.web;

/**
 * Mensagem de erro default
 * 
 * @author marcelofelix
 * 
 */
public class DefaultMessageError extends AbstractMessageError<Exception> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5774156363331239911L;

	private static final String DEFAULT_MESSAGE_ERROR = "default.message.error";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.org.sesc.exception.AbstractMessageError#convert(java.lang.Exception)
	 */
	@Override
	public void convert(final Exception exception) {
		setMessage(exception.getMessage());
	}

	/**
	 * @return a causa da exceção.
	 */
	public String getCause() {
		if (getException() != null && getException().getCause() != null) {
			return getException().getCause().toString();
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.org.sesc.exception.MessageError#getCode()
	 */
	@Override
	public String getCode() {
		return DEFAULT_MESSAGE_ERROR;
	}
}