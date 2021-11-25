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
import com.b1.pages.HomePage;
import com.b1.pages.LocationPage;
import com.b1.pages.LoginPage;
import com.b1.util.TestUtility;

 
@Listeners(TestListener.class)
public class AccountsCustomValuesPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	AccountsCustomValuesPage accountsCustomValuesPage;
	AccountsDetailsPage accountsDetailsPage;
	LocationPage locationPage;
	
	public AccountsCustomValuesPageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {

		initialization();
		//BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accountsCustomValuesPage = new AccountsCustomValuesPage();
		accountsDetailsPage = new AccountsDetailsPage();
		
		locationPage = new LocationPage();
	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void clickOnContextAndSelectGeostix() throws InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectGeostix();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'geostix2')]")).getText();
		System.out.println("Location Name : " + LocationName);

	}

	@Test(groups = { "sanity", "regression" },priority = 2)
	public void GoTOAccount() {
		accountsDetailsPage.goToAccountsPage();

	}
	
	@Test(groups = { "sanity", "regression" },priority = 3)
	public void VerifyAccountCustom() throws Exception {

		accountsCustomValuesPage.checkAccountCustom();
	}
	
	@Test(groups = { "sanity", "regression" },priority = 4)
	public void VerifyCustomPropTab() throws Exception {

		accountsCustomValuesPage.goToCustomPropTab();
	}
	
	@Test(groups = { "sanity", "regression" },priority = 5)
	public void VerifyAddCustom() throws Exception 
	{

		accountsCustomValuesPage.CheckAddCustom();
	}
	
	@Test(groups = { "sanity", "regression" },priority = 6)
	public void VerifyAddCustomProperty() throws Exception {

		accountsCustomValuesPage.AddCustomProperty();
	}
	
	@Test(groups = { "sanity", "regression" },priority = 7)
	public void VerifyNewAddedCustomRecord() throws Exception {

		accountsCustomValuesPage.checkNewAddedCustomRecord();
	}
	
	@Test(groups = { "sanity", "regression" },priority = 8)
	public void VerifynavigateToLocation() throws Exception {

		accountsCustomValuesPage.navigateToLocation();
	}
	
	
	  @Test(groups = { "sanity", "regression" },priority = 9) public void
	  VerifyAllLableNames() throws Exception {
	  
	  accountsCustomValuesPage.checkAllLableNames(); }
	 
	
	@Test(groups = { "sanity", "regression" },priority = 10)
	public void GoTOAccountPage() throws Exception {
		accountsDetailsPage.goToAccountsPage();
		Thread.sleep(2000);
		accountsCustomValuesPage.goToCustomPropTab();

	}
	
	  @Test(groups = { "sanity", "regression" },priority = 11) public void
	  VerifydeleteCustomProp() throws Exception 
	  {
	  accountsCustomValuesPage.deleteCustomProp(); 
	  }
	  
	  @AfterClass(alwaysRun = true) public void tearDown() {
	  
	  driver.quit();
	  
	  }
	 
	
}
