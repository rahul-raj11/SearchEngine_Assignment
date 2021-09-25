package com.qa.selenium.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.selenium.factory.DriverFactory;
import com.qa.selenium.pages.BingPage;
import com.qa.selenium.pages.GooglePage;

public class BaseTest {

	WebDriver driver;
	Properties prop;
	DriverFactory df;

	SoftAssert softAssert;

	GooglePage googlePage;
	BingPage bingPage;

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(String browserName) {

		softAssert = new SoftAssert();
		df = new DriverFactory();
		prop = df.initProperties();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
			//prop.setProperty("browserversion", browserVersion);

		}

		driver = df.initDriver(prop);
		googlePage = new GooglePage(driver);
		//bingPage = new BingPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
