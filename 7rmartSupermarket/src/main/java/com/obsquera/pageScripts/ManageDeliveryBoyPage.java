package com.obsquera.pageScripts;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageDeliveryBoyPage {

public WebDriver driver;

	
	public ManageDeliveryBoyPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//div[contains(@class,'small-box bg-info')]//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") WebElement manageDeliveryBoyMoreInfoButton;
	@FindBy(xpath="//a[contains(@class,'btn btn-rounded btn-danger')][@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath="//input[@id='name']") WebElement nameTextField;
	@FindBy(xpath="//input[@id='username']") WebElement userNameTextField;
	@FindBy(xpath="//input[@id='password']") WebElement passwordTextField;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]//h5") WebElement successAlertField;
	public ManageDeliveryBoyPage clickOnManageDeliveryBoyTileMoreInfoButton()
	{
		manageDeliveryBoyMoreInfoButton.click();
		return this;
	}
	public ManageDeliveryBoyPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageDeliveryBoyPage userCanAbleToEnterNameInTextField(String deliveryboyname)
	{
		nameTextField.sendKeys(deliveryboyname);
		return this;
	}
	public ManageDeliveryBoyPage userCanAbleToEnterUserNameInTextField(String deliveryboyusername)
	{
		userNameTextField.sendKeys(deliveryboyusername);
		return this;
	}
	public ManageDeliveryBoyPage userCanAbleToEnterPasswordInTextField(String deliveryboypassword)
	{
		passwordTextField.sendKeys(deliveryboypassword);
		return this;
	}
	public ManageDeliveryBoyPage pageScrollDown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		return this;
	}
	public ManageDeliveryBoyPage clickOnSaveButton()
	{   
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
		return this;
	}
	public boolean checkSuccessAlertIsPresent()
	{   
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(successAlertField));
		boolean successAlertFieldStatus= successAlertField.isDisplayed();
		return successAlertFieldStatus;
	}
}
