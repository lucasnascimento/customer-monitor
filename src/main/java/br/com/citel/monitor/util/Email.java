package br.com.citel.monitor.util;

import java.util.Collection;
import java.util.HashSet;

public class Email {

	private final String remetente;
	private final String assunto;
	private final Collection< String > destinatarios = new HashSet< String >();
	private String texto;
	private String link;

	public Email( final String remetente, final String assunto ) {

		super();
		this.remetente = remetente;
		this.assunto = assunto;
	}

	public String getTexto() {

		return texto;
	}

	public void setTexto( String texto ) {

		this.texto = texto;
		replace( "[ASSUNTO]", assunto );
	}

	public String getRemetente() {

		return remetente;
	}

	public String getAssunto() {

		return assunto;
	}

	public Collection< String > getDestinatarios() {

		return destinatarios;
	}

	public void addDestinatario( final String destinatario ) {

		this.destinatarios.add( destinatario );
	}

	public void replace( final String chave, String valor ) {

		valor = ( valor != null ) ? valor : "";
		texto = texto.replace( chave, valor );
	}

	public void setHash( final String hash ) {

		replace( "[URL]", link + hash );
	}

	public String getLink() {

		return link;
	}

	public void setLink( String hash ) {

		this.link = hash;
	}

	public void setNomeDestinatario( final String nome ) {

		replace( "[NOME]", nome );
	}

	@Override
	public String toString() {

		return String.format( "[remetente=%s, assunto=%s]", remetente, assunto );
	}
}
