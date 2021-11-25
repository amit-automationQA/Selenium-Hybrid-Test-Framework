package com.b1.pages;

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
 

public class LocationGUI extends TestBase {

	TestUtility testUtil = new TestUtility();
	HomePage homePage = new HomePage();

	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile;
	
	@FindBy(xpath = "//div[contains(text(),'Entitlements')]")
	WebElement Entitlement;
	
	@FindBy(xpath = "//div[contains(text(),'Accounts')]")
	WebElement Accounts;
	
	@FindBy(xpath = "//span[contains(text(),'ADD LOCATION')]")
	WebElement AddLocation;

	@FindBy(xpath = "//div[contains(text(),'Details')]")
	WebElement Details;

	@FindBy(xpath = "//div[contains(text(),'Map')]")
	WebElement Map;

	@FindBy(xpath = "//div[contains(text(),'SEO')]")
	WebElement SEO;

	@FindBy(xpath = "/descendant::div[contains(text(),'Hours')][1]")
	WebElement Hours;

	@FindBy(xpath = "//div[contains(text(),'Offerings')]")
	WebElement Offering;

	@FindBy(xpath = "/descendant::div[contains(text(),'Media')]")
	WebElement Media;

	@FindBy(xpath = "//div[contains(text(),'Custom')]")
	WebElement Custom;

	@FindBy(xpath = "//div[contains(text(),'Profile URLs')]")
	WebElement ProfileURL;

	@FindBy(xpath = "//div[contains(text(),'History')]")
	WebElement History;

	@FindBy(xpath = "//div[contains(text(),'Internal')]")
	WebElement Internal;

	public LocationGUI() {
		PageFactory.initElements(driver, this);
	}


	public void ClickOnAddLocation() throws InterruptedException {

		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement location = driver.findElement(By.xpath("//span[contains(text(),'ADD LOCATION')]"));
		Assert.assertTrue(location.isDisplayed());
		new WebDriverWait(driver, 60).ignoring(NoSuchSessionException.class)
				.until(ExpectedConditions.elementToBeClickable(location));
		location.click();

	}

	public void VerifyLocationTabs() {

		String Details = driver.findElement(By.xpath("//div[contains(text(),'Details')]")).getText();
		Assert.assertEquals(Details, "Details");
		System.out.println("Detail Tab is Varified Successfully");

		String Map = driver.findElement(By.xpath("//div[contains(text(),'Map')]")).getText();
		Assert.assertEquals(Map, "Map");
		System.out.println("Map Tab is Varified Successfully");

		String SEO = driver.findElement(By.xpath("//div[contains(text(),'SEO')]")).getText();
		Assert.assertEquals(SEO, "SEO");
		System.out.println("SEO Tab is Varified Successfully");

		String Hours = driver.findElement(By.xpath("/descendant::div[contains(text(),'Hours')][1]")).getText();
		Assert.assertEquals(Hours, "Hours");
		System.out.println("Hours Tab is Varified Successfully");

		String Offering = driver.findElement(By.xpath("//div[contains(text(),'Offerings')]")).getText();
		Assert.assertEquals(Offering, "Offerings");
		System.out.println("Offerings Tab is Varified Successfully");

		String Media = driver.findElement(By.xpath("/descendant::div[contains(text(),'Media')]")).getText();
		Assert.assertEquals(Media, "Media");
		System.out.println("Media Tab is Varified Successfully");

		String Custom = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getText();
		Assert.assertEquals(Custom, "Custom");
		System.out.println("Custom Tab is Varified Successfully");

	}

	public void verifyDetailTab() {

		String BN = driver.findElement(By.xpath("//div[contains(text(),'Business Name')]")).getText();
		Assert.assertEquals(BN, "Business Name");
		System.out.println("Business Name is Varified Successfully");

		String CK = driver.findElement(By.xpath("//div[contains(text(),'Client Key')]")).getText();
		Assert.assertEquals(CK, "Client Key");
		System.out.println("Client Key is Varified Successfully");

		String AV = driver.findElement(By.xpath("//div[contains(text(),'Address Visible')]")).getText();
		Assert.assertEquals(AV, "Address Visible");
		System.out.println("Address Visible is Varified Successfully");

		String A1 = driver.findElement(By.xpath("//div[contains(text(),'Address 1')]")).getText();
		Assert.assertEquals(A1, "Address 1");
		System.out.println("Address 1 is Varified Successfully");

		String A2 = driver.findElement(By.xpath("//div[contains(text(),'Address 2')]")).getText();
		Assert.assertEquals(A2, "Address 2");
		System.out.println("Address 2 is Varified Successfully");

		String City = driver.findElement(By.xpath("/descendant::div[contains(text(),'City')][1]")).getText();
		Assert.assertEquals(City, "City");
		System.out.println("City is Varified Successfully");

		String State = driver.findElement(By.xpath("/descendant::div[contains(text(),'State')][1]")).getText();
		Assert.assertEquals(State, "State");
		System.out.println("State is Varified Successfully");

		String PC = driver.findElement(By.xpath("//div[contains(text(),'Postal Code')]")).getText();
		Assert.assertEquals(PC, "Postal Code");
		System.out.println("Postal Code is Varified Successfully");

		String County = driver.findElement(By.xpath("//div[contains(text(),'County')]")).getText();
		Assert.assertEquals(County, "County");
		System.out.println("County is Varified Successfully");

		String Country = driver.findElement(By.xpath("//div[contains(text(),'Country')]")).getText();
		Assert.assertEquals(Country, "Country");
		System.out.println("Country is Varified Successfully");

		String Sublocality = driver.findElement(By.xpath("//div[contains(text(),'Sublocality')]")).getText();
		Assert.assertEquals(Sublocality, "Sublocality");
		System.out.println("Sublocality is Varified Successfully");

		String PN = driver.findElement(By.xpath("//div[contains(text(),'Phone Number')]")).getText();
		Assert.assertEquals(PN, "Phone Number");
		System.out.println("Phone Number is Varified Successfully");

		String AP = driver.findElement(By.xpath("//div[contains(text(),'Alternate Phone')]")).getText();
		Assert.assertEquals(AP, "Alternate Phone");
		System.out.println("Alternate Phone is Varified Successfully");

		String TFP = driver.findElement(By.xpath("//div[contains(text(),'Toll-Free Phone')]")).getText();
		Assert.assertEquals(TFP, "Toll-Free Phone");
		System.out.println("Toll-Free Phone is Varified Successfully");

		String FN = driver.findElement(By.xpath("//div[contains(text(),'Fax Number')]")).getText();
		Assert.assertEquals(FN, "Fax Number");
		System.out.println("Fax Number is Varified Successfully");

		String IP = driver.findElement(By.xpath("//div[contains(text(),'International Phone')]")).getText();
		Assert.assertEquals(IP, "International Phone");
		System.out.println("International Phone is Varified Successfully");

		/*
		 * String PT =
		 * driver.findElement(By.xpath("//input[contains(@placeholder,'Phone Type')]")).
		 * getText(); Assert.assertEquals(PT, "Phone Type");
		 * System.out.println("Phone Type Tab is Displayed");
		 */

		String Tags = driver.findElement(By.xpath("//div[contains(text(),'Tags')]")).getText();
		Assert.assertEquals(Tags, "Tags");
		System.out.println("Tags Tab is Displayed");

	}

	public void VerifyMapTab() {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Map);

		String SL = driver.findElement(By.xpath("//div[contains(text(),'Store Location')]")).getText();
		Assert.assertTrue(SL.contains("Store Location"));
		System.out.println("Store Location is Varified Successfully");

		String WL = driver.findElement(By.xpath("//div[contains(text(),'Walking Location')]")).getText();
		Assert.assertTrue(WL.contains("Walking Location"));
		System.out.println("Walking Location is Varified Successfully");

		String PL = driver.findElement(By.xpath("//div[contains(text(),'Parking Location')]")).getText();
		Assert.assertTrue(PL.contains("Parking Location"));
		System.out.println("Parking Location is Varified Successfully");

		String PickupLoc = driver.findElement(By.xpath("//div[contains(text(),'Pickup Location')]")).getText();
		Assert.assertTrue(PickupLoc.contains("Pickup Location"));
		System.out.println("Pickup Location is Varified Successfully");

		String DL = driver.findElement(By.xpath("//div[contains(text(),'Dropoff Location')]")).getText();
		Assert.assertTrue(DL.contains("Dropoff Location"));
		System.out.println("Dropoff Location is Varified Successfully");

		String geocode = driver.findElement(By.xpath("//a[contains(text(),'Geocode')]")).getText();
		Assert.assertEquals(geocode, "GEOCODE");

		WebElement Geocode = driver.findElement(By.xpath("//a[contains(text(),'Geocode')]"));
		Assert.assertTrue(Geocode.isEnabled());

	}

	public void VerifySEOTab() {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", SEO);

		/*
		 * String PC =
		 * driver.findElement(By.xpath("//div[contains(text(),'Primary Category')]")).
		 * getText(); Assert.assertEquals(PC, "Primary Category");
		 * System.out.println("Primary Category is Varified Successfully");
		 * 
		 * String SC =
		 * driver.findElement(By.xpath("//div[contains(text(),'Secondary Categories')]")
		 * ).getText(); Assert.assertEquals(SC, "Secondary Categories");
		 * System.out.println("Secondary Categories is Varified Successfully");
		 */

		/*
		 * String twitter =
		 * driver.findElement(By.xpath("//h2[contains(text(),'twitter')]")).getText();
		 * Assert.assertEquals(twitter, "TWITTER");
		 * System.out.println("twitter is Varified Successfully");
		 */

		/*
		 * String Handle =
		 * driver.findElement(By.xpath("//div[contains(text(),'Handle')]")).getText();
		 * Assert.assertEquals(Handle, "Handle");
		 * System.out.println("Handle is Varified Successfully");
		 */

		String Keywords = driver.findElement(By.xpath("//form//div[contains(text(),'Keywords')]")).getText();
		Assert.assertEquals(Keywords, "Keywords");
		System.out.println("Keywords is Varified Successfully");

		String WL = driver.findElement(By.xpath("//div[contains(text(),'Website Links')]")).getText();
		Assert.assertEquals(WL, "Website Links");
		System.out.println("Website Links is Varified Successfully");

		String SD = driver.findElement(By.xpath("//div[contains(text(),'Short Description')]")).getText();
		Assert.assertEquals(SD, "Short Description");
		System.out.println("Short Description is Varified Successfully");

		String LD = driver.findElement(By.xpath("//div[contains(text(),'Long Description')]")).getText();
		Assert.assertEquals(LD, "Long Description");
		System.out.println("Long Description is Varified Successfully");

		String History = driver.findElement(By.xpath("//div[contains(text(),'History')]")).getText();
		Assert.assertEquals(History, "History");
		System.out.println("History is Varified Successfully");

		String CE = driver.findElement(By.xpath("//div[contains(text(),'Contact Emails')]")).getText();
		Assert.assertEquals(CE, "Contact Emails");
		System.out.println("Contact Emails is Varified Successfully");

	}

	public void VerifyHoursTab() {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Hours);

		String RH = driver.findElement(By.xpath("//div[contains(text(),'Regular Hours')]")).getText();
		Assert.assertEquals(RH, "REGULAR HOURS");
		System.out.println("Regular Hours is Varified Successfully");

		String Sunday = driver.findElement(By.xpath("//div[@class='bho']//div[contains(text(),'Sunday')]")).getText();
		Assert.assertEquals(Sunday, "Sunday");
		System.out.println("Sunday is Varified Successfully");

		String Monday = driver.findElement(By.xpath("//div[@class='bho']//div[contains(text(),'Monday')]")).getText();
		Assert.assertEquals(Monday, "Monday");
		System.out.println("Monday is Varified Successfully");

		String Tuesday = driver.findElement(By.xpath("//div[@class='bho']//div[contains(text(),'Tuesday')]")).getText();
		Assert.assertEquals(Tuesday, "Tuesday");
		System.out.println("Tuesday is Varified Successfully");

		String Wednesday = driver.findElement(By.xpath("//div[@class='bho']//div[contains(text(),'Wednesday')]"))
				.getText();
		Assert.assertEquals(Wednesday, "Wednesday");
		System.out.println("Wednesday is Varified Successfully");

		String Thursday = driver.findElement(By.xpath("//div[@class='bho']//div[contains(text(),'Thursday')]"))
				.getText();
		Assert.assertEquals(Thursday, "Thursday");
		System.out.println("Thursday is Varified Successfully");

		String Friday = driver.findElement(By.xpath("//div[@class='bho']//div[contains(text(),'Friday')]")).getText();
		Assert.assertEquals(Friday, "Friday");
		System.out.println("Friday is Varified Successfully");

		String Saturday = driver.findElement(By.xpath("//div[@class='bho']//div[contains(text(),'Saturday')]"))
				.getText();
		Assert.assertEquals(Saturday, "Saturday");
		System.out.println("Saturday is Varified Successfully");

		String SH = driver.findElement(By.xpath("//h2[contains(text(),'Special Hours')]")).getText();
		Assert.assertEquals(SH, "SPECIAL HOURS");
		System.out.println("Special Hours Tab is Varified Successfully");

		String NH = driver.findElement(By.xpath("//span[contains(text(),'New Hours')]")).getText();
		Assert.assertTrue(NH.contains("NEW HOURS"));
		System.out.println("New Hours is Varified Successfully");

		String Open = driver.findElement(By.xpath("/descendant::div[contains(text(),'Open')][1]")).getText();
		Assert.assertEquals(Open, "Open");
		System.out.println("Open is Varified Successfully");

		String OD = driver.findElement(By.xpath("//div[contains(text(),'Opening Date')]")).getText();
		Assert.assertEquals(OD, "Opening Date");
		System.out.println("Opening Date is Varified Successfully");

		String CD = driver.findElement(By.xpath("//div[contains(text(),'Closing Date')]")).getText();
		Assert.assertEquals(CD, "Closing Date");
		System.out.println("Closing Date is Varified Successfully");

	}

	public void VerifyOfferingTab() {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Offering);

		String Brands = driver.findElement(By.xpath("//div[contains(@class,'brands-container group-block-main sc-')]//div[contains(text(),'Brands')]")).getText();
		Assert.assertEquals(Brands, "Brands");
		System.out.println("Brands Varified Successfully");

		String Services = driver.findElement(By.xpath("//div[contains(text(),'Services')]")).getText();
		Assert.assertEquals(Services, "Services");
		System.out.println("Services Varified Successfully");

		String Products = driver.findElement(By.xpath("//div[contains(text(),'Products')]")).getText();
		Assert.assertEquals(Products, "Products");
		System.out.println("Products Varified Successfully");

		String Specialties = driver.findElement(By.xpath("//div[contains(text(),'Specialties')]")).getText();
		Assert.assertEquals(Specialties, "Specialties");
		System.out.println("Specialties Varified Successfully");

		String Organizations = driver.findElement(By.xpath("//div[contains(text(),'Organizations')]")).getText();
		Assert.assertEquals(Organizations, "Organizations");
		System.out.println("Organizations Varified Successfully");

		String PM = driver.findElement(By.xpath("//div[contains(text(),'Payment Methods')]")).getText();
		Assert.assertEquals(PM, "Payment Methods");
		System.out.println("Payment Methods is Varified Successfully");
		
		String Discover = driver.findElement(By.xpath("//span[contains(text(),'Discover')]")).getText();
		Assert.assertEquals(Discover, "Discover");
		System.out.println("Discover Payment Method Varified Successfully");

		String Visa = driver.findElement(By.xpath("//span[contains(text(),'Visa')]")).getText();
		Assert.assertEquals(Visa, "Visa");
		System.out.println("Visa Payment Method Varified Successfully");

		String MasterCard = driver.findElement(By.xpath("//span[contains(text(),'MasterCard')]")).getText();
		Assert.assertEquals(MasterCard, "MasterCard");
		System.out.println("MasterCard Payment Method Varified Successfully");

		String AmericanExpress = driver.findElement(By.xpath("//span[contains(text(),'American Express')]")).getText();
		Assert.assertEquals(AmericanExpress, "American Express");
		System.out.println("American Express Payment Method Varified Successfully");

		String ApplePay = driver.findElement(By.xpath("//span[contains(text(),'Apple Pay')]")).getText();
		Assert.assertEquals(ApplePay, "Apple Pay");
		System.out.println("Apple Pay Payment Method Varified Successfully");

		String PayPal = driver.findElement(By.xpath("//span[contains(text(),'PayPal')]")).getText();
		Assert.assertEquals(PayPal, "PayPal");
		System.out.println("PayPal Payment Methods is Varified Successfully");
		
		String Check = driver.findElement(By.xpath("//span[contains(text(),'Check')]")).getText();
		Assert.assertEquals(Check, "Check");
		System.out.println("Check Payment Method Varified Successfully");

		String Cash = driver.findElement(By.xpath("//span[contains(text(),'Cash')]")).getText();
		Assert.assertEquals(Cash, "Cash");
		System.out.println("Cash Payment Method Varified Successfully");

		String AndroidPay = driver.findElement(By.xpath("//span[contains(text(),'Android Pay')]")).getText();
		Assert.assertEquals(AndroidPay, "Android Pay");
		System.out.println("Android Pay Payment Method Varified Successfully");

		String Bitcoin = driver.findElement(By.xpath("//span[contains(text(),'Bitcoin')]")).getText();
		Assert.assertEquals(Bitcoin, "Bitcoin");
		System.out.println("Bitcoin Payment Method Varified Successfully");

		String VPay = driver.findElement(By.xpath("//span[contains(text(),'V Pay')]")).getText();
		Assert.assertEquals(VPay, "V Pay");
		System.out.println("V Pay Payment Method Varified Successfully");

		String Invoice = driver.findElement(By.xpath("//span[contains(text(),'Invoice')]")).getText();
		Assert.assertEquals(Invoice, "Invoice");
		System.out.println("Invoice Payment Methods is Varified Successfully");
		
		String Financing = driver.findElement(By.xpath("//span[contains(text(),'Financing')]")).getText();
		Assert.assertEquals(Financing, "Financing");
		System.out.println("Financing Payment Method Varified Successfully");

		String DirectDebit = driver.findElement(By.xpath("//span[contains(text(),'Direct Debit')]")).getText();
		Assert.assertEquals(DirectDebit, "Direct Debit");
		System.out.println("Direct Debit payment Method Varified Successfully");

		String BankTransfer = driver.findElement(By.xpath("//span[contains(text(),'Bank Transfer')]")).getText();
		Assert.assertEquals(BankTransfer, "Bank Transfer");
		System.out.println("Bank Transfer Payment Method Varified Successfully");

		
		
		boolean Discover1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][3]")).isEnabled();
		
		boolean Visa1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][4]")).isEnabled();
		
		boolean MasterCard1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][5]")).isEnabled();
		
		boolean AmericanExpress1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][6]")).isEnabled();
		
		boolean ApplePay1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][7]")).isEnabled();
		
		boolean PayPal1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][8]")).isEnabled();
		
		boolean Check1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][9]")).isEnabled();
		
		boolean Cash1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][10]")).isEnabled();
		
		boolean AndroidPay1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][11]")).isEnabled();
		
		boolean Bitcoin1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][12]")).isEnabled();
		
		boolean VPay1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][13]")).isEnabled();
		
		boolean Invoice1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][14]")).isEnabled();
		
		boolean Financing1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][15]")).isEnabled();
		
		boolean DirectDebit1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][16]")).isEnabled();
		
		boolean BankTransfer1 = driver.findElement(By.xpath("/descendant::div[starts-with(@class,'ui-checkbox sc-')][17]")).isEnabled();
		
		
	}

	public void VerifyMediaTab() {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Media);
		String Photos = driver.findElement(By.xpath("//div[contains(text(),'Photos')]")).getText();
		Assert.assertTrue(Photos.contains("Photos"));
		System.out.println("Photos Varified Successfully");
		String Videos = driver.findElement(By.xpath("//div[contains(text(),'Videos')]")).getText();
		Assert.assertEquals(Videos, "Videos");
		System.out.println("Videos Varified Successfully");

	}

	public void VerifyCustomTab() {

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Custom);

		String DN = driver.findElement(By.xpath("//div[contains(text(),'Do Name')]")).getText();
		Assert.assertEquals(DN, "Do Name");
		System.out.println("Do Name Varified Successfully");

		String DE = driver.findElement(By.xpath("//div[contains(text(),'Do Email')]")).getText();
		Assert.assertEquals(DE, "Do Email");
		System.out.println("Do Email Varified Successfully");

		String RN = driver.findElement(By.xpath("//div[contains(text(),'RVP Name')]")).getText();
		Assert.assertEquals(RN, "RVP Name");
		System.out.println("RVP Name Varified Successfully");

		String RE = driver.findElement(By.xpath("//div[contains(text(),'RVP Email')]")).getText();
		Assert.assertEquals(RE, "RVP Email");
		System.out.println("RVP Email Varified Successfully");

	}

	public void VerifyFiltersNTabs() {

		String Name = driver.findElement(By.xpath("//a[@id='fltrOptName']")).getText();
		Assert.assertTrue(Name.contains("Name"));
		System.out.println("Name filter Varified Successfully");

		String Add1 = driver.findElement(By.xpath("//a[@id='fltrOptAddress 1']")).getText();
		Assert.assertTrue(Add1.contains("Address 1"));
		System.out.println("Address 1 Varified Successfully");

		String City = driver.findElement(By.xpath("//a[@id='fltrOptCity']")).getText();
		Assert.assertTrue(City.contains("City"));
		System.out.println("City Varified Successfully");

		String State = driver.findElement(By.xpath("//a[@id='fltrOptState']")).getText();
		Assert.assertTrue(State.contains("State"));
		System.out.println("State Varified Successfully");

		String PC = driver.findElement(By.xpath("//a[@id='fltrOptPostal Code']")).getText();
		Assert.assertTrue(PC.contains("Postal Code"));
		System.out.println("Postal Code Varified Successfully");

		/*
		 * String AF = driver.findElement(By.xpath("//a[@id='filterAdd']")).getText();
		 * Assert.assertTrue(AF.contains("+ Add Filters"));
		 * System.out.println("+Add Filters Varified Successfully");
		 */

		String Cancel = driver.findElement(By.xpath("/descendant::a[contains(text(),'Cancel')][7]")).getText();
		Assert.assertTrue(Cancel.contains("CANCEL"));
		System.out.println("Cancel Tab Varified Successfully");

		String CL = driver.findElement(By.xpath("//a[contains(text(),'Create Location')]")).getText();
		Assert.assertTrue(CL.contains("CREATE LOCATION"));
		System.out.println("Create Location Varified Successfully");

		/*
		 * JavascriptExecutor js2 = (JavascriptExecutor) driver; WebElement CANCEL =
		 * driver.findElement(By.xpath("/descendant::a[contains(text(),'Cancel')][7]"));
		 * js2.executeScript("arguments[0].click();", CANCEL);
		 */

	}

	public void LocationDetailsData() throws InterruptedException {
		Thread.sleep(1500);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Details);
		Thread.sleep(1500);

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupInfo-name sc-')]")).sendKeys("Brandify T3");

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupInfo-igniteClientKey sc-')]"))
				.sendKeys("Brandify #T3");

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

	public void clickOnCreateLocation() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Create Location')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void VerifydefaultFieldsforDetailsTab() throws InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//h3[contains(text(),'Brandify T3 #Brandify #T3')]")).click();

		Thread.sleep(2000);

		String BN = driver.findElement(By.xpath("//div[contains(text(),'Business Name')]")).getText();
		Assert.assertEquals(BN, "Business Name");
		System.out.println("Business Name is Varified Successfully");

		String CK = driver.findElement(By.xpath("//div[contains(text(),'Client Key')]")).getText();
		Assert.assertEquals(CK, "Client Key");
		System.out.println("Client Key is Varified Successfully");

		String AV = driver.findElement(By.xpath("//div[contains(text(),'Address Visible')]")).getText();
		Assert.assertEquals(AV, "Address Visible");
		System.out.println("Address Visible is Varified Successfully");

		String A1 = driver.findElement(By.xpath("//div[contains(text(),'Address 1')]")).getText();
		Assert.assertEquals(A1, "Address 1");
		System.out.println("Address 1 is Varified Successfully");

		String A2 = driver.findElement(By.xpath("//div[contains(text(),'Address 2')]")).getText();
		Assert.assertEquals(A2, "Address 2");
		System.out.println("Address 2 is Varified Successfully");

		String City = driver.findElement(By.xpath("/descendant::div[contains(text(),'City')][1]")).getText();
		Assert.assertEquals(City, "City");
		System.out.println("City is Varified Successfully");

		String State = driver.findElement(By.xpath("/descendant::div[contains(text(),'State')][1]")).getText();
		Assert.assertEquals(State, "State");
		System.out.println("State is Varified Successfully");

		String PC = driver.findElement(By.xpath("//div[contains(text(),'Postal Code')]")).getText();
		Assert.assertEquals(PC, "Postal Code");
		System.out.println("Postal Code is Varified Successfully");

		String County = driver.findElement(By.xpath("//div[contains(text(),'County')]")).getText();
		Assert.assertEquals(County, "County");
		System.out.println("County is Varified Successfully");

		String Country = driver.findElement(By.xpath("//div[contains(text(),'Country')]")).getText();
		Assert.assertEquals(Country, "Country");
		System.out.println("Country is Varified Successfully");

		String Sublocality = driver.findElement(By.xpath("//div[contains(text(),'Sublocality')]")).getText();
		Assert.assertEquals(Sublocality, "Sublocality");
		System.out.println("Sublocality is Varified Successfully");

		String PN = driver.findElement(By.xpath("//div[contains(text(),'Phone Number')]")).getText();
		Assert.assertEquals(PN, "Phone Number");
		System.out.println("Phone Number is Varified Successfully");

		String AP = driver.findElement(By.xpath("//div[contains(text(),'Alternate Phone')]")).getText();
		Assert.assertEquals(AP, "Alternate Phone");
		System.out.println("Alternate Phone is Varified Successfully");

		String TFP = driver.findElement(By.xpath("//div[contains(text(),'Toll-Free Phone')]")).getText();
		Assert.assertEquals(TFP, "Toll-Free Phone");
		System.out.println("Toll-Free Phone is Varified Successfully");

		String FN = driver.findElement(By.xpath("//div[contains(text(),'Fax Number')]")).getText();
		Assert.assertEquals(FN, "Fax Number");
		System.out.println("Fax Number is Varified Successfully");

		String IP = driver.findElement(By.xpath("//div[contains(text(),'International Phone')]")).getText();
		Assert.assertEquals(IP, "International Phone");
		System.out.println("International Phone is Varified Successfully");

		/*
		 * String PT =
		 * driver.findElement(By.xpath("//input[contains(@placeholder,'Phone Type')]")).
		 * getText(); Assert.assertEquals(PT, "Phone Type");
		 * System.out.println("Phone Type Tab is Displayed");
		 */

		String Tags = driver.findElement(By.xpath("//div[contains(text(),'Tags')]")).getText();
		Assert.assertEquals(Tags, "Tags");
		System.out.println("Tags Tab is Displayed");

		String Relationship = driver.findElement(By.xpath("//div[contains(text(),'Relationship')]")).getText();
		Assert.assertEquals(Relationship, "Relationship");
		System.out.println("Relationship Tab is Displayed");

	}

	public void VerifydefaultFieldsforMapTab() throws InterruptedException {
		Thread.sleep(2000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Map);

		String SLN = driver.findElement(By.xpath("/descendant::div[contains(text(),'Brandify')][3]")).getText();
		Assert.assertTrue(SLN.contains("Brandify"));
		System.out.println("Store Location is Varified Successfully");

	}

	public void VerifydefaultFieldsforSEOTab() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", SEO);

		String Keywords = driver.findElement(By.xpath("//form//div[contains(text(),'Keywords')]")).getText();
		Assert.assertEquals(Keywords, "Keywords");
		System.out.println("Keywords is Varified Successfully");

		String WL = driver.findElement(By.xpath("//div[contains(text(),'Website Links')]")).getText();
		Assert.assertEquals(WL, "Website Links");
		System.out.println("Website Links is Varified Successfully");

		String SD = driver.findElement(By.xpath("//div[contains(text(),'Short Description')]")).getText();
		Assert.assertEquals(SD, "Short Description");
		System.out.println("Short Description is Varified Successfully");

		String LD = driver.findElement(By.xpath("//div[contains(text(),'Long Description')]")).getText();
		Assert.assertEquals(LD, "Long Description");
		System.out.println("Long Description is Varified Successfully");

		String History = driver.findElement(By.xpath("//div[contains(text(),'History')]")).getText();
		Assert.assertEquals(History, "History");
		System.out.println("History is Varified Successfully");

		String CE = driver.findElement(By.xpath("//div[contains(text(),'Contact Emails')]")).getText();
		Assert.assertEquals(CE, "Contact Emails");
		System.out.println("Contact Emails is Varified Successfully");
	}

	public void VerifydefaultFieldsforHoursTab() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Hours);

		String RH = driver.findElement(By.xpath("//div[contains(text(),'Regular Hours')]")).getText();
		Assert.assertEquals(RH, "REGULAR HOURS");
		System.out.println("Regular Hours is Varified Successfully");

		String Sunday = driver.findElement(By.xpath("//div[@class='day'][contains(text(),'Sunday')]")).getText();
		Assert.assertEquals(Sunday, "Sunday");
		System.out.println("Sunday is Varified Successfully");

		String Monday = driver.findElement(By.xpath("//div[@class='day'][contains(text(),'Monday')]")).getText();
		Assert.assertEquals(Monday, "Monday");
		System.out.println("Monday is Varified Successfully");

		String Tuesday = driver.findElement(By.xpath("//div[@class='day'][contains(text(),'Tuesday')]")).getText();
		Assert.assertEquals(Tuesday, "Tuesday");
		System.out.println("Tuesday is Varified Successfully");

		String Wednesday = driver.findElement(By.xpath("//div[@class='day'][contains(text(),'Wednesday')]")).getText();
		Assert.assertEquals(Wednesday, "Wednesday");
		System.out.println("Wednesday is Varified Successfully");

		String Thursday = driver.findElement(By.xpath("//div[@class='day'][contains(text(),'Thursday')]")).getText();
		Assert.assertEquals(Thursday, "Thursday");
		System.out.println("Thursday is Varified Successfully");

		String Friday = driver.findElement(By.xpath("//div[@class='day'][contains(text(),'Friday')]")).getText();
		Assert.assertEquals(Friday, "Friday");
		System.out.println("Friday is Varified Successfully");

		String Saturday = driver.findElement(By.xpath("//div[@class='day'][contains(text(),'Saturday')]")).getText();
		Assert.assertEquals(Saturday, "Saturday");
		System.out.println("Saturday is Varified Successfully");

		String SH = driver.findElement(By.xpath("//h2[contains(text(),'Special Hours')]")).getText();
		Assert.assertEquals(SH, "SPECIAL HOURS");
		System.out.println("Special Hours Tab is Varified Successfully");

		String Open = driver.findElement(By.xpath("/descendant::div[contains(text(),'Open')][1]")).getText();
		Assert.assertEquals(Open, "Open");
		System.out.println("Open is Varified Successfully");

		String OD = driver.findElement(By.xpath("//div[contains(text(),'Opening Date')]")).getText();
		Assert.assertEquals(OD, "Opening Date");
		System.out.println("Opening Date is Varified Successfully");

		String CD = driver.findElement(By.xpath("//div[contains(text(),'Closing Date')]")).getText();
		Assert.assertEquals(CD, "Closing Date");
		System.out.println("Closing Date is Varified Successfully");
		}

	public void VerifydefaultFieldsforOfferingsTab() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Offering);

		String Brands = driver.findElement(By.xpath("//div[contains(@class,'brands-container group-block-main sc-')]//div[contains(text(),'Brands')]")).getText();
		Assert.assertEquals(Brands, "Brands");
		System.out.println("Brands Varified Successfully");

		String Services = driver.findElement(By.xpath("//div[contains(text(),'Services')]")).getText();
		Assert.assertEquals(Services, "Services");
		System.out.println("Services Varified Successfully");

		String Products = driver.findElement(By.xpath("//div[contains(text(),'Products')]")).getText();
		Assert.assertEquals(Products, "Products");
		System.out.println("Products Varified Successfully");

		String Specialties = driver.findElement(By.xpath("//div[contains(text(),'Specialties')]")).getText();
		Assert.assertEquals(Specialties, "Specialties");
		System.out.println("Specialties Varified Successfully");

		String Organizations = driver.findElement(By.xpath("//div[contains(text(),'Organizations')]")).getText();
		Assert.assertEquals(Organizations, "Organizations");
		System.out.println("Organizations Varified Successfully");

		String PM = driver.findElement(By.xpath("//div[contains(text(),'Payment Methods')]")).getText();
		Assert.assertEquals(PM, "Payment Methods");
		System.out.println("Payment Methods is Varified Successfully");
	}

	public void VerifydefaultFieldsforMediaTab() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Media);

		String Photos = driver.findElement(By.xpath("//div[contains(text(),'Photos')]")).getText();
		Assert.assertTrue(Photos.contains("Photos"));
		System.out.println("Photos Varified Successfully");

		String Videos = driver.findElement(By.xpath("//div[contains(text(),'Videos')]")).getText();
		Assert.assertEquals(Videos, "Videos");
		System.out.println("Videos Varified Successfully");
	}

	public void VerifydefaultFieldsforProfileURLsTab() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", ProfileURL);

		String PU = driver.findElement(By.xpath("//h2[contains(text(),'Profile Url')]")).getText();
		Assert.assertEquals(PU, "PROFILE URL");
		System.out.println("Profile Url Tab Varified Successfully");

	} 

	public void VerifydefaultFieldsforCustomsTab() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Custom);

		String DN = driver.findElement(By.xpath("//div[contains(text(),'Do Name')]")).getText();
		Assert.assertEquals(DN, "Do Name");
		System.out.println("Do Name Varified Successfully");

		String DE = driver.findElement(By.xpath("//div[contains(text(),'Do Email')]")).getText();
		Assert.assertEquals(DE, "Do Email");
		System.out.println("Do Email Varified Successfully");

		String RN = driver.findElement(By.xpath("//div[contains(text(),'RVP Name')]")).getText();
		Assert.assertEquals(RN, "RVP Name");
		System.out.println("RVP Name Varified Successfully");

		String RE = driver.findElement(By.xpath("//div[contains(text(),'RVP Email')]")).getText();
		Assert.assertEquals(RE, "RVP Email");
		System.out.println("RVP Email Varified Successfully");
	}

	public void VerifydefaultFieldsforHistoryTab() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", History);

		String USER = driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'User')]"))
				.getText();
		Assert.assertTrue(USER.contains("User"));
		System.out.println("User Name Varified Successfully");

		String DATE = driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Date')]"))
				.getText();
		Assert.assertTrue(DATE.contains("Date"));
		System.out.println("Date Varified Successfully");

		String FIELD = driver.findElement(By.xpath("//th[contains(text(),'Field')]")).getText();
		Assert.assertEquals(FIELD, "Field");
		System.out.println("Field Varified Successfully");

		String OLDVALUE = driver.findElement(By.xpath("//th[contains(text(),'Old Value')]")).getText();
		Assert.assertEquals(OLDVALUE, "Old Value");
		System.out.println("Old Value Varified Successfully");

		String NEWVALUE = driver.findElement(By.xpath("//th[contains(text(),'New Value')]")).getText();
		Assert.assertEquals(NEWVALUE, "New Value");
		System.out.println("New Value Varified Successfully");

	}

	public void VerifydefaultFieldsforInternalsTab() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", Internal);

		String LI = driver.findElement(By.xpath("//div[contains(text(),'Location ID')]")).getText();
		Assert.assertEquals(LI, "Location ID");
		System.out.println("Location ID Varified Successfully");

		String IS = driver.findElement(By.xpath("//div[contains(text(),'Ignite Schema')]")).getText();
		Assert.assertEquals(IS, "Ignite Schema");
		System.out.println("Ignite Schema Varified Successfully");

		String DC = driver.findElement(By.xpath("//div[contains(text(),'Date Created')]")).getText();
		Assert.assertEquals(DC, "Date Created");
		System.out.println("Date Created Varified Successfully");

		String DU = driver.findElement(By.xpath("//div[contains(text(),'Date Updated')]")).getText();
		Assert.assertEquals(DU, "Date Updated");
		System.out.println("Date Updated Varified Successfully");

		String DS = driver.findElement(By.xpath("//div[contains(text(),'Delete Status')]")).getText();
		Assert.assertEquals(DS, "Delete Status");
		System.out.println("Delete Status Varified Successfully");

		String DD = driver.findElement(By.xpath("//div[contains(text(),'Date Deleted')]")).getText();
		Assert.assertEquals(DD, "Date Deleted");
		System.out.println("Date Deleted is Varified Successfully");

		String DBU = driver.findElement(By.xpath("//div[contains(text(),'Deleted By User')]")).getText();
		Assert.assertEquals(DBU, "Deleted By User");
		System.out.println("Deleted By User Varified Successfully");

		String LSI = driver.findElement(By.xpath("//div[contains(text(),'Location State Id')]")).getText();
		Assert.assertEquals(LSI, "Location State Id");
		System.out.println("Location State Id Varified Successfully");
		
		WebElement ListingId = driver.findElement(By.xpath("/descendant::div[contains(text(),'Listing ID')][1]"));
		Assert.assertTrue(ListingId.isDisplayed());
		System.out.println("Location ID Varified Successfully");

		WebElement AR = driver.findElement(By.xpath("/descendant::div[contains(text(),'API Response')][1]"));
		Assert.assertTrue(AR.isDisplayed());
		System.out.println("API Responses Varified Successfully");

		WebElement DLI = driver.findElement(By.xpath("/descendant::div[contains(text(),'Distributor Listings ID')][1]"));
		Assert.assertTrue(DLI.isDisplayed());
		System.out.println("Distributors Listing Id Varified Successfully");

		WebElement DAI = driver.findElement(By.xpath("/descendant::div[contains(text(),'Distributor Account ID')][1]"));
		Assert.assertTrue(DAI.isDisplayed());
		System.out.println("Distributor Account Id Varified Successfully");

		WebElement CS = driver.findElement(By.xpath("/descendant::div[contains(text(),'Claim Status')][1]"));
		Assert.assertTrue(CS.isDisplayed());
		System.out.println("Claim Status Varified Successfully");

		WebElement FS = driver.findElement(By.xpath("/descendant::div[contains(text(),'Force Syndication')][1]"));
		Assert.assertTrue(FS.isDisplayed());
		System.out.println("Force Syndication Varified Successfully");

		WebElement UAF = driver.findElement(By.xpath("/descendant::div[contains(text(),'Update All Fields')][1]"));
		Assert.assertTrue(UAF.isDisplayed());
		System.out.println("Update All Fields Varified Successfully");

		WebElement ListingStatus = driver.findElement(By.xpath("/descendant::div[contains(text(),'Listing Status')][1]"));
		Assert.assertTrue(ListingStatus.isDisplayed());
		System.out.println("Listing Status Id Varified Successfully");
		
		WebElement ListingState = driver.findElement(By.xpath("/descendant::div[contains(text(),'Listing State')][1]"));
		Assert.assertTrue(ListingState.isDisplayed());
		System.out.println("Listing State Id Varified Successfully");
		

		System.out.println("...................................................................");	
		Thread.sleep(1500);
		List<WebElement> element = driver.findElements(By.xpath("//h2[starts-with(@class,'sc-')]"));
		System.out.println("Number of Providers Tile : " + element.size());
		//List<WebElement> element0 = driver.findElements(By.xpath("//form[@class='-form']"));
		
		for (int i = 0; i < element.size(); i++) {
			System.out.println("Providers List Present in Internals Tab : " + element.get(i).getText());
		
			/*for (int j=1; j< element0.size(); j++) {
				VerifydefaultFieldsforInternalsTab();
			}*/
			
			
		}
		System.out.println("...................................................................");	
		
		Thread.sleep(1500);
		List<WebElement> element1 = driver.findElements(By.xpath("//form[@class='-form']"));
		System.out.println("Number of Tiles Present on the Page : " + element1.size());
	    System.out.println("Data of Each Tile is Displayed................");
		for (int i = 0; i < element1.size(); i++) {
			System.out.println("Providers Data Present In Each Tile :  " + element1.get(i).getText());
		}
		System.out.println("...................................................................");
		
		}
		


	public void DeleteCreatedLocation() throws InterruptedException {

		Thread.sleep(3000);
		WebElement Delete = driver.findElement(By.xpath("//i[contains(text(),'delete')]"));
		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", Delete);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();

		Thread.sleep(3000);
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
