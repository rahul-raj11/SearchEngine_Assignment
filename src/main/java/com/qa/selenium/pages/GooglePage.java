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

public class GooglePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// private By locators:
	private By searchTextBox = By.name("q");
	// private By googleSearchBtn = By.xpath("(//input[@value='Google Search' and
	// @type='submit'])[2]");
	private By signInBtn = By.linkText("Sign in");
	private String firstReturnedItem = "//div[@id='search']//a//h3[contains(text(),'%s')]";

	// constructor:
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// page actions/ page methods/ functionality/behavior of the page/ no assertion

	@Step("getting google page title....")
	public String validateGooglePageTitle() {
		return elementUtil.waitForTitleIs(Constants.GOOGLE_PAGE_TITLE, 5);
	}

	@Step("search for given value {0}")
	public void searchOnGoogle(String value) {
		elementUtil.doSendKeys(searchTextBox, value);
		elementUtil.doEnter(searchTextBox);
	}

	@Step("convert string to webelement and return the text")
	public String getFirstSearchedItem(String firstItem) {
		return elementUtil.convertStringToWebElement(firstReturnedItem, firstItem).getText();
	}

	@Step("navigating to sign-in page....")
	public GoogleSignInPage clickOnSignIn() {
		elementUtil.doClick(signInBtn);

		return new GoogleSignInPage(driver);
	}

}
