package com.b1.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;

  
public class HomePage extends TestBase {

	TestUtility testUtil = new TestUtility();

	@FindBy(xpath = "//i[contains(text(),'language')]")
	WebElement context;

	@FindBy(xpath = "//input[contains(@placeholder,'Select Accounts')]")
	WebElement selectAccounts;

	@FindBy(xpath = "//div[contains(text(),'Cheesecake Factory')]")
	WebElement ch;
	//div[contains(text(),'cheesecake')]
	@FindBy(xpath = "//div[contains(@class,'cs-resulttext sc-')][contains(text(),'All Locations')]")
	//@FindBy(xpath = "//span[contains(text(),'All Locations')]")
	WebElement AllLocation;
	
	@FindBy(xpath = "//div[contains(text(),'Restaurants')]")
	WebElement bj;

	@FindBy(xpath = "//div[contains(text(),'geostix2')]")
	WebElement geostix;
	
	@FindBy(xpath = "//div[contains(text(),'Brandify')]")
	WebElement Brandify;
	
	@FindBy(xpath = "//div[contains(text(),\"DICK'S Sporting Goods\")]")
	WebElement DSG;
	
	@FindBy(xpath = "//div[contains(text(),'Express Oil Change & Tire Engineers')]")
	WebElement EOCnTE;
	
	
	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnContextAndSelectCheesecake() {

		TestUtility.clickOn(driver, context, 30);
		TestUtility.clickOn(driver, selectAccounts, 20);
		TestUtility.clickOn(driver, ch, 20);
		TestUtility.clickOn(driver, AllLocation, 20);

	}

	public void clickOnContextAndSelectBJ() {

		TestUtility.clickOn(driver, context, 20);
		TestUtility.clickOn(driver, selectAccounts, 20);
		TestUtility.clickOn(driver, bj, 20);
		TestUtility.clickOn(driver, AllLocation, 20);

	}
	
	public void clickOnContextAndSelectGeostix() {

		TestUtility.clickOn(driver, context, 20);
		TestUtility.clickOn(driver, selectAccounts, 20);
		TestUtility.clickOn(driver, geostix, 20);
		TestUtility.clickOn(driver, AllLocation, 20);

	}

	public void clickOnContextAndBrandify() {
		TestUtility.clickOn(driver, context, 20);
		TestUtility.clickOn(driver, selectAccounts, 20);
		TestUtility.clickOn(driver, Brandify, 20);
		TestUtility.clickOn(driver, AllLocation, 20);
		
	}
	
	public void clickOnContextAndDSG() {

		TestUtility.clickOn(driver, context, 20);
		TestUtility.clickOn(driver, selectAccounts, 20);
		TestUtility.clickOn(driver, DSG, 20);
		TestUtility.clickOn(driver, AllLocation, 20);

	}
	
	
	public void clickOnContextAndEOCnTE() {

		TestUtility.clickOn(driver, context, 20);
		TestUtility.clickOn(driver, selectAccounts, 20);
		TestUtility.clickOn(driver, EOCnTE, 20);
		TestUtility.clickOn(driver, AllLocation, 20);

	}
}
