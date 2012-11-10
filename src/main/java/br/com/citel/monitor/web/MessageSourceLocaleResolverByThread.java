package br.com.citel.monitor.web;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Esse MessageSource usa como o Locale associado a thread para resolver as
 * mensagens
 * 
 * @author marcelofelix
 * 
 */
public class MessageSourceLocaleResolverByThread extends ResourceBundleMessageSource implements
		MessageSourceLocaleResolver {

	@Override
	public String getMessage(final String code, final Object... objects) {
		return super.getMessage(code, objects, null, LocaleContextHolder.getLocale());
	}

}