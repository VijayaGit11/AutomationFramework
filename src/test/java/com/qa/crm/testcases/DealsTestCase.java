package com.qa.crm.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DealsTestCase extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealspage;
		
	public DealsTestCase() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialisation();
	}
		
	@Given("^User moves to new deals page$")
	public void user_moves_to_new_deals_page() {
	    loginPage = new LoginPage();
		dealspage=new DealsPage();
		homePage = new HomePage();
	    loginPage.logintoFreeCRM(prop.getProperty("email"), prop.getProperty("pwd"));
		HomePage.clickOnDealsLink();
		dealspage.user_moves_to_new_deals_page();
	}
	
	
	@Then("^User enters deals details$")
	public void user_enters_deals_details(DataTable details) throws InterruptedException {
		dealspage.user_enters_deals_details(details);
	    
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
