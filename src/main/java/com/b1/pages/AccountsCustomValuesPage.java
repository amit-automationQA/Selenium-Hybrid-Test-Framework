package com.b1.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;

 

public class AccountsCustomValuesPage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'Custom Properties')]")
	WebElement CustomProp;

	@FindBy(xpath = "//a[contains(text(),'+ Add Custom Property')]")
	WebElement AddCustomProp;

	public AccountsCustomValuesPage() {

		PageFactory.initElements(driver, this);

	}

	public void checkAccountCustom() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String accountTitle = driver.findElement(By.xpath("//div[@class='account-main__title']")).getText();
		System.out.println("Account main title name is ==> " + accountTitle);
		Assert.assertEquals(accountTitle, "Account");
		Thread.sleep(2000);
		String accountclientName = driver.findElement(By.xpath("//div[@class='account-main__clientName']")).getText();
		System.out.println("Account main client name is ==> " + accountclientName);
		// Assert.assertEquals(accountclientName, "cheesecake");

		String accountclientWebsite = driver.findElement(By.xpath("//div[@class='account-main__clientWebsite']"))
				.getText();
		System.out.println("Account main clientWebsite name is ==> " + accountclientWebsite);
		// Assert.assertEquals(accountclientWebsite,
		// "The Cheesecake Factory Incorporated Client | www.thecheesecakefactory.com");

		String accountlocationTotal = driver.findElement(By.xpath("//div[@class='account-main__locations-total']"))
				.getText();
		System.out.println("Account main client location name is ==> " + accountlocationTotal);
		// Assert.assertEquals(accountlocationTotal, "202 Locations");

		String accountlocationsGroups = driver.findElement(By.xpath("//div[@class='account-main__locations-groups']"))
				.getText();
		System.out.println("Account main client location group name is ==> " + accountlocationsGroups);
		// Assert.assertEquals(accountlocationsGroups, "2 Location Groups");

	}

	public void goToCustomPropTab() throws Exception {

		TestUtility.clickOn(driver, CustomProp, 30);

	}

	public void CheckAddCustom() {

		TestUtility.clickOn(driver, AddCustomProp, 30);
	}

	public void AddCustomProperty() throws Exception {

		driver.findElement(By.xpath("//input[@placeholder='Display Name']")).sendKeys("Do ATest");
		driver.findElement(By.xpath("//input[@placeholder='Field Key']")).sendKeys("Test123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();

	}

	public void checkNewAddedCustomRecord() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

		String fieldName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
		System.out.println("Field Name is : " + fieldName);

		String key = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
		System.out.println("Key Name is : " + key);

		String fieldType = driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]")).getText();
		System.out.println("Field Type is : " + fieldType);

		String validType = driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]")).getText();
		System.out.println("Valid Type is : " + validType);

	}

	public void navigateToLocation() throws Exception 
	{
		Actions action = new Actions(driver);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'LOCATIONS')]"));
		action.moveToElement(location).build().perform();
		driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Overview sc-')][contains(text(),'Overview')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[1]//div[1]//div[1]//h3[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Custom')]")).click();
		Thread.sleep(6000);
	}

	public void checkAllLableNames() {
		
		String fieldName1 = driver.findElement(By.xpath("//div[contains(text(),'Do ATest')]")).getText();
		System.out.println("Field Name is : " + fieldName1);
		Assert.assertEquals("Do ATest", fieldName1);
		/*
		 * String key1 =
		 * driver.findElement(By.xpath("//div[contains(text(),'Test Boolean')]")).
		 * getText(); System.out.println("Key Name is : " + key1);
		 * //Assert.assertEquals("Test Boolean", fieldName1); String fieldType1 =
		 * driver.findElement(By.xpath("//div[contains(text(),'Test Select')]")).getText
		 * (); System.out.println("Field Type is : " + fieldType1);
		 * //Assert.assertEquals("Test Select", fieldName1); String validType1 =
		 * driver.findElement(By.xpath("//div[contains(text(),'Test Text')]")).getText()
		 * ; System.out.println("Valid Type is : " + validType1);
		 * //Assert.assertEquals("Test Text", fieldName1);
		 */		
	}
	
	public void deleteCustomProp() throws Exception {
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
	}

}
