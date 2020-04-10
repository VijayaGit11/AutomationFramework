package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase {
	
	@FindBy(xpath="//a[@href='/tasks/new']//button[@class='ui linkedin button']")
	WebElement newTaskLink;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement tasksSaveButton;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement tasksTitle;
	
	@FindBy(xpath = "//div[@name='deal']/input")
	WebElement tasksDeal;
	
	
	public TasksPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String user_is_on_tasks_page() {
		return driver.getTitle(); 
	}
	
	public void User_clicks_New_Tasks_Page() {
		newTaskLink.click();
	}
	
	public void user_fill_new_tasks_details(String title, String deals) throws InterruptedException{
		System.out.println("new task");
		Thread.sleep(200);
		System.out.println("entered");
		tasksTitle.sendKeys(title);
		tasksDeal.sendKeys(deals);
		tasksSaveButton.click();
	}
	

}
