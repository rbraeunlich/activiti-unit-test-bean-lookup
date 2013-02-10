package org.activiti;

import static org.junit.Assert.assertNotNull;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MyUnitTest extends AbstractCdiTestClass {


	@Test
	@Deployment(resources = { "org/activiti/test/my-process.bpmn20.xml" })
	public void test() {
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("my-process");
		assertNotNull(processInstance);
	}

}
