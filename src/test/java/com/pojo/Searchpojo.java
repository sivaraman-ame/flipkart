package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BaseClass;

public class Searchpojo extends BaseClass {

	public Searchpojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "_3704LK")
	private WebElement txtsearch;
	@FindBy(className = "L0Z3Pu")
	private WebElement btnsearch;

	public WebElement getTxtsearch() {
		return txtsearch;
	}

	public WebElement getBtnsearch() {
		return btnsearch;
	}

}
