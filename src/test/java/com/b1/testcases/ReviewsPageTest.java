package com.b1.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;
 

@Listeners(TestListener.class)
public class ReviewsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ReviewsPage reviewsPage;
	TestUtility testUtil;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public ReviewsPageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {

		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reviewsPage = new ReviewsPage();
	}

	@Test(groups = { "sanity", "regression" }, priority = 1)
	public void clickOnContextAndSelectCheesecake() throws Exception {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();
		//String LocationName = driver.findElement(By.xpath("//div[contains(text(),'cheesecake')]")).getText();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'Cheesecake Factory')]")).getText();
		System.out.println("Location Name : " + LocationName);

	}

	@Test(groups = { "sanity", "regression" }, priority = 2)
	public void checkReviewEnable() throws IOException {
		driver.navigate().refresh();
		reviewsPage.selectReviewOnEntitlements();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean checkbox = driver.findElement(By.xpath("//input[@id='entitlements-Review']")).isSelected();

		System.out.println("Check checkbox value is : " + checkbox);
		if (checkbox == true) {

			System.out.println("Checkbox is already checked  ");

		} else {

			WebElement ReviewChecked = driver.findElement(By.xpath("//input[@id='entitlements-Review']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ReviewChecked);

			System.out.println("Checkbox is checked");

			driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();
		}
	
		    Runtime.getRuntime().exec("E:\\workspace\\PortableGit\\git-bash.exe");
		    
		    Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});


		}

	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void clickOnReviews() throws InterruptedException {
		driver.navigate().refresh();

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

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void totalCountOnDefault() throws Exception {
		driver.navigate().refresh();
		// String totalCount =
		// driver.findElement(By.cssSelector("div.totalcounttext.sc-fguZLD.cTkXIa")).getText();
		Thread.sleep(5000);
		String totalCount = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",
				driver.findElement(By.xpath("//div[starts-with(@class,'totalcounttext sc-')]")));
		System.out.println("Total Count on Default : " + totalCount);

	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void clickOnPostingDate() throws Exception {
		reviewsPage.postingDate();
	
		

	}

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 6) public void
	 * RespondersOptions() throws Exception { reviewsPage.RespondersOptions(); }
	 */

	
	/*
	 * @Test(groups = { "sanity", "regression" },priority = 7) public void
	 * VerifyRespondersOptionFlagReviews() throws InterruptedException {
	 * reviewsPage.VerifyRespondersOptionFlagReviews(); }
	 */
	  
	  
	/*
	 * @Test(groups = { "sanity", "regression" },priority = 8) public void
	 * VerifyGoToReviewSite() throws InterruptedException {
	 * reviewsPage.VerifyGoToReviewSite(); }
	 */
	  
	  
	/*
	 * @Test(groups = { "sanity", "regression" },priority = 8) public void
	 * VerifyReviewHistory() throws InterruptedException {
	 * reviewsPage.VerifyReviewHistory(); }
	 * 
	 * @Test(groups = { "sanity", "regression" },priority = 9) public void
	 * VerifyShareReview() throws InterruptedException {
	 * reviewsPage.VerifyShareReview(); }
	 */
	  
	 @Test(groups = { "sanity", "regression" },priority = 10) 
	 public void TotalCountOnAllTime() throws Exception 
	 {
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  Thread.sleep(2000); 
	  String totalCount = (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerText;",
	  driver.findElement(By.xpath("//div[starts-with(@class,'totalcounttext sc-')]"))); 
	  System.out.println("Total Count on Default : " + totalCount);
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 11) public void
	  VerifyDefaultReviewText() {
	  
	  String defReviewText = driver.findElement(By.xpath("//span[contains(text(),'Review Text')]")).getText(); 
	  String defNotEmpty = driver.findElement(By.xpath("//span[contains(text(),': Not Empty')]")).getText(); 
	  Assert.assertEquals(defReviewText, "Review Text");
	  Assert.assertEquals(defNotEmpty, ": Not Empty");
	  System.out.println("Default ReviewText is ==> " + defReviewText +
	  defNotEmpty);
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 12) 
	  public void AllReviews() 
	  { 
		  driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-') and contains(text(),'expand_more')]")).click();
	  	  driver.findElement(By.xpath("//div[contains(text(),'All Reviews')]")).click();
	  	  String reviewText = driver.findElement(By.xpath("//span[contains(text(),'Review Text')]")).getText();
	  	  Assert.assertEquals(reviewText, "Review Text");
	  	  System.out.println("It displays 'Review Text' on selecting 'All Review'");
	  }
	  
	  
	  
	 @Test(groups = { "sanity", "regression" },priority = 14) public void
	  VerifyRespondFeature() { driver.manage().timeouts().implicitlyWait(60,
	  TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]"))
	  .click();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 // driver.findElement(By.xpath("//div[contains(text(),'Response Required')]")).click();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@class='actionviewstream']")).click();
	  WebElement element =
	  driver.findElement(By.xpath("//span[contains(text(),'Respond')]"));
	  TestUtility.clickOn(driver, element, 60);
	  
	  driver.findElement(By.name("responseTextarea")).sendKeys("Test Message");
	  
	  driver.findElement(By.name("responseTextarea")).sendKeys(Keys.BACK_SPACE);
	  driver.findElement(By.name("responseTextarea")).sendKeys(Keys.BACK_SPACE);
	  driver.findElement(By.name("responseTextarea")).sendKeys(Keys.BACK_SPACE);
	  driver.findElement(By.name("responseTextarea")).sendKeys(Keys.BACK_SPACE);
	  driver.findElement(By.name("responseTextarea")).sendKeys(Keys.BACK_SPACE);
	  
	  driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
	  
	  }
	  
	  
	  
	  @Test(groups = { "sanity", "regression" },priority = 15) public void
	  VerifySourceProvider() throws Exception {
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//a[@id='fltrOptSource']")).click();
	  
	  WebDriverWait wait=new WebDriverWait(driver,20); 
	  WebElement clearAll= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Clear All')]"))); 
	  JavascriptExecutor js =(JavascriptExecutor) driver; js.executeScript("arguments[0].click();",clearAll); 
	  Thread.sleep(5000);
	  //driver.findElement(By.xpath("//a[contains(@class,'dropdownlink sc-') and contains(text(),'Clear All')]")).click();
	  
	  driver.findElement(By.xpath("//label[contains(text(),'Google')]")).click();
	  
	  WebElement applyBtn = driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][4]"));
	  
	  TestUtility.clickOn(driver, applyBtn, 30);
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 16) public void
	  CheckGoogleImage() throws Exception { Thread.sleep(3000);
	  // WebElement ImageFile = //
	  driver.findElement(By.xpath("//img[@src='/img/logos/Google.png']"));
	  
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  
	  WebElement ImageFile = wait
	  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	  "//img[@src='/img/logos/Google.png']")));
	  
	  Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
	  "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0"
	  , ImageFile); if (!ImagePresent) {
	  System.out.println("Google image not displayed."); } else {
	  System.out.println("Google image displayed."); }
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 17) public void
	  checkFacebookImage() throws Exception { Thread.sleep(3000); WebElement
	  sourceProvider = driver.findElement(By.
	  xpath("//a[starts-with(@class,'bqltoggle fltr-opt-source sc-')]"));
	  TestUtility.clickOn(driver, sourceProvider, 30);
	  
	  //driver.findElement(By.xpath("//label[contains(text(),'Google')]")).click();
	  driver.findElement(By.xpath("//input[@id='Google']")).click();
	  //driver.findElement(By.xpath("//label[contains(text(),'Facebook')]")).click( );
	  driver.findElement(By.xpath("//input[@id='Facebook']")).click();  WebElement applyBtn = driver.findElement(By.xpath(
	  "/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][4]"));
	  TestUtility.clickOn(driver, applyBtn, 30);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  
	  WebElement ImageFile = wait.until(
	  ExpectedConditions.visibilityOfElementLocated(By.xpath(
	  "//img[@src='/img/logos/Facebook.png']")));
	  
	  // WebElement ImageFile = //
	  driver.findElement(By.xpath("//img[@src='/img/logos/Facebook.png']"));
	  
	  Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
	  "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0"
	  , ImageFile); if (!ImagePresent) {
	  System.out.println("Facebook image not displayed."); } 
	  else 
	  {
		  System.out.println("Facebook image displayed."); 
	  }
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 18) public void
	  checkYelpImage() throws Exception { Thread.sleep(3000); WebElement
	  sourceProvider = driver.findElement(By.
	  xpath("//a[starts-with(@class,'bqltoggle fltr-opt-source sc-')]"));
	  TestUtility.clickOn(driver, sourceProvider, 30);
	  
	  driver.findElement(By.xpath("//label[contains(text(),'Facebook')]")).click();
	  
	  driver.findElement(By.xpath("//label[contains(text(),'Yelp')]")).click();
	  
	  WebElement applyBtn = driver.findElement(By.xpath(
	  "/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][4]"));
	  TestUtility.clickOn(driver, applyBtn, 30); Thread.sleep(4000); WebElement
	  ImageFile = driver.findElement(By.xpath("//img[@src='/img/logos/Yelp.png']"));
	  
	  Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
	  "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0"
	  , ImageFile); Assert.assertTrue(ImageFile.isDisplayed()); if (!ImagePresent)
	  { System.out.println("Yelp image not displayed."); } else {
	  System.out.println("Yelp image displayed."); }
	  
	  }
	  
	  
	/*
	 * @Test(groups = { "sanity", "regression" },priority = 14) public void
	 * verifyYelpSubmitOption() {
	 * 
	 * driver.findElement(By.xpath("//span[contains(text(),'Respond')]")).click();
	 * 
	 * String goToYelpBtn =
	 * driver.findElement(By.xpath("//span[contains(text(),'Yelp')]")).getText();
	 * System.out.println("For Yelp Review it displayed " + goToYelpBtn);
	 * //Assert.assertEquals(goToYelpBtn, "GO TO YELP"); }
	 */	  
	  
	  @Test(groups = { "sanity", "regression" },priority = 19) public void
	  checkTripAdvisorImage() throws Exception { Thread.sleep(3000); WebElement
	  sourceProvider = driver.findElement(By.
	  xpath("//a[starts-with(@class,'bqltoggle fltr-opt-source sc-')]"));
	  TestUtility.clickOn(driver, sourceProvider, 30);
	  
	  driver.findElement(By.xpath("//label[contains(text(),'Yelp')]")).click();
	  
	  driver.findElement(By.xpath("//label[contains(text(),'TripAdvisor')]")).click
	  ();
	  
	  WebElement applyBtn = driver.findElement(By.
	  xpath("/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][4]"));
	  TestUtility.clickOn(driver, applyBtn, 30); Thread.sleep(4000); WebElement
	  ImageFile =
	  driver.findElement(By.xpath("//img[@src='/img/logos/TripAdvisor.png']"));
	  
	  Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
	  "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0"
	  , ImageFile); Assert.assertTrue(ImageFile.isDisplayed()); if (!ImagePresent)
	  { System.out.println("TripAdvisor image not displayed."); } else {
	  System.out.println("TripAdvisor image displayed."); }
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  }
	  
	/*
	 * @Test(groups = { "sanity", "regression" },priority = 20) public void
	 * verifyTripAdvisorSubmitOption() {
	 * 
	 * driver.findElement(By.xpath("//span[contains(text(),'Respond')]")).click();
	 * 
	 * String goToTripAdvisorBtn =
	 * driver.findElement(By.xpath("//span[contains(text(),'Go to  Tripadvisor')]"))
	 * .getText(); System.out.println("For TripAdvisor Review it displayed "
	 * +goToTripAdvisorBtn);
	 * Assert.assertEquals(goToTripAdvisorBtn,"GO TO TRIPADVISOR");
	 * 
	 * }
	 */
	  
	  @Test(groups = { "sanity", "regression" },priority = 21) public void
	  googleSourceProvider() throws Exception {
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); WebElement
	  sourceProvider = driver.findElement(By.
	  xpath("//a[starts-with(@class,'bqltoggle fltr-opt-source sc-')]"));
	  TestUtility.clickOn(driver, sourceProvider, 30);
	  driver.findElement(By.xpath("//label[contains(text(),'TripAdvisor')]")).click
	  ();
	  driver.findElement(By.xpath("//label[contains(text(),'Google')]")).click();
	  WebElement applyBtn = driver.findElement(By.xpath(
	  "/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][4]"));
	  TestUtility.clickOn(driver, applyBtn, 30);
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 22) public void
	  VerifyTotalReviewsFor10() {
	  
	  Select drpCountry = new Select(driver.findElement(By.
	  xpath("//select[starts-with(@class,'review-selectsmall sc-')]")));
	  drpCountry.selectByValue("10");
	  
	  List<WebElement> elements =
	  driver.findElements(By.xpath("//div[starts-with(@class,'tile-company')]"));
	  System.out.println("Number of elements:" + elements.size());
	  
	  
	  for (int i = 0; i < elements.size(); i++) {
	  System.out.println("Review Records List : " + elements.get(i).getText()); } }
	  
	  @Test(groups = { "sanity", "regression" },priority = 23) public void
	  VerifyTotalReviewsFor25() {
	  
	  Select drpCountry = new Select( driver.findElement(By.
	  xpath("//select[starts-with(@class,'review-selectsmall sc-')]")));
	  drpCountry.selectByValue("25");
	  
	  List<WebElement> elements =
	  driver.findElements(By.xpath("//div[starts-with(@class,'tile-company')]"));
	  System.out.println("Number of elements:" + elements.size());
	  
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 24) public void
	  VerifyTotalReviewsFor50() {
	  
	  Select drpCountry = new Select( driver.findElement(By.
	  xpath("//select[starts-with(@class,'review-selectsmall sc-')]")));
	  drpCountry.selectByValue("50");
	  
	  List<WebElement> elements =
	  driver.findElements(By.xpath("//div[starts-with(@class,'tile-company')]"));
	  System.out.println("Number of elements:" + elements.size());
	  
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 25) public void
	  VerifyTotalReviewsFor100() {
	  
	  Select drpCountry = new Select( driver.findElement(By.
	  xpath("//select[starts-with(@class,'review-selectsmall sc-')]")));
	  drpCountry.selectByValue("100");
	  
	  List<WebElement> elements =
	  driver.findElements(By.xpath("//div[starts-with(@class,'tile-company')]"));
	  System.out.println("Number of elements:" + elements.size());
	  
	  
	  int count = driver.findElements(By.xpath("//div[contains(@class,'tileheader sc-')]")).size();
	  //Assert.assertTrue(count > 100);
	  System.out.println("Count is greater than 100. Count is: " + count);
	  
	  
	  for (int i=0; i<elements.size();i++)
	  {
	  System.out.println("Review Records List : " + elements.get(i).getText()); 
	  }
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 26) public void
	  VerifyTagsFunctionality() throws Exception { JavascriptExecutor js =
	  (JavascriptExecutor) driver; WebElement showTags = driver.findElement(By.
	  xpath("//button[starts-with(@class,'review-showtags sc-')]"));
	  js.executeScript("arguments[0].click();", showTags);
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //driver.findElement(By.xpath("//button[@class='review-showtags sc-hBfwTO eOuMRJ']")).click(); 
	  //driver.findElement(By.xpath("//input[@type='text']")).getAttribute("placeholdertext");
	  
	  String HideTags = driver.findElement(By.xpath("//div[contains(@class,'actionsright sc-')]/child::button[contains(@class,'review-showtags sc-')]" )).getText();
	  System.out.println("Button converts from Show Tags to : " +HideTags);
	  
	  
	  String placeHolderValue = driver .findElement(By.
	  xpath("//input[@type='text' and @placeholder='Enter new tag here...']"))
	  .getAttribute("placeholder"); System.out.println("place Holder name is : " +
	  placeHolderValue);
	  
	  
	  
	  
	  driver.findElement(By.
	  xpath("//input[@type='text' and @placeholder='Enter new tag here...']")).
	  click(); Thread.sleep(1000);
	  driver.findElement(By.xpath("//div[contains(text(),'Birthday')]")).click();
	  String tagName = driver.findElement(By.xpath(
	  "//span[@title='Primary tag - Drag tags to reorder. The first tag will be the primary tag used in reports and exports.']"
	  )) .getText(); System.out.println("Added Tag name is ==> " + tagName);
	  Thread.sleep(1000);
	  
	  WebElement xClick = driver.findElement(By.
	  xpath("//span[@title='Primary tag - Drag tags to reorder. The first tag will be the primary tag used in reports and exports.']"
	  )); js.executeScript("arguments[0].click();", xClick);
	  //driver.findElement(By.xpath("//div[@class='tile-tagswrapper sc-gTwXSI ImmEY']//a[@class='title-tagvalues sc-kyseJx hpqrsj']//span[contains(text(),'x')]")).click();
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 27) 
	  public void addSaveFilter() throws Exception { 
		  reviewsPage.saveFilter();
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  
	  reviewsPage.verifyFilter(); 
	  Thread.sleep(2000);
	  String filterRecordPresent = driver.findElement(By.xpath("//h5[starts-with(@class,'savedfiltertitle sc-')][contains(text(),'Test123')]")) .getText();
	  Assert.assertTrue(filterRecordPresent.contains("Test123"));
	  System.out.println("Filter name which is saved ==> " + filterRecordPresent);
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 28) 
	  public void deleteFilter() throws Exception { 
		Thread.sleep(3000);
	  driver.findElement(By.xpath("//h5[contains(text(),'Test123')]//following::i[2]")).click();
	  reviewsPage.verifyFilter(); Assert.assertFalse(false);
	  
	  }
	  
	  @Test(groups = { "sanity", "regression" },priority = 29) public void
	  AddFilter() { JavascriptExecutor js = (JavascriptExecutor) driver; WebElement
	  mainMenu =
	  driver.findElement(By.xpath("//a[starts-with(@class,'filter-add sc-')]"));
	  js.executeScript("arguments[0].click();", mainMenu);
	  
	  WebElement addFilterOption =
	  driver.findElement(By.xpath("//select[@id='adtlFiltOpts']"));
	  js.executeScript("arguments[0].click();", addFilterOption);
	  
	  WebElement mySelectElement =
	  driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")); Select dropdown
	  = new Select(mySelectElement); dropdown.selectByVisibleText("Author");
	  
	  driver.findElement(By.xpath("//input[@id='adtlOptTxt']")).
	  sendKeys("Richard Y.");
	  
	  WebElement applyBtn =
	  driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']"));
	  TestUtility.clickOn(driver, applyBtn, 30);
	  
	  String addFilter =
	  driver.findElement(By.xpath("//span[contains(text(),'Author')]")).getText();
	  Assert.assertEquals(addFilter, "Author"); System.out.println(addFilter +
	  " filter gets added "); }
	  
	  @Test(groups = { "sanity", "regression" },priority = 30) public void
	  RemoveFilter() {
	  driver.findElement(By.xpath("//a[@id='fltrOptAuthor']")).click(); WebElement
	  removeFilter = driver.findElement(By.
	  xpath("/descendant::a[starts-with(@class,'dropdownwrapperactioncenter sc-')][6]"
	  )); removeFilter.click();
	  System.out.println("Added Filter gets Removed successfully");
	  
	  }
	  
	  
	  @AfterClass(alwaysRun = true) public void tearDown() 
	  { 
		  driver.quit();
	  } 
	 

}
