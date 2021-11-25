package com.b1.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.HomePage;
import com.b1.pages.Insight_Pages;
import com.b1.pages.InsightsPage;
import com.b1.pages.LoginPage;
import com.b1.util.TestUtility;
 
@Listeners(TestListener.class)
public class Insight_Pages_test extends TestBase{
	Insight_Pages pages;
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	InsightsPage insightsPage;


	public Insight_Pages_test() throws IOException {
		super();

	}

	@BeforeClass
	public void setup() throws IOException {
		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		pages = new Insight_Pages();
	}

	@Test(priority =1)
	public void clickOnContextAndSelectgeostix2() throws Exception {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();	
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'Cheesecake')]")).getText();
		System.out.println("Location Name : " + LocationName);
	}
	
	/*
	 * @Test(priority = 2) public void VerifySearchLocation_test() throws
	 * InterruptedException { pages.VerifySearchLocation(); }
	 */

	
	@Test(priority = 3)
	public void Insight_Brandscore_SubMenu_test() throws InterruptedException {
		pages.Insight_Brandscore_SubMenu();
	}

	@Test(priority = 4)
	public void VerifyExport_CSV_Brandscore_Leadboard_test() throws InterruptedException {
		pages.VerifyExport_CSV_Leadboard_Brandscore();
		pages.VerifyExport_CSV_Leadboard_Listing();
		pages.VerifyExport_CSV_Leadboard_Review();
		pages.VerifyExport_CSV_Leadboard_Search();
		pages.VerifyExport_CSV_Leadboard_Engagement();
	}

	@Test(priority = 5)
	public void VeifyExport_PDF_Brandscore_Leadboard_test() throws InterruptedException {
		pages.VerifyExport_PDF_Leadboard_Brandscore();
		pages.VerifyExport_PDF_Leadboard_Listing();
		pages.VerifyExport_PDF_Leadboard_Reviews();
		pages.VerifyExport_PDF_Leadboard_Search();
		pages.VerifyExport_PDF_Leadboard_Engagement();
	}

	@Test(priority = 6)
	public void VerifyInsights_Brandscore_test() throws InterruptedException {
		pages.VerifyInsights_Brandscore();
	}

	@Test(priority = 7)
	public void VerifyInsights_Timeline_test() throws InterruptedException {
		pages.VerifyInsights_Timeline();
	}

	@Test(priority = 8)
	public void VerifyExport_TimelineLocations_test() throws InterruptedException {
		pages.VerifyExport_CSV_Timeline_Locations();
		pages.VerifyExport_PDF_Timeline_Locations();
	}

	@Test(priority = 9)
	public void VerifyExport_Timeline_LocationGropus_test() throws InterruptedException {
		pages.VerifyExportCSV_Timeline_locationGroups();
		pages.VerifyExportPDF_Timeline_LocationGroups();
	}

	@Test(priority = 10)
	public void VerifyInsight_Competitors_test() throws InterruptedException {
		pages.VerifyInsight_Competitors();
	}

	@Test(priority = 11)
	public void Insight_Engagement_SubMenu_test() throws InterruptedException {
		pages.Insight_Engagement_SubMenu();
	}

	@Test(priority = 12)
	public void VerifyExport_Engagement_Google_Locations_test() throws InterruptedException {
		pages.VerifyExport_CSV_Engagement_Google_Locations();
		pages.VerifyExport_PDF_Engagement_Google_Locations();
	}

	@Test(priority = 13)
	public void VerifyEngagement_Google_test() throws InterruptedException {
		pages.VerifyEngagement_Google();
	}

	@Test(priority = 14)
	public void VerifyExport_Engagement_Google_LocationGroups_test() throws InterruptedException {
		pages.VerifyExport_CSV_Engagement_Google_LocationGropus();
		pages.VerifyExport_PDF_Engagement_Google_LocationGropus();
	}

	@Test(priority = 15)
	public void VerifyEngagement_Google_Publishers_test() throws InterruptedException {
		pages.VerifyExport_CSV_Engagement_Google_Publishers();
	}

	@Test(priority = 16)
	public void VerifyExport_Engagement_Yelp_Locations_test() throws InterruptedException {
		pages.VerifyExport_CSV_Engagement_Yelp_Locations();
		pages.VerifyExport_PDF_Engagement_Yelp_Locations();

	}

	@Test(priority = 17)
	public void VerifyEngagement_Yelp_test() throws InterruptedException {
		pages.VerifyEngagement_Yelp();
	}

	@Test(priority = 18)
	public void VerifyExport_Engagement_Yelp_LocationGroups_test() throws InterruptedException {
		pages.VerifyExport_CSV_Engagement_Yelp_LocationGroups();
		pages.VerifyExport_PDF_Engagement_Yelp_LocationGroups();
	}

	@Test(priority = 19)
	public void VerifyExport_Engagement_Yelp_Publishers_test() throws InterruptedException {
		pages.VerifyExport_CSV_Engagement_Yelp_publishers();
	}

	@Test(priority = 20)
	public void VerifyExport_Engagement_Facebook_Locations_test() throws InterruptedException {
		pages.VerifyExport_CSV_Engagement_Facebook_Locations();
	}

	@Test(priority = 21)
	public void VerifyEngagement_Facebook_test() throws InterruptedException {
		pages.VerifyEngagement_Facebook();
	}

	@Test(priority = 22)
	public void VerifyExport_Engagement_Facebook_LocationGroups_test() throws InterruptedException {
		pages.VerifyExport_CSV_Engagement_Facebook_LocationGroups();
	}

	@Test(priority = 23)
	public void VerifyExport_Engagement_Facebook_Demographics() throws InterruptedException {
		pages.VerifyExport_CSV_Engagement_Facebook_Demographics1();
		pages.VerifyExport_CSV_Engagement_Facebook_Demographics2();
	}

	@Test(priority = 24)
	public void Insight_EngagementActions_SubMenu_test() throws InterruptedException {
		pages.Insight_EngagementActions_SubMenu();
	}

	@Test(priority = 25)
	public void VerifyExportEngagementActions_Google_Locations_test() throws InterruptedException {
		pages.VerifyExport_CSV_EngagementActions_google_Locations();
		pages.VerifyExport_PDF_EngagementActions_google_Locations();
	}

	@Test(priority = 26)
	public void VerifyEngagementActions_google_test() throws InterruptedException {
		pages.VerifyEngagementActions_google();
	}

	@Test(priority = 27)
	public void VerifyExportEngagementActions_Google_LocationGroups_test() throws InterruptedException {
		pages.VerifyExport_CSV_EngagementActions_Google_LocationGroups();
		pages.VerifyExport_PDF_EngagementActions_Google_LocationGroups();
	}

	@Test(priority = 28)
	public void VerifyExportEngagementActions_Google_Publishers_test() throws InterruptedException {
		pages.VerifyExport_CSV_EngagementActions_Google_Publishers();
	}

	@Test(priority = 29)
	public void VerifyExportEngagementActions_Yelp_Locations_test() throws InterruptedException {
		pages.VerifyExport_CSV_EngagementActions_Yelp_Locations();
		pages.VerifyExport_PDF_EngagementActions_Yelp_Locations();
	}

	@Test(priority = 30)
	public void VerifyEngagementActions_Yelp_test() throws InterruptedException {
		pages.VerifyEngagementActions_Yelp();
	}

	@Test(priority = 31)
	public void VerifyExportEngagementActions_Yelp_LocationGroups_test() throws InterruptedException {
		pages.VerifyExport_CSV_EngagementActions_Yelp_LocationGroups();
		pages.VerifyExport_PDF_EngagementActions_Yelp_LocationGroups();
	}

	@Test(priority = 32)
	public void VerifyExportEngagementActions_Yelp_Publishers_test() throws InterruptedException {
		pages.VerifyExport_CSV_EngagementActions_Yelp_Publishers();
	}

	@Test(priority = 33)
	public void VerifyExportEngagementActions_Facebook_Locations_test() throws InterruptedException {
		pages.VerifyExport_CSV_EngagementActions_Facebook_Locations();
	}

	@Test(priority = 34)
	public void VerifyEngagementActions_Facebook_test() throws InterruptedException {
		pages.VerifyEngagementActions_Facebook();
	}

	@Test(priority = 35)
	public void VerifyExportEngagementActions_Facebook_LocationGroups_test() throws InterruptedException {
		pages.VerifyExport_CSV_EngagementActions_Facebook_LocationGroups();
	}

	@Test(priority = 36)
	public void Insight_LocalPage_SubMenu_test() throws InterruptedException {
		pages.Insight_LocalPage_SubMenu();
	}

	@Test(priority = 37)
	public void VerifyExport_LocalPages_Locations_test() throws InterruptedException {
		pages.Verify_CSV_LocalPages_Locations();
	}

	@Test(priority = 38)
	public void VerifyExport_LocalPages__LocationGroups_test() throws InterruptedException {
		pages.Verify_CSV_LocalPages_LocationGroups();
	}

	@Test(priority = 39)
	public void VerifyExport_LocalPages__Devices_test() throws InterruptedException {
		pages.Verify_CSV_LocalPages_Devices();
	}	 
	  
	@Test(priority = 40)
	public void Insight_Ratings_SubMenu_test() throws InterruptedException {
		pages.Insight_Ratings_SubMenu();
	}

	@Test(priority = 41)
	public void VerifyRatings_ShareByEmail_test() throws InterruptedException {
		pages.VerifyRatings_ShareByEmail();
	}

	@Test(priority = 42)
	public void VerifyExport_Ratings_Sentiment_Locations_test() throws InterruptedException {
		pages.VerifyExport_CSV_Ratings_Sentiment_Locations();
		pages.VerifyExport_PDF_Ratings_Sentiment_Locations();
	}

	@Test(priority = 43)
	public void Verify_Ratings_Sentiment_test() throws InterruptedException {
		pages.Verify_Ratings_Sentiment();
	}

	@Test(priority = 44)
	public void VerifyExport_Ratings_sentiment_LocationGroups() throws InterruptedException {
		pages.VerifyExport_CSV_Ratings_Sentiment_LocationGroups();
		pages.VerifyExport_PDF_Ratings_Sentiment_LocationGroups();
	}

	@Test(priority = 45)
	public void VerifyExport_Ratings_Sentiment_Publishers() throws InterruptedException {
		pages.VerifyExport_CSV_Ratings_Sentiment_Publishers();
	}
	 

		@Test(priority = 46)
		public void VerifyExport_Ratings_StarRating_Locations() throws InterruptedException {
			pages.VerifyExport_CSV_Ratings_StarRating_Locations();
			pages.VerifyExport_PDF_Ratings_StarRating_Locations();
		}
		  
		@Test(priority = 47)
		public void VerifyExport_Ratings_StarRating_LocationGroups() throws InterruptedException {
			pages.VerifyExport_CSV_Ratings_StarRating_LocationGroups();
			pages.VerifyExport_PDF_Ratings_StarRating_LocationGroups();
		}

		@Test(priority = 48)
		public void VerifyExport_Ratings_StarRating_Publishers() throws InterruptedException {
			pages.VerifyExport_CSV_Ratings_StarRating_Publishers();
		}

		@Test(priority = 49)
		public void Insight_Responses_SubMenu_test() throws InterruptedException {
			pages.Insight_Responses_SubMenu();
		}

		@Test(priority = 50)
		public void Verify_Respnses_ShareByEmail_test() throws InterruptedException {
			pages.Verify_Responses_ShareByEmail();
		}

		@Test(priority = 51)
		public void VerifyExport_Responses_Locations_test() throws InterruptedException {
			pages.VerifyExportCSV_Responses_Locations();
			pages.VerifyExport_PDF_Responses_Locations();
		}

		@Test(priority = 52)
		public void VerifyRespnses_test() throws InterruptedException {
			pages.VerifyRespnses();
		}

		@Test(priority = 53)
		public void VerifyExport_Responses_LocationGroups() throws InterruptedException {
			pages.VerifyExport_CSV_Responses_LocationGroups();
			pages.VerifyExport_PDF_Responses_LocationGroups();
		}

		@Test(priority = 54)
		public void VerifyExport_Responses_Publishers() throws InterruptedException {
			pages.VerifyExport_CSV_Responses_Publishers();
		}

		@Test(priority = 55)
		public void Insight_Sentiment_SubMenu_test() throws InterruptedException {
			pages.Insight_Sentiment_SubMenu();
		}

		@Test(priority = 56)
		public void Verify_Sentiment_ShareByEmail_test() throws InterruptedException {
			pages.Verify_Sentiment_ShareByEmail();
		}

		@Test(priority = 57)
		public void VerifyExport_Sentiment_AllTopics_test() throws InterruptedException {
			pages.VerifyExport_CSV_Sentiment_AllTopics();
			//pages.VerifyExport_PDF_Sentiment_AllTopics();

		}

		@Test(priority = 58)
		public void VerifySentimnet_test() throws InterruptedException {
			pages.VerifySentimnet();
		}

		@Test(priority = 59)
		public void VerifyExport_Sentiment_MonitoredTopics() throws InterruptedException {
			pages.VerifyExport_CSV_Sentiment_monitoredTopics();
			//pages.VerifyExport_PDF_Sentiment_monitoredTopics();
		}

		@Test(priority = 60)
		public void VerifyTopic_cloud_test() throws InterruptedException {
			pages.VerifyTopic_cloud();
		}
		
		@AfterClass
		public void down() throws InterruptedException {
			Thread.sleep(3000);
			driver.quit();

		}

	}
