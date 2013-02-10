package org.activiti.cdi.impl.util;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.activiti.AbstractCdiTestClass;
import org.activiti.cdi.bean.AlternativeBean;
import org.junit.Test;

public class ProgrammaticBeanLookupTest extends AbstractCdiTestClass {

	@Inject
	private BeanManager manager;

	@Test
	public void testLookup() {
		//50/50 chance that this test will crash
			Object lookup = ProgrammaticBeanLookup.lookup("example", manager);
			assertThat(lookup, is(instanceOf(AlternativeBean.class)));
	}
}
