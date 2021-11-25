package com.b1.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;
 

public class BrandifyLocationPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'ADD LOCATION')]")
	WebElement AddLocation;

	@FindBy(xpath = "/descendant::div[contains(text(),'Map')][1]")
	WebElement Map;

	@FindBy(xpath = "//a[contains(text(),'Geocode')]")
	WebElement Geocode;

	public BrandifyLocationPage() {

		PageFactory.initElements(driver, this);
	}

	public void VerifyLocationCreateOnCheck() throws InterruptedException {

		WebElement UpdateButton = driver.findElement(By.xpath("//button[@type='submit']"));

		Boolean Locationcheckstatus = driver.findElement(By.xpath("//input[@id='entitlements-Location']")).isSelected();
		Thread.sleep(1000);
		if (Locationcheckstatus == true) {
			System.out.println("Location checkbox was selected on default");
		} else {
			System.out.println("The Location Checkbox was not checked on default");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='entitlements-Location']/following::span[1]")).click();
			Thread.sleep(1000);
			UpdateButton.click();
			Thread.sleep(1000);
			System.out.println("The Location Checkbox is now checked");
		}

		driver.findElement(By.xpath("/descendant::span[contains(text(),'Location')][1]")).click();
		Boolean locationcheckstatus = driver.findElement(By.xpath("//input[@id='entitlements-Location-Location']"))
				.isSelected();
		Thread.sleep(1000);
		if (locationcheckstatus == true) {
			System.out.println("location checkbox was selected on default");
		} else {
			System.out.println("The location Checkbox was not checked on default");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='entitlements-Location-Location']/following::span[1]")).click();
			Thread.sleep(1000);

			System.out.println("The location Checkbox is now checked");
		}

		driver.findElement(By.xpath("/descendant::span[contains(text(),'Location')][2]")).click();
		Boolean Approvalcheckstatus = driver.findElement(By.xpath("//input[@id='Location-Location-Approve']"))
				.isSelected();
		Thread.sleep(1000);
		if (Approvalcheckstatus == true) {
			System.out.println("Approval checkbox was selected on default");
		} else {
			System.out.println("The Approval Checkbox was not checked on default");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='Location-Location-Approve']/following::span[1]")).click();
			Thread.sleep(1000);
			System.out.println("The create Checkbox is now checked");
		}

		Boolean createcheckstatus = driver.findElement(By.xpath("//input[@id='Location-Location-Create']"))
				.isSelected();
		Thread.sleep(1000);
		if (createcheckstatus == true) {
			System.out.println("create checkbox was selected on default");
		} else {
			System.out.println("The create Checkbox was not checked on default");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='Location-Location-Create']/following::span[1]")).click();
			Thread.sleep(1000);
			UpdateButton.click();
			Thread.sleep(2000);
			System.out.println("The create Checkbox is now checked");
		}

	}

	public void verifyListingOncheck() throws InterruptedException {

		WebElement UpdateButton = driver.findElement(By.xpath("//button[@type='submit']"));
		Boolean listingcheckstatus = driver.findElement(By.xpath("//input[@id='entitlements-Listing']")).isSelected();
		Thread.sleep(1000);
		if (listingcheckstatus == true) {
			driver.findElement(By.xpath("//input[@id='entitlements-Listing']/following::span[1]")).click();
			System.out.println("listing checkbox was selected on default");
		} else {
			System.out.println("The listing Checkbox was not checked on default");
			Thread.sleep(1000);

		}
		driver.findElement(By.xpath("//span[contains(@class,'Listing')][contains(text(),'Listing')]")).click();

		// Google Selection ---------

		Boolean Googlecheckstatus = driver.findElement(By.xpath("//input[@id='entitlements-Listing-Google']"))
				.isSelected();
		Thread.sleep(2000);
		if (Googlecheckstatus == true) 
		{
			System.out.println("Google checkbox was selected on default");
		} 
		else 
		{
			System.out.println("The Google Checkbox was not checked on default");
			driver.findElement(By.xpath("//input[@id='entitlements-Listing-Google']/following::span[1]")).click();
			Thread.sleep(2000);
			System.out.println("The Google Checkbox is now checked");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(@class,'Listing-Google')]")).click();
			Thread.sleep(2000);
			Boolean GoogleSyndicate = driver.findElement(By.xpath("//input[@id='Listing-Google-Syndicate']")).isSelected();
			if (GoogleSyndicate == true) 
			{
				driver.findElement(By.xpath("//input[@id='Listing-Google-Syndicate']/following::span[1]")).click();
				Thread.sleep(5000);
				System.out.println("The Google syndicate Checkbox is now unchecked");
			} else {
				System.out.println("The Google syndicate Checkbox is already unchecked");
			}
		}

		// Foursquare------

		Boolean Foursquarecheckstatus = driver.findElement(By.xpath("//input[@id='entitlements-Listing-Foursquare']"))
				.isSelected();
		Thread.sleep(1000);
		if (Foursquarecheckstatus == true) {
			System.out.println("Foursquare checkbox was selected on default");
		} else {
			System.out.println("The Foursquare Checkbox was not checked on default");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='entitlements-Listing-Foursquare']/following::span[1]")).click();
			Thread.sleep(2000);
			System.out.println("The Foursquare Checkbox is now checked");
			driver.findElement(By.xpath("//span[contains(@class,'Listing-Foursquare')][contains(text(),'Foursquare')]"))
					.click();
			Thread.sleep(2000);
			Boolean FoursquareSyndicate = driver.findElement(By.xpath("//input[@id='Listing-Foursquare-Syndicate']"))
					.isSelected();

			if (FoursquareSyndicate == true) {
				driver.findElement(By.xpath("//input[@id='Listing-Foursquare-Syndicate']/following::span[1]")).click();
				Thread.sleep(1000);
				System.out.println("The Foursquare syndicate Checkbox is now unchecked");
			} else {
				System.out.println("The FoursquareSyndicate Checkbox is already unchecked");
			}
		}

		// Yelp------

		Boolean Yelpcheckstatus = driver.findElement(By.xpath("//input[@id='entitlements-Listing-Yelp']")).isSelected();
		Thread.sleep(1000);
		if (Yelpcheckstatus == true) {
			System.out.println("Yelp checkbox was selected on default");
		} else 
		{
			System.out.println("The Yelp Checkbox was not checked on default");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='entitlements-Listing-Yelp']/following::span[1]")).click();
			Thread.sleep(1000);
			System.out.println("The Yelp Checkbox is now checked");
			driver.findElement(By.xpath("//span[contains(@class,'Listing-Yelp')][contains(text(),'Yelp')]")).click();
			Boolean YelpSyndicate = driver.findElement(By.xpath("//input[@id='Listing-Yelp-Syndicate']")).isSelected();
			Thread.sleep(1000);
			if (YelpSyndicate == true) {
				driver.findElement(By.xpath("//input[@id='Listing-Yelp-Syndicate']/following::span[1]")).click();
				Thread.sleep(1000);
				System.out.println("The Yelp syndicate Checkbox is now unchecked");
			} else {
				System.out.println("The YelpSyndicate Checkbox is already unchecked");
			}
		}

		// Cylex----

		Boolean Cylexcheckstatus = driver.findElement(By.xpath("//input[@id='entitlements-Listing-Cylex']"))
				.isSelected();
		Thread.sleep(1000);
		if (Cylexcheckstatus == true) {
			System.out.println("Cylex checkbox was selected on default");
		} 
		else 
		{
			System.out.println("The Cylex Checkbox was not checked on default");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='entitlements-Listing-Cylex']/following::span[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(@class,'Listing-Cylex')][contains(text(),'Cylex')]")).click();
			Boolean CylexSyndicate = driver.findElement(By.xpath("//input[@id='Listing-Cylex-Syndicate']"))
					.isSelected();
			Thread.sleep(1000);
			if (CylexSyndicate == true) {
				driver.findElement(By.xpath("//input[@id='Listing-Cylex-Syndicate']/following::span[1]")).click();
				Thread.sleep(2000);
				System.out.println("The Cylex syndicate Checkbox is now unchecked");
			} else {
				System.out.println("The YelpSyndicate Checkbox is already unchecked");
			}

			UpdateButton.click();
			Thread.sleep(1000);
			System.out.println("The Cylex Checkbox is now checked");
		}
	}

	public void clickOnLocationOVerview() throws Exception {

		Thread.sleep(2000);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(location);
		actions.click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
		Thread.sleep(2000);
		AddLocation.click();
	}

	public void LocationDetailsData() {

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupInfo-name sc-')]")).sendKeys("Brandify T3");

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupInfo-igniteClientKey sc-')]"))
				.sendKeys("Brandify");

		driver.findElement(By.xpath("//div[starts-with(@class,'qa-groupAddress-isAddressVisible-slider sc-')]"))
				.click();

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupAddress-address1 sc-')]"))
				.sendKeys("222 S. Harbor Blvd");

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupAddress-city sc-')]")).sendKeys("Anaheim");

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupAddress-state sc-')]")).sendKeys("CA");

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupAddress-postalCode sc-')]")).sendKeys("92805");

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupAddress-county sc-')]")).sendKeys("Orange");
		driver.findElement(By.xpath("//input[@type='tel' and @name='main']")).sendKeys("714-660-4870");

	}

	public void selectCountry() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Select...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'United States of America')]")).click();
	}

	public void checkAllTabs() {
		String DeailsTab = driver.findElement(By.xpath("//div[contains(text(),'Details')]")).getAttribute("innerText");
		Assert.assertTrue(DeailsTab.contains("Details"));
		System.out.println("Details Tab is present ==> " + DeailsTab);

		String MapTab = driver.findElement(By.xpath("//div[contains(text(),'Map')]")).getAttribute("innerText");
		Assert.assertTrue(MapTab.contains("Map"));
		System.out.println("Map Tab is present ==> " + MapTab);

		String SEOTab = driver.findElement(By.xpath("//div[contains(text(),'SEO')]")).getAttribute("innerText");
		Assert.assertTrue(SEOTab.contains("SEO"));
		System.out.println("SEO Tab is present ==> " + SEOTab);

		String HoursTab = driver.findElement(By.xpath("//div[contains(text(),'Hours')]")).getAttribute("innerText");
		Assert.assertTrue(HoursTab.contains("Hours"));
		System.out.println("Hours Tab is present ==> " + HoursTab);

		String OfferingsTab = driver.findElement(By.xpath("//div[contains(text(),'Offerings')]"))
				.getAttribute("innerText");
		Assert.assertTrue(OfferingsTab.contains("Offerings"));
		System.out.println("Offerings Tab is present ==> " + OfferingsTab);

		String MediaTab = driver.findElement(By.xpath("//div[contains(text(),'Media')]")).getAttribute("innerText");
		Assert.assertTrue(MediaTab.contains("Media"));
		System.out.println("Media Tab is present ==> " + MediaTab);

	}

	public void ClickOnLocaionMap() {
		TestUtility.clickOn(driver, Map, 30);
	}

	public void VerifyLocationMap() {
		String geocode = driver.findElement(By.xpath("//a[contains(text(),'Geocode')]")).getText();
		Assert.assertEquals(geocode, "GEOCODE");

		WebElement Geocode = driver.findElement(By.xpath("//a[contains(text(),'Geocode')]"));
		Assert.assertTrue(Geocode.isEnabled());

		TestUtility.clickOn(driver, Geocode, 30);

	}

	public void clickOnCreateLocation() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Create Location')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void ClickOnLocationApproval() throws InterruptedException {
		Thread.sleep(3000);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(location);
		actions.click().build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(text(),'Approvals')]")).click();
		Thread.sleep(3000);
		/*
		 * driver.navigate().refresh(); Thread.sleep(4000);
		 */
	}

	public void ClickOnListMatching() throws InterruptedException {

		driver.findElement(By.xpath("/descendant::input[@type='checkbox'][2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::i[contains(text(),'check')][2]")).click();
		Thread.sleep(3000);

		// driver.navigate().refresh(); Thread.sleep(3000);

	}

	public void ClickOnEditListing() throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(By.xpath("//i[contains(text(),'edit')]")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//h3[contains(text(),'New Listing')]")).click();

	}

	public void VerifyListing() throws InterruptedException {

		Boolean Google = driver.findElement(By.xpath("/descendant::div[contains(text(),'Google')][2]")).isDisplayed();
		if (Google == true) {
			System.out.println("Google is Displayed");
			Thread.sleep(2000);
			WebElement Listing = driver.findElement(By.xpath("/descendant::li[@role='presentation'][1]"));
			JavascriptExecutor jv = (JavascriptExecutor) driver;
			jv.executeScript("arguments[0].click();", Listing);
			// driver.findElement(By.xpath("//h3[contains(text(),'New Listing')]")).click();
			Thread.sleep(1000);
			WebElement Next = driver.findElement(By.xpath("//a[contains(text(),'NEXT')]"));
			Assert.assertTrue(Next.isEnabled());

			driver.findElement(By.xpath("//a[contains(text(),'NEXT')]")).click();
		} else {
			System.out.println("Google is Not Available");

		}

		Boolean Cylex = driver.findElement(By.xpath("//div[contains(text(),'Cylex')]")).isDisplayed();
		if (Cylex == true) {
			System.out.println("Cylex is Displayed");
			Thread.sleep(1000);
			WebElement Listing = driver.findElement(By.xpath("/descendant::li[@role='presentation'][1]"));
			JavascriptExecutor jv = (JavascriptExecutor) driver;
			jv.executeScript("arguments[0].click();", Listing);
			// driver.findElement(By.xpath("//h3[contains(text(),'New Listing')]")).click();
			Thread.sleep(1000);
			WebElement Next = driver.findElement(By.xpath("//a[contains(text(),'NEXT')]"));
			Assert.assertTrue(Next.isEnabled());

			driver.findElement(By.xpath("//a[contains(text(),'NEXT')]")).click();
		} else {
			System.out.println("Cylex is Not Available");
		}

		Boolean Yelp = driver.findElement(By.xpath("//div[contains(text(),'Yelp')]")).isDisplayed();
		if (Yelp == true) {
			System.out.println("Yelp is Displayed");
			Thread.sleep(1000);
			WebElement Listing = driver.findElement(By.xpath("/descendant::li[@role='presentation'][1]"));
			JavascriptExecutor jv = (JavascriptExecutor) driver;
			jv.executeScript("arguments[0].click();", Listing);
			// driver.findElement(By.xpath("//h3[contains(text(),'New Listing')]")).click();
			Thread.sleep(1000);
			WebElement Next = driver.findElement(By.xpath("//a[contains(text(),'NEXT')]"));
			Assert.assertTrue(Next.isEnabled());

			driver.findElement(By.xpath("//a[contains(text(),'NEXT')]")).click();
		} else {
			System.out.println("Yelp is Not Available");
		}

		Boolean Foursquare = driver.findElement(By.xpath("//div[contains(text(),'Foursquare')]")).isDisplayed();
		if (Foursquare == true) {
			System.out.println("Foursquare is Displayed");
			Thread.sleep(1000);
			WebElement Listing = driver.findElement(By.xpath("/descendant::li[@role='presentation'][1]"));
			JavascriptExecutor jv = (JavascriptExecutor) driver;
			jv.executeScript("arguments[0].click();", Listing);
			// driver.findElement(By.xpath("//h3[contains(text(),'New Listing')]")).click();

		} else {
			System.out.println("Foursquare is Not Available");
			Thread.sleep(1500);
			driver.findElement(By.xpath("//ul[@class='listing-list sc-gwjevP rSTOY']//li[1]")).click();
		}

		String submit = driver.findElement(By.xpath("//a[contains(text(),'SUBMIT')]")).getText();
		Assert.assertEquals(submit, "SUBMIT");

		WebElement Submit = driver.findElement(By.xpath("//a[contains(text(),'SUBMIT')]"));
		Assert.assertTrue(Submit.isEnabled());

		driver.findElement(By.xpath("/descendant::i[contains(text(),'close')][4]")).click();

	}

	public void DeleteLocation() throws InterruptedException {

		Thread.sleep(2000);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(location);
		actions.click().build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/descendant::h3[contains(text(),'Brandify T3 #Brandify')][1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/span/div"))
				.click();

		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
		Thread.sleep(1500);

	}

	public void DeleteApprovalHistory() throws InterruptedException {

		Thread.sleep(2000);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(location);
		actions.click().build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(text(),'Approvals')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/descendant::input[@type='checkbox'][2]")).click();

		driver.findElement(By.xpath("/descendant::i[contains(text(),'check')][2]")).click();
		Thread.sleep(1500);

	}

}
