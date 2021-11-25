package com.b1.pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;
 

public class ReviewReports extends TestBase {

		TestUtility testUtil = new TestUtility();
		HomePage homePage = new HomePage();

		@FindBy(xpath = "//button[contains(text(),'Report')]")
		WebElement ReviewBtn;

		public void clickOnReviews() throws InterruptedException {
			driver.navigate().refresh();
			
		/*
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); WebElement
		 * locator = driver.findElement(By.xpath("//div[contains(text(),'REVIEWS')]"));
		 * new WebDriverWait(driver, 60).ignoring(NoSuchSessionException.class)
		 * .until(ExpectedConditions.elementToBeClickable(locator)); locator.click();
		 * Thread.sleep(3000);
		 */
		/*
		 * driver.navigate().refresh(); Thread.sleep(4000);
		 */
			Thread.sleep(5000);
			WebElement Reviews = driver.findElement(By.xpath("//div[contains(text(),'REVIEWS')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(Reviews);
			actions.click().build().perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/descendant::div[contains(text(),'Reviews Feed')][1]")).click();

		}
		
		public void postingDate() throws Exception {
			
			Thread.sleep(5000);
			WebDriverWait wait=new WebDriverWait(driver,20);
			WebElement PostingDate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='fltrOptPosting Date']//span[contains(text(),'Posting Date')]"))); 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", PostingDate);
			Thread.sleep(2000);
			WebDriverWait wait1=new WebDriverWait(driver,30);
			WebElement AllTimeFilter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[starts-with(@class,'calendaractionitem sc-')]//a[contains(text(),'All Time')]")));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", AllTimeFilter);
			Thread.sleep(2000);
			WebDriverWait wait2=new WebDriverWait(driver,20);
			WebElement ApplyButton=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][1]")));
			JavascriptExecutor js2 = (JavascriptExecutor) driver;							//div[starts-with(@class,'dropdownwrapperactions sc-')]//a[starts-with(@class,'dropdownapplyaction sc-') and contains(text(),'Apply')]  
			js2.executeScript("arguments[0].click();", ApplyButton);
			
		}
		
		public void ClickOnReviewReport() throws InterruptedException {
			//driver.navigate().refresh();
			Thread.sleep(3500);
			//driver.findElement(By.xpath("//i[contains(text(),'assignment_returned')]")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Assignment = driver.findElement(By.xpath("//i[contains(text(),'assignment_returned')]"));
			js.executeScript("arguments[0].click();", Assignment);
		}

		

		public void VerifyReviewReportOptions() throws InterruptedException {
            Thread.sleep(3000);
			String Report = driver.findElement(By.xpath("//h3[contains(text(),'Report')]")).getText();
			Assert.assertEquals(Report, "Report");

			String FirstName = driver.findElement(By.xpath("//td[contains(text(),'First Name')]")).getText();
			Assert.assertEquals(FirstName, "First Name");

			String LastName = driver.findElement(By.xpath("//td[contains(text(),'Last Name')]")).getText();
			Assert.assertEquals(LastName, "Last Name");

			String StrtDate = driver.findElement(By.xpath("//td[contains(text(),'Start Date')]")).getText();
			Assert.assertEquals(StrtDate, "Start Date");

			String EndDate = driver.findElement(By.xpath("//td[contains(text(),'End Date')]")).getText();
			Assert.assertEquals(EndDate, "End Date");

			String Email = driver.findElement(By.xpath("//td[contains(text(),'Email')]")).getText();
			Assert.assertEquals(Email, "Email");

			String Engine = driver.findElement(By.xpath("//td[contains(text(),'Engines')]")).getText();
			Assert.assertEquals(Engine, "Engines");

			String Google = driver.findElement(By.xpath("/descendant::label[contains(text(),'Google')][2]")).getText();
			Assert.assertEquals(Google, "Google");

			String Facebook = driver.findElement(By.xpath("/descendant::label[contains(text(),'Facebook')][2]")).getText();
			Assert.assertEquals(Facebook, "Facebook");

			String Yelp = driver.findElement(By.xpath("/descendant::label[contains(text(),'Yelp')][2]")).getText();
			Assert.assertEquals(Yelp, "Yelp");

			String Tripadvisor = driver.findElement(By.xpath("//label[contains(text(),'Trip Advisor')]")).getText();
			Assert.assertEquals(Tripadvisor, "Trip Advisor");

			/*
			 * String cancel =
			 * driver.findElement(By.xpath("//div[@class='editor-gadgets']//button[1]")).
			 * getAttribute("Text"); //Assert.assertEquals(cancel, "Cancel");
			 * System.out.println("Button name is:" +cancel);
			 */

			WebElement Cancel = driver.findElement(By.xpath("//span[contains(text(),'Cancel')]"));
			Assert.assertTrue(Cancel.isEnabled());

			/*
			 * Thread.sleep(2000); String Create1 =
			 * driver.findElement(By.xpath("//span[contains(text(),'Create')]")).getText();
			 * Assert.assertEquals(Create1, "CREATE");
			 */

			WebElement Create = driver.findElement(By.xpath("//span[contains(text(),'Create')]"));
			Assert.assertTrue(Create.isEnabled());
		}

		public void VerifyBlankDataErrorMsg() throws InterruptedException {
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
			Thread.sleep(2000);
			String FrstName = driver.findElement(By.xpath("/descendant::div[contains(text(),'Required')][4]")).getText();
			Assert.assertEquals(FrstName, "Required");
			System.out.println("Enter The First Name=====>>>>");

			String LstName = driver.findElement(By.xpath("/descendant::div[contains(text(),'Required')][4]")).getText();
			Assert.assertEquals(LstName, "Required");
			System.out.println("Enter The Last Name=====>>>>");

			String Email = driver.findElement(By.xpath("/descendant::div[contains(text(),'Required')][6]")).getText();
			Assert.assertEquals(Email, "Required");
			System.out.println("Enter The Email=====>>>>");

		}

		public void EnterReviewReportData() throws InterruptedException {

			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sachin");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Nair");
			Thread.sleep(1500);

			driver.findElement(By.xpath("//input[starts-with(@id,'undefined-StartDate-')]")).click();
			Thread.sleep(1000);

			WebElement clickback = driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/div/div/button[1]"));
			clickback.click();

			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement clickDate = driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'10')]"));
			js.executeScript("arguments[0].click();", clickDate);

			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[starts-with(@id,'undefined-EndDate-undefined-')]")).click();
			Thread.sleep(1000);

			JavascriptExecutor jk = (JavascriptExecutor) driver;
			WebElement clickOnDate = driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'10')]"));
			jk.executeScript("arguments[0].click();", clickOnDate);

			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sachin@testriq.com");
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div[@class='editor-gadgets']//li[1]")).click();
			driver.findElement(By.xpath("//div[@class='editor-gadgets']//li[2]")).click();
			driver.findElement(By.xpath("//div[@class='editor-gadgets']//li[3]")).click();
			driver.findElement(By.xpath("//div[@class='editor-gadgets']//li[4]")).click();
			Thread.sleep(1500);

		}

		public void VerifyEnteredReviewReportData() throws InterruptedException {

			WebElement google = driver.findElement(By.xpath("//div[@class='editor-gadgets']//li[1]//div/div/div/div[3]"));
			Assert.assertTrue(google.isEnabled());

			WebElement Facebook = driver.findElement(By.xpath("//div[@class='editor-gadgets']//li[2]//div/div/div/div[3]"));
			Assert.assertTrue(Facebook.isEnabled());

			WebElement Yelp = driver.findElement(By.xpath("//div[@class='editor-gadgets']//li[3]//div/div/div/div[3]"));
			Assert.assertTrue(Yelp.isEnabled());

			WebElement TripAdvisor = driver
					.findElement(By.xpath("//div[@class='editor-gadgets']//li[4]//div/div/div/div[3]"));
			Assert.assertTrue(TripAdvisor.isEnabled());

			Thread.sleep(2000);
			JavascriptExecutor jk = (JavascriptExecutor) driver;
			WebElement clickOnDate = driver.findElement(By.xpath("//span[contains(text(),'Create')]"));
			jk.executeScript("arguments[0].click();", clickOnDate);
			Thread.sleep(4000);
				}


}
