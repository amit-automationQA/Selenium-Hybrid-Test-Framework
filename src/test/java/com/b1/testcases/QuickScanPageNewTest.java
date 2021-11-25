package com.b1.testcases;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.pages.QuickScanPageNew;
import com.b1.util.TestUtility;


@Listeners(TestListener.class)
public class QuickScanPageNewTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	QuickScanPageNew quickScanPage;

	public QuickScanPageNewTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {
		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		quickScanPage = new QuickScanPageNew();
	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void QuickScanPageDetails() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().to("https://one-staging.brandify.com/quick-scan");
		Thread.sleep(3000);
		quickScanPage.VerifyQuickScanTitle();
	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void QuickScanPageElement() {
		quickScanPage.VerifyPageElements();
	}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void QuickScanVerifyMendatoryFields() {
		quickScanPage.VerifyMendatoryFields();
	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void QuickScanVerifyDifferentTextValuesInBusinessName() throws InterruptedException {
		quickScanPage.VerifyDifferentTextValuesInBusinessName();
	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void QuickScanVerifyDifferentCountryFlagsAndCodes() throws InterruptedException {
		quickScanPage.VerifyDifferentCountryFlagsAndCodes();
	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void QuickScanVerifyDifferentValuesForBusinessPhone() throws InterruptedException {
		quickScanPage.VerifyDifferentValuesForBusinessPhone();
	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void QuickScanVerifyDifferentValuesForBusinessAddress() throws InterruptedException {
		quickScanPage.VerifyDifferentValuesForBusinessAddress();
	}

	
	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 8) public void
	 * QuickScanCheckReportInIreland() throws InterruptedException {
	 * quickScanPage.CheckReportInIreland(); }
	 */
	 

	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void QuickScanVerifyProvidersInReportForIreland() throws InterruptedException {
		quickScanPage.VerifyProvidersInReportForIreland();
	}

	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void QuickScanVerifyReportColumnForIreland() {
		quickScanPage.VerifyReportColumnForIreland();
	}

	@Test(groups = { "sanity", "regression" }, priority = 11)
	public void QuickScanVerifyReportInUK() {
		quickScanPage.CheckReportInUK();
	}

	@Test(groups = { "sanity", "regression" }, priority = 12)
	public void QuickScanVerifyReportInUS() {
		quickScanPage.CheckReportInUS();
	}

	@Test(groups = { "sanity", "regression" }, priority = 13)
	public void QuickScanCheckReportForGoogleInIreland() {
		quickScanPage.CheckReportForGoogleInIreland();
	}

	@Test(groups = { "sanity", "regression" }, priority = 14)
	public void QuickScanCheckReportWithNotFoundSource() {
		quickScanPage.CheckReportWithNotFoundSource();
	}

	@Test(groups = { "sanity", "regression" }, priority = 15)
	public void QuickScanCheckReportWithAddr() {
		quickScanPage.CheckReportWithAddr();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();

	}
}
