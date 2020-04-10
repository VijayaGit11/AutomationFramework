package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.crm.util.TestUtil;
import com.qa.crm.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public TestBase(){
		try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("C:/Users/HP/Documents/Framework/Framework/src/main/java/com/qa/config/config.properties");
				prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	
	@BeforeSuite
	public void setUpSuite(String report_) {
		System.out.println("Started");
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/" + report_ + System.currentTimeMillis()+".html"));
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail(result.getThrowable().getMessage()+ MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.takeScreensotAtEndOfTest(driver)).build());
		}
		extent.flush();
	}
	
	public static void initialisation() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Documents/Framework/FreeCRMTestAutomation/Drivers/chromedriver.exe");
			driver = new ChromeDriver();				
			}
		
		else if(browserName.equals("gecko")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/HP/Documents/Framework/FreeCRMTestAutomation/Drivers/chromedriver.exe");
			driver = new FirefoxDriver();				
			}
		
		e_driver = new EventFiringWebDriver(driver);
		//create object of Eventlisternerhandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
