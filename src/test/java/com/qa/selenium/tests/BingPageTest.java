package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.selenium.listeners.TestAllureListener;
import com.qa.selenium.utils.Constants;
import com.qa.selenium.utils.Errors;
import com.qa.selenium.utils.ExcelUtil;

@Listeners(TestAllureListener.class)
public class BingPageTest extends BaseTest {
	
	@Test(priority = 1, dataProvider = "getGoogleTestData")
	public void searchItemOnBingAndVerify(String valueToSearch, String searchedItem) {
		String title = bingPage.validateBingPageTitle();
		Assert.assertEquals(title, Constants.BING_PAGE_TITLE, Errors.TITLE_ERROR_MESSG);
		googlePage.searchOnGoogle(valueToSearch);
		String firstSearchedItem = bingPage.getFirstSearchedItem(searchedItem);
		Assert.assertEquals(firstSearchedItem, searchedItem, Errors.RETURNED_ITEM_ERROR_MESSG);
	}
	
	@DataProvider
	public Object[][] getGoogleTestData() {
		Object[][] data = ExcelUtil.getTestData(Constants.BING_SEARCH_SHEET_NAME);
		return data;
	}

}
