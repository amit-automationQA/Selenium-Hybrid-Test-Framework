package com.b1.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;

 

public class AccountsLocationGroupsPage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'Location Groups')]")
	WebElement locationGroup;

	@FindBy(xpath = "//button[contains(text(),'+ Add Location Group')]")
	WebElement AddLocationGroup;

	@FindBy(xpath = "//div[contains(text(),'Select Manually')]")
	WebElement selectManually;

	@FindBy(xpath = "//input[@name='locationGroupName']")
	WebElement locationGroupName;

	@FindBy(xpath = "//tr[2]//td[1]//input[1]")
	WebElement checkbox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//i[contains(text(),'delete')]")
	WebElement delete;

	@FindBy(xpath = "//button[@class='delete']")
	WebElement deleteLocationGroup;

	public AccountsLocationGroupsPage() {

		PageFactory.initElements(driver, this);

	}

	public void goToLocationGroupTab() throws Exception {

		TestUtility.clickOn(driver, locationGroup, 30);

	}

	public void clickOnAddLocationGroup() {

		TestUtility.clickOn(driver, AddLocationGroup, 30);
	}

	public void clickOnSelectManually() {

		TestUtility.clickOn(driver, selectManually, 30);
	}

	public void AddLocationGroupName() {
		driver.findElement(By.xpath("//tr[2]//td[1]//input[1]")).click();
		boolean checkbox = driver.findElement(By.xpath("//tr[2]//td[1]//input[1]")).isSelected();
		System.out.println("checkbox selected " + checkbox);
		locationGroupName.sendKeys("Tester123");
	}

	public void clickOnSubmit() {
		TestUtility.clickOn(driver, saveBtn, 30);

	}

	public void checkLocationGroupRecord() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptLocation Group Name']")).click();
		driver.findElement(By.xpath("//input[@id='fltrTxtInput']")).sendKeys("Tester123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::a[contains(text(),'Apply')][1]")).click();
		Thread.sleep(1000);
		String locationGroupRecord = driver.findElement(By.xpath("//td[contains(text(),'Tester123')]")).getText();
		System.out.println("Location Group Record is exists : " + locationGroupRecord);
		Assert.assertEquals(locationGroupRecord, "Tester123");
	}

	public void deleteRecord() throws Exception {
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//td[contains(text(),'Tester123')]/preceding-sibling::td//input[@type='checkbox']")).click();
		boolean checkbox = driver.findElement(By.xpath("//td[contains(text(),'Tester123')]/preceding-sibling::td//input[@type='checkbox']")).isSelected();
		System.out.println("checkbox selected " + checkbox);
		TestUtility.clickOn(driver, delete, 30);
		TestUtility.clickOn(driver, deleteLocationGroup, 30);

	}

}
