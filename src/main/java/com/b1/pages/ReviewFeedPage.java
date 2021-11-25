package com.b1.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;

 


public class ReviewFeedPage extends TestBase{
	
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
	
	@FindBy(xpath = "//div[@class='sc-cpmLhU cptrmy']")
	WebElement TotalCount;

	@FindBy(xpath = "//*[@id='fltrOptPosting Date']")
	WebElement PostingDate;

	@FindBy(id = "//a[contains(text(),'Custom')]")
	WebElement custom;

	@FindBy(id = "calendarfrom")
	WebElement fromDate;

	@FindBy(id = "calendarto")
	WebElement toDate;

	@FindBy(xpath = "//li[@class='calendaractionitem sc-efAmGo isBGLh']//a[contains(text(),'All Time')]")
	WebElement AllTimeFilter;

	@FindBy(xpath = "//div[@class='dropdownwrapperactions sc-bocRTG dkQTKu']//a[@class='dropdownapplyaction sc-bNpCPZ cpxkDZ'][contains(text(),'Apply')]")
	WebElement ApplyButton;

	@FindBy(xpath = "//div[contains(text(),'REVIEWS')]")
	WebElement Reviews;

	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile;

	@FindBy(xpath = "//div[contains(text(),'Accounts')]")
	WebElement Account;

	@FindBy(xpath = "//div[contains(text(),'Entitlements')]")
	WebElement Entitlements;

	@FindBy(css = "#moreFiltOpt")
	WebElement filterOptions;

	@FindBy(css = "#saveFiltOpt")
	WebElement saveAsNewFilter;

	@FindBy(xpath = "//input[@type='text' and @placeholder='Filter Name']")
	WebElement filterName;

	@FindBy(xpath = "//a[@class='export-filt-opt']")
	WebElement exportReviewData;

	@FindBy(xpath = "//span[contains(text(),'Export')]")
	WebElement exportBtn;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement submitBtn;

	@FindBy(xpath = "//a[@class='rst-filt-opt']")
	WebElement resetFtr;

	@FindBy(xpath = "//a[starts-with(@class,'filter-toggle sc-')]")
	WebElement filterIcon;

	@FindBy(xpath = "//article[1]//div[1]//div[1]//div[3]//div[1]//button[1]")
	WebElement RespondBTN;

	@FindBy(xpath = "//div[contains(text(),'Reviews Feed:')]")
	WebElement PrecanFilter;

	public ReviewFeedPage() throws IOException {
       super();
		PageFactory.initElements(driver, this);

	}
	public void VerifyOneStagingLogin(String un,String pa) throws InterruptedException {
		uname.clear();
		Thread.sleep(2000);
		uname.sendKeys(un);
		Thread.sleep(2000);
		pass.clear();
		pass.sendKeys(pa);
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
	}
	

	public void selectReviews() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement locator = driver.findElement(By.xpath("//div[contains(text(),'REVIEWS')]"));
		new WebDriverWait(driver, 60).ignoring(NoSuchSessionException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}


	public void ClickOnReviews() throws Exception {
		
		/*
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); WebElement
		 * locator = driver.findElement(By.xpath("//div[contains(text(),'REVIEWS')]"));
		 * new WebDriverWait(driver, 60).ignoring(NoSuchSessionException.class)
		 * .until(ExpectedConditions.elementToBeClickable(locator)); locator.click();
		 */
		
		Thread.sleep(5000);
		WebElement Reviews = driver.findElement(By.xpath("//div[contains(text(),'REVIEWS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(Reviews);
		actions.click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Reviews Feed')][1]")).click();
	}

	public void TotalCountOnDefault() throws Exception {
		 driver.navigate().refresh();
		Thread.sleep(10000);
		String totalCount = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",
				driver.findElement(By.xpath("//div[starts-with(@class,'totalcounttext sc-')]")));
		System.out.println("Total Count on Default : " + totalCount);
	}

	public void postingDate() throws Exception {

		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement PostingDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@id='fltrOptPosting Date']//span[contains(text(),'Posting Date')]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", PostingDate);

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		WebElement AllTimeFilter = wait1.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//li[starts-with(@class,'calendaractionitem sc-')]//a[contains(text(),'All Time')]")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", AllTimeFilter);

		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		WebElement ApplyButton = wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][1]")));
		JavascriptExecutor js2 = (JavascriptExecutor) driver; // div[starts-with(@class,'dropdownwrapperactions
																// sc-')]//a[starts-with(@class,'dropdownapplyaction
																// sc-') and contains(text(),'Apply')]
		js2.executeScript("arguments[0].click();", ApplyButton);
	}

	public void TotalCountOnALLTime() throws Exception {
		// driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		String totalCount = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",
				driver.findElement(By.xpath("//div[starts-with(@class,'totalcounttext sc-')]")));
		System.out.println("Total Count on Default : " + totalCount);
	}

	public void DefaultReviewText() throws Exception {
		String defReviewText = driver.findElement(By.xpath("//span[contains(text(),'Review Text')]")).getText();
		String defNotEmpty = driver.findElement(By.xpath("//span[contains(text(),'Not Empty')]")).getText();
		Assert.assertEquals(defReviewText, "Review Text:");
		Assert.assertEquals(defNotEmpty, "Not Empty");
		System.out.println("Default ReviewText is ==> " + defReviewText + defNotEmpty);
	}

	public void AllReview() throws Exception {
		Thread.sleep(2000);
		PrecanFilter.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'All Reviews')]")).click();
		String reviewStatus = driver.findElement(By.xpath("//span[contains(text(),'Review Status')]")).getText();
		Assert.assertEquals(reviewStatus, "Review Status:");
		System.out.println("It displays 'Review Status' filter on selecting 'All Review'");
		Thread.sleep(3000);
		String ReviewStatus = driver.findElement(By.xpath(
				"//a[@id='fltrOptReview Status']//span[contains(@class,'singleselection sc-')][contains(text(),'All')]"))
				.getText();
		Assert.assertEquals(ReviewStatus, "All");
		System.out.println("It displays 'Review Status' as ALL in filter on selecting 'All Review'");
	}

	public void RespondFeature() throws Exception {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(3000);
		PrecanFilter.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Response Required')][1]")).click();
		Thread.sleep(8000);
		postingDate();
		Thread.sleep(5000);
		WebElement RespondBtn = driver
				.findElement(By.xpath("/descendant::a[starts-with(@class,'reply reply-to-review-start sc-')][1]"));
		Assert.assertTrue(RespondBtn.isDisplayed());
		Assert.assertTrue(RespondBtn.isEnabled());
		Thread.sleep(2000);
		TestUtility.clickOn(driver, RespondBtn, 60);
		WebElement RespondArea = driver.findElement(By.xpath("//textarea[@placeholder='Enter your reply here...']"));
		Assert.assertTrue(RespondArea.isDisplayed());
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your reply here...']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your reply here...']")).sendKeys("Test Message");
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your reply here...']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your reply here...']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your reply here...']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your reply here...']")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your reply here...']")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//a[contains(@class,'cancel cancel-response
		// sc-')]")).click();
		driver.findElement(By.xpath("/descendant::i[contains(text(),'close')][3]")).click();
		Thread.sleep(3000);
	}

	public void PublisherFilterVerification() throws Exception {
		String defProvider = driver.findElement(By.xpath("//a[@id='fltrOptPublisher']//span[1]")).getText();
		Assert.assertEquals(defProvider, "Publisher:");
		System.out.println("The publisher filter text is  showing ==> " + defProvider);

		/*
		 * driver.findElement(By.xpath("//a[@id='filterAdd']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//option[contains(text(),'Publisher')]")).click(
		 * ); Thread.sleep(3000);
		 * driver.findElement(By.xpath("//label[contains(text(),'Google')]")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']")).click();
		 * Thread.sleep(2000); 
		 *  driver.navigate().refresh();
		 */
		

	}

	public void VerifyGoogleImage() throws Exception {
		/*
		 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		 * Thread.sleep(5000); WebElement ClearPublisher=
		 * driver.findElement(By.xpath("//a[contains(text(),'Clear All')]"));
		 * 
		 * WebElement SelectPublisher=
		 * driver.findElement(By.xpath("//a[contains(text(),'Select All')]"));
		 * 
		 * driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		 * Thread.sleep(2000);
		 * 
		 * if(SelectPublisher.isDisplayed()) { Thread.sleep(3000);
		 * SelectPublisher.click(); Thread.sleep(5000); ClearPublisher.click();
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]")).
		 * click(); } else {
		 * driver.findElement(By.xpath("/descendant::a[contains(text(),'Cancel')][5]")).
		 * click(); System.out.println("The Select all option is not available"); }
		 */
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownlink sc-')][contains(text(),'Select All')][1]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownlink sc-')][contains(text(),'Clear All')][2]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='Google']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]")).click();
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement GoogleImage = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/descendant::div[starts-with(@class,'provider-logo-wrapper sc-')][1]")));
		Assert.assertTrue(GoogleImage.isDisplayed());

		if (!GoogleImage.isDisplayed()) 
		{
			System.out.println("Google not displayed.");
		} 
		else 
		{
			System.out.println("Google displayed.");
		}

	}

	public void VerifyFacebookImage() throws Exception {
		Thread.sleep(3000);
		WebElement sourceProvider = driver
				.findElement(By.xpath("//a[starts-with(@class,'bqltoggle fltr-opt-publisher sc-')]"));

		TestUtility.clickOn(driver, sourceProvider, 30);
		Thread.sleep(4000);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownlink sc-')][contains(text(),'Select All')][1]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownlink sc-')][contains(text(),'Clear All')][2]")).click();
		Thread.sleep(1500);
		//driver.findElement(By.xpath("//input[@id='Google']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Facebook']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]")).click();
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement FacebookImage = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/descendant::i[starts-with(@class,'provider-3  sc-')][1]")));

		Assert.assertTrue(FacebookImage.isDisplayed());

		if (!FacebookImage.isDisplayed()) {
			System.out.println("Facebook image not displayed.");
		} else {
			System.out.println("Facebook image displayed.");
		}

	}

	public void VerifyYelpImage() throws Exception {
		Thread.sleep(3000);
		WebElement sourceProvider = driver
				.findElement(By.xpath("//a[starts-with(@class,'bqltoggle fltr-opt-publisher sc-')]"));

		TestUtility.clickOn(driver, sourceProvider, 30);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownlink sc-')][contains(text(),'Select All')][1]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownlink sc-')][contains(text(),'Clear All')][2]")).click();
		Thread.sleep(1500);
		//driver.findElement(By.xpath("//input[@id='Facebook']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Yelp']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]")).click();
		Thread.sleep(7000);
		WebElement YelpImage = driver.findElement(
				By.xpath("/descendant::i[starts-with(@class,'provider-6  sc-')][1]"));

		/*
		 * Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
		 * "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0"
		 * , ImageFile);
		 */

		Assert.assertTrue(YelpImage.isDisplayed());

		if (!YelpImage.isDisplayed()) {
			System.out.println("Yelp image not displayed.");
		} else {
			System.out.println("Yelp image displayed.");
		}

	}

	public void VerifyTripAdvisorImage() throws Exception {
		Thread.sleep(3000);
		WebElement sourceProvider = driver
				.findElement(By.xpath("//a[starts-with(@class,'bqltoggle fltr-opt-publisher sc-')]"));
		TestUtility.clickOn(driver, sourceProvider, 30);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownlink sc-')][contains(text(),'Select All')][1]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownlink sc-')][contains(text(),'Clear All')][2]")).click();
		//Thread.sleep(1500);
		//driver.findElement(By.xpath("//input[@id='Yelp']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='TripAdvisor']")).click();
		Thread.sleep(2000);
		WebElement applyBtn = driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]"));
		TestUtility.clickOn(driver, applyBtn, 30);
		
		Thread.sleep(7000);
		WebElement TripAdvisorImage = driver.findElement(
				By.xpath("/descendant::i[starts-with(@class,'provider-11  sc-')][1]"));

		Assert.assertTrue(TripAdvisorImage.isDisplayed());

		if (!TripAdvisorImage.isDisplayed()) 
		{
			System.out.println("TripAdvisor image not displayed.");
		} 
		else 
		{
			System.out.println("TripAdvisor image displayed.");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void VerifygooglePublisher() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='TripAdvisor']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Google']")).click();
		Thread.sleep(7000);
		WebElement applyBtn = driver
				.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]"));

		TestUtility.clickOn(driver, applyBtn, 30);

		WebElement GooglePublisher = driver.findElement(By.xpath("//a[@id='fltrOptPublisher']//span[2]"));
		String GooglePub = driver.findElement(By.xpath("//a[@id='fltrOptPublisher']//span[2]")).getText();
		System.out.println("The Publiser name is" + GooglePub);

		Assert.assertEquals(GooglePub, "Google");

		if (!GooglePublisher.isDisplayed()) {
			System.out.println("Google Publisher displayed.");
		} 
		else 
		{
			System.out.println("Google Publisher is not displayed.");
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void VerifyTotalReviewOnPageFor10() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'actionsright sc-')]/div[2]/div[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[contains(@class,'sc-')]//div[contains(@class,'dropdown-content sc-')]//div[contains(text(),'10')]"))
				.click();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath(
				"//div[starts-with(@class,'tile-container')]//div[starts-with(@class,'tile-body sc-')]//div[starts-with(@class,'header-container sc-')]//div[1]//a[1]"));
		System.out.println("Number of Tile:" + elements.size());

		// div[starts-with(@class,'tile-container')]

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Review Records List : " + elements.get(i).getText());

			Thread.sleep(3000);
		}

	}

	public void VerifyTotalReviewOnPageFor25() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'actionsright sc-')]/div[2]/div[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[contains(@class,'sc-')]//div[contains(@class,'dropdown-content sc-')]//div[contains(text(),'25')]"))
				.click();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath(
				"//div[starts-with(@class,'tile-container')]//div[starts-with(@class,'tile-body sc-')]//div[starts-with(@class,'header-container sc-')]//div[1]//a[1]"));
		System.out.println("Number of Tile:" + elements.size());

		// div[starts-with(@class,'tile-container')]

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Review Records List : " + elements.get(i).getText());
		}

	}

	public void VerifyTotalReviewOnPageFor50() throws Exception {

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'actionsright sc-')]/div[2]/div[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[contains(@class,'sc-')]//div[contains(@class,'dropdown-content sc-')]//div[contains(text(),'50')]"))
				.click();
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath(
				"//div[starts-with(@class,'tile-container')]//div[starts-with(@class,'tile-body sc-')]//div[starts-with(@class,'header-container sc-')]//div[1]//a[1]"));
		System.out.println("Number of Tile:" + elements.size());

		// div[starts-with(@class,'tile-container')]

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Review Records List : " + elements.get(i).getText());
		}

	}

	public void VerifyTotalReviewOnPageFor100() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'actionsright sc-')]/div[2]/div[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[contains(@class,'sc-')]//div[contains(@class,'dropdown-content sc-')]//div[contains(text(),'100')]"))
				.click();
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath(
				"//div[starts-with(@class,'tile-container')]//div[starts-with(@class,'tile-body sc-')]//div[starts-with(@class,'header-container sc-')]//div[1]//a[1]"));
		System.out.println("Number of Tile:" + elements.size());
		// div[starts-with(@class,'tile-container')]
		/*
		 * for (int i = 0; i < elements.size(); i++) {
		 * System.out.println("Review Records List : " + elements.get(i).getText()); }
		 */
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'actionsright sc-')]/div[2]/div[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[contains(@class,'sc-')]//div[contains(@class,'dropdown-content sc-')]//div[contains(text(),'10')]"))
				.click();
		Thread.sleep(2000);
	}

	public void VerifyAddDeleteTag() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String placeHolderValue = driver
				.findElement(By.xpath("//input[contains(@class,'undefined-input sc-') and @placeholder='Add Tag']"))
				.getAttribute("placeholder");
		System.out.println("place Holder name is : " + placeHolderValue);

		driver.findElement(By.xpath("//input[contains(@class,'undefined-input sc-') and @placeholder='Add Tag']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Birthday')]")).click();

		String tagName = driver.findElement(By.xpath("//span[@class='tag-item-tagname']")).getText();
		System.out.println("Added Tag name is ==> " + tagName);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement xClick = driver.findElement(By.xpath(
				"//div[contains(@class,'tag-list-item sc-')]//span[contains(text(),'Birthday')]//following::i[1]"));
		js.executeScript("arguments[0].click();", xClick);
	}

	public void saveFilter() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", filterOptions);
		// filterOptions.click();
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click();", saveAsNewFilter);
		// TestUtility.clickOn(driver, saveAsNewFilter, 30);
		filterName.sendKeys("Test123");
		TestUtility.clickOn(driver, submitBtn, 30);
	}

	public void verifyFilter() throws InterruptedException {
		TestUtility.clickOn(driver, filterIcon, 30);
		Thread.sleep(2000);
		String filterRecordPresent = driver
				.findElement(By.xpath("//h5[starts-with(@class,'savedfiltertitle sc-')][contains(text(),'Test123')]"))
				.getText();
		Assert.assertTrue(filterRecordPresent.contains("Test123"));
		System.out.println("Filter name which is saved ==> " + filterRecordPresent);

	}

	public void DeleteSavedFilter() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='material-icons'][contains(text(),'close')]")).click();

	}

	public void preCannedFilterSelect() throws Exception {

		//driver.navigate().refresh();
		Thread.sleep(5000);
		PrecanFilter.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'All Reviews')][1]")).click();
		Thread.sleep(5000);

	}

	public void VerifyFlaggedReviews() throws Exception {
		Thread.sleep(1000);
		PrecanFilter.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Flagged Reviews')]")).click();

		String reviewStatus = driver.findElement(By.xpath("//span[contains(text(),'Review Status')]")).getText();
		Assert.assertEquals(reviewStatus, "Review Status:");

		String FlaggedReviewFilter = driver.findElement(By.xpath("//a[@id='fltrOptFlagged Review']//span")).getText();
		Assert.assertEquals(FlaggedReviewFilter, "Flagged Review:");

		String ReviewsFilterOption = driver.findElement(By.xpath("//a[@id='fltrOptFlagged Review']//span[2]"))
				.getText();
		Assert.assertEquals(ReviewsFilterOption, "Flagged");
		Thread.sleep(3000);
	}

	public void VerifyResponseRequired() throws Exception {
		driver.navigate().refresh();
		Thread.sleep(5000);
		PrecanFilter.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Response Required')][1]")).click();
		Thread.sleep(5000);
		String PostingDate = driver.findElement(By.xpath("//span[contains(text(),'7 days')]")).getText();
		Assert.assertEquals(PostingDate, "7 days");
		Thread.sleep(1000);
		String ReviewStatus = driver.findElement(By.xpath("//a[@id='fltrOptReview Status']//span[2]")).getText();
		Assert.assertEquals(ReviewStatus, "New");
		Thread.sleep(1000);
		String ReviewText = driver.findElement(By.xpath("//span[contains(text(),'Not Empty')]")).getText();
		Assert.assertEquals(ReviewText, "Not Empty");
		Thread.sleep(1000);
		String Publisher = driver.findElement(By.xpath("//span[contains(@class,'multipleselections sc-')]")).getText();
		Assert.assertEquals(Publisher, "4");
		Thread.sleep(1000);
		String Ratings = driver.findElement(By.xpath("//span[contains(text(),'Ratings')]")).getText();
		Assert.assertEquals(Ratings, "Ratings:");
		Thread.sleep(1000);
		String AddFilter = driver.findElement(By.xpath("//a[@id='filterAdd']")).getText();
		Assert.assertEquals(AddFilter, "+ Add Filter");
	}

	public void VerifyRespondedReviews() throws Exception {
		//driver.navigate().refresh();
		Thread.sleep(5000);
		PrecanFilter.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded Reviews')][1]")).click();
		Thread.sleep(5000);
		String PostingDate = driver.findElement(By.xpath("//span[contains(text(),'7 days')]")).getText();
		Assert.assertEquals(PostingDate, "7 days");
		Thread.sleep(1000);

		String RespondedDate = driver.findElement(By.xpath("//span[contains(text(),'All Time')]")).getText();
		Assert.assertEquals(RespondedDate, "All Time");
		Thread.sleep(1000);

		String ReviewStatus = driver.findElement(By.xpath("//span[contains(text(),'Review Status')]")).getText();
		Assert.assertEquals(ReviewStatus, "Review Status:");
		Thread.sleep(1000);

		String ReviewText = driver.findElement(By.xpath("//span[contains(text(),'Not Empty')]")).getText();
		Assert.assertEquals(ReviewText, "Not Empty");
		Thread.sleep(1000);
		String Publisher = driver.findElement(By.xpath("//span[contains(@class,'multipleselections sc-')]")).getText();
		Assert.assertEquals(Publisher, "4");
		Thread.sleep(1000);
		String Ratings = driver.findElement(By.xpath("//span[contains(text(),'Ratings')]")).getText();
		Assert.assertEquals(Ratings, "Ratings:");
		Thread.sleep(1000);
		String AddFilter = driver.findElement(By.xpath("//a[@id='filterAdd']")).getText();
		Assert.assertEquals(AddFilter, "+ Add Filter");
	}

	public void VerifyAllReviews() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Reviews Feed')][2]")).click();
		Thread.sleep(2000);
		WebElement AllReviews = driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel All Reviews sc-')][contains(text(),'All Reviews')]"));
		AllReviews.click();
		Thread.sleep(8000);
		String PostingDate = driver.findElement(By.xpath("//span[contains(text(),'All Time')]")).getText();
		Assert.assertEquals(PostingDate, "All Time");
		Thread.sleep(1000);
		String ReviewStatus = driver
				.findElement(By.xpath("//a[@id='fltrOptReview Status']//span[contains(text(),'All')]")).getText();
		Assert.assertEquals(ReviewStatus, "All");
		Thread.sleep(1000);
		String ReviewText = driver.findElement(By.xpath("//span[contains(text(),'Not Empty')]")).getText();
		Assert.assertEquals(ReviewText, "Not Empty");
		Thread.sleep(1000);
		String Publisher = driver.findElement(By.xpath("//span[contains(text(),'Publisher')]")).getText();
		Assert.assertEquals(Publisher, "Publisher:");
		Thread.sleep(1000);
		String Ratings = driver.findElement(By.xpath("//span[contains(text(),'Ratings')]")).getText();
		Assert.assertEquals(Ratings, "Ratings:");
		Thread.sleep(1000);
		String AddFilter = driver.findElement(By.xpath("//a[@id='filterAdd']")).getText();
		Assert.assertEquals(AddFilter, "+ Add Filter");
	}

	public void Select3DotReviewTile() throws InterruptedException {

		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'show-more-options sc-')][1]")).click();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath(
				"//div[@class='popover-content sc-kEYyzF cnjdtE']//div[@class='dropdown-styled sc-bnXvFD eTeAjN']"));
		System.out.println("\nNumber of elements:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Review preCannedFilter List :\n" + elements.get(i).getText() + "\n\n");
		}
	}
	public void SelectGotoSite() throws InterruptedException {

		// driver.findElement(By.xpath("//i[starts-with(@class,'material-icons
		// sc-')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Go to Review Site')][1]")).click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs2.get(0));

	}

	public void SelectReviewHistory() throws InterruptedException {

		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'show-more-options sc-')][1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/descendant::div[contains(text(),'Review History')][1]")).click();
		String History = driver.findElement(By.xpath("/descendant::div[contains(text(),'Review History')][2]"))
				.getText();
		Assert.assertTrue(History.contains("Review History"));

		String response = driver.findElement(By.xpath("//p[contains(text(),'History')]")).getText();
		Assert.assertEquals(response, "History");
		driver.findElement(By.xpath("//a[contains(text(),'CLOSE')]")).click();

	}

	public void SelectShareReview() throws InterruptedException {

		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'show-more-options sc-')][1]")).click();
		Thread.sleep(3500);

		driver.findElement(By.xpath("/descendant::div[contains(text(),'Share Review')][1]")).click();

		String Share = driver.findElement(By.xpath("/descendant::div[contains(text(),'Share Review')][2]")).getText();
		System.out.println(Share);
		// Assert.assertTrue(Share.contains("Share Review"));

		driver.findElement(By.xpath("//input[@placeholder='Enter an email address']")).sendKeys("sachin@testriq.com");
		driver.findElement(By.xpath("//i[@id='submitbutton']")).click();

		driver.findElement(By.xpath("//textarea[@placeholder='Enter your message...']"))
				.sendKeys("Review Test Option Check");

		String Cancel1 = driver.findElement(By.xpath("//a[contains(text(),'CANCEL')]")).getText();
		Assert.assertEquals(Cancel1, "CANCEL");

		String Share1 = driver.findElement(By.xpath("//a[contains(text(),'SEND')]")).getText();
		Assert.assertEquals(Share1, "SEND");

		driver.findElement(By.xpath("//a[contains(text(),'SEND')]")).click();

	}

	public void SortOldestFilter() throws InterruptedException {

		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[contains(text(),'Newest')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Oldest')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(10000);

		String Date = driver.findElement(By.xpath("/descendant::span[contains(text(),'05/15/2002')][1]"))
				.getText();
		Assert.assertEquals(Date, "05/15/2002");
		System.out.println("Oldest Review date is present");

	}

	public void HighestRatedFilter() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Oldest')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Highest Rated')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(7000);

		Boolean Recommended = driver.findElement(By.xpath("/descendant::i[starts-with(@class,'fb-recommend  sc-')][1]"))
				.isDisplayed();
		Assert.assertTrue(Recommended);
		System.out.println("Highest Rated Review date is present");

	}

	public void preCannedFilter() throws Exception {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]")).click();
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[starts-with(@class,'filterlist sc-')]"));
		System.out.println("\nNumber of elements:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Review preCannedFilter List :\n" + elements.get(i).getText() + "\n\n");
		}
		driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]")).click();
	}

	public void ReviewStatusNew() throws Exception {
		Thread.sleep(3000);
		PrecanFilter.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'All Reviews')]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(5000);
		WebElement ClearFilter = driver.findElement(By.xpath(
				"//div[contains(@class,'fixed-max sc-')]//ul[contains(@class,'fixed-height sc-')]//li[1]//a[contains(text(),'Clear All')]"));
		//ClearFilter.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", ClearFilter);
		Thread.sleep(2000);
		WebElement New = driver.findElement(By.xpath(
				"//li//input[@id='New']"));
		New.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();
		Thread.sleep(5000);

		String TileReviewStatus = driver
				.findElement(By.xpath("//div[contains(@class,'tile-body sc-')]//div//a[contains(@class,'status-button sc-')]//span")).getText();
		Assert.assertEquals(TileReviewStatus, "New");

		List<WebElement> elements = driver.findElements(By.xpath(
				"//div[starts-with(@class,'tile-container')]//div[starts-with(@class,'tile-body sc-')]//div[contains(@class,'status-container sc-')]//a//div//span[contains(text(),'New')]"));
		System.out.println("Number of Tile:" + elements.size());

		for (int i = 0; i < elements.size(); i++) {

			System.out.println("Review Status List : " + elements.get(i).getText());
			Assert.assertEquals(elements.get(i).getText(), "New");
			Thread.sleep(3000);
		}

	}

	public void ReviewStatusQueued() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(5000);
		WebElement SelectAll = driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]"));
		SelectAll.click();
		
		Thread.sleep(2000);
		WebElement ClearFilter = driver.findElement(By.xpath(
				"//div[contains(@class,'fixed-max sc-')]//ul[contains(@class,'fixed-height sc-')]//li[1]//a[contains(text(),'Clear All')]"));
		//ClearFilter.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", ClearFilter);
		Thread.sleep(2000);
		WebElement Queued = driver.findElement(By.xpath(
				"//div[contains(@class,'fixed-max sc-')]//ul[contains(@class,'fixed-height sc-')]//li[3]//input[@id='Queued']"));
		Queued.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();
		Thread.sleep(5000);
		String TileReviewStatus = driver
				.findElement(By.xpath("//div[contains(@class,'tile-body sc-')]//div//a[contains(@class,'status-button sc-')]//span")).getText();
		Assert.assertEquals(TileReviewStatus, "Queued");
		Thread.sleep(3000);

	}

	public void ReviewStatusFailed() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(5000);
		WebElement SelectAll = driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]"));
		SelectAll.click();
		
		Thread.sleep(2000);
		WebElement ClearFilter = driver.findElement(By.xpath(
				"//div[contains(@class,'fixed-max sc-')]//ul[contains(@class,'fixed-height sc-')]//li[1]//a[contains(text(),'Clear All')]"));
		//ClearFilter.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", ClearFilter);
		Thread.sleep(2000);
		WebElement Failed = driver.findElement(By.xpath(
				"//div[contains(@class,'fixed-max sc-')]//ul[contains(@class,'fixed-height sc-')]//li[4]//input[@id='Failed']"));
		Failed.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();
		Thread.sleep(5000);
		String TileReviewStatus = driver
				.findElement(By.xpath("//div[contains(@class,'tile-body sc-')]//div//a[contains(@class,'status-button sc-')]//span")).getText();
		Assert.assertEquals(TileReviewStatus, "Failed");
		Thread.sleep(3000);
	}

	public void ReviewStatusDone() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(5000);
	
		WebElement SelectAll = driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]"));
		SelectAll.click();
		
		Thread.sleep(2000);
		WebElement ClearFilter = driver.findElement(By.xpath(
				"//div[contains(@class,'fixed-max sc-')]//ul[contains(@class,'fixed-height sc-')]//li[1]//a[contains(text(),'Clear All')]"));
		//ClearFilter.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", ClearFilter);
		Thread.sleep(2000);
		WebElement Done = driver.findElement(By.xpath(
				"//div[contains(@class,'fixed-max sc-')]//ul[contains(@class,'fixed-height sc-')]//li[5]//input[@id='Done']"));
		Done.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();
		Thread.sleep(5000);
		String TileReviewStatus = driver
				.findElement(By.xpath("//div[contains(@class,'tile-body sc-')]//div//a[contains(@class,'status-button sc-')]//span")).getText();
		Assert.assertEquals(TileReviewStatus, "Done");
		Thread.sleep(3000);
	}

	public void PublicResponse() throws Exception {
		PrecanFilter.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'All Reviews')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();
		Thread.sleep(2000);
		
		WebElement SelectFilter=driver.findElement(By.id("adtlFiltOpts"));
		 
		Select adtlFiltOpts=new Select(SelectFilter);
		 
		List<WebElement> dropdown=adtlFiltOpts.getOptions();
		 
		 for(int i=0;i<dropdown.size();i++){
		 
		 String drop_down_values=dropdown.get(i).getText();
		 
		 System.out.println("dropdown values are : "+drop_down_values);
		 
		 }
		 adtlFiltOpts.selectByVisibleText("Public Response");
		 
		 driver.findElement(By.xpath("//input[@id='adtlOptTxt']")).sendKeys("Test");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//i[@class='material-icons'][contains(text(),'add')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn'][contains(text(),'Apply')]")).click();
		 Thread.sleep(2000);
	}
	
	public void PrivateResponse() throws Exception {
		Thread.sleep(3000);
		PrecanFilter.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'All Reviews')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();
		Thread.sleep(2000);
		
		WebElement SelectFilter=driver.findElement(By.id("adtlFiltOpts"));
		 
		Select adtlFiltOpts=new Select(SelectFilter);
		 
		List<WebElement> dropdown=adtlFiltOpts.getOptions();
		 
		 for(int i=0;i<dropdown.size();i++){
		 
		 String drop_down_values=dropdown.get(i).getText();
		 
		 System.out.println("dropdown values are : "+drop_down_values);
		 
		 }
		 adtlFiltOpts.selectByVisibleText("Private Response");
		 
		 driver.findElement(By.xpath("//input[@id='adtlOptTxt']")).sendKeys("Test");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[@id='adtlOptAddBtn']//i[@class='material-icons'][contains(text(),'add')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn'][contains(text(),'Apply')]")).click();
		 Thread.sleep(2000);
	}
	
	public void RatingFilter() throws Exception {
		Thread.sleep(3000);
		PrecanFilter.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(" /descendant::div[contains(text(),'All Reviews')][1]")).click();
		Thread.sleep(10000);
		
		String Ratings = driver.findElement(By.xpath("//div//li//a//span[contains(text(),'Ratings')]")).getText();
		Assert.assertEquals(Ratings, "Ratings:");
		
		WebElement Rating= driver.findElement(By.xpath("//div//li//a[contains(@class,'bqltoggle sc-')][span[contains(text(),'Ratings')]]"));
		Rating.click();
		Thread.sleep(5000);
		List<WebElement> dropdown= driver.findElements(By.xpath("//div[contains(@class,'ratings sc-')]//ul//li//input"));
		
		 for(int i=0;i<dropdown.size();i++)
		 {
			 if(dropdown.get(i).isSelected())
			 {
				 System.out.println(" The Options checkbox selected");
			 }
		 }
		 
	}
	
	public void Verify_City_Filter() throws InterruptedException {
		Thread.sleep(3000);
		PrecanFilter.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'All Reviews')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();
		Thread.sleep(2000);
		WebElement SelectFilter=driver.findElement(By.id("adtlFiltOpts"));
		 
		Select adtlFiltOpts=new Select(SelectFilter);
		 
		List<WebElement> dropdown=adtlFiltOpts.getOptions();
		 
		 for(int i=0;i<dropdown.size();i++){
		 
		 String drop_down_values=dropdown.get(i).getText();
		 
		 System.out.println("dropdown values are : "+drop_down_values);
		 
		 }
		 adtlFiltOpts.selectByVisibleText("City");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/descendant::a[starts-with(@class,'textoptiontoggle sc-')][2]")).click();
		 Thread.sleep(1500);
		 String CityText=driver.findElement(By.xpath("/descendant::label[contains(text(),' Contains')][2]")).getText();
		 Assert.assertTrue(CityText.contains("Contains"));
		 Thread.sleep(1500);
		 driver.findElement(By.xpath("//input[@id='adtlOptTxt']")).sendKeys("Bran");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//i[@class='material-icons'][contains(text(),'add')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn'][contains(text(),'Apply')]")).click();
		 Thread.sleep(5000);
		 WebElement CityAdd=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]"));
		CityAdd.getText();
		Assert.assertTrue(CityAdd.isDisplayed());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptCity']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][6]")).click();
	}
	
	public void Verify_State_Filter() throws InterruptedException {
		//Thread.sleep(5000);
		//PrecanFilter.click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[contains(text(),'All Reviews')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();
		Thread.sleep(2000);
		WebElement SelectFilter=driver.findElement(By.id("adtlFiltOpts"));
		Select adtlFiltOpts=new Select(SelectFilter);
		 
		List<WebElement> dropdown=adtlFiltOpts.getOptions();
		 
		 for(int i=0;i<dropdown.size();i++){
		 
		 String drop_down_values=dropdown.get(i).getText();
		 
		 System.out.println("dropdown values are : "+drop_down_values);
		 
		 }
		 adtlFiltOpts.selectByVisibleText("State");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/descendant::a[starts-with(@class,'textoptiontoggle sc-')][2]")).click();
		 Thread.sleep(1500);
		 String CityText=driver.findElement(By.xpath("/descendant::label[contains(text(),' Contains')][2]")).getText();
		 Assert.assertTrue(CityText.contains("Contains"));
		 Thread.sleep(1500);
		 driver.findElement(By.xpath("//input[@id='adtlOptTxt']")).sendKeys("NY");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//i[@class='material-icons'][contains(text(),'add')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn'][contains(text(),'Apply')]")).click();
		 Thread.sleep(5000);
		 WebElement StateAdd=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]"));
		 StateAdd.getText();
		Assert.assertTrue(StateAdd.isDisplayed());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptState']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][6]")).click();
	}
	
}
