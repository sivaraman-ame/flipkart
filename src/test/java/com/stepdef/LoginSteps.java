package com.stepdef;

import java.util.Map;

import com.pojo.loginpojo;
import com.utils.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends BaseClass {
	loginpojo l;

	@Given("^user launches the browser$")
	public void user_launches_the_browser() {
		launchPage("https://www.flipkart.com/");
		waitImplicit(15);
	}

	@When("user close the login popup and clicks login")
	public void user_close_the_login_popup_and_clicks_login() {
		l = new loginpojo();
		click(l.getBtnClose());
		click(l.getBtnloginpage());
	}

	@When("user enters username and password and clicks login")
	public void user_enters_username_and_password_and_clicks_login(DataTable table) throws Throwable {

		l = new loginpojo();
		Map<String, String> asMap = table.asMap(String.class, String.class);

		sendKeys(l.getTxtUserName(), asMap.get("userName"));
		sendKeys(l.getTxtPassword(), asMap.get("Password"));
		click(l.getBtnLogin());

	}
}