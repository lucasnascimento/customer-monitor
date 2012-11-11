package br.com.citel.monitor.tests.repository;

import static org.springframework.test.web.server.setup.MockMvcBuilders.annotationConfigSetup;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;

import br.com.citel.monitor.model.Atributo;
import br.com.citel.monitor.repository.AtributoRepository;
import br.com.citel.monitor.tests.controller.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"customer-monitor-beans.xml"})
public class AtributoRepositoryIntegrationTests {
	@Autowired
	protected ApplicationContext context;

	protected MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = annotationConfigSetup(getWebConfig()).setParentContext(context).configureWebAppRootDir("src/main/webapp", false).build();
	}

	protected Class<?> getWebConfig() {
		return WebConfig.class;
	}
	  @Autowired
	  AtributoRepository repository;

	  @Test
	  public void savesAndFindOne() {

	    Atributo atributo = new Atributo();
	    atributo.setAtributo("HD");
	    atributo.setCondicao(" between 80  and 100");
	    atributo.setCriticidade("CRITICO");

	    Atributo result = repository.save(atributo);
	    Assert.assertTrue( result != null && result.getId() != null );

	    List<Atributo> resultList = repository.findByAttributeName("HD");
	    Assert.assertTrue( resultList.contains(atributo) );
	  }
}
