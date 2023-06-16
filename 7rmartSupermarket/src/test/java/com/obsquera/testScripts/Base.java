package com.obsquera.testScripts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.obsquera.utilities.GeneralUtility;
import com.obsquera.utilities.ScreenShotUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;
	ScreenShotUtility scrshot;
	public Properties prop;
	FileInputStream fs;
	
	@BeforeMethod
	@Parameters("browser")
	public void initializeBrowser(@Optional("chrome") String browser) throws Exception
	{  
		try 
		{
			prop = new Properties();
			fs = new FileInputStream(GeneralUtility.CONFIGfILE);
			prop.load(fs);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
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
		
		driver.get(prop.getProperty("url"));
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
