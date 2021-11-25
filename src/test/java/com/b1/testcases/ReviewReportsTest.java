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
import com.b1.pages.ReviewReports;
import com.b1.util.TestUtility;
 

@Listeners(TestListener.class)
public class ReviewReportsTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ReviewReports PrecannedReviewOptionspage;
	TestUtility testUtil;
	
	public ReviewReportsTest() 
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
		PrecannedReviewOptionspage = new ReviewReports();
	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void clickOnContextAndSelectCheesecake() throws Exception 
	{
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'Cheesecake Factory')]")).getText();
		System.out.println("Location Name : " + LocationName);
	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void clickOnReviews() throws InterruptedException 
	{
		PrecannedReviewOptionspage.clickOnReviews();
	}
	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 3) public void
	 * clickOnPostingDate() throws Exception {
	 * PrecannedReviewOptionspage.postingDate(); Thread.sleep(3000);}
	 */

	
	@Test(groups = { "sanity", "regression" }, priority =3 )
	public void ClickOnReviewReport() throws InterruptedException 
	{
		PrecannedReviewOptionspage.ClickOnReviewReport();
	}

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 4) public void
	 * VerifyBlankDataErrorMsg() throws InterruptedException {
	 * PrecannedReviewOptionspage.VerifyBlankDataErrorMsg(); }
	 */

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void VerifyReviewReportOptions() throws InterruptedException 
	{
		PrecannedReviewOptionspage.VerifyReviewReportOptions();
	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void EnterReviewReportData() throws InterruptedException 
	{
		PrecannedReviewOptionspage.EnterReviewReportData();
	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void VerifyEnteredReviewReportData() throws InterruptedException 
	{
		PrecannedReviewOptionspage.VerifyEnteredReviewReportData();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() 
	{
		driver.quit();
	}

}
