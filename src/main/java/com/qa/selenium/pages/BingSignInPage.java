package com.qa.selenium.pages;

import org.openqa.selenium.WebDriver;

import com.qa.selenium.utils.ElementUtil;

public class BingSignInPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;

	public BingSignInPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
}
