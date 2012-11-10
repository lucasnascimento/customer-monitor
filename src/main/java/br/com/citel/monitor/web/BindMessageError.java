package br.com.citel.monitor.web;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author marcelofelix
 * 
 */
public class BindMessageError extends AbstractMessageError<BindException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2052812049209746314L;

	private Collection<FieldErrorMessageError> fields = new ArrayList<FieldErrorMessageError>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.org.sesc.commons.rest.MessageError#getCode()
	 */
	@Override
	public String getCode() {
		return "bind.request.error";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.org.sesc.commons.rest.AbstractMessageError#convert(java.lang.Exception
	 * )
	 */
	@Override
	public void convert(final BindException exception) {
		final BindingResult bind = exception.getBindingResult();
		for (final FieldError o : bind.getFieldErrors()) {
			fields.add(new FieldErrorMessageError(o.getField(), getMessageSource().getMessage(o.getCode(),
					o.getArguments())));
		}
		setMessage(getMessageSource().getMessage(getCode()));

	}

	/**
	 * @return Field Errors
	 */
	public Collection<FieldErrorMessageError> getFields() {
		return fields;
	}

	/**
	 * @param fields
	 *            the fields to set
	 */
	public void setFields(final Collection<FieldErrorMessageError> fields) {
		this.fields = fields;
	}

}