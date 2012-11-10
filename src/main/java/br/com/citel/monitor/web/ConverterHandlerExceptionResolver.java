package br.com.citel.monitor.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * 
 * @author marcelofelix
 * 
 */
public class ConverterHandlerExceptionResolver implements HandlerExceptionResolver {

	private final Logger log = LoggerFactory.getLogger(ConverterHandlerExceptionResolver.class);
	private final Map<Class<? extends Exception>, Class<? extends MessageError>> messages;
	private final Map<Class<? extends Exception>, Integer> status;
	private final Class<? extends MessageError> defaultMessage;

	@Autowired
	private MessageSourceLocaleResolver messageSource;

	/**
	 * 
	 */
	public ConverterHandlerExceptionResolver() {
		messages = new HashMap<Class<? extends Exception>, Class<? extends MessageError>>();
		status = new HashMap<Class<? extends Exception>, Integer>();
		defaultMessage = DefaultMessageError.class;

		messages.put(MissingServletRequestParameterException.class, MissingRequestParameterError.class);
		messages.put(NoSuchRequestHandlingMethodException.class, DefaultMessageError.class);
		messages.put(HttpRequestMethodNotSupportedException.class, DefaultMessageError.class);
		messages.put(HttpMediaTypeNotSupportedException.class, DefaultMessageError.class);
		messages.put(HttpMediaTypeNotAcceptableException.class, DefaultMessageError.class);
		messages.put(TypeMismatchException.class, DefaultMessageError.class);
		messages.put(HttpMessageNotReadableException.class, DefaultMessageError.class);
		messages.put(BindException.class, BindMessageError.class);

		status.put(MissingServletRequestParameterException.class, HttpStatus.BAD_REQUEST.value());
		status.put(NoSuchRequestHandlingMethodException.class, HttpStatus.NOT_FOUND.value());
		status.put(HttpRequestMethodNotSupportedException.class, HttpStatus.METHOD_NOT_ALLOWED.value());
		status.put(HttpMediaTypeNotSupportedException.class, HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
		status.put(HttpMediaTypeNotAcceptableException.class, HttpStatus.NOT_ACCEPTABLE.value());
		status.put(TypeMismatchException.class, HttpStatus.BAD_REQUEST.value());
		status.put(HttpMessageNotReadableException.class, HttpStatus.BAD_REQUEST.value());
		status.put(BindException.class, HttpStatus.BAD_REQUEST.value());
	}

	@Override
	public ModelAndView resolveException(final HttpServletRequest request, final HttpServletResponse response,
			final Object object, final Exception exception) {
		MessageError error = convertException(exception);
		ModelAndView model = new ModelAndView("mappingJacksonJsonView");
		response.setContentType("application/json");
		model.getModelMap().put("status", getStatusMapper(exception));
		model.getModelMap().put("erro", error);
		response.setStatus(getStatusMapper(exception));
		return model;
	}

	/**
	 * Configuração adicional para tratamento de exceptions.
	 * 
	 * @param entries
	 */
	public void setMessageErrorEntry(final List<MessageErrorEntry> entries) {
		for (MessageErrorEntry m : entries) {
			messages.put(m.getException(), m.getMessageError());
			status.put(m.getException(), m.getHttpStatus());
		}
	}

	/**
	 * @param ex
	 * @return MessageError
	 */
	private MessageError convertException(final Exception ex) {
		MessageError message = getMessageErrorMap(ex);
		try {
			message.setMessageSource(messageSource);
			message.setException(ex);
			log.info("Erro: ", ex);
		} catch (Exception e) {
			log.error("Não foi possivel converter exception " + ex.getClass() + " para MessageError "
					+ message.getClass());
			message = new DefaultMessageError();
			message.setException(e);
		}
		return message;
	}

	/**
	 * @param ex
	 * @return MessageError
	 */
	private MessageError getMessageErrorMap(final Exception ex) {

		try {
			if (messages.containsKey(ex.getClass())) {
				log.debug("Exception", ex);
				return messages.get(ex.getClass()).newInstance();
			} else {
				log.error("Default message error", ex);
				return defaultMessage.newInstance();
			}
		} catch (Exception e) {
			log.error("Messageerror sem construtor default");
			return new DefaultMessageError();
		}
	}

	/**
	 * @param ex
	 * @return Http status
	 */
	private int getStatusMapper(final Exception ex) {

		if (status.containsKey(ex.getClass())) {
			return status.get(ex.getClass());
		} else {
			return HttpStatus.INTERNAL_SERVER_ERROR.value();
		}
	}

}