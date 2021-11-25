package com.b1.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;

 
public class ReviewVerification extends TestBase {
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
	
	@FindBy(xpath = "//div[contains(@class,'review-main sc-')]//div[1]//div[1]//div[2]//div[3]//div[2]//a[1]//i[1]")
	WebElement RespondBTN;

	public ReviewVerification() {

		PageFactory.initElements(driver, this);

	}

	public void selectReviewOnEntitlements() 
	{

		TestUtility.clickOn(driver, MyProfile, 30);
		TestUtility.clickOn(driver, Account, 30);
		TestUtility.clickOn(driver, Entitlements, 30);
	}
	
	public void selectReviews() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement locator = driver.findElement(By.xpath("//div[contains(text(),'REVIEWS')]"));
		new WebDriverWait(driver, 60).ignoring(NoSuchSessionException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}

	public void selectCheesecake() throws Exception {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectCheesecake();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'cheesecake')]")).getText();
		System.out.println("Location Name : " + LocationName);

	}
	public void postingDate() throws Exception {
		
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement PostingDate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='fltrOptPosting Date']//span[contains(text(),'Posting Date')]"))); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", PostingDate);
		
		WebDriverWait wait1=new WebDriverWait(driver,50);
		WebElement AllTimeFilter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[starts-with(@class,'calendaractionitem sc-')]//a[contains(text(),'All Time')]")));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", AllTimeFilter);
	
		WebDriverWait wait2=new WebDriverWait(driver,30);
		WebElement ApplyButton=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][1]")));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;							//div[starts-with(@class,'dropdownwrapperactions sc-')]//a[starts-with(@class,'dropdownapplyaction sc-') and contains(text(),'Apply')]  
		js2.executeScript("arguments[0].click();", ApplyButton);	
	}
	
	public void preCannedFilter() throws Exception 
	{
		driver.navigate().refresh();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(3000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='sc-dymIpo jbVzNs']//child::div[starts-with(@class,'dropdown-content sc')]"));
		System.out.println("\nNumber of elements:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Review preCannedFilter List :\n" + elements.get(i).getText()+"\n\n");
		}
		//driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		Thread.sleep(2000);
	}
	
	public void ReviewOptions() throws Exception
	{
		
		boolean Option = driver.findElement(By.xpath("//div[contains(@class,'show-more-options sc-')]//i[contains(@class,'material-icons  sc-')][contains(text(),'more_vert')]")).isDisplayed();
		Assert.assertTrue(Option);
		//RespondBTN.click();
		Thread.sleep(3000);	
		postingDate();
		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'popover-content sc-kEYyzF fJEHpl')]//div[contains(@class,'dropdown-content sc-CtfFt bphjLy')]"));
		System.out.println("Number of elements:" + elements.size());

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Responders Option List :\n" + elements.get(i).getText()+"\n\n");
		}
		Thread.sleep(3000);	
	}
	
	
	public void OptionFlagReviews() {
		
		String Flag = driver.findElement(By.xpath("//div[contains(text(),'Flag Review')]")).getText();
		Assert.assertEquals(Flag, "Flag Review");
		
		WebElement Flags = driver.findElement(By.xpath("//div[contains(text(),'Flag Review')]"));
		Assert.assertTrue(Flags.isEnabled());
		
		driver.findElement(By.xpath("//div[contains(text(),'Flag Review')]")).click();
		
		WebElement ReviewsTextArea = driver.findElement(By.xpath("//textarea[@placeholder='Enter your reason for flagging...']"));
		Assert.assertTrue(ReviewsTextArea.isDisplayed());
		
		WebElement ReviewFlags = driver.findElement(By.xpath("//span[contains(text(),'Flag Review')]"));
		Assert.assertTrue(ReviewFlags.isEnabled());
		
		WebElement Cancel= driver.findElement(By.xpath("//div[contains(@class,'btngray sc-')]//button"));	
		Assert.assertTrue(Cancel.isEnabled());
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript ("arguments[0].click();", Cancel);
	}
	
	public void ResponseRequired() throws Exception
	{
		Thread.sleep(3000);	
		//driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		WebElement ResponseRequired = driver.findElement(By.xpath("//div[starts-with(@class,'dropdown-content sc-')]//div[contains(text(),'Response Required')]"));
		ResponseRequired.click();
		Thread.sleep(3000);	
		postingDate();
		Thread.sleep(3000);	
		ReviewOptions();
		Thread.sleep(3000);	
		//OptionFlagReviews();
	}
	
	public void SavedReviews() throws Exception
	{
		driver.navigate().refresh();
		driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]")).click();
		WebElement SavedReviews = driver.findElement(By.xpath("//div[starts-with(@class,'filterlistitem sc-')][contains(text(),'Saved Reviews')]"));
		SavedReviews.click();
		Thread.sleep(3000);
		postingDate();
		ReviewOptions();
		Thread.sleep(2000);	
		OptionFlagReviews();
		
	}
	
	public void WaitingForApproval() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]")).click();
		WebElement WaitingForApproval = driver.findElement(By.xpath("//div[starts-with(@class,'filterlistitem sc-')][contains(text(),'Waiting For Approval')]"));
		WaitingForApproval.click();
		Thread.sleep(3000);
		postingDate();
		Thread.sleep(3000);
		ReviewOptions();
		Thread.sleep(2000);	
		OptionFlagReviews();
	}
	public void ApprovalHistory() throws Exception
	{
		driver.navigate().refresh();
		driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]")).click();
		WebElement ApprovalHistory = driver.findElement(By.xpath("//div[starts-with(@class,'filterlistitem sc-')][contains(text(),'Approval History')]"));
		ApprovalHistory.click();
		Thread.sleep(3000);
		ReviewOptions();
		Thread.sleep(2000);	
		OptionFlagReviews();
	}
	public void RespondedReviews() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		WebElement RespondedReviews = driver.findElement(By.xpath("//div[starts-with(@class,'dropdown-content sc-')]//div[contains(text(),'Responded Reviews')]"));
		Thread.sleep(2000);
		RespondedReviews.click();
		Thread.sleep(2000);
		postingDate();
		ReviewOptions();
		Thread.sleep(2000);	
		//OptionFlagReviews();
	}
	public void FlaggedReviews() throws Exception
	{
		driver.findElement(By.xpath("//i[starts-with(@class,'material-icons sc-')]")).click();
		WebElement FlaggedReviews = driver.findElement(By.xpath("//div[starts-with(@class,'filterlistitem sc-')][contains(text(),'Flagged Reviews')]"));
		FlaggedReviews.click();
		Thread.sleep(2000);
		postingDate();
		Thread.sleep(2000);	
		ReviewOptions();
		Thread.sleep(2000);	
		OptionFlagReviews();
	}
	public void AllReviews() throws Exception
	{
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Reviews Feed:')]")).click();
		WebElement AllReviews = driver.findElement(By.xpath("//div[starts-with(@class,'dropdown-content sc-')]//div[contains(text(),'All Reviews')]"));
		AllReviews.click();
		Thread.sleep(2000);
		ReviewOptions();
		Thread.sleep(2000);	
		//OptionFlagReviews();
		
	}
	
}