package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import util.Utility;

public class BrowserLaunch {
	
	public static WebDriver driver;
	public static FileReader fr;
	public static Properties prop = new Properties();
	public String user_dir;
	public static Logger logger;
	
	@BeforeSuite(alwaysRun = true)
	public void startReporter() throws IOException
	{
		logger=Logger.getLogger("Logger");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Initializing extent report");
		user_dir=System.getProperty("user.dir");		
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		if(driver==null)
		{
			fr= new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
			prop.load(fr);	
			logger.info("Reading data from property file.");
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{

			driver = new ChromeDriver();
			logger.info("Chrome Browser started.");
			driver.get(prop.getProperty("testurl"));
			logger.info("Navigated to"+prop.getProperty("testurl"));
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			logger.info("FIrefox Browser started.");
			driver.get(prop.getProperty("testurl"));
			logger.info("Navigated to"+prop.getProperty("testurl"));
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			logger.info("Edge Browser started.");
			driver.get(prop.getProperty("testurl"));
			logger.info("Navigated to"+prop.getProperty("testurl"));
		}
		driver.manage().window().maximize();
		logger.info("Maximizing the browser window.");
			
	}
	
	@AfterMethod(alwaysRun = true)
	public void check_tc_status(ITestResult result)
	{
		System.out.println(result.getName());
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.info("Capturing the screenshot since the testcase got failed.");
		}
		driver.quit();
	}
	
}

