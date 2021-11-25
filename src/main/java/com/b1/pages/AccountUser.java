package com.b1.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;

 
public class AccountUser extends TestBase{
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement uname;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement pass;

	@FindBy(xpath = "//button[@class='raised_button signinBtn']")
	WebElement signin_btn;

	@FindBy(xpath = "//i[contains(normalize-space(),'language')]")
	WebElement locations;

	@FindBy(xpath = "//input[@placeholder='Select Accounts']")
	WebElement search_feild;
	
	@FindBy(xpath = "//div[starts-with(@class,'cs-dropdownitem')][contains(text(),'geostix2')]")
	WebElement geo;

	@FindBy(xpath = "//i[starts-with(@class,'context-account fonticon sc-')]")
	WebElement all_locations;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/ul/li[2]/div/div[1]/div")
	WebElement MyProfile1;
	
	@FindBy(xpath = "//div[contains(text(),'Users')]")
	WebElement User;
	
	@FindBy(xpath = "//div[contains(text(),'Add User')]")
	WebElement AddUser;
	
	@FindBy(xpath = "//input[@placeholder='First Name'][@name='firstName']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@placeholder='Last Name'][@name='lastName']")
	WebElement LastName;
	
	@FindBy(xpath = "//input[@placeholder='Email Address'][@name='username']")
	WebElement CompanyEmail;
	
	@FindBy(xpath = "//input[@placeholder='Phone Number'][@name='phone']")
	WebElement Phone;
	
	@FindBy(xpath = "//select[@placeholder='Team Name']")
	WebElement AddTeam;
	
	@FindBy(xpath = "//button[@class='save']")
	WebElement SaveBtn;
	
	@FindBy(xpath = "//a[@id='filterAdd']")
	WebElement AddFilters;
	
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	WebElement GoBackToSearchPage;
	
	@FindBy(xpath = "//select[@id='adtlFiltOpts']")
	WebElement SelectFilter;
	
	@FindBy(xpath = "//input[@id='adtlOptTxt']")
	WebElement SearchTextBox;
	
	@FindBy(xpath = "//a[@id='adtlOptApplyBtn']")
	WebElement ApplyBtn;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div[3]/a/label/span")
	WebElement CheckBtn;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div")
	WebElement DeleteBtn;
	
	@FindBy(xpath = "/descendant::a[starts-with(@class,'textoptiontoggle sc-')][4]")
	WebElement DropDwn;
	
	@FindBy(xpath = "//input[@id='EqualTo'][@name='textSelection']")
	WebElement RadioBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	WebElement ConfirmBtn;
	
	@FindBy(xpath = "//a[@id='fltrOptFirst Name']")
	WebElement FirstnameBtn;
	
	@FindBy(xpath = "//a[@id='moreFiltOpt']")
	WebElement OptionBtn;
	
	@FindBy(xpath = "//a[@id='saveFiltOpt']")
	WebElement SelectOptionBtn;
	
	@FindBy(xpath = "//a[text()='Reset Filter']")
	WebElement ResetFilterName;
	
	@FindBy(xpath = "//body/div[@class='container']//div[@id='navcontainer']/ul[1]/li[1]")
	WebElement VerifyFilterName;
	
	@FindBy(xpath = "//*[contains(text(),'SaveNew')]")
	WebElement ClickOnCreatedFilterToVerifyFilter;
	
	
	public AccountUser() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyOneStagingLogin(String un,String pa) throws InterruptedException {
		uname.clear();
		Thread.sleep(2000);
		uname.sendKeys(un);
		Thread.sleep(2000);
		pass.clear();
		pass.sendKeys(pa);
		Thread.sleep(2000);
		signin_btn.click();
	}
	
	public void VerifySearchLocation() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Location Overview')]")));
		locations.click();
		Thread.sleep(3000);
		search_feild.click();
		search_feild.clear();
		Thread.sleep(2000);
		search_feild.sendKeys("geos");
		Thread.sleep(3000);
		geo.click();
		Thread.sleep(2000);
		all_locations.click();	
	}
	
	public void VerifyProfile() throws InterruptedException{
		Thread.sleep(5000);
		WebElement myprofile=driver.findElement(By.xpath("//div[@id='appbar-avatar']"));
		myprofile.click();
		Thread.sleep(2000);
		WebElement users=driver.findElement(By.xpath("//div[contains(text(),'Users')]"));
		Assert.assertTrue(users.isDisplayed());
		users.click();
		}
	
	public void VerifyAdd_User() throws InterruptedException {
		Thread.sleep(3000);
		WebElement adduser=driver.findElement(By.xpath("/descendant::div[starts-with(@class,'sc-')][contains(text(),'Add User')][1]"));
		adduser.click();
		Thread.sleep(2000);
		WebElement dropdown_adduser=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Add a User sc-')][contains(text(),'Add a User')]"));
		dropdown_adduser.click();
	}
	
	

	
	public void AddUserDetails() throws Exception
	{
		FirstName.sendKeys("Atul");
		LastName.sendKeys("Shinde");
		CompanyEmail.sendKeys("Ravi@test.com");
		Phone.sendKeys("1234567890");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@placeholder='Team Name']")).click();
		Select teamname=new Select(driver.findElement(By.xpath("//select[@placeholder='Team Name']")));
		teamname.selectByVisibleText("ClientAdmin");
		Thread.sleep(1500);
		WebElement review_email=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[2]/form[1]/div[6]/div[1]/div[1]/div[1]"));
		review_email.click();
		Thread.sleep(1500);
		WebElement tes=driver.findElement(By.xpath("/descendant::span[starts-with(@class,'sc-')][contains(text(),'tes')][1]"));
		tes.click();
		Thread.sleep(1500);
		review_email.click();
		WebElement send_email=driver.findElement(By.xpath("//span[contains(text(),'Send registration email to this user')]"));
		send_email.click();
		WebElement save= driver.findElement(By.xpath("//button[@class='save']"));
		Assert.assertTrue(save.isEnabled());
		save.click();	
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@id='save']")).click();
		System.out.println("User Profile Save Sucessfully");
	}
	
	public void GoBackToSearchPage() throws InterruptedException {
		Thread.sleep(1500);
		GoBackToSearchPage.click();
	}

	
	public void SearchDetailsUsingFirstName() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='fltrOptFirst Name']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::input[@id='fltrTxtInput'][2]")).sendKeys("Atul");
		Thread.sleep(1500);
		driver.findElement(By.xpath("/descendant::a[starts-with(@class,'dropdownapplyaction sc-')][contains(text(),'Apply')][2]")).click();
		String Text = driver.findElement(By.xpath("//h3[contains(text(),'Atul Shinde')]")).getText();
		Assert.assertEquals(Text,"Atul Shinde");
		System.out.println("Newly Created user Displed in Search Result" +Text);

	}
	

public void SearchDetail_Using_LastName() throws InterruptedException {
	   Thread.sleep(1500);
		AddFilters.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
		Thread.sleep(1000);
		Select filter=new Select(driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")));
		filter.selectByVisibleText("Last Name");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='adtlOptTxt']")).sendKeys("Shinde");
		ApplyBtn.click();
	}

public void SearchUserDetailUsingMail() throws InterruptedException {
	Thread.sleep(2000);
	AddFilters.click();
	Thread.sleep(1500);
	driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")).click();
	Thread.sleep(1000);
	Select filter=new Select(driver.findElement(By.xpath("//select[@id='adtlFiltOpts']")));
	filter.selectByVisibleText("Email");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='adtlOptTxt']")).sendKeys("Ravi@test.com");
	ApplyBtn.click();	
}

public void VerifyDubplicate_UserCreation() throws Exception
{	
	VerifyAdd_User();
	Thread.sleep(3000);
	FirstName.sendKeys("Atul");
	LastName.sendKeys("Shinde");
	CompanyEmail.sendKeys("Ravi@test.com");
	Phone.sendKeys("1234567890");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//select[@placeholder='Team Name']")).click();
	Select teamname=new Select(driver.findElement(By.xpath("//select[@placeholder='Team Name']")));
	teamname.selectByVisibleText("ClientAdmin");
	Thread.sleep(1500);
	WebElement review_email=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[2]/form[1]/div[6]/div[1]/div[1]/div[1]"));
	review_email.click();
	Thread.sleep(1500);
	WebElement tes=driver.findElement(By.xpath("/descendant::span[starts-with(@class,'sc-')][contains(text(),'tes')][1]"));
	tes.click();
	Thread.sleep(1500);
	review_email.click();
	WebElement send_email=driver.findElement(By.xpath("//span[contains(text(),'Send registration email to this user')]"));
	send_email.click();
	WebElement save= driver.findElement(By.xpath("//button[@class='save']"));
	Assert.assertTrue(save.isEnabled());
	save.click();	
	Thread.sleep(3000);
	String Error_Message = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[2]/form[1]/div[11]/div[1]/div[1]/div[1]/div[2]/div[1]")).getText(); 
	Thread.sleep(1500);
	WebElement CancelBtn = driver.findElement(By.xpath("//button[@id='close']"));
	Assert.assertTrue(CancelBtn.isEnabled());	
	CancelBtn.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
}

public void SelectOptionCreatNewFilter() throws InterruptedException {
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@id='moreFiltOpt']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@id='saveFiltOpt']")).click();
	Thread.sleep(1500);
	driver.findElement(By.xpath("//input[@name='filterName']")).sendKeys("SaveNew");
	Thread.sleep(1500);
	driver.findElement(By.xpath("//span[text()='Submit']")).click();
	
}

public void VerifyCreatedFilter() throws InterruptedException {
	Thread.sleep(1500);
	VerifyFilterName.click();
	String Alpha = driver.findElement(By.xpath("//*[contains(text(),'SaveNew')]")).getText();
	Assert.assertEquals(Alpha, "SaveNew");
	System.out.println("Newly Created user Displayed in Search Filter" +Alpha);
	Thread.sleep(3000);
	ClickOnCreatedFilterToVerifyFilter.click();
	Thread.sleep(1500);
	Assert.assertTrue(CheckBtn.isEnabled());	
}

public void SelectResetFilter() throws InterruptedException {
	Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", OptionBtn);
	Thread.sleep(1000);
	JavascriptExecutor Rf = (JavascriptExecutor) driver;
	Rf.executeScript("arguments[0].click();", ResetFilterName);
}

public void VerifySavedFilter() throws InterruptedException {
	Thread.sleep(1000);
	VerifyFilterName.click();
	driver.findElement(By.xpath("//i[@class='material-icons'][contains(text(),'close')]")).click();
	//driver.navigate().refresh();
	VerifyFilterName.click();
	driver.navigate().refresh();
	Thread.sleep(2000);
}


public void DeleteUserProfile() throws InterruptedException {
	Thread.sleep(2000);
	SearchDetailsUsingFirstName();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/a[1]/label[1]/span[1]")).click();
	Thread.sleep(1500);
	driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
	System.out.println("Atul Shinde Profile Deleted Sucessfully");
}

}
