package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='New Deal']")
	WebElement newDealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {		
		return driver.getTitle();
	}
	
	public boolean validateUserNameLabel() {
		return usernameLabel.isDisplayed();		
	}
	
	//-------------------CONTACTS PAGE---------------
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContact(){
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
	}
	
	//----------------DEALS PAGE------------------
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewDeals() {
		Actions actions = new Actions(driver);
		actions.moveToElement(dealsLink).build().perform();
		newDealsLink.click();
	}
	
	//------------------Tasks Page-----------------
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	
	
	
}
