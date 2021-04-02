package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class productpojo extends BaseClass {
	public productpojo() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[text()='POCO M3 (Power Black, 128 GB)']")
	private WebElement btnlink;

	public WebElement getBtnlink() {
		return btnlink;
	}

}
