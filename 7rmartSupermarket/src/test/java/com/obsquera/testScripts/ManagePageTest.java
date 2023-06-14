package com.obsquera.testScripts;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsquera.pageScripts.LoginPage;
import com.obsquera.pageScripts.ManagePage;
import com.obsquera.utilities.ExcelUtility;

public class ManagePageTest extends Base {
	
	@Test(description = "TC1_Verify user is able to add datas to list page")
	@Parameters({"Title","Description","Page"})
	public void userIsAbleToEnterDatasToListPage(String Title,String Description,String Page)
	{   
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		ManagePage managepage=new ManagePage(driver);
		managepage.clickOnManagePageTileMoreInfoButton().clickOnNewButton().enterDataInTitleField(Title).enterDataInDescriptionField(Description).enterDataInPageField(Page).pageScrollDown().clickOnSaveButton()
		.navigateBackToOriginalScreen();
		boolean actualSuccessAlertFieldStatus=managepage.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to enter datas to list page");
	}
	
	
	@Test(description = "TC2_Verify user is able to search pages in list page")
	@Parameters("Title")
	public void checkWhetherUserIsAbleToSearchPagesInManagePages(String Title)
	{   
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		ManagePage managepage=new ManagePage(driver);
		managepage.clickOnManagePageTileMoreInfoButton().clickOnSearchButton().enterDatatoSearchTextField(Title).clickOnSearchButtoninsideSearchListPagesBand();
		boolean searchContentFoundStatus=managepage.checkWhetherResponseTableContainsCorrespondingEntry(Title);
		assertTrue(searchContentFoundStatus,"User is not able to search Title in list pages");
			}
	@Test(description = "TC3_Verify user is able to edit pages in list page")
	@Parameters({"Title","TitleUpdated"})
	public void checkWhetherUserIsAbleToEditPagesInManagePages(String title, String titleUpdated)
	{   
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		ManagePage managepage=new ManagePage(driver);
		managepage.clickOnManagePageTileMoreInfoButton().clickOnSearchButton().enterDatatoSearchTextField(title).clickOnSearchButtoninsideSearchListPagesBand();
		boolean searchContentFoundStatus=managepage.checkWhetherResponseTableContainsCorrespondingEntry(title);
		assertTrue(searchContentFoundStatus,"User is not able to search Title in list pages");
		managepage.clickOnEditIcon().clearAddPageTitleTextField().enterDataInTitleField(titleUpdated).pageScrollDown().clickOnUpdateButton();
		boolean actualSuccessAlertFieldStatus=managepage.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to update datas to list page");
			}	
	@Test(description = "TC4_Verify user is able to delete pages in list page")
	@Parameters("TitleUpdated")
	public void checkwhetherUserCanAbleToDeleteAddedEntryInManagePages(String titleUpdated)
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		ManagePage managepage=new ManagePage(driver);
		managepage.clickOnManagePageTileMoreInfoButton().clickOnSearchButton().enterDatatoSearchTextField(titleUpdated).clickOnSearchButtoninsideSearchListPagesBand();
		boolean searchContentFoundStatus=managepage.checkWhetherResponseTableContainsCorrespondingEntry(titleUpdated);
		assertTrue(searchContentFoundStatus,"User is not able to search Title in list pages");
		managepage.clickOnDeleteIcon().clickOnAlertOkButton();
		boolean actualSuccessAlertFieldStatus=managepage.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to delete datas in list page");
	}
}
