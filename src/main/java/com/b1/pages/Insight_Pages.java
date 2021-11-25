package com.b1.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.b1.base.TestBase;

 

public class Insight_Pages extends TestBase{
	private static String downloadPath = "C:\\Users\\pramod\\Downloads";
		
		private static String month="January 2021";
		private static String day="10";
		
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

		@FindBy(xpath = "//div[starts-with(@class,'cs-dropdownitem sc-')][contains(text(),'Cheesecake Factory')]")
		WebElement cheesef;

		@FindBy(xpath = "//i[starts-with(@class,'context-account fonticon sc-')]")
		WebElement all_locations;

		
		public Insight_Pages() throws IOException {
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
			search_feild.sendKeys("chee");
			Thread.sleep(3000);
			cheesef.click();
			Thread.sleep(2000);
			all_locations.click();	
		}

		public void Insight_Brandscore_SubMenu() throws InterruptedException {
			Thread.sleep(5000);
			WebElement insight_tab=driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
			WebElement branscore_submenu=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Brandscore sc-')][contains(text(),'Brandscore')]"));
			Actions act=new Actions(driver);
			act.moveToElement(insight_tab).perform();
			act.moveToElement(branscore_submenu).click().perform();
		}
		
		public void VerifyExport_CSV_Leadboard_Brandscore() throws InterruptedException  {
			Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(8000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Leaderboard|Brandscore CSV file download :- "+csvfile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_CSV_Leadboard_Listing() throws InterruptedException  {
			Thread.sleep(5000);
			 WebElement listingbrandscore_icon=driver.findElement(By.xpath("//li[@title='Listings Brandscore']"));
			 listingbrandscore_icon.click();
			 Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(8000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Leaderboard|Listing CSV file download :- "+csvfile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_CSV_Leadboard_Review() throws InterruptedException  {
			Thread.sleep(5000);
			WebElement reviewbranscore_icon=driver.findElement(By.xpath("//li[@title='Reviews Brandscore']"));
			reviewbranscore_icon.click();
			 Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(8000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Leaderboard|Review CSV file download :- "+csvfile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_CSV_Leadboard_Search() throws InterruptedException  {
			Thread.sleep(5000);
			WebElement searchbrandscore_icon=driver.findElement(By.xpath("//li[@title='Search Brandscore']"));
			searchbrandscore_icon.click();
			 Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(8000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Leaderboard|Search CSV file download :- "+csvfile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_CSV_Leadboard_Engagement() throws InterruptedException  {
			Thread.sleep(5000);
			WebElement engagementbrandscore_icon=driver.findElement(By.xpath("//li[@title='Engagement Brandscore']"));
			engagementbrandscore_icon.click();
			 Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(8000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Leaderboard|Engagement CSV file download :- "+csvfile);
				file.delete();
				break;
				}}
		}
		public void VerifyExport_PDF_Leadboard_Brandscore() throws InterruptedException {
			Thread.sleep(2000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(22000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdffile=file.getName();
					System.out.println("Leaderboard|Brandscore PDF file download :- "+pdffile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_PDF_Leadboard_Listing() throws InterruptedException {
			Thread.sleep(5000);
			 WebElement listingbrandscore_icon=driver.findElement(By.xpath("//li[@title='Listings Brandscore']"));
			 listingbrandscore_icon.click();
			 Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(24000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdffile=file.getName();
					System.out.println("Leaderboard|Listing PDF file download :- "+pdffile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_PDF_Leadboard_Reviews() throws InterruptedException {
			Thread.sleep(5000);
			WebElement reviewbranscore_icon=driver.findElement(By.xpath("//li[@title='Reviews Brandscore']"));
			reviewbranscore_icon.click();
			 Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(22000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdffile=file.getName();
					System.out.println("Leaderboard|Reviews PDF file download :- "+pdffile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_PDF_Leadboard_Search() throws InterruptedException {
			Thread.sleep(5000);
			WebElement searchbrandscore_icon=driver.findElement(By.xpath("//li[@title='Search Brandscore']"));
			searchbrandscore_icon.click();
			 Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(22000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdffile=file.getName();
					System.out.println("Leaderboard|Search PDF file download :- "+pdffile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_PDF_Leadboard_Engagement() throws InterruptedException {
			Thread.sleep(5000);
			WebElement engagementbrandscore_icon=driver.findElement(By.xpath("//li[@title='Engagement Brandscore']"));
			engagementbrandscore_icon.click();
			 Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]	"));
			export_btn.click();
			Thread.sleep(22000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Leaderboard_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdffile=file.getName();
					System.out.println("Leaderboard|Engagement PDF file download :- "+pdffile);
				file.delete();
				break;
				}}
		}
		public void VerifyInsights_Brandscore() throws InterruptedException {
			Thread.sleep(8000);
		   WebElement listingbrandscore_icon=driver.findElement(By.xpath("//li[@title='Listings Brandscore']"));
	       Assert.assertTrue(listingbrandscore_icon.isEnabled());
	       listingbrandscore_icon.click();
	       Thread.sleep(2000);
	       WebElement leadboard_brandscore=driver.findElement(By.xpath("//div[contains(text(),'Leaderboard | ')]"));
			Assert.assertTrue(leadboard_brandscore.isDisplayed());
			System.out.println(leadboard_brandscore.getText());
	       Thread.sleep(3000);
			
			WebElement reviewbranscore_icon=driver.findElement(By.xpath("//li[@title='Reviews Brandscore']"));
			Assert.assertTrue(reviewbranscore_icon.isEnabled());
			reviewbranscore_icon.click();
			Thread.sleep(2000);
				Assert.assertTrue(leadboard_brandscore.isDisplayed());
				System.out.println(leadboard_brandscore.getText());
			Thread.sleep(3000);
				
				WebElement searchbrandscore_icon=driver.findElement(By.xpath("//li[@title='Search Brandscore']"));
				Assert.assertTrue(searchbrandscore_icon.isEnabled());
				searchbrandscore_icon.click();
				Thread.sleep(2000);
				Assert.assertTrue(leadboard_brandscore.isDisplayed());
				System.out.println(leadboard_brandscore.getText());
				Thread.sleep(3000);
				
					WebElement engagementbrandscore_icon=driver.findElement(By.xpath("//li[@title='Engagement Brandscore']"));
					Assert.assertTrue(engagementbrandscore_icon.isEnabled());
					engagementbrandscore_icon.click();
					Thread.sleep(2000);
					Assert.assertTrue(leadboard_brandscore.isDisplayed());
					System.out.println(leadboard_brandscore.getText());
					Thread.sleep(3000);
					WebElement totalbrandscore_icon=driver.findElement(By.xpath("//li[@title='Total Brandscore']"));
					Assert.assertTrue(totalbrandscore_icon.isEnabled());
					totalbrandscore_icon.click();
					Thread.sleep(2000);
					Assert.assertTrue(leadboard_brandscore.isDisplayed());
					System.out.println(leadboard_brandscore.getText());

		}
		
		
		public void VerifyInsights_Timeline() throws InterruptedException {
			Thread.sleep(3000);
			WebElement dropdown_arrow=driver.findElement(By.xpath("/descendant::div[contains(text(),'Leaderboard')][1]"));
			dropdown_arrow.click();
			WebElement timeline=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Timeline sc-')][contains(text(),'Timeline')]"));
			timeline.click();
			Thread.sleep(15000);
			WebElement score=driver.findElement(By.xpath("/descendant::div[starts-with(@class,'sc-')][@color='#00C853'][2]"));
			Assert.assertTrue(score.isDisplayed());
			System.out.println("Your Score is:- "+score.getText());
			Thread.sleep(5000);
			WebElement popover=driver.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
			popover.click();
			Thread.sleep(2000);
			WebElement last3month=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Last 3 months sc-')][contains(text(),'Last 3 months')]"));
			last3month.click();
			Thread.sleep(10000);
			WebElement timelinelocations_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
			System.out.println(timelinelocations_result.getText());
			}
		
		public void VerifyExport_CSV_Timeline_Locations() throws InterruptedException  {
			Thread.sleep(2000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(8000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Timeline_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Timeline Locations CSV file download :- "+csvfile);
					file.delete();
					break;
				}}
		}
		
		public void VerifyExport_PDF_Timeline_Locations() throws InterruptedException {
			Thread.sleep(2000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(25000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Timeline_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdf_file=file.getName();
					System.out.println("Timeline Locations PDF file download :- "+pdf_file);
					file.delete();
					break;
				}}
		}
		public void VerifyExportCSV_Timeline_locationGroups() throws InterruptedException {
			Thread.sleep(4000);
			WebElement downnarrow = driver
					.findElement(By.xpath("/descendant::i[contains(normalize-space(),'arrow_drop_down')][2]"));
			downnarrow.click();
			Thread.sleep(2000);
			WebElement locarionsgrp = driver.findElement(By.xpath(
					"//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
			locarionsgrp.click();
			Thread.sleep(9000);
			WebElement gropresult = driver
					.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
			Assert.assertTrue(gropresult.isDisplayed());
			System.out.println(gropresult.getText());
			Thread.sleep(2000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(8000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Timeline_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Timeline Location Groups CSV file download :- "+csvfile);
					file.delete();
					break;}}
		}
		
		public void VerifyExportPDF_Timeline_LocationGroups() throws InterruptedException {
			Thread.sleep(4000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(25000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="Brandscore_Timeline_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdf_file=file.getName();
					System.out.println("Timeline Location Groups PDF file download :- "+pdf_file);
					file.delete();
					break;
				}}
		}
		public void VerifyInsight_Competitors() throws InterruptedException {
			Thread.sleep(8000);
			WebElement dropdown_arrow=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Timeline')]"));
			dropdown_arrow.click();
			Thread.sleep(2000);
			WebElement competitors=driver.findElement(By.xpath(" //div[starts-with(@class,'dropdownlabel Competitors sc-')][contains(text(),'Competitors')]"));
			competitors.click();
			Thread.sleep(12000);
			WebElement cheesecake_brand=driver.findElement(By.xpath("//img[@title='Cheesecake Factory']"));
			Assert.assertTrue(cheesecake_brand.isDisplayed());
			System.out.println("CheeseCake Factory brand is is Displayed");
		}
		
		public void Insight_Engagement_SubMenu() throws InterruptedException {
			Thread.sleep(5000);
			WebElement insight_tab=driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
			WebElement engagment_submenu=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Engagement sc-')][contains(text(),'Engagement')]"));
			Actions act=new Actions(driver);
			act.moveToElement(insight_tab).perform();
			act.moveToElement(engagment_submenu).click().perform();
		}
		
		public void VerifyExport_CSV_Engagement_Google_Locations() throws InterruptedException  {
			Thread.sleep(8000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(10000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Google Locations CSV file download :- "+csvfile);
					file.delete();
					break;
				 
				}
			}
			
		}
		
		public void VerifyExport_PDF_Engagement_Google_Locations() throws InterruptedException {
			Thread.sleep(2000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(22000);	  
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdffile=file.getName();
					System.out.println("Google Locations PDF file download :- "+pdffile);
				file.delete();
				break;
				}}
		}
		public void VerifyEngagement_Google() throws InterruptedException {
			Thread.sleep(6000);
			WebElement actionrate=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3"));
			Assert.assertTrue(actionrate.isDisplayed());
			System.out.println("Actions Rate is:- "+actionrate.getText());
			Thread.sleep(2000);
			WebElement popover = driver
					.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
			popover.click();
			Thread.sleep(2000);
			WebElement last3month = driver.findElement(By.xpath(
					"//div[starts-with(@class,'dropdownlabel Last 3 months sc-')][contains(text(),'Last 3 months')]"));
			last3month.click();
			Thread.sleep(6000);
			WebElement dropdown_icon = driver
					.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"));
			dropdown_icon.click();
			Thread.sleep(3000);
			WebElement month_label = driver.findElement(
					By.xpath("//div[contains(text(),'Month')]"));
			month_label.click();
			Thread.sleep(8000);
			WebElement actionrate2=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3"));
			Assert.assertTrue(actionrate.isDisplayed());
			System.out.println("Actions Rate is:- " + actionrate2.getText());
		}
		
		public void VerifyExport_CSV_Engagement_Google_LocationGropus() throws InterruptedException {
			Thread.sleep(3000);
			WebElement arrowicon_location = driver
					.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
			arrowicon_location.click();
			Thread.sleep(2000);
			WebElement Locationsgrp = driver
					.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
			Locationsgrp.click();
			//Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/div[1]")));
			WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
			Assert.assertTrue(locationsgrp_result.isDisplayed());
			System.out.println("Locations Group Resullt:- " + locationsgrp_result.getText());
			Thread.sleep(2000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(10000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Google Location Gropus CSV file download :- "+csvfile);
					file.delete();
					break;
				 
				}
			}
		}
		
		public void VerifyExport_PDF_Engagement_Google_LocationGropus() throws InterruptedException {
			Thread.sleep(2000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(22000);	  
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdffile=file.getName();
					System.out.println("Google Location Gropus PDF file download :- "+pdffile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_CSV_Engagement_Google_Publishers() throws InterruptedException {
			Thread.sleep(3000);
			WebElement publisher = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]"));
			publisher.click();
			Thread.sleep(7000);
			WebElement google_icon = driver.findElement(By.xpath("//div[@src='/img/logos/Google.png']"));
			Assert.assertTrue(google_icon.isDisplayed());
			WebElement searchresult = driver.findElement(
					By.xpath("//tbody/tr[2]/td[2]/div[1]"));
			Assert.assertTrue(searchresult.isDisplayed());
			System.out.println("Google Search Result:- " + searchresult.getText());
			Thread.sleep(3000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(10000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Google Publishers CSV file download :- "+csvfile);
					file.delete();
					break;
				 
				}
			}
			
		}
		
		public void VerifyExport_CSV_Engagement_Yelp_Locations() throws InterruptedException  {
			Thread.sleep(5000);
			WebElement publisher_dropdown=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Google')]"));
			publisher_dropdown.click();
			Thread.sleep(2000);
			WebElement yelp=driver.findElement(By.xpath("//div[contains(text(),'Yelp')]"));
			yelp.click();
			Thread.sleep(8000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(10000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Yelp Locations CSV file download :- "+csvfile);
					file.delete();
					break;
				}
			}	
		}
		public void VerifyExport_PDF_Engagement_Yelp_Locations() throws InterruptedException {
			Thread.sleep(2000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(22000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdffile=file.getName();
					System.out.println("Yelp Locations PDF file download :- "+pdffile);
				file.delete();
				break;
				}}
		}
		public void VerifyEngagement_Yelp() throws InterruptedException {
			Thread.sleep(5000);
			WebElement actionrate=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3"));
			Assert.assertTrue(actionrate.isDisplayed());
			System.out.println("Actions Rate is:- "+actionrate.getText());
			Thread.sleep(3000);
			WebElement popover = driver
					.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
			popover.click();
			Thread.sleep(2000);
			WebElement last6month = driver.findElement(By.xpath(
					"//div[starts-with(@class,'dropdownlabel Last 6 months sc-')][contains(text(),'Last 6 months')]"));
			last6month.click();
			Thread.sleep(8000);
			WebElement dropdown_icon = driver
					.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"));
			dropdown_icon.click();
			Thread.sleep(3000);
			WebElement quarter_label = driver.findElement(
					By.xpath("//div[contains(text(),'Quarter')]"));
			quarter_label.click();
			Thread.sleep(8000);
			WebElement actionrate2=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3"));
			Assert.assertTrue(actionrate2.isDisplayed());
			System.out.println("Actions Rate is:- " + actionrate2.getText());
		}
		
		public void VerifyExport_CSV_Engagement_Yelp_LocationGroups() throws InterruptedException {
			Thread.sleep(3000);
			WebElement arrowicon_location = driver
					.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
			arrowicon_location.click();
			Thread.sleep(2000);
			WebElement Locationsgrp = driver
					.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
			Locationsgrp.click();
			//Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/div[1]")));
			WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
			Assert.assertTrue(locationsgrp_result.isDisplayed());
			System.out.println("Locations Group Resullt:- " + locationsgrp_result.getText());
			Thread.sleep(3000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(10000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Yelp Location Groups  CSV file download :- "+csvfile);
					file.delete();
					break;
				 
				}
			}
		}
		
		public void VerifyExport_PDF_Engagement_Yelp_LocationGroups() throws InterruptedException {
			Thread.sleep(2000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
			format_type.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(22000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String pdffile=file.getName();
					System.out.println("Yelp Location Groups PDF file download :- "+pdffile);
				file.delete();
				break;
				}}
		}
		
		public void VerifyExport_CSV_Engagement_Yelp_publishers() throws InterruptedException {
			Thread.sleep(3000);
			WebElement publisher = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]"));
			publisher.click();
			Thread.sleep(7000);
			WebElement yelp_icon = driver.findElement(By.xpath("//div[@src='/img/logos/Yelp.png']"));
			Assert.assertTrue(yelp_icon.isDisplayed());
			WebElement searchresult = driver.findElement(
					By.xpath("//tbody/tr[3]/td[2]/div[1]"));
			Assert.assertTrue(searchresult.isDisplayed());
			System.out.println("Yelp Search Result:- " + searchresult.getText());	
			Thread.sleep(3000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(10000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Yelp publishers  CSV file download :- "+csvfile);
					file.delete();
					break;
				 
				}
			}
		}
		
		public void VerifyExport_CSV_Engagement_Facebook_Locations() throws InterruptedException  {
			Thread.sleep(5000);
			WebElement publisher_dropdown=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Yelp')]"));
			publisher_dropdown.click();
			Thread.sleep(2000);
			WebElement facebook=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Facebook sc-')][contains(text(),'Facebook')]"));
			facebook.click();
			Thread.sleep(8000);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(10000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="engagement_Facebook_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("Facebook Locations CSV file download :- "+csvfile);
					file.delete();
					break;
				}
			}	
		}
		
		
		public void VerifyEngagement_Facebook() throws InterruptedException {
			Thread.sleep(5000);
			WebElement pageimpression_value=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h5"));
			Assert.assertTrue(pageimpression_value.isDisplayed());
			System.out.println(pageimpression_value.getText());
			Thread.sleep(3000);
			WebElement popover = driver
					.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
			popover.click();
			Thread.sleep(2000);
			WebElement last6month = driver.findElement(By.xpath(
					"//div[starts-with(@class,'dropdownlabel Last year sc-')][contains(text(),'Last year')]"));
			last6month.click();
			Thread.sleep(6000);
			WebElement dropdown_icon = driver
					.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"));
			dropdown_icon.click();
			Thread.sleep(3000);
			WebElement year_label = driver.findElement(
					By.xpath("//div[contains(text(),'Year')]"));
			year_label.click();
			Thread.sleep(8000);
			WebElement actionrate2=driver.findElement(By.xpath("//tbody/tr[1]/td[8]/div[1]/div[1]/b"));
			Assert.assertTrue(actionrate2.isDisplayed());
			System.out.println("Actions Rate is:- " + actionrate2.getText());
		
		}
		
	public void VerifyExport_CSV_Engagement_Facebook_LocationGroups() throws InterruptedException {
		Thread.sleep(3000);
		WebElement arrowicon_location = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
		arrowicon_location.click();
		Thread.sleep(2000);
		WebElement Locationsgrp = driver
				.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
		Locationsgrp.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/div[1]")));
		WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locationsgrp_result.isDisplayed());
		Thread.sleep(3000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]	"));
		export_btn.click();
		Thread.sleep(10000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_Facebook_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("Facebook Location Groups CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void VerifyExport_CSV_Engagement_Facebook_Demographics1() throws InterruptedException {
		Thread.sleep(3000);
		WebElement arrowicon_demographic = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][3]"));
		WebElement demographics1=driver.findElement(By.xpath("//div[contains(text(),'Demographics | People Talking About Your Pages')]"));
		Actions act=new Actions(driver);
		act.moveToElement(arrowicon_demographic).perform();
		act.moveToElement(demographics1).click().perform();
	Thread.sleep(10000);
	WebElement gender_result=driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]"));
	Assert.assertTrue(gender_result.isDisplayed());
	System.out.println("Gender result is:- "+ gender_result.getText());
	Thread.sleep(3000);
	WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
	trigger.click();
	Thread.sleep(2000);
	WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
	filedownload_icon.click();
	Thread.sleep(2000);
	WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
	export_btn.click();
	Thread.sleep(10000);
	File filelocaitons = new File(downloadPath);
	File[] totalfiles=filelocaitons.listFiles();
	String file_Name="engagement_Facebook_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
	for(File file:totalfiles) {
		if(file.getName().equals(file_Name)) {
			String csvfile=file.getName();
			System.out.println("Facebook Demographics | People Talking About Your Pages CSV file download :- "+csvfile);
			file.delete();
			break;
		}
	}	
	}

	public void VerifyExport_CSV_Engagement_Facebook_Demographics2() throws InterruptedException {
		Thread.sleep(3000);
		WebElement arrowicon_demographic = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][3]"));
		WebElement demographics2=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Demographics | Page Impressions sc-')]"));
		Actions act=new Actions(driver);
		act.moveToElement(arrowicon_demographic).perform();
		act.moveToElement(demographics2).click().perform();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]/div[1]")));
		WebElement gender_result=driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]"));
		Assert.assertTrue(gender_result.isDisplayed());
		System.out.println("Gender result is:- "+ gender_result.getText());
		Thread.sleep(3000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(10000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_Facebook_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("Facebook Demographics | Page Impressions CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void Insight_EngagementActions_SubMenu() throws InterruptedException {
		Thread.sleep(5000);
		WebElement insight_tab=driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		WebElement eng_actions=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Engagement Actions sc-')][contains(text(),'Engagement Actions')]"));
		Actions act=new Actions(driver);
		act.moveToElement(insight_tab).perform();
		act.moveToElement(eng_actions).click().perform();
	}

	public void VerifyExport_CSV_EngagementActions_google_Locations() throws InterruptedException  {
		Thread.sleep(8000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void VerifyExport_PDF_EngagementActions_google_Locations() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void VerifyEngagementActions_google() throws InterruptedException {
		Thread.sleep(6000);
		WebElement popover = driver
				.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
		popover.click();
		Thread.sleep(2000);
		WebElement last3month = driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownlabel Last 3 months sc-')][contains(text(),'Last 3 months')]"));
		last3month.click();
		Thread.sleep(6000);
		WebElement dropdown_icon = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"));
		dropdown_icon.click();
		Thread.sleep(3000);
		WebElement month_label = driver.findElement(
				By.xpath("//div[contains(text(),'Month')]"));
		month_label.click();
		Thread.sleep(8000);
		WebElement locations_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locations_result.isDisplayed());
		System.out.println("Locations Result is:- "+locations_result.getText());

	}

	public void VerifyExport_CSV_EngagementActions_Google_LocationGroups() throws InterruptedException {
		Thread.sleep(3000);
		WebElement arrowicon_location = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
		arrowicon_location.click();
		Thread.sleep(2000);
		WebElement Locationsgrp = driver
				.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
		Locationsgrp.click();
		//Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/div[1]")));
		WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locationsgrp_result.isDisplayed());
		System.out.println("Locations Group Resullt:- " + locationsgrp_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void VerifyExport_PDF_EngagementActions_Google_LocationGroups() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void VerifyExport_CSV_EngagementActions_Google_Publishers() throws InterruptedException {
		Thread.sleep(3000);
		WebElement publisher = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]"));
		publisher.click();
		Thread.sleep(5000);
		WebElement google_icon = driver.findElement(By.xpath("//div[@src='/img/logos/Google.png']"));
		Assert.assertTrue(google_icon.isDisplayed());
		WebElement searchresult = driver.findElement(
				By.xpath("//tbody/tr[2]/td[2]/div[1]"));
		Assert.assertTrue(searchresult.isDisplayed());
		System.out.println("Google Search Result:- " + searchresult.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Google_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void VerifyExport_CSV_EngagementActions_Yelp_Locations() throws InterruptedException {
		Thread.sleep(5000);
		WebElement publisher_dropdown=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Google')]"));
		publisher_dropdown.click();
		Thread.sleep(2000);
		WebElement yelp=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Yelp sc-')][contains(text(),'Yelp')]"));
		yelp.click();
		Thread.sleep(8000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}
	}

	public void VerifyExport_PDF_EngagementActions_Yelp_Locations() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}

	}

	public void VerifyEngagementActions_Yelp() throws InterruptedException {
		Thread.sleep(5000);
		WebElement popover = driver
				.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
		popover.click();
		Thread.sleep(2000);
		WebElement last6month = driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownlabel Last 6 months sc-')][contains(text(),'Last 6 months')]"));
		last6month.click();
		Thread.sleep(6000);
		WebElement dropdown_icon = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"));
		dropdown_icon.click();
		Thread.sleep(3000);
		WebElement quarter_label = driver.findElement(
				By.xpath("//div[contains(text(),'Quarter')]"));
		quarter_label.click();
		Thread.sleep(8000);
		WebElement locations_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locations_result.isDisplayed());
		System.out.println("Locations Result is:- "+locations_result.getText());

	}

	public void VerifyExport_CSV_EngagementActions_Yelp_LocationGroups() throws InterruptedException {
		Thread.sleep(3000);
		WebElement arrowicon_location = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
		arrowicon_location.click();
		Thread.sleep(2000);
		WebElement Locationsgrp = driver
				.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
		Locationsgrp.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/div[1]")));
		WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locationsgrp_result.isDisplayed());
		System.out.println("Locations Group Resullt:- " + locationsgrp_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}
	}

	public void VerifyExport_PDF_EngagementActions_Yelp_LocationGroups() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void VerifyExport_CSV_EngagementActions_Yelp_Publishers() throws InterruptedException {
		Thread.sleep(3000);
		WebElement publisher = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]"));
		publisher.click();
		Thread.sleep(5000);
		WebElement yelp_icon = driver.findElement(By.xpath("//div[@src='/img/logos/Yelp.png']"));
		Assert.assertTrue(yelp_icon.isDisplayed());
		WebElement searchresult = driver.findElement(
				By.xpath("//tbody/tr[2]/td[2]/div[1]"));
		Assert.assertTrue(searchresult.isDisplayed());
		System.out.println("Yelp Search Result:- " + searchresult.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Yelp_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}
	}

	public void VerifyExport_CSV_EngagementActions_Facebook_Locations() throws InterruptedException {
		Thread.sleep(5000);
		WebElement publisher_dropdown=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Yelp')]"));
		publisher_dropdown.click();
		Thread.sleep(2000);
		WebElement facebook=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Facebook sc-')][contains(text(),'Facebook')]"));
		facebook.click();
		Thread.sleep(8000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Facebook_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void VerifyEngagementActions_Facebook() throws InterruptedException {
		Thread.sleep(5000);
		WebElement popover = driver
				.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
		popover.click();
		Thread.sleep(2000);
		WebElement last6month = driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownlabel Last year sc-')][contains(text(),'Last year')]"));
		last6month.click();
		Thread.sleep(6000);
		WebElement dropdown_icon = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"));
		dropdown_icon.click();
		Thread.sleep(3000);
		WebElement year_label = driver.findElement(
				By.xpath("//div[contains(text(),'Year')]"));
		year_label.click();
		Thread.sleep(8000);
		WebElement locations_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locations_result.isDisplayed());
		System.out.println("Locations Result is:- "+locations_result.getText());
		
	}

	public void VerifyExport_CSV_EngagementActions_Facebook_LocationGroups() throws InterruptedException {
		Thread.sleep(3000);
		WebElement arrowicon_location = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
		arrowicon_location.click();
		Thread.sleep(2000);
		WebElement Locationsgrp = driver
				.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
		Locationsgrp.click();
		//Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/div[1]")));
		WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locationsgrp_result.isDisplayed());
		System.out.println("Locations Group Resullt:- " + locationsgrp_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="engagement_actions_Facebook_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);	
				file.delete();
				break;
			}
		}	
	}

	public void Insight_LocalPage_SubMenu() throws InterruptedException {
		Thread.sleep(5000);
		WebElement insight_tab=driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		WebElement LocalPages=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Local Pages sc-')][contains(text(),'Local Pages')]"));
		Actions act=new Actions(driver);
		act.moveToElement(insight_tab).perform();
		act.moveToElement(LocalPages).click().perform();
	}

	public void Verify_CSV_LocalPages_Locations() throws InterruptedException {
		Thread.sleep(6000);
		WebElement popover = driver
				.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
		popover.click();
		Thread.sleep(2000);
		WebElement last3month = driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownlabel Last 3 months sc-')][contains(text(),'Last 3 months')]"));
		last3month.click();
		Thread.sleep(6000);
		WebElement dropdown_icon = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"));
		dropdown_icon.click();
		Thread.sleep(3000);
		WebElement month_label = driver.findElement(
				By.xpath("//div[contains(text(),'Month')]"));
		month_label.click();
		Thread.sleep(12000);
		WebElement locations_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locations_result.isDisplayed());
		System.out.println("Locations Result is:- "+locations_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(5000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="local_pages_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("file download :- "+csvfile);
				file.delete();
				break;
			}
		}		
	}

	public void Verify_CSV_LocalPages_LocationGroups() throws InterruptedException {
		Thread.sleep(6000);
		//WebElement total_locations=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		//Assert.assertTrue(total_locations.isDisplayed());
		//System.out.println("Local Pages Total Locations are:- "+ total_locations.getText());
		//Thread.sleep(2000);
		
		WebElement arrowicon_location = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
		arrowicon_location.click();
		Thread.sleep(2000);
		WebElement Locationsgrp = driver
				.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
		Locationsgrp.click();
		//Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/div[1]")));
		WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locationsgrp_result.isDisplayed());
		System.out.println("Locations Group Resullt:- " + locationsgrp_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(5000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="local_pages_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("file download :- "+csvfile);
				file.delete();
				break;
			}
		}		
	}

	public void Verify_CSV_LocalPages_Devices() throws InterruptedException {
		  Thread.sleep(3000);
		    WebElement devices=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][contains(text(),'Devices')]"));
		    devices.click();
		    //Thread.sleep(6000);
		    WebDriverWait wait = new WebDriverWait(driver,15);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[3]/td[1]/div[1]")));
		    WebElement mobile_device=driver.findElement(By.xpath("//tbody/tr[3]/td[1]/div[1]"));
		    Assert.assertTrue(mobile_device.isDisplayed());
		    System.out.println("Device Name is:- "+mobile_device.getText());
		    WebElement totalmobile_device=driver.findElement(By.xpath("//tbody/tr[3]/td[2]/div[1]"));
		    Assert.assertTrue(totalmobile_device.isDisplayed());
		    System.out.println("Total Mobile Device :-  "+totalmobile_device.getText());
		    Thread.sleep(2500);
			WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
			trigger.click();
			Thread.sleep(2000);
			WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
			filedownload_icon.click();
			Thread.sleep(2000);
			WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
			export_btn.click();
			Thread.sleep(5000);
			File filelocaitons = new File(downloadPath);
			File[] totalfiles=filelocaitons.listFiles();
			String file_Name="local_pages_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
			for(File file:totalfiles) {
				if(file.getName().equals(file_Name)) {
					String csvfile=file.getName();
					System.out.println("file download :- "+csvfile);
					file.delete();
					break;
				}
			}		
	}

	public void Insight_Ratings_SubMenu() throws InterruptedException {
		Thread.sleep(5000);
		WebElement insight_tab=driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		WebElement ratings=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Ratings sc-')][contains(text(),'Ratings')]"));
		Actions act=new Actions(driver);
		act.moveToElement(insight_tab).perform();
		act.moveToElement(ratings).click().perform();
	}

	public void VerifyRatings_ShareByEmail() throws InterruptedException {
		Thread.sleep(5000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement email_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Share by Email sc-')][contains(text(),'Share by Email')]"));
		email_icon.click();
		Thread.sleep(6000);
		WebElement schedule_new=driver.findElement(By.xpath("//div[contains(text(),'NEW SCHEDULE')]"));
		schedule_new.click();
		Thread.sleep(5000);
		WebElement saveas_field=driver.findElement(By.xpath("//input[@placeholder='Schedule Name']"));
		saveas_field.clear();
		saveas_field.sendKeys("Test");
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
		while(true) {
			String text=driver.findElement(By.xpath("//div[@class='react-datepicker__current-month'][contains(text(),'January 2021')]")).getText();
		
			if(text.equals(month)) {
				break;
			}
			
			else  {
				driver.findElement(By.xpath("//button[contains(text(),'Next month')]")).click();
				
			}
		}
		driver.findElement(By.xpath("//div[starts-with(@class,'react-datepicker__day react-datepicker__day--sun')][contains(text(),'10')]")).click();
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
		Thread.sleep(3000);
		trigger.click();
		Thread.sleep(2000);
		email_icon.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Select all')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		System.out.println("Email Scheduler Deleted successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
	}

	public void VerifyExport_CSV_Ratings_Sentiment_Locations() throws InterruptedException {
		Thread.sleep(8000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}		
	}

	public void VerifyExport_PDF_Ratings_Sentiment_Locations() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}
	public void Verify_Ratings_Sentiment() throws InterruptedException {
		Thread.sleep(6000);
		WebElement start_ratings=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/h3"));
		Assert.assertTrue(start_ratings.isDisplayed());
		System.out.println("Ratings of Star:-  "+start_ratings.getText());
		/*
		 * WebElement popover = driver .findElement(By.
		 * xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"
		 * )); popover.click(); Thread.sleep(2000); WebElement last3month =
		 * driver.findElement(By.xpath(
		 * "//div[starts-with(@class,'dropdownlabel Last 3 months sc-')][contains(text(),'Last 3 months')]"
		 * )); last3month.click(); Thread.sleep(6000); WebElement dropdown_icon = driver
		 * .findElement(By.
		 * xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"
		 * )); dropdown_icon.click(); Thread.sleep(3000); WebElement month_label =
		 * driver.findElement( By.xpath("//div[contains(text(),'Month')]"));
		 * month_label.click(); Thread.sleep(8000);
		 */
		Thread.sleep(2000);
		WebElement locations_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locations_result.isDisplayed());
		System.out.println("Locations Result is:- "+locations_result.getText());

	}

	public void VerifyExport_CSV_Ratings_Sentiment_LocationGroups() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement arrowicon_location = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
		arrowicon_location.click();
		Thread.sleep(2000);
		WebElement Locationsgrp = driver
				.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
		Locationsgrp.click();
		Thread.sleep(12000);
		WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locationsgrp_result.isDisplayed());
		System.out.println("Locations Group Resullt:- " + locationsgrp_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void VerifyExport_PDF_Ratings_Sentiment_LocationGroups() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void VerifyExport_CSV_Ratings_Sentiment_Publishers() throws InterruptedException {
		Thread.sleep(3000);
		WebElement publisher = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]"));
		publisher.click();
		Thread.sleep(8000);
		WebElement publisher_result=driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]"));
		Assert.assertTrue(publisher_result.isDisplayed());
		System.out.println("Publisher Result is:- "+publisher_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void VerifyExport_CSV_Ratings_StarRating_Locations() throws InterruptedException {
		Thread.sleep(2000);
		WebElement arrowicon_location = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
		arrowicon_location.click();
		Thread.sleep(2000);
		WebElement Locations = driver
				.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Locations sc-')][contains(text(),'Locations')]"));
		Locations.click();
		Thread.sleep(3000);
		WebElement rating_downarrow=driver.findElement(By.xpath("/descendant::div[starts-with(@class,'sc-')][@color='#B0BEC5'][1]"));
		rating_downarrow.click();
		Thread.sleep(2000);
		WebElement starrating=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Star Rating sc-')][contains(text(),'Star Rating')]"));
		starrating.click();
		Thread.sleep(5000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void VerifyExport_PDF_Ratings_StarRating_Locations() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(3000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void VerifyExport_CSV_Ratings_StarRating_LocationGroups() throws InterruptedException {
		Thread.sleep(3000);
		WebElement arrowicon_location = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
		arrowicon_location.click();
		Thread.sleep(2000);
		WebElement Locationsgrp = driver
				.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
		Locationsgrp.click();
		Thread.sleep(10000);
		WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locationsgrp_result.isDisplayed());
		System.out.println("Locations Group Resullt:- " + locationsgrp_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void VerifyExport_PDF_Ratings_StarRating_LocationGroups() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void VerifyExport_CSV_Ratings_StarRating_Publishers() throws InterruptedException {
		Thread.sleep(3000);
		WebElement publisher = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]"));
		publisher.click();
		Thread.sleep(10000);
		WebElement publisher_result=driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]"));
		Assert.assertTrue(publisher_result.isDisplayed());
		System.out.println("Publisher Result is:- "+publisher_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(3000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="ratings_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}	
	}

	public void Insight_Responses_SubMenu() throws InterruptedException {
		Thread.sleep(5000);
		WebElement insight_tab=driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		WebElement responses=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Responses sc-')][contains(text(),'Responses')]"));
		Actions act=new Actions(driver);
		act.moveToElement(insight_tab).perform();
		act.moveToElement(responses).click().perform();
	}

	public void VerifyExportCSV_Responses_Locations() throws InterruptedException {
		Thread.sleep(10000);
		WebElement total_reviews=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]//b"));
		Assert.assertTrue(total_reviews.isDisplayed());
		System.out.println("Total Reviews:- "+total_reviews.getText());
		Thread.sleep(3000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="responses_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}		
	}

	public void VerifyExport_PDF_Responses_Locations() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="responses_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void Verify_Responses_ShareByEmail() throws InterruptedException {
		Thread.sleep(5000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement email_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Share by Email sc-')][contains(text(),'Share by Email')]"));
		email_icon.click();
		Thread.sleep(6000);
		WebElement schedule_new=driver.findElement(By.xpath("//div[contains(text(),'NEW SCHEDULE')]"));
		schedule_new.click();
		Thread.sleep(5000);
		WebElement saveas_field=driver.findElement(By.xpath("//input[@placeholder='Schedule Name']"));
		saveas_field.clear();
		saveas_field.sendKeys("Test");
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
		while(true) {
			String text=driver.findElement(By.xpath("//div[@class='react-datepicker__current-month'][contains(text(),'January 2021')]")).getText();
		
			if(text.equals(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//button[contains(text(),'Next month')]")).click();
			}
		}
		driver.findElement(By.xpath("//div[starts-with(@class,'react-datepicker__day react-datepicker__day--sun')][contains(text(),'10')]")).click();
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
		Thread.sleep(3000);
		trigger.click();
		Thread.sleep(2000);
		email_icon.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Select all')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		System.out.println("Email Scheduler Deleted successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
	}

	public void VerifyRespnses() throws InterruptedException {
		Thread.sleep(7000);
		WebElement popover = driver
				.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
		popover.click();
		Thread.sleep(2000);
		WebElement last3month = driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownlabel Last 3 months sc-')][contains(text(),'Last 3 months')]"));
		last3month.click();
		Thread.sleep(6000);
		WebElement dropdown_icon = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"));
		dropdown_icon.click();
		Thread.sleep(3000);
		WebElement month_label = driver.findElement(
				By.xpath("//div[contains(text(),'Month')]"));
		month_label.click();
		Thread.sleep(8000);
		WebElement locations_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locations_result.isDisplayed());
		System.out.println("Locations Result is:- "+locations_result.getText());

	}

	public void VerifyExport_CSV_Responses_LocationGroups() throws InterruptedException {
		Thread.sleep(3000);
		WebElement arrowicon_location = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][2]"));
		arrowicon_location.click();
		Thread.sleep(2000);
		WebElement Locationsgrp = driver
				.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Location Groups sc-')][contains(text(),'Location Groups')]"));
		Locationsgrp.click();
		Thread.sleep(12000);
		WebElement locationsgrp_result = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(locationsgrp_result.isDisplayed());
		System.out.println("Locations Group Resullt:- " + locationsgrp_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="responses_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}		
	}

	public void VerifyExport_PDF_Responses_LocationGroups() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="responses_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void VerifyExport_CSV_Responses_Publishers() throws InterruptedException {
		Thread.sleep(10000);
		WebElement publisher = driver.findElement(By.xpath("//div[contains(text(),'Publishers')]"));
		publisher.click();
		//Thread.sleep(15000);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[2]/div[1]")));
		WebElement publisher_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(publisher_result.isDisplayed());
		System.out.println("Publisher Result is:- "+publisher_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="responses_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}		
	}

	public void Insight_Sentiment_SubMenu() throws InterruptedException {
		Thread.sleep(8000);
		WebElement insight_tab=driver.findElement(By.xpath("//div[contains(text(),'INSIGHTS')]"));
		WebElement sentiment=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Sentiment sc-')][contains(text(),'Sentiment')]"));
		Actions act=new Actions(driver);
		act.moveToElement(insight_tab).perform();
		act.moveToElement(sentiment).click().perform();
	}

	public void VerifyExport_CSV_Sentiment_AllTopics() throws InterruptedException {
		Thread.sleep(10000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="sentiment_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}		
	}

	public void VerifyExport_PDF_Sentiment_AllTopics() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="sentiment_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void Verify_Sentiment_ShareByEmail() throws InterruptedException {
		Thread.sleep(5000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement email_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Share by Email sc-')][contains(text(),'Share by Email')]"));
		email_icon.click();
		Thread.sleep(6000);
		WebElement schedule_new=driver.findElement(By.xpath("//div[contains(text(),'NEW SCHEDULE')]"));
		schedule_new.click();
		Thread.sleep(5000);
		WebElement saveas_field=driver.findElement(By.xpath("//input[@placeholder='Schedule Name']"));
		saveas_field.clear();
		saveas_field.sendKeys("Test");
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
		while(true) {
			String text=driver.findElement(By.xpath("//div[@class='react-datepicker__current-month'][contains(text(),'January 2021')]")).getText();
		
			if(text.equals(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next'][contains(text(),'Next month')]")).click();
			}
		}
		driver.findElement(By.xpath("//div[starts-with(@class,'react-datepicker__day react-datepicker__day--sun')][contains(text(),'10')]")).click();
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
		Thread.sleep(3000);
		trigger.click();
		Thread.sleep(2000);
		email_icon.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Select all')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		System.out.println("Email Scheduler Deleted successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
	}

	public void VerifySentimnet() throws InterruptedException {
		Thread.sleep(8000);
		WebElement popover = driver
				.findElement(By.xpath("//i[starts-with(@class,'material-icons  sc-')][contains(text(),'date_range')]"));
		popover.click();
		Thread.sleep(2000);
		WebElement last3month = driver.findElement(By.xpath(
				"//div[starts-with(@class,'dropdownlabel Last 3 months sc-')][contains(text(),'Last 3 months')]"));
		last3month.click();
		Thread.sleep(6000);
		WebElement dropdown_icon = driver
				.findElement(By.xpath("/descendant::i[starts-with(@class,'material-icons  sc-')][contains(normalize-space(),'arrow_drop_down')][1]"));
		dropdown_icon.click();
		Thread.sleep(3000);
		WebElement month_label = driver.findElement(
				By.xpath("//div[contains(text(),'Month')]"));
		month_label.click();
		Thread.sleep(8000);
		WebElement alltopic_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(alltopic_result.isDisplayed());
		System.out.println("Topic Result is:- "+alltopic_result.getText());	
	}

	public void VerifyExport_CSV_Sentiment_monitoredTopics() throws InterruptedException {
		Thread.sleep(8000);
		WebElement alltopic=driver.findElement(By.xpath("/descendant::div[contains(text(),'All Topics')][1]"));
		WebElement monitortopic=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Monitored Topics sc-')][contains(text(),'Monitored Topics')]"));
		Actions act=new Actions(driver);
		act.moveToElement(alltopic).perform();
		act.moveToElement(monitortopic).click().perform();
		Thread.sleep(8000);
		WebElement monitortopic_result=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
		Assert.assertTrue(monitortopic_result.isDisplayed());
		System.out.println("Monitored Topic Result is:- "+monitortopic_result.getText());
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(8000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="sentiment_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".csv";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String csvfile=file.getName();
				System.out.println("CSV file download :- "+csvfile);
				file.delete();
				break;
			}
		}		
	}

	public void VerifyExport_PDF_Sentiment_monitoredTopics() throws InterruptedException {
		Thread.sleep(2000);
		WebElement trigger=driver.findElement(By.xpath("//div[starts-with(@class,'sc-')][@color='#455A64']"));
		trigger.click();
		Thread.sleep(2000);
		WebElement filedownload_icon=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel Export sc-')][contains(text(),'Export')]"));
		filedownload_icon.click();
		Thread.sleep(2000);
		WebElement format_type=driver.findElement(By.xpath("//span[contains(text(),'.pdf')]"));
		format_type.click();
		Thread.sleep(2000);
		WebElement export_btn=driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'EXPORT')]"));
		export_btn.click();
		Thread.sleep(20000);
		File filelocaitons = new File(downloadPath);
		File[] totalfiles=filelocaitons.listFiles();
		String file_Name="sentiment_export_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date())+".pdf";
		for(File file:totalfiles) {
			if(file.getName().equals(file_Name)) {
				String pdffile=file.getName();
				System.out.println("PDF file download :- "+pdffile);
			file.delete();
			break;
			}}
	}

	public void VerifyTopic_cloud() throws InterruptedException {
		Thread.sleep(8000);
		WebElement topicloud=driver.findElement(By.xpath("//div[contains(text(),'Topic Cloud')]"));
		topicloud.click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[contains(text(),'manager')]")).click();
		Thread.sleep(8000);
		WebElement trendresult=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]"));
		Assert.assertTrue(trendresult.isDisplayed());
	System.out.println("Manager Topic Trend Result is:-  "+trendresult.getText());
	Thread.sleep(2000);
	driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
	Thread.sleep(8000);
	driver.findElement(By.xpath("//div[contains(text(),'cheesecake factory')]")).click();
	Thread.sleep(8000);
	WebElement cheesecakeresult=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]"));
	Assert.assertTrue(cheesecakeresult.isDisplayed());
	System.out.println("CheeseCacke Factory Topic Trend Result is:-  "+cheesecakeresult.getText());
	}

	}
