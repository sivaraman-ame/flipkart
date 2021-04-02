package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class Addtocartpojo extends BaseClass {
	public Addtocartpojo() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='POCO M3 (Power Black, 128 GB)']")
	private WebElement txtProductname;
	@FindBy(xpath = "//div[text()='₹11,999'][@class='_30jeq3 _16Jk6d']")
	private WebElement txtPrice;

	public WebElement getTxtProductname() {
		return txtProductname;
	}

	public WebElement getTxtPrice() {
		return txtPrice;
	}

}
