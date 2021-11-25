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
import com.b1.pages.EditUpdateLocationPage;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;
 

@Listeners(TestListener.class)
public class EditUpdateLocationPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	ReviewsPage reviewsPage;
	EditUpdateLocationPage editUpdateLocationPage;

	public EditUpdateLocationPageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {

		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reviewsPage = new ReviewsPage();
		editUpdateLocationPage = new EditUpdateLocationPage();

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
	public void VerifyTaxonomy() throws Exception {
		editUpdateLocationPage.VerifyTaxonomy();
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void VerifyListingForGoogleOnSEOTab() throws Exception {
		editUpdateLocationPage.VerifyListingForGoogleOnSEOTab();
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void clickOnLocationOVerview() throws Exception {
		editUpdateLocationPage.clickOnLocationOVerview();
	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void AddLocationDetailsData() throws Exception {
		editUpdateLocationPage.AddLocationDetailsData();

	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void selectCountry() throws Exception {
		editUpdateLocationPage.selectCountry();

	}
	
	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void AddLocationSEOData() throws Exception {
		editUpdateLocationPage.AddLocationSEOData();

	}
	
	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void AddLocationOfferingsData() throws Exception {
		editUpdateLocationPage.AddLocationOfferingsData();

	}
	
	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void clickOnCreateLocation() throws Exception {
		editUpdateLocationPage.clickOnCreateLocation();

	}
		
	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void UpdateCreatedLocationData() throws Exception {
		editUpdateLocationPage.UpdateCreatedLocationData();

	}
	
	@Test(groups = { "sanity", "regression" }, priority = 11)
	public void VerifyUpdatedLocationData() throws Exception {
		editUpdateLocationPage.VerifyUpdatedLocationData();

	}
	
	@Test(groups = { "sanity", "regression" }, priority = 12)
	public void DeleteCreatedLocation() throws Exception {
		editUpdateLocationPage.DeleteCreatedLocation();

	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();

	}
}
