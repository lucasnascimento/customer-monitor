package br.com.citel.monitor.web;

/**
 * @author
 * 
 */
public class FieldErrorMessageError {

	private String field;
	private String message;

	/**
	 * Construtor.
	 */
	public FieldErrorMessageError() {
		super();
	}

	/**
	 * Construtor.
	 * 
	 * @param field
	 * @param message
	 */
	public FieldErrorMessageError(final String field, final String message) {
		super();
		this.field = field;
		this.message = message;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(final String field) {
		this.field = field;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FieldErrorMessageError [field=" + field + ", message=" + message + "]";
	}

}