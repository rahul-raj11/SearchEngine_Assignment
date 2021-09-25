package com.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.utils.Constants;
import com.qa.selenium.utils.ElementUtil;

import io.qameta.allure.Step;

public class BingPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By searchTxtBx = By.name("q");

	private By signInBtn = By.linkText("Sign in");
	
	private String firstReturnedItem = "//main[contains(@aria-label,'Search')]//h2//a[contains(text(),'%s')]";

	// constructor:
	public BingPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	@Step("getting google page title....")
	public String validateBingPageTitle() {
		return elementUtil.waitForTitleIs(Constants.BING_PAGE_TITLE, 5);
	}

	@Step("search for given value {0}")
	public void searchOnBing(String value) {
		elementUtil.doSendKeys(searchTxtBx, value);
		elementUtil.doEnter(searchTxtBx);
	}
	
	@Step("convert string to webelement and return the text")
	public String getFirstSearchedItem(String firstItem) {
		return elementUtil.convertStringToWebElement(firstReturnedItem, firstItem).getText();
	}

	@Step("navigating to sign-in page....")
	public BingSignInPage clickOnSignIn() {
		elementUtil.doClick(signInBtn);

		return new BingSignInPage(driver);
	}

}
