package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;

	public HomePageTest() {
		super(); //super is used to initialize the properties for the parent class constructor
	}

	@BeforeMethod
	public void setup() {
		initialization();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home Page title not matched");
	}

	@Test(priority = 2)
	public void validateUserNameLabelTest() {
		testUtil.switchToFrame();
		boolean flag = homePage.validateUserNameLabel();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void validateContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}




	@AfterMethod
	public void tearDown() {
		driver.quit();

	}


}
