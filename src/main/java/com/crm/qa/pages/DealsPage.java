package com.crm.qa.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import cucumber.api.DataTable;

public class DealsPage extends TestBase {
	
	
	@FindBy(xpath="//a[@href='/deals']")
	static WebElement dealsLink;
	
	@FindBy(xpath ="//a[@href='/deals/new']")
	WebElement dealsNewButton;
	
	@FindBy(xpath = "//input[@name='title']")
	WebElement title;
	
	@FindBy(xpath = "//div[@role='listbox' and @name='status']")
	WebElement statusDrpdown;
	
	@FindBy(xpath = "//div[@role='option']//span[contains(text(), 'Active')]")
	WebElement Active;
	
	@FindBy(xpath = "//div[@class='ui fluid selection dropdown']/i")
	WebElement AssignedTo;
	
	@FindBy(xpath = "//div[@class='react-datepicker-wrapper']//input")
	WebElement CloseDate;
	
	@FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--003 react-datepicker__day--outside-month']")
	WebElement SelectedCloseDate;
	
	@FindBy(xpath = "//div[@class='ui fluid container ']//textarea[@name='description']")
	WebElement Description;
	
	@FindBy(xpath="//div[@class='ui left labeled input']//input[@name= 'commission']")
	WebElement 	Commision;
	
	@FindBy(xpath = "//div[@name='status']")
	WebElement Status;
	
	@FindBy(xpath ="//label[@for='tags']//div[@role='combobox']")
	WebElement tags;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement dealsSaveButton;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void user_moves_to_new_deals_page() {
		dealsNewButton.click();
	}
	
	public void user_enters_deals_details(DataTable dealDetails) throws InterruptedException{
		for (Map<String, String> details : dealDetails.asMaps(String.class, String.class)) 	{
			title.sendKeys(details.get("Title"));
			Description.sendKeys(details.get("Description"));
//			statusDrpdown.click();
//			Active.click();
//			tags.sendKeys(details.get("tags"));
//			tags.sendKeys(Keys.ENTER);
			dealsSaveButton.click();
			Thread.sleep(2000);
			//if(TestUtil.isEnabled(dealsLink)) {
//				Actions act = new Actions(driver);
//				act.moveToElement(dealsLink).build().perform();
			dealsLink.click();
//				JavascriptExecutor js = (JavascriptExecutor)driver;
//				js.executeScript("arguments[0].click();", dealsLink);
//			}
//			else {
//				System.out.println("Failed to click on deals link");
//			}
//			System.out.println("Button clicked");
//			Thread.sleep(1000);
//			if(TestUtil.isEnabled(dealsNewButton)){
				dealsNewButton.click();
////				JavascriptExecutor js = (JavascriptExecutor)driver;
////				js.executeScript("arguments[0].click();", dealsNewButton);
//			}
//				else {
//				System.out.println("Failed to click on new deals link");
//			}
		}
		
	}

}
