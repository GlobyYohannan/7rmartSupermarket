package com.obsquera.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsquera.pageScripts.LoginPage;
import com.obsquera.pageScripts.ManageDeliveryBoyPage;
import com.obsquera.pageScripts.ManageSliderPage;
import com.obsquera.utilities.ExcelUtility;

public class ManageSliderTest extends Base{

	LoginPage loginpage;
	ManageSliderPage manageslider;
	@Test(description = "TC9_Verify user is able to add datas to delivery boy list",dataProvider = "links")
	
	public void userCanAbleToAddNewSlider(String link)
	{   
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		manageslider=new ManageSliderPage(driver);
		manageslider.clickOnManageSliderPageTileMoreInfoButton().clickOnNewButton().uploadFile().pageScrollDown();
		manageslider.enterLinkInLinkTextField(link);
		manageslider.clickOnSaveButton();
		boolean actualSuccessAlertFieldStatus=manageslider.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to add new slider to list slider page");
	}
	@Test(description="TC10_Verify that user can able to update the status in List sliders page")

	public void checkWhetherUserIsAbleToUpdateStatusOfSliderPage()
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		manageslider=new ManageSliderPage(driver);
		manageslider.clickOnManageSliderPageTileMoreInfoButton().clickOnActiveStatusButton();
		boolean actualSuccessAlertFieldStatus=manageslider.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to change status of list slider page");
		
	}
	@DataProvider(name = "links")
	public Object[][] getLinks() {
		
		return new Object[][] 
		    	{
					{"www.google.com"}
		        };
		};
}
