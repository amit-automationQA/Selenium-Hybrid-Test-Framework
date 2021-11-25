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
import com.b1.pages.HomePage;
import com.b1.pages.LocationPage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;
 

@Listeners(TestListener.class)
public class LocationPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ReviewsPage reviewsPage;
	TestUtility testUtil;
	LocationPage locationPage;

	public LocationPageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {

		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reviewsPage = new ReviewsPage();
		locationPage = new LocationPage();
	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void clickOnContextAndSelectGeostix() throws InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectGeostix();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'geostix2')]")).getText();
		System.out.println("Location Name : " + LocationName);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void VerifyNameFilter() {

		locationPage.checkNameFilter();

	}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void VerifyAddressFilter() {

		locationPage.checkAddressFilter();

	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void VerifyCityFilter() {

		locationPage.checkCityFilter();

	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void VerifyStateFilter() {

		locationPage.checkStateFilter();

	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void VerifyPostalCodeFilter() {

		locationPage.checkPostalCodeFilter();

	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void VerifyAddFilter() {

		locationPage.checkAddFilterFilter();

	}

	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void VerifySelectFilter() throws Exception {

		locationPage.checkSelectFilter();

	}

	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void VerifyClickAddLocation() {

		locationPage.clickAddLocation();
	}

	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void VerifyLocationDetailsData() {

		locationPage.LocationDetailsData();
	}

	@Test(groups = { "sanity", "regression" }, priority = 11)
	public void SelectCountryInDetails() throws Exception {

		locationPage.selectCountry();
	}

	@Test(groups = { "sanity", "regression" }, priority = 12)
	public void VerifyAllTabs() {

		locationPage.checkAllTabs();
	}

	@Test(groups = { "sanity", "regression" }, priority = 13)
	public void VerifyClickSEO() {

		locationPage.clickSEO();
	}

	@Test(groups = { "sanity", "regression" }, priority = 14)
	public void VerifyLocationSEOData() {

		locationPage.LocationSEOData();
	}

	@Test(groups = { "sanity", "regression" }, priority = 15)
	public void VerifyWebsiteInSEO() throws Exception {

		locationPage.addWebsiteLinks();
	}

	@Test(groups = { "sanity", "regression" }, priority = 16)
	public void VerifyClickHours() {

		locationPage.clickHours();
	}

	@Test(groups = { "sanity", "regression" }, priority = 17)
	public void VerifySelectHours() {

		locationPage.selectHours();
	}

	@Test(groups = { "sanity", "regression" }, priority = 18)
	public void VerifySelectSpecialHours() throws Exception {

		locationPage.selectSpecialHours();
	}

	@Test(groups = { "sanity", "regression" }, priority = 19)
	public void VerifyHours() throws Exception 
	{
		locationPage.VerifyHours();
	}

	@Test(groups = { "sanity", "regression" }, priority = 20)
	public void VerifyClickOfferings() 
	{
		locationPage.clickOfferings();
	}

	@Test(groups = { "sanity", "regression" }, priority = 21)
	public void VerifyLocationOfferingsData() {

		locationPage.LocationOfferingsData();
	}

	@Test(groups = { "sanity", "regression" }, priority = 22)
	public void ClickOnLocationMedia() 
	{
		locationPage.ClickOnLocationMedia();
	}

	@Test(groups = { "sanity", "regression" }, priority = 23)
	public void VerifyLocationMedia() throws InterruptedException 
	{
		locationPage.VerifyLocationMedia();
	}

	 /* @Test(groups = { "sanity", "regression" }, priority = 24) public void
	  UploadImage() throws InterruptedException, IOException {
	  locationPage.UploadImage();
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" }, priority = 25) public void
	  VerifyUploadedImage() throws InterruptedException {
	  locationPage.VerifyUploadedImage();
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" }, priority = 26) public void
	  EditMedia() throws InterruptedException { locationPage.EditMedia();
	  
	 }*/
	 
	@Test(groups = { "sanity", "regression" }, priority = 27)
	public void VerifyInputData() throws InterruptedException 
	{
		locationPage.VerifyInputData();
	}

	@Test(groups = { "sanity", "regression" }, priority = 28)
	public void VerifyClickCustom() 
	{
		locationPage.clickOCustom();
	}

	@Test(groups = { "sanity", "regression" }, priority = 29)
	public void VerifyLocationCustomData() {

		locationPage.LocationCustomData();
	}

	@Test(groups = { "sanity", "regression" }, priority = 30)
	public void VerifyDetailsData() {

		locationPage.checkDetailsData();
	}

	@Test(groups = { "sanity", "regression" }, priority = 31)
	public void VerifyLocationMap() {

		locationPage.VerifyLocationMap();
	}

	@Test(groups = { "sanity", "regression" }, priority = 32)
	public void VerifySEOdata() {

		locationPage.checkSEOdata();
	}

	@Test(groups = { "sanity", "regression" }, priority = 33)
	public void VerifyOfferingsdata() {

		locationPage.checkOfferingsdata();
	}

	@Test(groups = { "sanity", "regression" }, priority = 34)
	public void VerifyCustomdata() {

		locationPage.checkCustomdata();
	}

	@Test(groups = { "sanity", "regression" }, priority = 35)
	public void VerifyCreateLocation() throws Exception {
		locationPage.clickOnCreateLocation();
		Thread.sleep(3000);
	}

	@Test(groups = { "sanity", "regression" }, priority = 36)
	public void VerifyNewlyCreatedLocation() throws Exception {

		locationPage.checkNewAddedLocation();

	}

	@Test(groups = { "sanity", "regression" }, priority = 37)
	public void VerifyDeleteLocation() throws Exception {

		locationPage.deleteLocation();
	}

	@Test(groups = { "sanity", "regression" }, priority = 38)
	public void VerifyexportDataSetup() throws Exception {

		locationPage.exportDataSetup();
	}

	@Test(groups = { "sanity", "regression" }, priority = 39)
	public void VerifyexportReviewData() throws Exception {

		locationPage.exportReviewData();
	}

	@Test(groups = { "sanity", "regression" }, priority = 40)
	public void VerifyreadExportCSVData() throws Exception {

		locationPage.readExportCSVData();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();

	}

}
