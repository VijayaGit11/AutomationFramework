package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageTest extends TestBase {
	
	static LoginPage loginPage;
	static HomePage homePage;
	static  ContactsPage contactsPage;
	static DealsPage dealspage;
	static TasksPage taskspage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		initialisation();	
	}
	
	@Test
	@Given("^User is on homepage$")
	public void User_is_on_homepage() {
		loginPage = new LoginPage();
		homePage = loginPage.logintoFreeCRM(prop.getProperty("email"), prop.getProperty("pwd"));
		Assert.assertEquals(homePage.verifyHomePageTitle(), "Cogmento CRM", "HomePage title is not matched");
	}
	
	@Test
	@Then("^User moves to contacts page$")
	public static void user_moves_to_contacts_page(){
		contactsPage = new ContactsPage();
	    contactsPage = HomePage.ClickonContactsPage();
	    
	}

	@Test
	@Then("^User moves to deals page$")
	public void user_moves_to_deals_page(){
		dealspage = new DealsPage();
	    HomePage.clickOnDealsLink();
	    
	}

	@Test
	@Then("^User moves to tasks page$")
	public void user_moves_to_tasks_page(){
		taskspage = new TasksPage();
	    HomePage.clickOnTaskLink();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
