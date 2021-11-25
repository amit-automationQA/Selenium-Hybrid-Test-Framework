package com.b1.testcases;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewFeedPage;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;
 

public class ReviewFeedPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ReviewFeedPage reviewFeedPage;
	TestUtility testUtil;
	ReviewsPage reviewsPage;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public ReviewFeedPageTest() throws IOException 
	{
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {
		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			reviewFeedPage = new ReviewFeedPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		reviewFeedPage.ClickOnReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void totalCountOnDefault() throws Exception {
		reviewFeedPage.TotalCountOnDefault();
	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void VerifyFlaggedReviewsFilters() throws Exception {
		reviewFeedPage.VerifyFlaggedReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void VerifyResponserequiredFilters() throws Exception {

		reviewFeedPage.VerifyResponseRequired();
	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void VerifyRespondedReviewsFilters() throws Exception {
		reviewFeedPage.VerifyRespondedReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void VerifyAllReviewFilters() throws Exception {
		reviewFeedPage.VerifyAllReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void TotalCountOnAllTime() throws Exception {
		reviewFeedPage.TotalCountOnALLTime();
	}

	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void VerifyDefaultReviewText() throws Exception {

		reviewFeedPage.DefaultReviewText();
	}

	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void VerifyRespondFeature() throws Exception {
		reviewFeedPage.RespondFeature();
	}

	@Test(groups = { "sanity", "regression" }, priority = 11)

	public void VerifyAllReviews() throws Exception {
		reviewFeedPage.AllReview();
	}

	@Test(groups = { "sanity", "regression" }, priority = 12)
	public void VerifySourceProviderFilter() throws Exception {
		reviewFeedPage.PublisherFilterVerification();
	}

	@Test(groups = { "sanity", "regression" }, priority = 13)
	public void CheckGoogleImage() throws Exception {
		reviewFeedPage.VerifyGoogleImage();
	}

	@Test(groups = { "sanity", "regression" }, priority = 14)
	public void checkFacebookImage() throws Exception {
		reviewFeedPage.VerifyFacebookImage();
	}

	@Test(groups = { "sanity", "regression" }, priority = 15)
	public void checkYelpImage() throws Exception {
		reviewFeedPage.VerifyYelpImage();
	}

	@Test(groups = { "sanity", "regression" }, priority = 16)
	public void checkTripAdvisorImage() throws Exception {
		reviewFeedPage.VerifyTripAdvisorImage();
	}

	@Test(groups = { "sanity", "regression" }, priority = 17)
	public void CheckgooglePublisherFilter() throws Exception {
		reviewFeedPage.VerifygooglePublisher();
	}

	@Test(groups = { "sanity", "regression" }, priority = 18)
	public void VerifyReviewsCountFor10() throws Exception {
		reviewFeedPage.VerifyTotalReviewOnPageFor10();
	}

	@Test(groups = { "sanity", "regression" }, priority = 19)
	public void VerifyReviewsCountFor25() throws Exception {
		reviewFeedPage.VerifyTotalReviewOnPageFor25();
	}

	@Test(groups = { "sanity", "regression" }, priority = 20)
	public void VerifyReviewsCountFor50() throws Exception {
		reviewFeedPage.VerifyTotalReviewOnPageFor50();
	}

	@Test(groups = { "sanity", "regression" }, priority = 21)
	public void VerifyReviewsCountFor100() throws Exception {
		reviewFeedPage.VerifyTotalReviewOnPageFor100();
	}

	@Test(groups = { "sanity", "regression" }, priority = 22)
	public void VerifyTagsFunctionality() throws Exception {
		reviewFeedPage.VerifyAddDeleteTag();
	}

	@Test(groups = { "sanity", "regression" }, priority = 23)
	public void saveFilter() throws Exception {
		reviewFeedPage.saveFilter();
	}

	@Test(groups = { "sanity", "regression" }, priority = 24)
	public void verifyFilter() throws Exception {
		reviewFeedPage.verifyFilter();
	}

	@Test(groups = { "sanity", "regression" }, priority = 25)
	public void DeleteSavedFilter() throws Exception {
		reviewFeedPage.DeleteSavedFilter();
	}

	@Test(groups = { "sanity", "regression" }, priority = 26)
	public void preCannedFilterSelect() throws Exception {
		reviewFeedPage.preCannedFilterSelect();
	}

	@Test(groups = { "sanity", "regression" }, priority = 27)
	public void Select3DotReviewTile() throws Exception {
		reviewFeedPage.Select3DotReviewTile();
	}

	@Test(groups = { "sanity", "regression" }, priority = 28)
	public void SelectGotoSite() throws Exception {
		reviewFeedPage.SelectGotoSite();
	}

	@Test(groups = { "sanity", "regression" }, priority = 29)
	public void SelectReviewHistory() throws Exception {
		reviewFeedPage.SelectReviewHistory();
	}

	@Test(groups = { "sanity", "regression" }, priority = 30)
	public void SelectShareReview() throws Exception {
		reviewFeedPage.SelectShareReview();
	}

	@Test(groups = { "sanity", "regression" }, priority = 31)
	public void SortOldestFilter() throws Exception {
		reviewFeedPage.SortOldestFilter();
	}

	@Test(groups = { "sanity", "regression" }, priority = 32)
	public void HighestRatedFilter() throws Exception {
		reviewFeedPage.HighestRatedFilter();
	}

	@Test(groups = { "sanity", "regression" }, priority = 33)
	public void VerifyReviewStatusNew() throws Exception {
		reviewFeedPage.ReviewStatusNew();
	}

	@Test(groups = { "sanity", "regression" }, priority = 34)
	public void VerifyReviewStatusQueued() throws Exception {
		reviewFeedPage.ReviewStatusQueued();
	}

	@Test(groups = { "sanity", "regression" }, priority = 35)
	public void VerifyReviewStatusFailed() throws Exception {
		reviewFeedPage.ReviewStatusFailed();
	}

	@Test(groups = { "sanity", "regression" }, priority = 36)
	public void VerifyReviewStatusDone() throws Exception {
		reviewFeedPage.ReviewStatusDone();
	}

	@Test(groups = { "sanity", "regression" }, priority = 37)
	public void VerifyPublicResponse() throws Exception {
		reviewFeedPage.PublicResponse();
	}

	@Test(groups = { "sanity", "regression" }, priority = 38)
	public void VerifyPrivateResponse() throws Exception {
		reviewFeedPage.PrivateResponse();
	}

	@Test(groups = { "sanity", "regression" }, priority = 39)
	public void VerifyRatingFilter() throws Exception {
		reviewFeedPage.RatingFilter();
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 40)
	public void Verify_City_Filter_test() throws InterruptedException {
		reviewFeedPage.Verify_City_Filter();
	}
	
	@Test(groups = { "sanity", "regression" }, priority = 41)
	public void Verify_State_Filter_test() throws InterruptedException {
		reviewFeedPage.Verify_State_Filter();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
