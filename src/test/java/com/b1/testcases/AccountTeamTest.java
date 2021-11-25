package com.b1.testcases;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.AccountTeam;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.util.TestUtility;
 

@Listeners(TestListener.class)
public class AccountTeamTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	AccountTeam accountteam;
	
	public AccountTeamTest() {
		super();
	}
	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException, MalformedURLException {
		//initialization();
		BrowserStack_Invocation();
		  loginPage = new LoginPage(); homePage =
		  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		  accountteam = new AccountTeam();	
	}
	@Test(groups = { "sanity", "regression" },priority = 1)
	public void clickOnContextAndSelectgeostix2() throws Exception {
		Thread.sleep(5000);
		homePage.clickOnContextAndSelectGeostix();
		String LocationName = driver.findElement(By.xpath("//div[contains(text(),'geostix2')]")).getText();
		System.out.println("Location Name : " + LocationName);
	}
	
	@Test(groups = { "sanity", "regression" },priority = 2)
	public void GoTOAccount() {
		accountteam.goToProfile();
	}
	
	@Test(groups = { "sanity", "regression" },priority = 3)
	public void GoTOTeams() 
	{
		accountteam.gotoTeams();

	}
	
	@Test(groups = { "sanity", "regression" },priority = 4)
	public void GoTOAddnewTeams() {
		accountteam.gotoAddTeams();

	}
	
	@Test(groups = { "sanity", "regression" },priority = 5)
	public void GoTOAddTeamName()  {
		accountteam.AddTeamsName();

	}
	@Test(groups = { "sanity", "regression" },priority = 6)
	public void GoTOCheckBox() {
		accountteam.gotoCheckBoxsName();

	}
	
	@Test(groups = { "sanity", "regression" },priority = 7)
	public void GoTOLocationCheckBox() {
		accountteam.gotoLocationCheckBox();

	}
	@Test(groups = { "sanity", "regression" },priority = 8)
	public void GoTOCreateTeam() throws InterruptedException{
		accountteam.AddCreateBtn();

	}
	@Test(groups = { "sanity", "regression" },priority = 9)
	public void GoTODeleteTeam() throws InterruptedException {
		accountteam.DeleteTeam();

	}

	@AfterClass(alwaysRun = true) public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	  
	  }
	 
}
