package br.com.citel.monitor.web;

import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 * @author marcelofelix
 * 
 */
public class MissingRequestParameterError extends AbstractMessageError<MissingServletRequestParameterException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6213643812656991915L;

	public static final String MISSING_REQUEST_PARAMETER = "missing.request.parameter";
	private String parameter;

	@Override
	public void convert(final MissingServletRequestParameterException exception) {
		this.parameter = exception.getParameterName();
		setMessage(getMessageSource().getMessage(MISSING_REQUEST_PARAMETER, this.getParameter()));

	}

	/**
	 * @return the parameter
	 */
	public String getParameter() {
		return parameter;
	}

	@Override
	public String getCode() {
		return MISSING_REQUEST_PARAMETER;
	}

}