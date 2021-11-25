package com.b1.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.b1.base.TestBase;
 

public class StoreLocationSearch extends TestBase {

	HomePage homePage;

	@FindBy(xpath = "//div[contains(text(),'Cheesecake Factory')]")
	WebElement CheesecakeFactory;

	@FindBy(xpath = "//div[contains(text(),'Location Group')]")
	WebElement LocationGroup;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement SearchField;

	@FindBy(xpath = "//div[starts-with(@class,'cs-locations sc-')]//span[starts-with(@class,'cs-resulttext sc-')]")
	WebElement SearchedLocations;

	public StoreLocationSearch() {

		PageFactory.initElements(driver, this);
	}

	public void ClickOnCheesecake_AllLocations() throws Exception {

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", CheesecakeFactory);
		Thread.sleep(1000);

		jv.executeScript("arguments[0].click();", LocationGroup);
		Thread.sleep(1000);
	}

	public void ClickOnSearchField() throws InterruptedException {

		JavascriptExecutor jv = (JavascriptExecutor) driver;
		jv.executeScript("arguments[0].click();", SearchField);
		Thread.sleep(1000);

	}

	public void EnterSearchData() {

		SearchField.sendKeys("180");
		SearchField.sendKeys(Keys.ENTER);

	}

	public void VerifySearchedData() throws InterruptedException {

		List<WebElement> LocationElements = driver.findElements(By
				.xpath("//div[starts-with(@class,'cs-locations sc-')]//div[starts-with(@class,'cs-resulttext sc-')]"));
		Thread.sleep(1000);
		System.out.println("Number of Locations Present ====:> " + LocationElements.size());
		for (int i = 0; i < LocationElements.size(); i++) {
			System.out.println("Searched Location List have: " + LocationElements.get(i).getText());
		}

		Thread.sleep(1500);

		String SearchedLocation = driver
				.findElement(By.xpath(
						"//div[starts-with(@class,'cs-locations sc-')]//div[starts-with(@class,'cs-resulttext sc-')]"))
				.getText();
		// System.out.println("found=========> " + SearchedLocation);
		Assert.assertTrue(SearchedLocation.contains("180"));
		Thread.sleep(1500);

		List<WebElement> elements = driver.findElements(By
				.xpath("//div[starts-with(@class,'cs-locations sc-')]//div[starts-with(@class,'cs-resulttext sc-')]"));
		java.util.Iterator<WebElement> program = elements.iterator();
		while (program.hasNext()) {
			String values = program.next().getText();

			if (!values.equals("null")) {
				Assert.assertTrue(values.contains("180"));
				System.out.println("The Location Store Numbers ====> " + values);
			} else {
				System.out.println("Field is not display all the Programs defined for the provider ");
			}
		}
	}
}
