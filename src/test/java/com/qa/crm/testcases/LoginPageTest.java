package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialisation();
		loginPage= new LoginPage();
	}
	
	@Given("^User validates loginPage Title$")
	public void user_validates_loginPage_Title(){
	  Assert.assertEquals(loginPage.validateLoginPageTitle(), "Cogmento CRM");
	}

	@Then("^User validate Forgot password link$")
	public void user_validate_Forgot_password_link(){
	   Assert.assertTrue(loginPage.validateForgotPasswordLink());
	}

	@Then("^User login to Free CRM Application$")
	public void user_login_to_Free_CRM_Application(){
		homePage = loginPage.logintoFreeCRM(prop.getProperty("email"), prop.getProperty("pwd"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
