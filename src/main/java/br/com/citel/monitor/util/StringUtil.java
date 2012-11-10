package br.com.citel.monitor.util;

import java.text.Normalizer;

public class StringUtil {

	public static String rightPad( String value, int size, char padChar ) {

		String result = "";
		for ( int i = value.length(); i < size; i++ ) {
			result = result.concat( String.valueOf( padChar ) );
		}
		return result.concat( value );
	}

	public static String removerAcentuacao( final String texto ) {

		String result = null;
		if ( texto != null ) {
			result = Normalizer.normalize( texto, Normalizer.Form.NFD );
			result = result.replaceAll( "[^\\p{ASCII}]", "" );
		}
		return result;
	}
}
