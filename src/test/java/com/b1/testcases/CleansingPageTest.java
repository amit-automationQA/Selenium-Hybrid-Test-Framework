package com.b1.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.CleansingPage;
import com.b1.pages.HomePage;
import com.b1.pages.LocationPage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;
 


@Listeners(TestListener.class)
public class CleansingPageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	ReviewsPage reviewsPage;
	TestUtility testUtil;
	LocationPage locationPage;
	CleansingPage cleansingPage;

	public CleansingPageTest() 
	{
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException 
	{
		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reviewsPage = new ReviewsPage();
		locationPage = new LocationPage();
		cleansingPage = new CleansingPage();	
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
		cleansingPage.clickOnLocationCleansing();
		
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void VerifyHeader() throws Exception {
		cleansingPage.checkHeader();
		
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void VerifyIssueTypesFilter() throws Exception {
		cleansingPage.ListOfIssueTypesFilter();
		
	}
	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void VerifyIssueDateFilter() throws Exception {
		cleansingPage.ListOfIssueDateFilter();
	}
	
	
	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void VerifyIssues() throws Exception {
		cleansingPage.checkIssues();
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void VerifyIssuesTypes() throws Exception {
		cleansingPage.checkIssuesTypes();
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void VerifyLocation() throws Exception {
		cleansingPage.checkLocation();
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void VerifyAvgLenth() throws Exception {
		cleansingPage.checkAvgLenth();
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void VerifyHeaderofTable() throws Exception {
		cleansingPage.HeaderofTable();
	}
	
	  @Test(groups = { "sanity", "regression" }, priority = 11) public void
	  SelectIssueDate() throws Exception { cleansingPage.IssueDateSelection(); }
	  
	  @Test(groups = { "sanity", "regression" }, priority = 12) public void
	  VerifyHandleRows() throws Exception { cleansingPage.HandleTableRows(); }
	 
	
	 @AfterClass(alwaysRun = true)
	 public void tearDown() {
	  
	  driver.quit();
	  
	  }
	
}
