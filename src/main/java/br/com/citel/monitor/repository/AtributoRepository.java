package br.com.citel.monitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.citel.monitor.model.Atributo;

@Repository
public interface AtributoRepository extends CrudRepository<Atributo, Long> {

	@Query("select a from Atributo a where a.atributo = ?1")
	List<Atributo> findByAttributeName(String atributo);

}
