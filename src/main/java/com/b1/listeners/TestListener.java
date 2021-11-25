package com.b1.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.b1.base.TestBase;

import io.qameta.allure.Attachment;


public class TestListener extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " Success...");
		System.out.println(result.getMethod().getMethodName() + " Success!");

		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");

		// attach screenshots to report
		saveSuccessScreenShot();
	}

	@Attachment
	public byte[] saveSuccessScreenShot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

		
	

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		System.out.println(result.getMethod().getMethodName() + " failed!");

		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");

		// attach screenshots to report
		saveFailureScreenShot();
	}

	@Attachment
	public byte[] saveFailureScreenShot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}