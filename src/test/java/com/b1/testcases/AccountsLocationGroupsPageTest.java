package com.b1.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.AccountsCustomValuesPage;
import com.b1.pages.AccountsDetailsPage;
import com.b1.pages.AccountsLocationGroupsPage;
import com.b1.pages.HomePage;
import com.b1.pages.LocationPage;
import com.b1.pages.LoginPage;
import com.b1.util.TestUtility;


@Listeners(TestListener.class)
public class AccountsLocationGroupsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	AccountsCustomValuesPage accountsCustomValuesPage;
	AccountsDetailsPage accountsDetailsPage;
	LocationPage locationPage;
	AccountsLocationGroupsPage accountsLocationGroupsPage;

	public AccountsLocationGroupsPageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {

		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accountsCustomValuesPage = new AccountsCustomValuesPage();
		accountsDetailsPage = new AccountsDetailsPage();
		accountsLocationGroupsPage = new AccountsLocationGroupsPage();
		locationPage = new LocationPage();
	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void clickOnContextAndSelectGeostix() throws InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectGeostix();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'geostix2')]")).getText();
		System.out.println("Location Name : " + LocationName);

	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void GoTOAccount() {
		accountsDetailsPage.goToAccountsPage();

	}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void VerifyLocationGroupTab() throws Exception {

		accountsLocationGroupsPage.goToLocationGroupTab();
	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void VerifyAddLocationGroup() throws Exception {

		accountsLocationGroupsPage.clickOnAddLocationGroup();
	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void VerifySelectManually() throws Exception {

		accountsLocationGroupsPage.clickOnSelectManually();
	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void VerifyLocationGroupName() throws Exception {

		accountsLocationGroupsPage.AddLocationGroupName();
	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void VerifySubmit() throws Exception {

		accountsLocationGroupsPage.clickOnSubmit();
	}

	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void VerifyNewRecord() throws Exception {

		accountsLocationGroupsPage.checkLocationGroupRecord();
	}

	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void VerifyDeleteRecord() throws Exception {

		accountsLocationGroupsPage.deleteRecord();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		driver.quit();

	}

}
