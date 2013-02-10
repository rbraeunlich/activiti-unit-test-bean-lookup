package org.activiti.cdi.bean;

import javax.inject.Named;

@Named("example")
public class ExampleBean {

	public void test(){
		System.out.println("Test");
	}
}
