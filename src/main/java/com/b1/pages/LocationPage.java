package com.b1.pages;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.excel.utility.Xls_Reader1;
import com.b1.util.TestUtility;
 

public class LocationPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Name')]")
	WebElement Name;

	@FindBy(xpath = "//span[contains(text(),'Address 1')]")
	WebElement Address;

	@FindBy(xpath = "//span[contains(text(),'City')]")
	WebElement City;

	@FindBy(xpath = "//span[contains(text(),'State')]")
	WebElement State;

	@FindBy(xpath = "//span[contains(text(),'Postal Code')]")
	WebElement PostalCode;

	@FindBy(xpath = "//a[@id='filterAdd']")
	WebElement AddFilter;

	@FindBy(xpath = "//span[contains(text(),'ADD LOCATION')]")
	WebElement AddLocation;

	@FindBy(xpath = "//div[contains(text(),'SEO')]")
	WebElement SEO;

	@FindBy(xpath = "//input[contains(@placeholder,'Link Title')]")
	WebElement LinkTitle;

	@FindBy(xpath = "//input[@placeholder='Link']")
	WebElement Link;

	@FindBy(xpath = "//div[contains(text(),'Hours')]")
	WebElement Hours;

	@FindBy(xpath = "//div[contains(text(),'Offerings')]")
	WebElement Offerings;

	@FindBy(xpath = "//div[contains(text(),'Custom')]")
	WebElement Custom;

	@FindBy(xpath = "/descendant::div[contains(text(),'Map')][1]")
	WebElement Map;

	@FindBy(xpath = "//a[contains(text(),'Geocode')]")
	WebElement Geocode;

	@FindBy(xpath = "//div[contains(text(),'Media')]")
	WebElement Media;

	@FindBy(xpath = "//span[@id='desk']")
	WebElement Addmedia;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement Save;

	@FindBy(xpath = "/descendant::i[contains(text(),'add')][51]")
	WebElement Add;

	public LocationPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnLocationOVerview() throws Exception 
	{
		Thread.sleep(2000);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(location);
		actions.click().build().perform();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement overview = driver.findElement(By.xpath("//div[contains(text(),'Overview')]"));
		js.executeScript("arguments[0].click();", overview);
	}

	public void checkNameFilter() 
	{
		String nameFilter = driver.findElement(By.xpath("//span[contains(text(),'Name')]")).getAttribute("innerText");
		Assert.assertTrue(nameFilter.contains("Name"));
		System.out.println("Name Filter is present ==> " + nameFilter);
	}

	public void checkAddressFilter() 
	{
		String addressFilter = driver.findElement(By.xpath("//span[contains(text(),'Address 1')]"))
				.getAttribute("innerText");
		Assert.assertTrue(addressFilter.contains("Address 1"));
		System.out.println("Name Filter is present ==> " + addressFilter);
	}

	public void checkCityFilter() 
	{
		String cityFilter = driver.findElement(By.xpath("//span[contains(text(),'City')]")).getAttribute("innerText");
		Assert.assertTrue(cityFilter.contains("City"));
		System.out.println("Name Filter is present ==> " + cityFilter);
	}

	public void checkStateFilter() 
	{
		String stateFilter = driver.findElement(By.xpath("//span[contains(text(),'State')]")).getAttribute("innerText");
		Assert.assertTrue(stateFilter.contains("State"));
		System.out.println("Name Filter is present ==> " + stateFilter);
	}

	public void checkPostalCodeFilter() 
	{
		String postalCodeFilter = driver.findElement(By.xpath("//span[contains(text(),'Postal Code')]"))
				.getAttribute("innerText");
		Assert.assertTrue(postalCodeFilter.contains("Postal Code"));
		System.out.println("Name Filter is present ==> " + postalCodeFilter);
	}

	public void checkAddFilterFilter() 
	{
		String addFilter = driver.findElement(By.xpath("//a[@id='filterAdd']")).getAttribute("innerText");
		Assert.assertTrue(addFilter.contains("+ Add Filter"));
		System.out.println("Name Filter is present ==> " + addFilter);
	}

	public void checkSelectFilter() throws Exception 
	{
		TestUtility.clickOn(driver, AddFilter, 30);
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='adtlFiltOpts']"));
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		for (WebElement item : options) 
		{
			System.out.println("Dropdown values is ==> " + item.getText());
		}
	}

	public void clickAddLocation() 
	{
		TestUtility.clickOn(driver, AddLocation, 30);
	}

	public void LocationDetailsData() 
	{
		//Xls_Reader1 reader = new Xls_Reader1("/var/lib/jenkins/workspace/B1AutomationTest/src/main/java/com/b1/testdata/TestData.xlsx");
		Xls_Reader1 reader = new Xls_Reader1("E:\\workspace\\B1AutomationTesting\\src\\main\\java\\com\\b1\\qa\\testdata\\TestData.xlsx");

		String BusinessName = reader.getCellData("CreateLocationDetails", "Business Name", 2);
		System.out.println(BusinessName);

		String ClientKey = reader.getCellData("CreateLocationDetails", "Client Key", 2);
		System.out.println(ClientKey);

		String Address1 = reader.getCellData("CreateLocationDetails", "Address 1", 2);
		System.out.println(Address1);

		String Address2 = reader.getCellData("CreateLocationDetails", "Address 2", 2);
		System.out.println(Address2);

		String City = reader.getCellData("CreateLocationDetails", "City", 2);
		System.out.println(City);

		String State = reader.getCellData("CreateLocationDetails", "State", 2);
		System.out.println(State);

		String PostalCode = reader.getCellData("CreateLocationDetails", "Postal Code", 2);
		System.out.println(PostalCode);

		String PhoneNumber = reader.getCellData("CreateLocationDetails", "Phone Number", 2);
		System.out.println(PhoneNumber);

		driver.findElement(By.xpath("//input[contains(@class,'qa-groupInfo-name sc-')]")).sendKeys(BusinessName);

		driver.findElement(By.xpath("//input[contains(@class,'qa-groupInfo-igniteClientKey sc-')]"))
				.sendKeys(ClientKey);

		driver.findElement(By.xpath("//input[contains(@class,'qa-groupAddress-address1 sc-')]")).sendKeys(Address1);

		driver.findElement(By.xpath("//input[contains(@class,'qa-groupAddress-address2 sc-')]")).sendKeys(Address2);

		driver.findElement(By.xpath("//input[contains(@class,'qa-groupAddress-city sc-')]")).sendKeys(City);

		driver.findElement(By.xpath("//input[contains(@class,'qa-groupAddress-state sc-')]")).sendKeys(State);

		driver.findElement(By.xpath("//input[contains(@class,'qa-groupAddress-postalCode sc-')]")).sendKeys(PostalCode);

		driver.findElement(By.xpath("//input[@type='tel' and @name='main']")).sendKeys(PhoneNumber);
		
		WebElement Tag= driver.findElement(By.xpath("//input[contains(@placeholder,'Enter new tag...')]"));
		Assert.assertTrue(Tag.isEnabled());
		Tag.sendKeys("Store");
	}

	public void selectCountry() throws Exception 
	{

		/*
		 * driver.findElement(By.xpath("//body//div[@name='country']//div//div//div[2]")
		 * ).click(); Thread.sleep(2000); driver.findElement(By.
		 * xpath("//div[contains(text(),'United States of America')]")).click();
		 */

	}

	public void checkAllTabs() 
	{
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

		String CustomTab = driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).getAttribute("innerText");
		Assert.assertTrue(CustomTab.contains("Custom"));
		System.out.println("Custom Tab is present ==> " + CustomTab);
	}

	public void clickSEO() 
	{
		TestUtility.clickOn(driver, SEO, 30);
	}

	public void LocationSEOData() 
	{
		//Xls_Reader1 reader = new Xls_Reader1("/var/lib/jenkins/workspace/B1AutomationTest/src/main/java/com/b1/testdata/TestData.xlsx");
		
		Xls_Reader1 reader = new Xls_Reader1("E:\\workspace\\B1AutomationTesting\\src\\main\\java\\com\\b1\\qa\\testdata\\TestData.xlsx");

		String PrimaryCat = reader.getCellData("SEOLocationDetails", "Primary Category", 2);
		System.out.println(PrimaryCat);

		String SecondaryCat = reader.getCellData("SEOLocationDetails", "Secondary Categories", 2);
		System.out.println(SecondaryCat);

		String ShortDescription = reader.getCellData("SEOLocationDetails", "Short Description", 2);
		System.out.println(ShortDescription);

		String LongDescription = reader.getCellData("SEOLocationDetails", "Long Description", 2);
		System.out.println(LongDescription);

		String ContactEmails = reader.getCellData("SEOLocationDetails", "Contact Emails", 2);
		System.out.println(ContactEmails);

		driver.findElement(By.xpath("//input[contains(@placeholder,'Select Primary Category')]")).sendKeys(PrimaryCat);

		driver.findElement(By.xpath("//input[contains(@placeholder,'Select Category')]")).sendKeys(SecondaryCat);

		driver.findElement(By.xpath("//textarea[contains(@class,'qa-groupDesc-shortDescription sc-')]"))
				.sendKeys(ShortDescription);

		driver.findElement(By.xpath("//textarea[contains(@class,'qa-groupDesc-longDescription sc-')]"))
				.sendKeys(LongDescription);

		driver.findElement(By.xpath("//input[contains(@class,'qa-undefined-contactEmails[0].text sc-')]"))
				.sendKeys(ContactEmails);
	}

	public void addWebsiteLinks() throws Exception 
	{

		driver.findElement(By.xpath("//div[contains(@class,'qa-undefined-urlLinks[0].type sc-')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Facebook')]")).click();
		Thread.sleep(1000);
		LinkTitle.sendKeys("Facebook");
		Thread.sleep(1000);
		Link.sendKeys("http://www.facebook.com");
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//div[contains(@class,'additional-items')]/button[2]/div[1]/*[1]")).click();
	}

	public void clickHours() 
	{
		TestUtility.clickOn(driver, Hours, 30);
	}

	public void selectHours() 
	{

		Select dropdownValue = new Select(driver.findElement(
				By.xpath("//div[contains(@class,'list')]//div[1]//div[1]//div[1]//div[1]//div[1]//select[1]")));
		dropdownValue.selectByVisibleText("24hours");

		Select dropdownValue1 = new Select(driver
				.findElement(By.xpath("//div[@class='edit show']//div[2]//div[1]//div[1]//div[1]//div[1]//select[1]")));
		dropdownValue1.selectByVisibleText("Closed");

		// Select dropdownValue2 = new
		// Select(driver.findElement(By.xpath("//body//div[contains(@class,'create')]//div//div[3]//div[1]//div[1]//div[1]//div[1]//select[1]")));
		
		Select dropdownValue2 = new Select(driver.findElement(By.xpath(
				"//body//div[contains(@class,'edit show')]//div//div[3]//div[1]//div[1]//div[1]//div[1]//select[1]")));
		dropdownValue2.selectByVisibleText("Open");

		driver.findElement(By.xpath("//div[contains(@class,'range')]//div[1]//input[1]")).sendKeys("11:00");

		driver.findElement(By.xpath("//body//div[contains(@class,'list')]//div//div[3]//input[1]")).sendKeys("12:00");

		Select dropdownValue3 = new Select(
				driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[1]//div[1]//select[1]")));
		dropdownValue3.selectByVisibleText("Split");

		driver.findElement(By.name("name_Thursday_0")).sendKeys("Morning");

		driver.findElement(By.name("from_Thursday_0")).sendKeys("9:00");

		driver.findElement(By.name("to_Thursday_0")).sendKeys("1:00");

		driver.findElement(By.name("name_Thursday_1")).sendKeys("Evening");

		driver.findElement(By.name("from_Thursday_1")).sendKeys("4:00");

		driver.findElement(By.name("to_Thursday_1")).sendKeys("9:00");

	}

	public void selectSpecialHours() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'New Hours')]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickCalendar = driver
				.findElement(By.xpath("//div[contains(@class,'qa-undefined-holidayHours[0].date sc-')]"));
		js.executeScript("arguments[0].click();", clickCalendar);
		Thread.sleep(1000);
		/*
		 * WebElement clicknext = driver .findElement(By.
		 * xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']"
		 * )); clicknext.click();
		 */
		WebElement clickPre = driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']"));
		clickPre.click();
		
		driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Holiday");
		Thread.sleep(1000);
		WebElement clickDate = driver.findElement(By.xpath(
				"//div[@class='react-datepicker__day react-datepicker__day--tue'][contains(text(),'1')]"));
		js.executeScript("arguments[0].click();", clickDate);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'qa-undefined-holidayHours[0].status sc-')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Closed')]")).click();

		// Select dropdownValue3 = new
		// Select(driver.findElement(By.xpath("//select[contains(text(),'>')]")));
		// dropdownValue3.selectByVisibleText("Closed");
		//Open
		driver.findElement(By.xpath("//div[contains(@class,'qa-groupOpen-openStatus sc-')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Permanently Closed')]")).click();
		//Opening date
		driver.findElement(By.xpath("//div[contains(@class,'qa-groupOpen-openingDate sc-')]")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--fri')][contains(text(),'5')]")).click();
		
		//Closing Date
		driver.findElement(By.xpath("//div[contains(@class,'qa-groupOpen-closingDate sc-')]")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'25')]")).click();
	}
	
	public void VerifyHours() {
		String sun = driver.findElement(By.xpath("//div[contains(@class,'list')]//div[1]//div[1]//div[1]//div[1]//div[1]//select[1]")).getAttribute("value");
		Assert.assertTrue(sun.contains("24hours"));
		System.out.println("hours is present ==> " + sun);
		
		String mon = driver.findElement(By.xpath("//div[@class='edit show']//div[2]//div[1]//div[1]//div[1]//div[1]//select[1]")).getAttribute("value");
		Assert.assertTrue(mon.contains("Closed"));
		System.out.println("hours is present ==> " + mon);
		
		String tue = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[4]/form[1]/div/div[2]/div/div/div[3]/div/div/div/div[1]/select")).getAttribute("value");
		Assert.assertTrue(tue.contains("Open"));
		System.out.println("hours is present ==> " + tue);
		
		String tue1 = driver.findElement(By.xpath("//div[contains(@class,'range')]//div[1]//input[1]")).getAttribute("value");
		Assert.assertTrue(tue1.contains("11:00 am"));
		System.out.println("hours is present ==> " + tue1);
		
		String tue2 = driver.findElement(By.xpath("//body//div[contains(@class,'list')]//div//div[3]//input[1]")).getAttribute("value");
		Assert.assertTrue(tue2.contains("12:00 pm"));
		System.out.println("hours is present ==> " + tue2);
		
		String thur = driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[1]//div[1]//select[1]")).getAttribute("value");
		Assert.assertTrue(thur.contains("Split"));
		System.out.println("hours is present ==> " + thur);
}

	public void clickOfferings() {

		TestUtility.clickOn(driver, Offerings, 30);
	}

	public void LocationOfferingsData() {
		//Xls_Reader1 reader = new Xls_Reader1("/var/lib/jenkins/workspace/B1AutomationTest/src/main/java/com/b1/testdata/TestData.xlsx");
		
		Xls_Reader1 reader = new Xls_Reader1("E:\\workspace\\B1AutomationTesting\\src\\main\\java\\com\\b1\\qa\\testdata\\TestData.xlsx");

		String Brands = reader.getCellData("OfferingsLocationDetails", "Brands", 2);
		System.out.println(Brands);

		String Services = reader.getCellData("OfferingsLocationDetails", "Services", 2);
		System.out.println(Services);

		String Products = reader.getCellData("OfferingsLocationDetails", "Products", 2);
		System.out.println(Products);

		String Specialties = reader.getCellData("OfferingsLocationDetails", "Specialties", 2);
		System.out.println(Specialties);

		String Organizations = reader.getCellData("OfferingsLocationDetails", "Organizations", 2);
		System.out.println(Organizations);

		// driver.findElement(By.xpath("//input[@id='brands[0].text']")).sendKeys(Brands);
		driver.findElement(By.xpath("//input[contains(@class,'qa-undefined-brands[0].text sc-')]")).sendKeys(Brands);

		// driver.findElement(By.xpath("//input[@id='services[0].text']")).sendKeys(Services);
		driver.findElement(By.xpath("//input[contains(@class,'qa-undefined-services[0].text sc-')]"))
				.sendKeys(Services);

		// driver.findElement(By.xpath("//input[@id='products[0].text']")).sendKeys(Products);
		driver.findElement(By.xpath("//input[contains(@class,'qa-undefined-products[0].text sc-')]"))
				.sendKeys(Products);

		// driver.findElement(By.xpath("//input[@id='specialties[0].text']")).sendKeys(Specialties);
		driver.findElement(By.xpath("//input[contains(@class,'qa-undefined-specialties[0].text sc-')]"))
				.sendKeys(Specialties);

		// driver.findElement(By.xpath("//input[@id='organizations[0].text']")).sendKeys(Organizations);
		driver.findElement(By.xpath("//input[contains(@class,'qa-undefined-organizations[0].text sc-')]"))
				.sendKeys(Organizations);
		
		List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[7]/form[6]/div/div/div/div[2]/div"));
		System.out.println("Number of elements:" + elements.size());

		for (int i = 0; i < elements.size(); i++) {
		System.out.println("Tabs List is : " + elements.get(i).getText());
		}

		WebElement Card = driver.findElement(By.xpath("//span[contains(text(),'MasterCard')]"));
		Assert.assertTrue(Card.isEnabled());
		
		driver.findElement(By.xpath("//span[contains(text(),'MasterCard')]")).click();
		}
	
	public void ClickOnLocationMedia() 
	{
		//TestUtility.clickOn(driver, Media, 100);
		//driver.findElement(By.xpath("/descendant::div[contains(text(),'Media')][1]")).click();
		driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Media')]")).click();
	}
	
	public void VerifyLocationMedia() throws InterruptedException 
	{
		String photo = driver.findElement(By.xpath("//div[contains(text(),'Photos')]")).getText();
		Assert.assertEquals(photo, "Photos");

		String video = driver.findElement(By.xpath("//div[contains(text(),'Videos')]")).getText();
		Assert.assertEquals(video, "Videos");

		  WebElement edit = driver.findElement(By.xpath("//div[contains(text(),'Photos')]")); 
		  Actions actions = new Actions(driver); 
		  actions.moveToElement(edit);
		  actions.click().build().perform(); 
		  Thread.sleep(5000);
		 
		  //driver.findElement(By.xpath("//div[@class='sc-gwZsXD ewEtki']//div[@class='sc-chPdSV jfixXo']//i[contains(text(),'edit')]")).click();
		  // /descendant::i[contains(text(),'edit')][2]
		  JavascriptExecutor js = (JavascriptExecutor) driver; WebElement edit1 =
		  driver.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(text(),'edit')][2]"));
		  js.executeScript("arguments[0].click();", edit1);
		 
	}
	
	public void UploadImage() throws InterruptedException, IOException 
	{
		String addimage = driver.findElement(By.xpath("//span[@id='desk']")).getText();
		Assert.assertEquals(addimage, "+ ADD NEW IMAGE");

		TestUtility.clickOn(driver, Addmedia, 30);

		driver.findElement(By.xpath("//span[contains(text(),'Browse your Images')]")).click();

		Runtime.getRuntime().exec("E:\\Ajay Yadav\\AutoIT.exe");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("/descendant::input[contains(@name,'name')][6]")).clear();
		//driver.findElement(By.xpath("/descendant::input[contains(@name,'name')][6]")).sendKeys("Test");

		driver.findElement(By.xpath("//div[contains(text(),'Image Label')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='react-select-2--option-0']")).click();

		TestUtility.clickOn(driver, Save, 30);
	}
	
	public void VerifyUploadedImage() throws InterruptedException 
	{
		String image = driver.findElement(By.xpath("//p[contains(text(),'Approved')]")).getText();
		Assert.assertEquals(image, "Approved");

		driver.findElement(By.xpath("//span[contains(text(),'< Back to Location Details')]")).click();
		Thread.sleep(3000);

		TestUtility.clickOn(driver, Map, 30);

		TestUtility.clickOn(driver, Media, 30);

		driver.findElement(By.xpath("//input[contains(@placeholder,'Url')]")).sendKeys("www.Google.com");
		driver.findElement(By.xpath("//input[(@class='qa-undefined-videos[0].name sc-feJyhm hpBcrH')]")).sendKeys("Google");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Description')]")).sendKeys("Search Engine");

		driver.findElement(By.xpath("//div[@class='sc-dtmqqe kzoDQV']//div[@class='sc-jDwBTQ jMWwM']//div[2]")).click();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", Add);
		 */
		// TestUtility.clickOn(driver, Add, 30);

	}
	
	public void EditMedia() throws InterruptedException 
	{
		TestUtility.clickOn(driver, Map, 30);

		TestUtility.clickOn(driver, Media, 30);
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement cancel = driver.findElement(By.xpath("/descendant::i[contains(text(),'cancel')][11]"));
		js.executeScript("arguments[0].click();", cancel);

		WebElement edit = driver.findElement(By.xpath("//div[contains(text(),'Photos')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(edit);
		actions.click().build().perform();
		Thread.sleep(2000);
		
		// Edit1 xpath needs to be updated after every release
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement edit1 = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/div[8]/form[1]/div[1]/div[2]/div[1]"));
		js1.executeScript("arguments[0].click();", edit1);

		/*
		 * WebElement edit2 =
		 * driver.findElement(By.xpath("//div[contains(text(),'Logo')]")); Actions
		 * actions1 = new Actions(driver); actions1.moveToElement(edit2);
		 * actions1.build().perform(); Thread.sleep(2000);
		 * driver.findElement(By.xpath("/descendant::i[contains(text(),'more_vert')][2]"
		 * )).click();
		 */
		Thread.sleep(2000);
	}

	public void VerifyInputData() throws InterruptedException 
	{
		/*
		 * String ImageName = driver.findElement(By.xpath(
		 * "/descendant::div[contains(text(),'Batman.jpg')][2]")).getText();
		 * Assert.assertEquals(ImageName, "Batman.jpg");
		 * 
		 * String imageLabel =
		 * driver.findElement(By.xpath("/descendant::div[contains(text(),'Logo')][2]")).
		 * getText(); Assert.assertEquals(imageLabel, "Logo");
		 * 
		 * String UploadedBy =
		 * driver.findElement(By.xpath("//div[contains(text(),'Ignite')]")).getText();
		 * Assert.assertEquals(UploadedBy, "Ignite");
		 * 
		 * String Status =
		 * driver.findElement(By.xpath("//div[contains(text(),'Approved')]")).getText();
		 * Assert.assertEquals(Status, "Approved");
		 * 
		 * String edit =
		 * driver.findElement(By.xpath("//span[contains(text(),'Edit')]")).getText();
		 * Assert.assertEquals(edit, "EDIT");
		 * 
		 * String delete =
		 * driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).getText();
		 * Assert.assertEquals(delete, "DELETE");
		 */

		/*
		 * WebElement close =
		 * driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
		 * Assert.assertTrue(close.isDisplayed());
		 */

		/*
		 * driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//span[contains(text(),'Delete Image')]")).click
		 * (); Thread.sleep(3000);
		 */
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'< Back to Location Details')]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement cancel = driver.findElement(By.xpath("/descendant::i[contains(text(),'cancel')][10]"));
		js.executeScript("arguments[0].click();", cancel);

	}

	public void clickOCustom() 
	{

		TestUtility.clickOn(driver, Custom, 30);
	}

	public void LocationCustomData() 
	{
		//Xls_Reader1 reader = new Xls_Reader1("/var/lib/jenkins/workspace/B1AutomationTest/src/main/java/com/b1/testdata/TestData.xlsx");
		
		Xls_Reader1 reader = new Xls_Reader1("E:\\workspace\\B1AutomationTesting\\src\\main\\java\\com\\b1\\qa\\testdata\\TestData.xlsx");

		String DOEmail = reader.getCellData("CustomLocationDetails", "DO Email", 2);
		System.out.println(DOEmail);

		/*
		 * String DOName = reader.getCellData("CustomLocationDetails", "DO Name", 2);
		 * System.out.println(DOName);
		 */

		String RVPEmail = reader.getCellData("CustomLocationDetails", "RVP Email", 2);
		System.out.println(RVPEmail);

		String RVPName = reader.getCellData("CustomLocationDetails", "RVP Name", 2);
		System.out.println(RVPName);

		/*
		 * driver.findElement(By.
		 * xpath("//input[starts-with(@class,'qa-groupCustomProperties-doName sc-')]"))
		 * .sendKeys(DOName);
		 */

		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupCustomProperties-doEmail sc-')]"))
				.sendKeys(DOEmail);
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupCustomProperties-rvpName sc-')]"))
		.sendKeys(RVPName);
		
		driver.findElement(By.xpath("//input[starts-with(@class,'qa-groupCustomProperties-rvpEmail sc-')]"))
				.sendKeys(RVPEmail);	

	}

	public void checkDetailsData() {

		driver.findElement(By.xpath("//div[contains(text(),'Details')]")).click();

		String BusinessName = driver.findElement(By.xpath(" //input[contains(@class, 'qa-groupInfo-name sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(BusinessName.contains("Restaurant & Brewhouse"));
		System.out.println("BusinessName is present ==> " + BusinessName);

		String ClientKey = driver.findElement(By.xpath("//input[@value='111']")).getAttribute("value");
		Assert.assertTrue(ClientKey.contains("111"));
		System.out.println("ClientKey is present ==> " + ClientKey);

		String Address1 = driver.findElement(By.xpath("//input[@value='650 Bald Hill Rd']")).getAttribute("value");
		Assert.assertTrue(Address1.contains("650 Bald Hill Rd"));
		System.out.println("Address1 is present ==> " + Address1);

		String Address2 = driver.findElement(By.xpath("//input[@value='Ste C']")).getAttribute("value");
		Assert.assertTrue(Address2.contains("Ste C"));
		System.out.println("Address2 is present ==> " + Address2);

		String City = driver.findElement(By.xpath("//input[@value='Warwick']")).getAttribute("value");
		Assert.assertTrue(City.contains("Warwick"));
		System.out.println("City is present ==> " + City);

		String State = driver.findElement(By.xpath("//input[@value='RI']")).getAttribute("value");
		Assert.assertTrue(State.contains("RI"));
		System.out.println("State is present ==> " + State);

		String PostalCode = driver.findElement(By.xpath("//input[@value='2886']")).getAttribute("value");
		Assert.assertTrue(PostalCode.contains("2886"));
		System.out.println("PostalCode is present ==> " + PostalCode);

		String PhoneNumber = driver.findElement(By.xpath("//input[@type='tel' and @name='main']"))
				.getAttribute("value");
		Assert.assertTrue(PhoneNumber.contains("+1253-472-1220"));
		System.out.println("PhoneNumber is present ==> " + PhoneNumber);

	}

	public void VerifyLocationMap() {

		TestUtility.clickOn(driver, Map, 30);
		String geocode = driver.findElement(By.xpath("//a[contains(text(),'Geocode')]")).getText();
		Assert.assertEquals(geocode, "GEOCODE");

		WebElement Geocode = driver.findElement(By.xpath("//a[contains(text(),'Geocode')]"));
		Assert.assertTrue(Geocode.isEnabled());

		//TestUtility.clickOn(driver, Geocode, 30);
	}

	
	
	public void checkSEOdata() {

		TestUtility.clickOn(driver, SEO, 30);

		String PrimaryCat = driver.findElement(By.xpath("//input[contains(@placeholder,'Select Primary Category')]"))
				.getAttribute("value");
		// Assert.assertTrue(PrimaryCat.contains("Restaurant"));
		System.out.println("PrimaryCat is present ==> " + PrimaryCat);

		String SecondaryCat = driver.findElement(By.xpath("//input[contains(@placeholder,'Select Category')]"))
				.getAttribute("value");
		// Assert.assertTrue(SecondaryCat.contains("Pizza Restaurant"));
		System.out.println("SecondaryCat is present ==> " + SecondaryCat);

		String ShortDescription = driver.findElement(By.xpath("//textarea[contains(@class,'shortDescription')]"))
				.getAttribute("value");
		Assert.assertTrue(ShortDescription.contains("One-of-a-kind Brewhouse…"));
		System.out.println("ShortDescription is present ==> " + ShortDescription);

		String LongDescription = driver.findElement(By.xpath("//textarea[contains(@class,'longDescription')]"))
				.getAttribute("value");
		Assert.assertTrue(LongDescription.contains("Here at BJ’s Restaurant & Brewhouse…"));
		System.out.println("LongDescription is present ==> " + LongDescription);

		String ContactEmails = driver
				.findElement(By.xpath("//input[contains(@class,'qa-undefined-contactEmails[0].text sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(ContactEmails.contains("Test@Test.com"));
		System.out.println("ContactEmails is present ==> " + ContactEmails);

	}

	public void checkOfferingsdata() {

		TestUtility.clickOn(driver, Offerings, 30);

		String Brands = driver.findElement(By.xpath("//input[contains(@class,'qa-undefined-brands[0].text sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(Brands.contains("TestBrands"));
		System.out.println("Brands is present ==> " + Brands);

		String Services = driver.findElement(By.xpath("//input[contains(@class,'qa-undefined-services[0].text sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(Services.contains("TestServices"));
		System.out.println("Services is present ==> " + Services);

		String Products = driver.findElement(By.xpath("//input[contains(@class,'qa-undefined-products[0].text sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(Products.contains("Pizza"));
		System.out.println("Products is present ==> " + Products);

		String Specialties = driver
				.findElement(By.xpath("//input[contains(@class,'qa-undefined-specialties[0].text sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(Specialties.contains("TestSpecialties"));
		System.out.println("Specialties is present ==> " + Specialties);

		String Organizations = driver
				.findElement(By.xpath("//input[contains(@class,'qa-undefined-organizations[0].text sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(Organizations.contains("TestOrganizations"));
		System.out.println("Organizations is present ==> " + Organizations);
	}

	public void checkCustomdata() {

		TestUtility.clickOn(driver, Custom, 30);

		/*
		 * String DOName = driver.findElement(By.
		 * xpath("//input[contains(@class,'qa-groupCustomProperties-doName sc-')]"))
		 * .getAttribute("value"); Assert.assertTrue(DOName.contains("TesterOne"));
		 * System.out.println("DOName is present ==> " + DOName);
		 */

		String DOEmail = driver
				.findElement(By.xpath("//input[contains(@class,'qa-groupCustomProperties-doEmail sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(DOEmail.contains("testone@test.com"));
		System.out.println("DOEmail is present ==> " + DOEmail);

		String RVPName = driver
				.findElement(By.xpath("//input[contains(@class,'qa-groupCustomProperties-rvpName sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(RVPName.contains("TesterTwo"));
		System.out.println("RVPName is present ==> " + RVPName);

		String RVPEmail = driver
				.findElement(By.xpath("//input[contains(@class,'qa-groupCustomProperties-rvpEmail sc-')]"))
				.getAttribute("value");
		Assert.assertTrue(RVPEmail.contains("testtwo@test.com"));
		System.out.println("RVPEmail is present ==> " + RVPEmail);

	}

	public void clickOnCreateLocation() throws InterruptedException 
	{
		
		  WebElement element = driver .findElement(By.xpath("//div[contains(@class,'sc-')]//a[contains(text(),'Create Location')]"));
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();", element);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void checkNewAddedLocation() throws Exception {
		Thread.sleep(5000);
		driver.navigate().refresh();
		boolean NewLocation = driver
				.findElement(By.xpath("//h3[contains(text(),\"BJ's Restaurant & Brewhouse #111\")]")).isDisplayed();
		System.out.println("Newly Added Location is displayed " + NewLocation);

	}

	public void deleteLocation() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"locationSideBar\"]//div//h3[contains(text(),\"BJ's Restaurant & Brewhouse #111\")]")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//i[contains(text(),'delete')]")));
		// driver.findElement(By.xpath("//i[contains(text(),'delete')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
	}
	
	
	public void exportDataSetup() throws Exception {
		Thread.sleep(2000);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(location);
		actions.click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='moreFiltOpt']")));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='exportFiltOpt']")));
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//i[contains(text(),'check')]")));

	}

	public void exportReviewData() throws Exception {
		Thread.sleep(2000);
		String totalCount = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",
				driver.findElement(By.xpath("//div[starts-with(@class,'exportheader sc-')]")));
		System.out.println("Total Count for Export Review Data : " + totalCount);
		driver.findElement(By.xpath("//span[contains(text(),'Export')]")).click();
		Thread.sleep(17000);

	}

	public void readExportCSVData() throws Exception {
		Thread.sleep(20000);
		//Reader reader = Files.newBufferedReader(Paths.get("/var/lib/jenkins/workspace/B1AutomationTest/location_export.csv"));
		Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\Pramod\\Downloads\\location_export.csv"));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		
		for (CSVRecord csvRecord : csvParser) 
		{
			String location_id = csvRecord.get(0);
			String Clientkey = csvRecord.get(1);
			String name = csvRecord.get(2);
			String address = csvRecord.get(3);
			String address2 = csvRecord.get(4);
			String city = csvRecord.get(5);
			String state = csvRecord.get(6);
			String postalCode = csvRecord.get(7);
			
			System.out.println("Record No - " + csvRecord.getRecordNumber());
			System.out.println("---------------");
			System.out.println("location_id : " + location_id);
			System.out.println("Clientkey : " + Clientkey);
			System.out.println("name : " + name);
			System.out.println("address : " + address);
			System.out.println("address2 : " + address2);
			System.out.println("city : " + city);
			System.out.println("state : " + state);
			System.out.println("postalCode : " + postalCode);
			System.out.println("---------------\n\n");
		}
	}
}
