package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BrowserLaunch;
import pages.HomePage;
import pages.PaymentPage;
import pages.ShoppingPage;
import pages.SigninPage;
import util.ExcelDataProvider;

public class PlaceOrder extends BrowserLaunch{
	ExcelDataProvider excel= new ExcelDataProvider();
	


	@Test(priority = 0,groups = "regression")
	public void validate_checkout_option() throws IOException, InterruptedException
	{
		tests=reports.createTest("TC: Checkout Cart Validation");
		tests.log(Status.INFO, "<b>In this test we are adding a product and validating checkout page.</b>");
		PaymentPage payment= new PaymentPage(driver,tests,logger);
		ShoppingPage shopping = new ShoppingPage(driver,tests,logger);
		HomePage home = new HomePage(driver, tests,logger);
		home.navigate_to_homepage();
		shopping.yoga_product();
		payment.validate_checkout();
	}
	
	@Test(dataProvider = "shipping_address",priority = 1,groups = {"smoke","regression"})
	public void place_an_order(String email, String firstname, String lastname, String address, String city, String state, String zipcode, String phoneno) throws IOException, InterruptedException
	{
		tests=reports.createTest("TC: Place an Order Validation");
		tests.log(Status.INFO, "<b>In this test we are adding a product and purchasing it.</b>");
		PaymentPage payment= new PaymentPage(driver,tests,logger);
		ShoppingPage shopping = new ShoppingPage(driver,tests,logger);
		HomePage home = new HomePage(driver, tests,logger);
		home.navigate_to_homepage();
		shopping.yoga_product();
		payment.validate_checkout();
		payment.purchase_product(email,firstname,lastname,address,city,state,zipcode,phoneno);
	}

	
	
	
	@DataProvider(name="shipping_address")
	public Object[][] getLoginData()	{		
		Object[][] data =excel.getData("Shipping_Details");		
		return data;
	}
	
}
