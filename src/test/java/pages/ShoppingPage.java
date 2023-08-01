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

public class ShoppingPage
{
	WebDriver driver;
	ExtentTest tests;
	Logger logger;
	
	@FindBy(xpath="//a[@class=\"action showcart\"]")
	WebElement cart;
	
	@FindBy(xpath = "//*[@id='minicart-content-wrapper']/div[2]/strong[text()='You have no items in your shopping cart.']")
	WebElement empty_cart_msg;
	
	@FindBy(xpath = "//span[text()='Shop New Yoga']")
	WebElement shop_new_yoga_btn;
	
	@FindBy(xpath="//span[text()='New Luma Yoga Collection']")
	WebElement yoga_collection;

	@FindBy(xpath="(//div[@class='swatch-attribute size']/div/div)[1]")
	WebElement select_size;
	
	@FindBy(xpath="(//div[@class='swatch-option color'])[1]")
	WebElement select_colour;
	
	@FindBy(xpath="(//button[@title='Add to Cart'])[1]")
	WebElement add_to_cart_btn;
	
	@FindBy(xpath="//div[@role='alert']/div/div[contains(text(),'You added Echo Fit Compression Short to your')]")
	WebElement success_add_msg;

	
	
	public ShoppingPage(WebDriver driver,ExtentTest tests,Logger logger)
	{
		this.driver=driver;		
		this.tests=tests;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	public void empty_cart() throws IOException
	{
		tests.info("Navigated to Home Page");
		logger.info("Navigated to Home Page");
		cart.click();
		tests.info("Clicked On Cart Button");
		logger.info("Clicked On Cart Button");
		Utility.wait_for_element_to_visible(driver, 10, empty_cart_msg);
		if(empty_cart_msg.isDisplayed())
		{
			tests.info("Empty Cart message is visible");
			logger.info("Empty Cart message is visible");
			tests.pass("Empty Cart Validation Passed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.getscreenshot(driver,"empty_cart")).build());
			
		}
	}
	
	public void yoga_product() throws IOException, InterruptedException
	{
		tests.info("Navigated to Home Page");
		logger.info("Navigated to Home Page");
		shop_new_yoga_btn.click();
		tests.info("Clicked on Shop New Yoga Button");
		logger.info("Clicked on Shop New Yoga Button");
		Utility.wait_for_element_to_visible(driver, 10, yoga_collection);
		tests.info("Yoga collection is displayed");
		logger.info("Yoga collection is displayed");
		select_size.click();
		tests.info("Selecting the size for the product");
		logger.info("Selecting the size for the product");
		Utility.click_and_wait(select_colour);
		tests.info("Selecting Colour for the product");
		logger.info("Selecting Colour for the product");
		Utility.click_and_wait(add_to_cart_btn);
		tests.info("Clicked on Add to Cart button.");
		logger.info("Clicked on Add to Cart button.");
		Utility.wait_for_element_to_visible(driver, 10, success_add_msg);
		String msg=success_add_msg.getText();
		tests.info("Product Added Successfully with message <b>"+msg+"</b>");
		logger.info("Product Added Successfully with message "+msg+"");
		tests.pass("Product Added Validation Passed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.getscreenshot(driver,"product_add")).build());
		
	}

}