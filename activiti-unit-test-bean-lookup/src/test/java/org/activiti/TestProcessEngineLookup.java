package org.activiti;

import org.activiti.cdi.CdiStandaloneProcessEngineConfiguration;
import org.activiti.cdi.spi.ProcessEngineLookup;
import org.activiti.engine.ProcessEngine;

public class TestProcessEngineLookup implements ProcessEngineLookup {

	static ProcessEngine engine;

	public int getPrecedence() {
		return 100;
	}

	public ProcessEngine getProcessEngine() {
		engine = new CdiStandaloneProcessEngineConfiguration()
				.setDatabaseSchemaUpdate("true").setJdbcDriver("org.h2.Driver")
				.setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000")
				.setJdbcUsername("sa").setJdbcPassword("").buildProcessEngine();
		return engine;
	}

	public void ungetProcessEngine() {
		engine.close();
	}

}
