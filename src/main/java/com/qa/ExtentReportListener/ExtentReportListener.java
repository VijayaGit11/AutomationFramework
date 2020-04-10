package com.qa.ExtentReportListener;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.qa.base.TestBase;
import com.qa.crm.util.TestUtil;

public class ExtentReportListener extends TestBase {
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public void setUp() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Report/report.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Free CRM Test", "This is free CRM Test");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			String temp = TestUtil.takeScreensotAtEndOfTest(driver);
			logger.fail(result.getThrowable().getMessage()+ MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			extent.flush();
		}
	}

}
