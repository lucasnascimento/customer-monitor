package br.com.citel.monitor.web;

import org.springframework.context.MessageSource;

/**
 * 
 * Tenta resolver mensagems
 * 
 * @author marcelofelix
 * 
 */
public interface MessageSourceLocaleResolver extends MessageSource {

	/**
	 * @param code
	 * @param objects
	 * @return Mensagem resolvida
	 */
	String getMessage(String code, Object... objects);

}