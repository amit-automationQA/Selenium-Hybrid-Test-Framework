package com.b1.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.excel.utility.Xls_Reader1;
import com.b1.util.TestUtility;
 

public class AccountsDetailsPage extends TestBase {

	TestUtility testUtil = new TestUtility();

	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile1;

	@FindBy(xpath = "//div[contains(text(),'Accounts')]")
	WebElement Account1;

	@FindBy(xpath = "//div[@class='title-block']")
	WebElement Contacts;

	@FindBy(xpath = "//span[contains(text(),'Add New Contact')]")
	WebElement AddNewContact;

	@FindBy(xpath = "//span[contains(text(),'Delete Contact')]")
	WebElement DeleteContact;

	@FindBy(xpath = "/descendant::span[contains(text(),'Update')]")
	// @FindBy(xpath = "/descendant::button[contains(text(),'Update')]")

	WebElement updateBtn;

	// @FindBy(xpath = "//div[@class='field'][contains(text(),'cheesecake')]")
	@FindBy(xpath = "//div[contains(text(),'cheesecake')]")
	WebElement detailsData;

	// @FindBy(xpath = "//div[@class='edit
	// show']//div[@class='label'][contains(text(),'Account Name')]")
	@FindBy(xpath = "//div[contains(text(),'Industry')]")
	WebElement accountNameLabelName;

	@FindBy(xpath = "//input[@value='cheesecake']")
	WebElement accountNameTextField;

	// @FindBy(xpath = "//div[@class='edit
	// show']//div[@class='label'][contains(text(),'Industry')]")
	@FindBy(xpath = "//div[contains(text(),'Industry')]")
	WebElement industryLabelName;

	// @FindBy(xpath = "//input[@name='industry']")
	@FindBy(xpath = "//input[contains(@class,'qa-groupDetails-industry sc-')]")
	WebElement industryTextField;

	// @FindBy(xpath = "//div[@class='edit
	// show']//div[@class='label'][contains(text(),'White Label')]")
	@FindBy(xpath = "//div[contains(text(),'White Label')]")
	WebElement whiteLabelName;

	// @FindBy(xpath = "//input[@name='whiteLabel']")
	@FindBy(xpath = "//input[contains(@class,'qa-groupDetails-whiteLabel sc-')]")
	WebElement whiteTextField;

	// @FindBy(xpath = "//div[@class='edit
	// show']//div[@class='label'][contains(text(),'Company Website')]")
	@FindBy(xpath = "//div[contains(text(),'Company Website')]")
	WebElement companyWebsiteLabelName;

	// @FindBy(xpath = "//input[@name='website']")
	@FindBy(xpath = "//input[contains(@class,'qa-groupDetails-website sc-')]")
	WebElement companyWebsiteTextField;

	@FindBy(xpath = "//div[contains(text(),'Account Type')]")
	WebElement accountTypeLabelName;

	// @FindBy(xpath = "//input[@name='accountType']")
	@FindBy(xpath = "//input[contains(@class,'qa-groupDetails-accountType sc-')]")
	WebElement accountTypeTextField;

	// @FindBy(xpath = "//div[@class='edit
	// show']//div[@class='label'][contains(text(),'Account Status')]")
	@FindBy(xpath = "//div[contains(text(),'Account Status')]")
	WebElement accountStatusLabelName;

	public AccountsDetailsPage() {

		PageFactory.initElements(driver, this);

	}

	public void goToAccountsPage() {
		TestUtility.clickOn(driver, MyProfile1, 30);
		TestUtility.clickOn(driver, Account1, 30);

	}

	public void AddDetailsData() throws Exception {

		//TestUtility.clickOn(driver, detailsData, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement DetailsEdit = driver.findElement(By.xpath("/descendant::i[contains(@class,'material-icons  sc-')][4]"));
		WebElement DetailsEdit = driver.findElement(By.xpath("//div[starts-with(@class,'groupDetails-edit-icon sc-')]"));
		js.executeScript("arguments[0].click();", DetailsEdit);

		industryTextField.sendKeys("Food Service");
		whiteTextField.sendKeys("White Label Test");
		companyWebsiteTextField.sendKeys("https://www.google.com");
		accountTypeTextField.sendKeys("Restaurant Test");
		driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();

	}

	public void clickOnContacts() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Contacts')]")).click();
		Thread.sleep(2000);// div[@class='array-json-list']//div[@class='title-block' and
							// contains(text(),'Contacts')]
		driver.findElement(By.xpath("//span[contains(text(),'Add New Contact')]")).click();
		// div[@class='array-json-list']//span[contains(text(),'Add New Contact')]

	}

	public void ContactsData() {
		//Xls_Reader1 reader = new Xls_Reader1("/var/lib/jenkins/workspace/B1AutomationTest/src/main/java/com/b1/testdata/TestData.xlsx");
		Xls_Reader1 reader = new Xls_Reader1("E:\\workspace\\B1AutomationTesting\\src\\main\\java\\com\\b1\\qa\\testdata\\TestData.xlsx");

		String JobTitle = reader.getCellData("Contacts", "JobTitle", 2);
		System.out.println(JobTitle);

		String FirstName = reader.getCellData("Contacts", "FirstName", 2);
		System.out.println(FirstName);

		String LastName = reader.getCellData("Contacts", "LastName", 2);
		System.out.println(LastName);

		String Address1 = reader.getCellData("Contacts", "Address1", 2);
		System.out.println(Address1);

		String Address2 = reader.getCellData("Contacts", "Address2", 2);
		System.out.println(Address2);

		String City = reader.getCellData("Contacts", "City", 2);
		System.out.println(City);

		String State = reader.getCellData("Contacts", "State", 2);
		System.out.println(State);

		String PostalCode = reader.getCellData("Contacts", "PostalCode", 2);
		System.out.println(PostalCode);

		String Country = reader.getCellData("Contacts", "Country", 2);
		System.out.println(Country);

		String ContactNotes = reader.getCellData("Contacts", "ContactNotes", 2);
		System.out.println(ContactNotes);

		String ContactEmail = reader.getCellData("Contacts", "ContactEmail", 2);
		System.out.println(ContactEmail);

		String Phone = reader.getCellData("Contacts", "Phone", 2);
		System.out.println(Phone);

		driver.findElement(By.name("contacts[0].title")).sendKeys(JobTitle);

		driver.findElement(By.name("contacts[0].firstName")).sendKeys(FirstName);

		driver.findElement(By.name("contacts[0].lastName")).sendKeys(LastName);

		driver.findElement(By.name("contacts[0].address1")).sendKeys(Address1);

		driver.findElement(By.name("contacts[0].address2")).sendKeys(Address2);

		driver.findElement(By.name("contacts[0].city")).sendKeys(City);

		driver.findElement(By.name("contacts[0].state")).sendKeys(State);

		driver.findElement(By.name("contacts[0].postalCode")).sendKeys(PostalCode);

		driver.findElement(By.name("contacts[0].country")).sendKeys(Country);

		driver.findElement(By.name("contacts[0].notes")).sendKeys(ContactNotes);

		driver.findElement(By.name("contacts[0].email")).sendKeys(ContactEmail);

		driver.findElement(By.name("contacts[0].phone")).sendKeys(Phone);

		TestUtility.clickOn(driver, updateBtn, 30);

	}

	public void checkAccountsTabs() {

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='account-tabs']"));
		System.out.println("Number of elements:" + elements.size());

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Accounts Tabs List : " + elements.get(i).getText());
		}

	}

	public void checkAllTabs() {

		String details = driver.findElement(By.xpath("//div[contains(text(),'Details')]")).getText();
		System.out.println("Tab name is ==> " + details);
		Assert.assertEquals(details, "Details");

		String locationGroups = driver.findElement(By.xpath("//div[contains(text(),'Location Groups')]")).getText();
		System.out.println("Tab name is ==> " + locationGroups);
		Assert.assertEquals(locationGroups, "Location Groups");

		String defaultFieldValues = driver.findElement(By.xpath("//div[contains(text(),'Default Field Values')]"))
				.getText();
		System.out.println("Tab name is ==> " + defaultFieldValues);
		Assert.assertEquals(defaultFieldValues, "Default Field Values");

		String customProp = driver.findElement(By.xpath("//div[contains(text(),'Custom Properties')]")).getText();
		System.out.println("Tab name is ==> " + customProp);
		Assert.assertEquals(customProp, "Custom Properties");

		String settings = driver.findElement(By.xpath("//div[contains(text(),'Settings')]")).getText();
		System.out.println("Tab name is ==> " + settings);
		Assert.assertEquals(settings, "Settings");

		String history = driver.findElement(By.xpath("//div[contains(text(),'History')]")).getText();
		System.out.println("Tab name is ==> " + history);
		Assert.assertEquals(history, "History");

		String entitlements = driver.findElement(By.xpath("//div[contains(text(),'Entitlements')]")).getText();
		System.out.println("Tab name is ==> " + entitlements);
		Assert.assertEquals(entitlements, "Entitlements");

		String internal = driver.findElement(By.xpath("//div[contains(text(),'Internal')]")).getText();
		System.out.println("Tab name is ==> " + internal);
		Assert.assertEquals(internal, "Internal");

		/*
		 * String photos =
		 * driver.findElement(By.xpath("//div[contains(text(),'Photos')]")).getText();
		 * System.out.println("Tab name is ==> " + photos); Assert.assertEquals(photos,
		 * "Photos");
		 */
	}

	public void checkAccountDetails() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String accountTitle = driver.findElement(By.xpath("//div[@class='account-main__title']")).getText();
		System.out.println("Account main title name is ==> " + accountTitle);
		Assert.assertEquals(accountTitle, "Account");
		Thread.sleep(3000);
		
		String accountclientName = driver.findElement(By.xpath("//div[@class='account-main__clientName'][contains(text(),'Cheesecake Factory')]")).getText();
		System.out.println("Account main client name is ==> " + accountclientName);
		Assert.assertEquals(accountclientName, "Cheesecake Factory");

		String accountclientWebsite = driver.findElement(By.xpath("//div[@class='account-main__clientWebsite']"))
				.getText();
		System.out.println("Account main clientWebsite name is ==> " + accountclientWebsite);
		Assert.assertEquals(accountclientWebsite, "The Cheesecake Factory Incorporated Client | www.thecheesecakefactory.com");
		String accountlocationTotal = driver.findElement(By.xpath("//div[@class='account-main__locations-total']"))
				.getText();
		System.out.println("Account main client location name is ==> " + accountlocationTotal);
		Assert.assertEquals(accountlocationTotal, "206 Locations");

		String accountlocationsGroups = driver.findElement(By.xpath("//div[@class='account-main__locations-groups']"))
				.getText();
		System.out.println("Account main client location group name is ==> " + accountlocationsGroups);
		//Assert.assertEquals(accountlocationsGroups, "62 Location Groups");

	}

	public void GoToDefaultFieldValuesTab() throws Exception {

		driver.findElement(By.xpath("//div[contains(text(),'Default Field Values')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Details')]")).click();

	}

	public void CheckDetailsData() throws Exception {
		Thread.sleep(3000);
		/*
		 * String accountNameLabelName = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement( By.
		 * xpath("//div[@class='normal show']//div[@class='label'][contains(text(),'Account Name')]"
		 * ))); System.out.println(accountNameLabelName);
		 * 
		 * String accountNameLabelName1 = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement(
		 * By.xpath("//div[@class='field'][contains(text(),'cheesecake')]")));
		 * System.out.println(accountNameLabelName1);
		 * 
		 * 
		 * String industryLabelName = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement( By.
		 * xpath("//div[@class='normal show']//div[@class='label'][contains(text(),'Industry')]"
		 * ))); System.out.println(industryLabelName);
		 * 
		 * String industryLabelName1 = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement(
		 * By.xpath("//div[contains(text(),'Food Service')]")));
		 * System.out.println(industryLabelName1);
		 * 
		 * String whiteLabelName = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement( By.
		 * xpath("//div[@class='normal show']//div[@class='label'][contains(text(),'White Label')]"
		 * ))); System.out.println(whiteLabelName);
		 * 
		 * String whiteLabelName1 = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement(
		 * By.xpath("//div[contains(text(),'White Label Test')]")));
		 * System.out.println(whiteLabelName1);
		 * 
		 * String companyWebsiteLabelName = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement( By.
		 * xpath("//div[contains(@class,'normal show')]//div[contains(@class,'label')][contains(text(),'Company Website')]"
		 * ))); System.out.println(companyWebsiteLabelName);
		 * 
		 * String companyWebsiteLabelName1 = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement(
		 * By.xpath("//div[contains(text(),'https://www.google.com')]")));
		 * System.out.println(companyWebsiteLabelName1);
		 * 
		 * String accountTypeLabelName = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement( By.
		 * xpath("//div[contains(@class,'normal show')]//div[contains(@class,'label')][contains(text(),'Account Type')]"
		 * ))); System.out.println(accountTypeLabelName);
		 * 
		 * String accountTypeLabelName1 = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement(
		 * By.xpath("//div[contains(text(),'Restaurant')]")));
		 * System.out.println(accountTypeLabelName1);
		 * 
		 * String accountStatusLabelName = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement( By.
		 * xpath("//div[contains(@class,'normal show')]//div[contains(@class,'label')][contains(text(),'Account Status')]"
		 * ))); System.out.println(accountStatusLabelName);
		 * 
		 * String accountStatusLabelName1 = (String) ((JavascriptExecutor) driver)
		 * .executeScript("return arguments[0].innerText;", driver.findElement(
		 * By.xpath("//div[contains(@class,'field')][contains(text(),'Live')]")));
		 * System.out.println(accountStatusLabelName1);
		 */

		System.out.println("The Details Field Names Are: \n");
		String ACName = accountNameLabelName.getText();
		System.out.println(ACName);

		String WLName = whiteLabelName.getText();
		System.out.println(WLName);

		String WSName = companyWebsiteLabelName.getText();
		System.out.println(WSName);

		String ACTName = accountTypeLabelName.getText();
		System.out.println(ACTName);

		String ACSName = accountStatusLabelName.getText();
		System.out.println(ACSName);

	}

	public void clearDetailsData() throws InterruptedException {
		// TestUtility.clickOn(driver, detailsData, 30);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//WebElement DetailsEdit = driver.findElement(By.xpath("/descendant::i[contains(@class,'material-icons  sc-')][4]"));
		WebElement DetailsEdit = driver.findElement(By.xpath("//div[starts-with(@class,'groupDetails-edit-icon sc-')]"));
		js1.executeScript("arguments[0].click();", DetailsEdit);
		/*
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 * driver.findElement(By.xpath("//input[contains(@value,'Food Service')]")).
		 * clear();
		 * driver.findElement(By.xpath("//input[contains(@value,'White Label Test')]")).
		 * clear(); driver.findElement(By.xpath(
		 * "//input[contains(@value,'https://www.google.com')]")).clear();
		 * driver.findElement(By.xpath("//input[contains(@value,'Restaurant Test')]")).
		 * clear();
		 */
		
		  //industryTextField.clear();
		  Thread.sleep(1);
		  industryTextField.sendKeys(Keys.CONTROL + "a");
		  industryTextField.sendKeys(Keys.DELETE);
		  
		 // whiteTextField.clear(); 
		  
		  whiteTextField.sendKeys(Keys.CONTROL + "a");
		  whiteTextField.sendKeys(Keys.DELETE);
		  
		 // companyWebsiteTextField.clear();
		  companyWebsiteTextField.sendKeys(Keys.CONTROL + "a");
		  companyWebsiteTextField.sendKeys(Keys.DELETE);
		  
		 // accountTypeTextField.clear(); 
		  accountTypeTextField.sendKeys(Keys.CONTROL + "a");
		  accountTypeTextField.sendKeys(Keys.DELETE);
		  
		driver.findElement(By.xpath("/descendant::button[contains(text(),'Update')]")).click();
	}

	public void CheckContactsData() throws Exception {
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//
		// button[@type='submit']//div//div//span[contains(text(),'Update')]")).click();
		// Thread.sleep(3000); //
		// button[@type='submit']//div//div//span[contains(text(),'Update')]
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='array-block']"));
		System.out.println("Number of elements:" + elements.size());

		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Contacts Records List : " + elements.get(i).getText());
		}
	}

	public void deleteContact() {

		driver.findElement(By.xpath("//label[contains(text(),'Postal Code')]")).click();

		TestUtility.clickOn(driver, DeleteContact, 30);
		TestUtility.clickOn(driver, updateBtn, 30);

	}

}
