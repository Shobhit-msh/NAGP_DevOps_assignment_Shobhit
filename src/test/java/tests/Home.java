package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BrowserLaunch;
import pages.HomePage;

public class Home extends BrowserLaunch{

	@Test(groups = {"smoke","regression"})
	public void homepage_element_validation()
	{
		HomePage home = new HomePage(driver,logger);
		home.home_page_validation();
	}
	
	@Test(groups = {"smoke","regression"})
	public void homepage_search() throws IOException
	{
		HomePage home = new HomePage(driver,logger);
		home.home_page_search_validation("T Shirts");
		
	}

}
