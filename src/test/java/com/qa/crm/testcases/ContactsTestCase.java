package com.qa.crm.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ContactsTestCase extends TestBase{
	LoginPage loginPage;
	ContactsPage contactPage;
	HomePage homePage;
	
	public ContactsTestCase() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialisation();
	}
	
	@Given("^User is on contacts page$")
	public void User_is_on_contacts_page() throws Throwable {
		loginPage = new LoginPage();
	    //contactPage = new ContactsPage();
	    
	    loginPage.logintoFreeCRM(prop.getProperty("email"), prop.getProperty("pwd"));
	    
	    Thread.sleep(2000);
	    contactPage = HomePage.ClickonContactsPage();
	    contactPage.User_is_on_contacts_page();
	    
	}

	@Then("^User clicks on new contacts page$")
	public void User_clicks_on_new_contacts_page() throws Throwable {
	   contactPage.User_clicks_on_new_contacts_page();
	}

	@Then("^User fills contact details$")
	public void User_fills_contact_details() throws Throwable {
	    contactPage.User_fills_contact_details();	    
	}

	@Then("^User saves the details$")
	public void User_saves_the_details() throws Throwable {
	    contactPage.User_saves_the_details();	    
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}

}
