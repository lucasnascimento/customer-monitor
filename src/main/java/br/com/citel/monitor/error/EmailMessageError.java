package br.com.citel.monitor.error;

import java.util.HashMap;
import java.util.Map;

import br.com.citel.monitor.exception.EmailException;
import br.com.citel.monitor.web.AbstractMessageError;

public class EmailMessageError extends AbstractMessageError<EmailException> {

	private static final long serialVersionUID = 1L;
	
	private static final String ERRO_ENVIAR_EMAIL = "erro.enviar.email";
	private static final String EMAIL_CONTATO_NAO_CADASTRADO = "email.contato.nao.cadastrado";
	
	private Integer codigo;
	
	@SuppressWarnings("serial")
	final Map<Integer, String> mapCodes = new HashMap<Integer, String>() {
		{
			put(EmailException.ERRO_ENVIAR_EMAIL, ERRO_ENVIAR_EMAIL);
			put(EmailException.EMAIL_CONTATO_NAO_CADASTRADO, EMAIL_CONTATO_NAO_CADASTRADO);
		}
	};

	@Override
	public String getCode() {
		return mapCodes.get(codigo);
	}

	@Override
	public void convert(EmailException exception) {
		codigo = exception.getCodigo();
		
		setMessage(getMessageSource().getMessage(getCode(), exception.getMessage()));
	}
}
