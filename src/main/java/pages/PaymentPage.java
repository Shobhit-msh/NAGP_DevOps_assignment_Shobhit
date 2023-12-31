package pages;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import util.Utility;

public class PaymentPage
{
	
	WebDriver driver;
	Logger logger;
	
	@FindBy(xpath = "//button[@title='Proceed to Checkout']")
	WebElement proceed_to_checkout_btn;
	
	@FindBy(xpath = "//a[@class='action showcart']")
	WebElement shopping_cart_btn;
	
	@FindBy(xpath = "//li[@class='checkout-shipping-address']")
	WebElement shipping_details;
	
	@FindBy(xpath = "//li[@id='shipping']//input[@id='customer-email']")
	WebElement email_txtbox;
	
	@FindBy(xpath = "//li[@id='shipping']//input[@name='firstname']")
	WebElement firstname_txtbox;
	
	@FindBy(xpath = "//li[@id='shipping']//input[@name='lastname']")
	WebElement lastname_txtbox;
	
	@FindBy(xpath = "//li[@id='shipping']//input[@name='street[0]']")
	WebElement address_txtbox;
	
	@FindBy(xpath="//li[@id='shipping']//input[@name='city']")
	WebElement city_txtbox;
	
	@FindBy(xpath="//li[@id='shipping']//select[@name='region_id']")
	WebElement state_drpdpwn;
	
	@FindBy(xpath="//li[@id='shipping']//select[@name='country_id']")
	WebElement country_drpdpwn;
	
	@FindBy(xpath = "//li[@id='shipping']//input[@name='postcode']")
	WebElement zipcode_txtbox;	
	
	@FindBy(xpath = "//li[@id='shipping']//input[@name='telephone']")
	WebElement phoneno_txtbox;
	
	@FindBy(xpath = "//input[@value='flatrate_flatrate']")
	WebElement shipping_method;
	
	@FindBy(xpath = "//button/span[text()='Next']")
	WebElement next_btn;	
	
	@FindBy(xpath="//button/span[text()='Place Order']")
	WebElement place_order_btn;
	
	@FindBy(xpath="//h1/span[text()='Thank you for your purchase!']")
	WebElement purchase_complete_msg;

	
	
	public PaymentPage(WebDriver driver,Logger logger)
	{
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	
	public void validate_checkout() throws IOException, InterruptedException {
		Utility.scroll_to_element(driver, shopping_cart_btn);
		shopping_cart_btn.click();
		logger.info("Clicked On shopping cart Button");
		Utility.wait_for_element_to_visible(driver, 10, proceed_to_checkout_btn);
		proceed_to_checkout_btn.click();
		logger.info("Clicked On Proceed to cart button.");
		Utility.wait_for_element_to_visible(driver, 10, firstname_txtbox);
		
	}
	
	public void purchase_product(String email,String fName,String lName,String address,String city,String state,String zip,String phone) throws IOException {
		
		Utility.wait_for_element_to_visible(driver, 10, firstname_txtbox);
		email_txtbox.sendKeys(email);
		logger.info("Entering Email as : "+email+"");
		firstname_txtbox.sendKeys(fName);
		logger.info("Entering Firstname as :"+fName+"");
		lastname_txtbox.sendKeys(lName);
		logger.info("Entering lastname as : "+lName+"");
		address_txtbox.sendKeys(address);
		logger.info("Entering Address as : "+address+"");
		city_txtbox.sendKeys(city);
		logger.info("Entering Address as :"+city+"");
		state_drpdpwn.click();
		Utility.select_value_from_drpdwn(state_drpdpwn, "Alaska");
		logger.info("Selecting State as : "+state+"");
		zipcode_txtbox.sendKeys(zip);
		logger.info("Entering Zipcode as : "+zip+"");
		phoneno_txtbox.sendKeys(phone);
		logger.info("Entering Phone Number as : "+phone+"");
		shipping_method.click();
		logger.info("Clicked on Create an Account button");
		next_btn.click();
		logger.info("Clicked on Next Button");
		Utility.wait_for_element_to_visible(driver, 10, place_order_btn);
		Utility.wait_for_element_to_clicked(driver, 10, place_order_btn);
		Utility.click_through_js_executor(driver, place_order_btn);
		logger.info("Clicked on Place an Order Button");
		Utility.wait_for_element_to_visible(driver, 10, purchase_complete_msg);
		
	}
	
	
}