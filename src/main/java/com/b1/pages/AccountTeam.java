package com.b1.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.b1.base.TestBase;
import com.b1.util.TestUtility;
 

public class AccountTeam extends TestBase {
	
	TestUtility testUtil = new TestUtility();
	
	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile1;
	
	@FindBy(xpath="//div[contains(text(),'Teams')]")
	WebElement Teams;
	
	@FindBy(xpath="//p[@class='add']")
	WebElement AddNewTeam;
	
	@FindBy(xpath="//input[@name='teamName']")
	WebElement TeamName;
	
	@FindBy(xpath="//input[@type='checkbox'][@id=\"_9bdae3db-0786-4d59-9d2f-5e1c7df5629e\"]")
	WebElement CheckBox;
	
	@FindBy(xpath="//button[contains(text(),'Next')]")
	WebElement NextBtn;
	
	@FindBy(xpath="/descendant::button[contains(text(),'Next')][2]")
	WebElement NextBtn1;
	
	@FindBy(xpath="//input[@id='__all-locations']")
	WebElement LocationCheckBox;
	
	@FindBy(xpath="//button[contains(text(),'Create Team')]")
	WebElement CreateTeamBtn;
	
	@FindBy(xpath="//p[contains(text(),'Brandy')]//following::i[4]")
	WebElement SelectDeleteBtn;
	
	@FindBy(xpath="//button[@class='delete']")
	WebElement DeleteBtn;
	
	public AccountTeam() 
	{
		PageFactory.initElements(driver, this);
	}
	public void goToProfile() {
		TestUtility.clickOn(driver, MyProfile1, 30);
	}
	
	public void gotoTeams() {
		TestUtility.clickOn(driver, Teams, 30);
	}
	public void gotoAddTeams() {
		TestUtility.clickOn(driver, AddNewTeam, 30);
	}
	
	
	public void gotoCheckBoxsName() {
		if(CheckBox.isSelected()) 
		{
			System.out.println("Checkbox is already selected");
		}
		else
		{
		TestUtility.clickOn(driver, CheckBox, 30);
		System.out.println("The checkbox is now selected");
		}
	}
	
	
	public void AddTeamsName()
	{
	Actions actions = new Actions(driver);
	actions.moveToElement(TeamName).click().sendKeys("Brandy");
	actions.build().perform();	
	TestUtility.clickOn(driver, CheckBox, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", NextBtn);
	js.executeScript("arguments[0].click();", NextBtn1);
	
	}
	

	public void gotoLocationCheckBox() 
		{
			TestUtility.clickOn(driver, LocationCheckBox, 30);
		}
		
		
		public void AddCreateBtn() throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", CreateTeamBtn);
		
		}
		

		public void DeleteTeam() throws InterruptedException {
		
			driver.navigate().refresh();
			Thread.sleep(3000);
			TestUtility.clickOn(driver, SelectDeleteBtn, 30);
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", DeleteBtn);
			Thread.sleep(3000);
	}
}

