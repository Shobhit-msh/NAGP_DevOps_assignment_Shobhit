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
		tests=reports.createTest("TC: Empty Shopping Cart Validation");
		tests.log(Status.INFO, "<b>In this test we are validating shopping cart if user have not added any product.</b>");
		ShoppingPage shopping = new ShoppingPage(driver,tests,logger);
		HomePage home = new HomePage(driver, tests,logger);
		home.navigate_to_homepage();
		shopping.empty_cart();
		
	}
	
	@Test(priority = 1,groups = {"smoke","regression"})
	public void add_yoga_product() throws IOException, InterruptedException
	{
		tests=reports.createTest("TC: Add Product to Shopping Cart Validation");
		tests.log(Status.INFO, "<b>In this test we are adding one yoga product to cart.</b>");
		ShoppingPage shopping = new ShoppingPage(driver,tests,logger);
		HomePage home = new HomePage(driver, tests,logger);
		home.navigate_to_homepage();
		shopping.yoga_product();
		
	}

}
