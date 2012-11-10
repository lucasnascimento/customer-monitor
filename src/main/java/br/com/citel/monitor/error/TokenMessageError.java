package br.com.citel.monitor.error;

import java.util.HashMap;
import java.util.Map;

import br.com.citel.monitor.exception.TokenException;
import br.com.citel.monitor.web.AbstractMessageError;

public class TokenMessageError extends AbstractMessageError<TokenException>{


	private static final long serialVersionUID = 3573343979051936319L;
	
	private static final String TOKEN_NAO_ENCONTRADO = "token.nao.encontrado";
	private static final String TOKEN_NAO_INFORMADO= "token.nao.informado";
	private static final String TOKEN_NAO_PERTENCE_ENTIDADE= "token.nao.pertence.entidade";
	
	private Integer codigo;
	
	@SuppressWarnings("serial")
	final Map<Integer, String> mapCodes = new HashMap<Integer, String>(){
		{
			put(TokenException.TOKEN_NAO_ENCONTRADO, TOKEN_NAO_ENCONTRADO);
			put(TokenException.TOKEN_NAO_INFORMADO, TOKEN_NAO_INFORMADO);
			put(TokenException.TOKEN_NAO_PERTENCE_ENTIDADE, TOKEN_NAO_PERTENCE_ENTIDADE);
		}
	};
	
	@Override
	public String getCode() {
		return mapCodes.get(codigo);
	}

	@Override
	public void convert(TokenException exception) {
		codigo = exception.getCodigo();
		
		setMessage(getMessageSource().getMessage(getCode(), exception.getMessage()));
	}

}
