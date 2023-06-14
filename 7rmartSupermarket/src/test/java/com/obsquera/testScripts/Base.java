package com.obsquera.testScripts;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.obsquera.utilities.ScreenShotUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;
	ScreenShotUtility scrshot;
	
	@BeforeMethod
	@Parameters("browser")
	public void initializeBrowser(@Optional("chrome") String browser) throws Exception
	{
		if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();

		}

		else if (browser.equalsIgnoreCase("chrome")) {
			
			driver= WebDriverManager.chromedriver().create();
		}

		else if (browser.equalsIgnoreCase("edge")) 
		{

			driver = WebDriverManager.edgedriver().create();
		} 
		else 
		{
			throw new Exception("Browser is not correct");
		}
		
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException 
	{
		if (iTestResult.getStatus() == ITestResult.FAILURE)
		{
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
