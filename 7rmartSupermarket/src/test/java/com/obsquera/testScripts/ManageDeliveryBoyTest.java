package com.obsquera.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsquera.pageScripts.ManageDeliveryBoyPage;
import com.obsquera.pageScripts.LoginPage;
import com.obsquera.utilities.ExcelUtility;
import com.obsquera.utilities.PageUtility;
import com.obsquera.utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginpage;
	RandomDataUtility randomutility;
	PageUtility pageutilty;
	ManageDeliveryBoyPage categorypage;
	@Test(description = "TC6_Verify user is able to add datas to delivery boy list")
	@Parameters({"deliveryboyname","deliveryboyusername"})
	public void userIsAbleToAddDatasToListDeliveryBoy(String deliveryboyname, String deliveryboyusername)
	{   randomutility=new RandomDataUtility();
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		categorypage=new ManageDeliveryBoyPage(driver);
		categorypage.clickOnManageDeliveryBoyTileMoreInfoButton().clickOnNewButton().userCanAbleToEnterNameInTextField(deliveryboyname).userCanAbleToEnterUserNameInTextField(deliveryboyusername).userCanAbleToEnterPasswordInTextField(randomutility.togetpass()).pageScrollDown().clickOnSaveButton();
		boolean actualSuccessAlertFieldStatus=categorypage.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to enter datas to list delivery Boypage");
	}
	
	@Test(description = "TC7_Verify user is able to search names in list Delivery Boy page",dataProvider="LoginProvider")
	
	public void checkWhetherUserIsAbleToSearchNamesInDeliveryBoyPages(String deliveryboyname)
	{   
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		categorypage=new ManageDeliveryBoyPage(driver);
		categorypage.clickOnManageDeliveryBoyTileMoreInfoButton().clickOnSearchButton().enterDatatoSearchTextField(deliveryboyname).clickOnSearchButtoninsideSearchListPagesBand();
		boolean searchContentFoundStatus=categorypage.checkWhetherResponseTableContainsCorrespondingEntry(deliveryboyname);
		assertTrue(searchContentFoundStatus,"User is not able to search names in list Delivery Boy pages");
			}
	
	
	@Test(description="TC8_Verify that user can able to update the status in delivery boy list page")

	public void checkWhetherUserIsAbleToUpdateStatusInDeliveryBoyListPage()
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		categorypage=new ManageDeliveryBoyPage(driver);
		categorypage.clickOnManageDeliveryBoyTileMoreInfoButton().clickOnActiveStatusButton();
		boolean actualSuccessAlertFieldStatus=categorypage.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to change status of list delivery Boy page");
		
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		
		return new Object[][] 
		    	{
		            {"Globy"}
		        };
		};
}
