package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Vijaya Zambre')]")
	WebElement usernameLable;
	
	@FindBy(xpath="//a[@href='/deals']")
	static WebElement dealsLink;
	
	@FindBy(xpath="//a[@href='/tasks']")
	static WebElement tasksLink;
	
	@FindBy(xpath = "//a[@href='/contacts']")
	static
	WebElement contactsLink;
		
	//Initializing the Page Objects"
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyusernameLable() {
		return usernameLable.isDisplayed();
	}
	
	public static DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public static TasksPage clickOnTaskLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public static ContactsPage ClickonContactsPage() {
		contactsLink.click();
		return new ContactsPage();
	}

}
