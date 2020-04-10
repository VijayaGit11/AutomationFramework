package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.qa.crm.util.TestUtil;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//a[@href='/contacts/new']")
	WebElement newContactsLink;
	
	@FindBy(xpath = "//*[@id='dashboard-toolbar']//div[text()='Contacts']")
	WebElement contactsLable;
	
	@FindBy(name = "first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(name = "last_name")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void User_is_on_contacts_page() {
		TestUtil.isDisplayed(contactsLable);
	}
	
	public void User_clicks_on_new_contacts_page() {
		if(TestUtil.isEnabled(newContactsLink)){
			newContactsLink.click();
		}
			else {
			System.out.println("Failed to click on new contacts link");
		}
	}
	
	public void User_fills_contact_details() {
		if(TestUtil.isDisplayed(firstName)) {
			firstName.sendKeys("Annie");
			lastName.sendKeys("devauxe");
		}
		else {
			System.out.println("Unable to fill contact Details");
		}
	}
	
	public void User_saves_the_details() {
		if(TestUtil.isEnabled(saveButton)) {
			saveButton.click();
		}
		else {
			System.out.println("Failed to save the details");
		}
	}

}
