package com.b1.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.b1.base.TestBase;
import com.b1.listeners.TestListener;
import com.b1.pages.AccountUser;
import com.b1.pages.HomePage;
import com.b1.pages.LoginPage;
import com.b1.util.TestUtility;
@Listeners(TestListener.class)
public class AccountUserTest extends TestBase{
	AccountUser account;
	LoginPage loginPage;
	HomePage homePage;
	TestUtility testUtil;
	AccountUser accountUser;
	
	public AccountUserTest() throws IOException {
		super();
	}
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException  {
	    // initialization();
		BrowserStack_Invocation();
		  loginPage = new LoginPage();
		  account=new AccountUser();		
	}
	
	@Test(priority = 1)
	public void VerifyOneStagingLogin_test() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 2)
	public void VerifySearchLocation_test() throws InterruptedException {
		account.VerifySearchLocation();
	}
	  
	@Test(priority = 3)
	public void VerifyProfile_test() throws InterruptedException {
		account.VerifyProfile();
	}
	
	@Test(priority = 4)
	public void VerifyAdd_User_test() throws InterruptedException {
		account.VerifyAdd_User();
	}
	
	@Test(priority = 5)
	public void AddUserDetails_test() throws Exception {
		account.AddUserDetails();
	}
	
	@Test(priority = 6)
	public void GoBackToSearchPage_test() throws InterruptedException {
		account.GoBackToSearchPage();
	}
	
	@Test(priority = 7)
	public void SearchDetailsUsingFirstName_test() throws InterruptedException {
		account.SearchDetailsUsingFirstName();
	}
	
	@Test(priority = 8)
	public void SearchDetailUsingLastName_test() throws InterruptedException{
		account.SearchDetail_Using_LastName();
	}
	
	@Test(priority = 9)
	public void SearchUserDetailUsingMail_test() throws InterruptedException {
		account.SearchUserDetailUsingMail();
	}
	
	@Test(priority = 10)
	public void VerifyDubplicateUserCreation_test() throws Exception 
	{
		account.VerifyDubplicate_UserCreation();
	}
	
	@Test(priority = 11)
	public void SelectOptionCreatNewFilter_test() throws InterruptedException 
	{
		account.SelectOptionCreatNewFilter();
	}
	
	@Test(priority = 12)
	public void VerifyCreatedFilter_test() throws InterruptedException 
	{
		account.VerifyCreatedFilter();
	}
	
	@Test(priority = 13)
	public void SelectResetFilter_test() throws InterruptedException 
	{
		account.SelectResetFilter();
	}
	
	@Test(priority = 14)
	public void VerifySavedFilter_test() throws InterruptedException 
	{
		account.VerifySavedFilter();
	}
	
	@Test(priority = 15)
	public void DeleteUserProfile_test() throws InterruptedException 
	{
		account.DeleteUserProfile();
	}

	  @AfterClass(alwaysRun = true) 
	  public void tearDown() throws InterruptedException {
		  Thread.sleep(3000);
		  driver.quit();
	  }
	
}
