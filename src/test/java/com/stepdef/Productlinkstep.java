package com.stepdef;

import java.awt.AWTException;

import com.pojo.productpojo;
import com.utils.BaseClass;

import cucumber.api.java.en.And;

public class Productlinkstep extends BaseClass {
	productpojo p;

	@And("user selects the first link in new tab")
	public void user_selects_the_first_link_in_new_tab() throws AWTException {
		p = new productpojo();

		click(p.getBtnlink());

	}

}
