package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory : OR
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(css = ".ui.fluid.large.blue.submit.button")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	WebElement forgotMyPasswordLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signUpButton;
	
	@FindBy(xpath="//span[contains(text(),'Vijaya Zambre')]")
	WebElement usernameLable;	
	
	//Initialising the page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	 public String validateLoginPageTitle() {
		return driver.getTitle();
	 }
	 
	 public boolean validateForgotPasswordLink() {
		return forgotMyPasswordLink.isDisplayed();
	 }
	 
	 public HomePage logintoFreeCRM(String mailId, String pwd) {
		 email.sendKeys(mailId);
		 password.sendKeys(pwd);
		 loginButton.click();
		 return new HomePage();
	 }

}
