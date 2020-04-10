package com.qa.crm.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	
	//switch to frame
	public void switchtoFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	//TakeScreenshot
	public static String takeScreensotAtEndOfTest(WebDriver driver) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile , new File(path));
		return path;
	}
	
	//explicit wait
	public static boolean isDisplayed(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		return wait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
	}
	
	//element enabled with explicit wait
	public static boolean isEnabled(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		return wait.until(ExpectedConditions.visibilityOf(webElement)).isEnabled();
	}
	
	
	//element selected with explicit wait
		public static boolean isSelected(WebElement webElement) {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			return wait.until(ExpectedConditions.visibilityOf(webElement)).isSelected();
		}

}
