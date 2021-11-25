package com.b1.pages;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.testautomationguru.utility.PDFUtil;

public class HealthPage extends TestBase {

	public HealthPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnLocationHealth() throws Exception {

		Thread.sleep(2000);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(location);
		actions.click().build().perform();
		Thread.sleep(2000);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement health =
		 * driver.findElement(By.xpath("//div[contains(text(),'Health')]"));
		 * js.executeScript("arguments[0].click();", health);
		 */
		driver.findElement(By.xpath("//div[contains(text(),'Health')]")).click();

	}

	public void HandleTableRows() {

		WebElement webtable = driver.findElement(By.xpath("html/body"));
		List<WebElement> rows = webtable.findElements(By.tagName("tr"));

		System.out.println("Number of Rows including headings:" + rows.size());

		for (int i = 0; i < rows.size(); i++) {
			System.out.println("Review Records List : " + rows.get(i).getText());
		}

	}

	public void HandleTableColumns() {

		WebElement webtable = driver.findElement(By.xpath("html/body"));
		List<WebElement> columns = webtable.findElements(By.tagName("td"));

		System.out.println("Number of Rows including headings:" + columns.size());

		for (int i = 0; i < columns.size(); i++) {
			System.out.println("Review Records List : " + columns.get(i).getText());
		}

	}

	public void HandleTableHeader() {

		WebElement webtable = driver.findElement(By.xpath("html/body"));
		List<WebElement> header = webtable.findElements(By.tagName("th"));

		System.out.println("Number of Rows including headings:" + header.size());

		for (int i = 0; i < header.size(); i++) {
			System.out.println("Review Records List : " + header.get(i).getText());
		}

	}

	public void clickOnrecord() {

		driver.findElement(By.xpath("//*/table/tbody/tr[2]/td[4]/div")).click();
		String publisherName = driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).getText();
		System.out.println("Clicked on FB Publisher record " + publisherName);

	}

	public void ListOfIssueTypesFilter() throws Exception {

		String IssueTypesName = driver
				.findElement(By.xpath("//a[starts-with(@class,'bqltoggle fltr-opt-issue types sc-')]")).getText();
		System.out.println("IssueTypes Name is " + IssueTypesName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[starts-with(@class,'bqltoggle fltr-opt-issue types sc-')]")).click();
		Thread.sleep(2000);

		List<WebElement> elements = driver.findElements(By.xpath("//ul[starts-with(@class,'fixed-height sc-')]"));
		System.out.println("Number of IssueTypes:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("IssueTypes List : " + elements.get(i).getText());
		}

		boolean checkbox = driver.findElement(By.xpath("//input[@id='NameMismatch']")).isSelected();

		System.out.println("Check checkbox status of NameMismatch : " + checkbox);

	}

	public void checkPublisher() throws Exception {

		String publisher = driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).getText();
		System.out.println("IssueTypes Name is " + publisher);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptPublisher']")).click();
		Thread.sleep(2000);

		List<WebElement> elements = driver
				.findElements(By.xpath("/descendant::div[starts-with(@class,'fixed-max sc-')][2]"));
		System.out.println("Number of publisher:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("publisher List : " + elements.get(i).getText());
		}

		boolean checkbox = driver.findElement(By.xpath("//input[@id='Facebook']")).isSelected();

		System.out.println("Check checkbox status of FB : " + checkbox);

	}

	public void checkAddNormalization() throws Exception {

		String AddNormalization = driver.findElement(By.xpath("//a[@id='fltrOptAddress Normalization']")).getText();
		System.out.println("IssueTypes Name is " + AddNormalization);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptAddress Normalization']")).click();
		Thread.sleep(2000);

		List<WebElement> elements = driver
				.findElements(By.xpath("/descendant::div[starts-with(@class,'fixed-max sc-')][3]"));
		System.out.println("Number of AddNormalization:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("AddNormalization List : " + elements.get(i).getText());
		}

		boolean checkbox = driver.findElement(By.xpath("//input[@id='Disabled']")).isSelected();

		System.out.println("Check checkbox status of Disabled : " + checkbox);

	}

	public void checkStatus() throws Exception {

		String Status = driver.findElement(By.xpath("//a[@id='fltrOptStatus']")).getText();
		System.out.println("IssueTypes Name is " + Status);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fltrOptStatus']")).click();
		Thread.sleep(2000);

		List<WebElement> elements = driver
				.findElements(By.xpath("/descendant::div[starts-with(@class,'fixed-max sc-')][4]"));
		System.out.println("Number of Status:" + elements.size());
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Status List : " + elements.get(i).getText());
		}

	}

	public void checkIssues(){

		String Issues = driver.findElement(By.xpath("//div[contains(text(),'ISSUES')]")).getText();
		Assert.assertEquals("ISSUES", Issues);
		System.out.println("Issues Title is present ==> " + Issues);
		String IssuesCount = driver
				.findElement(By.xpath("//a[1]//span[1]")).getText();
		System.out.println("Issues Count is  ==> " + IssuesCount);

	}
	
	public void checkIssuesTypes(){

		String IssuesTypes = driver.findElement(By.xpath("//div[contains(text(),'ISSUE TYPES')]")).getText();
		Assert.assertEquals("ISSUE TYPES", IssuesTypes);
		System.out.println("Issues Types Title is present ==> " + IssuesTypes);
		String IssuesCount = driver
				.findElement(By.xpath("//a[2]//span[1]")).getText();
		System.out.println("Issues Types Count is  ==> " + IssuesCount);

	}
	
	public void checkLocation() {

		String Location = driver.findElement(By.xpath("//div[contains(@class,'subheader')][contains(text(),'LOCATIONS')]")).getText();
		Assert.assertEquals("LOCATIONS", Location);
		System.out.println("Location Title is present ==> " + Location);
		String LocationCount = driver
				.findElement(By.xpath("//a[3]//span[1]")).getText();
		System.out.println("Location Count is  ==> " + LocationCount);

	}
	
	public void checkPending() {

		String Pending = driver.findElement(By.xpath("//div[contains(text(),'PENDING')]")).getText();
		Assert.assertEquals("PENDING", Pending);
		System.out.println("Location Title is present ==> " + Pending);
		String PendingCount = driver
				.findElement(By.xpath("//a[4]//span[1]")).getText();
		System.out.println("Location Count is  ==> " + PendingCount);

	}
	
	
	public void checkPublishers() {

		String Publishers = driver.findElement(By.xpath("//div[contains(text(),'PUBLISHERS')]")).getText();
		Assert.assertEquals("PUBLISHERS", Publishers);
		System.out.println("Publishers Title is present ==> " + Publishers);
		String PublishersCount = driver
				.findElement(By.xpath("//a[5]//span[1]")).getText();
		System.out.println("Publishers Count is  ==> " + PublishersCount);

	}
	
	
	public void TableRows() {
		
		WebElement webtable = driver.findElement(By.xpath("html/body"));
		List<WebElement> rows = webtable.findElements(By.tagName("tr"));

		System.out.println("Number of Rows including headings:" + rows.size());

		for (int i = 0; i < rows.size(); i++) {
			System.out.println("Review Records List : " + rows.get(i).getText());
		}
	}
	
	
	public void TableColumns() {

		WebElement webtable = driver.findElement(By.xpath("html/body"));
		List<WebElement> columns = webtable.findElements(By.tagName("td"));

		System.out.println("Number of columns including headings:" + columns.size());

		for (int i = 0; i < columns.size(); i++) {
			System.out.println("Review Records List : " + columns.get(i).getText());
		}

	}

	public void TableHeader() {

		WebElement webtable = driver.findElement(By.xpath("html/body"));
		List<WebElement> header = webtable.findElements(By.tagName("th"));

		System.out.println("Number of header including headings:" + header.size());

		for (int i = 0; i < header.size(); i++) {
			System.out.println("Review Records List : " + header.get(i).getText());
		}

	}

	public void exportDataSetup() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='moreFiltOpt']")));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='exportFiltOpt']")));
				
		}
	
	public void exportReviewData() throws Exception {
		Thread.sleep(2000);
		String totalCount = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",
				driver.findElement(By.xpath("//div[starts-with(@class,'exportheader sc-')]")));
		System.out.println("Total Count for Export Review Data : " + totalCount);
		driver.findElement(By.xpath("//span[contains(text(),'Export')]")).click();

	}

	
	public void readExportCSVData() throws Exception {

		Thread.sleep(15000);
		//Reader reader = Files.newBufferedReader(Paths.get("/var/lib/jenkins/workspace/B1AutomationTest/health_export.csv"));
		Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Pramod\\Downloads\\health_export.csv"));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

		for (CSVRecord csvRecord : csvParser) {

			String ClientKey = csvRecord.get(0);
			String Publisher = csvRecord.get(1);
			String IssueType = csvRecord.get(2);
			String PublisherValue = csvRecord.get(3);
			String StoredName = csvRecord.get(4);
			String StoredAddress1 = csvRecord.get(5);
			String StoredAddress2 = csvRecord.get(6);
			String StoredCity = csvRecord.get(7);
			String StoredState = csvRecord.get(8);
			String StoredCountry = csvRecord.get(9);
			String StoredPostalCode = csvRecord.get(10);
			String lng = csvRecord.get(11);
			String lat = csvRecord.get(12);
			String StoredPhoneNumber = csvRecord.get(13);
			String StoredHours = csvRecord.get(14);
			String StoredWebsite = csvRecord.get(15);
			String DistributorProfileURL = csvRecord.get(16);
			String dateCreated = csvRecord.get(17);
			

			System.out.println("Record No - " + csvRecord.getRecordNumber());
			System.out.println("---------------");
			System.out.println("ClientKey : " + ClientKey);
			System.out.println("Publisher : " + Publisher);
			System.out.println("IssueType : " + IssueType);
			System.out.println("PublisherValue : " + PublisherValue);
			System.out.println("StoredName : " + StoredName);
			System.out.println("StoredAddress1 : " + StoredAddress1);
			System.out.println("StoredAddress2 : " + StoredAddress2);
			System.out.println("StoredCity : " + StoredCity);
			System.out.println("StoredState : " + StoredState);
			System.out.println("StoredCountry : " + StoredCountry);
			System.out.println("StoredPostalCode : " + StoredPostalCode);
			System.out.println("lng : " + lng);
			System.out.println("lat : " + lat);
			System.out.println("StoredPhoneNumber : " + StoredPhoneNumber);
			System.out.println("StoredHours : " + StoredHours);
			System.out.println("StoredWebsite : " + StoredWebsite);
			System.out.println("DistributorProfileURL : " + DistributorProfileURL);
			System.out.println("dateCreated : " + dateCreated);
			System.out.println("---------------\n\n");
		}
	}
	
	public void selectSingleLocations() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'All Locations')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Location Group')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("4400 Sharon Rd Space A, Charlotte, NC US 28211");
		driver.findElement(By.xpath("/descendant::i[contains(@class,'')][contains(text(),'search')]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//p[contains(text(),'8188 E Santa Ana Canyon Rd, Anaheim Hills')]")).click();
		driver.findElement(By.xpath("//p[contains(text(),'4400 Sharon Rd Space A, Charlotte, NC US 28211')]")).click();
	}
	
	/*public void clickOnRecordRandomly() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> records= driver.findElements(By.xpath("//div[starts-with(@class,'cs-resultswrapper sc-')]"));
		int count=records.size();
		System.out.println("Number of records are:"+count); 
		Random r=new Random();
		int linkNo=r.nextInt(count);
		WebElement link=records.get(linkNo);
		Thread.sleep(2000);
		link.click();
		          }
		*/
	
	public void downloadHealthReport() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		//span[contains(text(),'November 2019')]
		driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(@type,'rounded')]")).click();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//div[contains(text(),'August 2019')]"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement filedownloadIcon = driver.findElement(By.xpath("//i[contains(text(),'file_download')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", filedownloadIcon);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
	}
	
	public void checkHealthReport() throws Exception 
	{
		Thread.sleep(25000);
		//String pdfLocation = "/var/lib/jenkins/workspace/B1AutomationTest/healthreport.pdf";
		String pdfLocation = "C:\\Users\\Pramod\\Downloads\\healthreport.pdf";
		PDFUtil pdfUtil = new PDFUtil();
		String content = pdfUtil.getText(pdfLocation);
		System.out.println(" The entire page content is: " + content);
		Assert.assertTrue(content.contains("Health Overview"));
		Assert.assertTrue(content.contains("Claimed"));
		Assert.assertTrue(content.contains("Name"));
		Assert.assertTrue(content.contains("Address"));
		Assert.assertTrue(content.contains("Phone"));
		Assert.assertTrue(content.contains("Website"));
		Assert.assertTrue(content.contains("Hours"));
		Assert.assertTrue(content.contains("The Cheesecake Factory"));
		
	}
	}
	
	


