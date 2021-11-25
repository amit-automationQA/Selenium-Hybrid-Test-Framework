package com.b1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;


public class CleansingPage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'Data Cleansing')]")
	WebElement header;

	@FindBy(xpath = "//a[@id='fltrOptIssue Types']")
	WebElement issueTypes;
		
	public CleansingPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnLocationCleansing() throws Exception {

		Thread.sleep(4000);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(location);
		actions.click().build().perform();
		Thread.sleep(2000);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement health =
		 * driver.findElement(By.xpath("//div[contains(text(),'Cleansing')]"));
		 * js.executeScript("arguments[0].click();", health);
		 */
		driver.findElement(By.xpath("//div[contains(text(),'Cleansing')]")).click();

	}

	public void checkHeader() {
		String HeaderTitleName = driver.findElement(By.xpath("//div[contains(text(),'Data Cleansing')]")).getText();
		System.out.println("TItle name is ==> " + HeaderTitleName);
		Assert.assertEquals("Data Cleansing", HeaderTitleName);
	}

	public void ListOfIssueTypesFilter() throws Exception {

		String IssueTypesName = driver
				.findElement(By.xpath("//a[@id='fltrOptIssue Types']")).getText();
		System.out.println("IssueTypes Name is " + IssueTypesName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptIssue Types']")).click();
		Thread.sleep(2000);

		List<WebElement> elements = driver.findElements(By.xpath("//ul[starts-with(@class,'fixed-height sc-')]"));
		System.out.println("Number of IssueTypes:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("IssueTypes List : " + elements.get(i).getText());
		}
	
	}
	
	public void ListOfIssueDateFilter() throws Exception {

		String ListOfIssueDateFilter = driver
				.findElement(By.xpath("//a[@id='fltrOptIssue Date']")).getText();
		System.out.println("IssueTypes Name is " + ListOfIssueDateFilter);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptIssue Date']")).click();
		Thread.sleep(2000);

		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='calendartop']"));
		System.out.println("Number of IssueTypes:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("IssueTypes List : " + elements.get(i).getText());
		}
		
	}
		public void IssueDateSelection() throws Exception {
			
			Thread.sleep(5000);
		/*
		 * WebDriverWait wait=new WebDriverWait(driver,30); WebElement
		 * PostingDate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//a[@id='fltrOptIssue Date']//span[contains(text(),'Issue Date')]")));
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", PostingDate);
		 */
			//Thread.sleep(2000);
			WebDriverWait wait1=new WebDriverWait(driver,30);
			WebElement AllTimeFilter=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[starts-with(@class,'calendaractionitem sc-')]//a[contains(text(),'All Time')]")));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", AllTimeFilter);
			Thread.sleep(2000);
			WebDriverWait wait2=new WebDriverWait(driver,20);
			WebElement ApplyButton= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][2]")));
			JavascriptExecutor js2 = (JavascriptExecutor) driver;							//div[starts-with(@class,'dropdownwrapperactions sc-')]//a[starts-with(@class,'dropdownapplyaction sc-') and contains(text(),'Apply')]  
			js2.executeScript("arguments[0].click();", ApplyButton);
			
		}
		
		
	
	
	public void checkIssues() {
		String Issues = driver.findElement(By.xpath("//div[contains(text(),'ISSUES')]")).getAttribute("innerText");
		Assert.assertTrue(Issues.contains("ISSUES"));
		System.out.println("ISSUES is present ==> " + Issues);

	}
	
	public void checkIssuesTypes() {
		String IssuesTypes = driver.findElement(By.xpath("//div[contains(text(),'ISSUE TYPES')]")).getAttribute("innerText");
		Assert.assertTrue(IssuesTypes.contains("ISSUE TYPES"));
		System.out.println("IssuesTypes is present ==> " + IssuesTypes);

	}
	
	public void checkLocation() {
		String Location = driver.findElement(By.xpath("//div[contains(@class,'subheader')][contains(text(),'LOCATIONS')]")).getAttribute("innerText");
		Assert.assertTrue(Location.contains("LOCATIONS"));
		System.out.println("Location is present ==> " + Location);

	}
	
	public void checkAvgLenth() {
		String AvgLenth = driver.findElement(By.xpath("//div[contains(text(),'AVG LENGTH SINCE REPORT')]")).getAttribute("innerText");
		Assert.assertTrue(AvgLenth.contains("AVG LENGTH SINCE REPORT"));
		System.out.println("AvgLenth is present ==> " + AvgLenth);

	}
	
	public void HeaderofTable() {

		WebElement webtable = driver.findElement(By.xpath("html/body"));
		List<WebElement> header = webtable.findElements(By.tagName("th"));

		System.out.println("Number of headings:" + header.size());

		for (int i = 0; i < header.size(); i++) {
			System.out.println("Header List : " + header.get(i).getText());
		}
	
}
	
	public void HandleTableRows() throws InterruptedException {
		
		WebElement webtable = driver.findElement(By.xpath("html/body"));
		List<WebElement> rows = webtable.findElements(By.tagName("tr"));
		Thread.sleep(2000);
		System.out.println("Number of Rows including headings:" + rows.size());
		Thread.sleep(2000);
		String recordName = driver.findElement(By.xpath("//td[contains(text(),\"The Cheesecake Factory\")]")).getText(); 
		Assert.assertTrue(recordName.contains("The Cheesecake Factory"));
		System.out.println("The Cheesecake Factory is present ==> " + recordName);
		Thread.sleep(2000);
		
		/*
		 * for (int i = 0; i < rows.size(); i++) {
		 * System.out.println("Records List : \n" + rows.get(i).getText()+"\n"); }
		 */

	}
	
	
	
	
}
