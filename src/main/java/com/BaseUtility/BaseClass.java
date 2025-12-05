package com.BaseUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Generic.WebdriverUtility.JavaUtility;
import com.Generic.WebdriverUtility.UtilityClassObject;
import com.Generic.WebdriverUtility.WebDriverUtility;
import com.GenericFileUtility.ExcelUtility;
import com.GenericFileUtility.FileUtility;
import com.databaseUtility.DatabaseUtility;
import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;



public class BaseClass {

	public	DatabaseUtility dbutil= new DatabaseUtility();
	public	FileUtility futil = new FileUtility();
	public	ExcelUtility eutil = new ExcelUtility();
	public	JavaUtility jutil = new JavaUtility();
	public	WebDriverUtility wutil = new WebDriverUtility();
	public	WebDriver driver= null;
	public static WebDriver sdriver=null;
		
		@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
		public void configBS() {
			System.out.println("==connect to DB, report Config");
			dbutil.getDBConnection();
		}
		
		//@Parameters("BROWSER")
		@BeforeClass(groups = {"SmokeTest","RegressionTest"})
		public void configBC(/*String BROWSER*/) throws Throwable  {
			System.out.println("==launch browser");
			
			//String BROWSER = futil.getDataFromPropertiesFile("browser");
			String BROWSER=System.getProperty("browser",futil.getDataFromPropertiesFile("browser"));
			if(BROWSER.equals("chrome")) {
				driver= new ChromeDriver();
			}else if(BROWSER.equals("firefox")) {
				driver= new FirefoxDriver();
			}else if(BROWSER.equals("edge")) {
				driver= new EdgeDriver();
			}else {
				driver = new ChromeDriver();
			}	
			sdriver=driver;
			UtilityClassObject.setDriver(driver);
		}
		
		@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
		public void configBM() throws Throwable {
			
			System.out.println("==login==");
		//String URL = futil.getDataFromPropertiesFile("url");
			//String UN = futil.getDataFromPropertiesFile("username");
			//String PWD=futil.getDataFromPropertiesFile("Password");
			
			//fetching from cmd line
			String URL=System.getProperty("url",futil.getDataFromPropertiesFile("url"));
			String UN=System.getProperty("username",futil.getDataFromPropertiesFile("username"));
			String PWD=System.getProperty("Password",futil.getDataFromPropertiesFile("Password"));
			
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(URL, UN, PWD);
			
		}
		
		@AfterMethod(groups = {"SmokeTest","RegressionTest"})
		public void configAM() throws InterruptedException {
		System.out.println("==logout==");
			HomePage hp = new HomePage(driver);
			hp.signOut();
		}
		
		@AfterClass(groups = {"SmokeTest","RegressionTest"})
		public void configAC() {
			System.out.println("==close browser==");
			driver.quit();
		}
		
		@AfterSuite(groups = {"SmokeTest","RegressionTest"})
		public void configAS() {
			System.out.println("==close DB connection, report backup==");
			dbutil.closeDBConnection();
		}

}
