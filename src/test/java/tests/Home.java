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
		tests=reports.createTest("TC: Home Page Validation");
		tests.log(Status.INFO, "<b>In this Test Case we are doing validations on Homepage like Logo, dropdowns etc.</b>");
		HomePage home = new HomePage(driver,tests,logger);
		home.home_page_validation();
	}
	
	@Test(groups = {"smoke","regression"})
	public void homepage_search() throws IOException
	{
		tests=reports.createTest("TC: Home Page Search Validation");
		tests.log(Status.INFO, "<b>In this Test Case we searching text in searchbox and validating the results.</b>");
		HomePage home = new HomePage(driver,tests,logger);
		home.home_page_search_validation("T Shirts");
		
	}

}
