package br.com.citel.monitor.tests.controller;

import static org.springframework.test.web.server.setup.MockMvcBuilders.annotationConfigSetup;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.server.MockMvc;

public class BasicControllerTest {

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
}