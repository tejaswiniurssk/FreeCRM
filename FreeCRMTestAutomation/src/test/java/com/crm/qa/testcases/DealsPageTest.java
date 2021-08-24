package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	TestUtil testUtil;
	String sheetName = "Deals";
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		dealsPage = new DealsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	}
	
	@Test(priority = 1)
	public void validateDealsHeadingTest() {
		 dealsPage = homePage.clickOnDealsLink();
		 Assert.assertTrue(dealsPage.validateDealsHeading());
	}
	
	@DataProvider
	public Object[][] dealsTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority = 2, dataProvider = "dealsTestData")
	public void createNewDealsTest(String type, String title, String amount, String company) {
		homePage.clickOnNewDeals();
		//dealsPage.createNewDeal("New", "NewDeal", "100", "Dell");
		dealsPage.createNewDeal(type, title, amount, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
