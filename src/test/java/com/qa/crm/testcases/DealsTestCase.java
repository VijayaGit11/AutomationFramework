package com.qa.crm.testcases;

import java.io.IOException;

import org.testng.ITestResult;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DealsTestCase extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealspage;
		
	public DealsTestCase() {
		super();
	}
	
//	@BeforeClass
//	public void setUp1(String TestCaseName) {
//		Reporter.log("Started");
//		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/" + System.currentTimeMillis()+".html"));
//		extent = new ExtentReports();
//		extent.attachReporter(reporter);
//		//extent.createTest("Deal Test");
//		logger = extent.createTest(TestCaseName);
//	}
	
	
//	@BeforeSuite
//	public void setUp1() {
//		setUpSuite("Deals Validation Test");
//	}
	
	@Before
	public void setUp() {
		setUpSuite("DealsTestCase");
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
		driver.quit();
	    
	}
	
	@After
	public void User_Closes_The_Report() throws IOException {
		DealsPage.tearDownReport();
	}
}
