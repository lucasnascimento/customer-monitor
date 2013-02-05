package br.com.citel.monitor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.citel.monitor.dto.LiderDTO;
import br.com.citel.monitor.model.Monitor;

@Repository
public interface MonitorRepository extends CrudRepository<Monitor, Long> {

	@Query("select distinct new br.com.citel.monitor.dto.LiderDTO( m.codigoLider as codigoLider, m.nomeLider as nomeLider) from Monitor m")
	List<LiderDTO> findLideres();
	
	@Query("select distinct new br.com.citel.monitor.dto.LiderDTO( m.codigoLider as codigoLider, m.nomeLider as nomeLider) from Monitor m where m.codigoLider = ?1")
	LiderDTO findLider(Long codigoLider);	
	
	@Query("select m from Monitor m where m.codigoLider = ?1 or 0 = ?1 order by ordem1, ordem2")
	List<Monitor> findByLider(Long codigoLider);
	
	@Query("select distinct m.setor from Monitor m")
	List<String> listSetores();
	
}
