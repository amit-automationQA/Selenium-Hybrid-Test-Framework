package com.b1.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.b1.base.TestBase;

public class ReviewFeed_Regress_Page extends TestBase{

	public ReviewFeed_Regress_Page() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnReviews() throws Exception {
		Thread.sleep(8000);
		WebElement Reviews = driver.findElement(By.xpath("//div[contains(text(),'REVIEWS')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(Reviews);
		actions.click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[contains(text(),'Reviews Feed')][1]")).click();
	}

	//Email as Review Summary:-C2277
	public void VerifyEmail_ReviewSummary() throws InterruptedException, ParseException {
		driver.findElement(By.xpath("//div[starts-with(@class,'button__email-icon sc-')]")).click();
		 Thread.sleep(5000);
		 
		 WebElement headingemail=driver.findElement(By.xpath("//div[contains(text(),'Share by Email')]"));
		 Assert.assertTrue(headingemail.isDisplayed());
		 Thread.sleep(1000);
		   WebElement schedule_new=driver.findElement(By.xpath("//div[contains(text(),'NEW SCHEDULE')]"));
			schedule_new.click();
			Thread.sleep(5000);
			WebElement saveas_field=driver.findElement(By.xpath("//input[@placeholder='Schedule Name']"));
			saveas_field.clear();
			saveas_field.sendKeys("ReviewTest");
			Thread.sleep(3000);
			WebElement email_field=driver.findElement(By.xpath("//input[@placeholder='Email addresses...']"));
			email_field.clear();
			email_field.sendKeys("ayadav");
			WebElement email_id=driver.findElement(By.xpath("//div[starts-with(@class,'tile-searchitem sc-')]"));
			email_id.click();
			Thread.sleep(3000);
			WebElement calender=driver.findElement(By.xpath("//div[contains(text(),'MM/DD/YYYY')]"));
			calender.click();
			Thread.sleep(2000);
			String setDatestr = "11/03/2021";// DDMMYYYY
			String currentDatestr = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText();// MMM YYY
			Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
			Date currentDate = new SimpleDateFormat("MMM yyyy").parse(currentDatestr);
			int monthDiff = Months
					.monthsBetween(new DateTime(currentDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1))
					.getMonths();
			boolean isFuture = true;
			if (monthDiff < 0) {
				isFuture = false;
				monthDiff = -1 * monthDiff;
			}
			for (int i = 0; i < monthDiff; i++) {
				if (isFuture)
					driver.findElement(By.xpath("//button[contains(text(),'Next month')]")).click();
				else
					 driver.findElement(By.xpath("//button[contains(text(),'Previous Month')]")).click();

			}
			driver.findElement(By.xpath("//div[contains(@aria-label,'day-11')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='HH:MM']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel 12 sc-')][contains(text(),'12')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel 00 sc-')][contains(text(),'00')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'AM')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'SAVE')]")).click();
			Thread.sleep(3000);
			WebElement response_content=driver.findElement(By.xpath("//p[contains(text(),'Successfully created an email schedule')]"));
			Assert.assertTrue(response_content.isDisplayed());
			System.out.println(response_content.getText());
			WebElement closebtn=driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
			closebtn.click();
	}
	
	//Email as ResponseReminder:- C2278
	public void VerifyEmail_ResponseReminder() throws InterruptedException, ParseException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[starts-with(@class,'button__email-icon sc-')]")).click();
		Thread.sleep(3000);
		   WebElement schedule_new=driver.findElement(By.xpath("//div[contains(text(),'NEW SCHEDULE')]"));
			schedule_new.click();
			Thread.sleep(3000);
			Select email_type=new Select(driver.findElement(By.xpath("/descendant::select[starts-with(@class,'sc-')][2]")));
			email_type.selectByVisibleText("Response Reminder");
			Thread.sleep(2000);
			WebElement saveas_field=driver.findElement(By.xpath("//input[@placeholder='Schedule Name']"));
			saveas_field.clear();
			saveas_field.sendKeys("SummaryTest");
			Thread.sleep(3000);
			WebElement email_field=driver.findElement(By.xpath("//input[@placeholder='Email addresses...']"));
			email_field.clear();
			email_field.sendKeys("ayadav");
			WebElement email_id=driver.findElement(By.xpath("//div[starts-with(@class,'tile-searchitem sc-')]"));
			email_id.click();
			Thread.sleep(3000);
			WebElement calender=driver.findElement(By.xpath("//div[contains(text(),'MM/DD/YYYY')]"));
			calender.click();
			Thread.sleep(2000);
			String setDatestr = "20/03/2021";// DDMMYYYY
			String currentDatestr = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText();// MMM YYY
			Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
			Date currentDate = new SimpleDateFormat("MMM yyyy").parse(currentDatestr);
			int monthDiff = Months
					.monthsBetween(new DateTime(currentDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1))
					.getMonths();
			boolean isFuture = true;
			if (monthDiff < 0) {
				isFuture = false;
				monthDiff = -1 * monthDiff;
			}
			for (int i = 0; i < monthDiff; i++) {
				if (isFuture)
					driver.findElement(By.xpath("//button[contains(text(),'Next month')]")).click();
				else
					 driver.findElement(By.xpath("//button[contains(text(),'Previous Month')]")).click();

			}
			driver.findElement(By.xpath("//div[contains(@aria-label,'day-20')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='HH:MM']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel 12 sc-')][contains(text(),'12')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel 00 sc-')][contains(text(),'00')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'AM')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'SAVE')]")).click();
			Thread.sleep(3000);
			WebElement response_content=driver.findElement(By.xpath("//p[contains(text(),'Successfully created an email schedule')]"));
			Assert.assertTrue(response_content.isDisplayed());
			System.out.println(response_content.getText());
			WebElement closebtn=driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
			closebtn.click();
	}
	
	//Share Review:-C2281
	public void VerifyShareReview() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'show-more-options sc-')][1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/descendant::div[starts-with(@class,'dropdownlabel Share Review sc-')][1]")).click();
		Thread.sleep(1000);
		WebElement heading_sharereview=driver.findElement(By.xpath("/descendant::div[contains(text(),'Share Review')][2]"));
		Assert.assertTrue(heading_sharereview.isDisplayed());
		Thread.sleep(2000);
		WebElement email_feild=driver.findElement(By.xpath("//input[@placeholder='Enter an email address']"));
		email_feild.clear();
		email_feild.sendKeys("ayadav");
		WebElement email_id=driver.findElement(By.xpath("//div[starts-with(@class,'tile-searchitem sc-')]"));
		email_id.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your message...']")).sendKeys("ShareTest");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'SEND')]")).click();
	}
	

}
