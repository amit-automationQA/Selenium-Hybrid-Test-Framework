package com.b1.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.AccountsDetailsPage;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.util.TestUtility;
 

@Listeners(TestListener.class)
public class AccountsDetailsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	AccountsDetailsPage accountsDetailsPage;

	public AccountsDetailsPageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {

		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accountsDetailsPage = new AccountsDetailsPage();
	}

	@Test(groups = { "sanity", "regression" },priority = 1)
	public void clickOnContextAndSelectCheesecake() throws Exception {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'Cheesecake Factory')]")).getText();
		System.out.println("Location Name : " + LocationName);

	}

	@Test(groups = { "sanity", "regression" },priority = 2)
	public void GoTOAccount() {
		accountsDetailsPage.goToAccountsPage();

	}
	

	@Test(groups = { "sanity", "regression" },priority = 3)
	public void VerifyAccountDetails() throws Exception {

		accountsDetailsPage.checkAccountDetails();
	}
	
	@Test(groups = { "sanity", "regression" },priority = 4)
	public void VeifyAccountsTabs() {
		accountsDetailsPage.checkAccountsTabs();

	}

	
	@Test(groups = { "sanity", "regression" },priority = 5)
	public void VerifyAllTabs() {
		accountsDetailsPage.checkAllTabs();

	}

	@Test(groups = { "sanity", "regression" },priority = 6)
	public void VeifyAddDetailsData() throws Exception {
		accountsDetailsPage.AddDetailsData();

	}
	
	@Test(groups = { "sanity", "regression" },priority = 7)
	public void VerifyContacts() throws Exception {
		accountsDetailsPage.clickOnContacts();

	}

	@Test(groups = { "sanity", "regression" },priority = 8)
	public void VerifyContactsData() {

		accountsDetailsPage.ContactsData();
	}
	
	@Test(groups = { "sanity", "regression" },priority = 9)	
	public void VerifyGoToDefaultFieldValuesTab() throws Exception {
		accountsDetailsPage.GoToDefaultFieldValuesTab();
	}
	@Test(groups = { "sanity", "regression" },priority = 10)
	public void VeifyDetailsData() throws Exception {
		accountsDetailsPage.CheckDetailsData();

	}
	@Test(groups = { "sanity", "regression" },priority = 11)
	public void VerifyContactsAddedData() throws Exception {

		accountsDetailsPage.CheckContactsData();

	}
	
	
	@Test(groups = { "sanity", "regression" },priority = 12)
	public void VeifyClearDetailsData() throws Exception {
		accountsDetailsPage.clearDetailsData();

	}

	@Test(groups = { "sanity", "regression" },priority = 13)
	public void VerifyDeleteContact() throws Exception {
		Thread.sleep(3000);
		accountsDetailsPage.deleteContact();
	}

	

@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();

	}
	
}
