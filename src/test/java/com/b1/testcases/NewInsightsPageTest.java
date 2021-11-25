package com.b1.testcases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.NewInsightsPage;

 
@Listeners(TestListener.class)
public class NewInsightsPageTest extends TestBase  {
	NewInsightsPage newInsightsPage;
	//LoginPage loginPage;
	//HomePage homePage;
	public NewInsightsPageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {
		//initialization();
		BrowserStack_Invocation();
		//loginPage = new LoginPage();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		newInsightsPage = new NewInsightsPage();
	}

	/*
	 * @Test(priority =1) public void clickOnContextAndSelectgeostix2() throws
	 * Exception { Thread.sleep(5000); homePage.clickOnContextAndSelectCheesecake();
	 * String LocationName =
	 * driver.findElement(By.xpath("//div[contains(text(),'Cheesecake')]")).getText(
	 * ); System.out.println("Location Name : " + LocationName); }
	 */
	
	
	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void VerifyOneStagingLogin_test() throws InterruptedException {
		newInsightsPage.VerifyOneStagingLogin();
		newInsightsPage.VerifySearchLocation();
	}
	  
	  @Test(groups = { "sanity", "regression" }, priority = 2) public void
	  CheckMenuPresent() throws InterruptedException {
	  newInsightsPage.InsightsPresentOptions();
	  
	  }
	  
	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void VerifyClickOnBrandscore() throws InterruptedException {
		newInsightsPage.ClickOnBrandscore();

	}

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void VerifyReportOnTotalBrandScore() throws InterruptedException {
		newInsightsPage.CheckReportOnTotalBrandScore();

	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void VerifyReportGeneratedOnTopList() {
		newInsightsPage.VerifyReportGeneratedOnTopList();

	}

	@Test(groups = { "sanity", "regression" }, priority = 6)
	public void VerifyReportGeneratedOnBottomList() throws InterruptedException {
		newInsightsPage.VerifyReportGeneratedOnBottomList();

	}

	@Test(groups = { "sanity", "regression" }, priority = 7)
	public void VerifyCheckListingsBrandScore() throws InterruptedException {
		newInsightsPage.CheckListingsBrandScore();

	}

	@Test(groups = { "sanity", "regression" }, priority = 8)
	public void VerifyReportGeneratedOnTopListOfListings() throws InterruptedException {
		newInsightsPage.VerifyReportGeneratedOnTopListOfListings();

	}

	@Test(groups = { "sanity", "regression" }, priority = 9)
	public void VerifyReportGeneratedOnBottomListOfListings() throws InterruptedException {
		newInsightsPage.VerifyReportGeneratedOnBottomListOfListings();

	}

	@Test(groups = { "sanity", "regression" }, priority = 10)
	public void VerifyCheckEngagementBrandScore() throws InterruptedException {
		newInsightsPage.CheckEngagementBrandScore();

	}

	@Test(groups = { "sanity", "regression" }, priority = 11)
	public void VerifyReportGeneratedOnTopListOfEngagement() throws InterruptedException {
		newInsightsPage.VerifyReportGeneratedOnTopListOfEngagement();

	}

	@Test(groups = { "sanity", "regression" }, priority = 12)
	public void VerifyReportGeneratedOnBottomListOfEngagement() throws InterruptedException {
		newInsightsPage.VerifyReportGeneratedOnBottomListOfEngagement();

	}

	@Test(groups = { "sanity", "regression" }, priority = 13)
	public void VerifyCheckReviewsBrandScore() throws InterruptedException {
		newInsightsPage.CheckReviewsBrandScore();

	}

	@Test(groups = { "sanity", "regression" }, priority = 14)
	public void VerifyReportGeneratedOnTopListOfReviews() throws InterruptedException {
		newInsightsPage.VerifyReportGeneratedOnTopListOfReviews();

	}

	@Test(groups = { "sanity", "regression" }, priority = 15)
	public void VerifyReportGeneratedOnBottomListOfReviews() throws InterruptedException {
		newInsightsPage.VerifyReportGeneratedOnBottomListOfReviews();

	}

	@Test(groups = { "sanity", "regression" }, priority = 16)
	public void VerifyCheckSearchBrandScore() throws InterruptedException {
		newInsightsPage.CheckSearchBrandScore();

	}

	@Test(groups = { "sanity", "regression" }, priority = 17)
	public void VerifyReportGeneratedOnTopListOfSearch() throws InterruptedException {
		newInsightsPage.VerifyReportGeneratedOnTopListOfSearch();

	}

	@Test(groups = { "sanity", "regression" }, priority = 18)
	public void VerifyReportGeneratedOnBottomListOfSearch() throws InterruptedException {
		newInsightsPage.VerifyReportGeneratedOnBottomListOfSearch();

	}

	@Test(groups = { "sanity", "regression" }, priority = 19)
	public void ClickOnEngagement() throws InterruptedException {
		newInsightsPage.ClickOnEngagement();
	}

	@Test(groups = { "sanity", "regression" }, priority = 20)
	public void VerifyEngagementPageTitle() throws InterruptedException {
		newInsightsPage.VerifyEngagementPageTitle();

	}

	@Test(groups = { "sanity", "regression" }, priority = 21)
	public void VerifyEngagementPageActions() throws InterruptedException {
		newInsightsPage.VerifyEngagementPageActions();

	}

	@Test(groups = { "sanity", "regression" }, priority = 22)
	public void VerifyEngagementHeaderDateAndExport() throws InterruptedException {
		newInsightsPage.VerifyEngagementHeaderDateAndExport();

	}

	@Test(groups = { "sanity", "regression" }, priority = 23)
	public void VerifyEngagementGraphDetailsWithDate() throws InterruptedException {
		newInsightsPage.VerifyEngagementGraphDetailsWithDate();

	}

	@Test(groups = { "sanity", "regression" }, priority = 24)
	public void VerifyEngagementLocationTable() throws InterruptedException {
		newInsightsPage.VerifyEngagementLocationTable();

	}

	@Test(groups = { "sanity", "regression" }, priority = 25)
	public void VerifyEngagementLocationGroupTable() throws InterruptedException {
		newInsightsPage.VerifyEngagementLocationGroupTable();

	}

	@Test(groups = { "sanity", "regression" }, priority = 26)
	public void VerifyShowCountNumberStatus() throws InterruptedException {
		newInsightsPage.VerifyShowCountNumberStatus();

	}

	@Test(groups = { "sanity", "regression" }, priority = 27)
	public void VerifyEngagementPublishersTable() throws InterruptedException {
		newInsightsPage.VerifyEngagementPublishersTable();

	}

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 28) public void
	 * ClickOnEngagement_Actions() throws InterruptedException {
	 * newInsightsPage.ClickOnEngagement_Actions(); }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 29) public void
	 * VerifyEngagement_ActionsPageTitle() throws InterruptedException {
	 * newInsightsPage.VerifyEngagement_ActionsPageTitle();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 30) public void
	 * VerifyEngagement_ActionsPageAction() throws InterruptedException {
	 * newInsightsPage.VerifyEngagement_ActionsPageAction();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 31) public void
	 * VerifyEngagement_ActionsHeaderDateAndExport() throws InterruptedException {
	 * newInsightsPage.VerifyEngagement_ActionsHeaderDateAndExport();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 32) public void
	 * VerifyEngagement_ActionsGraphDetailsWithDate() throws InterruptedException {
	 * newInsightsPage.VerifyEngagement_ActionsGraphDetailsWithDate();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 33) public void
	 * VerifyEngagement_ActionsLocation() throws InterruptedException {
	 * newInsightsPage.VerifyEngagement_ActionsLocation();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 34) public void
	 * VerifyEngagement_ActionsLocationGroup() throws InterruptedException {
	 * newInsightsPage.VerifyEngagement_ActionsLocationGroup();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 35) public void
	 * VerifyEngagement_ActionsShowCountNumberStatus() throws InterruptedException {
	 * newInsightsPage.VerifyEngagement_ActionsShowCountNumberStatus();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 36) public void
	 * VerifyEngagement_ActionsPublishers() throws InterruptedException {
	 * newInsightsPage.VerifyEngagement_ActionsPublishers();
	 * 
	 * }
	 */

	@Test(groups = { "sanity", "regression" }, priority = 37)
	public void ClickOnResponses() throws InterruptedException {
		newInsightsPage.ClickOnResponses();
	}

	@Test(groups = { "sanity", "regression" }, priority = 38)
	public void VerifyResponsesPageTitle() throws InterruptedException {
		newInsightsPage.VerifyResponsesPageTitle();

	}

	@Test(groups = { "sanity", "regression" }, priority = 39)
	public void VerifyResponsesPageAction() throws InterruptedException {
		newInsightsPage.VerifyResponsesPageAction();

	}

	@Test(groups = { "sanity", "regression" }, priority = 40)
	public void VerifyResponses_HeaderDateAndExport() throws InterruptedException {
		newInsightsPage.VerifyResponses_HeaderDateAndExport();

	}

	@Test(groups = { "sanity", "regression" }, priority = 41)
	public void VerifyResponses_GraphDetailsWithDate() throws InterruptedException {
		newInsightsPage.VerifyResponses_GraphDetailsWithDate();

	}

	@Test(groups = { "sanity", "regression" }, priority = 42)
	public void VerifyResponses_Location() throws InterruptedException {
		newInsightsPage.VerifyResponses_Location();

	}

	@Test(groups = { "sanity", "regression" }, priority = 43)
	public void VerifyResponses_LocationGroup() throws InterruptedException {
		newInsightsPage.VerifyResponses_LocationGroup();

	}

	@Test(groups = { "sanity", "regression" }, priority = 44)
	public void VerifyResponses_Publisher() throws InterruptedException {
		newInsightsPage.VerifyResponses_Publisher();

	}

	@Test(groups = { "sanity", "regression" }, priority = 45)
	public void VerifyResponses_ShowCountNumberStatus() throws InterruptedException {
		newInsightsPage.VerifyResponses_ShowCountNumberStatus();

	}

	@Test(groups = { "sanity", "regression" }, priority = 46)
	public void ClickOnRatings() throws InterruptedException {
		newInsightsPage.ClickOnRatings();

	}

	@Test(groups = { "sanity", "regression" }, priority = 47)
	public void VerifyRatings_PageTitle() throws InterruptedException {
		newInsightsPage.VerifyRatings_PageTitle();

	}

	@Test(groups = { "sanity", "regression" }, priority = 48)
	public void VerifyRatings_PageAction() throws InterruptedException {
		newInsightsPage.VerifyRatings_PageAction();

	}

	@Test(groups = { "sanity", "regression" }, priority = 49)
	public void VerifyRatings_HeaderDateAndExport() throws InterruptedException {
		newInsightsPage.VerifyRatings_HeaderDateAndExport();

	}

	@Test(groups = { "sanity", "regression" }, priority = 50)
	public void VerifyRatings_GraphDetailsWithDate() throws InterruptedException {
		newInsightsPage.VerifyRatings_GraphDetailsWithDate();

	}

	@Test(groups = { "sanity", "regression" }, priority = 51)
	public void VerifyRatings_Location() throws InterruptedException {
		newInsightsPage.VerifyRatings_Location();

	}

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 52) public void
	 * VerifyRatings_LocationGroup() throws InterruptedException {
	 * newInsightsPage.VerifyRatings_LocationGroup();
	 * 
	 * }
	 */
	@Test(groups = { "sanity", "regression" }, priority = 53)
	public void VerifyRatings_Publishers() throws InterruptedException {
		newInsightsPage.VerifyRatings_Publishers();

	}

	@Test(groups = { "sanity", "regression" }, priority = 54)
	public void VerifyRatings_ShowCountNumberStatus() throws InterruptedException {
		newInsightsPage.VerifyRatings_ShowCountNumberStatus();

	}

	@Test(groups = { "sanity", "regression" }, priority = 55)
	public void ClickOnSentiment() throws InterruptedException {
		newInsightsPage.ClickOnSentiment();
	}

	@Test(groups = { "sanity", "regression" }, priority = 56)
	public void VerifySentiment_PageTitle() throws InterruptedException {
		newInsightsPage.VerifySentiment_PageTitle();

	}

	@Test(groups = { "sanity", "regression" }, priority = 57)
	public void VerifySentiment_ChartOptions() {
		newInsightsPage.VerifySentiment_ChartOptions();

	}

	@Test(groups = { "sanity", "regression" }, priority = 58)
	public void VerifySentiment_PageGraph() throws InterruptedException {
		newInsightsPage.VerifySentiment_PageGraph();

	}

	@Test(groups = { "sanity", "regression" }, priority = 59)
	public void VerifySentiment_HeaderDateAndExport() throws InterruptedException {
		newInsightsPage.VerifySentiment_HeaderDateAndExport();

	}

	@Test(groups = { "sanity", "regression" }, priority = 60)
	public void VerifySentiment_GraphDetailsWithDate() throws InterruptedException {
		newInsightsPage.VerifySentiment_GraphDetailsWithDate();

	}

	@Test(groups = { "sanity", "regression" }, priority = 61)
	public void VerifySentiment_AllTopic() throws InterruptedException {
		newInsightsPage.VerifySentiment_AllTopic();

	}

	@Test(groups = { "sanity", "regression" }, priority = 62)
	public void VerifySentiment_MonitoredTopics() throws InterruptedException {
		newInsightsPage.VerifySentiment_MonitoredTopics();

	}

	@Test(groups = { "sanity", "regression" }, priority = 63)
	public void VerifySentiment_ShowCountNumberStatus() throws InterruptedException {
		newInsightsPage.VerifySentiment_ShowCountNumberStatus();

	}
	 

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 64) public void
	 * ClickOnSearchPositions() throws InterruptedException {
	 * newInsightsPage.ClickOn_SearchPositions(); }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 65) public void
	 * VerifySearchPositions_PageTitle() throws InterruptedException {
	 * newInsightsPage.VerifySearchPositions_PageTitle();
	 * 
	 * }
	 * 
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 66) public void
	 * VerifySearchPositions_SearchPublishers() throws InterruptedException {
	 * newInsightsPage.VerifySearchPositions_SearchPublishers();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 67) public void
	 * VerifySearchPositions_PageGraphForGL() throws InterruptedException {
	 * newInsightsPage.VerifySearchPositions_PageGraphForGL();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 68) public void
	 * VerifySearchPositions_HeaderDateAndExportFor_GL() throws InterruptedException
	 * { newInsightsPage.VerifySearchPositions_HeaderDateAndExportFor_GL();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 69) public void
	 * VerifySearchPositions_GraphDetailsWithDateForGL() throws InterruptedException
	 * { newInsightsPage.VerifySearchPositions_GraphDetailsWithDateForGL();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 70) public void
	 * VerifySearchPositions_LocationForGL() throws InterruptedException {
	 * newInsightsPage.VerifySearchPositions_LocationForGL();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 71) public void
	 * VerifySearchPositions_LocationGroupForGL() throws InterruptedException {
	 * newInsightsPage.VerifySearchPositions_LocationGroupForGL();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 72) public void
	 * VerifySearchPositions_ShowCountNumberStatusForGL() throws
	 * InterruptedException {
	 * newInsightsPage.VerifySearchPositions_ShowCountNumberStatusForGL();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 73) public void
	 * VerifySearchPositions_PageGraphForGO() throws InterruptedException {
	 * newInsightsPage.VerifySearchPositions_PageGraphForGO();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 74) public void
	 * VerifySearchPositions_HeaderDateAndExportFor_GO() throws InterruptedException
	 * { newInsightsPage.VerifySearchPositions_HeaderDateAndExportFor_GO();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 75) public void
	 * VerifySearchPositions_GraphDetailsWithDateForGO() throws InterruptedException
	 * { newInsightsPage.VerifySearchPositions_GraphDetailsWithDateForGO();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 76) public void
	 * VerifySearchPositions_LocationGroupForGo() throws InterruptedException {
	 * newInsightsPage.VerifySearchPositions_LocationGroupForGo();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 77) public void
	 * VerifySearchPositions_LocationForGO() throws InterruptedException {
	 * newInsightsPage.VerifySearchPositions_LocationForGO();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 78) public void
	 * VerifySearchPositions_ShowCountNumberStatusForGO() throws
	 * InterruptedException {
	 * newInsightsPage.VerifySearchPositions_ShowCountNumberStatusForGO();
	 * 
	 * }
	 */
	  
	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 64) public void
	 * ClickOn_Reports() throws InterruptedException {
	 * newInsightsPage.ClickOn_Reports();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 65) public void
	 * Verify_ReportData() throws InterruptedException {
	 * newInsightsPage.Verify_ReportData();
	 * 
	 * }
	 * 
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 65) public void
	 * Verify_ClickOnCreateNewReport() {
	 * newInsightsPage.Verify_ClickOnCreateNewReport();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 66) public void
	 * Verify_ManageReport() throws InterruptedException {
	 * newInsightsPage.Verify_ManageReport();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 67) public void
	 * Verify_CreateNewReport() throws InterruptedException {
	 * newInsightsPage.Verify_CreateNewReport();
	 * 
	 * }
	 */
	  
	@Test(groups = { "sanity", "regression" }, priority = 64)
	public void ClickOn_SearchKeywords() throws InterruptedException {
		newInsightsPage.ClickOn_SearchKeywords();
	}

	@Test(groups = { "sanity", "regression" }, priority = 65)
	public void VerifySearchKeywords_PageTitle() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_PageTitle();

	}

	@Test(groups = { "sanity", "regression" }, priority = 66)
	public void VerifySearchKeywords_SearchPublishers() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_SearchPublishers();

	}

	@Test(groups = { "sanity", "regression" }, priority = 67)
	public void VerifySearchKeywords_PageGraphForGL() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_PageGraphForGL();

	}

	@Test(groups = { "sanity", "regression" }, priority = 68)
	public void VerifySearchKeywords_HeaderDateAndExportFor_GL() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_HeaderDateAndExportFor_GL();

	}

	@Test(groups = { "sanity", "regression" }, priority = 69)
	public void VerifySearchKeywords_GraphDetailsWithDateForGL() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_GraphDetailsWithDateForGL();

	}

	@Test(groups = { "sanity", "regression" }, priority = 70)
	public void VerifySearchKeywords_LocationForGL() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_LocationForGL();

	}

	@Test(groups = { "sanity", "regression" }, priority = 71)
	public void VerifySearchKeywords_LocationGroupForGL() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_LocationGroupForGL();

	}

	@Test(groups = { "sanity", "regression" }, priority = 72)
	public void VerifySearchKeywords_ShowCountNumberStatusForGL() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_ShowCountNumberStatusForGL();

	}

	@Test(groups = { "sanity", "regression" }, priority = 73)
	public void VerifySearchKeywords_PageGraphForGO() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_PageGraphForGO();

	}

	@Test(groups = { "sanity", "regression" }, priority = 74)
	public void VerifySearchKeywords_HeaderDateAndExportFor_GO() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_HeaderDateAndExportFor_GO();

	}

	@Test(groups = { "sanity", "regression" }, priority = 75)
	public void VerifySearchKeywords_GraphDetailsWithDateForGO() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_GraphDetailsWithDateForGO();

	}

	@Test(groups = { "sanity", "regression" }, priority = 76)
	public void VerifySearchKeywords_LocationGroupForGo() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_LocationGroupForGo();

	}

	@Test(groups = { "sanity", "regression" }, priority = 77)
	public void VerifySearchKeywords_LocationForGO() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_LocationForGO();

	}

	@Test(groups = { "sanity", "regression" }, priority = 78)
	public void VerifySearchKeywords_ShowCountNumberStatusForGO() throws InterruptedException {
		newInsightsPage.VerifySearchKeywords_ShowCountNumberStatusForGO();

	}
	
	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 99) public void
	 * VerifySearchKeywords_GoToPublisher() throws InterruptedException {
	 * newInsightsPage.VerifySearchKeywords_GoToPublisher();
	 * 
	 * }
	 * 
	 * @Test(groups = { "sanity", "regression" }, priority = 100) public void
	 * VerifySearchKeywords_VerifyPublisherTable() throws InterruptedException {
	 * newInsightsPage.VerifySearchKeywords_VerifyPublisherTable();
	 * 
	 * }
	 */
	 
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();

	}
}
