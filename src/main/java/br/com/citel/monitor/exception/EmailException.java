package br.com.citel.monitor.exception;

public class EmailException extends RuntimeException{


	private static final long serialVersionUID = 5597654541261241116L;
	
	public static final int EMAIL_CONTATO_NAO_CADASTRADO = 0;
	public static final int ERRO_ENVIAR_EMAIL = 1;
	
	private final int codigo;
	
	public EmailException(final int codigo){
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
}
