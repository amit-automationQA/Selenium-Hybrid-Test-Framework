package com.b1.testcases;

import java.io.Reader;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class ReviewExportCSVReadTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ReviewsPage reviewsPage;
	TestUtility testUtil;
	//JavascriptExecutor js = (JavascriptExecutor) driver;

	public ReviewExportCSVReadTest() {
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
	public void ReviewsPageSetup() throws Exception {
		reviewsPage.selectCheesecake();
		reviewsPage.selectReviews();
		

	}

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 2) public void
	 * clickOnPostingDate() throws Exception { //driver.navigate().refresh();
	 * Thread.sleep(5000); reviewsPage.postingDate(); Thread.sleep(5000);
	 * 
	 * }
	 */

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 3) public void
	 * selectSavedReviews() throws Exception { //driver.navigate().refresh();
	 * Thread.sleep(3000); driver.findElement(By.
	 * xpath("//i[starts-with(@class,'material-icons sc-') and contains(text(),'expand_more')]"
	 * )) .click();
	 * driver.findElement(By.xpath("//h4[contains(text(),'Saved Filters')]")).click(
	 * );
	 * 
	 * }
	 */

	@Test(groups = { "sanity", "regression" }, priority = 4)
	public void exportReviewData() throws Exception {
		
		reviewsPage.exportData();

		Thread.sleep(5000);
		String totalCount = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",
				driver.findElement(By.xpath("//div[starts-with(@class,'exportheader sc-')]")));
		System.out.println("Total Count for Export Review Data : " + totalCount);

		driver.findElement(By.xpath("//span[contains(text(),'Export')]")).click();
		Thread.sleep(20000);
	
	}

	@Test(groups = { "sanity", "regression" }, priority = 5)
	public void readExportCSVData() throws Exception {

		Thread.sleep(10000);
		//Reader reader = Files.newBufferedReader(Paths.get("/var/lib/jenkins/workspace/B1AutomationTest/reviews_export.csv"));
		Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Pramod\\Downloads\\reviews_export.csv"));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

		for (CSVRecord csvRecord : csvParser) {

			String StoreNumber = csvRecord.get(0);
			String Site = csvRecord.get(1);
			String Link = csvRecord.get(2);
			String Reviewer = csvRecord.get(3);
			String ReviewText = csvRecord.get(4);
			String Rating = csvRecord.get(5);
			String ReviewDate = csvRecord.get(6);

			System.out.println("Record No - " + csvRecord.getRecordNumber());
			System.out.println("---------------");
			System.out.println("StoreNumber : " + StoreNumber);
			System.out.println("Site : " + Site);
			System.out.println("Link : " + Link);
			System.out.println("Reviewer : " + Reviewer);
			System.out.println("ReviewText : " + ReviewText);
			System.out.println("Rating : " + Rating);
			System.out.println("ReviewDate : " + ReviewDate);
			System.out.println("---------------\n\n");
			
		}
	}

	/*
	 * @Test(groups = { "sanity", "regression" }, priority = 6) public void
	 * ReviewDisable() throws InterruptedException { driver.navigate().refresh();
	 * Thread.sleep(2000); reviewsPage.selectReviewOnEntitlements();
	 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	 * 
	 * boolean checkbox =
	 * driver.findElement(By.xpath("//input[@id='entitlements-Review']")).isSelected
	 * (); System.out.println("Check checkbox value is : " + checkbox); if
	 * (checkbox== true) {
	 * 
	 * System.out.println("Checkbox is already checked  ");
	 * 
	 * WebElement element = driver.findElement(By.id("entitlements-Review"));
	 * JavascriptExecutor js = (JavascriptExecutor)driver; js.executeScript
	 * ("arguments[0].click();", element);
	 * 
	 * driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click(); }
	 * }
	 */
	

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		driver.quit();

	}

}
