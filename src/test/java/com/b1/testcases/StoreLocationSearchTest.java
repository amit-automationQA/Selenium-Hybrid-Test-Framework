package com.b1.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.pages.StoreLocationSearch;
 
@Listeners(TestListener.class)
public class StoreLocationSearchTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	StoreLocationSearch storelocationsearch;

	public StoreLocationSearchTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {
		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		storelocationsearch = new StoreLocationSearch();
	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void clickOnContextAndSelectCheesecake() throws Exception {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'Cheesecake Factory')]")).getText();
		System.out.println("Location Name : " + LocationName);
	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void ClickOnCheesecake_AllLocations() throws Exception {
		storelocationsearch.ClickOnCheesecake_AllLocations();

	}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void ClickOnSearchField() throws InterruptedException {
		storelocationsearch.ClickOnSearchField();

	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void EnterSearchData() throws InterruptedException {
		storelocationsearch.EnterSearchData();

	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void VerifySearchedData() throws InterruptedException {
		storelocationsearch.VerifySearchedData();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();

	}

}
