package br.com.citel.monitor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionUtils {

	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public static Collection< Collection< ? > > split( final Collection< ? > collection, final int max ) {

		try {
			final Collection< Collection< ? > > listas = new ArrayList< Collection< ? > >();
			if ( !collection.isEmpty() ) {
				Collection lista = new ArrayList();
				listas.add( lista );
				for ( Object object : collection ) {
					lista.add( object );
					if ( lista.size() > max ) {
						lista = new ArrayList();
						listas.add( lista );
					}
				}
			}
			return listas;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Collection< Long > toIds( final Collection< ? extends Identifiable > objs ) {

		final Collection< Long > ids = new HashSet< Long >();
		for ( Identifiable i : objs ) {
			ids.add( i.getId() );
		}
		return ids;
	}
}
