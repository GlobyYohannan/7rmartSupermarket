package com.obsquera.testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsquera.pageScripts.ManageDeliveryBoyPage;
import com.obsquera.pageScripts.LoginPage;
import com.obsquera.utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {

	@Test(description = "TC1_Verify user is able to add datas to delivery boy list")
	@Parameters({"deliveryboyname","deliveryboyusername","deliveryboypassword"})
	public void userIsAbleToAddDatasToListDeliveryBoy(String deliveryboyname, String deliveryboyusername, String deliveryboypassword)
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		ManageDeliveryBoyPage categorypage=new ManageDeliveryBoyPage(driver);
		categorypage.clickOnManageDeliveryBoyTileMoreInfoButton()
		.clickOnNewButton()
		.userCanAbleToEnterNameInTextField(deliveryboyname)
		.userCanAbleToEnterUserNameInTextField(deliveryboyusername)
		.userCanAbleToEnterPasswordInTextField(deliveryboypassword)
		.pageScrollDown()
		.clickOnSaveButton();
		boolean actualSuccessAlertFieldStatus=categorypage.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to enter datas to list delivery Boypage");
	}
}
