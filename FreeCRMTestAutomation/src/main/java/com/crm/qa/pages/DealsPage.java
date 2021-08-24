package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement dealsHeading;
	
	@FindBy(id="title")
	WebElement dealsTitle;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(id="amount")
	WebElement amt;
	
	@FindBy(name="type")
	WebElement type;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveBtn;
	
	
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//ACTIONS:
	public boolean validateDealsHeading() {
		return dealsHeading.isDisplayed();
	}
	
	public void createNewDeal(String typeSent, String dealTitle, String dealamt, String company) {
		dealsTitle.sendKeys(dealTitle);
		this.company.sendKeys(company);
		amt.sendKeys(dealamt);
		Select select = new Select(type);
		select.selectByVisibleText(typeSent);
		saveBtn.click();
		
	}

	
	
	
	
	
	

}
