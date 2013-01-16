package br.com.citel.monitor.tests.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.citel.monitor.dto.LiderDTO;
import br.com.citel.monitor.model.Monitor;
import br.com.citel.monitor.repository.MonitorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:customer-monitor-beans.xml" })
public class MonitorRepositoryIntegrationTests {

	@Autowired
	MonitorRepository repository;

	@Test
	public void encontrarLiderEProblemas() {

		List<LiderDTO> lideres = repository.findLideres();
		Assert.assertNotNull(lideres);
		Assert.assertTrue("Lista de lideres voltou vazia.", !lideres.isEmpty());

		for (LiderDTO lider : lideres) {

			List<Monitor> problemas = repository.findByLider(lider.getCodigoLider());
			Assert.assertNotNull(problemas);
			Assert.assertTrue("Lista de problemas voltou vazia.",
					!problemas.isEmpty());
		}

	}
}
