package com.SwagLabs.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentListener implements ITestListener {

	private ExtentReports extent;
	private ExtentTest test;
	private WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
		
		// Take a screenshot
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String filePath = "target/screenshots/" + result.getMethod().getMethodName() + ".png";
				File destFile = new File(filePath);
				destFile.getParentFile().mkdirs();
				try {
					FileUtils.copyFile(srcFile, destFile);
					test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
				} catch (IOException e) {
					test.fail("Failed to attach screenshot: " + e.getMessage());
				}
			}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}
}