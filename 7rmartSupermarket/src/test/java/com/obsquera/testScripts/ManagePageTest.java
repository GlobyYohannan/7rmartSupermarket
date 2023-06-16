package com.obsquera.testScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsquera.pageScripts.LoginPage;
import com.obsquera.pageScripts.ManagePage;
import com.obsquera.utilities.ExcelUtility;

import retry.Retry;

public class ManagePageTest extends Base {
	LoginPage loginpage;
	ManagePage managepage;
	@Test(priority = 1,description = "TC1_Verify user is able to add datas to list page",retryAnalyzer = Retry.class)
	@Parameters({"Title","Description","Page"})
	public void userIsAbleToEnterDatasToListPage(String Title,String Description,String Page)
	{   
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage")).enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage")).clickOnSignInButton();
		managepage=new ManagePage(driver);
		managepage.clickOnManagePageTileMoreInfoButton().clickOnNewButton().enterDataInTitleField(Title).enterDataInDescriptionField(Description).enterDataInPageField(Page).pageScrollDown().clickOnSaveButton().navigateBackToOriginalScreen();
		boolean actualSuccessAlertFieldStatus=managepage.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to enter datas to list page");
	}
	
	@Test(priority = 2,description = "TC2_Verify user is able to search pages in list page",retryAnalyzer = Retry.class)
	@Parameters("Title")
	public void checkWhetherUserIsAbleToSearchPagesInManagePages(String Title)
	{   
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		managepage=new ManagePage(driver);
		managepage.clickOnManagePageTileMoreInfoButton().clickOnSearchButton().enterDatatoSearchTextField(Title).clickOnSearchButtoninsideSearchListPagesBand();
		boolean searchContentFoundStatus=managepage.checkWhetherResponseTableContainsCorrespondingEntry(Title);
		assertTrue(searchContentFoundStatus,"User is not able to search Title in list pages");
			}
	@Test(priority = 3,description = "TC3_Verify user is able to edit pages in list page",retryAnalyzer = Retry.class)
	@Parameters({"Title","TitleUpdated"})
	public void checkWhetherUserIsAbleToEditPagesInManagePages(String title, String titleUpdated)
	{   
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		managepage=new ManagePage(driver);
		managepage.clickOnManagePageTileMoreInfoButton().clickOnSearchButton().enterDatatoSearchTextField(title).clickOnSearchButtoninsideSearchListPagesBand();
		boolean searchContentFoundStatus=managepage.checkWhetherResponseTableContainsCorrespondingEntry(title);
		assertTrue(searchContentFoundStatus,"User is not able to search Title in list pages");
		managepage.clickOnEditIcon().clearAddPageTitleTextField().enterDataInTitleField(titleUpdated).pageScrollDown().clickOnUpdateButton();
		boolean actualSuccessAlertFieldStatus=managepage.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to update datas to list page");
			}	
	@Test(priority = 4,description = "TC4_Verify user is able to delete pages in list page",retryAnalyzer = Retry.class)
	@Parameters("TitleUpdated")
	public void checkwhetherUserCanAbleToDeleteAddedEntryInManagePages(String titleUpdated)
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		managepage=new ManagePage(driver);
		managepage.clickOnManagePageTileMoreInfoButton().clickOnSearchButton().enterDatatoSearchTextField(titleUpdated).clickOnSearchButtoninsideSearchListPagesBand();
		boolean searchContentFoundStatus=managepage.checkWhetherResponseTableContainsCorrespondingEntry(titleUpdated);
		assertTrue(searchContentFoundStatus,"User is not able to search Title in list pages");
		managepage.clickOnDeleteIcon().clickOnAlertOkButton();
		boolean actualSuccessAlertFieldStatus=managepage.checkSuccessAlertIsPresent();
		assertTrue(actualSuccessAlertFieldStatus,"User is not able to delete datas in list page");
	}
	
	@Test(priority = 5,description = "TC5_Verify that user is getting no result found if search with not existing page in list page",retryAnalyzer = Retry.class)
	@Parameters({"nonexistingsearchcontent"})
	public void checkWhetherUserIsGettingNoResultFoundWhileSearchWithNonExistingPagesInManagePages(String searchContent)
	{   
		loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(ExcelUtility.getString(1, 0, "LoginPage"));
		loginpage.enterPasswordOnPasswordField(ExcelUtility.getString(1, 1, "LoginPage"));
		loginpage.clickOnSignInButton();
		managepage=new ManagePage(driver);
		managepage.clickOnManagePageTileMoreInfoButton().clickOnSearchButton().enterDatatoSearchTextField(searchContent).clickOnSearchButtoninsideSearchListPagesBand();
		boolean searchContentFoundStatus=managepage.checkWhetherResponseTableContainsCorrespondingEntry(searchContent);
		assertTrue(searchContentFoundStatus,"User is not able to search Title in list pages");
			}
}
