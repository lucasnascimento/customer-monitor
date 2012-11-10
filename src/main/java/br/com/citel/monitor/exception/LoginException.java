package br.com.citel.monitor.exception;

public class LoginException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private final int codigo;
	
	public static final int LOGIN_JA_EXISTE_BUILDER = 0;
	public static final int LOGIN_JA_EXISTE = 1;
	public static final int LOGIN_NAO_ENCONTRADO = 2;
	public static final int LOGIN_NAO_INFORMADO = 3;
	
	public LoginException(final int codigo){
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
}
