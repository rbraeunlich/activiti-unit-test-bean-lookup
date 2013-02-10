package org.activiti;

import javax.enterprise.inject.spi.BeanManager;

import org.activiti.cdi.impl.util.ProgrammaticBeanLookup;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.ProcessEngineImpl;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.test.ActivitiRule;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public abstract class AbstractCdiTestClass {

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule(
			getBeanInstance(ProcessEngine.class));

	protected BeanManager beanManager;

	protected ProcessEngine processEngine;
	protected FormService formService;
	protected HistoryService historyService;
	protected IdentityService identityService;
	protected ManagementService managementService;
	protected RepositoryService repositoryService;
	protected RuntimeService runtimeService;
	protected TaskService taskService;
	protected ProcessEngineConfigurationImpl processEngineConfiguration;

	protected <T> T getBeanInstance(Class<T> clazz) {
		return ProgrammaticBeanLookup.lookup(clazz);
	}

	@org.jboss.arquillian.container.test.api.Deployment
	public static Archive<?> erzeugeTestArchiv() {
		JavaArchive archiv = ShrinkWrap.create(JavaArchive.class)
				.addPackages(true, "org.activiti.cdi")
				.addAsManifestResource("META-INF/beans.xml", "beans.xml")
				.addClass(TestProcessEngineLookup.class);
		return archiv;
	}

	@Before
	public void initializeMembers() throws Exception {
		beanManager = ProgrammaticBeanLookup.lookup(BeanManager.class);
		processEngine = ProgrammaticBeanLookup.lookup(ProcessEngine.class);
		processEngineConfiguration = ((ProcessEngineImpl) TestProcessEngineLookup.engine)
				.getProcessEngineConfiguration();
		formService = processEngine.getFormService();
		historyService = processEngine.getHistoryService();
		identityService = processEngine.getIdentityService();
		managementService = processEngine.getManagementService();
		repositoryService = processEngine.getRepositoryService();
		runtimeService = processEngine.getRuntimeService();
		taskService = processEngine.getTaskService();
	}
}
