package org.activiti.cdi.bean;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Alternative
@Named("example")
public class AlternativeBean extends ExampleBean {

	@Override
	public void test() {
		super.test();
	}
}
