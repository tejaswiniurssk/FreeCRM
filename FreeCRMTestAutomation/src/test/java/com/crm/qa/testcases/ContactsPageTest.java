package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	}

	@Test(priority = 1)
	public void validateContactsHeadingTest() {
		contactsPage = homePage.clickOnContactsLink();
		boolean flag = contactsPage.validateContactsHeading();
		Assert.assertTrue(flag, "Contacts label is missing on the Page");
	}

	@Test(priority = 2)
	public void selectContactsByNameTest() {
		contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("adc deg");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void validateNewContactTest(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContact();
		//contactsPage.createNewContact("Mrs.", "Tej", "Nag", "google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
