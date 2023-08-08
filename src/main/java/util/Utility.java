package util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriver driver;
	static WebDriverWait wait;
	
	public static String getscreenshot(WebDriver driver,String name){
		
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"/Reports/Screenshots/"+name+System.currentTimeMillis()+".png";
			File dest= new File(path);
			try {
			FileUtils.copyFile(source,dest );
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("Exception while taking snapshot"+e.getMessage());
		}

		return path;
	}
	


	public static void wait_for_element_to_visible(WebDriver driver,int i,WebElement element) throws IOException {
		wait = new WebDriverWait(driver,Duration.ofSeconds(i));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void wait_for_element_to_clicked(WebDriver driver,int i,WebElement element) throws IOException {
		wait = new WebDriverWait(driver,Duration.ofSeconds(i));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void click_through_js_executor(WebDriver driver,WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

	}
	
	public static void scroll_to_element(WebDriver driver,WebElement element) throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 

	}
	
	public static void click_and_wait(WebElement element) throws InterruptedException
	{
		element.click();
		Thread.sleep(5000);
	}
	
	public static void select_value_from_drpdwn(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

}

