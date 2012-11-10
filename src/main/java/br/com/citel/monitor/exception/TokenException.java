package br.com.citel.monitor.exception;

public class TokenException extends RuntimeException {

	private static final long serialVersionUID = 3807804355609673658L;

	private final int codigo;
	
	public static final int TOKEN_NAO_ENCONTRADO = 0;
	public static final int TOKEN_NAO_INFORMADO = 1;
	public static final int TOKEN_NAO_PERTENCE_ENTIDADE = 2;
	
	public TokenException(final int codigo){
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	
	
}
