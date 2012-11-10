package br.com.citel.monitor.error;

import java.util.HashMap;
import java.util.Map;

import br.com.citel.monitor.exception.SenhaException;
import br.com.citel.monitor.web.AbstractMessageError;

public class SenhaMessageError extends AbstractMessageError<SenhaException>{

	private static final long serialVersionUID = 8789179769493201843L;

	private static final String SENHA_NAO_INFORMADA = "senha.nao.informada";
	private static final String NOVA_SENHA_NAO_INFORMADA = "nova.senha.nao.informada";
	
	private Integer codigo;
	
	@SuppressWarnings("serial")
	final Map<Integer, String> mapCodes = new HashMap<Integer, String>(){
		{
			put(SenhaException.SENHA_NAO_INFORMADA, SENHA_NAO_INFORMADA);
			put(SenhaException.NOVA_SENHA_NAO_INFORMADA, NOVA_SENHA_NAO_INFORMADA);
		}
	};
	
	@Override
	public String getCode() {
		return mapCodes.get(codigo);
	}

	@Override
	public void convert(SenhaException exception) {
		this.codigo = exception.getCodigo();
		
		setMessage(getMessageSource().getMessage(getCode(), exception.getMessage()));
	}

}
