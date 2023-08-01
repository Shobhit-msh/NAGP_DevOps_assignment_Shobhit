package pages;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import util.Utility;

public class SigninPage
{
	
	WebDriver driver;
	ExtentTest tests;
	Logger logger;
	
	@FindBy(xpath = "//header//a[(contains(text(),'Sign In'))]")
	WebElement signin;
	
	@FindBy(xpath = "//header//a[(contains(text(),'Create an Account'))]")
	WebElement create_an_account;
	
	@FindBy(id = "email")
	WebElement email_txtbox;
	
	@FindBy(id = "pass")
	WebElement password_txtbox;
	
	@FindBy(xpath="//button[@class='action login primary']")
	WebElement signin_btn;
	
	@FindBy(xpath="//div[@role='alert']//div[text()='Incorrect CAPTCHA']")
	WebElement invalid_captcha;
	
	@FindBy(id = "firstname")
	WebElement firstname_txtbox;
	
	@FindBy(id = "lastname")
	WebElement lastname_txtbox;
	
	@FindBy(id = "email_address")
	WebElement email_input_txtbox;
	
	@FindBy(id = "password")
	WebElement password_input_txtbox;
	
	@FindBy(id = "password-confirmation")
	WebElement confirm_password_txtbox;
	
	@FindBy(xpath = "//button/span[text()='Create an Account']")
	WebElement create_account_btn;	
	

	@FindBy(xpath="//div[@role='alert']//div[text()='Thank you for registering with Main Website Store.']")
	WebElement successful_account_creation_msg;

	@FindBy(xpath="(//button[@class='action switch'])[1]")
	WebElement arrow_btn;
	@FindBy(xpath="(//a[contains(text(),'Sign Out')])[1]")
	WebElement sign_out;
	
	
	
	public SigninPage(WebDriver driver,ExtentTest tests,Logger logger)
	{
		this.driver=driver;		
		this.tests=tests;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	
	public void validate_invalid_signin(String username, String password) throws IOException {
		logger.info("Navigating to Sign In Page");
		tests.info("Navigating to Sign In Page");
		signin.click();
		logger.info("Clicked On sign in link.");
		email_txtbox.sendKeys(username);
		logger.info("Entering email as:"+username+"");
		tests.info("Entering email as: <b>"+username+"</b>");
		password_txtbox.sendKeys(password);
		logger.info("Entering password as:"+password+"");
		tests.info("Entering password as: <b>"+password+"</b>");
		signin_btn.click();
		logger.info("Clicking on Sign in button");
		tests.info("Clicking on Sign in button");
		Utility.wait_for_element_to_visible(driver, 10, invalid_captcha);
		invalid_captcha.isDisplayed();
		tests.pass("Invalid Captcha Error Message Displayed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.getscreenshot(driver,"Invalid_sign_in")).build());
		
	}
	
	public void create_account(String firstName,String lastName,String password) throws IOException {
		
		create_an_account.click();
		tests.info("CLicked on Create an account link.");
		logger.info("CLicked on Create an account link.");
		Utility.wait_for_element_to_visible(driver, 10, firstname_txtbox);
		firstname_txtbox.sendKeys(firstName);
		logger.info("Entering firstname as :"+firstName+"");
		tests.info("Entering firstname as : <b>"+firstName+"</b>");
		lastname_txtbox.sendKeys(lastName);
		logger.info("Entering lastname as :"+lastName+"");
		tests.info("Entering lastname as : <b>"+lastName+"</b>");
		String email=generateRandomString()+"@gmail.com";
		email_input_txtbox.sendKeys(email);
		logger.info("Entering Email as : "+email+"");
		tests.info("Entering Email as : <b>"+email+"</b>");
		password_input_txtbox.sendKeys(password);
		logger.info("Entering Password as : "+password+"");
		tests.info("Entering Password as : <b>"+password+"</b>");
		confirm_password_txtbox.sendKeys(password);
		logger.info("Entering Confirm Password as :"+password+"");
		tests.info("Entering Confirm Password as : <b>"+password+"</b>");
		create_account_btn.click();
		logger.info("Clicked on Create an Account button");
		tests.info("Clicked on Create an Account button");
		Utility.wait_for_element_to_visible(driver, 10, successful_account_creation_msg);
		successful_account_creation_msg.isDisplayed();
		tests.pass("Account Created Sucessfully", MediaEntityBuilder.createScreenCaptureFromPath(Utility.getscreenshot(driver,"sign_up")).build());
		arrow_btn.click();
		sign_out.click();
	}
	
	
	
	public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(5);
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int randomIndex = rand.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}