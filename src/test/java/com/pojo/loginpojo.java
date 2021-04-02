package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stepdef.Hooks;
import com.utils.BaseClass;

public class loginpojo extends BaseClass {

	public loginpojo() {
		PageFactory.initElements(Hooks.driver, this);
	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement btnClose;

	@FindBy(className = "_1_3w1N")
	private WebElement btnloginpage;
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	private WebElement txtUserName;
	@FindBy(xpath = "//input[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement txtPassword;
	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement btnLogin;

	public WebElement getBtnClose() {
		return btnClose;
	}

	public WebElement getBtnloginpage() {
		return btnloginpage;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

}
