package br.com.citel.monitor.exception;

public class SenhaException extends RuntimeException{
	
	private static final long serialVersionUID = -7930640908156733597L;
	
	public static final int SENHA_NAO_INFORMADA = 0;
	public static final int NOVA_SENHA_NAO_INFORMADA = 1;
	
	private final int codigo;
	
	public SenhaException(final int codigo){
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	

}
