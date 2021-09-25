package com.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.selenium.utils.ElementUtil;

import io.qameta.allure.Step;

public class GoogleSignInPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	By email = By.cssSelector("input#identifierId");
	
	public GoogleSignInPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	@Step("enter email in text box....")
	public void enterEmail(String emailId) {
		elementUtil.doSendKeys(email, emailId);
	}

}
