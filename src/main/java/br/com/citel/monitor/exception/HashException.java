package br.com.citel.monitor.exception;

public class HashException extends RuntimeException{

	private static final long serialVersionUID = -6027991679035655958L;

	private final int codigo;
	
	public static final int HASH_INVALIDO = 0;
	public static final int HASH_NAO_ENCONTRADO = 1;
	
	public HashException(final int codigo){
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
}
