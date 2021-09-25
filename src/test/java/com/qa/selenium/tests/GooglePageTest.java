package com.qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.selenium.listeners.TestAllureListener;
import com.qa.selenium.utils.Constants;
import com.qa.selenium.utils.Errors;
import com.qa.selenium.utils.ExcelUtil;



@Listeners(TestAllureListener.class)
public class GooglePageTest extends BaseTest {
	
	@Test(priority = 1, dataProvider = "getGoogleTestData")
	public void searchItemOnGoogleAndVerify(String valueToSearch, String searchedItem) {
		String title = googlePage.validateGooglePageTitle();
		Assert.assertEquals(title, Constants.GOOGLE_PAGE_TITLE, Errors.TITLE_ERROR_MESSG);
		googlePage.searchOnGoogle(valueToSearch);
		String firstSearchedItem = googlePage.getFirstSearchedItem(searchedItem);
		Assert.assertEquals(firstSearchedItem, searchedItem, Errors.RETURNED_ITEM_ERROR_MESSG);
	}
	
	@DataProvider
	public Object[][] getGoogleTestData() {
		Object[][] data = ExcelUtil.getTestData(Constants.GOOGLE_SEARCH_SHEET_NAME);
		return data;
	}
	
}
