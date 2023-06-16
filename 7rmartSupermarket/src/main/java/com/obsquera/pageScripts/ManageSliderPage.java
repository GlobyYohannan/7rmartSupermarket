package com.obsquera.pageScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsquera.utilities.GeneralUtility;
import com.obsquera.utilities.PageUtility;
import com.obsquera.utilities.WaitUtility;

public class ManageSliderPage {

	public WebDriver driver;
	WaitUtility waitutility;
	PageUtility pageutility;
	
	public ManageSliderPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']") WebElement manageSliderInfoButton;
	@FindBy(xpath="//a[contains(@class,'btn btn-rounded btn-danger')][@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath="//input[@id='main_img']") WebElement chooseFileButton;
	@FindBy(xpath="//div[@class='form-group']//child::input[@id='link']") WebElement linkTextField;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]//h5") WebElement successAlertField;
	@FindBy(xpath="//span[contains(@class,'badge bg-success')]") WebElement activeStatusButton;
	public ManageSliderPage clickOnManageSliderPageTileMoreInfoButton()
	{
		manageSliderInfoButton.click();
		return this;
	}
	public ManageSliderPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	
	public ManageSliderPage uploadFile()
	{
		chooseFileButton.sendKeys(GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE );
		return this;
	}
	public ManageSliderPage pageScrollDown()
	{

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		return this;
	}
	
	public ManageSliderPage enterLinkInLinkTextField(String link)
	{
		linkTextField.sendKeys(link);
		return this;
	}
	public ManageSliderPage clickOnSaveButton()
	{   
		saveButton.click();
		return this;
	}
	public boolean checkSuccessAlertIsPresent()
	{   waitutility=new WaitUtility();
		waitutility.waitForElement(driver, successAlertField);
		boolean successAlertFieldStatus= successAlertField.isDisplayed();
		return successAlertFieldStatus;
	}
	public ManageSliderPage clickOnActiveStatusButton()
	{
		waitutility=new WaitUtility();
		waitutility.waitForElement(driver, activeStatusButton);
		activeStatusButton.click();
		return this;
	}
}
