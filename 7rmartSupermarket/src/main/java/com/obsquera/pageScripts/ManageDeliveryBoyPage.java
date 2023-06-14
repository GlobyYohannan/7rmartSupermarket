package com.obsquera.pageScripts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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
	@FindBy(xpath="//a[contains(@class,'btn btn-rounded btn-primary')][@onclick='click_button(2)']") WebElement searchButton;
	@FindBy(xpath="//input[contains(@class,'form-control')][@id='un']") WebElement nameSearchTextField;
	@FindBy(xpath="//button[contains(@class,'btn btn-block-sm btn-danger')]") WebElement searchButtoninsideSearchListDeliveryBoyPagesBand;
	@FindAll({@FindBy(xpath="//table[contains(@class,'table table-bordered table-hover table-sm')]//child::tbody//tr//td")}) List<WebElement> listDeliveryBoyPageTableContents;
	@FindBy(xpath="//table[contains(@class,'table table-bordered table-hover table-sm')]//child::tbody//td//i[contains(@class,'fas fa-edit')]") WebElement editIcon;
	@FindBy(xpath="//button[@name='update']") WebElement updateButton;
	@FindBy(xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]") WebElement failureAlertField;
	@FindBy(xpath="//span[contains(@class,'badge bg-success')]") WebElement activeStatusButton;
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
	public ManageDeliveryBoyPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	public ManageDeliveryBoyPage enterDatatoSearchTextField(String deliveryboyname)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(nameSearchTextField));
		nameSearchTextField.sendKeys(deliveryboyname);
		return this;
	}
	public ManageDeliveryBoyPage clickOnSearchButtoninsideSearchListPagesBand()
	{
		searchButtoninsideSearchListDeliveryBoyPagesBand.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return this;
	}
	public boolean checkWhetherResponseTableContainsCorrespondingEntry(String searchContent)
	{  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for (int i=0;i<listDeliveryBoyPageTableContents.size();i++)
		{   
			String listPageTableDetail=listDeliveryBoyPageTableContents.get(i).getText().trim();
			if(listPageTableDetail.equalsIgnoreCase(searchContent.trim()))
				 return true;		
		}
		return false;
	}
	public ManageDeliveryBoyPage clickOnEditIcon()
	{   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		editIcon.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return this;
	}
	
	public ManageDeliveryBoyPage clearPasswordTextField()
	{
		passwordTextField.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return this;
	}
	public ManageDeliveryBoyPage clickOnUpdateButton()
	{  
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(updateButton));
		updateButton.click();
		return this;
	}
	public boolean checkFailureAlertIsPresent()
	{   
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(failureAlertField));
		boolean failureAlertFieldStatus= failureAlertField.isDisplayed();
		return failureAlertFieldStatus;
	}
	
	public ManageDeliveryBoyPage pageScrollRight()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(2000,0)");
		return this;
	}
	public ManageDeliveryBoyPage clickOnActiveStatusButton()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(activeStatusButton));
		activeStatusButton.click();
		return this;
	}
	
	public String getToolTipMessage()
	{
		String tootTipMessage=nameTextField.getAttribute("title");
		return tootTipMessage;
	}
}
