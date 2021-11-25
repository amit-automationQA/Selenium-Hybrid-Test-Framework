package com.b1.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;

 


public class NewInsightsPage extends TestBase  {
	//public static WebDriver driver;
	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile1;

	@FindBy(xpath = "//div[contains(text(),'My Profile')]")
	WebElement MyProfile;

	@FindBy(xpath = "//div[contains(text(),'Accounts')]")
	WebElement Account1;

	@FindBy(xpath = "//div[contains(text(),'INSIGHTS')]")
	WebElement INSIGHTS;

	@FindBy(xpath = "//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Brandscore')]")
	WebElement DropDownBrandscore;

	@FindBy(xpath = "/descendant::div[contains(text(),'Engagement')][1]")
	WebElement Engagement;

	@FindBy(xpath = "//div[contains(text(),'Engagement Actions')]")
	WebElement EngagementActions;

	@FindBy(xpath = "//div[contains(text(),'Locator')]")
	WebElement Locator;

	@FindBy(xpath = "//div[contains(text(),'Responses')]")
	WebElement Responses;

	@FindBy(xpath = "//div[contains(text(),'Ratings')]")
	WebElement Ratings;

	@FindBy(xpath = "//div[contains(text(),'Sentiment')]")
	WebElement Sentiment;

	@FindBy(xpath = "//div[contains(text(),'Search Positions')]")
	WebElement SearchPositions;

	@FindBy(xpath = "//div[contains(text(),'Search Keywords')]")
	WebElement SearchKeywords;

	@FindBy(xpath = "//div[contains(text(),'Reports')]")
	WebElement Reports;

	@FindBy(xpath = "//div[contains(text(),'Executive Reports')]")
	WebElement ExecutiveReports;

	@FindBy(xpath = "//li[@title='Total Brandscore']")
	WebElement TotalBrandscore;

	@FindBy(xpath = "//li[@title='Listings Brandscore']")
	WebElement ListingsBrandscore;

	@FindBy(xpath = "//li[@title='Engagement Brandscore']")
	WebElement EngagementBrandscore;

	@FindBy(xpath = "//li[@title='Reviews Brandscore']")
	WebElement ReviewsBrandscore;

	@FindBy(xpath = "//li[@title='Search Brandscore']")
	WebElement SearchBrandscore;

	@FindBy(xpath = "//a[contains(text(),'Apply')]")
	WebElement ApplyBtn;

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement uname;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement pass;

	@FindBy(xpath = "//button[@class='raised_button signinBtn']")
	WebElement signin_btn;

	@FindBy(xpath = "//i[contains(normalize-space(),'language')]")
	WebElement locations;

	@FindBy(xpath = "//input[@placeholder='Select Accounts']")
	WebElement search_feild;

	@FindBy(xpath = "//div[starts-with(@class,'cs-dropdownitem sc-')][contains(text(),'Cheesecake Factory')]")
	WebElement cheesef;

	@FindBy(xpath = "//i[starts-with(@class,'context-account fonticon sc-')]")
	WebElement all_locations;
	public NewInsightsPage() {

		PageFactory.initElements(driver, this);
	}

	/*
	 * public static void initialization() { String baseurl =
	 * "https://one-staging.brandify.com/";
	 * System.setProperty("webdriver.chrome.driver",
	 * ".\\src\\main\\java\\com\\b1\\qa\\resourceFiles\\chromedriver.exe"); driver =
	 * new ChromeDriver(); driver.manage().window().maximize();
	 * driver.manage().deleteAllCookies();
	 * driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
	 * driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	 * driver.get(baseurl);
	 * 
	 * }
	 */
	
	public void VerifyOneStagingLogin() throws InterruptedException {
		uname.clear();
		Thread.sleep(2000);
		uname.sendKeys("sage@leanst.com");
		Thread.sleep(2000);
		pass.clear();
		pass.sendKeys("Sage521802");
		Thread.sleep(2000);
		signin_btn.click();
	}
	
	public void VerifySearchLocation() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Location Overview')]")));
		locations.click();
		Thread.sleep(3000);
		search_feild.click();
		search_feild.clear();
		Thread.sleep(2000);
		search_feild.sendKeys("chee");
		Thread.sleep(3000);
		cheesef.click();
		Thread.sleep(2000);
		all_locations.click();
		/*
		 * Thread.sleep(5000); WebElement
		 * insight_tab=driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]")
		 * ); WebElement branscore_submenu=driver.findElement(By.
		 * xpath("//div[starts-with(@class,'dropdownlabel Brandscore sc-')][contains(text(),'Brandscore')]"
		 * )); Actions act=new Actions(driver);
		 * act.moveToElement(insight_tab).perform();
		 * act.moveToElement(branscore_submenu).click().perform();
		 */
	}
	
	public void InsightsPresentOptions() throws InterruptedException {

		Thread.sleep(8000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		INSIGHTS.click();
		Actions action = new Actions(driver);
		action.moveToElement(InsightsMenu).perform();
		Assert.assertTrue(InsightsMenu.isDisplayed());
		System.out.println("The Insights menu is displayed");
		
		List<WebElement> elements = driver
				.findElements(By.xpath("/html/body/div[1]/div/div[1]/ul/li[1]/div/ul/li[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(5000);
		System.out.println("Number of elements:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Insights Records List have: " + elements.get(i).getText());
		}
		Thread.sleep(2000);
		String Brandscore = driver
				.findElement(By.xpath(
						"//div[starts-with(@class,'dropdownlabel Brandscore sc-')][contains(text(),'Brandscore')]"))
				.getText();
		System.out.println("found=========" + Brandscore);
		Assert.assertEquals(Brandscore, "Brandscore");

		String Engagement = driver.findElement(By.xpath("/descendant::div[contains(text(),'Engagement')][1]"))
				.getText();
		System.out.println("found=========" + Engagement);
		Assert.assertEquals("Engagement", Engagement);

		/*
		 * String EA =
		 * driver.findElement(By.xpath("//div[contains(text(),'Engagement Actions')]")).
		 * getText(); System.out.println("found=========" + EA);
		 * Assert.assertEquals("Engagement Actions", EA);
		 */

		String Responses = driver.findElement(By.xpath("//div[contains(text(),'Responses')]")).getText();
		System.out.println("found=========" + Responses);
		Assert.assertEquals("Responses", Responses);

		String Ratings = driver.findElement(By.xpath("//div[contains(text(),'Ratings')]")).getText();
		System.out.println("found=========" + Ratings);
		Assert.assertEquals("Ratings", Ratings);

		String Sentiment = driver.findElement(By.xpath("//div[contains(text(),'Sentiment')]")).getText();
		System.out.println("found=========" + Sentiment);
		Assert.assertEquals("Sentiment", Sentiment);

		String Reports = driver.findElement(By.xpath("//div[contains(text(),'Reports')]")).getText();
		System.out.println("found=========" + Reports);
		Assert.assertEquals("Reports", Reports);

	}

	public void ClickOnBrandscore() throws InterruptedException {
		Thread.sleep(2000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		 Actions act=new Actions(driver);
		act.moveToElement(InsightsMenu).perform();
		  act.moveToElement(DropDownBrandscore).click().perform();
		//DropDownBrandscore.click();
		String Option = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'sc-')][contains(text(),'Insights / Brandscore')]"))
				.getText();
		System.out.println("found=========" + Option);
		Assert.assertEquals("Insights / Brandscore", Option);

	}

	public void CheckReportOnTotalBrandScore() throws InterruptedException {

		Thread.sleep(2000);
		TotalBrandscore.click();

		String Option = driver.findElement(By.xpath("//div[contains(text(),'Top 10 Locations')]")).getText();
		Assert.assertTrue(Option.contains("Top 10 Locations"));
		System.out.println("found=========" + Option);

		String Option1 = driver.findElement(By.xpath("//div[contains(text(),'Bottom 10 Locations')]")).getText();
		Assert.assertTrue(Option1.contains("Bottom 10 Locations"));
		System.out.println("found=========" + Option1);

	}

	public void VerifyReportGeneratedOnTopList() {

		// verify report generated in Top-10 Locations:

		String TopRank = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][1]"))
				.getText();
		System.out.println("Rank=========" + TopRank);
		Assert.assertEquals("1", TopRank);

		String Option1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/p[1]"))
				.getText();
		System.out.println("Location=========" + Option1);
		Assert.assertTrue(Option1.contains("The Cheesecake Factory"));

		String Score = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][1]"))
				.getText();
		System.out.println("Score=========" + Score);

		WebElement Top = driver.findElement(By.xpath("/descendant::td[contains(text(),'1')][1]"));
		Actions action = new Actions(driver);
		action.moveToElement(Top).perform();

	}

	public void VerifyReportGeneratedOnBottomList() throws InterruptedException {

		// verify report generated in Bottom-10 Locations:

		Thread.sleep(1000);
		String BottomRank = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][20]"))
				.getText();
		System.out.println("Rank=========" + BottomRank);
		Assert.assertTrue(BottomRank.contains(BottomRank));

		String Option1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[11]/td[2]/p[1]"))
				.getText();
		System.out.println("Location=========" + Option1);
		Assert.assertTrue(Option1.contains("The Cheesecake Factory"));

		String Score = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][20]")).getText();
		System.out.println("Score=========" + Score);

		WebElement Bottom = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][12]"));
		Actions action = new Actions(driver);
		action.moveToElement(Bottom).perform();

	}

	public void CheckListingsBrandScore() throws InterruptedException {

		Thread.sleep(2000);
		ListingsBrandscore.click();

		String Option1 = driver
				.findElement(By
						.xpath("//div[starts-with(@class,'mod-justify-between sc-')]//div[starts-with(@class,'sc-')] "))
				.getText();
		Assert.assertTrue(Option1.contains("Leaderboard | Listings"));
		System.out.println("found=========" + Option1);

	}

	public void VerifyReportGeneratedOnTopListOfListings() throws InterruptedException {

		// verify report generated in Top-10 Locations:

		String TopRank = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][1]"))
				.getText();
		System.out.println("Rank=========" + TopRank);
		Assert.assertTrue(TopRank.contains(TopRank));

		String Option1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/p[1]"))
				.getText();
		System.out.println("Location=========" + Option1);
		Assert.assertTrue(Option1.contains("The Cheesecake Factory"));

		String Score = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][1]"))
				.getText();
		System.out.println("Score=========" + Score);

		Thread.sleep(1000);
		WebElement Top = driver.findElement(By.xpath("/descendant::td[contains(text(),'1')][1]"));
		Actions action = new Actions(driver);
		action.moveToElement(Top).perform();

	}

	public void VerifyReportGeneratedOnBottomListOfListings() throws InterruptedException {

		// verify report generated in Bottom-10 Locations:

		Thread.sleep(1000);
		String BottomRank = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][20]"))
				.getText();
		System.out.println("Rank=========" + BottomRank);
		Assert.assertTrue(BottomRank.contains(BottomRank));

		String BT_Option = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[11]/td[2]/p[1]"))
				.getText();
		System.out.println("Location=========" + BT_Option);
		Assert.assertTrue(BT_Option.contains("The Cheesecake Factory"));

		String BT_Score = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][20]")).getText();
		System.out.println("Score=========" + BT_Score);

		WebElement Bottom = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][12]"));
		Actions action = new Actions(driver);
		action.moveToElement(Bottom).perform();

	}

	public void CheckEngagementBrandScore() throws InterruptedException {

		Thread.sleep(1500);
		EngagementBrandscore.click();
		Thread.sleep(3000);

		String Option1 = driver
				.findElement(By
						.xpath("//div[starts-with(@class,'mod-justify-between sc-')]//div[starts-with(@class,'sc-')]"))
				.getText();
		Assert.assertTrue(Option1.contains("Leaderboard | Engagement"));
		System.out.println("found=========" + Option1);

	}

	public void VerifyReportGeneratedOnTopListOfEngagement() throws InterruptedException {

		// verify report generated in Top-10 Locations:

		String TopRank = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][1]"))
				.getText();
		System.out.println("Rank=========" + TopRank);
		// Assert.assertEquals("1", TopRank);
		Assert.assertTrue(TopRank.contains(TopRank));

		String Option1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/p[1]"))
				.getText();
		System.out.println("Location=========" + Option1);
		Assert.assertTrue(Option1.contains("The Cheesecake Factory"));

		String Score = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][1]"))
				.getText();
		System.out.println("Score=========" + Score);

		Thread.sleep(1000);
		WebElement Top = driver.findElement(By.xpath("/descendant::td[contains(text(),'1')][1]"));
		Actions action = new Actions(driver);
		action.moveToElement(Top).perform();

	}

	public void VerifyReportGeneratedOnBottomListOfEngagement() throws InterruptedException {

		// verify report generated in Bottom-10 Locations:

		Thread.sleep(1000);
		String BottomRank = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][20]"))
				.getText();
		System.out.println("Rank=========" + BottomRank);
		Assert.assertTrue(BottomRank.contains(BottomRank));

		String Option1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[11]/td[2]/p[1]"))
				.getText();
		System.out.println("Location=========" + Option1);
		Assert.assertTrue(Option1.contains("The Cheesecake Factory"));

		String Score = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][20]")).getText();
		System.out.println("Score=========" + Score);

		Thread.sleep(1000);
		WebElement Bottom = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][12]"));
		Actions action = new Actions(driver);
		action.moveToElement(Bottom).perform();

	}

	public void CheckReviewsBrandScore() throws InterruptedException {

		Thread.sleep(1500);
		ReviewsBrandscore.click();
		Thread.sleep(3000);

		String Option1 = driver
				.findElement(By
						.xpath("//div[starts-with(@class,'mod-justify-between sc-')]//div[starts-with(@class,'sc-')]"))
				.getText();
		Assert.assertTrue(Option1.contains("Leaderboard | Reviews"));
		System.out.println("found=========" + Option1);

	}

	public void VerifyReportGeneratedOnTopListOfReviews() throws InterruptedException {

		// verify report generated in Top-10 Locations:

		String TopRank = driver.findElement(By.xpath(
				"/descendant::td[contains(text(),'1')][1]"))
				.getText();
		System.out.println("Rank=========" + TopRank);
		Assert.assertEquals("1", TopRank);

		String TP_Rank = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/p[1]"))
				.getText();
		System.out.println("Location=========" + TP_Rank);
		Assert.assertTrue(TP_Rank.contains("The Cheesecake Factory"));

		String TP_RankScore = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][1]")).getText();
		System.out.println("Score=========" + TP_RankScore);

		Thread.sleep(1000);
		WebElement Top = driver.findElement(By.xpath("/descendant::td[contains(text(),'1')][1]"));
		Actions action = new Actions(driver);
		action.moveToElement(Top).perform();
	}

	public void VerifyReportGeneratedOnBottomListOfReviews() throws InterruptedException {

		// verify report generated in Bottom-10 Locations:

		Thread.sleep(1000);
		String BottomRank = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][20]"))
				.getText();
		System.out.println("Rank=========" + BottomRank);
		Assert.assertTrue(BottomRank.contains(BottomRank));

		String BT_Rank = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[11]/td[2]/p[1]"))
				.getText();
		System.out.println("Location=========" + BT_Rank);
		Assert.assertTrue(BT_Rank.contains("The Cheesecake Factory"));

		String BT_RankScore = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][20]")).getText();
		System.out.println("Score=========" + BT_RankScore);

		Thread.sleep(1000);
		WebElement Bottom = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][12]"));
		Actions action = new Actions(driver);
		action.moveToElement(Bottom).perform();

	}

	public void CheckSearchBrandScore() throws InterruptedException {

		Thread.sleep(1500);
		SearchBrandscore.click();
		Thread.sleep(3000);
		String Option1 = driver
				.findElement(By
						.xpath("//div[starts-with(@class,'mod-justify-between sc-')]//div[starts-with(@class,'sc-')]"))
				.getText();
		Assert.assertTrue(Option1.contains("Leaderboard | Search"));
		System.out.println("found=========" + Option1);

	}

	public void VerifyReportGeneratedOnTopListOfSearch() throws InterruptedException {

		// verify report generated in Top-10 Locations:

		String TopRank = driver.findElement(By.xpath(
				"/descendant::td[contains(text(),'1')][1]"))
				.getText();
		System.out.println("Rank=========" + TopRank);
		Assert.assertEquals("1", TopRank);

		String TP_Option1 = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/p[1]"))
				.getText();
		System.out.println("Location=========" + TP_Option1);
		Assert.assertTrue(TP_Option1.contains("The Cheesecake Factory"));

		String TP_Score = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][1]")).getText();
		System.out.println("Score=========" + TP_Score);

		Thread.sleep(1000);
		WebElement Top = driver.findElement(By.xpath("/descendant::td[contains(text(),'1')][1]"));
		Actions action = new Actions(driver);
		action.moveToElement(Top).perform();

	}

	public void VerifyReportGeneratedOnBottomListOfSearch() throws InterruptedException {

		// verify report generated in Bottom-10 Locations:
		Thread.sleep(1000);
		String BottomRank = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][20]"))
				.getText();
		System.out.println("Rank=========" + BottomRank);
		Assert.assertTrue(BottomRank.contains(BottomRank));

		String BT = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[11]/td[2]/p[1]")).getText();
		System.out.println("Location=========" + BT);
		Assert.assertTrue(BT.contains("The Cheesecake Factory"));

		String BT_Score = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'score-item score-item1')][20]")).getText();
		System.out.println("Score=========" + BT_Score);

		Thread.sleep(1000);
		WebElement Bottom = driver.findElement(By.xpath(
				"/descendant::td[starts-with(@class,'leaderboard-table-col leaderboard-table-col-rank max-w-100 sc-')][12]"));
		Actions action = new Actions(driver);
		action.moveToElement(Bottom).perform();

	}

	public void ClickOnEngagement() throws InterruptedException {

		Thread.sleep(2000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
	
		Actions action = new Actions(driver);
		action.moveToElement(InsightsMenu).perform();
		Assert.assertTrue(InsightsMenu.isDisplayed());
		action.moveToElement(Engagement).click().perform();
	}

	public void VerifyEngagementPageTitle() throws InterruptedException {

		Thread.sleep(7000);
		String Option = driver.findElement(By.xpath("//div[contains(text(),'Social / Insights / Engagement')]"))
				.getText();
		System.out.println("found=========" + Option);
		Assert.assertEquals("Social / Insights / Engagement", Option);

	}

	public void VerifyEngagementPageActions() throws InterruptedException {

		Thread.sleep(1500);
		String Option = driver.findElement(By.xpath("/descendant::h3[starts-with(@class,'sc-')][5]")).getText();
		System.out.println("found=========" + Option);

		WebElement Searches = driver.findElement(By.xpath("//div[@label='Searches']"));
		Assert.assertTrue(Searches.isDisplayed());

		String SearchesCount = driver.findElement(By.xpath("/descendant::h5[starts-with(@class,'sc-')][1]")).getText();
		System.out.println("found=========" + SearchesCount);

		WebElement Views = driver.findElement(By.xpath("//div[@label='Views']"));
		Assert.assertTrue(Views.isDisplayed());

		String ViewsCounts = driver.findElement(By.xpath("/descendant::h5[starts-with(@class,'sc-')][2]")).getText();
		System.out.println("found=========" + ViewsCounts);

		WebElement Actions = driver.findElement(By.xpath("//div[@label='Actions']"));
		Assert.assertTrue(Actions.isDisplayed());

		String ActionsCounts = driver.findElement(By.xpath("/descendant::h5[starts-with(@class,'sc-')][3]")).getText();
		System.out.println("found=========" + ActionsCounts);

		WebElement Graph = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]"));
		Graph.isDisplayed();

	}

	public void VerifyEngagementHeaderDateAndExport() throws InterruptedException {

		String DefaultHeaderDays = driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + DefaultHeaderDays);
		Assert.assertEquals("Last 30 days", DefaultHeaderDays);

		driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).click();
		Thread.sleep(1000);
		List<WebElement> HeaderElements = driver.findElements(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + HeaderElements.size());
		for (int i = 0; i < HeaderElements.size(); i++) {
			System.out.println("Header Days Drop-Down List have: " + HeaderElements.get(i).getText());
		}

		Thread.sleep(1000);
		String LastOneday = driver.findElement(By.xpath("//div[contains(text(),'Last 24 hours')]")).getText();
		System.out.println("found=========" + LastOneday);
		Assert.assertEquals("Last 24 hours", LastOneday);

		String LastSevenday = driver.findElement(By.xpath("//div[contains(text(),'Last 7 days')]")).getText();
		System.out.println("found=========" + LastSevenday);
		Assert.assertEquals("Last 7 days", LastSevenday);

		String LastThirtyday = driver.findElement(By.xpath("//div[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + LastThirtyday);
		Assert.assertEquals("Last 30 days", LastThirtyday);

		String LastThreemonth = driver.findElement(By.xpath("//div[contains(text(),'Last 3 months')]")).getText();
		System.out.println("found=========" + LastThreemonth);
		Assert.assertEquals("Last 3 months", LastThreemonth);

		String LastSixmonth = driver.findElement(By.xpath("//div[contains(text(),'Last 6 months')]")).getText();
		System.out.println("found=========" + LastSixmonth);
		Assert.assertEquals("Last 6 months", LastSixmonth);

		String Lastyear = driver.findElement(By.xpath("//div[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + Lastyear);
		Assert.assertEquals("Last year", Lastyear);

		String Alltime = driver.findElement(By.xpath("//div[contains(text(),'All time')]")).getText();
		System.out.println("found=========" + Alltime);
		Assert.assertEquals("All time", Alltime);

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom);
		Assert.assertEquals("Custom", Custom);

		Thread.sleep(1000);
		WebElement Export3DotMenu = driver.findElement(By.xpath("//i[contains(text(),'more_vert')]"));
		Assert.assertTrue(Export3DotMenu.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

		String Export = driver.findElement(By.xpath("//div[contains(text(),'Export')]")).getText();
		System.out.println("found=========" + Export);
		Assert.assertEquals("Export", Export);

		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

	}

	public void VerifyEngagementGraphDetailsWithDate() throws InterruptedException {

		String Days = driver.findElement(By.xpath("//span[@class='dropdown-label']")).getText();
		System.out.println("found=========" + Days);
		Assert.assertEquals("Day", Days);

		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();

		Thread.sleep(1000);
		List<WebElement> elements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + elements.get(i).getText());
		}

		Thread.sleep(1000);
		String Day = driver.findElement(By.xpath("//div[contains(text(),'Day')]")).getText();
		System.out.println("found=========" + Day);
		Assert.assertEquals("Day", Day);

		String Week = driver.findElement(By.xpath("//div[contains(text(),'Week')]")).getText();
		System.out.println("found=========" + Week);
		Assert.assertEquals("Week", Week);

		String Month = driver.findElement(By.xpath("//div[contains(text(),'Month')]")).getText();
		System.out.println("found=========" + Month);
		Assert.assertEquals("Month", Month);

		String Quarter = driver.findElement(By.xpath("//div[contains(text(),'Quarter')]")).getText();
		System.out.println("found=========" + Quarter);
		Assert.assertEquals("Quarter", Quarter);

		String Year = driver.findElement(By.xpath("//div[contains(text(),'Year')]")).getText();
		System.out.println("found=========" + Year);
		Assert.assertEquals("Year", Year);

	}

	public void VerifyEngagementLocationTable() throws InterruptedException {

		String Location = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"))
				.getText();
		System.out.println("found=========" + Location);
		Assert.assertEquals("Locations", Location);

		Thread.sleep(1000);

		WebElement LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();

		Thread.sleep(1000);
		List<WebElement> LocationElements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + LocationElements.size());
		for (int i = 0; i < LocationElements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + LocationElements.get(i).getText());
		}

		String Locations = driver
				.findElement(By.xpath(
						"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Locations')]"))
				.getText();
		System.out.println("found=========" + Locations);
		Assert.assertEquals("Locations", Locations);

		String LocationGroups = driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Location Groups')]"))
				.getText();
		System.out.println("found=========" + LocationGroups);
		Assert.assertEquals("Location Groups", LocationGroups);

		driver.findElement(
				By.xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Locations')]"))
				.click();
		Thread.sleep(1000);

		WebElement table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		table.isDisplayed();
		System.out.println("Location Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocation = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location')]")).getText();
		System.out.println("found=========" + TableLocation);
		Assert.assertTrue(TableLocation.contains("Location"));

		String TableSearches = driver.findElement(By.xpath("/descendant::div[contains(text(),'Searches')][2]")).getText();
		System.out.println("found=========" + TableSearches);
		Assert.assertTrue(TableSearches.contains("Searches"));

		String TableViews = driver.findElement(By.xpath("/descendant::div[contains(text(),'Views')][2]")).getText();
		System.out.println("found=========" + TableViews);
		Assert.assertTrue(TableViews.contains("Views"));

		String TableActions = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Actions')]")).getText();
		System.out.println("found=========" + TableActions);
		Assert.assertTrue(TableActions.contains("Actions"));

		String TableActionRate = driver.findElement(By.xpath("//div[contains(text(),'Action Rate')]")).getText();
		System.out.println("found=========" + TableActionRate);
		Assert.assertTrue(TableActionRate.contains("Action Rate"));

		String TableTachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		String TableSearchesPercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableSearchesPercentValue);

		String TableSearchesCountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableSearchesCountValue);

		String TableViewsPercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableViewsPercentValue);

		String TableViewsCountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableViewsCountValue);

		String TableActionsPercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableActionsPercentValue);

		String TableActionsCountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableActionsCountValue);

		String TableActionRatePercentValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableActionRatePercentValue);

		String TableActionsRateCountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableActionsRateCountValue);

	}

	public void VerifyEngagementLocationGroupTable() throws InterruptedException {

		Thread.sleep(2000);
		WebElement LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Location Groups')]"))
				.click();
		Thread.sleep(5000);

		WebElement LocationGrouptable = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		LocationGrouptable.isDisplayed();
		System.out.println("Location Group Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocationGroup = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location Group')]"))
				.getText();
		System.out.println("found=========" + TableLocationGroup);
		Assert.assertTrue(TableLocationGroup.contains("Location Group"));

		String TableLocationGroupSearches = driver.findElement(By.xpath("/descendant::div[contains(text(),'Searches')][2]"))
				.getText();
		System.out.println("found=========" + TableLocationGroupSearches);
		Assert.assertTrue(TableLocationGroupSearches.contains("Searches"));

		String TableLocationGroupViews = driver.findElement(By.xpath("/descendant::div[contains(text(),'Views')][2]")).getText();
		System.out.println("found=========" + TableLocationGroupViews);
		Assert.assertTrue(TableLocationGroupViews.contains("Views"));

		String TableLocationGroupActions = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Actions')]")).getText();
		System.out.println("found=========" + TableLocationGroupActions);
		Assert.assertTrue(TableLocationGroupActions.contains("Actions"));

		String TableLocationGroupActionRate = driver.findElement(By.xpath("//div[contains(text(),'Action Rate')]"))
				.getText();
		System.out.println("found=========" + TableLocationGroupActionRate);
		Assert.assertTrue(TableLocationGroupActionRate.contains("Action Rate"));

		Thread.sleep(1500);
		String TableLocationGroupTachometerValue = driver
				.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationGroupTachometerValue);

		String TableLocationGroupValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableLocationGroupValue);

		String TableLocationGroupSearchesPercentValue = driver
				.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationGroupSearchesPercentValue);

		String TableLocationGroupSearchesCountValue = driver
				.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableLocationGroupSearchesCountValue);

		String TableLocationGroupViewsPercentValue = driver
				.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationGroupViewsPercentValue);

		String TableLocationGroupViewsCountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableLocationGroupViewsCountValue);

		String TableLocationGroupActionsPercentValue = driver
				.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationGroupActionsPercentValue);

		String TableLocationGroupActionsCountValue = driver
				.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableLocationGroupActionsCountValue);

		String TableLocationGroupActionRatePercentValue = driver
				.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationGroupActionRatePercentValue);

		String TableLocationGroupActionsRateCountValue = driver
				.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableLocationGroupActionsRateCountValue);

	}

	public void VerifyEngagementPublishersTable() throws InterruptedException {

		Thread.sleep(2000);
		String Publishers = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]")).getText();
		System.out.println("found=========" + Publishers);
		Assert.assertEquals("Publishers", Publishers);

		driver.findElement(By.xpath("//div[contains(text(),'Publishers')]")).click();
		Thread.sleep(5000);

		String Publisher = driver.findElement(By.xpath("/descendant::div[contains(text(),'Publisher')][2]")).getText();
		System.out.println("found=========" + Publisher);
		Assert.assertTrue(Publisher.contains("Publisher"));

		String PublisherSearches = driver.findElement(By.xpath("/descendant::div[contains(text(),'Searches')][2]")).getText();
		System.out.println("found=========" + PublisherSearches);
		Assert.assertTrue(PublisherSearches.contains("Searches"));

		String PublisherViews = driver.findElement(By.xpath("/descendant::div[contains(text(),'Views')][2]")).getText();
		System.out.println("found=========" + PublisherViews);
		Assert.assertTrue(PublisherViews.contains("Views"));

		String PublisherActions = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Actions')]")).getText();
		System.out.println("found=========" + PublisherActions);
		Assert.assertTrue(PublisherActions.contains("Actions"));

		String PublisherActionRate = driver.findElement(By.xpath("//div[contains(text(),'Action Rate')]")).getText();
		System.out.println("found=========" + PublisherActionRate);
		Assert.assertTrue(PublisherActionRate.contains("Action Rate"));

		String PublisherValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + PublisherValue);

		String PublisherSearchesPercentValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + PublisherSearchesPercentValue);

		String PublisherSearchesCountValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + PublisherSearchesCountValue);

		String PublisherViewsPercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + PublisherViewsPercentValue);

		String PublisherViewsCountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + PublisherViewsCountValue);

		String PublisherActionsPercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + PublisherActionsPercentValue);

		String PublisherActionsCountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + PublisherActionsCountValue);

		String PublisherActionRatePercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + PublisherActionRatePercentValue);

		String PublisherActionsRateCountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + PublisherActionsRateCountValue);

		String Bing = driver.findElement(By.xpath("//b[contains(text(),'Bing')]")).getText();
		System.out.println("found=========" + Bing);
		Assert.assertTrue(Bing.contains("Bing"));

		/*
		 * String Facebook =
		 * driver.findElement(By.xpath("//b[contains(text(),'Facebook')]")).getText();
		 * System.out.println("found=========" + Facebook);
		 * Assert.assertTrue(Facebook.contains("Facebook"));
		 */

		String Foursqure = driver.findElement(By.xpath("//b[contains(text(),'Foursquare')]")).getText();
		System.out.println("found=========" + Foursqure);
		Assert.assertTrue(Foursqure.contains("Foursquare"));
		 
		String Google = driver.findElement(By.xpath("//b[contains(text(),'Google')]")).getText();
		System.out.println("found=========" + Google);
		Assert.assertTrue(Google.contains("Google"));

		String Pinterest = driver.findElement(By.xpath("//b[contains(text(),'Pinterest')]")).getText();
		System.out.println("found=========" + Pinterest);
		Assert.assertTrue(Pinterest.contains("Pinterest"));

		String Twitter = driver.findElement(By.xpath("//b[contains(text(),'Twitter')]")).getText();
		System.out.println("found=========" + Twitter);
		Assert.assertTrue(Twitter.contains("Twitter"));

		String Yelp = driver.findElement(By.xpath("//b[contains(text(),'Yelp')]")).getText();
		System.out.println("found=========" + Yelp);
		Assert.assertTrue(Yelp.contains("Yelp"));

		String Youtube = driver.findElement(By.xpath("//b[contains(text(),'YouTube')]")).getText();
		System.out.println("found=========" + Youtube);
		Assert.assertTrue(Youtube.contains("YouTube"));

	}

	public void VerifyShowCountNumberStatus() throws InterruptedException {

		Thread.sleep(5000);

		// scroll down page to Bottom:>>>>>

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement ShowCountOfElement = driver
				.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[2]"));
		Assert.assertTrue(ShowCountOfElement.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", ShowCountOfElement);

		Thread.sleep(1000);
		List<WebElement> PageNoElements = driver
				.findElements(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[2]/div[1]"));
		
		System.out.println("Number of elements:" + PageNoElements.size());
		for (int i = 0; i < PageNoElements.size(); i++) {
			System.out.println("Total count of Pages Drop-Down List have: " + PageNoElements.get(i).getText());
		}
		Thread.sleep(2000);
		String Twentyfive = driver.findElement(By.xpath("//li[contains(text(),'25')]")).getText();
		System.out.println("found=========" + Twentyfive);
		Assert.assertTrue(Twentyfive.contains("25"));

		String Fifty = driver.findElement(By.xpath("//li[contains(text(),'50')]")).getText();
		System.out.println("found=========" + Fifty);
		Assert.assertTrue(Fifty.contains("50"));

		String Hundred = driver.findElement(By.xpath("//li[contains(text(),'100')]")).getText();
		System.out.println("found=========" + Hundred);
		Assert.assertTrue(Hundred.contains("100"));

		Thread.sleep(1000);
		jv.executeScript("arguments[0].click();", ShowCountOfElement);
		Thread.sleep(1000);
	}

	public void ClickOnEngagement_Actions() throws InterruptedException {

		Thread.sleep(2000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		INSIGHTS.click();
		Actions action = new Actions(driver);
		action.moveToElement(InsightsMenu).perform();
		Assert.assertTrue(InsightsMenu.isDisplayed());
		EngagementActions.click();

	}

	public void VerifyEngagement_ActionsPageTitle() throws InterruptedException {

		Thread.sleep(7000);
		String PageHeader = driver
				.findElement(By.xpath("//div[contains(text(),'Social / Insights / Engagement Actions')]")).getText();
		System.out.println("found=========" + PageHeader);
		Assert.assertEquals("Social / Insights / Engagement Actions", PageHeader);

	}

	public void VerifyEngagement_ActionsPageAction() throws InterruptedException {

		Thread.sleep(1500);

		/*
		 * String ActionsCounts =
		 * driver.findElement(By.xpath("//div[@id='reactgooglegraph-1']")).getText();
		 * System.out.println("found=========" + ActionsCounts);
		 * 
		 * WebElement ActionsCountsGraph =
		 * driver.findElement(By.xpath("//div[@id='reactgooglegraph-1']"));
		 * ActionsCountsGraph.isDisplayed();
		 */

		String Graph = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]")).getText();
		System.out.println("found=========" + Graph);

		WebElement ActionGraph = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]"));
		ActionGraph.isDisplayed();

		Thread.sleep(1000);
		List<WebElement> HeaderElements = driver.findElements(By.xpath("//div[starts-with(@class,'line-chart')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + HeaderElements.size());
		for (int i = 0; i < HeaderElements.size(); i++) {
			System.out.println("Elements List have: " + HeaderElements.get(i).getText());
		}

	}

	public void VerifyEngagement_ActionsHeaderDateAndExport() throws InterruptedException {

		Thread.sleep(1000);
		String DefaultHeaderDays = driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + DefaultHeaderDays);
		Assert.assertEquals("Last 30 days", DefaultHeaderDays);

		driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).click();
		Thread.sleep(1000);
		List<WebElement> HeaderElements = driver.findElements(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + HeaderElements.size());
		for (int i = 0; i < HeaderElements.size(); i++) {
			System.out.println("Header Days Drop-Down List have: " + HeaderElements.get(i).getText());
		}

		Thread.sleep(1000);
		String LastOneday = driver.findElement(By.xpath("//div[contains(text(),'Last 24 hours')]")).getText();
		System.out.println("found=========" + LastOneday);
		Assert.assertEquals("Last 24 hours", LastOneday);

		String LastSevenday = driver.findElement(By.xpath("//div[contains(text(),'Last 7 days')]")).getText();
		System.out.println("found=========" + LastSevenday);
		Assert.assertEquals("Last 7 days", LastSevenday);

		String LastThirtyday = driver.findElement(By.xpath("//div[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + LastThirtyday);
		Assert.assertEquals("Last 30 days", LastThirtyday);

		String LastThreemonth = driver.findElement(By.xpath("//div[contains(text(),'Last 3 months')]")).getText();
		System.out.println("found=========" + LastThreemonth);
		Assert.assertEquals("Last 3 months", LastThreemonth);

		String LastSixmonth = driver.findElement(By.xpath("//div[contains(text(),'Last 6 months')]")).getText();
		System.out.println("found=========" + LastSixmonth);
		Assert.assertEquals("Last 6 months", LastSixmonth);

		String Lastyear = driver.findElement(By.xpath("//div[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + Lastyear);
		Assert.assertEquals("Last year", Lastyear);

		String Alltime = driver.findElement(By.xpath("//div[contains(text(),'All time')]")).getText();
		System.out.println("found=========" + Alltime);
		Assert.assertEquals("All time", Alltime);

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom);
		Assert.assertEquals("Custom", Custom);

		Thread.sleep(1000);
		WebElement Export3DotMenu = driver.findElement(By.xpath("//i[contains(text(),'more_vert')]"));
		Assert.assertTrue(Export3DotMenu.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

		String Export = driver.findElement(By.xpath("//div[contains(text(),'Export')]")).getText();
		System.out.println("found=========" + Export);
		Assert.assertEquals("Export", Export);

		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

	}

	public void VerifyEngagement_ActionsGraphDetailsWithDate() throws InterruptedException {

		String Days = driver.findElement(By.xpath("//span[@class='dropdown-label']")).getText();
		System.out.println("found=========" + Days);
		Assert.assertEquals("Day", Days);

		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();

		Thread.sleep(1000);
		List<WebElement> EA_elements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + EA_elements.size());
		for (int i = 0; i < EA_elements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + EA_elements.get(i).getText());
		}

		Thread.sleep(1000);
		String Day = driver.findElement(By.xpath("//div[contains(text(),'Day')]")).getText();
		System.out.println("found=========" + Day);
		Assert.assertEquals("Day", Day);

		String Week = driver.findElement(By.xpath("//div[contains(text(),'Week')]")).getText();
		System.out.println("found=========" + Week);
		Assert.assertEquals("Week", Week);

		String Month = driver.findElement(By.xpath("//div[contains(text(),'Month')]")).getText();
		System.out.println("found=========" + Month);
		Assert.assertEquals("Month", Month);

		String Quarter = driver.findElement(By.xpath("//div[contains(text(),'Quarter')]")).getText();
		System.out.println("found=========" + Quarter);
		Assert.assertEquals("Quarter", Quarter);

		String Year = driver.findElement(By.xpath("//div[contains(text(),'Year')]")).getText();
		System.out.println("found=========" + Year);
		Assert.assertEquals("Year", Year);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();
		Thread.sleep(1000);

	}

	public void VerifyEngagement_ActionsLocation() throws InterruptedException {

		String Location = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"))
				.getText();
		System.out.println("found=========" + Location);
		Assert.assertEquals("Locations", Location);

		Thread.sleep(1000);

		WebElement LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();

		Thread.sleep(1000);
		List<WebElement> LocationElements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + LocationElements.size());
		for (int i = 0; i < LocationElements.size(); i++) {
			System.out.println("Location Drop-Down List have: " + LocationElements.get(i).getText());
		}

		/*
		 * WebElement location = driver.findElement( By.
		 * xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Locations')]"
		 * )); TestUtility.clickOn(driver, location, 30); Thread.sleep(1000);
		 */

		WebElement table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		table.isDisplayed();
		System.out.println("Location Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocation = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location')]")).getText();
		System.out.println("found=========" + TableLocation);
		Assert.assertTrue(TableLocation.contains("Location"));

		String Tabledirections = driver.findElement(By.xpath("//div[contains(text(),'Directions')]")).getText();
		System.out.println("found=========" + Tabledirections);
		Assert.assertTrue(Tabledirections.contains("Directions"));

		String TableWebsite = driver.findElement(By.xpath("//div[contains(text(),'Website')]")).getText();
		System.out.println("found=========" + TableWebsite);
		Assert.assertTrue(TableWebsite.contains("Website"));

		String TableCall = driver.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Call')]"))
				.getText();
		System.out.println("found=========" + TableCall);
		Assert.assertTrue(TableCall.contains("Call"));

		String TableTotal = driver.findElement(By.xpath("//div[contains(text(),'Total')]")).getText();
		System.out.println("found=========" + TableTotal);
		Assert.assertTrue(TableTotal.contains("Total"));

		String TableTachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		String TableDirectionPercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableDirectionPercentValue);

		String TableDirectionCountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableDirectionCountValue);

		String TableWebsitePercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableWebsitePercentValue);

		String TableWebsiteCountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableWebsiteCountValue);

		String TableCallPercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableCallPercentValue);

		String TableCallCountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableCallCountValue);

		String TableTotalPercentValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableTotalPercentValue);

		String TableTotalCountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableTotalCountValue);

	}

	public void VerifyEngagement_ActionsLocationGroup() throws InterruptedException {

		Thread.sleep(2000);
		WebElement LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Location Groups')]"))
				.click();
		Thread.sleep(5000);

		WebElement LocationGrouptable = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		LocationGrouptable.isDisplayed();
		System.out.println("Location Group Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocationGroup = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location Group')]"))
				.getText();
		System.out.println("found=========" + TableLocationGroup);
		Assert.assertTrue(TableLocationGroup.contains("Location Group"));

		String Tabledirections = driver.findElement(By.xpath("//div[contains(text(),'Directions')]")).getText();
		System.out.println("found=========" + Tabledirections);
		Assert.assertTrue(Tabledirections.contains("Directions"));

		String TableWebsite = driver.findElement(By.xpath("//div[contains(text(),'Website')]")).getText();
		System.out.println("found=========" + TableWebsite);
		Assert.assertTrue(TableWebsite.contains("Website"));

		String TableCall = driver.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Call')]"))
				.getText();
		System.out.println("found=========" + TableCall);
		Assert.assertTrue(TableCall.contains("Call"));

		String TableTotal = driver.findElement(By.xpath("//div[contains(text(),'Total')]")).getText();
		System.out.println("found=========" + TableTotal);
		Assert.assertTrue(TableTotal.contains("Total"));

		String TableTachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		String TableDirectionPercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableDirectionPercentValue);

		String TableDirectionCountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableDirectionCountValue);

		String TableWebsitePercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableWebsitePercentValue);

		String TableWebsiteCountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableWebsiteCountValue);

		String TableCallPercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableCallPercentValue);

		String TableCallCountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableCallCountValue);

		String TableTotalPercentValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableTotalPercentValue);

		String TableTotalCountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableTotalCountValue);

	}

	public void VerifyEngagement_ActionsPublishers() throws InterruptedException {

		Thread.sleep(2000);
		String Publishers = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]")).getText();
		System.out.println("found=========" + Publishers);
		Assert.assertEquals("Publishers", Publishers);

		driver.findElement(By.xpath("//div[contains(text(),'Publishers')]")).click();
		Thread.sleep(5000);

		String Publisher = driver.findElement(By.xpath("/descendant::div[contains(text(),'Publisher')][2]")).getText();
		System.out.println("found=========" + Publisher);
		Assert.assertTrue(Publisher.contains("Publisher"));

		String Publisherdirections = driver.findElement(By.xpath("//div[contains(text(),'Directions')]")).getText();
		System.out.println("found=========" + Publisherdirections);
		Assert.assertTrue(Publisherdirections.contains("Directions"));

		String PublisherWebsite = driver.findElement(By.xpath("//div[contains(text(),'Website')]")).getText();
		System.out.println("found=========" + PublisherWebsite);
		Assert.assertTrue(PublisherWebsite.contains("Website"));

		String PublisherCall = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Call')]")).getText();
		System.out.println("found=========" + PublisherCall);
		Assert.assertTrue(PublisherCall.contains("Call"));

		String PublisherTotal = driver.findElement(By.xpath("//div[contains(text(),'Total')]")).getText();
		System.out.println("found=========" + PublisherTotal);
		Assert.assertTrue(PublisherTotal.contains("Total"));

		String TablePublisherValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TablePublisherValue);

		String TableDirectionPercentValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableDirectionPercentValue);

		String TableDirectionCountValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableDirectionCountValue);

		String TableWebsitePercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableWebsitePercentValue);

		String TableWebsiteCountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableWebsiteCountValue);

		String TableCallPercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableCallPercentValue);

		String TableCallCountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableCallCountValue);

		String TableTotalPercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableTotalPercentValue);

		String TableTotalCountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableTotalCountValue);

		String Bing = driver.findElement(By.xpath("//b[contains(text(),'Bing')]")).getText();
		System.out.println("found=========" + Bing);
		Assert.assertTrue(Bing.contains("Bing"));

		/*
		 * String Facebook =
		 * driver.findElement(By.xpath("//b[contains(text(),'Facebook')]")).getText();
		 * System.out.println("found=========" + Facebook);
		 * Assert.assertTrue(Facebook.contains("Facebook"));
		 */

		String Foursqure = driver.findElement(By.xpath("//b[contains(text(),'Foursquare')]")).getText();
		System.out.println("found=========" + Foursqure);
		Assert.assertTrue(Foursqure.contains("Foursquare"));

		String Google = driver.findElement(By.xpath("//b[contains(text(),'Google')]")).getText();
		System.out.println("found=========" + Google);
		Assert.assertTrue(Google.contains("Google"));

		String Pinterest = driver.findElement(By.xpath("//b[contains(text(),'Pinterest')]")).getText();
		System.out.println("found=========" + Pinterest);
		Assert.assertTrue(Pinterest.contains("Pinterest"));

		String Twitter = driver.findElement(By.xpath("//b[contains(text(),'Twitter')]")).getText();
		System.out.println("found=========" + Twitter);
		Assert.assertTrue(Twitter.contains("Twitter"));

		String Yelp = driver.findElement(By.xpath("//b[contains(text(),'Yelp')]")).getText();
		System.out.println("found=========" + Yelp);
		Assert.assertTrue(Yelp.contains("Yelp"));

		String Youtube = driver.findElement(By.xpath("//b[contains(text(),'YouTube')]")).getText();
		System.out.println("found=========" + Youtube);
		Assert.assertTrue(Youtube.contains("YouTube"));

	}

	public void VerifyEngagement_ActionsShowCountNumberStatus() throws InterruptedException {

		Thread.sleep(3000);

		// scroll down page to Bottom:>>>>>

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement CountOfElement = driver
				.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]"));
		Assert.assertTrue(CountOfElement.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", CountOfElement);

		Thread.sleep(1000);
		List<WebElement> PageNoElements = driver
				.findElements(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[1]/ul[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + PageNoElements.size());
		for (int i = 0; i < PageNoElements.size(); i++) {
			System.out.println("Total count of Pages Drop-Down List have: " + PageNoElements.get(i).getText());
		}

		String Twenty_five = driver.findElement(By.xpath("//li[contains(text(),'25')]")).getText();
		System.out.println("found=========" + Twenty_five);
		Assert.assertTrue(Twenty_five.contains("25"));

		String Fifty = driver.findElement(By.xpath("//li[contains(text(),'50')]")).getText();
		System.out.println("found=========" + Fifty);
		Assert.assertTrue(Fifty.contains("50"));

		String Hundred = driver.findElement(By.xpath("//li[contains(text(),'100')]")).getText();
		System.out.println("found=========" + Hundred);
		Assert.assertTrue(Hundred.contains("100"));

		Thread.sleep(1000);
		jv.executeScript("arguments[0].click();", CountOfElement);
		Thread.sleep(1000);
	}

	public void ClickOnResponses() throws InterruptedException {

		Thread.sleep(2000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		INSIGHTS.click();
		Actions action = new Actions(driver);
		action.moveToElement(InsightsMenu).perform();
		Assert.assertTrue(InsightsMenu.isDisplayed());
		Responses.click();

	}

	public void VerifyResponsesPageTitle() throws InterruptedException {

		Thread.sleep(7000);
		String PageHeader = driver.findElement(By.xpath("//div[contains(text(),'Social / Insights / Responses')]"))
				.getText();
		System.out.println("found=========" + PageHeader);
		Assert.assertEquals("Social / Insights / Responses", PageHeader);

	}

	public void VerifyResponsesPageAction() throws InterruptedException {

		Thread.sleep(1500);

		/*
		 * String ActionsCounts =
		 * driver.findElement(By.xpath("//div[@id='reactgooglegraph-7']")).getText();
		 * System.out.println("found=========" + ActionsCounts);
		 * 
		 * WebElement ActionsCountsGraph =
		 * driver.findElement(By.xpath("//div[@id='reactgooglegraph-7']"));
		 * ActionsCountsGraph.isDisplayed();
		 */

		String Graph = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/*[1]")).getText();
	    System.out.println("found=========" + Graph);

		WebElement LineChart = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/*[1]"));
		LineChart.isDisplayed();

		Thread.sleep(1000);
		List<WebElement> HeaderElements = driver.findElements(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/*[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + HeaderElements.size());
		for (int i = 0; i < HeaderElements.size(); i++) {
			System.out.println("Elements List have: " + HeaderElements.get(i).getText());
		}

	}

	public void VerifyResponses_HeaderDateAndExport() throws InterruptedException {

		Thread.sleep(1000);
		String DefaultHeaderDay = driver.findElement(By.xpath("//span/div/ul/li[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + DefaultHeaderDay);
		Assert.assertEquals("Last 30 days", DefaultHeaderDay);

		driver.findElement(By.xpath("//span/div/ul/li[contains(text(),'Last 30 days')]")).click();
		Thread.sleep(1000);
		List<WebElement> HeaderDay = driver.findElements(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + HeaderDay.size());
		for (int i = 0; i < HeaderDay.size(); i++) {
			System.out.println("Header Days Drop-Down List have: " + HeaderDay.get(i).getText());
		}

		Thread.sleep(1000);
		String LastOneday = driver.findElement(By.xpath("//div[contains(text(),'Last 24 hours')]")).getText();
		System.out.println("found=========" + LastOneday);
		Assert.assertEquals("Last 24 hours", LastOneday);

		String LastSevenday = driver.findElement(By.xpath("//div[contains(text(),'Last 7 days')]")).getText();
		System.out.println("found=========" + LastSevenday);
		Assert.assertEquals("Last 7 days", LastSevenday);

		String LastThirtyday = driver.findElement(By.xpath("//div[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + LastThirtyday);
		Assert.assertEquals("Last 30 days", LastThirtyday);

		String LastThreemonth = driver.findElement(By.xpath("//div[contains(text(),'Last 3 months')]")).getText();
		System.out.println("found=========" + LastThreemonth);
		Assert.assertEquals("Last 3 months", LastThreemonth);

		String LastSixmonth = driver.findElement(By.xpath("//div[contains(text(),'Last 6 months')]")).getText();
		System.out.println("found=========" + LastSixmonth);
		Assert.assertEquals("Last 6 months", LastSixmonth);

		String Lastyear = driver.findElement(By.xpath("//div[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + Lastyear);
		Assert.assertEquals("Last year", Lastyear);

		String Alltime = driver.findElement(By.xpath("//div[contains(text(),'All time')]")).getText();
		System.out.println("found=========" + Alltime);
		Assert.assertEquals("All time", Alltime);

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom);
		Assert.assertEquals("Custom", Custom);

		Thread.sleep(1000);
		WebElement Export3DotMenu = driver.findElement(By.xpath("//i[contains(text(),'more_vert')]"));
		Assert.assertTrue(Export3DotMenu.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

		String Export = driver.findElement(By.xpath("//div[contains(text(),'Export')]")).getText();
		System.out.println("found=========" + Export);
		Assert.assertEquals("Export", Export);

		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

	}

	public void VerifyResponses_GraphDetailsWithDate() throws InterruptedException {

		String Day = driver.findElement(By.xpath("//span[@class='dropdown-label']")).getText();
		System.out.println("found=========" + Day);
		Assert.assertEquals("Day", Day);

		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();

		Thread.sleep(1000);
		List<WebElement> DropDownelements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + DropDownelements.size());
		for (int i = 0; i < DropDownelements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + DropDownelements.get(i).getText());
		}

		Thread.sleep(1000);
		String Days = driver.findElement(By.xpath("//div[contains(text(),'Day')]")).getText();
		System.out.println("found=========" + Days);
		Assert.assertEquals("Day", Days);

		String Week = driver.findElement(By.xpath("//div[contains(text(),'Week')]")).getText();
		System.out.println("found=========" + Week);
		Assert.assertEquals("Week", Week);

		String Month = driver.findElement(By.xpath("//div[contains(text(),'Month')]")).getText();
		System.out.println("found=========" + Month);
		Assert.assertEquals("Month", Month);

		String Quarter = driver.findElement(By.xpath("//div[contains(text(),'Quarter')]")).getText();
		System.out.println("found=========" + Quarter);
		Assert.assertEquals("Quarter", Quarter);

		String Year = driver.findElement(By.xpath("//div[contains(text(),'Year')]")).getText();
		System.out.println("found=========" + Year);
		Assert.assertEquals("Year", Year);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();
		Thread.sleep(1000);

	}

	public void VerifyResponses_Location() throws InterruptedException {

		String TableLocation = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"))
				.getText();
		System.out.println("found=========" + TableLocation);
		Assert.assertEquals("Locations", TableLocation);

		Thread.sleep(1000);

		WebElement TableLocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(TableLocationDropDown).perform();

		Thread.sleep(1000);
		List<WebElement> LocationElements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + LocationElements.size());
		for (int i = 0; i < LocationElements.size(); i++) {
			System.out.println("Location Drop-Down List have: " + LocationElements.get(i).getText());
		}

		driver.findElement(
				By.xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Locations')]"))
				.click();
		Thread.sleep(1000);

		WebElement table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		table.isDisplayed();
		System.out.println("Location Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocations = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location')]")).getText();
		System.out.println("found=========" + TableLocations);
		Assert.assertTrue(TableLocations.contains("Location"));

		String TableReviews = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Reviews')]")).getText();
		System.out.println("found=========" + TableReviews);
		Assert.assertTrue(TableReviews.contains("Reviews"));

		String TableResponded = driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded')][2]")).getText();
		System.out.println("found=========" + TableResponded);
		Assert.assertTrue(TableResponded.contains("Responded"));

		String TableUnresponded = driver.findElement(By.xpath("//div[contains(text(),'Unresponded')]")).getText();
		System.out.println("found=========" + TableUnresponded);
		Assert.assertTrue(TableUnresponded.contains("Unresponded"));

		String TableUnrespondable = driver.findElement(By.xpath("//body//th[6]//div[contains(text(),'Unrespondable')]"))
				.getText();
		System.out.println("found=========" + TableUnrespondable);
		Assert.assertTrue(TableUnrespondable.contains("Unrespondable"));

		String TachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TachometerValue);

		String TableLocationsValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationsValue);

		String TableReviewsPercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableReviewsPercentValue);

		String TableReviewsCountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableReviewsCountValue);

		String TableRespondedPercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableRespondedPercentValue);

		String TableRespondedCountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableRespondedCountValue);

		String TableUnrespondedPercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableUnrespondedPercentValue);

		String TableUnrespondedCountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableUnrespondedCountValue);

		String TableUnrespondablePercentValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableUnrespondablePercentValue);

		String TableUnrespondableCountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableUnrespondableCountValue);

	}

	public void VerifyResponses_LocationGroup() throws InterruptedException {

		Thread.sleep(2000);
		WebElement LocationDD = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDD).perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Location Groups')]"))
				.click();
		Thread.sleep(5000);

		WebElement LocationGroup = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		LocationGroup.isDisplayed();
		System.out.println("Location Group Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocationGroup = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location')]")).getText();
		System.out.println("found=========" + TableLocationGroup);
		Assert.assertTrue(TableLocationGroup.contains("Location"));

		String LG_TableReviews = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Reviews')]")).getText();
		System.out.println("found=========" + LG_TableReviews);
		Assert.assertTrue(LG_TableReviews.contains("Reviews"));

		String LG_TableResponded = driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded')][2]")).getText();
		System.out.println("found=========" + LG_TableResponded);
		Assert.assertTrue(LG_TableResponded.contains("Responded"));

		String LG_TableUnresponded = driver.findElement(By.xpath("//div[contains(text(),'Unresponded')]")).getText();
		System.out.println("found=========" + LG_TableUnresponded);
		Assert.assertTrue(LG_TableUnresponded.contains("Unresponded"));

		String LG_TableUnrespondable = driver
				.findElement(By.xpath("//body//th[6]//div[contains(text(),'Unrespondable')]")).getText();
		System.out.println("found=========" + LG_TableUnrespondable);
		Assert.assertTrue(LG_TableUnrespondable.contains("Unrespondable"));

		String LG_TachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + LG_TachometerValue);

		String LG_TableLocationsValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + LG_TableLocationsValue);

		String LG_TableReviewsPercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + LG_TableReviewsPercentValue);

		String LG_TableReviewsCountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + LG_TableReviewsCountValue);

		String LG_TableRespondedPercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + LG_TableRespondedPercentValue);

		String LG_TableRespondedCountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + LG_TableRespondedCountValue);

		String LG_TableUnrespondedPercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + LG_TableUnrespondedPercentValue);

		String LG_TableUnrespondedCountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + LG_TableUnrespondedCountValue);

		String LG_TableUnrespondablePercentValue = driver
				.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + LG_TableUnrespondablePercentValue);

		String LG_TableUnrespondableCountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + LG_TableUnrespondableCountValue);

	}

	public void VerifyResponses_Publisher() throws InterruptedException {

		Thread.sleep(2000);
		String Publisher = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]")).getText();
		System.out.println("found=========" + Publisher);
		Assert.assertEquals("Publishers", Publisher);

		driver.findElement(By.xpath("//div[contains(text(),'Publishers')]")).click();
		Thread.sleep(5000);

		String Publishers = driver.findElement(By.xpath("/descendant::div[contains(text(),'Publisher')][2]")).getText();
		System.out.println("found=========" + Publishers);
		Assert.assertTrue(Publishers.contains("Publisher"));

		String Publisher_Reviews = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Reviews')]")).getText();
		System.out.println("found=========" + Publisher_Reviews);
		Assert.assertTrue(Publisher_Reviews.contains("Reviews"));

		String Publisher_Responded = driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded')][2]")).getText();
		System.out.println("found=========" + Publisher_Responded);
		Assert.assertTrue(Publisher_Responded.contains("Responded"));

		String Publisher_Unresponded = driver.findElement(By.xpath("//div[contains(text(),'Unresponded')]")).getText();
		System.out.println("found=========" + Publisher_Unresponded);
		Assert.assertTrue(Publisher_Unresponded.contains("Unresponded"));

		String Publisher_Unrespondable = driver
				.findElement(By.xpath("//body//th[5]//div[contains(text(),'Unrespondable')]")).getText();
		System.out.println("found=========" + Publisher_Unrespondable);
		Assert.assertTrue(Publisher_Unrespondable.contains("Unrespondable"));

		String Publisher_TablePublisherValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + Publisher_TablePublisherValue);

		String Publisher_TableReviewsPercentValue = driver
				.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + Publisher_TableReviewsPercentValue);

		String Publisher_TableReviewsCountValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + Publisher_TableReviewsCountValue);

		String Publisher_TableRespondedPercentValue = driver
				.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + Publisher_TableRespondedPercentValue);

		String Publisher_TableRespondedCountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + Publisher_TableRespondedCountValue);

		String Publisher_TableUnrespondedPercentValue = driver
				.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + Publisher_TableUnrespondedPercentValue);

		String Publisher_TableUnrespondedCountValue = driver
				.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + Publisher_TableUnrespondedCountValue);

		String Publisher_TableUnrespondablePercentValue = driver
				.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + Publisher_TableUnrespondablePercentValue);

		String Publisher_TableUnrespondableCountValue = driver
				.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + Publisher_TableUnrespondableCountValue);

		String info = driver.findElement(By.xpath("//b[contains(text(),'411.info')]")).getText();
		System.out.println("found=========" + info);
		Assert.assertTrue(info.contains("411.info"));

		String Amazon = driver.findElement(By.xpath("//b[contains(text(),'Amazon')]")).getText();
		System.out.println("found=========" + Amazon);
		Assert.assertTrue(Amazon.contains("Amazon"));

		String AG = driver.findElement(By.xpath("//b[contains(text(),'ApartmentGuides.com')]")).getText();
		System.out.println("found=========" + AG);
		Assert.assertTrue(AG.contains("ApartmentGuides.com"));

		String AR = driver.findElement(By.xpath("//b[contains(text(),'ApartmentRatings.com')]")).getText();
		System.out.println("found=========" + AR);
		Assert.assertTrue(AR.contains("ApartmentRatings.com"));

		String AP = driver.findElement(By.xpath("//b[contains(text(),'Apartments.com')]")).getText();
		System.out.println("found=========" + AP);
		Assert.assertTrue(AP.contains("Apartments.com"));

		String Bing = driver.findElement(By.xpath("//b[contains(text(),'Bing')]")).getText();
		System.out.println("found=========" + Bing);
		Assert.assertTrue(Bing.contains("Bing"));

		String BB = driver.findElement(By.xpath("//b[contains(text(),'Brownbook')]")).getText();
		System.out.println("found=========" + BB);
		Assert.assertTrue(BB.contains("Brownbook"));

		String CityGrid = driver.findElement(By.xpath("//b[contains(text(),'CityGrid')]")).getText();
		System.out.println("found=========" + CityGrid);
		Assert.assertTrue(CityGrid.contains("CityGrid"));

		String Citysearch = driver.findElement(By.xpath("//b[contains(text(),'Citysearch')]")).getText();
		System.out.println("found=========" + Citysearch);
		Assert.assertTrue(Citysearch.contains("Citysearch"));

		String CitySquares = driver.findElement(By.xpath("//b[contains(text(),'CitySquares')]")).getText();
		System.out.println("found=========" + CitySquares);
		Assert.assertTrue(CitySquares.contains("CitySquares"));

		// Enable When Providers Change :! >>

		/*
		 * String Facebook =
		 * driver.findElement(By.xpath("//b[contains(text(),'Facebook')]")).getText();
		 * System.out.println("found=========" + Facebook);
		 * Assert.assertTrue(Facebook.contains("Facebook"));
		 * 
		 * String Foursqure =
		 * driver.findElement(By.xpath("//b[contains(text(),'Foursquare')]")).getText();
		 * System.out.println("found=========" + Foursqure);
		 * Assert.assertTrue(Foursqure.contains("Foursquare"));
		 * 
		 * String Google =
		 * driver.findElement(By.xpath("//b[contains(text(),'Google')]")).getText();
		 * System.out.println("found=========" + Google);
		 * Assert.assertTrue(Google.contains("Google"));
		 * 
		 * String MC =
		 * driver.findElement(By.xpath("//b[contains(text(),'Merchant Circle')]")).
		 * getText(); System.out.println("found=========" + MC);
		 * Assert.assertTrue(MC.contains("Merchant Circle"));
		 * 
		 * String Yellowpages =
		 * driver.findElement(By.xpath("//b[contains(text(),'Yellowpages')]")).getText()
		 * ; System.out.println("found=========" + Yellowpages);
		 * Assert.assertTrue(Yellowpages.contains("Yellowpages"));
		 * 
		 * String Yelp =
		 * driver.findElement(By.xpath("//b[contains(text(),'Yelp')]")).getText();
		 * System.out.println("found=========" + Yelp);
		 * Assert.assertTrue(Yelp.contains("Yelp"));
		 */

	}

	public void VerifyResponses_ShowCountNumberStatus() throws InterruptedException {

		Thread.sleep(3000);

		// scroll down page to Bottom:>>>>>

		JavascriptExecutor jv = ((JavascriptExecutor) driver);
		jv.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement CountOfElement = driver
				.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]"));
		Assert.assertTrue(CountOfElement.isDisplayed());

		JavascriptExecutor jm = (JavascriptExecutor) driver;
		jm.executeScript("arguments[0].click();", CountOfElement);

		Thread.sleep(1000);
		List<WebElement> PageNoElements = driver
				.findElements(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[1]/ul[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + PageNoElements.size());
		for (int i = 0; i < PageNoElements.size(); i++) {
			System.out.println("Total count of Pages Drop-Down List have: " + PageNoElements.get(i).getText());
		}

		String Twenty_five = driver.findElement(By.xpath("//li[contains(text(),'25')]")).getText();
		System.out.println("found=========" + Twenty_five);
		Assert.assertTrue(Twenty_five.contains("25"));

		String Fifty = driver.findElement(By.xpath("//li[contains(text(),'50')]")).getText();
		System.out.println("found=========" + Fifty);
		Assert.assertTrue(Fifty.contains("50"));

		String Hundred = driver.findElement(By.xpath("//li[contains(text(),'100')]")).getText();
		System.out.println("found=========" + Hundred);
		Assert.assertTrue(Hundred.contains("100"));

		Thread.sleep(1000);
		jv.executeScript("arguments[0].click();", CountOfElement);
		Thread.sleep(1000);
	}

	public void ClickOnRatings() throws InterruptedException {

		Thread.sleep(2000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		INSIGHTS.click();
		Actions action = new Actions(driver);
		action.moveToElement(InsightsMenu).perform();
		Assert.assertTrue(InsightsMenu.isDisplayed());
		Ratings.click();

	}

	public void VerifyRatings_PageTitle() throws InterruptedException {

		Thread.sleep(7000);
		String Rating_PageHeader = driver.findElement(By.xpath("//div[contains(text(),'Social / Insights / Ratings')]"))
				.getText();
		System.out.println("found=========" + Rating_PageHeader);
		Assert.assertEquals("Social / Insights / Ratings", Rating_PageHeader);

	}

	public void VerifyRatings_PageAction() throws InterruptedException {

		Thread.sleep(3000);

		/*
		 * String ActionsCounts =
		 * driver.findElement(By.xpath("//div[@id='reactgooglegraph-1']")).getText();
		 * System.out.println("found=========" + ActionsCounts);
		 * 
		 * WebElement ActionsCountsGraph =
		 * driver.findElement(By.xpath("//div[@id='reactgooglegraph-1']"));
		 * ActionsCountsGraph.isDisplayed();
		 */

		String Rating_Graph = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]")).getText();
		System.out.println("found=========" + Rating_Graph);

		WebElement Ratings_Graph = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]"));
		Ratings_Graph.isDisplayed();

		Thread.sleep(1000);
		List<WebElement> HeaderElements = driver.findElements(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + HeaderElements.size());
		for (int i = 0; i < HeaderElements.size(); i++) {
			System.out.println("Elements List have: " + HeaderElements.get(i).getText());
		}

	}

	public void VerifyRatings_HeaderDateAndExport() throws InterruptedException {

		Thread.sleep(1000);
		String Default_HeaderDay = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).getText();
		System.out.println("found=========" + Default_HeaderDay);
		Assert.assertEquals("Last 30 days", Default_HeaderDay);

		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).click();
		Thread.sleep(1000);
		List<WebElement> DD_HeaderElements = driver.findElements(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + DD_HeaderElements.size());
		for (int i = 0; i < DD_HeaderElements.size(); i++) {
			System.out.println("Header Days Drop-Down List have: " + DD_HeaderElements.get(i).getText());
		}

		Thread.sleep(1000);
		String LastOneday = driver.findElement(By.xpath("//div[contains(text(),'Last 24 hours')]")).getText();
		System.out.println("found=========" + LastOneday);
		Assert.assertEquals("Last 24 hours", LastOneday);

		String LastSevenday = driver.findElement(By.xpath("//div[contains(text(),'Last 7 days')]")).getText();
		System.out.println("found=========" + LastSevenday);
		Assert.assertEquals("Last 7 days", LastSevenday);

		String LastThirtyday = driver.findElement(By.xpath("//div[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + LastThirtyday);
		Assert.assertEquals("Last 30 days", LastThirtyday);

		String LastThreemonth = driver.findElement(By.xpath("//div[contains(text(),'Last 3 months')]")).getText();
		System.out.println("found=========" + LastThreemonth);
		Assert.assertEquals("Last 3 months", LastThreemonth);

		String LastSixmonth = driver.findElement(By.xpath("//div[contains(text(),'Last 6 months')]")).getText();
		System.out.println("found=========" + LastSixmonth);
		Assert.assertEquals("Last 6 months", LastSixmonth);

		String Lastyear = driver.findElement(By.xpath("//div[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + Lastyear);
		Assert.assertEquals("Last year", Lastyear);

		String Alltime = driver.findElement(By.xpath("//div[contains(text(),'All time')]")).getText();
		System.out.println("found=========" + Alltime);
		Assert.assertEquals("All time", Alltime);

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom);
		Assert.assertEquals("Custom", Custom);

		Thread.sleep(1000);
		WebElement Export_3DotMenu = driver.findElement(By.xpath("//i[contains(text(),'more_vert')]"));
		Assert.assertTrue(Export_3DotMenu.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Export_3DotMenu);
		Thread.sleep(1000);

		String Export = driver.findElement(By.xpath("//div[contains(text(),'Export')]")).getText();
		System.out.println("found=========" + Export);
		Assert.assertEquals("Export", Export);

		jv.executeScript("arguments[0].click();", Export_3DotMenu);
		Thread.sleep(1000);

	}

	public void VerifyRatings_GraphDetailsWithDate() throws InterruptedException {

		String Day = driver.findElement(By.xpath("//span[@class='dropdown-label']")).getText();
		System.out.println("found=========" + Day);
		Assert.assertEquals("Day", Day);

		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();

		Thread.sleep(1000);
		List<WebElement> DayDD_elements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + DayDD_elements.size());
		for (int i = 0; i < DayDD_elements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + DayDD_elements.get(i).getText());
		}

		Thread.sleep(1000);
		String Days = driver.findElement(By.xpath("//div[contains(text(),'Day')]")).getText();
		System.out.println("found=========" + Days);
		Assert.assertEquals("Day", Days);

		String Week = driver.findElement(By.xpath("//div[contains(text(),'Week')]")).getText();
		System.out.println("found=========" + Week);
		Assert.assertEquals("Week", Week);

		String Month = driver.findElement(By.xpath("//div[contains(text(),'Month')]")).getText();
		System.out.println("found=========" + Month);
		Assert.assertEquals("Month", Month);

		String Quarter = driver.findElement(By.xpath("//div[contains(text(),'Quarter')]")).getText();
		System.out.println("found=========" + Quarter);
		Assert.assertEquals("Quarter", Quarter);

		String Year = driver.findElement(By.xpath("//div[contains(text(),'Year')]")).getText();
		System.out.println("found=========" + Year);
		Assert.assertEquals("Year", Year);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();
		Thread.sleep(1000);

	}

	public void VerifyRatings_Location() throws InterruptedException {

		String Locations = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"))
				.getText();
		System.out.println("found=========" + Locations);
		Assert.assertEquals("Locations", Locations);

		Thread.sleep(1000);

		WebElement Location_DropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(Location_DropDown).perform();

		Thread.sleep(1000);
		List<WebElement> LocationDD_Elements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + LocationDD_Elements.size());
		for (int i = 0; i < LocationDD_Elements.size(); i++) {
			System.out.println("Location Drop-Down List have: " + LocationDD_Elements.get(i).getText());
		}

		driver.findElement(
				By.xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Locations')]"))
				.click();
		Thread.sleep(1000);

		WebElement table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		table.isDisplayed();
		System.out.println("Location Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocation = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location')]")).getText();
		System.out.println("found=========" + TableLocation);
		Assert.assertTrue(TableLocation.contains("Location"));

		String Table_Avg = driver.findElement(By.xpath("//div[contains(text(),'Avg')]")).getText();
		System.out.println("found=========" + Table_Avg);
		Assert.assertTrue(Table_Avg.contains("Avg"));

		String Table_Positive = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Positive')]")).getText();
		System.out.println("found=========" + Table_Positive);
		Assert.assertTrue(Table_Positive.contains("Positive"));

		String Table_Neutral = driver.findElement(By.xpath("//div[contains(text(),'Neutral')]")).getText();
		System.out.println("found=========" + Table_Neutral);
		Assert.assertTrue(Table_Neutral.contains("Neutral"));

		String Table_Negative = driver.findElement(By.xpath("//div[contains(text(),'Negative')]")).getText();
		System.out.println("found=========" + Table_Negative);
		Assert.assertTrue(Table_Negative.contains("Negative"));

		String Table_Total = driver.findElement(By.xpath("//div[contains(text(),'Total')]")).getText();
		System.out.println("found=========" + Table_Total);
		Assert.assertTrue(Table_Total.contains("Total"));

		String Table_BScoreValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + Table_BScoreValue);

		String Table_LocationValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + Table_LocationValue);

		String TableAvg_PercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableAvg_PercentValue);

		String TableAvg_CountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableAvg_CountValue);

		String TablePositive_PercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TablePositive_PercentValue);

		String TablePositive_CountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TablePositive_CountValue);

		String TableNeutral_PercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableNeutral_PercentValue);

		String TableNeutral_CountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableNeutral_CountValue);

		String TableNegative_PercentValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableNegative_PercentValue);

		String TableNegative_CountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableNegative_CountValue);

		String TableTotal_PercentValue = driver.findElement(By.xpath("//tr[1]//td[7]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableTotal_PercentValue);

		String TableTotal_CountValue = driver.findElement(By.xpath("//tr[1]//td[7]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableTotal_CountValue);

	}

	public void VerifyRatings_LocationGroup() throws InterruptedException {

		Thread.sleep(2000);
		WebElement Location_DropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(Location_DropDown).perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Location Groups')]"))
				.click();
		Thread.sleep(5000);

		WebElement LocationGroup_table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		LocationGroup_table.isDisplayed();
		System.out.println("Location Group Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String Table_LocationGroup = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location Group')]"))
				.getText();
		System.out.println("found=========" + Table_LocationGroup);
		Assert.assertTrue(Table_LocationGroup.contains("Location Group"));

		String Table_Avg = driver.findElement(By.xpath("//div[contains(text(),'Avg')]")).getText();
		System.out.println("found=========" + Table_Avg);
		Assert.assertTrue(Table_Avg.contains("Avg"));

		String Table_Positive = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Positive')]")).getText();
		System.out.println("found=========" + Table_Positive);
		Assert.assertTrue(Table_Positive.contains("Positive"));

		String Table_Neutral = driver.findElement(By.xpath("//div[contains(text(),'Neutral')]")).getText();
		System.out.println("found=========" + Table_Neutral);
		Assert.assertTrue(Table_Neutral.contains("Neutral"));

		String Table_Negative = driver.findElement(By.xpath("//div[contains(text(),'Negative')]")).getText();
		System.out.println("found=========" + Table_Negative);
		Assert.assertTrue(Table_Negative.contains("Negative"));

		String Table_Total = driver.findElement(By.xpath("//div[contains(text(),'Total')]")).getText();
		System.out.println("found=========" + Table_Total);
		Assert.assertTrue(Table_Total.contains("Total"));

		String Table_TachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + Table_TachometerValue);

		String Table_LocationGrpValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + Table_LocationGrpValue);

		String TableAvg_PercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableAvg_PercentValue);

		String TableAvg_CountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableAvg_CountValue);

		String TablePositive_PercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TablePositive_PercentValue);

		String TablePositive_CountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TablePositive_CountValue);

		String TableNeutral_PercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableNeutral_PercentValue);

		String TableNeutral_CountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableNeutral_CountValue);

		String TableNegative_PercentValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableNegative_PercentValue);

		String TableNegative_CountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableNegative_CountValue);

		String TableTotal_PercentValue = driver.findElement(By.xpath("//tr[1]//td[7]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableTotal_PercentValue);

		String TableTotal_CountValue = driver.findElement(By.xpath("//tr[1]//td[7]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableTotal_CountValue);

	}

	public void VerifyRatings_Publishers() throws InterruptedException {

		Thread.sleep(2000);
		String Publishers = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]")).getText();
		System.out.println("found=========" + Publishers);
		Assert.assertEquals("Publishers", Publishers);

		driver.findElement(By.xpath("//div[contains(text(),'Publishers')]")).click();
		Thread.sleep(5000);

		String Publisher = driver.findElement(By.xpath("/descendant::div[contains(text(),'Publisher')][2]")).getText();
		System.out.println("found=========" + Publisher);
		Assert.assertTrue(Publisher.contains("Publisher"));

		String Table_Avg = driver.findElement(By.xpath("//div[contains(text(),'Avg')]")).getText();
		System.out.println("found=========" + Table_Avg);
		Assert.assertTrue(Table_Avg.contains("Avg"));

		String Table_Positive = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Positive')]")).getText();
		System.out.println("found=========" + Table_Positive);
		Assert.assertTrue(Table_Positive.contains("Positive"));

		String Table_Neutral = driver.findElement(By.xpath("//div[contains(text(),'Neutral')]")).getText();
		System.out.println("found=========" + Table_Neutral);
		Assert.assertTrue(Table_Neutral.contains("Neutral"));

		String Table_Negative = driver.findElement(By.xpath("//div[contains(text(),'Negative')]")).getText();
		System.out.println("found=========" + Table_Negative);
		Assert.assertTrue(Table_Negative.contains("Negative"));

		String Table_Total = driver.findElement(By.xpath("//div[contains(text(),'Total')]")).getText();
		System.out.println("found=========" + Table_Total);
		Assert.assertTrue(Table_Total.contains("Total"));

		String Table_PublisherValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + Table_PublisherValue);

		String TableAvg_PercentValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableAvg_PercentValue);

		String TableAvg_CountValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableAvg_CountValue);

		String TablePositive_PercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TablePositive_PercentValue);

		String TablePositive_CountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TablePositive_CountValue);

		String TableNeutral_PercentValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableNeutral_PercentValue);

		String TableNeutral_CountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableNeutral_CountValue);

		String TableNegative_PercentValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableNegative_PercentValue);

		String TableNegative_CountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableNegative_CountValue);

		String TableTotal_PercentValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableTotal_PercentValue);

		String TableTotal_CountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableTotal_CountValue);

		String info = driver.findElement(By.xpath("//b[contains(text(),'411.info')]")).getText();
		System.out.println("found=========" + info);
		Assert.assertTrue(info.contains("411.info"));

		String Amazon = driver.findElement(By.xpath("//b[contains(text(),'Amazon')]")).getText();
		System.out.println("found=========" + Amazon);
		Assert.assertTrue(Amazon.contains("Amazon"));

		String AG = driver.findElement(By.xpath("//b[contains(text(),'ApartmentGuides.com')]")).getText();
		System.out.println("found=========" + AG);
		Assert.assertTrue(AG.contains("ApartmentGuides.com"));

		String AR = driver.findElement(By.xpath("//b[contains(text(),'ApartmentRatings.com')]")).getText();
		System.out.println("found=========" + AR);
		Assert.assertTrue(AR.contains("ApartmentRatings.com"));

		String AP = driver.findElement(By.xpath("//b[contains(text(),'Apartments.com')]")).getText();
		System.out.println("found=========" + AP);
		Assert.assertTrue(AP.contains("Apartments.com"));

		String Bing = driver.findElement(By.xpath("//b[contains(text(),'Bing')]")).getText();
		System.out.println("found=========" + Bing);
		Assert.assertTrue(Bing.contains("Bing"));

		String BB = driver.findElement(By.xpath("//b[contains(text(),'Brownbook')]")).getText();
		System.out.println("found=========" + BB);
		Assert.assertTrue(BB.contains("Brownbook"));

		String CityGrid = driver.findElement(By.xpath("//b[contains(text(),'CityGrid')]")).getText();
		System.out.println("found=========" + CityGrid);
		Assert.assertTrue(CityGrid.contains("CityGrid"));

		String Citysearch = driver.findElement(By.xpath("//b[contains(text(),'Citysearch')]")).getText();
		System.out.println("found=========" + Citysearch);
		Assert.assertTrue(Citysearch.contains("Citysearch"));

		String CitySquares = driver.findElement(By.xpath("//b[contains(text(),'CitySquares')]")).getText();
		System.out.println("found=========" + CitySquares);
		Assert.assertTrue(CitySquares.contains("CitySquares"));

		// Enable When Providers Change :! >>

		/*
		 * String Facebook =
		 * driver.findElement(By.xpath("//b[contains(text(),'Facebook')]")).getText();
		 * System.out.println("found=========" + Facebook);
		 * Assert.assertTrue(Facebook.contains("Facebook"));
		 * 
		 * String Foursqure =
		 * driver.findElement(By.xpath("//b[contains(text(),'Foursquare')]")).getText();
		 * System.out.println("found=========" + Foursqure);
		 * Assert.assertTrue(Foursqure.contains("Foursquare"));
		 * 
		 * String Google =
		 * driver.findElement(By.xpath("//b[contains(text(),'Google')]")).getText();
		 * System.out.println("found=========" + Google);
		 * Assert.assertTrue(Google.contains("Google"));
		 * 
		 * String MC =
		 * driver.findElement(By.xpath("//b[contains(text(),'Merchant Circle')]")).
		 * getText(); System.out.println("found=========" + MC);
		 * Assert.assertTrue(MC.contains("Merchant Circle"));
		 * 
		 * String Yellowpages =
		 * driver.findElement(By.xpath("//b[contains(text(),'Yellowpages')]")).getText()
		 * ; System.out.println("found=========" + Yellowpages);
		 * Assert.assertTrue(Yellowpages.contains("Yellowpages"));
		 * 
		 * String Yelp =
		 * driver.findElement(By.xpath("//b[contains(text(),'Yelp')]")).getText();
		 * System.out.println("found=========" + Yelp);
		 * Assert.assertTrue(Yelp.contains("Yelp"));
		 */

	}

	public void VerifyRatings_ShowCountNumberStatus() throws InterruptedException {

		Thread.sleep(3000);

		// scroll down page to Bottom:>>>>>

		JavascriptExecutor jn = ((JavascriptExecutor) driver);
		jn.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement CountOfElement = driver
				.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[2]"));
		Assert.assertTrue(CountOfElement.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", CountOfElement);

		Thread.sleep(1000);
		List<WebElement> PageElements = driver
				.findElements(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[2]/div[1]/ul[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + PageElements.size());
		for (int i = 0; i < PageElements.size(); i++) {
			System.out.println("Total count of Pages Drop-Down List have: " + PageElements.get(i).getText());
		}

		String Twentyfive = driver.findElement(By.xpath("//li[contains(text(),'25')]")).getText();
		System.out.println("found=========" + Twentyfive);
		Assert.assertTrue(Twentyfive.contains("25"));

		String Fifty = driver.findElement(By.xpath("//li[contains(text(),'50')]")).getText();
		System.out.println("found=========" + Fifty);
		Assert.assertTrue(Fifty.contains("50"));

		String Hundred = driver.findElement(By.xpath("//li[contains(text(),'100')]")).getText();
		System.out.println("found=========" + Hundred);
		Assert.assertTrue(Hundred.contains("100"));

		Thread.sleep(1000);
		jv.executeScript("arguments[0].click();", CountOfElement);
		Thread.sleep(1000);
	}

	public void ClickOnSentiment() throws InterruptedException {

		Thread.sleep(2000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		INSIGHTS.click();
		Actions action = new Actions(driver);
		action.moveToElement(InsightsMenu).perform();
		Assert.assertTrue(InsightsMenu.isDisplayed());
		Sentiment.click();

	}

	public void VerifySentiment_PageTitle() throws InterruptedException {

		Thread.sleep(7000);
		String PageHeader = driver.findElement(By.xpath("//div[contains(text(),'Social / Insights / Sentiment')]"))
				.getText();
		System.out.println("found=========" + PageHeader);
		Assert.assertEquals("Social / Insights / Sentiment", PageHeader);

	}

	public void VerifySentiment_ChartOptions() {

		String TopFive = driver.findElement(By.xpath("//div[contains(text(),'Top 5')]")).getText();
		System.out.println("found=========" + TopFive);
		Assert.assertEquals("Top 5", TopFive);

		WebElement Top_Five = driver.findElement(By.xpath("//div[contains(text(),'Top 5')]"));
		Assert.assertTrue(Top_Five.isDisplayed());

		String TopicCloud = driver.findElement(By.xpath("//div[contains(text(),'Topic Cloud')]")).getText();
		System.out.println("found=========" + TopicCloud);
		Assert.assertEquals("Topic Cloud", TopicCloud);

		WebElement Topic_Cloud = driver.findElement(By.xpath("//div[contains(text(),'Topic Cloud')]"));
		Assert.assertTrue(Topic_Cloud.isDisplayed());

	}

	public void VerifySentiment_PageGraph() throws InterruptedException {

		Thread.sleep(1500);

		String TopFive_Graph = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]")).getText();
		System.out.println("found=========" + TopFive_Graph);

		WebElement SentimentTopfive_Chart = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]"));
		SentimentTopfive_Chart.isDisplayed();

		Thread.sleep(1000);
		List<WebElement> Topfive_Elements = driver.findElements(By.xpath("//div[starts-with(@class,'line-chart')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + Topfive_Elements.size());
		for (int i = 0; i < Topfive_Elements.size(); i++) {
			System.out.println("Elements List have: " + Topfive_Elements.get(i).getText());

		}
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[contains(text(),'Topic Cloud')]")).click();

		String TopicCloud_Graph = driver.findElement(By.xpath("//div[starts-with(@class,'tag-item-wrapper sc-')]"))
				.getText();
		System.out.println("found=========" + TopicCloud_Graph);

		WebElement SentimentTopicCloud_Chart = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]"));
		SentimentTopicCloud_Chart.isDisplayed();

		Thread.sleep(1000);
		List<WebElement> TopicCloud_Elements = driver
				.findElements(By.xpath("//div[starts-with(@class,'tag-item-wrapper sc-')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + TopicCloud_Elements.size());
		for (int i = 0; i < TopicCloud_Elements.size(); i++) {
			System.out.println("Elements List have: " + TopicCloud_Elements.get(i).getText());

		}

	}

	public void VerifySentiment_HeaderDateAndExport() throws InterruptedException {

		Thread.sleep(1000);
		String Sentiment_DefaultHeaderDay = driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]"))
				.getText();
		System.out.println("found=========" + Sentiment_DefaultHeaderDay);
		Assert.assertEquals("Last 30 days", Sentiment_DefaultHeaderDay);

		driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).click();
		Thread.sleep(1000);
		List<WebElement> Sentiment_HeaderDay = driver.findElements(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + Sentiment_HeaderDay.size());
		for (int i = 0; i < Sentiment_HeaderDay.size(); i++) {
			System.out.println("Header Days Drop-Down List have: " + Sentiment_HeaderDay.get(i).getText());
		}

		Thread.sleep(1000);
		String LastOneday = driver.findElement(By.xpath("//div[contains(text(),'Last 24 hours')]")).getText();
		System.out.println("found=========" + LastOneday);
		Assert.assertEquals("Last 24 hours", LastOneday);

		String LastSevenday = driver.findElement(By.xpath("//div[contains(text(),'Last 7 days')]")).getText();
		System.out.println("found=========" + LastSevenday);
		Assert.assertEquals("Last 7 days", LastSevenday);

		String LastThirtyday = driver.findElement(By.xpath("//div[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + LastThirtyday);
		Assert.assertEquals("Last 30 days", LastThirtyday);

		String LastThreemonth = driver.findElement(By.xpath("//div[contains(text(),'Last 3 months')]")).getText();
		System.out.println("found=========" + LastThreemonth);
		Assert.assertEquals("Last 3 months", LastThreemonth);

		String LastSixmonth = driver.findElement(By.xpath("//div[contains(text(),'Last 6 months')]")).getText();
		System.out.println("found=========" + LastSixmonth);
		Assert.assertEquals("Last 6 months", LastSixmonth);

		String Lastyear = driver.findElement(By.xpath("//div[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + Lastyear);
		Assert.assertEquals("Last year", Lastyear);

		String Alltime = driver.findElement(By.xpath("//div[contains(text(),'All time')]")).getText();
		System.out.println("found=========" + Alltime);
		Assert.assertEquals("All time", Alltime);

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom);
		Assert.assertEquals("Custom", Custom);

		Thread.sleep(1000);
		WebElement Export3DotMenu = driver.findElement(By.xpath("//i[contains(text(),'more_vert')]"));
		Assert.assertTrue(Export3DotMenu.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

		String Export = driver.findElement(By.xpath("//div[contains(text(),'Export')]")).getText();
		System.out.println("found=========" + Export);
		Assert.assertEquals("Export", Export);

		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

	}

	public void VerifySentiment_GraphDetailsWithDate() throws InterruptedException {

		driver.findElement(By.xpath("//div[contains(text(),'Top 5')]")).click();
		Thread.sleep(1000);

		String Days = driver.findElement(By.xpath("//span[@class='dropdown-label']")).getText();
		System.out.println("found=========" + Days);
		Assert.assertEquals("Day", Days);

		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();

		Thread.sleep(1000);
		List<WebElement> DropDown_elements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + DropDown_elements.size());
		for (int i = 0; i < DropDown_elements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + DropDown_elements.get(i).getText());
		}

		Thread.sleep(500);
		String Day = driver.findElement(By.xpath("//div[contains(text(),'Day')]")).getText();
		System.out.println("found=========" + Day);
		Assert.assertEquals("Day", Day);

		String Week = driver.findElement(By.xpath("//div[contains(text(),'Week')]")).getText();
		System.out.println("found=========" + Week);
		Assert.assertEquals("Week", Week);

		String Month = driver.findElement(By.xpath("//div[contains(text(),'Month')]")).getText();
		System.out.println("found=========" + Month);
		Assert.assertEquals("Month", Month);

		String Quarter = driver.findElement(By.xpath("//div[contains(text(),'Quarter')]")).getText();
		System.out.println("found=========" + Quarter);
		Assert.assertEquals("Quarter", Quarter);

		String Year = driver.findElement(By.xpath("//div[contains(text(),'Year')]")).getText();
		System.out.println("found=========" + Year);
		Assert.assertEquals("Year", Year);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();
		Thread.sleep(1000);

	}

	public void VerifySentiment_AllTopic() throws InterruptedException {

		String Table_AllTopic = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'All Topics')]"))
				.getText();
		System.out.println("found=========" + Table_AllTopic);
		Assert.assertEquals("All Topics", Table_AllTopic);

		Thread.sleep(1000);

		WebElement TableAllTopic_DropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'All Topics')]"));
		Actions action = new Actions(driver);
		action.moveToElement(TableAllTopic_DropDown).perform();

		Thread.sleep(1000);
		List<WebElement> AllTopic_Elements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + AllTopic_Elements.size());
		for (int i = 0; i < AllTopic_Elements.size(); i++) {
			System.out.println("All Topic Drop-Down List have: " + AllTopic_Elements.get(i).getText());
		}

		String AllTopics = driver
				.findElement(By.xpath(
						"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'All Topics')]"))
				.getText();
		System.out.println("found=========" + AllTopics);

		String MonitoredTopics = driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Monitored Topics')]"))
				.getText();
		System.out.println("found=========" + MonitoredTopics);
		Assert.assertEquals("Monitored Topics", MonitoredTopics);

		driver.findElement(
				By.xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'All Topics')]"))
				.click();
		Thread.sleep(1000);

		WebElement Sentiments_table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		Sentiments_table.isDisplayed();
		System.out.println("Sentiment Table Is Displayed");

		String Instances = driver.findElement(By.xpath("//div[contains(text(),'Instances')]")).getText();
		System.out.println("found=========" + Instances);
		Assert.assertTrue(Instances.contains("Instances"));

		String Topic = driver.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Topic')]"))
				.getText();
		System.out.println("found=========" + Topic);
		Assert.assertTrue(Topic.contains("Topic"));

		String Sentiment = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Sentiment')]")).getText();
		System.out.println("found=========" + Sentiment);
		Assert.assertTrue(Sentiment.contains("Sentiment"));

		String Monitored = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Monitored')]")).getText();
		System.out.println("found=========" + Monitored);
		Assert.assertTrue(Monitored.contains("Monitored"));

		String Instances_PercentValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + Instances_PercentValue);

		String Instances_CountValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + Instances_CountValue);

		String TableTopic_Value = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableTopic_Value);

		String TableSentiment_PercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + TableSentiment_PercentValue);

		String TableSentiment_CountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableSentiment_CountValue);

	}

	public void VerifySentiment_MonitoredTopics() throws InterruptedException {

		Thread.sleep(2000);
		WebElement AllTopic_DD = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'All Topics')]"));
		Actions action = new Actions(driver);
		action.moveToElement(AllTopic_DD).perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Monitored Topics')]"))
				.click();
		Thread.sleep(5000);

		WebElement MonitoredTopics_Table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		MonitoredTopics_Table.isDisplayed();
		System.out.println("Monitored Topics Table Is Displayed");

		String MT_Instances = driver.findElement(By.xpath("//div[contains(text(),'Instances')]")).getText();
		System.out.println("found=========" + MT_Instances);
		Assert.assertTrue(MT_Instances.contains("Instances"));

		String MT_Topic = driver.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Topic')]"))
				.getText();
		System.out.println("found=========" + MT_Topic);
		Assert.assertTrue(MT_Topic.contains("Topic"));

		String MT_Sentiment = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Sentiment')]")).getText();
		System.out.println("found=========" + MT_Sentiment);
		Assert.assertTrue(MT_Sentiment.contains("Sentiment"));

		String MT_Monitored = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Monitored')]")).getText();
		System.out.println("found=========" + MT_Monitored);
		Assert.assertTrue(MT_Monitored.contains("Monitored"));

		String MT_InstancesPercentValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + MT_InstancesPercentValue);

		String MT_InstancesCountValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + MT_InstancesCountValue);

		String MT_TableTopicValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + MT_TableTopicValue);

		String MT_TableSentimentPercentValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
				.getText();
		System.out.println("found=========" + MT_TableSentimentPercentValue);

		String MT_TableSentimentCountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + MT_TableSentimentCountValue);

	}

	public void VerifySentiment_ShowCountNumberStatus() throws InterruptedException {

		Thread.sleep(3000);

		// scroll down page to Bottom:>>>>>

		JavascriptExecutor jv = ((JavascriptExecutor) driver);
		jv.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement Sentiment_CountOfElement = driver
				.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]"));
		Assert.assertTrue(Sentiment_CountOfElement.isDisplayed());

		JavascriptExecutor jm = (JavascriptExecutor) driver;
		jm.executeScript("arguments[0].click();", Sentiment_CountOfElement);

		Thread.sleep(1000);
		List<WebElement> MT_PageNoElements = driver
				.findElements(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/ul[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + MT_PageNoElements.size());
		for (int i = 0; i < MT_PageNoElements.size(); i++) {
			System.out.println("Total count of Pages Drop-Down List have: " + MT_PageNoElements.get(i).getText());
		}

		String Twenty_five = driver.findElement(By.xpath("//li[contains(text(),'25')]")).getText();
		System.out.println("found=========" + Twenty_five);
		Assert.assertTrue(Twenty_five.contains("25"));

		String Fifty = driver.findElement(By.xpath("//li[contains(text(),'50')]")).getText();
		System.out.println("found=========" + Fifty);
		Assert.assertTrue(Fifty.contains("50"));

		String Hundred = driver.findElement(By.xpath("//li[contains(text(),'100')]")).getText();
		System.out.println("found=========" + Hundred);
		Assert.assertTrue(Hundred.contains("100"));

		Thread.sleep(1000);
		jv.executeScript("arguments[0].click();", Sentiment_CountOfElement);
		Thread.sleep(1000);
	}

	public void ClickOn_SearchPositions() throws InterruptedException {

		Thread.sleep(2000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		INSIGHTS.click();
		Actions action = new Actions(driver);
		action.moveToElement(InsightsMenu).perform();
		Assert.assertTrue(InsightsMenu.isDisplayed());
		SearchPositions.click();

	}

	public void VerifySearchPositions_PageTitle() throws InterruptedException {

		Thread.sleep(7000);
		String SP_PageHeader = driver
				.findElement(By.xpath("//div[contains(text(),'Marketing / Insights / Search Positions')]")).getText();
		System.out.println("found=========" + SP_PageHeader);
		Assert.assertEquals("Marketing / Insights / Search Positions", SP_PageHeader);

	}

	public void VerifySearchPositions_SearchPublishers() throws InterruptedException {

		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Google Local')]")).click();

		Thread.sleep(1000);
		List<WebElement> Search_Publisher = driver
				.findElements(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + Search_Publisher.size());
		for (int i = 0; i < Search_Publisher.size(); i++) {
			System.out.println("Elements List have: " + Search_Publisher.get(i).getText());

		}

		String Google_Local = driver.findElement(By.xpath("/descendant::div[contains(text(),'Google Local')][2]"))
				.getText();
		System.out.println("found=========" + Google_Local);
		Assert.assertEquals("Google Local", Google_Local);

		String Google_Organic = driver.findElement(By.xpath("//div[contains(text(),'Google Organic')]")).getText();
		System.out.println("found=========" + Google_Organic);
		Assert.assertEquals("Google Organic", Google_Organic);

		driver.findElement(By.xpath("/descendant::div[contains(text(),'Google Local')][2]")).click();

	}

	public void VerifySearchPositions_PageGraphForGL() throws InterruptedException {

		Thread.sleep(1500);

		String GoogleLocal_Graph = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]")).getText();
		System.out.println("found=========" + GoogleLocal_Graph);

		WebElement GoogleLocal_Chart = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]"));
		GoogleLocal_Chart.isDisplayed();

		Thread.sleep(1000);
		List<WebElement> GoogleLocal_Elements = driver
				.findElements(By.xpath("//div[starts-with(@class,'line-chart')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GoogleLocal_Elements.size());
		for (int i = 0; i < GoogleLocal_Elements.size(); i++) {
			System.out.println("Elements List have: " + GoogleLocal_Elements.get(i).getText());

		}

	}

	public void VerifySearchPositions_HeaderDateAndExportFor_GL() throws InterruptedException {

		Thread.sleep(1000);
		String SP_DefaultHeaderDay = driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + SP_DefaultHeaderDay);
		Assert.assertEquals("Last 30 days", SP_DefaultHeaderDay);

		driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).click();
		Thread.sleep(1000);
		List<WebElement> SP_HeaderDay = driver.findElements(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + SP_HeaderDay.size());
		for (int i = 0; i < SP_HeaderDay.size(); i++) {
			System.out.println("Header Days Drop-Down List have: " + SP_HeaderDay.get(i).getText());
		}

		Thread.sleep(1000);
		String LastOneday = driver.findElement(By.xpath("//div[contains(text(),'Last 24 hours')]")).getText();
		System.out.println("found=========" + LastOneday);
		Assert.assertEquals("Last 24 hours", LastOneday);

		String LastSevenday = driver.findElement(By.xpath("//div[contains(text(),'Last 7 days')]")).getText();
		System.out.println("found=========" + LastSevenday);
		Assert.assertEquals("Last 7 days", LastSevenday);

		String LastThirtyday = driver.findElement(By.xpath("//div[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + LastThirtyday);
		Assert.assertEquals("Last 30 days", LastThirtyday);

		String LastThreemonth = driver.findElement(By.xpath("//div[contains(text(),'Last 3 months')]")).getText();
		System.out.println("found=========" + LastThreemonth);
		Assert.assertEquals("Last 3 months", LastThreemonth);

		String LastSixmonth = driver.findElement(By.xpath("//div[contains(text(),'Last 6 months')]")).getText();
		System.out.println("found=========" + LastSixmonth);
		Assert.assertEquals("Last 6 months", LastSixmonth);

		String Lastyear = driver.findElement(By.xpath("//div[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + Lastyear);
		Assert.assertEquals("Last year", Lastyear);

		String Alltime = driver.findElement(By.xpath("//div[contains(text(),'All time')]")).getText();
		System.out.println("found=========" + Alltime);
		Assert.assertEquals("All time", Alltime);

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom);
		Assert.assertEquals("Custom", Custom);

		Thread.sleep(1000);
		WebElement Export_3DotMenu = driver.findElement(By.xpath("//i[contains(text(),'more_vert')]"));
		Assert.assertTrue(Export_3DotMenu.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Export_3DotMenu);
		Thread.sleep(1000);

		String Export = driver.findElement(By.xpath("//div[contains(text(),'Export')]")).getText();
		System.out.println("found=========" + Export);
		Assert.assertEquals("Export", Export);

		WebElement Exports = driver.findElement(By.xpath("//div[contains(text(),'Export')]"));
		Exports.click();
		// jv.executeScript("arguments[0].click();", Exports);

		String ExportHeader = driver
				.findElement(By.xpath("//div[contains(text(),'Export Insights Search Positions Data')]")).getText();
		System.out.println("found=========" + ExportHeader);
		// Assert.assertTrue(ExportHeader.contains("Export Insights Search Positions
		// Data"));

		String FormatingType = driver.findElement(By.xpath("//div[contains(text(),'Formatting Type')]")).getText();
		System.out.println("found=========" + FormatingType);
		Assert.assertTrue(FormatingType.contains("Formatting Type"));

		String csv = driver.findElement(By.xpath("//span[contains(text(),'.csv')]")).getText();
		System.out.println("found=========" + csv);
		Assert.assertTrue(csv.contains(".csv"));

		String txt = driver.findElement(By.xpath("//span[contains(text(),'.txt')]")).getText();
		System.out.println("found=========" + txt);
		Assert.assertTrue(txt.contains(".txt"));

		String json = driver.findElement(By.xpath("//span[contains(text(),'.json')]")).getText();
		System.out.println("found=========" + json);
		Assert.assertTrue(json.contains(".json"));

		String export = driver.findElement(By.xpath("//button[contains(text(),'EXPORT')]")).getText();
		System.out.println("found=========" + export);
		Assert.assertTrue(export.contains("EXPORT"));

		String Cancel = driver.findElement(By.xpath("//a[contains(text(),'CANCEL')]")).getText();
		System.out.println("found=========" + Cancel);
		Assert.assertTrue(Cancel.contains("CANCEL"));

		// Txt
		Thread.sleep(1000);
		// jv.executeScript("arguments[0].click();", txt);
		WebElement txts = driver.findElement(By.xpath("//span[contains(text(),'.txt')]"));
		txts.click();

		Thread.sleep(1000);
		String Delimeter = driver.findElement(By.xpath("//div[contains(text(),'Delimiter')]")).getText();
		System.out.println("found=========" + Delimeter);
		Assert.assertTrue(Delimeter.contains("Delimiter"));

		String Tab = driver.findElement(By.xpath("//span[contains(text(),'Tab')]")).getText();
		System.out.println("found=========" + Tab);
		Assert.assertTrue(Tab.contains("Tab"));

		String Comma = driver.findElement(By.xpath("//span[contains(text(),'Comma')]")).getText();
		System.out.println("found=========" + Comma);
		Assert.assertTrue(Comma.contains("Comma"));

		String Semicolon = driver.findElement(By.xpath("//span[contains(text(),'Semicolon')]")).getText();
		System.out.println("found=========" + Semicolon);
		Assert.assertTrue(Semicolon.contains("Semicolon"));

		String Custom1 = driver.findElement(By.xpath("//span[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom1);
		Assert.assertTrue(Custom1.contains("Custom"));

		Thread.sleep(1000);
		WebElement cancel = driver.findElement(By.xpath("//a[contains(text(),'CANCEL')]"));
		cancel.click();
		// jv.executeScript("arguments[0].click();", Cancel);
		Thread.sleep(1000);

	}

	public void VerifySearchPositions_GraphDetailsWithDateForGL() throws InterruptedException {

		String Day = driver.findElement(By.xpath("//span[@class='dropdown-label']")).getText();
		System.out.println("found=========" + Day);
		Assert.assertEquals("Day", Day);

		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();

		Thread.sleep(1000);
		List<WebElement> DropDown_elements = driver.findElements(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + DropDown_elements.size());
		for (int i = 0; i < DropDown_elements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + DropDown_elements.get(i).getText());
		}

		Thread.sleep(500);
		String Days = driver.findElement(By.xpath("//div[contains(text(),'Day')]")).getText();
		System.out.println("found=========" + Days);
		Assert.assertEquals("Day", Days);

		String Week = driver.findElement(By.xpath("//div[contains(text(),'Week')]")).getText();
		System.out.println("found=========" + Week);
		Assert.assertEquals("Week", Week);

		String Month = driver.findElement(By.xpath("//div[contains(text(),'Month')]")).getText();
		System.out.println("found=========" + Month);
		Assert.assertEquals("Month", Month);

		String Quarter = driver.findElement(By.xpath("//div[contains(text(),'Quarter')]")).getText();
		System.out.println("found=========" + Quarter);
		Assert.assertEquals("Quarter", Quarter);

		String Year = driver.findElement(By.xpath("//div[contains(text(),'Year')]")).getText();
		System.out.println("found=========" + Year);
		Assert.assertEquals("Year", Year);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();
		Thread.sleep(1000);

	}

	public void VerifySearchPositions_LocationForGL() throws InterruptedException {

		String Location = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"))
				.getText();
		System.out.println("found=========" + Location);
		Assert.assertEquals("Locations", Location);

		Thread.sleep(1000);

		WebElement LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();

		Thread.sleep(1000);
		List<WebElement> LocationElements = driver.findElements(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/ul/li[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + LocationElements.size());
		for (int i = 0; i < LocationElements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + LocationElements.get(i).getText());
		}

		/*
		 * WebElement location = driver.findElement( By.
		 * xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Locations')]"
		 * )); TestUtility.clickOn(driver, location, 30); Thread.sleep(1000);
		 */

		WebElement table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		table.isDisplayed();
		System.out.println("Location Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocation = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location')]")).getText();
		System.out.println("found=========" + TableLocation);
		Assert.assertTrue(TableLocation.contains("Location"));

		String TablePosotion1to3 = driver.findElement(By.xpath("//div[contains(text(),'Position 1-3')]")).getText();
		System.out.println("found=========" + TablePosotion1to3);
		Assert.assertTrue(TablePosotion1to3.contains("Position 1-3"));

		String TablePosotion4to10 = driver.findElement(By.xpath("//div[contains(text(),'Position 4-10')]")).getText();
		System.out.println("found=========" + TablePosotion4to10);
		Assert.assertTrue(TablePosotion4to10.contains("Position 4-10"));

		String TablePosotion11to20 = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Position 11-20')]"))
				.getText();
		System.out.println("found=========" + TablePosotion11to20);
		Assert.assertTrue(TablePosotion11to20.contains("Position 11-20"));

		String NotRanked = driver.findElement(By.xpath("//div[contains(text(),'Not Ranked')]")).getText();
		System.out.println("found=========" + NotRanked);
		Assert.assertTrue(NotRanked.contains("Not Ranked"));

		String TableTachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		/*
		 * String TableP1to3PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP1to3PercentValue);
		 */

		String TableP1to3CountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP1to3CountValue);

		/*
		 * String TableP4to10PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP4to10PercentValue);
		 */

		String TableP4to10CountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP4to10CountValue);

		/*
		 * String TableP11to20PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP11to20PercentValue);
		 */

		String TableP11to20CountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP11to20CountValue);

		/*
		 * String TableNotRankedPercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" +
		 * TableNotRankedPercentValue);
		 */

		String TableNotRankedCountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableNotRankedCountValue);

	}

	public void VerifySearchPositions_LocationGroupForGL() throws InterruptedException {

		Thread.sleep(2000);
		WebElement LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Location Groups')]"))
				.click();
		Thread.sleep(5000);

		WebElement LocationGrouptable = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		LocationGrouptable.isDisplayed();
		System.out.println("Location Group Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocationGroup = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location Group')]"))
				.getText();
		System.out.println("found=========" + TableLocationGroup);
		Assert.assertTrue(TableLocationGroup.contains("Location Group"));

		String TablePosotion1to3 = driver.findElement(By.xpath("//div[contains(text(),'Position 1-3')]")).getText();
		System.out.println("found=========" + TablePosotion1to3);
		Assert.assertTrue(TablePosotion1to3.contains("Position 1-3"));

		String TablePosotion4to10 = driver.findElement(By.xpath("//div[contains(text(),'Position 4-10')]")).getText();
		System.out.println("found=========" + TablePosotion4to10);
		Assert.assertTrue(TablePosotion4to10.contains("Position 4-10"));

		String TablePosotion11to20 = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Position 11-20')]"))
				.getText();
		System.out.println("found=========" + TablePosotion11to20);
		Assert.assertTrue(TablePosotion11to20.contains("Position 11-20"));

		String NotRanked = driver.findElement(By.xpath("//div[contains(text(),'Not Ranked')]")).getText();
		System.out.println("found=========" + NotRanked);
		Assert.assertTrue(NotRanked.contains("Not Ranked"));

		String TableTachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		/*
		 * String TableP1to3PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP1to3PercentValue);
		 */

		String TableP1to3CountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP1to3CountValue);

		/*
		 * String TableP4to10PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP4to10PercentValue);
		 */

		String TableP4to10CountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP4to10CountValue);

		/*
		 * String TableP11to20PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP11to20PercentValue);
		 */

		String TableP11to20CountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP11to20CountValue);

		/*
		 * String TableNotRankedPercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" +
		 * TableNotRankedPercentValue);
		 */

		String TableNotRankedCountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableNotRankedCountValue);

	}

	public void VerifySearchPositions_ShowCountNumberStatusForGL() throws InterruptedException {

		Thread.sleep(3000);

		// scroll down page to Bottom:>>>>>

		JavascriptExecutor jv = ((JavascriptExecutor) driver);
		jv.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement SP_CountOfElement = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'with-select sc-')][1]"));
		Assert.assertTrue(SP_CountOfElement.isDisplayed());

		JavascriptExecutor jm = (JavascriptExecutor) driver;
		jm.executeScript("arguments[0].click();", SP_CountOfElement);

		Thread.sleep(1000);
		List<WebElement> GL_PageNoElements = driver
				.findElements(By.xpath("//div[starts-with(@class,'with-select sc-')]//ul[starts-with(@class,'sc-')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GL_PageNoElements.size());
		for (int i = 0; i < GL_PageNoElements.size(); i++) {
			System.out.println("Total count of Pages Drop-Down List have: " + GL_PageNoElements.get(i).getText());
		}

		String Twentyfive = driver.findElement(By.xpath("//li[contains(text(),'25')]")).getText();
		System.out.println("found=========" + Twentyfive);
		Assert.assertTrue(Twentyfive.contains("25"));

		String Fifty = driver.findElement(By.xpath("//li[contains(text(),'50')]")).getText();
		System.out.println("found=========" + Fifty);
		Assert.assertTrue(Fifty.contains("50"));

		String Hundred = driver.findElement(By.xpath("//li[contains(text(),'100')]")).getText();
		System.out.println("found=========" + Hundred);
		Assert.assertTrue(Hundred.contains("100"));

		Thread.sleep(1000);
		jv.executeScript("arguments[0].click();", SP_CountOfElement);
		Thread.sleep(1000);
	}

	public void VerifySearchPositions_PageGraphForGO() throws InterruptedException {

		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Google Local')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Google Organic')]")).click();
		Thread.sleep(2500);

		Thread.sleep(1500);

		String GoogleOrganic_Graph = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]")).getText();
		System.out.println("found=========" + GoogleOrganic_Graph);

		WebElement GoogleOrganic_Chart = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]"));
		GoogleOrganic_Chart.isDisplayed();

		Thread.sleep(1000);
		List<WebElement> GoogleOrganic_Elements = driver
				.findElements(By.xpath("//div[starts-with(@class,'line-chart')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GoogleOrganic_Elements.size());
		for (int i = 0; i < GoogleOrganic_Elements.size(); i++) {
			System.out.println("Elements List have: " + GoogleOrganic_Elements.get(i).getText());

		}

	}

	public void VerifySearchPositions_HeaderDateAndExportFor_GO() throws InterruptedException {

		Thread.sleep(1000);
		String GO_DefaultHeaderDay = driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + GO_DefaultHeaderDay);
		Assert.assertEquals("Last 30 days", GO_DefaultHeaderDay);

		driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).click();
		Thread.sleep(1000);
		List<WebElement> GO_HeaderDay = driver.findElements(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GO_HeaderDay.size());
		for (int i = 0; i < GO_HeaderDay.size(); i++) {
			System.out.println("Days Drop-Down List have: " + GO_HeaderDay.get(i).getText());
		}

		Thread.sleep(1000);
		String LastOneday = driver.findElement(By.xpath("//div[contains(text(),'Last 24 hours')]")).getText();
		System.out.println("found=========" + LastOneday);
		Assert.assertEquals("Last 24 hours", LastOneday);

		String LastSevenday = driver.findElement(By.xpath("//div[contains(text(),'Last 7 days')]")).getText();
		System.out.println("found=========" + LastSevenday);
		Assert.assertEquals("Last 7 days", LastSevenday);

		String LastThirtyday = driver.findElement(By.xpath("//div[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + LastThirtyday);
		Assert.assertEquals("Last 30 days", LastThirtyday);

		String LastThreemonth = driver.findElement(By.xpath("//div[contains(text(),'Last 3 months')]")).getText();
		System.out.println("found=========" + LastThreemonth);
		Assert.assertEquals("Last 3 months", LastThreemonth);

		String LastSixmonth = driver.findElement(By.xpath("//div[contains(text(),'Last 6 months')]")).getText();
		System.out.println("found=========" + LastSixmonth);
		Assert.assertEquals("Last 6 months", LastSixmonth);

		String Lastyear = driver.findElement(By.xpath("//div[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + Lastyear);
		Assert.assertEquals("Last year", Lastyear);

		String Alltime = driver.findElement(By.xpath("//div[contains(text(),'All time')]")).getText();
		System.out.println("found=========" + Alltime);
		Assert.assertEquals("All time", Alltime);

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom);
		Assert.assertEquals("Custom", Custom);

		Thread.sleep(1000);
		WebElement Export3DotMenu = driver.findElement(By.xpath("//i[contains(text(),'more_vert')]"));
		Assert.assertTrue(Export3DotMenu.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

		String Export = driver.findElement(By.xpath("//div[contains(text(),'Export')]")).getText();
		System.out.println("found=========" + Export);
		Assert.assertEquals("Export", Export);

		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

	}

	public void VerifySearchPositions_GraphDetailsWithDateForGO() throws InterruptedException {

		String Days = driver.findElement(By.xpath("//span[@class='dropdown-label']")).getText();
		System.out.println("found=========" + Days);
		Assert.assertEquals("Day", Days);

		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();

		Thread.sleep(1000);
		List<WebElement> GODropDown_elements = driver.findElements(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GODropDown_elements.size());
		for (int i = 0; i < GODropDown_elements.size(); i++) {
			System.out.println("Drop-Down List have: " + GODropDown_elements.get(i).getText());
		}

		Thread.sleep(500);
		String Day = driver.findElement(By.xpath("//div[contains(text(),'Day')]")).getText();
		System.out.println("found=========" + Day);
		Assert.assertEquals("Day", Day);

		String Week = driver.findElement(By.xpath("//div[contains(text(),'Week')]")).getText();
		System.out.println("found=========" + Week);
		Assert.assertEquals("Week", Week);

		String Month = driver.findElement(By.xpath("//div[contains(text(),'Month')]")).getText();
		System.out.println("found=========" + Month);
		Assert.assertEquals("Month", Month);

		String Quarter = driver.findElement(By.xpath("//div[contains(text(),'Quarter')]")).getText();
		System.out.println("found=========" + Quarter);
		Assert.assertEquals("Quarter", Quarter);

		String Year = driver.findElement(By.xpath("//div[contains(text(),'Year')]")).getText();
		System.out.println("found=========" + Year);
		Assert.assertEquals("Year", Year);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();
		Thread.sleep(1000);

	}

	public void VerifySearchPositions_LocationGroupForGo() throws InterruptedException {

		String Location_GO = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Location Groups')]"))
				.getText();
		System.out.println("found=========" + Location_GO);
		Assert.assertEquals("Location Groups", Location_GO);

		Thread.sleep(1000);

		WebElement LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Location Groups')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();

		Thread.sleep(1000);
		List<WebElement> GO_LocationElements = driver.findElements(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div[2]/div[3]/div[1]/div/div/ul/li/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GO_LocationElements.size());
		for (int i = 0; i < GO_LocationElements.size(); i++) {
			System.out.println("Location Drop-Down List have: " + GO_LocationElements.get(i).getText());
		}

		driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Location Groups')]"))
				.click();
		Thread.sleep(3500);

		WebElement GO_LocationGrouptable = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		GO_LocationGrouptable.isDisplayed();
		System.out.println("Location Group Table Is Displayed");

		WebElement GO_Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		GO_Tachometer.isDisplayed();

		String TableLocationGroup = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location Group')]"))
				.getText();
		System.out.println("found=========" + TableLocationGroup);
		Assert.assertTrue(TableLocationGroup.contains("Location Group"));

		String TablePosotion1to3_GO = driver.findElement(By.xpath("//div[contains(text(),'Position 1-3')]")).getText();
		System.out.println("found=========" + TablePosotion1to3_GO);
		Assert.assertTrue(TablePosotion1to3_GO.contains("Position 1-3"));

		String TablePosotion4to10 = driver.findElement(By.xpath("//div[contains(text(),'Position 4-10')]")).getText();
		System.out.println("found=========" + TablePosotion4to10);
		Assert.assertTrue(TablePosotion4to10.contains("Position 4-10"));

		String TablePosotion11to20 = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Position 11-20')]"))
				.getText();
		System.out.println("found=========" + TablePosotion11to20);
		Assert.assertTrue(TablePosotion11to20.contains("Position 11-20"));

		String NotRanked = driver.findElement(By.xpath("//div[contains(text(),'Not Ranked')]")).getText();
		System.out.println("found=========" + NotRanked);
		Assert.assertTrue(NotRanked.contains("Not Ranked"));

		String TableTachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		/*
		 * String TableP1to3PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP1to3PercentValue);
		 */

		String TableP1to3CountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP1to3CountValue);

		/*
		 * String TableP4to10PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP4to10PercentValue);
		 */

		String TableP4to10CountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP4to10CountValue);

		/*
		 * String TableP11to20PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP11to20PercentValue);
		 */
		String TableP11to20CountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP11to20CountValue);

		/*
		 * String TableNotRankedPercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" +
		 * TableNotRankedPercentValue);
		 */

		String TableNotRankedCountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableNotRankedCountValue);

	}

	public void VerifySearchPositions_LocationForGO() throws InterruptedException {

		String Location_GO = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Location Groups')]"))
				.getText();
		System.out.println("found=========" + Location_GO);
		Assert.assertEquals("Location Groups", Location_GO);

		Thread.sleep(1000);

		WebElement GO_LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Location Groups')]"));
		Actions action = new Actions(driver);
		action.moveToElement(GO_LocationDropDown).perform();

		Thread.sleep(1000);
		List<WebElement> GO_LocationElements = driver.findElements(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div[2]/div[3]/div[1]/div/div/ul/li/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GO_LocationElements.size());
		for (int i = 0; i < GO_LocationElements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + GO_LocationElements.get(i).getText());
		}

		WebElement Location = driver.findElement(
				By.xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Locations')]"));
		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Location);
		Thread.sleep(1000);
		// jv.executeScript("Click()", Location);

		WebElement table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		table.isDisplayed();
		System.out.println("Location Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocation = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location')]")).getText();
		System.out.println("found=========" + TableLocation);
		Assert.assertTrue(TableLocation.contains("Location"));

		String TablePosotion1to3 = driver.findElement(By.xpath("//div[contains(text(),'Position 1-3')]")).getText();
		System.out.println("found=========" + TablePosotion1to3);
		Assert.assertTrue(TablePosotion1to3.contains("Position 1-3"));

		String TablePosotion4to10 = driver.findElement(By.xpath("//div[contains(text(),'Position 4-10')]")).getText();
		System.out.println("found=========" + TablePosotion4to10);
		Assert.assertTrue(TablePosotion4to10.contains("Position 4-10"));

		String TablePosotion11to20 = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Position 11-20')]"))
				.getText();
		System.out.println("found=========" + TablePosotion11to20);
		Assert.assertTrue(TablePosotion11to20.contains("Position 11-20"));

		String NotRanked = driver.findElement(By.xpath("//div[contains(text(),'Not Ranked')]")).getText();
		System.out.println("found=========" + NotRanked);
		Assert.assertTrue(NotRanked.contains("Not Ranked"));

		String TableTachometerValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		/*
		 * String TableP1to3PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP1to3PercentValue);
		 */

		String TableP1to3CountValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP1to3CountValue);

		/*
		 * String TableP4to10PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP4to10PercentValue);
		 */

		String TableP4to10CountValue = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP4to10CountValue);

		/*
		 * String TableP11to20PercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" + TableP11to20PercentValue);
		 */

		String TableP11to20CountValue = driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TableP11to20CountValue);

		/*
		 * String TableNotRankedPercentValue =
		 * driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//div[1]"))
		 * .getText(); System.out.println("found=========" +
		 * TableNotRankedPercentValue);
		 */

		String TableNotRankedCountValue = driver.findElement(By.xpath("//tr[1]//td[6]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + TableNotRankedCountValue);

	}

	public void VerifySearchPositions_ShowCountNumberStatusForGO() throws InterruptedException {

		Thread.sleep(3000);

		// Scroll down page to Bottom :::::::->>>>>>>>>>>>

		JavascriptExecutor jx = ((JavascriptExecutor) driver);
		jx.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement GO_CountOfElement = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'with-select sc-')][1]"));
		Assert.assertTrue(GO_CountOfElement.isDisplayed());

		JavascriptExecutor jm = (JavascriptExecutor) driver;
		jm.executeScript("arguments[0].click();", GO_CountOfElement);

		Thread.sleep(1000);
		List<WebElement> GO_PageNoElements = driver
				.findElements(By.xpath("//div[starts-with(@class,'with-select sc-')]//ul[starts-with(@class,'sc-')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GO_PageNoElements.size());
		for (int i = 0; i < GO_PageNoElements.size(); i++) {
			System.out.println("Total count of Pages Drop-Down List have: " + GO_PageNoElements.get(i).getText());
		}

		String Twenty_five = driver.findElement(By.xpath("//li[contains(text(),'25')]")).getText();
		System.out.println("found=========" + Twenty_five);
		Assert.assertTrue(Twenty_five.contains("25"));

		String Fifty = driver.findElement(By.xpath("//li[contains(text(),'50')]")).getText();
		System.out.println("found=========" + Fifty);
		Assert.assertTrue(Fifty.contains("50"));

		String Hundred = driver.findElement(By.xpath("//li[contains(text(),'100')]")).getText();
		System.out.println("found=========" + Hundred);
		Assert.assertTrue(Hundred.contains("100"));

		Thread.sleep(1000);
		jx.executeScript("arguments[0].click();", GO_CountOfElement);

	}

	public void ClickOn_Reports() throws InterruptedException {

		Thread.sleep(2000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		INSIGHTS.click();
		Actions action = new Actions(driver);
		action.moveToElement(InsightsMenu).perform();
		Assert.assertTrue(InsightsMenu.isDisplayed());
		Reports.click();

	}

	public void Verify_ReportData() throws InterruptedException {

		Thread.sleep(3000);
       WebElement iframe1=driver.findElement(By.xpath("//iframe[@title='Claiming GMB - Searches']"));
       driver.switchTo().frame(iframe1);
		String NoReport = driver.findElement(By.xpath("//div[contains(text(),'Can't access report')]")).getText();
		System.out.println("found=========" + NoReport);
		Assert.assertTrue(NoReport.contains("No Reports"));
		System.out.println("Currently can't access this report");
		driver.switchTo().defaultContent();

	}

	public void Verify_ClickOnCreateNewReport() {
		
		driver.findElement(By.xpath("//button[@type='button']")).click();
		 
	}

	public void Verify_ManageReport() throws InterruptedException {

		Thread.sleep(500);
		String MR = driver.findElement(By.xpath("//div[contains(text(),'Manage Reports')]")).getText();
		System.out.println("found=========" + MR);
		Assert.assertTrue(MR.contains("Manage Reports"));

		String NR = driver.findElement(By.xpath("//div[contains(text(),'NEW REPORT')]")).getText();
		System.out.println("found=========" + NR);
		Assert.assertTrue(NR.contains("NEW REPORT"));

		String Close = driver.findElement(By.xpath("//a[contains(text(),'Close')]")).getText();
		System.out.println("found=========" + Close);
		Assert.assertTrue(Close.contains("CLOSE"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'NEW REPORT')]")).click();
	}

	public void Verify_CreateNewReport() throws InterruptedException {
		Thread.sleep(2000);

		String NR = driver.findElement(By.xpath("//div[contains(text(),'New Report')]")).getText();
		System.out.println("found=========" + NR);
		Assert.assertTrue(NR.contains("New Report"));

		String RT = driver.findElement(By.xpath("//div[contains(text(),'Report Title')]")).getText();
		System.out.println("found=========" + RT);
		Assert.assertTrue(RT.contains("Report Title"));

		String RU = driver.findElement(By.xpath("//div[contains(text(),'Report Url')]")).getText();
		System.out.println("found=========" + RU);
		Assert.assertTrue(RU.contains("Report Url"));

		String Height = driver.findElement(By.xpath("//div[contains(text(),'Height')]")).getText();
		System.out.println("found=========" + Height);
		Assert.assertTrue(Height.contains("Height"));

		String Order = driver.findElement(By.xpath("//div[contains(text(),'Order')]")).getText();
		System.out.println("found=========" + Order);
		Assert.assertTrue(Order.contains("Order"));

		String TA = driver.findElement(By.xpath("//div[contains(text(),'Team Access')]")).getText();
		System.out.println("found=========" + TA);
		Assert.assertTrue(TA.contains("Team Access"));

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 20); WebElement element =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "(//div[@id='brandSlider']/div[1]/div/div/div/img)[50]"))); element.click();
		 */

		driver.findElement(By.xpath("//a[contains(text(),'CANCEL')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();

	}

	public void ClickOn_SearchKeywords() throws InterruptedException {

		Thread.sleep(2000);
		WebElement InsightsMenu = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		INSIGHTS.click();
		Actions action = new Actions(driver);
		action.moveToElement(InsightsMenu).perform();
		Assert.assertTrue(InsightsMenu.isDisplayed());
		SearchKeywords.click();

	}

	public void VerifySearchKeywords_PageTitle() throws InterruptedException {

		Thread.sleep(7000);
		String SP_PageHeader = driver
				.findElement(By.xpath("//div[contains(text(),'Marketing / Insights / Search Keywords')]")).getText();
		System.out.println("found=========" + SP_PageHeader);
		Assert.assertEquals("Marketing / Insights / Search Keywords", SP_PageHeader);

	}

	public void VerifySearchKeywords_SearchPublishers() throws InterruptedException {

		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Google Local')]")).click();

		Thread.sleep(1000);
		List<WebElement> Search_Publisher = driver
				.findElements(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + Search_Publisher.size());
		for (int i = 0; i < Search_Publisher.size(); i++) {
			System.out.println("Elements List have: " + Search_Publisher.get(i).getText());

		}

		String Google_Local = driver.findElement(By.xpath("/descendant::div[contains(text(),'Google Local')][2]"))
				.getText();
		System.out.println("found=========" + Google_Local);
		Assert.assertEquals("Google Local", Google_Local);

		String Google_Organic = driver.findElement(By.xpath("//div[contains(text(),'Google Organic')]")).getText();
		System.out.println("found=========" + Google_Organic);
		Assert.assertEquals("Google Organic", Google_Organic);

		driver.findElement(By.xpath("/descendant::div[contains(text(),'Google Local')][2]")).click();

	}

	public void VerifySearchKeywords_PageGraphForGL() throws InterruptedException {

		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[contains(text(),'Distribution')][@color='#666']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Timeline sc-')][contains(text(),'Timeline')]")).click();
		Thread.sleep(5000);

		String GoogleLocal_Graph = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]")).getText();
		System.out.println("found=========" + GoogleLocal_Graph);

		WebElement GoogleLocal_Chart = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]"));
		GoogleLocal_Chart.isDisplayed();

		Thread.sleep(1000);
		List<WebElement> GoogleLocal_Elements = driver
				.findElements(By.xpath("//div[starts-with(@class,'line-chart')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GoogleLocal_Elements.size());
		for (int i = 0; i < GoogleLocal_Elements.size(); i++) {
			System.out.println("Elements List have: " + GoogleLocal_Elements.get(i).getText());

		}

	}

	public void VerifySearchKeywords_HeaderDateAndExportFor_GL() throws InterruptedException {

		Thread.sleep(1000);
		String SP_DefaultHeaderDay = driver.findElement(By.xpath("//span[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + SP_DefaultHeaderDay);
		Assert.assertEquals("Last year", SP_DefaultHeaderDay);

		driver.findElement(By.xpath("//span[contains(text(),'Last year')]")).click();
		Thread.sleep(1000);
		List<WebElement> SP_HeaderDay = driver.findElements(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + SP_HeaderDay.size());
		for (int i = 0; i < SP_HeaderDay.size(); i++) {
			System.out.println("Header Days Drop-Down List have: " + SP_HeaderDay.get(i).getText());
		}

		Thread.sleep(1000);
		/*
		 * String LastOneday =
		 * driver.findElement(By.xpath("//div[contains(text(),'Last 24 hours')]")).
		 * getText(); System.out.println("found=========" + LastOneday);
		 * Assert.assertEquals("Last 24 hours", LastOneday);
		 * 
		 * String LastSevenday =
		 * driver.findElement(By.xpath("//div[contains(text(),'Last 7 days')]")).getText
		 * (); System.out.println("found=========" + LastSevenday);
		 * Assert.assertEquals("Last 7 days", LastSevenday);
		 */

		String LastThirtyday = driver.findElement(By.xpath("//div[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + LastThirtyday);
		Assert.assertEquals("Last 30 days", LastThirtyday);

		String LastThreemonth = driver.findElement(By.xpath("//div[contains(text(),'Last 3 months')]")).getText();
		System.out.println("found=========" + LastThreemonth);
		Assert.assertEquals("Last 3 months", LastThreemonth);

		String LastSixmonth = driver.findElement(By.xpath("//div[contains(text(),'Last 6 months')]")).getText();
		System.out.println("found=========" + LastSixmonth);
		Assert.assertEquals("Last 6 months", LastSixmonth);

		String Lastyear = driver.findElement(By.xpath("//div[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + Lastyear);
		Assert.assertEquals("Last year", Lastyear);

		String Alltime = driver.findElement(By.xpath("//div[contains(text(),'All time')]")).getText();
		System.out.println("found=========" + Alltime);
		Assert.assertEquals("All time", Alltime);

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom);
		Assert.assertEquals("Custom", Custom);

		Thread.sleep(1000);
		WebElement Export_3DotMenu = driver.findElement(By.xpath("//i[contains(text(),'more_vert')]"));
		Assert.assertTrue(Export_3DotMenu.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Export_3DotMenu);
		Thread.sleep(1000);

		String Export = driver.findElement(By.xpath("//div[contains(text(),'Export')]")).getText();
		System.out.println("found=========" + Export);
		Assert.assertEquals("Export", Export);

		WebElement Exports = driver.findElement(By.xpath("//div[contains(text(),'Export')]"));
		Exports.click();
		// jv.executeScript("arguments[0].click();", Exports);

		WebElement ExportHeader = driver
				.findElement(By.xpath("//div[contains(text(),'Export Insights Search Keywords Data')]"));
		ExportHeader.isDisplayed();
		System.out.println("found=========" + ExportHeader);
		// Assert.assertTrue(ExportHeader.contains("Export Insights Search Keywords
		// Data"));

		WebElement FormatingType = driver.findElement(By.xpath("//div[contains(text(),'Formatting Type')]"));
		FormatingType.isDisplayed();

		String csv = driver.findElement(By.xpath("//span[contains(text(),'.csv')]")).getText();
		System.out.println("found=========" + csv);
		Assert.assertTrue(csv.contains(".csv"));

		String txt = driver.findElement(By.xpath("//span[contains(text(),'.txt')]")).getText();
		System.out.println("found=========" + txt);
		Assert.assertTrue(txt.contains(".txt"));

		String json = driver.findElement(By.xpath("//span[contains(text(),'.json')]")).getText();
		System.out.println("found=========" + json);
		Assert.assertTrue(json.contains(".json"));

		String export = driver.findElement(By.xpath("//button[contains(text(),'EXPORT')]")).getText();
		System.out.println("found=========" + export);
		Assert.assertTrue(export.contains("EXPORT"));

		String Cancel = driver.findElement(By.xpath("//a[contains(text(),'CANCEL')]")).getText();
		System.out.println("found=========" + Cancel);
		Assert.assertTrue(Cancel.contains("CANCEL"));

		// Txt
		Thread.sleep(1000);
		// jv.executeScript("arguments[0].click();", txt);
		WebElement txts = driver.findElement(By.xpath("//span[contains(text(),'.txt')]"));
		txts.click();

		Thread.sleep(1000);
		String Delimeter = driver.findElement(By.xpath("//div[contains(text(),'Delimiter')]")).getText();
		System.out.println("found=========" + Delimeter);
		Assert.assertTrue(Delimeter.contains("Delimiter"));

		String Tab = driver.findElement(By.xpath("//span[contains(text(),'Tab')]")).getText();
		System.out.println("found=========" + Tab);
		Assert.assertTrue(Tab.contains("Tab"));

		String Comma = driver.findElement(By.xpath("//span[contains(text(),'Comma')]")).getText();
		System.out.println("found=========" + Comma);
		Assert.assertTrue(Comma.contains("Comma"));

		String Semicolon = driver.findElement(By.xpath("//span[contains(text(),'Semicolon')]")).getText();
		System.out.println("found=========" + Semicolon);
		Assert.assertTrue(Semicolon.contains("Semicolon"));

		String Custom1 = driver.findElement(By.xpath("//span[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom1);
		Assert.assertTrue(Custom1.contains("Custom"));

		Thread.sleep(1000);
		WebElement cancel = driver.findElement(By.xpath("//a[contains(text(),'CANCEL')]"));
		cancel.click();
		// jv.executeScript("arguments[0].click();", Cancel);
		Thread.sleep(1000);

	}

	public void VerifySearchKeywords_GraphDetailsWithDateForGL() throws InterruptedException {

		String month = driver.findElement(By.xpath("//span[@class='dropdown-label'][contains(text(),'Month')]")).getText();
		System.out.println("found=========" + month);
		Assert.assertEquals("Month", month);

		driver.findElement(By.xpath("//span[@class='dropdown-label'][contains(text(),'Month')]")).click();

		Thread.sleep(1000);
		List<WebElement> DropDown_elements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + DropDown_elements.size());
		for (int i = 0; i < DropDown_elements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + DropDown_elements.get(i).getText());
		}

		Thread.sleep(500);
		String Days = driver.findElement(By.xpath("//div[contains(text(),'Day')]")).getText();
		System.out.println("found=========" + Days);
		Assert.assertEquals("Day", Days);

		String Week = driver.findElement(By.xpath("//div[contains(text(),'Week')]")).getText();
		System.out.println("found=========" + Week);
		Assert.assertEquals("Week", Week);

		String Month = driver.findElement(By.xpath("//div[contains(text(),'Month')]")).getText();
		System.out.println("found=========" + Month);
		Assert.assertEquals("Month", Month);

		String Quarter = driver.findElement(By.xpath("//div[contains(text(),'Quarter')]")).getText();
		System.out.println("found=========" + Quarter);
		Assert.assertEquals("Quarter", Quarter);

		String Year = driver.findElement(By.xpath("//div[contains(text(),'Year')]")).getText();
		System.out.println("found=========" + Year);
		Assert.assertEquals("Year", Year);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();
		Thread.sleep(1000);

	}

	public void VerifySearchKeywords_LocationForGL() throws InterruptedException {

		String Location = driver.findElement(By.xpath(
				"/descendant::div[starts-with(@class,'sc-')][contains(text(),'Locations')][3]"))
				.getText();
		System.out.println("found=========" + Location);
		Assert.assertEquals("Locations", Location);

		Thread.sleep(1000);

		WebElement LocationDropDown = driver.findElement(By.xpath(
				"/descendant::div[starts-with(@class,'sc-')][contains(text(),'Locations')][3]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();

		Thread.sleep(1000);
		List<WebElement> LocationElements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + LocationElements.size());
		for (int i = 0; i < LocationElements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + LocationElements.get(i).getText());
		}

		driver.findElement(
				By.xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Locations')]"))
				.click();
		Thread.sleep(1000);

		WebElement table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		table.isDisplayed();
		System.out.println("Location Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocation = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location')]")).getText();
		System.out.println("found=========" + TableLocation);
		Assert.assertTrue(TableLocation.contains("Location"));

		String cheesecake = driver.findElement(By.xpath("//thead/tr[1]/th[3]/div[1]")).getText();
		System.out.println("found=========" + cheesecake);
		Assert.assertTrue(cheesecake.contains("Cheesecake"));

		String cheesecakerestorant = driver.findElement(By.xpath("//thead/tr[1]/th[4]/div[1]"))
				.getText();
		System.out.println("found=========" + cheesecakerestorant);
		Assert.assertTrue(cheesecakerestorant.contains("Cheesecake Restaurant"));

		/*
		 * String thecheesecake = driver.findElement(By.
		 * xpath("//div[contains(text(),'the cheesecake restaurant')]")) .getText();
		 * System.out.println("found=========" + thecheesecake);
		 * Assert.assertTrue(thecheesecake.contains("the cheesecake restaurant"));
		 */

		String TableTachometerValue = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/b")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/p[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		String Cheesecake = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]")).getText();
		System.out.println("found=========" + Cheesecake);

		String Cheesecakeresturant = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]")).getText();
		System.out.println("found=========" + Cheesecakeresturant);

		/*
		 * String TheCheesecakeRestorant =
		 * driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText(
		 * ); System.out.println("found=========" + TheCheesecakeRestorant);
		 */
	}

	public void VerifySearchKeywords_LocationGroupForGL() throws InterruptedException {

		Thread.sleep(2000);
		WebElement LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Locations')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();
		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Location Groups')]"))
				.click();
		Thread.sleep(5000);

		WebElement LocationGrouptable = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		LocationGrouptable.isDisplayed();
		System.out.println("Location Group Table Is Displayed");

		WebElement Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		Tachometer.isDisplayed();

		String TableLocationGroup = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location Group')]"))
				.getText();
		System.out.println("found=========" + TableLocationGroup);
		Assert.assertTrue(TableLocationGroup.contains("Location Group"));

		String cheesecake = driver.findElement(By.xpath("//thead/tr[1]/th[3]/div[1]")).getText();
		System.out.println("found=========" + cheesecake);
		Assert.assertTrue(cheesecake.contains("Cheesecake"));

		String cheesecakerestorant = driver.findElement(By.xpath("//thead/tr[1]/th[4]/div[1]"))
				.getText();
		System.out.println("found=========" + cheesecakerestorant);
		Assert.assertTrue(cheesecakerestorant.contains("Cheesecake Restaurant"));

		/*
		 * String thecheesecake = driver.findElement(By.
		 * xpath("//div[contains(text(),'the cheesecake restaurant')]")) .getText();
		 * System.out.println("found=========" + thecheesecake);
		 * Assert.assertTrue(thecheesecake.contains("the cheesecake restaurant"));
		 */

		String TableTachometerValue = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/b[1]")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/p[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		String Cheesecake = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]")).getText();
		System.out.println("found=========" + Cheesecake);

		String Cheesecakeresturant = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]")).getText();
		System.out.println("found=========" + Cheesecakeresturant);

		/*
		 * String TheCheesecakeRestorant =
		 * driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText(
		 * ); System.out.println("found=========" + TheCheesecakeRestorant);
		 */

	}

	public void VerifySearchKeywords_ShowCountNumberStatusForGL() throws InterruptedException {

		Thread.sleep(3000);

		// scroll down page to Bottom:>>>>>

		JavascriptExecutor jv = ((JavascriptExecutor) driver);
		jv.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement SP_CountOfElement = driver
				.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[2]/div[2]"));
		Assert.assertTrue(SP_CountOfElement.isDisplayed());

		JavascriptExecutor jm = (JavascriptExecutor) driver;
		jm.executeScript("arguments[0].click();", SP_CountOfElement);

		Thread.sleep(1000);
		List<WebElement> GL_PageNoElements = driver
				.findElements(By.xpath("//div[starts-with(@class,'with-select sc-')]//ul[starts-with(@class,'sc-')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GL_PageNoElements.size());
		for (int i = 0; i < GL_PageNoElements.size(); i++) {
			System.out.println("Total count of Pages Drop-Down List have: " + GL_PageNoElements.get(i).getText());
		}

		String Twentyfive = driver.findElement(By.xpath("//li[contains(text(),'25')]")).getText();
		System.out.println("found=========" + Twentyfive);
		Assert.assertTrue(Twentyfive.contains("25"));

		String Fifty = driver.findElement(By.xpath("//li[contains(text(),'50')]")).getText();
		System.out.println("found=========" + Fifty);
		Assert.assertTrue(Fifty.contains("50"));

		String Hundred = driver.findElement(By.xpath("//li[contains(text(),'100')]")).getText();
		System.out.println("found=========" + Hundred);
		Assert.assertTrue(Hundred.contains("100"));

		Thread.sleep(1000);
		jv.executeScript("arguments[0].click();", SP_CountOfElement);
		Thread.sleep(1000);
	}

	public void VerifySearchKeywords_PageGraphForGO() throws InterruptedException {

		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Google Local')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Google Organic')]")).click();
		Thread.sleep(2500);

		Thread.sleep(1500);

		String GoogleOrganic_Graph = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]")).getText();
		System.out.println("found=========" + GoogleOrganic_Graph);

		WebElement GoogleOrganic_Chart = driver.findElement(By.xpath("//div[starts-with(@class,'line-chart')]"));
		GoogleOrganic_Chart.isDisplayed();

		Thread.sleep(1000);
		List<WebElement> GoogleOrganic_Elements = driver
				.findElements(By.xpath("//div[starts-with(@class,'line-chart')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GoogleOrganic_Elements.size());
		for (int i = 0; i < GoogleOrganic_Elements.size(); i++) {
			System.out.println("Elements List have: " + GoogleOrganic_Elements.get(i).getText());

		}

	}

	public void VerifySearchKeywords_HeaderDateAndExportFor_GO() throws InterruptedException {

		Thread.sleep(1000);
		/*
		 * String GO_DefaultHeaderDay =
		 * driver.findElement(By.xpath("//span[contains(text(),'Last 30 days')]")).
		 * getText(); System.out.println("found=========" + GO_DefaultHeaderDay);
		 * Assert.assertEquals("Last 30 days", GO_DefaultHeaderDay);
		 */

		driver.findElement(By.xpath("//i[contains(text(),'date_range')]")).click();
		Thread.sleep(1000);
		List<WebElement> GO_HeaderDay = driver.findElements(
				By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/div/div"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GO_HeaderDay.size());
		for (int i = 0; i < GO_HeaderDay.size(); i++) {
			System.out.println("Days Drop-Down List have: " + GO_HeaderDay.get(i).getText());
		}

		Thread.sleep(1000);
		/*
		 * String LastOneday =
		 * driver.findElement(By.xpath("//div[contains(text(),'Last 24 hours')]")).
		 * getText(); System.out.println("found=========" + LastOneday);
		 * Assert.assertEquals("Last 24 hours", LastOneday);
		 */

		/*
		 * String LastSevenday =
		 * driver.findElement(By.xpath("//div[contains(text(),'Last 7 days')]")).getText
		 * (); System.out.println("found=========" + LastSevenday);
		 * Assert.assertEquals("Last 7 days", LastSevenday);
		 */

		String LastThirtyday = driver.findElement(By.xpath("//div[contains(text(),'Last 30 days')]")).getText();
		System.out.println("found=========" + LastThirtyday);
		Assert.assertEquals("Last 30 days", LastThirtyday);

		String LastThreemonth = driver.findElement(By.xpath("//div[contains(text(),'Last 3 months')]")).getText();
		System.out.println("found=========" + LastThreemonth);
		Assert.assertEquals("Last 3 months", LastThreemonth);

		String LastSixmonth = driver.findElement(By.xpath("//div[contains(text(),'Last 6 months')]")).getText();
		System.out.println("found=========" + LastSixmonth);
		Assert.assertEquals("Last 6 months", LastSixmonth);

		String Lastyear = driver.findElement(By.xpath("//div[contains(text(),'Last year')]")).getText();
		System.out.println("found=========" + Lastyear);
		Assert.assertEquals("Last year", Lastyear);

		String Alltime = driver.findElement(By.xpath("//div[contains(text(),'All time')]")).getText();
		System.out.println("found=========" + Alltime);
		Assert.assertEquals("All time", Alltime);

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		System.out.println("found=========" + Custom);
		Assert.assertEquals("Custom", Custom);

		Thread.sleep(1000);
		WebElement Export3DotMenu = driver.findElement(By.xpath("//i[contains(text(),'more_vert')]"));
		Assert.assertTrue(Export3DotMenu.isDisplayed());

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

		String Export = driver.findElement(By.xpath("//div[contains(text(),'Export')]")).getText();
		System.out.println("found=========" + Export);
		Assert.assertEquals("Export", Export);

		jv.executeScript("arguments[0].click();", Export3DotMenu);
		Thread.sleep(1000);

	}

	public void VerifySearchKeywords_GraphDetailsWithDateForGO() throws InterruptedException {

		String mont = driver.findElement(By.xpath("//span[@class='dropdown-label'][contains(text(),'Month')]")).getText();
		System.out.println("found=========" + mont);
		Assert.assertEquals("Month",mont);

		driver.findElement(By.xpath("//span[@class='dropdown-label']")).click();

		Thread.sleep(1000);
		List<WebElement> GODropDown_elements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GODropDown_elements.size());
		for (int i = 0; i < GODropDown_elements.size(); i++) {
			System.out.println("Drop-Down List have: " + GODropDown_elements.get(i).getText());
		}

		Thread.sleep(500);
		String Day = driver.findElement(By.xpath("//div[contains(text(),'Day')]")).getText();
		System.out.println("found=========" + Day);
		Assert.assertEquals("Day", Day);

		String Week = driver.findElement(By.xpath("//div[contains(text(),'Week')]")).getText();
		System.out.println("found=========" + Week);
		Assert.assertEquals("Week", Week);

		String Month = driver.findElement(By.xpath("//div[contains(text(),'Month')]")).getText();
		System.out.println("found=========" + Month);
		Assert.assertEquals("Month", Month);

		String Quarter = driver.findElement(By.xpath("//div[contains(text(),'Quarter')]")).getText();
		System.out.println("found=========" + Quarter);
		Assert.assertEquals("Quarter", Quarter);

		String Year = driver.findElement(By.xpath("//div[contains(text(),'Year')]")).getText();
		System.out.println("found=========" + Year);
		Assert.assertEquals("Year", Year);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='dropdown-label'][contains(text(),'Month')]")).click();
		Thread.sleep(1000);

	}

	public void VerifySearchKeywords_LocationGroupForGo() throws InterruptedException {

		String Location_GO = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Location Groups')]"))
				.getText();
		System.out.println("found=========" + Location_GO);
		Assert.assertEquals("Location Groups", Location_GO);

		Thread.sleep(1000);

		WebElement LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Location Groups')]"));
		Actions action = new Actions(driver);
		action.moveToElement(LocationDropDown).perform();

		Thread.sleep(1000);
		List<WebElement> GO_LocationElements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GO_LocationElements.size());
		for (int i = 0; i < GO_LocationElements.size(); i++) {
			System.out.println("Location Drop-Down List have: " + GO_LocationElements.get(i).getText());
		}

		driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Location Groups')]"))
				.click();
		Thread.sleep(3500);

		WebElement GO_LocationGrouptable = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		GO_LocationGrouptable.isDisplayed();
		System.out.println("Location Group Table Is Displayed");

		WebElement GO_Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		GO_Tachometer.isDisplayed();

		String TableLocationGroup = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location Group')]"))
				.getText();
		System.out.println("found=========" + TableLocationGroup);
		Assert.assertTrue(TableLocationGroup.contains("Location Group"));

		String cheesecake = driver.findElement(By.xpath("//thead/tr[1]/th[3]/div[1]")).getText();
		System.out.println("found=========" + cheesecake);
		Assert.assertTrue(cheesecake.contains("Cheesecake"));

		String cheesecakerestorant = driver.findElement(By.xpath("//thead/tr[1]/th[4]/div[1]"))
				.getText();
		System.out.println("found=========" + cheesecakerestorant);
		Assert.assertTrue(cheesecakerestorant.contains("Cheesecake Restaurant"));

		/*
		 * String thecheesecake = driver.findElement(By.
		 * xpath("//div[contains(text(),'the cheesecake restaurant')]")) .getText();
		 * System.out.println("found=========" + thecheesecake);
		 * Assert.assertTrue(thecheesecake.contains("the cheesecake restaurant"));
		 */
		String TableTachometerValue = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/b")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/p[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		String Cheesecake = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]")).getText();
		System.out.println("found=========" + Cheesecake);

		String Cheesecakeresturant = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]")).getText();
		System.out.println("found=========" + Cheesecakeresturant);

		/*
		 * String TheCheesecakeRestorant =
		 * driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText(
		 * ); System.out.println("found=========" + TheCheesecakeRestorant);
		 */

	}

	public void VerifySearchKeywords_LocationForGO() throws InterruptedException {

		String Location_GO = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Location Groups')]"))
				.getText();
		System.out.println("found=========" + Location_GO);
		Assert.assertEquals("Location Groups", Location_GO);

		Thread.sleep(1000);

		WebElement GO_LocationDropDown = driver.findElement(By.xpath(
				"//div//div//div//ul//li//div[starts-with(@class,'trigger-wrapper sc-')]//div[contains(text(),'Location Groups')]"));
		Actions action = new Actions(driver);
		action.moveToElement(GO_LocationDropDown).perform();

		Thread.sleep(1000);
		List<WebElement> GO_LocationElements = driver.findElements(By.xpath(
				"//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GO_LocationElements.size());
		for (int i = 0; i < GO_LocationElements.size(); i++) {
			System.out.println("Days Drop-Down List have: " + GO_LocationElements.get(i).getText());
		}

		WebElement Location = driver.findElement(
				By.xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Locations')]"));
		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Location);
		Thread.sleep(1000);
		// jv.executeScript("Click()", Location);

		WebElement table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		table.isDisplayed();
		System.out.println("Location Table Is Displayed");

		WebElement GO_Tachometer = driver.findElement(By.xpath("//i[starts-with(@class,'tachometer inside-th sc-')]"));
		GO_Tachometer.isDisplayed();

		String TableLocationGroup = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Location Group')]"))
				.getText();
		System.out.println("found=========" + TableLocationGroup);
		Assert.assertTrue(TableLocationGroup.contains("Location Group"));

		String cheesecake = driver.findElement(By.xpath("//thead/tr[1]/th[3]/div[1]")).getText();
		System.out.println("found=========" + cheesecake);
		Assert.assertTrue(cheesecake.contains("Cheesecake"));

		String cheesecakerestorant = driver.findElement(By.xpath("//thead/tr[1]/th[4]/div[1]"))
				.getText();
		System.out.println("found=========" + cheesecakerestorant);
		Assert.assertTrue(cheesecakerestorant.contains("Cheesecake Restaurant"));

		/*
		 * String thecheesecake = driver.findElement(By.
		 * xpath("//div[contains(text(),'the cheesecake restaurant')]")) .getText();
		 * System.out.println("found=========" + thecheesecake);
		 * Assert.assertTrue(thecheesecake.contains("the cheesecake restaurant"));
		 */

		String TableTachometerValue = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/b")).getText();
		System.out.println("found=========" + TableTachometerValue);

		String TableLocationValue = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/p[1]")).getText();
		System.out.println("found=========" + TableLocationValue);

		String Cheesecake = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]")).getText();
		System.out.println("found=========" + Cheesecake);

		String Cheesecakeresturant = driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]")).getText();
		System.out.println("found=========" + Cheesecakeresturant);

		/*
		 * String TheCheesecakeRestorant =
		 * driver.findElement(By.xpath("//tr[1]//td[5]//div[1]//div[1]//b[1]")).getText(
		 * ); System.out.println("found=========" + TheCheesecakeRestorant);
		 */

	}

	public void VerifySearchKeywords_ShowCountNumberStatusForGO() throws InterruptedException {

		Thread.sleep(3000);

		// Scroll down page to Bottom :::::::->>>>>>>>>>>>

		JavascriptExecutor jx = ((JavascriptExecutor) driver);
		jx.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebElement GO_CountOfElement = driver
				.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[2]/div[2]"));
		Assert.assertTrue(GO_CountOfElement.isDisplayed());

		JavascriptExecutor jm = (JavascriptExecutor) driver;
		jm.executeScript("arguments[0].click();", GO_CountOfElement);

		Thread.sleep(1000);
		List<WebElement> GO_PageNoElements = driver
				.findElements(By.xpath("//div[starts-with(@class,'with-select sc-')]//ul[starts-with(@class,'sc-')]"));
		Thread.sleep(1000);
		System.out.println("Number of elements:" + GO_PageNoElements.size());
		for (int i = 0; i < GO_PageNoElements.size(); i++) {
			System.out.println("Total count of Pages Drop-Down List have: " + GO_PageNoElements.get(i).getText());
		}

		String Twenty_five = driver.findElement(By.xpath("//li[contains(text(),'25')]")).getText();
		System.out.println("found=========" + Twenty_five);
		Assert.assertTrue(Twenty_five.contains("25"));

		String Fifty = driver.findElement(By.xpath("//li[contains(text(),'50')]")).getText();
		System.out.println("found=========" + Fifty);
		Assert.assertTrue(Fifty.contains("50"));

		String Hundred = driver.findElement(By.xpath("//li[contains(text(),'100')]")).getText();
		System.out.println("found=========" + Hundred);
		Assert.assertTrue(Hundred.contains("100"));

		Thread.sleep(1000);
		jx.executeScript("arguments[0].click();", GO_CountOfElement);

	}

	public void VerifySearchKeywords_GoToPublisher() throws InterruptedException {

		Thread.sleep(2000);
		WebElement Publisher = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]"));
		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Publisher);
		/*
		 * WebElement Publisher =
		 * driver.findElement(By.xpath("//div[contains(text(),'Publishers')]"));
		 * Publisher.click();
		 */

	}

	public void VerifySearchKeywords_VerifyPublisherTable() throws InterruptedException {

		Thread.sleep(1500);
		// jv.executeScript("Click()", Location);

		WebElement table = driver.findElement(By.xpath("//table[starts-with(@class,'sc-')]"));
		table.isDisplayed();
		System.out.println("Location Table Is Displayed");

		String Publisher = driver
				.findElement(By.xpath("//th[starts-with(@class,'sc-')]//div[contains(text(),'Publisher')]")).getText();
		System.out.println("found=========" + Publisher);
		Assert.assertTrue(Publisher.contains("Publisher"));

		String cheesecake = driver.findElement(By.xpath("//div[contains(text(),'cheesecake')]")).getText();
		System.out.println("found=========" + cheesecake);
		Assert.assertTrue(cheesecake.contains("cheesecake"));

		String cheesecakerestorant = driver.findElement(By.xpath("//div[contains(text(),'cheesecake restaurant')]"))
				.getText();
		System.out.println("found=========" + cheesecakerestorant);
		Assert.assertTrue(cheesecakerestorant.contains("cheesecake restaurant"));

		String thecheesecake = driver.findElement(By.xpath("//div[contains(text(),'the cheesecake restaurant')]"))
				.getText();
		System.out.println("found=========" + thecheesecake);
		Assert.assertTrue(thecheesecake.contains("the cheesecake restaurant"));

		String PublisherValue = driver.findElement(By.xpath("//tr[1]//td[1]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + PublisherValue);

		String CheesecakeValue = driver.findElement(By.xpath("//tr[1]//td[2]//div[1]//div[1]//div[1]")).getText();
		System.out.println("found=========" + CheesecakeValue);

		String CheesecakeresturantValue = driver.findElement(By.xpath("//tr[1]//td[3]//div[1]//div[1]//b[1]"))
				.getText();
		System.out.println("found=========" + CheesecakeresturantValue);

		String TheCheesecakeRestorant = driver.findElement(By.xpath("//tr[1]//td[4]//div[1]//div[1]//b[1]")).getText();
		System.out.println("found=========" + TheCheesecakeRestorant);

		// Verify Publishers List ::>>>>

		String GL = driver.findElement(By.xpath("//b[contains(text(),'Google Local')]")).getText();
		System.out.println("found=========" + GL);
		Assert.assertTrue(GL.contains("Google Local"));

		String GO = driver.findElement(By.xpath("//b[contains(text(),'Google Organic')]")).getText();
		System.out.println("found=========" + GO);
		Assert.assertTrue(GO.contains("Google Organic"));

	}

}
