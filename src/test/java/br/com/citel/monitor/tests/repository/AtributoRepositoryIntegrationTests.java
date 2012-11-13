package br.com.citel.monitor.tests.repository;

import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.citel.monitor.model.Atributo;
import br.com.citel.monitor.model.Condicao;
import br.com.citel.monitor.repository.AtributoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:customer-monitor-beans.xml" })
public class AtributoRepositoryIntegrationTests {

	@Autowired
	AtributoRepository repository;

	@Test
	  public void savesAndFindOne() {

		Atributo atributo = new Atributo(null,"HD",new HashSet<Condicao>());
		atributo.getCondicoes().add( new Condicao(null, "beetween 80 and 100", "CRITICO", atributo));
		atributo.getCondicoes().add( new Condicao(null, "beetween 0 and 79", "NORMAL", atributo));  

	    Atributo result = repository.save(atributo);
	    Assert.assertTrue( result != null && result.getId() != null );

	    List<Atributo> resultList = repository.findByAttributeName("HD");
	    Assert.assertTrue( resultList.contains(atributo) );
	  }
}
