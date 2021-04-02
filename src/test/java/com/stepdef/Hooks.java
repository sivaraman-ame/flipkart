package com.stepdef;

import com.utils.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void beforeClass(Scenario sc) {
		chromeDriver();
		String name = sc.getName();
		System.out.println(name);

	}

}
