package br.com.citel.monitor.error;

import java.util.HashMap;
import java.util.Map;

import br.com.citel.monitor.exception.LoginException;
import br.com.citel.monitor.web.AbstractMessageError;

public class LoginMessageError extends AbstractMessageError<LoginException>{

	private static final long serialVersionUID = 2433337291598593341L;

	private Integer codigo;
	
	private static final String LOGIN_JA_EXISTE_BUILDER = "login.ja.cadastrado.builder";
	private static final String LOGIN_JA_EXISTE = "login.ja.cadastrado";
	private static final String LOGIN_NAO_ENCONTRADO = "login.nao.encontrado";
	private static final String LOGIN_NAO_INFORMADO = "login.nao.informado";
	
	@SuppressWarnings("serial")
	final Map<Integer, String> mapCodes = new HashMap<Integer, String>(){
		{
			put(LoginException.LOGIN_JA_EXISTE_BUILDER, LOGIN_JA_EXISTE_BUILDER);
			put(LoginException.LOGIN_JA_EXISTE, LOGIN_JA_EXISTE);
			put(LoginException.LOGIN_NAO_ENCONTRADO, LOGIN_NAO_ENCONTRADO);
			put(LoginException.LOGIN_NAO_INFORMADO, LOGIN_NAO_INFORMADO);
		}
	};
	
	@Override
	public String getCode() {
		return mapCodes.get(codigo);
	}

	@Override
	public void convert(LoginException exception) {
		this.codigo = exception.getCodigo();
		
		setMessage(getMessageSource().getMessage(getCode(), exception.getMessage()));
	}

}
