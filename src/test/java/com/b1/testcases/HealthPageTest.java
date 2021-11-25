package com.b1.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.HealthPage;
import com.b1.pages.HomePage;
import com.b1.pages.LocationPage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;

@Listeners(TestListener.class)
public class HealthPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ReviewsPage reviewsPage;
	TestUtility testUtil;
	LocationPage locationPage;
	HealthPage healthPage;

	public HealthPageTest() {
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
		healthPage = new HealthPage();

	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void clickOnContextAndSelectCheesecake() throws InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'Cheesecake Factory')]")).getText();
		System.out.println("Location Name : " + LocationName);

	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void SelectHealth() throws Exception {
		healthPage.clickOnLocationHealth();

	}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void VerifyHealthTableRows() {
		healthPage.HandleTableRows();

	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void VerifyHealthTableColumns() {
		healthPage.HandleTableColumns();

	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void VerifyHealthTableHeader() {
		healthPage.HandleTableHeader();

	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void VerifyclickOnrecord() {
		healthPage.clickOnrecord();

	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void VerifyListOfIssueTypesFilter() throws Exception {
		healthPage.ListOfIssueTypesFilter();

	}

	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void VerifyPublisherFilter() throws Exception {
		healthPage.checkPublisher();

	}

	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void VerifyAddNormalizationFilter() throws Exception {
		healthPage.checkAddNormalization();

	}

	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void VerifyStatus() throws Exception {
		healthPage.checkStatus();

	}

	@Test(groups = { "sanity", "regression" }, priority = 11)
	public void VerifyIssues() {
		healthPage.checkIssues();

	}

	@Test(groups = { "sanity", "regression" }, priority = 12)
	public void VerifyIssuesTypes() {
		healthPage.checkIssuesTypes();

	}

	@Test(groups = { "sanity", "regression" }, priority = 13)
	public void VerifyLocation() {
		healthPage.checkLocation();

	}

	@Test(groups = { "sanity", "regression" }, priority = 14)
	public void VerifyPending() {
		healthPage.checkPending();

	}

	@Test(groups = { "sanity", "regression" }, priority = 15)
	public void VerifyPublishers() {
		healthPage.checkPublishers();

	}

	@Test(groups = { "sanity", "regression" }, priority = 16)
	public void VerifyTableRows() {
		healthPage.TableRows();

	}

	@Test(groups = { "sanity", "regression" }, priority = 17)
	public void VerifyTableColumns() {
		healthPage.TableColumns();

	}

	@Test(groups = { "sanity", "regression" }, priority = 18)
	public void VerifyTableHeader() {
		healthPage.TableHeader();

	}

	@Test(groups = { "sanity", "regression" }, priority = 19)
	public void VerifyExportDataSetup() throws Exception {
		healthPage.exportDataSetup();

	}

	@Test(groups = { "sanity", "regression" }, priority = 20)
	public void VerifyExportReviewData() throws Exception {
		healthPage.exportReviewData();

	}

	@Test(groups = { "sanity", "regression" }, priority = 21)
	public void VerifyExportCSVData() throws Exception {
		healthPage.readExportCSVData();

	}

	@Test(groups = { "sanity", "regression" }, priority = 22)
	public void VerifyselectSingleLocations() throws Exception {
		healthPage.selectSingleLocations();

	}

	@Test(groups = { "sanity", "regression" }, priority = 23)
	public void VerifydownloadHealthReport() throws Exception {
		healthPage.downloadHealthReport();

	}

	@Test(groups = { "sanity", "regression" }, priority = 24)
	public void VerifyHealthReport() throws Exception {
		healthPage.checkHealthReport();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		driver.quit();

	}

}
