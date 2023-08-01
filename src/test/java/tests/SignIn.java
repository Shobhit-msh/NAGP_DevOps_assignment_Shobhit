package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BrowserLaunch;
import pages.HomePage;
import pages.SigninPage;
import util.ExcelDataProvider;

public class SignIn extends BrowserLaunch{
	ExcelDataProvider excel= new ExcelDataProvider();
	


	@Test(dataProvider ="invalid_login_data",groups ="regression")
	public void invalid_sign_in(String username,String password) throws IOException
	{
		tests=reports.createTest("TC: Invalid SignIn Validation");
		tests.log(Status.INFO, "<b>In this test we are entering credentials and not entering captcha to check the validation</b>");
		SigninPage obj = new SigninPage(driver,tests,logger);
		HomePage home = new HomePage(driver, tests,logger);
		home.navigate_to_homepage();
		obj.validate_invalid_signin(username,password);
	}
	
	
	
	@Test(dataProvider ="sign_up_data",groups = {"smoke","regression"} )
	public void sign_up(String firstName,String lastName,String password) throws IOException
	{
		System.out.println(reports);
		tests=reports.createTest("TC: SignUp Validation");
		tests.log(Status.INFO, "<b> In this test we are creating a new account for a fresh user </b>");
		SigninPage obj = new SigninPage(driver,tests,logger);
		HomePage home = new HomePage(driver, tests,logger);
		home.navigate_to_homepage();
		obj.create_account(firstName,lastName,password);				
	}
	
	
	
	
	
	@DataProvider(name="invalid_login_data")
	public Object[][] getLoginData()	{		
		Object[][] data =excel.getData("Invalid_Login");		
		return data;
	}
	
	@DataProvider(name="sign_up_data")
	public Object[][] getSignUpData()	{		
		Object[][] data =excel.getData("Sign_Up");		
		return data;
	}
}
