 package com.b1.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;

import org.openqa.selenium.support.ui.Select;
 

public class ReviewsPage extends TestBase {

	TestUtility testUtil = new TestUtility();
	HomePage homePage = new HomePage();

	@FindBy(xpath = "//div[@class='sc-kNBZmU jUXjdf']")
	WebElement PageHeader;

	@FindBy(xpath = "//div[@class='filtertext sc-jUiVId dsonYY']")
	WebElement DefaultQue;

	@FindBy(xpath = "//div[@class='totalcounttext sc-kecUPG gZNsQg']")
	WebElement TotalCount;

	@FindBy(xpath = "//*[@id=\"fltrOptPosting Date\"]")
	WebElement PostingDate;
//"//body/div[@class='container']/div[@class='app sc-cmjSyW labWht']/div[@class='sc-drKuOJ fpvyDh']/div/div[@class='review-main sc-dFAFAY jNWNao']/div[@class='review-bql sc-XAwzD bSZBcg']/div[@class='filtercomponent sc-gOCRIc csNmm']/div[@class='sc-gHpXsY dwHuaj']/nav[@id='filternav']/div[@id='navcontainer']/li[1]")
	
	
	@FindBy (id="//a[contains(text(),'Custom')]")
	WebElement custom;
	
	@FindBy (id="calendarfrom")
	WebElement fromDate;
	
	@FindBy (id="calendarto")
	WebElement toDate;
	
	@FindBy(xpath = "//li[@class='calendaractionitem sc-bECiaU dxHYfu']//a[contains(text(),'All Time')]")
	WebElement AllTimeFilter;

	@FindBy(xpath = "//div[@class='sc-hPZeXZ chNvWh']//a[@class='dropdownapplyaction sc-eylKsO kxiDLk'][contains(text(),'Apply')]")
	WebElement ApplyButton;

	@FindBy(xpath = "//div[contains(text(),'REVIEWS')]")
	WebElement Reviews;

	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile; 

	@FindBy(xpath = "//div[contains(text(),'Accounts')]") 
	WebElement Account;

	@FindBy(xpath = "//div[contains(text(),'Entitlements')]")
	WebElement Entitlements;

	//@FindBy(xpath = "//a[@id='moreFiltOpt']")
	//WebElement filterOptions;

	@FindBy(css = "#moreFiltOpt")
	WebElement filterOptions;
	
	//@FindBy(xpath = "//a[@id='saveFiltOpt']")
	//WebElement saveAsNewFilter;
	
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

	public ReviewsPage() {

		PageFactory.initElements(driver, this);

	}

	public void selectReviewOnEntitlements() {

		TestUtility.clickOn(driver, MyProfile, 30);
		TestUtility.clickOn(driver, Account, 30);
		TestUtility.clickOn(driver, Entitlements, 30);

	}

	public void selectReviews() throws InterruptedException {
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

	public void selectCheesecake() throws Exception {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'Cheesecake Factory')]")).getText();
		System.out.println("Location Name : " + LocationName);

	}


	public void saveFilter() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", filterOptions);
	//	filterOptions.click();
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click();", saveAsNewFilter);
	//	TestUtility.clickOn(driver, saveAsNewFilter, 30);
		filterName.sendKeys("Test123");
		TestUtility.clickOn(driver, submitBtn, 30);

	}

	public static void selectGoogleSource() throws Exception {
		Thread.sleep(2000);

		WebElement sourceProvider = driver.findElement(By.xpath("//a[@id='fltrOptSource']"));
		TestUtility.clickOn(driver, sourceProvider, 30);

		WebElement clearAll = driver.findElement(By.xpath("//a[contains(text(),'Clear All')]"));
		TestUtility.clickOn(driver, clearAll, 30);

		driver.findElement(By.xpath("//label[contains(text(),'Google')]")).click();

		WebElement applyBtn = driver.findElement(By.xpath(
				"//div[@class='fixed-max sc-hPZeXZ chNvWh']//a[@class='dropdownapplyaction sc-eylKsO kxiDLk'][contains(text(),'Apply')]"));
		TestUtility.clickOn(driver, applyBtn, 30);

	}

	public void verifyFilter() {
		TestUtility.clickOn(driver, filterIcon, 30);

	}
	
	public void postingDate() throws Exception {
		
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement PostingDate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='fltrOptPosting Date']//span[contains(text(),'Posting Date')]"))); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", PostingDate);
		Thread.sleep(2000);
		WebDriverWait wait1=new WebDriverWait(driver,30);
		WebElement AllTimeFilter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[starts-with(@class,'calendaractionitem sc-')]//a[contains(text(),'All Time')]")));
		//li[starts-with(@class,'calendaractionitem sc-')]//a[contains(text(),'30 days')]
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", AllTimeFilter);
		Thread.sleep(3000);
		WebDriverWait wait2=new WebDriverWait(driver,20);
		WebElement ApplyButton=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][1]")));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;							//div[starts-with(@class,'dropdownwrapperactions sc-')]//a[starts-with(@class,'dropdownapplyaction sc-') and contains(text(),'Apply')]  
		js2.executeScript("arguments[0].click();", ApplyButton);
		
	}
	
	public void exportData() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", filterOptions);
		Thread.sleep(1000);
		js1.executeScript("arguments[0].click();", exportReviewData);
		
	}
		public void RespondersOptions() throws Exception
		{
			driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]")).click();
			Thread.sleep(3000);
			WebElement ResponseRequired = driver.findElement(By.xpath("//div[starts-with(@class,'filterlistitem sc-')][contains(text(),'Response Required')]"));
			ResponseRequired.click();
			postingDate();
			Thread.sleep(3000);
			driver.navigate().refresh();
			boolean Option = driver.findElement(By.xpath("//article[1]//div[1]//div[1]//div[3]//div[1]//button[1]")).isDisplayed();
			Assert.assertTrue(Option);
			Thread.sleep(3000);
			RespondBTN.click();
			//driver.findElement(By.xpath("//div[contains(@role,'presentation')]")).getText();
			List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@role,'presentation')]"));
			System.out.println("Number of elements:" + elements.size());

			for (int i = 0; i < elements.size(); i++) {
				System.out.println("Responders Option List : " + elements.get(i).getText());
			}
		}

		public void VerifyRespondersOptionFlagReviews() throws InterruptedException {
			
			String Flag = driver.findElement(By.xpath("//div[contains(text(),'Flag Review')]")).getText();
			Assert.assertEquals(Flag, "Flag Review");
			Thread.sleep(2000);
			WebElement Flags = driver.findElement(By.xpath("//div[contains(text(),'Flag Review')]"));
			Assert.assertTrue(Flags.isEnabled());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'Flag Review')]")).click();
			Thread.sleep(2000);
			WebElement Reviews = driver.findElement(By.xpath("//div[starts-with(@class,'tile-srrtextcontainer sc-')]"));
			Assert.assertTrue(Reviews.isDisplayed());
			
			//driver.findElement(By.xpath("//p[contains(text(),'schultzie1963')]")).click();
			
			//WebElement ReviewFlags = driver.findElement(By.xpath("//div[contains(text(),'Flag Review')]"));
			//Assert.assertTrue(ReviewFlags.isEnabled());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();	
		}
		
		public void VerifyGoToReviewSite() throws InterruptedException {
			Thread.sleep(2000);
			RespondBTN.click();
			
			String ReviewSite = driver.findElement(By.xpath("//div[contains(text(),'Go to Review Site')]")).getText();
			Assert.assertEquals(ReviewSite, "Go to Review Site");
			
			WebElement ReviewSites = driver.findElement(By.xpath("//div[contains(text(),'Go to Review Site')]"));
			Assert.assertTrue(ReviewSites.isEnabled());
			
			driver.findElement(By.xpath("//div[contains(text(),'Go to Review Site')]")).click();
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    Thread.sleep(2000);
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
				
		}
		public void VerifyReviewHistory() throws InterruptedException {
			
			Thread.sleep(2000);
			//RespondBTN.click();
			
			String ReviewHistory = driver.findElement(By.xpath("//div[contains(text(),'Review History')]")).getText();
			Assert.assertEquals(ReviewHistory, "Review History");
			
			WebElement ReviewHistorys = driver.findElement(By.xpath("//div[contains(text(),'Review History')]"));
			Assert.assertTrue(ReviewHistorys.isEnabled());
			
			driver.findElement(By.xpath("//div[contains(text(),'Review History')]")).click();
			
			String History = driver.findElement(By.xpath("//h3[contains(text(),'Review History')]")).getText();
			Assert.assertTrue(History.contains("Review History"));
			
			
			String response = driver.findElement(By.xpath("//h4[contains(text(),'# responses')]")).getText();
			Assert.assertEquals(response, "# responses");
			
			driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
		}
		
		public void VerifyShareReview() throws InterruptedException {
			
			Thread.sleep(2000);
			//RespondBTN.click();
			
			String ReviewHistory = driver.findElement(By.xpath("//div[contains(text(),'Share Review')]")).getText();
			Assert.assertEquals(ReviewHistory, "Share Review");
			
			WebElement ReviewHistorys = driver.findElement(By.xpath("//div[contains(text(),'Share Review')]"));
			Assert.assertTrue(ReviewHistorys.isEnabled());
			
			driver.findElement(By.xpath("//div[contains(text(),'Share Review')]")).click();
			
					
			String History = driver.findElement(By.xpath("//h3[contains(text(),'Share Review')]")).getText();
			Assert.assertTrue(History.contains("Share Review"));
			
			
			driver.findElement(By.xpath("//span[contains(text(),'Cancel')]")).click();
			
			
		}

	
}
	

