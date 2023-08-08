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

	
	
	public ShoppingPage(WebDriver driver,Logger logger)
	{
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	public void empty_cart() throws IOException
	{
		logger.info("Navigated to Home Page");
		cart.click();
		logger.info("Clicked On Cart Button");
		Utility.wait_for_element_to_visible(driver, 10, empty_cart_msg);
		if(empty_cart_msg.isDisplayed())
		{
			logger.info("Empty Cart message is visible");
			
		}
	}
	
	public void yoga_product() throws IOException, InterruptedException
	{
		logger.info("Navigated to Home Page");
		shop_new_yoga_btn.click();
		logger.info("Clicked on Shop New Yoga Button");
		Utility.wait_for_element_to_visible(driver, 10, yoga_collection);
		logger.info("Yoga collection is displayed");
		select_size.click();
		logger.info("Selecting the size for the product");
		Utility.click_and_wait(select_colour);
		logger.info("Selecting Colour for the product");
		Utility.click_and_wait(add_to_cart_btn);
		logger.info("Clicked on Add to Cart button.");
		Utility.wait_for_element_to_visible(driver, 10, success_add_msg);
		String msg=success_add_msg.getText();
		logger.info("Product Added Successfully with message "+msg+"");
		
	}

}