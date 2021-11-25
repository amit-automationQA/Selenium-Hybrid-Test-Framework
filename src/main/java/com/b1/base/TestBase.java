package com.b1.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {

	 

		public static WebDriver driver;
		public static Properties prop;


		public TestBase() {
			try {
				
				prop = new Properties();
			FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\b1\\config\\config.properties");
				//FileInputStream ip = new FileInputStream("/var/lib/jenkins/workspace/B1AutomationTest/src/main/java/com/b1/config/config.properties");
				prop.load(ip);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public static void initialization() {

			String browserName = prop.getProperty("browser");
			
			if (browserName.equals("chrome")) 
			{
				 
				System.setProperty("webdriver.chrome.driver", ".\\src\\main\\java\\com\\b1\\resourceFiles\\chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/chromedriver");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("window-size=1360,768");
				
				ChromeOptions cap = new ChromeOptions(); 
				cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
				                  UnexpectedAlertBehaviour.IGNORE);
				
						
				/*
				 * DesiredCapabilities cap = DesiredCapabilities.chrome();
				 * cap.setCapability(ChromeOptions.CAPABILITY, options);
				 */
				options.setPageLoadStrategy(PageLoadStrategy.NONE); 
				//options.addArguments("--headless");
		        options.addArguments("start-maximized"); 
		        options.addArguments("enable-automation"); 
		        options.addArguments("--no-sandbox"); 
		        options.addArguments("--disable-infobars"); 
		        options.addArguments("--disable-dev-shm-usage"); 
		        options.addArguments("--disable-browser-side-navigation"); 
		        options.addArguments("--disable-gpu"); 
		        driver = new ChromeDriver(options);
				
			}

			else if (browserName.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", ".\\src\\main\\java\\com\\b1\\resourceFiles\\geckodriver.exe");
				driver = new FirefoxDriver();
				
				 
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		
			  driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 

			driver.get(prop.getProperty("url"));
			
			//driver.get("https://ignite.where2stageit.com/login.html");
			//driver.get("https://ignite.where2getit.com/login.html");
		}

		public static final String AUTOMATE_USERNAME = "brandifyadmins1";
		  public static final String AUTOMATE_ACCESS_KEY = "zaFQuGsddhtCMSpgPtqA";
		  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
		
		  
		  public static void BrowserStack_Invocation() throws MalformedURLException {
			
				//String baseurl = "https://benjerry.where2getit.com/";
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "79.0");
				caps.setCapability("resolution", "1366x768");
				caps.setCapability("project", "B1Automation");
				caps.setCapability("build", "Brandify");
				caps.setCapability("name", "BrandifySub_Pages");
				caps.setCapability("name", "reviews_export");
				//caps.setCapability("browserstack.local", "false");
			    //caps.setCapability("browserstack.selenium_version", "3.14.0");

				    driver = new RemoteWebDriver(new URL(URL), caps);
				    driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
			        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			        driver.get(prop.getProperty("url"));
			}
		}
	