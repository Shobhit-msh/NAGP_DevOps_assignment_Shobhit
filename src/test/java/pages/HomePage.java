package pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import util.Utility;

public class HomePage
{
	WebDriver driver;
	Logger logger;
	
	@FindBy(xpath="//a[@aria-label='store logo']")
	WebElement logo;
	
	@FindBy(xpath = "//header//a[(contains(text(),'Sign In'))]")
	WebElement signin;
	
	@FindBy(xpath = "//header//a[text()='Create an Account']")
	WebElement create_account;
	
	@FindBy(xpath="//nav//a//span[text()='Women']")
	WebElement women_drpdwn;

	@FindBy(xpath="//nav//a//span[text()='Men']")
	WebElement men_drpdwn;
	
	@FindBy(xpath="//nav//a//span[text()='Gear']")
	WebElement gear_drpdwn;
	
	@FindBy(xpath="//nav//a//span[text()='Training']")
	WebElement training_drpdwn;
	
	@FindBy(xpath="//nav//a//span[text()='Sale']")
	WebElement sale_drpdwn;
	
	@FindBy(xpath= "//input[@id='search']")
	WebElement search_box;
	@FindBy(xpath= "//button[@title='Search']")
	WebElement search_btn;
	
	
	public HomePage(WebDriver driver,Logger logger)
	{
		this.driver=driver;	
		this.logger=logger;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void home_page_validation() {
		//validating that all the buttons and links visible on homepage
		logger.info("Navigated to Home Page");
		logo.isDisplayed();
		logger.info("Logo is displayed");
		signin.isDisplayed();
		logger.info("Sign In link is displayed");
		create_account.isDisplayed();
		logger.info("Create Account Link is displayed");
		women_drpdwn.isDisplayed();
		logger.info("Dropdown for Women Section is displayed");
		men_drpdwn.isDisplayed();
		logger.info("Dropdown for Men Section is displayed");
		gear_drpdwn.isDisplayed();
		logger.info("Dropdown for Gear Section is displayed");
		training_drpdwn.isDisplayed();
		logger.info("Dropdown for Training Section is displayed");
		sale_drpdwn.isDisplayed();
		logger.info("Dropdown for Sale Section is displayed");
		
	}
	
	public void home_page_search_validation(String text) throws IOException {
		logger.info("Navigated to Home Page");
		search_box.sendKeys(text);
		logger.info("Entering "+text+" in Search Box on Homepage.");
		search_btn.click();
		logger.info("Clicking on Search Button");
		Utility.wait_for_element_to_visible(driver, 0, driver.findElement(By.xpath("//h1/span[text()=\"Search results for: '"+text+"'\"]")));
		logger.info("Search Results are Visible for "+text+"</b>\"");
		
	}
	
	public void navigate_to_homepage()
	{
		logo.click();
	}
}