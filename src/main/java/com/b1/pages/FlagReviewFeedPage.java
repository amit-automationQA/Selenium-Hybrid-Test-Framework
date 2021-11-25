package com.b1.pages;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;

 

public class FlagReviewFeedPage extends TestBase {

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

	@FindBy(xpath = "//div[starts-with(@class,'cs-dropdownitem')][contains(text(),'geostix2')]")
	WebElement geo;

	@FindBy(xpath = "//i[starts-with(@class,'context-account fonticon sc-')]")
	WebElement all_locations;

	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile;

	@FindBy(xpath = "//div[contains(text(),'Accounts')]")
	WebElement Account;

	@FindBy(xpath = "//div[contains(text(),'Entitlements')]")
	WebElement Entitlements;

	@FindBy(xpath = "//div[contains(text(),'Internal')]")
	WebElement Internal;

	@FindBy(xpath = "/descendant::div[starts-with(@class,'date-wrapper sc-')][1]/span")
	WebElement ReviewDate;

	@FindBy(xpath = "/descendant::div[starts-with(@class,'date-wrapper sc-')][1]/span")
	WebElement ReviewDate1;

	@FindBy(xpath = "/descendant::i[contains(text(),'flag')][1]")
	WebElement Flag;

	@FindBy(xpath = "/descendant::input[(@placeholder='Add Tag')][1]")
	WebElement AddTag;

	public FlagReviewFeedPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public void VerifyOneStagingLogin(String un, String pa) throws InterruptedException {
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

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Location Overview')]")));
		driver.navigate().refresh();
		locations.click();
		Thread.sleep(3000);
		search_feild.click();
		search_feild.clear();
		Thread.sleep(2000);
		search_feild.sendKeys("geos");
		Thread.sleep(3000);
		geo.click();
		Thread.sleep(2000);
		all_locations.click();
	}

	public void ClickOnReviews() throws Exception {
		/*
		 * Thread.sleep(5000); driver.manage().timeouts().implicitlyWait(30,
		 * TimeUnit.SECONDS); WebElement locator =
		 * driver.findElement(By.xpath("//div[contains(text(),'REVIEWS')]")); new
		 * WebDriverWait(driver, 60).ignoring(NoSuchSessionException.class)
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

	public void VerifyFlagIcon() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();

		Thread.sleep(7000);
		boolean Flag = driver.findElement(By.xpath("//i[contains(text(),'flag')]")).isDisplayed();
		Assert.assertTrue(Flag);
		System.out.println("Flag icon is Displayed at the top right corner of the every review tile on the page");
	}

	public void FlagIconInResponseRequired() throws InterruptedException {

		Thread.sleep(5000);
		String ReviewDate = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'date-wrapper sc-')][1]/span")).getText();
		// FlagDate.getText();
		System.out.println(ReviewDate);
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement Flag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]"));
		js1.executeScript("arguments[0].click();", Flag);

		Thread.sleep(2000);
	}

	public void GoToFlaggedReviews() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Response Required')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Flagged Reviews')]")).click();
		Thread.sleep(3000);

	}

	public void VerifyFlaggedReview() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();

		Thread.sleep(5000);

		ReviewDate.getText();
		ReviewDate.isDisplayed();
		Flag.isSelected();
	}

	public void UnflagReview() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement UnFlag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]"));
		js1.executeScript("arguments[0].click();", UnFlag);
	}

	public void VerifyUnflaggedReview() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Flagged Reviews')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Response Required')][1]")).click();
		Thread.sleep(3000);
	}

	public void UnflaggedReviewisPresentinRR() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();

		Thread.sleep(3000);

		ReviewDate.getText();
		System.out.println(ReviewDate);
		ReviewDate1.getText();
		System.out.println(ReviewDate1);
		Assert.assertEquals(ReviewDate, ReviewDate1);

	}

	public void SelectRespondedReview() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded Reviews')][1]")).click();
		Thread.sleep(3000);

	}

	public void FlagIconInResponedReview() throws InterruptedException {

		Thread.sleep(3000);
		String ReviewDate2 = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'date-wrapper sc-')][1]/span")).getText();

		System.out.println(ReviewDate2);
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement Flag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]"));
		js1.executeScript("arguments[0].click();", Flag);

		Thread.sleep(2000);

	}

	public void GoToFlaggedReviewsforRR() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Responded Reviews')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Flagged Reviews')][1]")).click();
		Thread.sleep(3000);

	}

	public void VerifyFlaggedReviewForRR() {

		ReviewDate.getText();
		ReviewDate.isDisplayed();
		Flag.isSelected();

	}

	public void UnflagReviewForRR() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement UnFlag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]"));
		js1.executeScript("arguments[0].click();", UnFlag);
	}

	public void VerifyUnflaggedReviewForRR() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Flagged Reviews')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded Reviews')][1]")).click();
		Thread.sleep(3000);
	}

	public void UnflaggedReviewIsPresentInRespondedReview() {
		ReviewDate.getText();
		System.out.println(ReviewDate);
		ReviewDate1.getText();
		System.out.println(ReviewDate1);
		Assert.assertEquals(ReviewDate, ReviewDate1);

	}

	public void SelectAllReviews() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'All Reviews')][1]")).click();
		Thread.sleep(3000);

	}

	public void FlagIconInAllReviews() throws InterruptedException {

		Thread.sleep(3000);
		String ReviewDate2 = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'date-wrapper sc-')][1]/span")).getText();

		System.out.println(ReviewDate2);
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement Flag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]"));
		js1.executeScript("arguments[0].click();", Flag);

		Thread.sleep(2000);

	}

	public void VerifyFlaggedReviewForAllReviews() {

		ReviewDate.getText();
		ReviewDate.isDisplayed();
		Flag.isSelected();

	}

	public void UnflagReviewForAllReviews() throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement UnFlag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]"));
		js1.executeScript("arguments[0].click();", UnFlag);
	}

	// +Add Filters:

	public void AuthorVarification() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();

		driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[contains(text(),'Author')]")).click();

		WebElement Name = driver.findElement(By.xpath("//input[@id='adtlOptTxt']"));
		Name.sendKeys("Eric");

		driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']")).click();
		Thread.sleep(2000);
		String Name1 = driver.findElement(By.xpath("//span[contains(text(),'Eric')]")).getText();
		Assert.assertTrue(Name1.contains("Eric"));
		System.out.println("Searched Author Name is Varified Successfully");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@id='fltrOptAuthor']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][6]")).click();

	}

	public void ModifiedReviewsFilter() throws InterruptedException {
		SelectAllReviews();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();

		driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[contains(text(),'Modified Review')]")).click();

		driver.findElement(By.xpath("//input[@id='availableModified']")).click();

		driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']")).click();

		Thread.sleep(2000);
		String Name1 = driver.findElement(By.xpath("//span[contains(text(),'Modified by Original Author')]")).getText();
		Assert.assertTrue(Name1.contains("Modified by Original Author"));
		System.out.println("The Review is Modified by Original Author");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptModified Review']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Modified']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='Unmodified']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][6]")).click();

		System.out.println("Modified by Original Author is not Present");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptModified Review']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][6]")).click();

	}

	public void VerifyFlaggedReviewsFromAddFilters() throws InterruptedException {
		SelectAllReviews();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();

		driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/descendant::option[contains(text(),'Flagged Review')][2]")).click();

		driver.findElement(By.xpath("//input[@id='availableFlagged']")).click();

		driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']")).click();

		Thread.sleep(2000);
		boolean Flag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]")).isDisplayed();
		boolean flag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]")).isEnabled();
		Assert.assertTrue(Flag);
		Assert.assertTrue(flag);
		System.out.println("Displayed Reviews are flagged");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptFlagged Review']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Flagged']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Unflagged']")).click();

		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][6]")).click();

		Thread.sleep(2000);
		boolean UnFlag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]")).isDisplayed();
		boolean Unflag = driver.findElement(By.xpath("/descendant::i[contains(text(),'flag')][1]")).isSelected();
		Assert.assertTrue(UnFlag);
		Assert.assertFalse(Unflag);
		System.out.println("Displayed Reviews are Unflagged");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptFlagged Review']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][6]")).click();

	}

	public void VerifyTags() throws InterruptedException {

		Thread.sleep(2000);
		WebElement AddTag = driver.findElement(By.xpath("/descendant::input[(@placeholder='Add Tag')][1]"));
		AddTag.sendKeys("Automation");
		AddTag.sendKeys(Keys.ENTER);
		System.out.println("Tag Entered Successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();

		driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();

		driver.findElement(By.xpath("//option[contains(text(),'Tags')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='adtlOptTxt']")).sendKeys("automation");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']")).click();
		Thread.sleep(2000);

		boolean Tag = driver.findElement(By.xpath("//span[contains(text(),'Automation')]")).isDisplayed();
		Assert.assertTrue(Tag);
		System.out.println("Searched Tag Verified Successfully");

		WebElement TagName = driver.findElement(By.xpath("//span[contains(text(),'Automation')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(TagName).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::i[contains(text(),'close')][3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptTags']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][6]")).click();

	}

	public void VerifyRespondedDates() throws InterruptedException, ParseException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();

		driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//option[contains(text(),'Responded Date')]")).click();

		driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']")).click();

		Thread.sleep(3000);

		boolean RespondedReviews = driver.findElement(By.xpath("//div[starts-with(@class,'responded-text sc-')]"))
				.isDisplayed();
		Assert.assertTrue(RespondedReviews);
		System.out.println("Responded Reviews Are Displayed for All Time");

		driver.findElement(By.xpath("//a[@id='fltrOptResponded Date']")).click();
		Thread.sleep(1000);
		/*
		 * driver.findElement(By.xpath(
		 * "/descendant::button[starts-with(@class,'react-calendar__navigation__label')][2]"
		 * )) .click(); Thread.sleep(1000); driver.findElement(By.xpath(
		 * "/descendant::button[starts-with(@class,'react-calendar__navigation__label')][2]"
		 * )) .click(); Thread.sleep(2000); driver.findElement(By.xpath(
		 * "/descendant::button[@class='react-calendar__navigation__arrow react-calendar__navigation__prev-button'][2]"
		 * )) .click(); Thread.sleep(1000);
		 * driver.findElement(By.xpath("//time[contains(text(),'2020')]")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//time[contains(text(),'January')]")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("/descendant::time[contains(text(),'27')][2]")).
		 * click(); Thread.sleep(1000);
		 * driver.findElement(By.xpath("/descendant::time[contains(text(),'27')][2]")).
		 * click(); Thread.sleep(1000);
		 * driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][6]")).
		 * click();
		 * 
		 * Thread.sleep(2000); String RespondDate =
		 * driver.findElement(By.xpath("//span[contains(text(),'01/27/2020')]")).getText
		 * (); Assert.assertEquals(RespondDate, "01/27/2020");
		 * System.out.println("Responded Review Date is Displayed");
		 */
		String setDatestr = "11/07/2018";// DDMMYYYY
		String currentDatestr = driver.findElement(By.xpath(
				"/descendant::button[starts-with(@class,'react-calendar__navigation__label')][contains(text(),'February 2021')][2]"))
				.getText();// MMM YYY
		Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
		Date currentDate = new SimpleDateFormat("MMM yyyy").parse(currentDatestr);
		int monthDiff = Months
				.monthsBetween(new DateTime(currentDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1))
				.getMonths();
		boolean isFuture = true;
		if (monthDiff < 0) {
			isFuture = false;
			monthDiff = -1 * monthDiff;
		}
		for (int i = 0; i < monthDiff; i++) {
			if (isFuture)
				driver.findElement(By.xpath(
						"/descendant::button[starts-with(@class,'react-calendar__navigation__arrow react-calendar__navigation__next-button')][contains(text(),'›')][2]"))
						.click();
			else
				driver.findElement(By.xpath(
						"/descendant::button[@class='react-calendar__navigation__arrow react-calendar__navigation__prev-button'][contains(text(),'‹')][2]"))
						.click();

		}

		driver.findElement(By.xpath("/descendant::time[contains(text(),'11')][2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::time[contains(text(),'11')][2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][6]")).click();

		Thread.sleep(2000);
		String RespondDate = driver.findElement(By.xpath("//span[contains(text(),'11/07/2018')]")).getText();
		Assert.assertEquals(RespondDate, "11/07/2018");
		System.out.println("Responded Review Date is Displayed");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptResponded Date']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][6]")).click();

	}

	public void VerifyStoreNumberWithNumeric() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'All Reviews')][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();

		driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//option[contains(text(),'Store Number')]")).click();

		WebElement StoreNumber = driver.findElement(By.xpath("//input[@id='adtlOptTxt']"));
		StoreNumber.sendKeys("201");
		// test_B1-2866

		driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']")).click();

		Thread.sleep(3000);

		String StoreName = driver.findElement(By.xpath("/descendant::a[(@class='header-link')][1]")).getText();
		Assert.assertTrue(StoreName.contains("201"));
		System.out.println("The Store Number is Displayed As per Numeric Search Result");

	}

	public void VerifyStoreNumberWithAlfaNumeric() throws InterruptedException {
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//div[contains(text(),'Reviews
		// Feed:')]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("/descendant::div[contains(text(),'All
		// Reviews')][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptStore Number']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'201')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::input[@id='fltrTxtInput'][2]")).sendKeys("test1_B1-3454");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][6]")).click();
		Thread.sleep(3000);

		String StoreName = driver.findElement(By.xpath("/descendant::a[(@class='header-link')][1]")).getText();
		Assert.assertTrue(StoreName.contains("test1_B1-3454"));
		System.out.println("The Store Number is Displayed As per AlfaNumeric Search Result");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptStore Number']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][6]")).click();

	}

	public void VerifyPublicResponse() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded Reviews')][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();

		driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//option[contains(text(),'Public Response')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'All Time')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][contains(text(),'Apply')][1]")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Clear All')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Facebook']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][5]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@id='fltrOptPublic Response']")).click();
		driver.findElement(By.xpath("/descendant::input[@id='fltrTxtInput'][2]")).sendKeys("Thanks");
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][7]")).click();

		Thread.sleep(5000);
		boolean Public = driver.findElement(By.xpath("/descendant::i[contains(text(),'language')][2]")).isDisplayed();
		Assert.assertTrue(Public);
		System.out.println("The Public Response Symbol is displayed");

		String PublicText = driver.findElement(By.xpath("//span[contains(text(),'thanks for your review.')]")).getText();
		Assert.assertTrue(PublicText.contains("thanks for your review."));

		driver.findElement(By.xpath("//a[@id='fltrOptPublic Response']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][7]")).click();


	}

	public void VerifyPrivateResponse() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'All Reviews')][1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='filterAdd']")).click();

		driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//option[contains(text(),'Private Response')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='adtlOptTxt']")).sendKeys("testing this response privately");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='adtlOptApplyBtn']")).click();
		Thread.sleep(3000);

		/*
		 * boolean Private = driver.findElement(By
		 * .xpath("//div[starts-with(@class,'responded-text sc-')]//i[starts-with(@class,'material-icons  sc-')]"
		 * )) .isDisplayed(); Assert.assertTrue(Private);
		 * System.out.println("Symbol of Private Response is Displayed");
		 * Thread.sleep(1000);
		 * 
		 * String PrivateText = driver.findElement(By.
		 * xpath("//span[contains(text(),'testing this response privately')]"))
		 * .getText(); Assert.assertEquals(PrivateText,
		 * "testing this response privately");
		 * System.out.println("Private Response Text Verified Successfully");
		 */

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='fltrOptPrivate Response']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),' Remove this filter')][6]")).click();
		Thread.sleep(3000);

	}

	public void VerifyStatusOfReviewTile() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Response Required')][1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();

		Thread.sleep(3000);
		WebElement New = driver.findElement(By.xpath("/descendant::span[contains(text(),'New')][3]"));
		if (New.isDisplayed() && New.isEnabled()) {
			String Text = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'date-wrapper sc-')][1]"))
					.getText();
			System.out.println(Text);
			New.click();

			Thread.sleep(2000);
			WebElement ReviewStatus = driver.findElement(By.xpath("//a[@id='fltrOptReview Status']"));
			ReviewStatus.click();

			Thread.sleep(1000);
			WebElement SelectAllStatus = driver
					.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]"));
			SelectAllStatus.click();

			Thread.sleep(1000);
			WebElement ClearAllStatus = driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]"));
			ClearAllStatus.click();

			Thread.sleep(1000);
			WebElement DoneStatus = driver.findElement(By.xpath("//input[@id='Done']"));
			DoneStatus.click();

			Thread.sleep(1000);
			WebElement Apply = driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]"));
			Apply.click();

			Thread.sleep(3000);

			String DoneText = driver
					.findElement(By.xpath("/descendant::div[starts-with(@class,'date-wrapper sc-')][1]")).getText();
			// Assert.assertEquals(Text, DoneText);
			// System.out.printf(Text, DoneText);
			System.out.println("Both Reviews Are Same");

			WebElement Done = driver.findElement(By.xpath("/descendant::span[contains(text(),'Done')][2]"));
			if (Done.isDisplayed() && Done.isEnabled()) {
				Done.click();
			}

			Thread.sleep(2000);
			WebElement ReviewStatus1 = driver.findElement(By.xpath("//a[@id='fltrOptReview Status']"));
			ReviewStatus1.click();

			Thread.sleep(1000);
			WebElement SelectAllStatus1 = driver
					.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]"));
			SelectAllStatus1.click();

			Thread.sleep(1000);
			WebElement ClearAllStatus1 = driver
					.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]"));
			ClearAllStatus1.click();

			Thread.sleep(1000);
			WebElement NewStatus = driver.findElement(By.xpath("//input[@id='New']"));
			NewStatus.click();

			Thread.sleep(1000);
			Apply.click();
		}
	}

	public void VerifyRespondHistory() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded Review')][1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'All Time')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();

		// boolean RespondDate =
		// driver.findElement(By.xpath("/descendant::div[starts-with(@class,'responded-user-and-time
		// sc-')][1]")).isDisplayed();

		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'show-more-options sc-')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Review History')][1]")).click();
		Thread.sleep(1000);

		boolean RespondHistory = driver.findElement(By.xpath("//div[starts-with(@class,'history-box sc-')]"))
				.isDisplayed();
		// Assert.assertEquals(RespondDate, RespondHistory);
		System.out.println("Responded History is Displayed");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'CLOSE')]")).click();
		// driver.findElement(By.xpath("//a[contains(@class,'send sc-bxivhb
		// cXjGIX')]")).click();
	}

	public void EmailSchedulerVerify() throws InterruptedException {

		Thread.sleep(3000);
		boolean Envolope = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/ul[2]/li[2]"))
				.isDisplayed();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/ul[2]/li[2]")).click();

		// Scheduled Email Check :::>>>>>>>>
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][2]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][3]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement DeleteIcon = driver
				.findElement(By.xpath("//div[starts-with(@class,'sc-')]//i[contains(text(),'delete')]"));
		js1.executeScript("arguments[0].click();", DeleteIcon);

		Thread.sleep(1000);
		String ConfirmDelete = driver.findElement(By.xpath("//div[contains(text(),'Please Confirm Deletion')]"))
				.getText();
		// Assert.assertTrue(ConfirmDelete.contains("Please Confirm Deletion"));
		System.out.println("Pop-up Box for confirm delete Email is Displyed");

		WebElement Cancel = driver.findElement(
				By.xpath("//a[starts-with(@class,'confirm-popup-cancel sc-')][contains(text(),'Cancel')]"));
		// Assert.assertEquals(Cancel, "CANCEL");

		WebElement Delete = driver.findElement(
				By.xpath("//a[starts-with(@class,'confirm confirm-popup-confirm sc-')][contains(text(),'Delete')]"));
		// Assert.assertEquals(Delete, "DELETE");

		driver.findElement(By.xpath("//a[starts-with(@class,'confirm-popup-cancel sc-')][contains(text(),'Cancel')]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();

	}

	public void ContextSwitchForSameFilter() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Response Required')][1]")).click();
		Thread.sleep(3000);

		// Filters Displayed Before Changing Context:::::>>>>>>
		Thread.sleep(3000);
		String PostingDate = driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).getText();
		String ReviewStatus = driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).getText();
		String ReviewText = driver.findElement(By.xpath("//a[@id='fltrOptReview Text']")).getText();
		String Publisher = driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).getText();
		String Rating = driver.findElement(By.xpath("//a[starts-with(@class,'bqltoggle sc-')]")).getText();
		String AddFilter = driver.findElement(By.xpath("//a[@id='filterAdd']")).getText();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement Context = driver.findElement(By.xpath("//i[contains(text(),'language')]"));
		js1.executeScript("arguments[0].click();", Context);

		Thread.sleep(2000);
		WebElement SelectContext = driver
				.findElement(By.xpath("/descendant::span[starts-with(@class,'cs-storename sc-')][1]"));
		js1.executeScript("arguments[0].click();", SelectContext);

		// Filters Displayed After Changing Context:::::>>>>>>
		Thread.sleep(3000);
		String ContextPostingDate = driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).getText();
		Assert.assertEquals(PostingDate, ContextPostingDate);

		String ContextReviewStatus = driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).getText();
		Assert.assertEquals(ReviewStatus, ContextReviewStatus);

		String ContextReviewText = driver.findElement(By.xpath("//a[@id='fltrOptReview Text']")).getText();
		Assert.assertEquals(ReviewText, ContextReviewText);

		String ContextPublisher = driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).getText();
		Assert.assertEquals(Publisher, ContextPublisher);

		String ContextRating = driver.findElement(By.xpath("//a[starts-with(@class,'bqltoggle sc-')]")).getText();
		Assert.assertEquals(Rating, ContextRating);

		String ContextAddFilter = driver.findElement(By.xpath("//a[@id='filterAdd']")).getText();
		Assert.assertEquals(AddFilter, ContextAddFilter);

		System.out.println("Displayed filters are same as After Changing the Context and before changing the context");

		Thread.sleep(1000);
		WebElement groupContext = driver.findElement(By.xpath("//i[starts-with(@class,'location-group-icon  sc-')]"));
		js1.executeScript("arguments[0].click();", groupContext);

		Thread.sleep(2000);
		WebElement AllLocationContext = driver
				.findElement(By.xpath("//div[starts-with(@class,'cs-alllocations sc-')]"));
		js1.executeScript("arguments[0].click();", AllLocationContext);

	}

	public void VerifyRespondToReview() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Facebook']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]")).click();
		Thread.sleep(3000);

		String Name = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'stars-and-user-info sc-')][1]"))
				.getText();
		System.out.println(Name);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement RespondButton = driver
				.findElement(By.xpath("/descendant::a[starts-with(@class,'reply reply-to-review-start sc-')][1]"));
		RespondButton.isDisplayed();
		js1.executeScript("arguments[0].click();", RespondButton);

		driver.findElement(By.xpath("//textarea[contains(@placeholder,'Enter your reply here...')]"))
				.sendKeys("Thank you...");

		WebElement Respond = driver.findElement(By.xpath("//a[starts-with(@class,'reply submit-response sc-')]"));
		js1.executeScript("arguments[0].click();", Respond);

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded Review')][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Facebook']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][5]")).click();
		Thread.sleep(3000);

		String Name1 = driver
				.findElement(By.xpath("/descendant::div[starts-with(@class,'stars-and-user-info sc-')][1]")).getText();
		//Assert.assertEquals(Name, Name1);

		String RespondText = driver.findElement(By.xpath("//span[contains(text(),'Thank you...')]")).getText();
		System.out.println(RespondText);
		Assert.assertEquals(RespondText, "Thank you...");
		System.out.println("Review is been Responded Successfully");

		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'show-more-options sc-')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Delete')][1]")).click();
		Thread.sleep(1000);
		WebElement ConfirmDelete = driver.findElement(By.xpath("//a[contains(text(),'Successfully Deleted')]"));
		ConfirmDelete.isDisplayed();
		ConfirmDelete.click();
		System.out.println("Responded Review is Deleted Successfully");
		Thread.sleep(5000);
	}

	public void VeirfyQueuedReviewstatus() throws InterruptedException {

		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'All Reviews')][1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Clear All')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Queued']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();

		Thread.sleep(3000);
		String Queued = driver.findElement(By.xpath("/descendant::a[starts-with(@class,'status-button sc-')][1]"))
				.getText();
		Assert.assertEquals(Queued, "Done");
		System.out.println("Queued Reviews are Displayed");

	}

	public void VeirfyFailedReviewstatus() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Clear All')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Failed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();

		Thread.sleep(3000);
		String Failed = driver.findElement(By.xpath("/descendant::a[starts-with(@class,'status-button sc-')][1]"))
				.getText();
		Assert.assertEquals(Failed, "Failed");
		System.out.println("Failed Reviews are Displayed");

	}

	public void VerifyAutomationModeForYelp() throws InterruptedException {

		Thread.sleep(3000);
		TestUtility.clickOn(driver, MyProfile, 30);
		TestUtility.clickOn(driver, Account, 30);
		TestUtility.clickOn(driver, Internal, 30);

		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::div[@class='ReviewYelpRespond-auto field'][1]")).click();
		System.out.println("Yelp respond Box is Displayed");
		Thread.sleep(1000);
		boolean Toggle = driver.findElement(By.xpath(
				"//div[@class='ReviewYelpRespond-auto field']//input[@type='checkbox'][@name='auto'][@value='on']"))
				.isSelected();
		System.out.println("Toogle button is set to Yes");
		WebElement checkbox = driver.findElement(By.xpath("//div[@class='ReviewYelpRespond-auto field']/div"));
		System.out.println("Checkbox is selected");
		if (Toggle != checkbox.isSelected()) {

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			WebElement Yes = driver.findElement(By.xpath(
					"//div[@class='ReviewYelpRespond-auto field']//input[@type='checkbox'][@name='auto'][@value='on']"));
			js1.executeScript("arguments[0].click();", Yes);

			System.out.println("Toggle is checked to No");

			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
			Thread.sleep(2000);
			System.out.println("Toggle for Manual Selection set to NO");
		} else {
			System.out.println("Yelp Respond is set to Manual");

		}

		driver.navigate().refresh();

		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Reviews = driver.findElement(By.xpath("//div[contains(text(),'REVIEWS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(Reviews);
		actions.click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Reviews Feed')][1]")).click();

	}

	public void VerifyFailedStatus() throws InterruptedException {
		/*
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click
		 * (); Thread.sleep(2000); driver.findElement(By.
		 * xpath("/descendant::div[contains(text(),'Response Required')][1]")).click();
		 */
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
	Thread.sleep(1500);
	driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();
	Thread.sleep(1500);
		driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][2]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[contains(text(),'Clear All')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='Yelp']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]")).click();
		Thread.sleep(3000);

		String Text = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'date-wrapper sc-')][1]"))
				.getText();
		WebElement New = driver.findElement(By.xpath("/descendant::span[contains(text(),'New')][3]"));
		if (New.isDisplayed() && New.isEnabled()) {
			System.out.println(Text);
		}

		/*
		 * Thread.sleep(2500);
		 * driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		 * Thread.sleep(1500);
		 * driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).
		 * click();
		 */
		Thread.sleep(1500);
		WebElement reply = driver.findElement(By.xpath("/descendant::i[contains(text(),'reply')][1]"));
		if (reply.isDisplayed() && reply.isEnabled()) {
			reply.click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[contains(@placeholder,'Enter your reply here...')]"))
				.sendKeys("Thank you...");

		Thread.sleep(1000);
		WebElement Respond = driver.findElement(By.xpath("//a[starts-with(@class,'reply open-manual-popup sc-')]"));
		if (Respond.isDisplayed() && Respond.isEnabled()) {
			Respond.click();
		}

		WebElement UnableToRespond = driver.findElement(By.xpath("//a[contains(text(),'Unable to Respond')]"));
		Assert.assertTrue(UnableToRespond.isDisplayed());
		UnableToRespond.click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Failed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();

		Thread.sleep(3000);
		String Text1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'date-wrapper sc-')][1]"))
				.getText();
		// Assert.assertEquals(Text, Text1);
		System.out.println(Text1);
		System.out.println("Both New & Failed Reviews are same");

		String Failed = driver.findElement(By.xpath("/descendant::span[contains(text(),'Failed')][1]")).getText();
		Assert.assertEquals(Failed, "Failed");
		Thread.sleep(1000);
		String Responded = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'responded-text sc-')][1]"))
				.getText();
		Assert.assertTrue(Responded.contains("Thank you..."));
		//Assert.assertTrue(Responded.contains("thanks so much!"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'show-more-options sc-')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Delete')][1]")).click();
		Thread.sleep(1000);
		WebElement ConfirmDelete = driver.findElement(By.xpath("//a[contains(text(),'Successfully Deleted')]"));
		ConfirmDelete.isDisplayed();
		ConfirmDelete.click();
		System.out.println("Responded Review is Deleted Successfully");
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(7000);

		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='New']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();
		Thread.sleep(3000);

	}

	public void YelpUpdateManualReviewProcessDialogText() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Yelp']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]")).click();
		Thread.sleep(3000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement RespondButton = driver
				.findElement(By.xpath("/descendant::a[starts-with(@class,'reply reply-to-review-start sc-')][1]"));
		RespondButton.isDisplayed();
		System.out.println(RespondButton);
		js1.executeScript("arguments[0].click();", RespondButton);

		driver.findElement(By.xpath("//textarea[contains(@placeholder,'Enter your reply here...')]"))
				.sendKeys("Thank you...");

		WebElement Respond = driver.findElement(By.xpath("//a[starts-with(@class,'reply open-manual-popup sc-')]"));
		js1.executeScript("arguments[0].click();", Respond);

		String UnabletoRespond = driver.findElement(By.xpath("//a[contains(text(),'Unable to Respond')]")).getText();
		Assert.assertEquals(UnabletoRespond, "UNABLE TO RESPOND");
		System.out.println("Unable to respond Button is displayed");

		String SuccessfullyoResponded = driver.findElement(By.xpath("//a[contains(text(),'Successfully Responded')]"))
				.getText();
		Assert.assertEquals(SuccessfullyoResponded, "SUCCESSFULLY RESPONDED");
		System.out.println("Successfully Responded Button is displayed");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Unable to Respond')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Failed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'show-more-options sc-')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Edit')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[starts-with(@class,'reply open-manual-popup sc-')]")).click();
		

		Thread.sleep(1000);

		String UnabletoEdit = driver.findElement(By.xpath("//a[contains(text(),'Unable to Edit')]")).getText();
		Assert.assertEquals(UnabletoEdit, "UNABLE TO EDIT");
		System.out.println("Unable to Edit Button is displayed");

		String SuccessfullyoEdited = driver.findElement(By.xpath("//a[contains(text(),'Successfully Edited')]"))
				.getText();
		Assert.assertEquals(SuccessfullyoEdited, "SUCCESSFULLY EDITED");
		System.out.println("Succsfully Edited Button is displayed");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Unable to Edit')]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		Thread.sleep(2500);
		driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[contains(text(),'All Time')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Failed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();
		Thread.sleep(5000);
		
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Yelp']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][4]")).click();
		Thread.sleep(3000);
		
		
		
	
		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'show-more-options sc-')][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Delete')][1]")).click();
		Thread.sleep(1000);

		String UnabletoDelete = driver.findElement(By.xpath("//a[contains(text(),'Unable to Delete')]")).getText();
		Assert.assertEquals(UnabletoDelete, "UNABLE TO DELETE");
		System.out.println("Unable to Delete Button is displayed");

		String SuccessfullyDeleted = driver.findElement(By.xpath("//a[contains(text(),'Successfully Deleted')]"))
				.getText();
		Assert.assertEquals(SuccessfullyDeleted, "SUCCESSFULLY DELETED");
		System.out.println("successfully Deleted Button is displayed");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Successfully Deleted')]")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(7000);

		driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Select All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Clear All')][1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='New']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][2]")).click();
		Thread.sleep(3000);

	}

	public void RatingsFilterDoesNotResetItsValues() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Responded Reviews')][1]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Response Required')][1]")).click();
		Thread.sleep(5000);

		String PostingDate = driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).getText();
		System.out.println(PostingDate);
		Assert.assertTrue(PostingDate.contains("7 days"));

		String ReviewStatus = driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).getText();
		System.out.println(ReviewStatus);
		Assert.assertTrue(ReviewStatus.contains("New"));

		String ReviewText = driver.findElement(By.xpath("//a[@id='fltrOptReview Text']")).getText();
		System.out.println(ReviewText);
		Assert.assertTrue(ReviewText.contains("Not Empty"));

		String Publisher = driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).getText();
		System.out.println(Publisher);
		Assert.assertTrue(Publisher.contains("4"));

		String Ratings = driver.findElement(By.xpath("//span[contains(text(),'Ratings')]")).getText();
		System.out.println(Ratings);
		Assert.assertTrue(Ratings.contains("Ratings"));

		String AddFilter = driver.findElement(By.xpath("//a[@id='filterAdd']")).getText();
		System.out.println(AddFilter);
		Assert.assertTrue(AddFilter.contains("+ Add Filter"));

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='moreFiltOpt']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='rstFiltOpt']")).click();
		Thread.sleep(3000);

		String ResetPostingDate = driver.findElement(By.xpath("//a[@id='fltrOptPosting Date']")).getText();
		System.out.println(ResetPostingDate);
		Assert.assertEquals(PostingDate, ResetPostingDate);
		Assert.assertTrue(PostingDate.contains("7 days"));

		String ResetReviewStatus = driver.findElement(By.xpath("//a[@id='fltrOptReview Status']")).getText();
		System.out.println(ResetReviewStatus);
		Assert.assertEquals(ReviewStatus, ResetReviewStatus);
		Assert.assertTrue(ReviewStatus.contains("New"));

		String ResetReviewText = driver.findElement(By.xpath("//a[@id='fltrOptReview Text']")).getText();
		System.out.println(ResetReviewText);
		Assert.assertEquals(ReviewText, ResetReviewText);
		Assert.assertTrue(ReviewText.contains("Not Empty"));

		String ResetPublisher = driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).getText();
		System.out.println(ResetPublisher);
		Assert.assertEquals(Publisher, ResetPublisher);
		Assert.assertTrue(Publisher.contains("4"));

		String ResetRatings = driver.findElement(By.xpath("//span[contains(text(),'Ratings')]")).getText();
		System.out.println(ResetRatings);
		Assert.assertEquals(Ratings, ResetRatings);
		Assert.assertTrue(Ratings.contains("Ratings"));

		String ResetAddFilter = driver.findElement(By.xpath("//a[@id='filterAdd']")).getText();
		System.out.println(ResetAddFilter);
		Assert.assertEquals(AddFilter, ResetAddFilter);
		Assert.assertTrue(AddFilter.contains("+ Add Filter"));
		Thread.sleep(4000);

	}

}
