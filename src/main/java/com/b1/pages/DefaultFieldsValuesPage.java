package com.b1.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;
import com.google.inject.Key;

 

public class DefaultFieldsValuesPage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'Default Field Values')]")
	WebElement defaultFieldValuesTab;

	@FindBy(xpath = "//div[contains(@class,'show sc-')]")
	WebElement enableFields;

	@FindBy(xpath = "//input[@placeholder='Select Master Category']")
	WebElement SelectMasterCat;

	@FindBy(xpath = "//div[contains(text(),'facebook')]")
	WebElement SelectFB;

	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement updateBtn;

	@FindBy(xpath = "//div[contains(@class,'bho-items')]//div[1]//div[2]//div[1]")
	WebElement RegularHours;

	public DefaultFieldsValuesPage() {

		PageFactory.initElements(driver, this);
	}

	public void clickOnDefaultFieldsValuesPage() {

		TestUtility.clickOn(driver, defaultFieldValuesTab, 30);
	}

	public void SelectMasterCat() throws Exception {

		// TestUtility.clickOn(driver, enableFields, 30);
		// driver.findElement(By.xpath("//input[@placeholder='Select Master
		// Category']")).sendKeys("google");
		// driver.findElement(By.xpath("//div[@class='sc-kGeDwz
		// crFUqw']//div[1]//div[2]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickED = driver.findElement(By.xpath("/descendant::i[contains(@class,'material-icons  sc-')][8]"));
		js.executeScript("arguments[0].click();", clickED);
		System.out.println("Successfully Clicked on Edit Button");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")).sendKeys("go");
		Actions action = new Actions(driver);
		WebElement location = driver.findElement(By.xpath("//div[contains(text(),'google')]"));
		action.moveToElement(location).build().perform();
		action.moveToElement(location).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'google')]")).click();
		Thread.sleep(2000);
		TestUtility.clickOn(driver, updateBtn, 30);
	}

	public void selectHours() throws Exception {
		TestUtility.clickOn(driver, RegularHours, 30);

		Select dropdownValue = new Select(driver.findElement(
				By.xpath("//div[contains(@class,'list')]//div[1]//div[1]//div[1]//div[1]//div[1]//select[1]")));
		dropdownValue.selectByVisibleText("24hours");

		Select dropdownValue1 = new Select(driver
				.findElement(By.xpath("//div[@class='edit show']//div[2]//div[1]//div[1]//div[1]//div[1]//select[1]")));

		dropdownValue1.selectByVisibleText("Closed");

		Select dropdownValue2 = new Select(
				driver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//div[1]//select[1]")));
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
		TestUtility.clickOn(driver, updateBtn, 30);
	}

	public void selectSpecialHours() throws Exception {
		Thread.sleep(3000);

		// driver.findElement(By.xpath("/descendant::i[contains(@class,'material-icons
		// sc-')][10]")).click();
		// driver.findElement(By.xpath("//div[@class='normal
		// show']//div[@class='special-hour-items']")).click();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement clickSH = driver.findElement(By.xpath("/descendant::i[contains(@class,'material-icons  sc-')][10]"));
		js1.executeScript("arguments[0].click();", clickSH);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'New Hours')]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::input[@placeholder='Title'][2]")).sendKeys("Holiday");
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickCalendar = driver
				.findElement(By.xpath("//div[contains(@class,'qa-undefined-specialHours[1].date sc-')]"));
		js.executeScript("arguments[0].click();", clickCalendar);

		Thread.sleep(1000);
		String setDatestr="19/06/2019";//MMDDYYYY
		String currentDatestr = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month'][contains(text(),'February 2021')]"))
				.getText();//MMM YYY
		Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
		Date currentDate=new SimpleDateFormat("MMM yyyy").parse(currentDatestr);
		int monthDiff = Months.monthsBetween(new DateTime(currentDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
		boolean isFuture=true;
		if(monthDiff<0) {
			isFuture=false;
			monthDiff = -1 * monthDiff;
		}
		for(int i=0; i<monthDiff; i++) {
			if(isFuture)
				driver.findElement(
						By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']"))
						.click();
						
			else
				driver.findElement(By.xpath(
						"//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']"))
						.click();
			
		}
		
 
		WebElement clickDate = driver.findElement(
				By.xpath("//div[@class='react-datepicker__day react-datepicker__day--wed'][contains(text(),'19')]"));
		js.executeScript("arguments[0].click();", clickDate);

		driver.findElement(By.xpath("//div[contains(@class,'[1].status sc-')]//div[contains(text(),'Select...')]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/descendant::div[contains(@class,'sc-')][contains(text(),'Closed')][2]")).click();

		/*
		 * Select dropdownValue3 = new
		 * Select(driver.findElement(By.xpath("//div[contains(text(),'Select')]")));
		 * dropdownValue3.selectByVisibleText("Closed");
		 */
		TestUtility.clickOn(driver, updateBtn, 30);
	}

	public void ClearCategoryData() throws Exception {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickED = driver.findElement(By.xpath("/descendant::i[contains(@class,'material-icons  sc-')][8]"));
		js.executeScript("arguments[0].click();", clickED);

		WebElement MCategory = driver.findElement(By.xpath("//input[@placeholder='Select Master Category']"));
		MCategory.sendKeys(Keys.CONTROL + "a");
		MCategory.sendKeys(Keys.DELETE);

		// TestUtility.clickOn(driver, enableFields, 30);
		/*
		 * driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")
		 * ).sendKeys(Keys.BACK_SPACE);
		 * driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")
		 * ).sendKeys(Keys.BACK_SPACE);
		 * driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")
		 * ).sendKeys(Keys.BACK_SPACE);
		 * driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")
		 * ).sendKeys(Keys.BACK_SPACE);
		 * driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")
		 * ).sendKeys(Keys.BACK_SPACE);
		 * driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")
		 * ).sendKeys(Keys.BACK_SPACE);
		 * driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")
		 * ).sendKeys(Keys.BACK_SPACE);
		 * driver.findElement(By.xpath("//input[@placeholder='Select Master Category']")
		 * ).sendKeys(Keys.BACK_SPACE);
		 */

		WebElement updateButton = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", updateButton);
		Thread.sleep(2000);

	}

	public void ClearHoursData() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'24 hours')]")).click();
		Select dropdownValue = new Select(driver.findElement(
				By.xpath("//div[contains(@class,'list')]//div[1]//div[1]//div[1]//div[1]//div[1]//select[1]")));
		dropdownValue.selectByVisibleText("Closed");

		Select dropdownValue2 = new Select(
				driver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//div[1]//select[1]")));
		dropdownValue2.selectByVisibleText("Closed");

		Select dropdownValue3 = new Select(
				driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[1]//div[1]//select[1]")));
		dropdownValue3.selectByVisibleText("Closed");
		TestUtility.clickOn(driver, updateBtn, 30);

	}

	public void ClearSpecialHoursData() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement clickSH = driver.findElement(By.xpath("/descendant::i[contains(@class,'material-icons  sc-')][10]"));
		js1.executeScript("arguments[0].click();", clickSH);

		// driver.findElement(By.xpath("//div[@class='specialTitle']")).click();
		// driver.findElement(By.xpath("//div[contains(@class,'special-hours-edit')]//div//button[contains(@type,'button')]")).click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[2]/div/div[2]/div/div[3]/div/form[3]/div/div[1]/div/div[2]/div[1]/div"))
				.click();
		// TestUtility.clickOn(driver, updateBtn, 30);

	}

}
