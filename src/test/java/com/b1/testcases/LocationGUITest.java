package com.b1.testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.HomePage;
import com.b1.pages.LocationGUI;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;
 
@Listeners(TestListener.class)
public class LocationGUITest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	ReviewsPage reviewsPage;
	LocationGUI locationGUI;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public LocationGUITest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {

		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		locationGUI = new LocationGUI();
		reviewsPage = new ReviewsPage();
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
	public void CheckAddLocationEnable() throws InterruptedException {

		reviewsPage.selectReviewOnEntitlements();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'Entitlements')]")).click();
		Thread.sleep(2000);
		boolean checkbox = driver.findElement(By.xpath("//input[@id='entitlements-Location']")).isSelected();
		System.out.println("Check checkbox value is : " + checkbox);
		if (checkbox == true) {

			System.out.println("Checkbox is already checked  ");

		} else {
			driver.findElement(By.xpath(
					"/html/body/div[1]/div/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div[1]/div[1]/div/label/span"))
					.click();

			System.out.println("Checkbox is checked");

			driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();
		}

		driver.navigate().refresh();
		
		Thread.sleep(6000);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(location);
		actions.click().build().perform();
		Thread.sleep(2000);


		driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
	}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void ClickOnAddLocation() throws Exception {
		locationGUI.ClickOnAddLocation();
	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void VerifyLocationTabs() throws Exception {
		Thread.sleep(2000);
		locationGUI.VerifyLocationTabs();
	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void verifyDetailTab() throws Exception {
		Thread.sleep(2000);
		locationGUI.verifyDetailTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void VerifyMapTab() throws Exception {
		Thread.sleep(2000);
		locationGUI.VerifyMapTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void VerifySEOTab() throws Exception {
		Thread.sleep(2000);
		locationGUI.VerifySEOTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void VerifyHoursTab() throws Exception {
		Thread.sleep(2000);
		locationGUI.VerifyHoursTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void VerifyOfferingTab() throws Exception {
		Thread.sleep(2000);
		locationGUI.VerifyOfferingTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void VerifyMediaTab() throws Exception {
		Thread.sleep(2000);
		locationGUI.VerifyMediaTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 11)
	public void VerifyCustomTab() throws Exception {
		Thread.sleep(2000);
		locationGUI.VerifyCustomTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 12)
	public void VerifyFiltersNTabs() throws Exception {
		Thread.sleep(2000);
		locationGUI.VerifyFiltersNTabs();
	}

	@Test(groups = { "sanity", "regression" }, priority = 13)
	public void LocationDetailsData() throws Exception {

		locationGUI.LocationDetailsData();
	}

	@Test(groups = { "sanity", "regression" }, priority = 14)
	public void selectCountry() throws Exception {

		locationGUI.selectCountry();
	}

	@Test(groups = { "sanity", "regression" }, priority = 15)
	public void clickOnCreateLocation() throws Exception {

		locationGUI.clickOnCreateLocation();
	}

	@Test(groups = { "sanity", "regression" }, priority = 16)
	public void VerifydefaultFieldsforDetailsTab() throws Exception {

		locationGUI.VerifydefaultFieldsforDetailsTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 17)
	public void VerifydefaultFieldsforMapTab() throws Exception {

		locationGUI.VerifydefaultFieldsforMapTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 18)
	public void VerifydefaultFieldsforSEOTab() throws Exception {

		locationGUI.VerifydefaultFieldsforSEOTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 19)
	public void VerifydefaultFieldsforHoursTab() throws Exception {

		locationGUI.VerifydefaultFieldsforHoursTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 20)
	public void VerifydefaultFieldsforOfferingsTab() throws Exception {

		locationGUI.VerifydefaultFieldsforOfferingsTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 21)
	public void VerifydefaultFieldsforMediaTab() throws Exception {

		locationGUI.VerifydefaultFieldsforMediaTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 22)
	public void VerifydefaultFieldsforProfileURLsTab() throws Exception {

		locationGUI.VerifydefaultFieldsforProfileURLsTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 23)
	public void VerifydefaultFieldsforCustomsTab() throws Exception {

		locationGUI.VerifydefaultFieldsforCustomsTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 24)
	public void VerifydefaultFieldsforHistoryTab() throws Exception {

		locationGUI.VerifydefaultFieldsforHistoryTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 25)
	public void VerifydefaultFieldsforInternalsTab() throws Exception {

		locationGUI.VerifydefaultFieldsforInternalsTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 26)
	public void DeleteCreatedLocation() throws Exception {

		locationGUI.DeleteCreatedLocation();
	}
	

	 @AfterClass(alwaysRun = true) 
	 public void tearDown() { 
		 driver.quit();
	 }
	
}
