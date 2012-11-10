package br.com.citel.monitor.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BasicRepository {

	@PersistenceContext
	public EntityManager entityManager;

	public <T> T find(final Class<T> type, final Serializable id) {
		return entityManager.find(type, id);
	}

	public <T> T load(final Class<T> type, final Serializable id) {
		return entityManager.find(type, id);
	}

	public void persist(final Object entity) {
		entityManager.persist(entity);
	}
	
	public void merge(final Object entity){
		entityManager.merge(entity);
	}

	public void remove(final Object entity) {
		this.entityManager.remove(entity);
	}

}
