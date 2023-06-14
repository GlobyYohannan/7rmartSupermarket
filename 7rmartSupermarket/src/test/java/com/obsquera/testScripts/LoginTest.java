package com.obsquera.testScripts;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsquera.pageScripts.LoginPage;
import com.obsquera.utilities.ExcelUtility;

public class LoginTest extends Base{
	LoginPage loginpage;
	public String expectedmanagePageTileTitle="Manage Pages";
	public String expectedAlertPageTitle="Alert!";
	@Test(priority = 1,description = "TC001_Verify home page title",groups = {"Regression","Smoke"})
	public void verifyTheUserCanAbletoLoginwithValidusernameandValidPasswordWhileClickonSignInButton()
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage")).clickOnSignInButton();
		String managePageTitle=loginpage.getLoginPageManagePageTileTitleAssertion();
		assertEquals(expectedmanagePageTileTitle,managePageTitle,"Login page is not loaded");
	}
	
	@Test(priority = 2,description = "TC006_Verify home page title",groups = {"Regression"})
	public void verifyTheUserCannotBeAbletoLoginwithInValidusernameandValidPasswordWhileClickonSignInButton()
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(2, 0, "LoginPage")).enterPasswordOnPasswordField(ExcelUtility.getString(2, 1, "LoginPage")).clickOnSignInButton();
		String alertPageTitle=loginpage.getAlertMessageOfIncorrectUsernamePassword();
		assertEquals(expectedAlertPageTitle,alertPageTitle,"Login page is  loaded even if username is invalid");
	}
	
	@Test(priority = 3,description = "TC006_Verify home page title",groups = {"Smoke"})
	@Parameters({"username","password"})
	public void verifyTheUserCannotBeAbletoLoginwithValidusernameandInValidPasswordWhileClickonSignInButton(String username, String password)
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		String alertPageTitle=loginpage.getAlertMessageOfIncorrectUsernamePassword();
		assertEquals(expectedAlertPageTitle,alertPageTitle,"Login page is  loaded even if password is invalid");
		
	}
	
	@Test(priority = 4,description = "TC006_Verify home page title",groups = {"Smoke"})
	public void verifyTheUserCannotBeAbletoLoginwithInValidusernameandInValidPasswordWhileClickonSignInButton()
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(3, 0, "LoginPage")).enterPasswordOnPasswordField(ExcelUtility.getString(3, 1, "LoginPage")).clickOnSignInButton();
		String alertPageTitle=loginpage.getAlertMessageOfIncorrectUsernamePassword();
		assertEquals(expectedAlertPageTitle,alertPageTitle,"Login page is  loaded even if username and password is invalid");
	}
}
