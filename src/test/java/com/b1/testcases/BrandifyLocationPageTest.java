package com.b1.testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.BrandifyLocationPage;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;
 

@Listeners(TestListener.class)
public class BrandifyLocationPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	ReviewsPage reviewsPage;
	BrandifyLocationPage branifyLocationPage;
	public BrandifyLocationPageTest() {
		super();
	}
	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {

		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reviewsPage = new ReviewsPage();
		branifyLocationPage = new BrandifyLocationPage();

	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void clickOnContextAndBrandify() throws InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnContextAndBrandify();
		String LocationName = driver.findElement(By.xpath("/descendant::div[contains(text(),'Brandify')][1]"))
				.getText();
		System.out.println("Location Name : " + LocationName);
		reviewsPage.selectReviewOnEntitlements();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void VerifyLocationCreateOnCheck() throws Exception {
		branifyLocationPage.VerifyLocationCreateOnCheck();

	}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void verifyListingOncheck() throws Exception {
		branifyLocationPage.verifyListingOncheck();

	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void clickOnLocationOVerview() throws Exception {
		branifyLocationPage.clickOnLocationOVerview();

	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void LocationDetailsData() throws Exception {
		branifyLocationPage.LocationDetailsData();

	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void selectCountry() throws Exception {
		branifyLocationPage.selectCountry();

	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void checkAllTabs() throws Exception {
		branifyLocationPage.checkAllTabs();

	}
	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void ClickOnLocaionMap() throws Exception {
		branifyLocationPage.ClickOnLocaionMap();

	}

	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void VerifyLocationMap() throws Exception {
		branifyLocationPage.VerifyLocationMap();

	}

	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void clickOnCreateLocation() throws Exception {
		branifyLocationPage.clickOnCreateLocation();

	}

	@Test(groups = { "sanity", "regression" }, priority = 11)
	public void ClickOnLocationApproval() throws Exception {
		branifyLocationPage.ClickOnLocationApproval();

	}

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 12) public void
	 * ClickOnListMatching() throws Exception {
	 * branifyLocationPage.ClickOnListMatching();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 13) public void
	 * ClickOnEditListing() throws Exception {
	 * branifyLocationPage.ClickOnEditListing(); }
	 */

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 14) public void
	 * VerifyListing() throws Exception { branifyLocationPage.VerifyListing(); }
	 */
	
	@Test(groups = { "sanity", "regression" }, priority = 15)
	public void DeleteLocation() throws Exception {
		branifyLocationPage.DeleteLocation();

	}

	@Test(groups = { "sanity", "regression" }, priority = 16)
	public void DeleteApprovalHistory() throws Exception {
		branifyLocationPage.DeleteApprovalHistory();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
