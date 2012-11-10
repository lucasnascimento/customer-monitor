package br.com.citel.monitor.error;

import java.util.HashMap;
import java.util.Map;

import br.com.citel.monitor.exception.HashException;
import br.com.citel.monitor.web.AbstractMessageError;

public class HashMessageError extends AbstractMessageError<HashException>{


	private static final long serialVersionUID = -4998147783865202905L;

	private static final String HASH_INVALIDO = "hash.invalido";
	private static final String HASH_NAO_ENCONTRADO = "hash.nao.encontrado";
	
	@SuppressWarnings("serial")
	final Map<Integer, String> mapCodes = new HashMap<Integer, String>(){
		{
			put(HashException.HASH_INVALIDO, HASH_INVALIDO);
			put(HashException.HASH_NAO_ENCONTRADO, HASH_NAO_ENCONTRADO);
		}
	};
	
	private Integer codigo;
	
	@Override
	public String getCode() {
		return mapCodes.get(codigo);
	}

	@Override
	public void convert(HashException exception) {
		codigo = exception.getCodigo();
		
		setMessage(getMessageSource().getMessage(getCode(), exception.getMessage()));
	}

}
