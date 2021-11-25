package com.b1.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.FlagReviewFeedPage;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewFeedPage;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;

@Listeners(TestListener.class)
public class FlagReviewFeedPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ReviewFeedPage reviewFeedPage;
	TestUtility testUtil;
	ReviewsPage reviewsPage;
	FlagReviewFeedPage flagreviewfeedpage;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public FlagReviewFeedPageTest() throws IOException {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reviewFeedPage = new ReviewFeedPage();
		flagreviewfeedpage = new FlagReviewFeedPage();
	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void VerifyOneStagingLogin_test() throws InterruptedException {
		flagreviewfeedpage.VerifySearchLocation();
	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void clickOnReviews() throws Exception {
		driver.navigate().refresh();
		flagreviewfeedpage.ClickOnReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void VerifyFlagIcon() throws Exception {
		flagreviewfeedpage.VerifyFlagIcon();
	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void FlagIconInResponseRequired() throws Exception {
		flagreviewfeedpage.FlagIconInResponseRequired();
	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void GoToFlaggedReviews() throws Exception {
		flagreviewfeedpage.GoToFlaggedReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void VerifyFlaggedReview() throws Exception {
		flagreviewfeedpage.VerifyFlaggedReview();
	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void UnflagReview() throws Exception {
		flagreviewfeedpage.UnflagReview();
	}

	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void VerifyUnflaggedReview() throws Exception {
		flagreviewfeedpage.VerifyUnflaggedReview();
	}

	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void UnflaggedReviewisPresentinRR() throws Exception {
		flagreviewfeedpage.UnflaggedReviewisPresentinRR();
	}

	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void SelectAllReviews() throws Exception {
		flagreviewfeedpage.SelectAllReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 11)
	public void FlagIconInAllReviews() throws Exception {
		flagreviewfeedpage.FlagIconInAllReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 12)
	public void VerifyFlaggedReviewForAllReviews() throws Exception {
		flagreviewfeedpage.VerifyFlaggedReviewForAllReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 13)
	public void UnflagReviewForAllReviews() throws Exception {
		flagreviewfeedpage.UnflagReviewForAllReviews();
	}

	@Test(groups = { "sanity", "regression" }, priority = 14)
	public void AuthorVarification() throws Exception {
		flagreviewfeedpage.AuthorVarification();
	}

	@Test(groups = { "sanity", "regression" }, priority = 15)
	public void ModifiedReviewsFilter() throws Exception {
		flagreviewfeedpage.ModifiedReviewsFilter();
	}

	@Test(groups = { "sanity", "regression" }, priority = 16)
	public void VerifyFlaggedReviewsFromAddFilters() throws Exception {
		flagreviewfeedpage.VerifyFlaggedReviewsFromAddFilters();
	}

	@Test(groups = { "sanity", "regression" }, priority = 17)
	public void VerifyTags() throws Exception {
		flagreviewfeedpage.VerifyTags();
	}

	@Test(groups = { "sanity", "regression" }, priority = 18)
	public void VerifyRespondedDates() throws Exception {
		flagreviewfeedpage.VerifyRespondedDates();
	}

	@Test(groups = { "sanity", "regression" }, priority = 19)
	public void VerifyStoreNumberWithNumeric() throws Exception {
		flagreviewfeedpage.VerifyStoreNumberWithNumeric();
	}

	@Test(groups = { "sanity", "regression" }, priority = 20)
	public void VerifyStoreNumberWithAlfaNumeric() throws Exception {
		flagreviewfeedpage.VerifyStoreNumberWithAlfaNumeric();
	}

	@Test(groups = { "sanity", "regression" }, priority = 21)
	public void VerifyPublicResponse() throws Exception {
		flagreviewfeedpage.VerifyPublicResponse();
	}

	@Test(groups = { "sanity", "regression" }, priority = 22)
	public void VerifyPrivateResponse() throws Exception {
		flagreviewfeedpage.VerifyPrivateResponse();
	}

	@Test(groups = { "sanity", "regression" }, priority = 23)
	public void VerifyStatusOfReviewTile() throws Exception {
		flagreviewfeedpage.VerifyStatusOfReviewTile();
	}

	@Test(groups = { "sanity", "regression" }, priority = 24)
	public void VerifyRespondHistory() throws Exception {
		flagreviewfeedpage.VerifyRespondHistory();
	}

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 25) public void
	 * EmailSchedulerVerify() throws Exception {
	 * flagreviewfeedpage.EmailSchedulerVerify(); }
	 */

	@Test(groups = { "sanity", "regression" }, priority = 26)
	public void ContextSwitchForSameFilter() throws Exception {
		flagreviewfeedpage.ContextSwitchForSameFilter();
	}

	@Test(groups = { "sanity", "regression" }, priority = 27)
	public void VerifyRespondToReview() throws Exception {
		flagreviewfeedpage.VerifyRespondToReview();
	}

	@Test(groups = { "sanity", "regression" }, priority = 28)
	public void VeirfyQueuedReviewstatus() throws Exception {
		flagreviewfeedpage.VeirfyQueuedReviewstatus();
	}

	@Test(groups = { "sanity", "regression" }, priority = 29)
	public void VeirfyFailedReviewstatus() throws Exception {
		flagreviewfeedpage.VeirfyFailedReviewstatus();
	}

	@Test(groups = { "sanity", "regression" }, priority = 30)
	public void VerifyAutomationModeForYelp() throws Exception {
		flagreviewfeedpage.VerifyAutomationModeForYelp();
	}

	@Test(groups = { "sanity", "regression" }, priority = 31)
	public void VerifyFailedStatus() throws Exception {
		flagreviewfeedpage.VerifyFailedStatus();
	}

	@Test(groups = { "sanity", "regression" }, priority = 32)
	public void YelpUpdateManualReviewProcessDialogText() throws Exception {
		flagreviewfeedpage.YelpUpdateManualReviewProcessDialogText();
	}

	@Test(groups = { "sanity", "regression" }, priority = 33)
	public void RatingsFilterDoesNotResetItsValues() throws Exception {
		flagreviewfeedpage.RatingsFilterDoesNotResetItsValues();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();

	}
}

/*
 * * @Test(groups = { "sanity", "regression" }, priority = 10) public void
 * SelectRespondedReview() throws Exception {
 * 
 * flagreviewfeedpage.SelectRespondedReview(); }
 * 
 * @Test(groups = { "sanity", "regression" }, priority = 11) public void
 * FlagIconInResponedReview() throws Exception {
 * 
 * flagreviewfeedpage.FlagIconInResponedReview(); }
 * 
 * @Test(groups = { "sanity", "regression" }, priority = 12) public void
 * GoToFlaggedReviewsforRR() throws Exception {
 * 
 * flagreviewfeedpage.GoToFlaggedReviewsforRR(); }
 * 
 * @Test(groups = { "sanity", "regression" }, priority = 13) public void
 * VerifyFlaggedReviewForRR() throws Exception {
 * 
 * flagreviewfeedpage.VerifyFlaggedReviewForRR(); }
 * 
 * @Test(groups = { "sanity", "regression" }, priority = 14) public void
 * UnflagReviewForRR() throws Exception {
 * 
 * flagreviewfeedpage.UnflagReviewForRR(); }
 * 
 * 
 * @Test(groups = { "sanity", "regression" }, priority = 15) public void
 * VerifyUnflaggedReviewForRR() throws Exception {
 * 
 * flagreviewfeedpage.VerifyUnflaggedReviewForRR(); }
 * 
 * @Test(groups = { "sanity", "regression" }, priority = 16) public void
 * UnflaggedReviewIsPresentInRespondedReview() throws Exception {
 * 
 * flagreviewfeedpage.UnflaggedReviewIsPresentInRespondedReview(); }
 */
