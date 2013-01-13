package br.com.citel.monitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.citel.monitor.model.Monitor;

@Repository
public interface MonitorRepository extends CrudRepository<Monitor, Long> {

	@Query("select distinct m.nomeLider from Monitor m")
	List<String> findLideres();
	
	@Query("select m from Monitor m where m.nomeLider = ?1")
	List<Monitor> findByLider(String nomeLider);

}
