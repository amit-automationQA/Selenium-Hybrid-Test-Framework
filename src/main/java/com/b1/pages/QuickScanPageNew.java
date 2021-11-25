package com.b1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;
 

public class QuickScanPageNew extends TestBase {

	TestUtility testUtil = new TestUtility();

	@FindBy(xpath = "//div[@class='qs-heading__title']")
	WebElement PageTitle;

	@FindBy(xpath = "//input[@name='businessName']")
	WebElement BusinessName;

	@FindBy(xpath = "//input[@name='businessPhone']")
	WebElement BusinessPhone;

	@FindBy(xpath = "//input[@name='address']")
	WebElement BusinessAdd;

	@FindBy(xpath = "//button[@type='submit'][contains(text(),'START')]")
	WebElement StartScanBtn;

	@FindBy(xpath = "//div[@class='selected-flag']")
	WebElement CountryFlagDrpDwn;

	@FindBy(xpath = "//span[contains(text(),'Ireland')]")
	WebElement CountryFlagIreland;

	@FindBy(xpath = "//span[contains(text(),'United Kingdom')]")
	WebElement CountryFlagUk;

	@FindBy(xpath = "//span[contains(text(),'United States')]")
	WebElement CountryFlagUs;

	@FindBy(xpath = "//button[@type='submit'][contains(text(),'RESCAN')]")
	WebElement RescanBtn;

	public QuickScanPageNew() {
		PageFactory.initElements(driver, this);
	}

	public void VerifyQuickScanTitle() {
		String PageUrl = driver.getCurrentUrl();
		System.out.println("The Url of a page is:" + PageUrl);
		Assert.assertEquals("https://one-staging.brandify.com/quick-scan", PageUrl);
		String PageHeader = driver.findElement(By.xpath("//div[@class='qs-heading__title']//h2")).getText();
		System.out.println("The Title of a page is:" + PageHeader);
		Assert.assertEquals("Local Listing Scan", PageHeader);
	}

	public void VerifyPageElements() {
		Assert.assertTrue(BusinessName.isEnabled());
		Assert.assertTrue(BusinessPhone.isEnabled());
		Assert.assertTrue(BusinessAdd.isEnabled());
		Assert.assertTrue(StartScanBtn.isEnabled());
	}

	public void VerifyMendatoryFields() {
		BusinessName.clear();
		BusinessPhone.clear();
		StartScanBtn.click();
	}

	public void VerifyDifferentTextValuesInBusinessName() throws InterruptedException {
		BusinessName.click();
		BusinessName.sendKeys("@ABCD");
		Thread.sleep(1000);
		BusinessName.clear();
		BusinessName.sendKeys("QuickScanVerifyTestPage");
		Thread.sleep(1000);
		BusinessName.clear();
		BusinessName.sendKeys("1234567890");
		Thread.sleep(1000);
		BusinessName.clear();
	}

	public void VerifyDifferentCountryFlagsAndCodes() throws InterruptedException {
		CountryFlagDrpDwn.click();
		CountryFlagIreland.click();
		Thread.sleep(1000);
		CountryFlagDrpDwn.click();
		CountryFlagUk.click();
		Thread.sleep(1000);
		CountryFlagDrpDwn.click();
		CountryFlagUs.click();
		BusinessPhone.clear();
		driver.navigate().refresh();
		Assert.assertTrue(CountryFlagIreland.isEnabled());
	}

	public void VerifyDifferentValuesForBusinessPhone() throws InterruptedException {
		CountryFlagDrpDwn.click();
		CountryFlagIreland.click();

		BusinessPhone.sendKeys("(01) 675 3420");
		System.out.println("Entered country No. Is Valid");
		BusinessPhone.clear();
		Thread.sleep(1000);

		BusinessPhone.sendKeys("1234567890");
		BusinessName.sendKeys("Zara");
		StartScanBtn.click();
		String IE = driver.findElement(By.xpath("//div[@class='qs-form-input__error-message']")).getText();
		Assert.assertEquals(IE, "Invalid Number", "Entered country No. Is InValid For Ireland");
		BusinessPhone.clear();
		Thread.sleep(1000);

		BusinessPhone.sendKeys("01234@#");
		String IE1 = driver.findElement(By.xpath("//div[@class='qs-form-input__error-message']")).getText();
		Assert.assertEquals(IE1, "Invalid Number", "Entered country No. Is InValid For Ireland");
		BusinessPhone.clear();
		Thread.sleep(1000);

		CountryFlagDrpDwn.click();
		CountryFlagUk.click();
		BusinessPhone.sendKeys("20 7592 7320");
		System.out.println("Entered country No. Is Valid");
		BusinessPhone.clear();
		Thread.sleep(1000);

		BusinessPhone.sendKeys("12345678901");
		String UK = driver.findElement(By.xpath("//div[@class='qs-form-input__error-message']")).getText();
		Assert.assertEquals(UK, "Invalid Number", "Entered country No. Is InValid For UK");
		BusinessPhone.clear();
		Thread.sleep(1000);

		BusinessPhone.sendKeys("01234@#");
		String UK1 = driver.findElement(By.xpath("//div[@class='qs-form-input__error-message']")).getText();
		Assert.assertEquals(UK1, "Invalid Number", "Entered country No. Is InValid For UK");
		BusinessPhone.clear();
		Thread.sleep(1000);

		CountryFlagDrpDwn.click();
		CountryFlagUs.click();
		BusinessPhone.sendKeys("(516) 256-8800");
		System.out.println("Entered country No. Is Valid");
		BusinessPhone.clear();
		Thread.sleep(1000);

		BusinessPhone.sendKeys("123456789012");
		String US = driver.findElement(By.xpath("//div[@class='qs-form-input__error-message']")).getText();
		Assert.assertEquals(US, "Invalid Number", "Entered country No. Is InValid For US");
		BusinessPhone.clear();
		Thread.sleep(1000);

		BusinessPhone.sendKeys("01234@#");

		String US1 = driver.findElement(By.xpath("//div[@class='qs-form-input__error-message']")).getText();
		Assert.assertEquals(US1, "Invalid Number", "Entered country No. Is InValid For US");
		BusinessPhone.clear();
	}

	public void VerifyDifferentValuesForBusinessAddress() throws InterruptedException {
		BusinessAdd.click();
		BusinessAdd.sendKeys("Ritz Carlton Hotel, Tinnehinch, Enniskerry, Co. Wicklow, Ireland");
		RescanBtn.click();
		Thread.sleep(3000);
		BusinessAdd.clear();
		BusinessAdd.sendKeys("qwertyuiolkjhgfdsazxcvbnm23456789");
		RescanBtn.click();
	}

	public void CheckReportInIreland() {
		driver.navigate().back();
		BusinessName.sendKeys("Zara");
		BusinessPhone.sendKeys("(01) 675 3420");
		StartScanBtn.click();
		String Name = driver.findElement(By.xpath("//div[starts-with(@class,'qs-table-cell__text')][contains(text(),'Zara')]"))
				.getText();
		//Assert.assertEquals(Name, "Zara", "Generated Report is Valid For Name");
		String No = driver
				.findElement(By.xpath("//div[@class='qs-table-cell__text false'][contains(text(),'(01) 675 3420')]"))
				.getText();
		Assert.assertEquals(No, "(01) 675 3420", "Generated Report is Valid For No");

		WebElement A = driver.findElement(By.xpath("//input[@name='address']"));
		String text = A.getAttribute("value");
		System.out.println(text);
		if (text.isEmpty()) {
			System.out.println("input box is empty");
		} else {
			System.out.println("input box is not empty");
		}
		
		// To Verify Schedulelink At Header
		/*WebElement ScheduleLink = driver.findElement(By.xpath("//a[contains(text(),'Schedule Demo')]"));
		Assert.assertTrue(ScheduleLink.isDisplayed());
		Assert.assertTrue(ScheduleLink.isEnabled());*/

	}

	public void VerifyProvidersInReportForIreland() throws InterruptedException {
		// For Google:
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(3000);
		WebElement ImageFile = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='report-googlelogo qs-table-cell__img']")));
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);
		if (!ImagePresent) {
			System.out.println("Google image not displayed.");
		} else {
			System.out.println("Google image displayed.");
		}

		// For Yelp
		WebDriverWait Y = new WebDriverWait(driver, 30);
		Thread.sleep(3000);
		WebElement IF = Y.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='report-yelplogo qs-table-cell__img']")));
		Boolean IP = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				IF);
		if (!IP) {
			System.out.println("Yelp image not displayed.");
		} else {
			System.out.println("Yelp image displayed.");
		}

		// For FourSquare
		WebDriverWait F = new WebDriverWait(driver, 30);
		WebElement II = F.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='report-foursquarelogo qs-table-cell__img']")));
		Boolean PP = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				II);
		if (!PP) {
			System.out.println("FourSquare image not displayed.");
		} else {
			System.out.println("FourSquare image displayed.");
		}

		// For GoldenPages
		WebDriverWait X = new WebDriverWait(driver, 30);
		WebElement FF = X.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='report-goldenpagesielogo qs-table-cell__img']")));
		Boolean XX = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				FF);
		if (!XX) {
			System.out.println("GoldenPages image not displayed.");
		} else {
			System.out.println("GoldenPages image displayed.");
		}

		// For Eirphonebook
		WebDriverWait AA = new WebDriverWait(driver, 30);
		WebElement BB = AA.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[starts-with(@class,'report-eirphonebooklogo qs-table-cell__img')]")));
		Boolean CC = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				BB);
		if (!CC) {
			System.out.println("Eirphonebook image not displayed.");
		} else {
			System.out.println("Eirphonebook image displayed.");
		}

		// For Hotfrog
		WebDriverWait DD = new WebDriverWait(driver, 30);
		WebElement EE = DD.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='report-hotfroglogo qs-table-cell__img']")));
		Boolean GG = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				EE);
		if (!GG) {
			System.out.println("Hotfrog image not displayed.");
		} else {
			System.out.println("Hotfrog image displayed.");
		}
	}

	public void VerifyReportColumnForIreland() {
		String Publisher = driver
				.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[1]")).getText();
		Assert.assertEquals(Publisher, "Publisher");
		String Status = driver.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[2]"))
				.getText();
		Assert.assertEquals(Status, "Status");
		String BusinessInfo = driver
				.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[3]")).getText();
		Assert.assertEquals(BusinessInfo, "Business information");
		String Review = driver.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[4]"))
				.getText();
		Assert.assertEquals(Review, "Reviews");
	}

	public void CheckReportInUK() {
		driver.navigate().back();
		BusinessName.sendKeys("Zara");
		CountryFlagDrpDwn.click();
		CountryFlagUk.click();
		BusinessPhone.sendKeys("20 7592 7320");
		StartScanBtn.click();
		String Name = driver.findElement(By.xpath("//div[@class='qs-table-cell__text false'][contains(text(),'Zara')]"))
				.getText();
		Assert.assertEquals(Name, "Zara", "Generated Report is Valid For Name");
		String No = driver
				.findElement(By.xpath("//div[@class='qs-table-cell__text false'][contains(text(),'020 7592 7320')]"))
				.getText();
		Assert.assertEquals(No, "020 7592 7320", "Generated Report is Valid For No");

		WebElement A = driver.findElement(By.xpath("//input[@name='address']"));
		String text = A.getAttribute("value");
		System.out.println(text);
		if (text.isEmpty()) {
			System.out.println("input box is empty");
		} else {
			System.out.println("input box is not empty");
		}

		// VerifyProviderReportForUK

		// For Google:
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ImageFile = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='googlelogo qs-table-cell__img']")));
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);
		if (!ImagePresent) {
			System.out.println("Google image not displayed.");
		} else {
			System.out.println("Google image displayed.");
		}

		// For Yelp
		WebDriverWait Y = new WebDriverWait(driver, 30);
		WebElement IF = Y.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='report-yelplogo qs-table-cell__img']")));
		Boolean IP = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				IF);
		if (!IP) {
			System.out.println("Yelp image not displayed.");
		} else {
			System.out.println("Yelp image displayed.");
		}

		// For FourSquare
		WebDriverWait K = new WebDriverWait(driver, 30);
		WebElement LL = K.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='foursquarelogo qs-table-cell__img']")));
		Boolean MM = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				LL);
		if (!MM) {
			System.out.println("FourSquare image not displayed.");
		} else {
			System.out.println("FourSquare image displayed.");
		}

		// For Bing
		WebDriverWait N = new WebDriverWait(driver, 30);
		WebElement OO = N.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='report-binglogo qs-table-cell__img']")));
		Boolean QQ = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				OO);
		if (!QQ) {
			System.out.println("Bing image not displayed.");
		} else {
			System.out.println("Bing image displayed.");
		}

		// VerifyReportColumnForUK
		String Publisher = driver
				.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[1]")).getText();
		Assert.assertEquals(Publisher, "Publisher");
		String Status = driver.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[2]"))
				.getText();
		Assert.assertEquals(Status, "Status");
		String BusinessInfo = driver
				.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[3]")).getText();
		Assert.assertEquals(BusinessInfo, "Business information");
		String Review = driver.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[4]"))
				.getText();
		Assert.assertEquals(Review, "Reviews");
	}

	public void CheckReportInUS() {
		driver.navigate().back();
		BusinessName.sendKeys("BJ's Restaurant & Brewhouse");
		CountryFlagDrpDwn.click();
		CountryFlagUs.click();
		BusinessPhone.sendKeys("(516) 256-8800");
		StartScanBtn.click();
		String Name = driver
				.findElement(
						By.xpath("//div[@class='qs-table qs-table--7cols qs-desktop-only']//div[2]//div[3]//div[1]"))
				.getText();
		Assert.assertEquals(Name, "BJ's Restaurant & Brewhouse", "Generated Report is Valid For Name");
		String No = driver
				.findElement(
						By.xpath("//div[@class='qs-table qs-table--7cols qs-desktop-only']//div[2]//div[3]//div[3]"))
				.getText();
		Assert.assertEquals(No, "(516) 256-8800", "Generated Report is Valid For No");

		WebElement A = driver.findElement(By.xpath("//input[@name='address']"));
		String text = A.getAttribute("value");
		System.out.println(text);
		if (text.isEmpty()) {
			System.out.println("input box is empty");
		} else {
			System.out.println("input box is not empty");
		}

		// VerifyProviderReportForUK

		// For Google:
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ImageFile = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='googlelogo qs-table-cell__img']")));
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);
		if (!ImagePresent) {
			System.out.println("Google image not displayed.");
		} else {
			System.out.println("Google image displayed.");
		}

		// For FourSquare
		WebDriverWait Y = new WebDriverWait(driver, 30);
		WebElement IF = Y.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@class='foursquarelogo qs-table-cell__img']")));
		Boolean IP = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				IF);
		if (!IP) {
			System.out.println("FourSquare image not displayed.");
		} else {
			System.out.println("FourSquare image displayed.");
		}

		// For Here
		WebDriverWait K = new WebDriverWait(driver, 30);
		WebElement LL = K.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='report-herelogo qs-table-cell__img']")));
		Boolean MM = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				LL);
		if (!MM) {
			System.out.println("Here image not displayed.");
		} else {
			System.out.println("Here image displayed.");
		}

		// VerifyReportColumnForUK
		String Publisher = driver
				.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[1]")).getText();
		Assert.assertEquals(Publisher, "Publisher");
		String Status = driver.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[2]"))
				.getText();
		Assert.assertEquals(Status, "Status");
		String BusinessInfo = driver
				.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[3]")).getText();
		Assert.assertEquals(BusinessInfo, "Business information");
		String Review = driver.findElement(By.xpath("//div[@class='qs-table-row qs-table-row__header']//child::div[4]"))
				.getText();
		Assert.assertEquals(Review, "Reviews");
	}

	public void CheckReportForGoogleInIreland() {

		driver.navigate().back();
		BusinessName.sendKeys("Fine Wines Limerick");
		BusinessPhone.sendKeys(" (061) 416 501");
		StartScanBtn.click();

		// To Check Google Status Connected

		String Warning = driver
				.findElement(By.xpath("//div[@class='qs-table qs-table--7cols qs-desktop-only']/div[2]/div[2]"))
				.getText();
		Assert.assertEquals(Warning, "In Progress");
		System.out.println("Google is Connected");

		// To Check that Google address is shown without warnings

		String Address = driver.findElement(By.xpath(
				"//div[@class='qs-table-cell__text false'][contains(text(),'41 Corbally Rd, Limerick, Ireland')]"))
				.getText();
		Assert.assertEquals(Address, "41 Corbally Rd, Limerick, Ireland");
		System.out.println("Google Address Shown Without Warning");

	}

	public void CheckReportWithNotFoundSource() {

		driver.navigate().back();
		BusinessName.sendKeys("Sika Restaurant");
		BusinessPhone.sendKeys("(01) 274 8888");
		StartScanBtn.click();

		// To Check no connected profiles are shown as 'No matching listing':==>

		String Google = driver
				.findElement(By.xpath("/descendant::div[contains(text(),'Sika Restaurant')][1]"))
				.getText();
		Assert.assertTrue(Google.contains("Sika Restaurant"));
		//Assert.assertTrue(Google.contains("No Matching Listing"));
		System.out.println("Report Is Generated for google");

		String Yelp = driver
				.findElement(By.xpath(
						"//body/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]"))
				.getText();
		Assert.assertTrue(Yelp.contains("No Matching Listing"));
		System.out.println("Report Is Generated for Yelp");

		String FourSquare = driver
				.findElement(By.xpath(
						"//body/div[1]/div[1]/div[1]/div[2]/div[5]/div[3]/div[1]"))
				.getText();
		Assert.assertTrue(FourSquare.contains("Sika"));
		System.out.println("Report Is Generated for FourSquare");

		String GoldenPages = driver
				.findElement(By.xpath(
						"/descendant::div[contains(text(),'No Matching Listing')][3]"))
				.getText();
		Assert.assertTrue(GoldenPages.contains("No Matching Listing"));
		System.out.println("Report Is Generated for GoldenPages");

		// To Check Google has additional text :==>

		/*
		 * String google = driver .findElement( By.
		 * xpath("//div[contains(@class,'qs-table qs-table--7cols qs-desktop-only')]//div[2]//div[2]"
		 * )) .getText(); Assert.assertTrue(google.
		 * contains("Advanced scan requires address information"));
		 * System.out.println("Report Is Generated for google With Additional Text");
		 */

		// To Verify User After Adding Address And Rescan==>>

		BusinessAdd.sendKeys("Ritz Carlton Hotel, Tinnehinch, Enniskerry, Co. Wicklow, Ireland");
		RescanBtn.click();

		// To Check Google Is Connected==>

		String Warning = driver
				.findElement(By.xpath(
						"//div[contains(@class,'qs-table qs-table--7cols qs-desktop-only')]//div[2]//div[3]//div[1]"))
				.getText();
		Assert.assertEquals(Warning, "Sika Restaurant");
		System.out.println("Google is Connected With Addrs");
	}

	public void CheckReportWithAddr() {
		driver.navigate().back();
		BusinessName.sendKeys("Sika Restaurant");
		BusinessPhone.sendKeys("(01) 274 8888");
		BusinessAdd.sendKeys("Ritz Carlton Hotel, Tinnehinch, Enniskerry, Co. Wicklow, Ireland");
		StartScanBtn.click();

		// To Check Google Is Connected==>

		String Warning = driver
				.findElement(By.xpath(
						"//div[contains(@class,'qs-table qs-table--7cols qs-desktop-only')]//div[2]//div[3]//div[1]"))
				.getText();
		Assert.assertEquals(Warning, "Sika Restaurant");
		System.out.println("Google is Connected After Adding Addrs");
	}

}
