package com.stepdef;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pojo.Searchpojo;
import com.utils.BaseClass;

import cucumber.api.java.en.And;

public class Searchsteps extends BaseClass {
	Searchpojo s;

	@And("user search mobiles in search tab and clicks search")
	public void user_search_mobiles_in_search_tab_and_clicks_search() throws IOException {
		s = new Searchpojo();
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(s.getBtnsearch()));
		sendKeys(s.getTxtsearch(), readExcelValue("Sheet1", 0, 0));
		click(s.getBtnsearch());
	}

}
