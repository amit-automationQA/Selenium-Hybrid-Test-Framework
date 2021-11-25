package com.b1.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewFeed_Regress_Page;
import com.b1.util.TestUtility;

public class ReviewFeed_Regress_PageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	ReviewFeed_Regress_Page review;

	public ReviewFeed_Regress_PageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		initialization();
		// BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 review = new ReviewFeed_Regress_Page();

	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void clickOnContextAndSelectCheesecake() throws Exception {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'Cheesecake Factory')]")).getText();
		System.out.println("Location Name : " + LocationName);
	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void clickOnReviews() throws Exception {
		driver.navigate().refresh();
		review.ClickOnReviews();
	}

	@Test(groups={ "sanity", "regression" },priority=3)
	public void C2277_VerifyEmail_ReviewSummary_Test() throws InterruptedException, ParseException {
		review.VerifyEmail_ReviewSummary();
	}
	
	@Test(groups={ "sanity", "regression" },priority=4)
	public void C2278_VerifyEmail_ResponseReminder_Test() throws InterruptedException, ParseException {
		review.VerifyEmail_ResponseReminder();
	}
	
	@Test(groups={ "sanity", "regression" },priority=4)
	public void C2281_VerifyShareReview() throws InterruptedException {
		review.VerifyShareReview();
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
