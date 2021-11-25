package com.b1.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.AccountsCustomValuesPage;
import com.b1.pages.AccountsDetailsPage;
import com.b1.pages.AccountsLocationGroupsPage;
import com.b1.pages.DefaultFieldsValuesPage;
import com.b1.pages.HomePage;
import com.b1.pages.LocationPage;
import com.b1.pages.LoginPage;
import com.b1.util.TestUtility;
 
@Listeners(TestListener.class)
public class DefaultFieldsValuesPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	AccountsCustomValuesPage accountsCustomValuesPage;
	AccountsDetailsPage accountsDetailsPage;
	LocationPage locationPage;
	AccountsLocationGroupsPage accountsLocationGroupsPage;
	DefaultFieldsValuesPage defaultFieldsValuesPage;

	public DefaultFieldsValuesPageTest() {
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
		defaultFieldsValuesPage = new DefaultFieldsValuesPage();
	}

	@Test(priority = 1)
	public void clickOnContextAndSelectGeostix() throws InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectGeostix();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'geostix2')]")).getText();
		System.out.println("Location Name : " + LocationName);

	}

	@Test(priority = 2)
	public void GoTOAccount() {
		accountsDetailsPage.goToAccountsPage();

	}

	@Test(priority = 3)
	public void VerifyDefaultFieldsValuesPage() {
		defaultFieldsValuesPage.clickOnDefaultFieldsValuesPage();

	}

	  @Test(priority = 4, enabled=true) public
	  void VerifySelectMasterCat() throws Exception {
	  defaultFieldsValuesPage.SelectMasterCat();
	  
	  }
	 
	  @Test(priority = 5, enabled=true) public
	  void VerifyUpdate() throws InterruptedException {
		  Thread.sleep(1000);
	//  String fbText = driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")).getAttribute("value");
		  String fbText = driver.findElement(By.xpath("//div[contains(text(),'google')]")).getText();
	  ////driver.findElement(By.xpath("//div[contains(text(),'facebook')]")).getText();
	  Assert.assertEquals("google", fbText);
	  System.out.println("Master Category added as googlepages " + fbText); }
	  
	@Test(priority = 6, enabled = true)
	public void VerifyselectHours() throws Exception {
		defaultFieldsValuesPage.selectHours();
	}

	@Test(priority = 7, enabled = true)
	public void VerifyselectSpecialHours() throws Exception {
		defaultFieldsValuesPage.selectSpecialHours();
	}

	@Test(priority = 8)
	public void VerifyClearData() throws Exception {
		defaultFieldsValuesPage.ClearCategoryData();
	}

	@Test(priority = 9)
	public void VerifyClearHoursData() throws Exception {
		defaultFieldsValuesPage.ClearHoursData();
	}

	@Test(priority = 10)
	public void VerifyClearSpecialHoursData() throws Exception {
		defaultFieldsValuesPage.ClearSpecialHoursData();
	}

	  @AfterClass(alwaysRun = true) public void tearDown() { driver.quit();
	  
	  }	
}
