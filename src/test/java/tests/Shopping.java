package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BrowserLaunch;
import pages.HomePage;
import pages.ShoppingPage;
import util.ExcelDataProvider;

public class Shopping extends BrowserLaunch{
	ExcelDataProvider excel= new ExcelDataProvider();
	

	@Test(priority = 0,groups = "regression")
	public void validate_empty_cart() throws IOException
	{
		ShoppingPage shopping = new ShoppingPage(driver,logger);
		HomePage home = new HomePage(driver,logger);
		home.navigate_to_homepage();
		shopping.empty_cart();
		
	}
	
	@Test(priority = 1,groups = {"smoke","regression"})
	public void add_yoga_product() throws IOException, InterruptedException
	{
		ShoppingPage shopping = new ShoppingPage(driver,logger);
		HomePage home = new HomePage(driver, logger);
		home.navigate_to_homepage();
		shopping.yoga_product();
		
	}

}
