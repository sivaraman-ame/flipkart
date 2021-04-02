package com.stepdef;

import java.io.IOException;

import com.pojo.Addtocartpojo;
import com.utils.BaseClass;

import cucumber.api.java.en.And;

public class Addtocartsteps extends BaseClass {
	Addtocartpojo a;

	@And("user prints the price and mobile name in excel")
	public void user_prints_the_price_and_mobile_name_in_excel() throws IOException, InterruptedException {
		a = new Addtocartpojo();
		windowHandle();

		createExcelValue(getText(a.getTxtPrice()), "Sheet1", 0, 1);
		createExcelValue(getText(a.getTxtProductname()), "Sheet1", 0, 4);
		close();
		System.out.println("driver closed");
	}

}
