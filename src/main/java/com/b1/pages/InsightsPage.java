package com.b1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;
 
public class InsightsPage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'INSIGHTS')]")
	WebElement insightsTab;

	@FindBy(xpath = "//div[contains(text(),'Brandscore')]")
	WebElement brandscore;

	@FindBy(xpath = "//div[contains(text(),'Reports')]")
	WebElement reports;

	@FindBy(xpath = "//li[@title='Listings Brandscore']")
	WebElement listings;

	@FindBy(xpath = "//li[@title='Engagement Brandscore']")
	WebElement engagement;
	
	@FindBy(xpath = "//li[@title='Reviews Brandscore']")
	WebElement reviews;
	
	@FindBy(xpath = "//li[@title='Search Brandscore']")
	WebElement search;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile; 

	@FindBy(xpath = "//div[contains(text(),'Accounts')]") 
	WebElement Account;

	@FindBy(xpath = "//div[contains(text(),'Entitlements')]")
	WebElement Entitlements;
	

	public InsightsPage() {

		PageFactory.initElements(driver, this);
	}
	
	
	public void navigateToEntitlements() {

		TestUtility.clickOn(driver, MyProfile, 30);
		TestUtility.clickOn(driver, Account, 30);
		TestUtility.clickOn(driver, Entitlements, 30);

	}

	
	public void clickOnBrandscore() throws Exception {
		Thread.sleep(2000);
		WebElement insights = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		Actions actions = new Actions(driver); 
		actions.moveToElement(insights);
		actions.build().perform();
		Thread.sleep(2000);
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement brandscore =
		 * driver.findElement(By.
		 * xpath("//div[@class='sc-gJWqzi dfjgY'][contains(text(),'Brandscore')]"));
		 * js.executeScript("arguments[0].click();", brandscore);
		 */
		driver.findElement(By.xpath("//div[starts-with(@class,'dropdownItemContainer sc-')]//div[contains(text(),'Brandscore')]")).click();
	}

	public void checkHeaderForBrandscore() {

		String header = driver.findElement(By.xpath("//div[contains(text(),'Leaderboard')]")).getText();
		System.out.println("Header name is => " + header);
		Assert.assertEquals(header, "Leaderboard | Brandscore");
	}

	public void checkBrandscoreData() {

		List<WebElement> brandscoreData = driver
				.findElements(By.xpath("//div[starts-with(@class,'mod-justify-between mod-align-center sc-')]"));
		System.out.println("Number of elements:" + brandscoreData.size());

		for (int i = 0; i < brandscoreData.size(); i++) {
			System.out.println("Review Records List : " + brandscoreData.get(i).getText());
		}

	}

	public void checkListing() {
		
		String listingName = driver.findElement(By.xpath("/descendant::h4[contains(text(),'Listings')][2]"))
				.getAttribute("innerText");
		Assert.assertTrue(listingName.contains("Listings"));
		System.out.println("Listing Name is displayed ==> " + listingName);
				
	}
	
	public void checkEngagement() {
		
		String EngagementName = driver.findElement(By.xpath("/descendant::h4[contains(text(),'Engagement')][2]"))
				.getAttribute("innerText");
		Assert.assertTrue(EngagementName.contains("Engagement"));
		System.out.println("Engagement Name is displayed ==> " + EngagementName);
				
	}
	
	public void checkReviews() {
		
		String ReviewsName = driver.findElement(By.xpath("/descendant::h4[contains(text(),'Reviews')][2]"))
				.getAttribute("innerText");
		Assert.assertTrue(ReviewsName.contains("Reviews"));
		System.out.println("Reviews Name is displayed ==> " + ReviewsName);
				
	}

	public void checkSearch() {
		
		String SearchName = driver.findElement(By.xpath("/descendant::h4[contains(text(),'Search')][2]"))
				.getAttribute("innerText");
		Assert.assertTrue(SearchName.contains("Search"));
		System.out.println("Search Name is displayed ==> " + SearchName);
				
	}








	public void recordsCount() {

		List<WebElement> brandscoreRecordCount = driver
				.findElements(By.xpath("//h4[contains(@class,'location-name')]"));
		System.out.println("Number of elements:" + brandscoreRecordCount.size());

		for (int i = 0; i < brandscoreRecordCount.size(); i++) {
			System.out.println("Review Records List : " + brandscoreRecordCount.get(i).getText());
		}

	}

	public void checkRecordName() {
		// Verifing Record Name
		String brandscoreRecordsName = driver.findElement(By.xpath("//h4[contains(@class,'location-name')]"))
				.getAttribute("innerText");
		Assert.assertTrue(brandscoreRecordsName.contains("JD Banking"));
		System.out.println("Record Name ==> " + brandscoreRecordsName);
		// Verifing Text Name
		String Yourbrandscore = driver.findElement(By.xpath(
				"//div[starts-with(@class,'mod-justify-between mod-align-center sc-')]//div[contains(text(),'Your Brandscore')]"))
				.getAttribute("innerText");
		Assert.assertTrue(Yourbrandscore.contains("Your Brandscore"));
		System.out.println("YourBrandscore Text ==> " + Yourbrandscore);

	}

	public void CheckListing() {

		TestUtility.clickOn(driver, listings, 30);

	}

	public void checkHeaderForListings() {

		String header = driver.findElement(By.xpath("//div[contains(text(),'Leaderboard')]")).getText();
		System.out.println("Header name is => " + header);
		Assert.assertEquals(header, "Leaderboard | Listings");
	}

	public void checkRecordNameForListings() {
		// Verifing Record Name
		String brandscoreRecordsName = driver.findElement(By.xpath("//h4[contains(@class,'location-name')]"))
				.getAttribute("innerText");
		Assert.assertTrue(brandscoreRecordsName.contains("GeoStix "));
		System.out.println("Record Name ==> " + brandscoreRecordsName);
		// Verifing Text Name
		String Yourbrandscore = driver.findElement(By.xpath(
				"//div[starts-with(@class,'mod-justify-between mod-align-center sc-')]//div[contains(text(),'Your Brandscore')]"))
				.getAttribute("innerText");
		Assert.assertTrue(Yourbrandscore.contains("Your Brandscore"));
		System.out.println("YourBrandscore Text ==> " + Yourbrandscore);

	}

	public void CheckEngagement() {

		TestUtility.clickOn(driver, engagement, 30);

	}

	public void checkHeaderForEngagement() {

		String header = driver.findElement(By.xpath("//div[contains(text(),'Leaderboard')]")).getText();
		System.out.println("Header name is => " + header);
		Assert.assertEquals(header, "Leaderboard | Engagement");
	}

	public void checkRecordNameForEngagement() {
		// Verifing Record Name
		String brandscoreRecordsName = driver.findElement(By.xpath("//h4[contains(@class,'location-name')]"))
				.getAttribute("innerText");
		Assert.assertTrue(brandscoreRecordsName.contains("GeoStix"));
		System.out.println("Record Name ==> " + brandscoreRecordsName);
		// Verifing Text Name
		String Yourbrandscore = driver.findElement(By.xpath(
				"//div[starts-with(@class,'mod-justify-between mod-align-center sc-')]//div[contains(text(),'Your Brandscore')]"))
				.getAttribute("innerText");
		Assert.assertTrue(Yourbrandscore.contains("Your Brandscore"));
		System.out.println("YourBrandscore Text ==> " + Yourbrandscore);

	}
	
	
	public void CheckReviews () {

		TestUtility.clickOn(driver, reviews, 30);

	}

	public void checkHeaderForReviews() {

		String header = driver.findElement(By.xpath("//div[contains(text(),'Leaderboard')]")).getText();
		System.out.println("Header name is => " + header);
		Assert.assertEquals(header, "Leaderboard | Reviews");
	}

	public void checkRecordNameForReviews() {
		// Verifing Record Name
		String brandscoreRecordsName = driver.findElement(By.xpath("//h4[contains(@class,'location-name')]"))
				.getAttribute("innerText");
		Assert.assertTrue(brandscoreRecordsName.contains("JD Banking"));
		System.out.println("Record Name ==> " + brandscoreRecordsName);
		// Verifing Text Name
		String Yourbrandscore = driver.findElement(By.xpath(
				"//div[starts-with(@class,'mod-justify-between mod-align-center sc-')]//div[contains(text(),'Your Brandscore')]"))
				.getAttribute("innerText");
		Assert.assertTrue(Yourbrandscore.contains("Your Brandscore"));
		System.out.println("YourBrandscore Text ==> " + Yourbrandscore);

	}
	
	
	public void CheckSearch () {

		TestUtility.clickOn(driver, search, 30);

	}

	public void checkHeaderForSearch() {

		String header = driver.findElement(By.xpath("//div[contains(text(),'Leaderboard')]")).getText();
		System.out.println("Header name is => " + header);
		Assert.assertEquals(header, "Leaderboard | Search");
	}

	public void checkRecordNameForSearch() {
		// Verifing Record Name
		String brandscoreRecordsName = driver.findElement(By.xpath("//h4[contains(@class,'location-name')]"))
				.getAttribute("innerText");
		Assert.assertTrue(brandscoreRecordsName.contains("GeoStix"));
		System.out.println("Record Name ==> " + brandscoreRecordsName);
		// Verifing Text Name
		String Yourbrandscore = driver.findElement(By.xpath(
				"//div[starts-with(@class,'mod-justify-between mod-align-center sc-')]//div[contains(text(),'Your Brandscore')]"))
				.getAttribute("innerText");
		Assert.assertTrue(Yourbrandscore.contains("Your Brandscore"));
		System.out.println("YourBrandscore Text ==> " + Yourbrandscore);

	}
	
	
	public void clickOnReports() throws Exception {
		Thread.sleep(2000);
		WebElement insights = driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		Actions actions = new Actions(driver); 
		actions.moveToElement(insights);
		actions.click().build().perform();
		Thread.sleep(2000);

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver; WebElement reports =
		 * driver.findElement(By.xpath("//div[contains(text(),'Reports')]"));
		 * js.executeScript("arguments[0].click();", reports);
		 */
		driver.findElement(By.xpath("//div[contains(text(),'Reports')]")).click();
	}
	
	public void ReportsData() {
		
		WebElement dropdown = driver.findElement(By.xpath("//select[starts-with(@class,'sc-')]")); 
        Select select = new Select(dropdown); 
        List<WebElement> options = select.getOptions(); 
        for(WebElement item:options) 
        { 
        
             System.out.println("Dropdown values are ==> "+ item.getText());           
           }
      
	}

}
