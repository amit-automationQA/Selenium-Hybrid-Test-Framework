package com.b1.testcases;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.pages.ReviewVerification;
import com.b1.pages.ReviewsPage;
import com.b1.util.TestUtility;
 

@Listeners(TestListener.class)
public class ReviewVerificationTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ReviewVerification reviewVerification;
	TestUtility testUtil;
	ReviewsPage reviewsPage;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public ReviewVerificationTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws MalformedURLException {

		//initialization();
		BrowserStack_Invocation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reviewVerification = new ReviewVerification();
	}

	@Test(groups = { "sanity", "regression" },priority = 1)
	public void clickOnContextAndSelectCheesecake() throws Exception {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'Cheesecake Factory')]")).getText();
		System.out.println("Location Name : " + LocationName);

	}

	@Test(groups = { "sanity", "regression" },priority = 2)
	public void checkReviewEnable() {

		reviewVerification.selectReviewOnEntitlements();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		boolean checkbox = driver
				.findElement(By.xpath("//input[@id='entitlements-Review']")).isSelected();
															
		System.out.println("Check checkbox value is : " + checkbox);
		if (checkbox == true) {

			System.out.println("Checkbox is already checked  ");

		} 
		else
		{
			
			WebElement ReviewChecked = driver.findElement(By.xpath("//input[@id='entitlements-Review']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript ("arguments[0].click();", ReviewChecked);	
			
			System.out.println("Checkbox is checked");

			driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();

		}
	}

	@Test(groups = { "sanity", "regression" },priority = 3)
	public void clickOnReviews() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * WebElement locator =
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
	@Test(groups = { "sanity", "regression" },priority = 4)
	public void totalCountOnDefault() throws Exception {
		driver.navigate().refresh();
		Thread.sleep(3000);
		String totalCount = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",
				driver.findElement(By.xpath("//div[starts-with(@class,'totalcounttext sc-')]")));
		System.out.println("Total Count on Default : " + totalCount);
	}

	@Test(groups = { "sanity", "regression" },priority = 5)
	public void clickOnPostingDate() throws Exception {
		driver.navigate().refresh();
		reviewVerification.postingDate();

	}
	
	@Test(groups = { "sanity", "regression" },priority = 6)
	public void VerifypreCannFilter() throws Exception {
		Thread.sleep(2000);
		reviewVerification.preCannedFilter();
	}
	
	@Test(groups = { "sanity", "regression" },priority = 7)
	public void VerifyResponseRequired() throws Exception 
	{
		Thread.sleep(5000);
		reviewVerification.ResponseRequired();	
	}
	
	
	/*
	 * @Test(groups = { "sanity", "regression" },priority = 8) public void
	 * VerifySavedReviews() throws Exception { reviewVerification.SavedReviews(); }
	 * 
	 * 
	 * 
	 * 
	 * @Test(groups = { "sanity", "regression" },priority = 9) public void
	 * VerifyWaitingForApproval() throws Exception {
	 * reviewVerification.WaitingForApproval(); }
	 * 
	 * 
	 * 
	 * @Test(groups = { "sanity", "regression" },priority = 10) public void
	 * VerifyApprovalHistory() throws Exception {
	 * reviewVerification.ApprovalHistory(); }
	 */
	 
	  
	  @Test(groups = { "sanity", "regression" },priority = 11) public void
	  VerifyRespondedReviews() throws Exception {
	  reviewVerification.RespondedReviews(); }
	  
	
	/*
	 * @Test(groups = { "sanity", "regression" },priority = 12) public void
	 * VerifyFlaggedReviews() throws Exception {
	 * reviewVerification.FlaggedReviews(); }
	 */
	 
	  @Test(groups = { "sanity", "regression" },priority = 13) public void
	  VerifyAllReviews() throws Exception { reviewVerification.AllReviews(); }
	 
	  @AfterClass(alwaysRun = true)
		public void tearDown() {
			driver.quit();

		}
	}

