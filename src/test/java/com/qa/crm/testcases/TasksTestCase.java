package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.qa.crm.util.ReadExcelData;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TasksTestCase extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TasksPage taskPage;
	String sheetName = "Tasks";
	
	public TasksTestCase() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialisation();
		loginPage = new LoginPage();
		loginPage.logintoFreeCRM(prop.getProperty("email"), prop.getProperty("pwd"));	}
	
	@DataProvider
	public Object[][] getData() {
		Object data[][] = ReadExcelData.getTestData(sheetName);
		return data;
	}

	
//	@Test(priority = 0)
//	@Given("^User is on tasks page$")
//	public void user_is_on_tasks_page(){
//		loginPage= new LoginPage();
//		homePage= new HomePage();
//		taskPage= new TasksPage();
//		loginPage.logintoFreeCRM(prop.getProperty("email"), prop.getProperty("pwd"));
//		HomePage.clickOnTaskLink();
//		Assert.assertEquals(taskPage.user_is_on_tasks_page(), "Cogmento CRM");
//	    
//	}
//	
	@Test(dataProvider="getData")
	@When("^User clicks on new tasks link$")
	public void User_clicks_on_new_tasks_link(String title, String deals) throws InterruptedException {
		homePage = new HomePage();
		taskPage= new TasksPage();
		HomePage.clickOnTaskLink();
		Assert.assertEquals(taskPage.user_is_on_tasks_page(), "Cogmento CRM");
		homePage.verifyusernameLable();
		taskPage.User_clicks_New_Tasks_Page();
		taskPage.user_fill_new_tasks_details(title, deals);
	}

	
//	@Test(dataProvider="getData")
//	@Then("^user fill new tasks details$")
//	public void user_fill_new_tasks_details(String title, String deals) throws InterruptedException{
//		Thread.sleep(2000);
//		taskPage= new TasksPage();
//	   taskPage.user_fill_new_tasks_details(title, deals); 
	    
//	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
