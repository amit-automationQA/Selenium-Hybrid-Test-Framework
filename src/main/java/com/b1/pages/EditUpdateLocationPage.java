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

 

public class EditUpdateLocationPage extends TestBase {

	TestUtility testUtil = new TestUtility();
	HomePage homePage = new HomePage();

	@FindBy(xpath = "//span[contains(text(),'ADD LOCATION')]")
	WebElement AddLocation;

	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile;

	@FindBy(xpath = "//div[contains(text(),'Sign out')]")
	WebElement SignOut;

	@FindBy(xpath = "//div[contains(text(),'Entitlements')]")
	WebElement Entitlement;

	@FindBy(xpath = "//div[contains(text(),'Accounts')]")
	WebElement Accounts;

	@FindBy(xpath = "//div[contains(text(),'SEO')]")
	WebElement SEO;
	
	@FindBy(xpath = "//div[contains(text(),'Offerings')]")
	WebElement Offering;
	
	@FindBy(xpath = "//div[contains(text(),'Details')]")
	WebElement Details;

	public EditUpdateLocationPage() {

		PageFactory.initElements(driver, this);
	}
	
	public void VerifyTaxonomy() throws InterruptedException {

		Thread.sleep(1000);
		MyProfile.click();
		Thread.sleep(1000);
		Accounts.click();
		Thread.sleep(1000);
		Entitlement.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::span[contains(text(),'Location')][1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/descendant::span[contains(text(),'Location')][2]")).click();
		Thread.sleep(500);
		WebElement UpdateButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		Boolean Taxonomy = driver.findElement(By.xpath("//label[contains(text(),'Taxonomy')]//input[@type='checkbox']"))
				.isSelected();
		Thread.sleep(1000);
		if (Taxonomy == true) {
			System.out.println("The Taxonomy Checkbox was checked on default");
			Thread.sleep(1000);

		} else {	
			driver.findElement(By.xpath("//input[@id='Location-Location-Taxonomy']/following::span[1]")).click();
			Thread.sleep(1000);
			UpdateButton.click();
			Thread.sleep(1000);
			System.out.println("The Taxonnomy Checkbox is now checked");
			Thread.sleep(1000);
			driver.findElement(By.xpath("/descendant::span[contains(text(),'Location')][1]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/descendant::span[contains(text(),'Location')][2]")).click();
			Thread.sleep(500);
		}

		Boolean Taxonomy1 = driver
				.findElement(By.xpath("//label[contains(text(),'Taxonomy')]//input[@type='checkbox']")).isSelected();
		Thread.sleep(1000);
		if (Taxonomy1 == true) {

			Thread.sleep(2000);
			WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(location);
			actions.click().build().perform();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();

			Thread.sleep(2000);
			AddLocation.click();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", SEO);
			Thread.sleep(2000);

			String PC = driver.findElement(By.xpath("//div[contains(text(),'Primary Category')]")).getText();
			Assert.assertEquals(PC, "Primary Category");
			System.out.println("Primary Category is Varified Successfully");

			String SC = driver.findElement(By.xpath("//div[contains(text(),'Secondary Categories')]")).getText();
			Assert.assertEquals(SC, "Secondary Categories");
			System.out.println("Secondary Categories is Varified Successfully");

		} else {

			Thread.sleep(2000);
			WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(location);
			actions.click().build().perform();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();

			Thread.sleep(2000);
			AddLocation.click();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", SEO);
			Thread.sleep(2000);

			System.out.println("Primary & Secondary Categories are Not Displayed");
		}
	}

	public void VerifyListingForGoogleOnSEOTab() throws InterruptedException {

		Thread.sleep(2500);
		MyProfile.click();
		Thread.sleep(1000);
		Accounts.click();
		Thread.sleep(1000);
		Entitlement.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/descendant::span[contains(text(),'Location')][1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/descendant::span[contains(text(),'Location')][2]")).click();
		Thread.sleep(500);

		WebElement UpdateButton = driver.findElement(By.xpath("//button[@type='submit']"));
		Boolean Taxonomy = driver.findElement(By.xpath("//label[contains(text(),'Taxonomy')]//input[@type='checkbox']"))
				.isSelected();
		Thread.sleep(1000);
		if (Taxonomy == true) {

			driver.findElement(By.xpath("//input[@id='Location-Location-Taxonomy']/following::span[1]")).click();
			Thread.sleep(1000);
			UpdateButton.click();
			Thread.sleep(1000);
			System.out.println("The Taxonomy Checkbox is now Unchecked");
			Thread.sleep(1000);
		} else {

			System.out.println("The Taxonnomy Checkbox is unchecked by default");
			Thread.sleep(2500);
		}

		Boolean Listing = driver.findElement(By.xpath("//input[@id='entitlements-Listing'][@type='checkbox']")).isSelected();
		Thread.sleep(1000);
		if (Listing == true) 
		{
			driver.findElement(By.xpath("//input[@id='entitlements-Listing']//following::span[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'Listing')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='entitlements-Listing-Google']/following::span[1]")).click();
			driver.findElement(By.xpath("//span[contains(@class,'Listing-Google')][contains(text(),'Google')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='Listing-Google-Syndicate']/following::span[1]")).click();
			Thread.sleep(1000);
			UpdateButton.click();
			Thread.sleep(1000);
			System.out.println("The Google Checkbox is now checked");
			Thread.sleep(1000);
		} else 
		
		{

			/*
			 * driver.findElement(By.xpath("//span[contains(text(),'Listing')]")).click();
			 * Thread.sleep(1000); driver.findElement(By.xpath(
			 * "/html/body/div[1]/div/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div[1]/div[4]/div/div/div/div/div[2]/div/label/span"
			 * )) .click(); Thread.sleep(1000); UpdateButton.click(); Thread.sleep(1000);
			 */
			System.out.println("The Google Checkbox is Already checked");
			Thread.sleep(2500);
		}

		Boolean Listing1 = driver.findElement(By.xpath("//input[@id='entitlements-Listing'][@type='checkbox']"))
				.isSelected();
		Thread.sleep(1000);
		if (Listing1 == true) {

			driver.findElement(By.xpath("//span[contains(text(),'Listing')]")).click();
			Thread.sleep(1000);
			Boolean Google = driver.findElement(By.xpath("//input[@id='entitlements-Listing-Google']")).isSelected();
			System.out.println(Google);
			Thread.sleep(1500);

			WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(location);
			actions.click().build().perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
			Thread.sleep(2000);
			AddLocation.click();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", SEO);
			Thread.sleep(3000);
			MyProfile.click();
			Thread.sleep(1000);
			SignOut.click();
			Thread.sleep(4000);
			driver.manage().deleteAllCookies();
			Thread.sleep(4000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("sage@leanst.com");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Sage521802");
			Thread.sleep(3500);
			driver.findElement(By.xpath("//button[@class='raised_button signinBtn']")).click();
			Thread.sleep(5000);
			WebElement location1 = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(location1);
			actions1.click().build().perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
			Thread.sleep(3000);
			AddLocation.click();
			Thread.sleep(3000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].click();", SEO);
			String google = driver.findElement(By.xpath("//h2[contains(text(),'google')]")).getText();
			Assert.assertEquals(google, "GOOGLE");
			System.out.println("google Categories are Varified Successfully in SEO Tab");

		} else {

			driver.findElement(By.xpath("//span[contains(text(),'Listing')]")).click();
			Thread.sleep(1000);
			Boolean Google = driver.findElement(By.xpath("//input[@id='entitlements-Listing-Google']")).isSelected();
			System.out.println(Google);
			Thread.sleep(1500);

			WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(location);
			actions.click().build().perform();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();

			Thread.sleep(2000);
			AddLocation.click();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", SEO);

			Thread.sleep(3000);
			MyProfile.click();
			Thread.sleep(1000);
			SignOut.click();
			Thread.sleep(4000);
			driver.manage().deleteAllCookies();
			Thread.sleep(4000);
			driver.navigate().refresh();

			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("sage@leanst.com");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Sage521802");
			Thread.sleep(3500);
			driver.findElement(By.xpath("//button[@class='raised_button signinBtn']")).click();
			Thread.sleep(6000);

			WebElement location1 = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(location1);
			actions1.click().build().perform();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
			Thread.sleep(3000);
			AddLocation.click();
			Thread.sleep(3000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("arguments[0].click();", SEO);
			String google = driver.findElement(By.xpath("//h2[contains(text(),'google')]")).getText();
			Assert.assertEquals(google, "GOOGLE");
			System.out.println("google Categories are Varified Successfully in SEO Tab");
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
	
	public void AddLocationDetailsData() {

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupInfo-name sc-')]")).sendKeys("Test Id");

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupInfo-igniteClientKey sc-')]"))
				.sendKeys("Brandify Test");

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

	public void AddLocationSEOData() {
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", SEO);
		
		driver.findElement(By.xpath("//input[@placeholder='Category ID']")).sendKeys("001");
		
		driver.findElement(By.xpath("//input[@placeholder='Category Name']")).sendKeys("Test");
		
		driver.findElement(By.xpath("//span[contains(text(),'Select Type')]")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Facebook')]")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Link Title']")).sendKeys("FaceBook");
		
		driver.findElement(By.xpath("//input[@placeholder='Link']")).sendKeys("www.facebook.com");
		
		driver.findElement(By.xpath("//textarea[starts-with(@class,'qa-groupDesc-shortDescription sc-')]")).sendKeys("Test For Short Description");
		
		driver.findElement(By.xpath("//textarea[starts-with(@class,'qa-groupDesc-longDescription sc-')]")).sendKeys("Test For Long Description");
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-companyInfo-companyInfo sc-')]")).sendKeys("Test History");
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-undefined-contactEmails[0].text sc-')]")).sendKeys("Test@where2getit.com");
		
	}
	
public void AddLocationOfferingsData() {
		
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("arguments[0].click();", Offering);
	
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-undefined-brands[0].text sc-')]")).sendKeys("Brandify");
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-undefined-services[0].text sc-')]")).sendKeys("Food");
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-undefined-products[0].text sc-')]")).sendKeys("Food");
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-undefined-specialties[0].text sc-')]")).sendKeys("Cheesecakes");
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-undefined-organizations[0].text sc-')]")).sendKeys("Testing");

}
	
	public void clickOnCreateLocation() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Create Location')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void UpdateCreatedLocationData() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//h3[contains(text(),'Test Id #Brandify Test')]")).click();

		Thread.sleep(2000);
		WebElement Edit = driver
				.findElement(By.xpath("//div[starts-with(@class,'groupInfo-container group-block-main sc-')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(Edit);
		actions.click().build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[starts-with(@class,'groupInfo-edit-icon sc-')]")).click();
		Thread.sleep(2000);
		/*WebElement BN = driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupInfo-name sc-')]"));
		BN.clear();
		Thread.sleep(1000);
		BN.sendKeys("Test");*/
		
		WebElement CN = driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupInfo-igniteClientKey sc-')]"));
		CN.clear();
		Thread.sleep(2000);
		CN.sendKeys("Brandify");
		driver.findElement(By.xpath("//button[starts-with(@class,'groupInfo-btn-submit sc-')]")).click();
		Thread.sleep(3000);
		
		
		//Thread.sleep(2000);
		WebElement Edit1 = driver
				.findElement(By.xpath("//div[starts-with(@class,'groupAddress-container group-block-main sc-')]"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(Edit1);
		actions1.click().build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[starts-with(@class,'groupAddress-edit-icon sc-')]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupAddress-address1 sc-')]")).clear();
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupAddress-address1 sc-')]")).sendKeys("222 Harbor Blvd");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[starts-with(@class,'groupAddress-btn-submit sc-')][contains(text(),'Update')]")).click();
		Thread.sleep(3000);
		
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", SEO);
		
		
		WebElement Edit2 = driver
				.findElement(By.xpath("//div[starts-with(@class,'companyInfo-container group-block-main sc-')]"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(Edit2);
		actions2.click().build().perform();
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//div[starts-with(@class,'companyInfo-edit-icon sc-')]")).click();
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-companyInfo-companyInfo sc-')]")).clear();
		
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-companyInfo-companyInfo sc-')]")).sendKeys("Test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[starts-with(@class,'companyInfo-btn-submit sc-')][contains(text(),'Update')]")).click();
		Thread.sleep(3000);
		
		
		
		js2.executeScript("arguments[0].click();", Offering);
		
		
		
		WebElement Edit3 = driver
				.findElement(By.xpath("//div[starts-with(@class,'specialties-container group-block-main sc-')]"));
		Actions actions3 = new Actions(driver);
		actions3.moveToElement(Edit3);
		actions3.click().build().perform();
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//div[starts-with(@class,'specialties-edit-icon sc-')]")).click();
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-undefined-specialties[0].text sc-')]")).clear();
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-undefined-specialties[0].text sc-')]")).sendKeys("Food");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[starts-with(@class,'specialties-btn-submit sc-')][contains(text(),'Update')]")).click();
		Thread.sleep(3000);
		
	}
		
		
		
		
	public void VerifyUpdatedLocationData() throws InterruptedException {
		
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Details);
		
		String CN = driver.findElement(By.xpath("//div[starts-with(@class,'groupInfo-container group-block-main sc-')]//div[contains(text(),'Brandify')]")).getText();
		Assert.assertEquals(CN, "Brandify");
		System.out.println("Brandify is Updated Successfully");

		String Add = driver.findElement(By.xpath("//div[starts-with(@class,'groupAddress-container group-block-main sc-')]//div[contains(text(),'222 Harbor Blvd')]")).getText();
		Assert.assertEquals(Add, "222 Harbor Blvd");
		System.out.println("Address is Updated Successfully");

		Thread.sleep(1500);
		js1.executeScript("arguments[0].click();", SEO);
		Thread.sleep(1500);
	
		String History = driver.findElement(By.xpath("//div[starts-with(@class,'companyInfo-container group-block-main sc-')]//div[contains(text(),'Test')]")).getText();
		Assert.assertEquals(History, "Test");
		System.out.println("Test is Upated Successfully");

		Thread.sleep(1000);
		js1.executeScript("arguments[0].click();", Offering);
		Thread.sleep(1000);
		String Speciality = driver.findElement(By.xpath("//div[starts-with(@class,'specialties-container group-block-main sc-')]//div[contains(text(),'Food')]")).getText();
		Assert.assertEquals(Speciality, "Food");
		System.out.println("Speciality Tab is Updated Successfully");

			
		Thread.sleep(2000);
		
		
		MyProfile.click();
		Thread.sleep(1000);
		SignOut.click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("sage@leanst.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Sage521802");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='raised_button signinBtn']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//h3[contains(text(),'Test Id #Brandify')]")).click();

		Thread.sleep(2000);
		js1.executeScript("arguments[0].click();", Details);
		
		String detail = driver.findElement(By.xpath("//div[starts-with(@class,'groupInfo-container group-block-main sc-')]//div[contains(text(),'Brandify')]")).getText();
		Assert.assertEquals(CN, detail);
		System.out.println(" Details Data Updated Successfully");

		String Address = driver.findElement(By.xpath("//div[starts-with(@class,'groupAddress-container group-block-main sc-')]//div[contains(text(),'222 Harbor Blvd')]")).getText();
		Assert.assertEquals(Add, Address);
		System.out.println("Details Address Data is Updated Successfully");

		Thread.sleep(1000);
		js1.executeScript("arguments[0].click();", SEO);
		Thread.sleep(1500);
	
		String History1 = driver.findElement(By.xpath("//div[starts-with(@class,'companyInfo-container group-block-main sc-')]//div[contains(text(),'Test')]")).getText();
		Assert.assertEquals(History, History1);
		System.out.println("History Tab Data is Upated Successfully");

		Thread.sleep(1000);
		js1.executeScript("arguments[0].click();", Offering);
		Thread.sleep(1000);
		String Food = driver.findElement(By.xpath("//div[starts-with(@class,'specialties-container group-block-main sc-')]//div[contains(text(),'Food')]")).getText();
		Assert.assertEquals(Speciality,Food);
		System.out.println("Speciality Tab is Updated Successfully");
	
		Thread.sleep(2000);

	}

		
	public void DeleteCreatedLocation() throws InterruptedException {

		Thread.sleep(3000);
		WebElement Delete = driver.findElement(By.xpath("//i[contains(text(),'delete')]"));
		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Delete);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
		
		Thread.sleep(4000);
		System.out.println("Created Location is deleted Successfully");

		Thread.sleep(5000);
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
